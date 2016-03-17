package calcmodel;

import java.util.*;


// TODO: 15.03.2016 сделать скобки в скобках, на данный момент он находит первую открывающую скобку блока, но обращается к закрывающей внетреннего блока
public class Calculator {
    LinkedList<Double> thisCiphers;
    LinkedList<Character> signs;
    private final int offsetConstant = 2;


    /*ввод пользователя разобранный парсером на два листа 1. цифры 2. знаки*/
    public Calculator(LinkedList<Double> ciphers, LinkedList<Character> signs) {
        this.thisCiphers = ciphers;
        this.signs = signs;
    }

    /*основной метод вызывающий все вычисления*/
    public double calculateExpression() {
        return calculations(0, thisCiphers, signs);
    }

    /*осуществляет вычисления через сложение согласно приоритету операторов и скобок*/
    private double calculations(int lo, List<Double> ciphers, List<Character> signs) {
        int hi = signs.size() - 1;
        char sign = signs.get(signs.size() - 1);
        char multpl = '*';
        char divide = '/';
        double temp = 0;
        int count = 0;

        while (signs.contains('(')) {
            calcParenthesis(ciphers, signs);
        }
        while (signs.contains(multpl)) {
            calcOperationPriority(multpl, signs, ciphers);
        }
        while (signs.contains(divide)) {
            calcOperationPriority(divide, signs, ciphers);
        }
        if (ciphers.size() == 1) {
            return ciphers.remove(0);
        }
                    /*временно для теста*/ // TODO: 15.03.2016 удалить в конечной версии
        System.out.println("temp = " + temp);
        System.out.println("signs = " + signs);
        System.out.println("thisCiphers = " + ciphers);
        if (lo == hi) {
            return operationChooser(lo, ciphers, sign);
        }
        try {
            return ciphers.get(lo) + calculations(lo + 1, ciphers, signs); // рекурсивный вызов
        } catch (Exception e) {
            sign = signs.get(signs.size() - 1);
            return operationChooser(lo, ciphers, sign);
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
        while (sublistSigns.contains('(')) {
            calcParenthesis(sublistCiphers,sublistSigns);
        }
        double res = calculations(0, sublistCiphers, sublistSigns);
        sublistSigns.removeAll(sublistSigns);
        sublistCiphers.removeAll(sublistCiphers);
        return res;
    }


    private int makeOffset(boolean pInP, List<Character> signs) {
        int offset = 0;
        if (pInP) {
            offset=offset- offsetConstant;
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
        double temp = 0;
        int indx = signs.indexOf(operation);
        signs.remove(indx);
        if (operation == '/') {
            if (ciphers.get(indx + 1) == 0) {
                throw new ArithmeticException("Trying divide by Zero");
            }
            temp = ciphers.get(indx) / ciphers.get(indx + 1);
        } else {
            temp = ciphers.get(indx) * ciphers.get(indx + 1);
        }
        ciphers.set(indx, temp);
        ciphers.remove(indx + 1);
    }

    private double operationChooser(int lo, List<Double> ciphers, char sign) {
        if (sign == '-' && ciphers.get(lo + 1) < 0) {
            double res = ciphers.get(lo) + ciphers.get(lo + 1);
            return res;
        }
        if (sign == '+' && ciphers.get(lo) < 0 && ciphers.get(lo + 1) < 0) {
            double res = ciphers.get(lo) + ciphers.get(lo + 1);
            return res;
        }
        if (sign == '-') {
            double res = ciphers.get(lo) - ciphers.get(lo + 1);
            return res;
        } else {
            double res = ciphers.get(lo) + ciphers.get(lo + 1);
            return res;
        }
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

    private void calcParenthesis(List<Double> ciphers, List<Character> signs) {
        double temp;
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

        temp = calcParenthesisPriority(pInp, indxParenthOpen, indxParenthClose, signs, ciphers);
        ciphers.add(indxParenthOpen, temp);

    }
}
