package calcmodel;

import java.util.*;


// TODO: 15.03.2016  проверить все конструкторы, сделать рефакторинг внутренний класс парсинга ввода
public class Calculator {
    LinkedList<Double> thisCiphers;
    LinkedList<Character> signs;
    private final int offsetConstant1 = 2;
    private final int offsetConstant2 = 3;
    private boolean hasNegativeFirstCipher;
    private LinkedList<Integer> minusAfterParenthList;


    /*ввод пользователя разобранный парсером на два листа 1. цифры 2. знаки*/
    public Calculator(LinkedList<Double> ciphers, LinkedList<Character> signs,
                      boolean isNegativeFirstCipher,
                      LinkedList<Integer> minusAfterParenthList ) {
        this.thisCiphers = ciphers;
        this.signs = signs;
        this.hasNegativeFirstCipher = isNegativeFirstCipher;
        this.minusAfterParenthList = minusAfterParenthList;
    }

public Calculator(LinkedList<Double> ciphers, LinkedList<Character> signs,
                      boolean hasNegativeFirstCipher) {
        this.thisCiphers = ciphers;
        this.signs = signs;
        this.hasNegativeFirstCipher = hasNegativeFirstCipher;
        this.minusAfterParenthList = null;
    }

public Calculator(LinkedList<Double> ciphers, LinkedList<Character> signs,
                      LinkedList<Integer> minusAfterParenthList ) {
        this.thisCiphers = ciphers;
        this.signs = signs;
        this.hasNegativeFirstCipher = false;
        this.minusAfterParenthList = minusAfterParenthList;
    }

    public Calculator(LinkedList<Double> ciphers, LinkedList<Character> signs) {
        this.thisCiphers = ciphers;
        this.signs = signs;
        this.hasNegativeFirstCipher = false;
        this.minusAfterParenthList = null;
    }

    /*основной метод вызывающий все вычисления*/
    public double calculateExpression() {
        return calculations(0, thisCiphers, signs);
    }

