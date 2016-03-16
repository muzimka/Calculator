package calculator.model;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;


// TODO: 15.03.2016 сделать скобки в скобках, на данный момент он находит первую открывающую скобку блока, но обращается к закрывающей внетреннего блока
@Component
public class Calculator {
    LinkedList<Double> ciphers;
    LinkedList<Character> signs;


    public Calculator() {
    }

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
        if (signs.contains('(')) {
            int indxParenthOpen = signs.indexOf('(');
            int indxParenthClose = signs.indexOf(')');

            temp = calcParenthesisPriority(indxParenthOpen, indxParenthClose);
            ciphers.add(indxParenthOpen, temp);
            /*временно для теста*/ // TODO: 15.03.2016 удалить в конечной версии
            System.out.println("temp = " + temp);
            System.out.println("signs = " + signs);
            System.out.println("ciphers = " + ciphers);
        }
        if (signs.contains(multpl)) {
            calcOperationPriority(multpl);
        }
        if (signs.contains(divide)) {
            calcOperationPriority(divide);
        }

        if(ciphers.size()==1){
            return ciphers.remove(0);
        }
        if (lo == hi) {
            if (sign == '-') {
                changeCipherToNegative(lo, ciphers);
            }
            double res = ciphers.get(lo) + ciphers.get(lo + 1);
            return res;
        }

        try {
            return ciphers.get(lo) + calculations(lo + 1, ciphers, signs); // рекурсивный вызов
        } catch (Exception e) {
            if (sign == '-') {
                changeCipherToNegative(lo, ciphers);
            }
            return ciphers.get(lo) + ciphers.get(lo + 1);
        }
    }

    /*передает выражение в скобках на вычисление и вставляет результат вместо этого выражения*/
    private double calcParenthesisPriority(int lo, int hi) {
        List<Character> sublistSigns = signs.subList(lo, hi + 1);
        List<Double> sublistCiphers = ciphers.subList(lo, hi);
        sublistSigns.remove(0);
        sublistSigns.remove(sublistSigns.size() - 1);
        double res = calculations(0, sublistCiphers, sublistSigns);
        sublistSigns.removeAll(sublistSigns);
        sublistCiphers.removeAll(sublistCiphers);
        return res;
    }

    /*вычисляет приоритетное выражение умножения или деления и вставляет результат вместо этого выражения*/
    private void calcOperationPriority(char operation) {
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

    /*меняет положительный знак цифры на отрицательный*/
    private void changeCipherToNegative(int lo, List<Double> ciphers) {
        double x = -ciphers.get(lo);
        ciphers.set(lo, x);
    }
}
