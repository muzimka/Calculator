import calcmodel.Calculator;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by MainW8 on 15.03.2016.
 */
public class CalcTestJunit {
    Stack<Double> ciphers;
    Stack<Character> signs1;
    Calculator clc1;

    @Before
            public void init(){
        ciphers = new Stack<Double>();
        ciphers.addAll(Arrays.asList(5., 3., 2., 3., 3.));
        Stack<Character> signs = new Stack<Character>();
        signs.addAll(Arrays.asList('/', '+', '*', '+'));
        clc1 = new Calculator(ciphers,signs);
    }


    @Test
            public void testCalculateExpression(){
        double x = clc1.calculateExpression(0);
        BigDecimal bd = new BigDecimal(x, MathContext.DECIMAL32);
        BigDecimal res = bd.setScale(4, RoundingMode.UP);
        assertEquals(res,BigDecimal.valueOf(10.6667));

    }





}