    /*осуществляет вычисления через сложение согласно приоритету операторов и скобок*/
    private double calculations(int lo, List<Double> ciphers, List<Character> signs) {

       /*если выражение начинается со знака минус*/
        if(hasNegativeFirstCipher){
           double tmp = ciphers.get(0);
            ciphers.set(0,-tmp);
            hasNegativeFirstCipher=false;
        }
        /*если блок скобок начинается с(-35) то делаем эту цифру отрицательной(первая часть сделана парсером)*/
        if(minusAfterParenthList!=null){
            for (Integer indxOfCipher : minusAfterParenthList) {
                double temp = ciphers.get(indxOfCipher);
                ciphers.set(indxOfCipher,-temp);
            }
            minusAfterParenthList=null;
        }

        char multpl = '*';
        char divide = '/';
        double temp = 0;

        while (signs.contains('(')) {
            findParenthesisCloseIndxAndCalculate(ciphers, signs);
        }

        while (signs.contains(multpl)) {
            calcOperationPriority(multpl, signs, ciphers);
        }
        while (signs.contains(divide)) {
            calcOperationPriority(divide, signs, ciphers);
        }

        /*заменяет знаки минус на плюс если нужно*/
        for (Character sgn : signs) {
            int ind = signs.indexOf(sgn);
           /*если следующая после отрицания число тоже отрицательное то ничего не делаем*/
            
            if (sgn == '-') {

                double tmp = ciphers.get(ind + 1);
                ciphers.set(ind + 1, -tmp);
                signs.set(ind, '+');
            }
        }

        if (ciphers.size() == 1) {
            return ciphers.remove(0);
        }

        /*временно для теста*/ // TODO: 15.03.2016 удалить в конечной версии
        System.out.println("temp = " + temp);
        System.out.println("signs = " + signs);
        System.out.println("thisCiphers = " + ciphers);

        try {
            return ciphers.get(lo) + calculations(lo + 1, ciphers, signs); // рекурсивный вызов
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage() + e.getClass());
            double res =  additionOperation(lo, ciphers);
            return res;
        }
    }


    /*передает выражение в скобках на вычисление и вставляет результат вместо этого выражения*/
    private double calcParenthesisPriority(boolean pInP, int lo, int hi, List<Character> signs, List<Double> ciphers) {
        double temp = 0;
        int hiForCiphers = hi;
        int offset = makeOffset(pInP, signs);
        pInP = false;
        List<Character> sublistSigns = signs.subList(lo, hi + 1);
        List<Double> sublistCiphers = ciphers.subList(lo, hi - offset);
        sublistSigns.remove(0);
        sublistSigns.remove(sublistSigns.size() - 1);
        /*если в во взятом блоке есть вложенный блок то погружаемся в него рекурсивно*/
        while (sublistSigns.contains('(')) {
            findParenthesisCloseIndxAndCalculate(sublistCiphers, sublistSigns);
        }
        /*если в блоке вложенных блоков больше нет, то переходим к вычислению*/
        double res = calculations(0, sublistCiphers, sublistSigns);
        sublistSigns.removeAll(sublistSigns);
        sublistCiphers.removeAll(sublistCiphers);
        return res;
    }


    private int makeOffset(boolean pInP, List<Character> signs) {
        int offset = 0;
        if (pInP) {
            offset = offset - offsetConstant1;
            for (Character sign : signs) {
                if (sign == '(' || sign == ')') {
                    offset++;
                }
            }
        }
        return offset;
    }

    /*вычисляет приоритетное выражение умножения или деления и вставляет результат вместо этого выражения*/
    private void calcOperationPriority(char operation, List<Character> signs, List<Double> ciphers) {
        double res = 0;
        int indx = signs.indexOf(operation);
        signs.remove(indx);
        double cipher1 = ciphers.get(indx);
        double cipher2 = ciphers.get(indx+1);
        if(cipher1<0 && cipher2<0){
            double temp = cipher2;
            cipher2=-temp;
        }

        if (operation == '/') {
            if (cipher2 == 0) {
                throw new ArithmeticException("Деление на ноль невозможно");
            }
            res = cipher1 / cipher2;
        } else {
            res = cipher1 * cipher2;
        }
        ciphers.set(indx, res);
        ciphers.remove(indx + 1);
    }

    private double additionOperation(int lo, List<Double> ciphers) {

        double res = ciphers.get(lo) + ciphers.get(lo + 1);
        return res;
    }

    private int findIndxParenthClose(List<Character> signs, int indxParenthClose, int countParenth) {
        int increaseStep = 1;
        int countStep = 1;
        int firstParClose = indxParenthClose;

        while (countStep <= countParenth) {
            if (signs.get(firstParClose + increaseStep) == ')') {
                countStep++;

            }
            indxParenthClose++;
            increaseStep++;
        }
        return indxParenthClose;
    }

    private void findParenthesisCloseIndxAndCalculate(List<Double> ciphers, List<Character> signs) {
        double res;
        boolean pInp = false;
        int indxParenthOpen = signs.indexOf('(');
        int indxOfFirstParenthClose = signs.indexOf(')');
        int numOfParenthBlocks = 0;

            /*считает кол-во скобок внутренних блоков*/
        int i = 1;
        while (signs.get(indxParenthOpen + i) != ')') {
            if (signs.get(indxParenthOpen + i) == '(') {
                numOfParenthBlocks++;
            }
            i++;
        }
            /*переводит в true  если имеются внутренние блоки*/
        if (numOfParenthBlocks > 0) {
            pInp = true;
        }
        int indxParenthClose = findIndxParenthClose(signs, indxOfFirstParenthClose, numOfParenthBlocks);
      int dim = offsetConstant2+numOfParenthBlocks;

        res = calcParenthesisPriority(pInp, indxParenthOpen, indxParenthClose, signs, ciphers);
        ciphers.add(indxParenthOpen, res);

    }
}
