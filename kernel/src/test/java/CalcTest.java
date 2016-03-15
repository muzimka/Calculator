import calcmodel.Calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;

/**
 * Created by MainW8 on 15.03.2016.
 */
public class CalcTest {


    public static void main(String[] args) {

        LinkedList<Double> ciphers = new LinkedList<Double>();
        LinkedList<Character> signs = new LinkedList<Character>();
        ciphers.addAll(Arrays.asList(5., 2.,       3., 4.,2.));
        signs.addAll(Arrays.asList(   '+', '*', '(', '+','-',')'));
        //signs.addAll(Arrays.asList(   '+', '*', '+'));

        Calculator clc = new Calculator(ciphers,signs);

        double x = 0;
        try {
            x = clc.calculateExpression(0);
        } catch (Exception e) {

        }

        BigDecimal bd = new BigDecimal(x,MathContext.DECIMAL32);
        BigDecimal res = bd.setScale(4, RoundingMode.UP);
        System.out.println(res);

    }



}
