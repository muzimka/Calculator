import calcmodel.Calculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by MainW8 on 15.03.2016.
 */
public class CalcTestJunit {
    LinkedList<Double> ciphers1;
    LinkedList<Double> ciphers2;
    LinkedList<Double> ciphers3;
    LinkedList<Double> ciphers4;
    LinkedList<Double> ciphers5;
    LinkedList<Double> ciphers6;
    LinkedList<Character> signs1;
    LinkedList<Character> signs2;
    LinkedList<Character> signs3;
    LinkedList<Character> signs4;
    LinkedList<Character> signs5;
    LinkedList<Character> signs6;
    Calculator clc1;
    Calculator clc2;
    Calculator clc3;
    Calculator clc4;
    Calculator clc5;
    Calculator clc6;

    @Before
    public void init() {
        /*init clc1*/
        ciphers1 = new LinkedList<Double>();
        ciphers1.addAll(Arrays.asList(5., 3., 2., 3., 3.));
        LinkedList<Character> signs1 = new LinkedList<Character>();
        signs1.addAll(Arrays.asList('/', '+', '*', '+'));
        clc1 = new Calculator(ciphers1, signs1);

        /*init clc2*/
        ciphers2 = new LinkedList<Double>();
        signs2 = new LinkedList<Character>();
        /*5+2*(3-2) = 7*/
        ciphers2.addAll(Arrays.asList(5., 2., 3., 2.));
        signs2.addAll(Arrays.asList('+', '*', '(', '-', ')'));
        clc2 = new Calculator(ciphers2, signs2);

        /*init clc3*/

        ciphers3 = new LinkedList<Double>();
        signs3 = new LinkedList<Character>();
        /*5+2*(3+2*(3+2))=31*/
        ciphers3.addAll(Arrays.asList(5., 2., 3., 2., 3., 2.));
        signs3.addAll(Arrays.asList('+', '*', '(', '+', '*', '(', '+', ')', ')'));
        clc3 = new Calculator(ciphers3, signs3);


        /*init clc4*/
        ciphers4 = new LinkedList<Double>();
        signs4 = new LinkedList<Character>();
        /*2+3*(2+2)-3*(2+1)=5*/
        ciphers4.addAll(Arrays.asList(2., 3., 2., 2., 3., 2., 1.));
        signs4.addAll(Arrays.asList('+', '*', '(', '+', ')', '-', '*', '(', '+', ')'));
        clc4 = new Calculator(ciphers4, signs4);

         /*init clc5*/
        ciphers5 = new LinkedList<Double>();
        signs5 = new LinkedList<Character>();
        /*5+2*(3-2*(3+2))=-9*/
        ciphers5.addAll(Arrays.asList(5., 2., 3., 2., 3., 2.));
        signs5.addAll(Arrays.asList('+', '*', '(', '-', '*', '(', '+', ')', ')'));
        clc5 = new Calculator(ciphers5, signs5);

        /*init clc6*/
        ciphers6 = new LinkedList<Double>();
        signs6 = new LinkedList<Character>();
        /*3+2*(4+2*(3+3*(2+2)))+3=74*/
        ciphers6.addAll(Arrays.asList(3., 2., 4., 2., 3., 3.,2.,2.,3.));
        signs6.addAll(Arrays.asList('+', '*','(' ,'+','*','(','+','*','(','+',')',')',')'));
        clc6 = new Calculator(ciphers6, signs6);

    }


    @Test
    public void testCalculateExpression() {
        /*test clc1*/
        double x = clc1.calculateExpression();
        BigDecimal bd = new BigDecimal(x, MathContext.DECIMAL32);
        BigDecimal res = bd.setScale(4, RoundingMode.UP);
        assertEquals("clc1", BigDecimal.valueOf(10.6667), res);

        /*test clc2*/
        x = clc2.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        System.out.println("res = " + res);
        assertEquals("clc2", BigDecimal.valueOf(7.0), res);


        /*test clc3*/
        System.out.println("\n5+2*(3+2*(3+2))");
        x = clc3.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc3", BigDecimal.valueOf(31.000), res);

        /*test clc4*/
        x = clc4.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc4", BigDecimal.valueOf(5.0), res);

        /*test clc5*/
        x = clc5.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc5", BigDecimal.valueOf(-9.0), res);

         /*test clc6*/
        x = clc6.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc6", BigDecimal.valueOf(74.0), res);

    }


}
