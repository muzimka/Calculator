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
    LinkedList<Character> signs1;
    LinkedList<Character> signs2;
    LinkedList<Character> signs3;
    Calculator clc1;
    Calculator clc2;
    Calculator clc3;

    @Before
            public void init(){
        /*init clc1*/
        ciphers1 = new LinkedList<Double>();
        ciphers1.addAll(Arrays.asList(5., 3., 2., 3., 3.));
        LinkedList<Character> signs1 = new LinkedList<Character>();
        signs1.addAll(Arrays.asList('/', '+', '*', '+'));
        clc1 = new Calculator(ciphers1,signs1);

        /*init clc2*/
        ciphers2 = new LinkedList<Double>();
        signs2 = new LinkedList<Character>();
        /*5+2*(3-2) = 7*/
        ciphers2.addAll(Arrays.asList(5.,2.,3.,2.));
        signs2.addAll(Arrays.asList( '+','*','(','-',')'));
        clc2 = new Calculator(ciphers2,signs2);

        /*init clc3*/
        ciphers3 = new LinkedList<Double>();
        signs3 = new LinkedList<Character>();
        /*5+2*(3+2*(3+2))=31*/
        ciphers3.addAll(Arrays.asList(5.,2.,3.,2.,3.,2.));
        signs3.addAll(Arrays.asList( '+','*','(','+','*','(','+',')',')'));
        clc3 = new Calculator(ciphers3,signs3);



    }


    @Test
            public void testCalculateExpression(){
        /*test clc1*/
        double x = clc1.calculateExpression();
        BigDecimal bd = new BigDecimal(x, MathContext.DECIMAL32);
        BigDecimal res = bd.setScale(4, RoundingMode.UP);
        assertEquals(res,BigDecimal.valueOf(10.6667));

        /*test clc2*/
         x = clc2.calculateExpression();
         bd = new BigDecimal(x, MathContext.DECIMAL32);
         res = bd.setScale(1, RoundingMode.UP);
        assertEquals(res,BigDecimal.valueOf(7.000));


        /*test clc3*/
       /* x = clc3.calculateExpression(0);
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals(res,BigDecimal.valueOf(31.000));*/

    }







}
