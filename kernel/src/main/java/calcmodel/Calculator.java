package calcmodel;

import java.util.List;
import java.util.Stack;

/**
 * C      ciphers.addAll(Arrays.asList(5., 2., 3., 4.));
         signs.addAll(Arrays.asList('+', '*', '(', '+',')'));
 */
public class Calculator {
    Stack<Double> ciphers;
    Stack<Character> signs;

    public Calculator(Stack<Double> ciphers, Stack<Character> signs) {
        this.ciphers = ciphers;
        this.signs = signs;
    }

    public double calculateExpression(int lo) {
        char multpl = '*';
        char divide = '/';
        if (signs.contains(multpl)) {
            performPriorityOperation(multpl);
        }
        if (signs.contains(divide)) {
            performPriorityOperation(divide);
        }
        int hi = signs.size() - 1;
        char sign = signs.get(signs.size() - 1);
        if (lo == hi) {
            if (sign == '-') {
                double x = -ciphers.get(lo + 1);
                ciphers.set(lo + 1, x);
            }
            return ciphers.get(lo) + ciphers.get(lo + 1);
        }
        return ciphers.get(lo) + calculateExpression(lo + 1);
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
