package calcmodel;

import java.util.*;


// TODO: 15.03.2016 сделать скобки в скобках, на данный момент он находит первую открывающую скобку блока, но обращается к закрывающей внетреннего блока
public class Calculator {
    LinkedList<Double> ciphers;
    LinkedList<Character> signs;


    /*ввод пользователя разобранный парсером на два листа 1. цифры 2. знаки*/
    public Calculator(LinkedList<Double> ciphers, LinkedList<Character> signs) {
        this.ciphers = ciphers;
        this.signs = signs;
    }

    /*основной метод вызывающий все вычисления*/
    public double calculateExpression() {
        return calculations(0, ciphers, signs);
    }

    /*осуществляет вычисления через сложение согласно приоритету операторов и скобок*/
    private double calculations(int lo, List<Double> ciphers, List<Character> signs) {
        int hi = signs.size() - 1;
        char sign = signs.get(signs.size() - 1);
        char multpl = '*';
        char divide = '/';
        double temp = 0;
        int count =0;

        while (signs.contains('(')) {
            count++;
            boolean parInpar = false;
            int indxParenthOpen = signs.indexOf('(');
            int indxParenthClose = signs.indexOf(')');

            while (indxParenthClose + 1 < signs.size() && signs.get(indxParenthClose + 1) == ')') {
                indxParenthClose += 1;
                count++;
                parInpar = true;
            }
            temp = calcParenthesisPriority(count,indxParenthOpen, indxParenthClose, parInpar,signs,ciphers);
            ciphers.add(indxParenthOpen, temp);
        }
        while (signs.contains(multpl)) {
            calcOperationPriority(multpl,signs,ciphers);
        }
        while (signs.contains(divide)) {
            calcOperationPriority(divide,signs,ciphers);
        }
        if (ciphers.size() == 1) {
            return ciphers.remove(0);
        }
                    /*временно для теста*/ // TODO: 15.03.2016 удалить в конечной версии
        System.out.println("temp = " + temp);
        System.out.println("signs = " + signs);
        System.out.println("ciphers = " + ciphers);

        if (lo == hi) {
            if (sign == '-') {

                double res = ciphers.get(lo) - ciphers.get(lo + 1);
                return res;
            } else {
                double res = ciphers.get(lo) + ciphers.get(lo + 1);
                return res;
            }
        }

        try {
            return ciphers.get(lo) + calculations(lo + 1, ciphers, signs); // рекурсивный вызов
        } catch (Exception e) {
            if (sign == '-') {
                double res = ciphers.get(lo) - ciphers.get(lo + 1);
                return res;
            } else {
                double res = ciphers.get(lo) + ciphers.get(lo + 1);
                return res;
            }
        }
    }

    /*передает выражение в скобках на вычисление и вставляет результат вместо этого выражения*/
    private double calcParenthesisPriority(int count, int lo, int hi, boolean parInpar,List<Character> signs,List<Double> ciphers) {
        int hiForCiphers = hi;
        int loForCiphers = lo;
        if (parInpar) {
            hiForCiphers = hi - (count+1);
            loForCiphers -= 1;
        }
        List<Character> sublistSigns = signs.subList(lo, hi + 1);
        List<Double> sublistCiphers = ciphers.subList(loForCiphers, hiForCiphers);
        sublistSigns.remove(0);
        sublistSigns.remove(sublistSigns.size() - 1);
        double res = calculations(0, sublistCiphers, sublistSigns);
        sublistSigns.removeAll(sublistSigns);
        sublistCiphers.removeAll(sublistCiphers);
        return res;
    }

    /*вычисляет приоритетное выражение умножения или деления и вставляет результат вместо этого выражения*/
    private void calcOperationPriority(char operation,List<Character> signs,List<Double> ciphers) {
        double temp = 0;
        int indx = signs.indexOf(operation);
        signs.remove(indx);
        if (operation == '/') {
            temp = ciphers.get(indx) / ciphers.get(indx + 1);
        } else {
            temp = ciphers.get(indx) * ciphers.get(indx + 1);
        }
        ciphers.set(indx, temp);
        ciphers.remove(indx + 1);
    }

}
