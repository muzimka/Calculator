import calcmodel.Calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by MainW8 on 15.03.2016.
 */
public class CalcTest {


    public static void main(String[] args) {

        Stack<Double> ciphers = new Stack<Double>();
        ciphers.addAll(Arrays.asList(5., 2., 3., 4.));
        Stack<Character> signs = new Stack<Character>();
        signs.addAll(Arrays.asList('+', '*', '(', '+',')'));

        Calculator clc = new Calculator(ciphers,signs);
        double x = clc.calculateExpression(0);
        BigDecimal bd = new BigDecimal(x,MathContext.DECIMAL32);
        BigDecimal res = bd.setScale(4, RoundingMode.UP);
        System.out.println(res);

    }



}
