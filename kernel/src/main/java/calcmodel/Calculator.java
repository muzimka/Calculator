package calcmodel;

import java.util.*;

/**
 * C      ciphers.addAll(Arrays.asList(5., 2., 3., 4.));
 * signs.addAll(Arrays.asList('+', '*', '(', '-',')'));
 */
// TODO: 15.03.2016 сделать скобки в скобках, на данный момент он находит первую открывающую скобку блока, но обращается к закрывающей внетреннего блока
public class Calculator {
    LinkedList<Double> ciphers;
    LinkedList<Double> tempSubstrCiphers;
    LinkedList<Character> signs;
    LinkedList<Character> tempSubstrSigns;

    public Calculator(LinkedList<Double> ciphers, LinkedList<Character> signs) {
        this.ciphers = ciphers;
        this.signs = signs;
    }

    public double calculateExpression(int lo) {
        return calculations(lo, ciphers, signs);
    }


    private double calculations(int lo, List<Double> ciphers, List<Character> signs) {
        int hi = signs.size() - 1;
        char sign = signs.get(signs.size() - 1);
        char multpl = '*';
        char divide = '/';
        double temp = 0;

        if (signs.contains('(')) {
            int indxParenthOpen = signs.indexOf('(');
            int indxParenthClose = signs.indexOf(')');

            temp = parenthesisPriority(indxParenthOpen, indxParenthClose);
            ciphers.add(indxParenthOpen, temp);
            System.out.println("temp = " + temp);
            System.out.println("signs = " + signs);
            System.out.println("ciphers = " + ciphers);
        }

        if (signs.contains(multpl)) {
            performPriorityOperation(multpl);
        }
        if (signs.contains(divide)) {
            performPriorityOperation(divide);
        }
        if (lo == hi) {
            if (sign == '-') {
                double x = -ciphers.get(lo + 1);
                ciphers.set(lo + 1, x);
            }
            double res = ciphers.get(lo) + ciphers.get(lo + 1);
            return res;
        }

        try {
            return ciphers.get(lo) + calculations(lo + 1, ciphers, signs);
        } catch (Exception e) {
            if (sign == '-') {
                double x = -ciphers.get(lo + 1);
                ciphers.set(lo + 1, x);
            }
            return ciphers.get(lo) + ciphers.get(lo + 1);
        }
    }

    private double parenthesisPriority(int lo, int hi) {
        List<Character> sublistSigns = signs.subList(lo, hi + 1);
        List<Double> sublistCiphers = ciphers.subList(lo, hi);
        sublistSigns.remove(0);
        sublistSigns.remove(sublistSigns.size() - 1);
        double res = calculations(0, sublistCiphers, sublistSigns);
        sublistSigns.removeAll(sublistSigns);
        sublistCiphers.removeAll(sublistCiphers);
        return res;
    }


    private void performPriorityOperation(char multpl) {
        double temp = 0;
        int indx = signs.indexOf(multpl);
        signs.remove(indx);
        if (multpl == '/') {
            temp = ciphers.get(indx) / ciphers.get(indx + 1);
        } else {
            temp = ciphers.get(indx) * ciphers.get(indx + 1);
        }
        ciphers.set(indx, temp);
        ciphers.remove(indx + 1);
    }

}
