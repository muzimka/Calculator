package calcmodel;

import java.util.*;

/**
 * C      ciphers.addAll(Arrays.asList(5., 2., 3., 4.));
 * signs.addAll(Arrays.asList('+', '*', '(', '+',')'));
 */
public class Calculator {
    LinkedList<Double> ciphers;
    LinkedList<Character> signs;

    public Calculator(LinkedList<Double> ciphers, LinkedList<Character> signs) {
        this.ciphers = ciphers;
        this.signs = signs;
    }

    public double calculateExpression(int lo) {
        return calculateExpression(lo, ciphers, signs);
    }


    private double calculateExpression(int lo, List<Double> ciphers, List<Character> signs) {
        int hi = signs.size() - 1;
        char sign = signs.get(signs.size() - 1);
        char multpl = '*';
        char divide = '/';
        double temp = 0;

        if (signs.contains('(')) {
            int indxParenthOpen = signs.indexOf('(');
            int indxParenthClose = signs.indexOf(')');
            temp = parenthesisPriority(indxParenthOpen,indxParenthClose);
            ciphers.add(indxParenthOpen,temp);
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
            return ciphers.get(lo) + ciphers.get(lo + 1);
        }

        return ciphers.get(lo) + calculateExpression(lo + 1, ciphers, signs);
    }

    private double parenthesisPriority(int lo, int hi) {
        List<Character> sublistSigns = signs.subList(lo, hi + 1);
        List<Double> sublistCiphers = ciphers.subList(lo, hi);
        sublistSigns.remove(0);
        sublistSigns.remove(sublistSigns.size() - 1);
        double res = calculateExpression(0, sublistCiphers, sublistSigns);
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
