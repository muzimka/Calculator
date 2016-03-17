import calcmodel.Calculator;

import static org.junit.Assert.*;

import calcmodel.UserInputParser;
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
    UserInputParser mInputParser1;
    UserInputParser mInputParser2;
    UserInputParser mInputParser3;
    UserInputParser mInputParser4;
    UserInputParser mInputParser5;
    UserInputParser mInputParser6;
    UserInputParser mInputParser7;
    UserInputParser mInputParser8;
    UserInputParser mInputParser9;
    UserInputParser mInputParser10;
    UserInputParser mInputParser11;
    UserInputParser mInputParser12;
    UserInputParser mInputParser13;
    UserInputParser mInputParser14;
    UserInputParser mInputParser15;
    UserInputParser mInputParser16;
    UserInputParser mInputParser17;
    UserInputParser mInputParser18;
    UserInputParser mInputParser19;
    UserInputParser mInputParser20;
    UserInputParser mInputParser21;
    UserInputParser mInputParser22;
    UserInputParser mInputParser23;
    UserInputParser mInputParser24;
    UserInputParser mInputParser25;
    Calculator clc1;
    Calculator clc2;
    Calculator clc3;
    Calculator clc4;
    Calculator clc5;
    Calculator clc6;
    Calculator clc7;
    Calculator clc8;
    Calculator clc9;
    Calculator clc10;
    Calculator clc11;
    Calculator clc12;
    Calculator clc13;
    Calculator clc14;
    Calculator clc15;
    Calculator clc16;
    Calculator clc17;
    Calculator clc18;
    Calculator clc19;
    Calculator clc20;
    Calculator clc21;
    Calculator clc22;
    Calculator clc23;
    Calculator clc24;
    Calculator clc25;
    String exp = "2+3*(2+2)-3*(2+1)";//5
    String exp1 = "2/2";
    String exp2 = "5+2*(3-2)"; //=7
    String exp3 = "2+(12-9)"; //=5
    String exp4 = "2*(3+2*(2+2))"; //=22
    String exp5 = "5+2*(3+2*(3+2))"; //=31
    String exp6 = "5+2*(3+2*(3-2))"; //=15
    String exp7 = "5+2*(3-2*(3+2))"; //=-9
    String exp8 = "3+2*(4+2*(3+3*(2+2)))"; //=71
    String exp9 = "3+2*(4+2*(3+3*(2+2)))+3"; //=74
    String exp10 = "2*(4+2)+3"; //=15
    String exp11 = "(4+2)*2+3"; //=15
    String exp12 = "(4+2)*2-3"; //=9
    String exp13 = "3+(4+2)*2"; //=15
    String exp14 = "3-(4+2)*2"; //=-9
    String exp15 = "3+2*(6+8*(7+2))"; //= 159
    String exp16 = "6*+11"; //=exception
    String exp17 = "6**11"; //=66
    String exp18 = "-+111"; //=exception
    String exp19 = "5/0"; //=exception
    String exp20 = "3+2*(6+8*(7+2))/0"; //=exception
    String exp21 = "4   +      8   *    7"; //=60
    String exp22 = "2+2*(3+3*(2-3*(2-3*(2+2*(1+1)))))"; //-268
    String exp23 = "5+2*(3+1-2*(3+2))"; // -7
    String exp24 = "5+2*(3+1-2*(3+2))+2"; // -5

    @Before
    public void init() {
        /*init clc1*/
        mInputParser1 = new UserInputParser(exp);
        clc1 = new Calculator(mInputParser1.getCiphersList(), mInputParser1.getSignsList());

/*init clc2*/
        mInputParser2 = new UserInputParser(exp1);
        clc2 = new Calculator(mInputParser2.getCiphersList(), mInputParser2.getSignsList());

/*init clc3*/
        mInputParser3 = new UserInputParser(exp2);
        clc3 = new Calculator(mInputParser3.getCiphersList(), mInputParser3.getSignsList());

/*init clc4*/
        mInputParser4 = new UserInputParser(exp3);
        clc4 = new Calculator(mInputParser4.getCiphersList(), mInputParser4.getSignsList());

/*init clc5*/
        mInputParser5 = new UserInputParser(exp4);
        clc5 = new Calculator(mInputParser5.getCiphersList(), mInputParser5.getSignsList());

/*init clc6*/
        mInputParser6 = new UserInputParser(exp5);
        clc6 = new Calculator(mInputParser6.getCiphersList(), mInputParser6.getSignsList());

/*init clc7*/
        mInputParser7 = new UserInputParser(exp6);
        clc7 = new Calculator(mInputParser7.getCiphersList(), mInputParser7.getSignsList());

/*init clc8*/
        mInputParser8 = new UserInputParser(exp7);
        clc8 = new Calculator(mInputParser8.getCiphersList(), mInputParser8.getSignsList());

/*init clc9*/
        mInputParser9 = new UserInputParser(exp8);
        clc9 = new Calculator(mInputParser9.getCiphersList(), mInputParser9.getSignsList());

/*init clc10*/
        mInputParser10 = new UserInputParser(exp9);
        clc10 = new Calculator(mInputParser10.getCiphersList(), mInputParser10.getSignsList());

/*init clc11*/
        mInputParser11 = new UserInputParser(exp10);
        clc11 = new Calculator(mInputParser11.getCiphersList(), mInputParser11.getSignsList());

/*init clc12*/
        mInputParser12 = new UserInputParser(exp11);
        clc12 = new Calculator(mInputParser12.getCiphersList(), mInputParser12.getSignsList());

/*init clc13*/
        mInputParser13 = new UserInputParser(exp12);
        clc13 = new Calculator(mInputParser13.getCiphersList(), mInputParser13.getSignsList());

/*init clc14*/
        mInputParser14 = new UserInputParser(exp13);
        clc14 = new Calculator(mInputParser14.getCiphersList(), mInputParser14.getSignsList());

/*init clc15*/
        mInputParser15 = new UserInputParser(exp14);
        clc15 = new Calculator(mInputParser15.getCiphersList(), mInputParser15.getSignsList());

/*init clc16*/
        mInputParser16 = new UserInputParser(exp15);
        clc16 = new Calculator(mInputParser16.getCiphersList(), mInputParser16.getSignsList());

/*init clc17 should be initialized in test method below*/


/*init clc18*/
        mInputParser18 = new UserInputParser(exp17);
        clc18 = new Calculator(mInputParser18.getCiphersList(), mInputParser18.getSignsList());

        /*init clc19 should be initialized in test method below*/

       /*init clc20*/
        mInputParser20 = new UserInputParser(exp19);
        clc20 = new Calculator(mInputParser20.getCiphersList(), mInputParser20.getSignsList());

       /*init clc21*/
        mInputParser21 = new UserInputParser(exp20);
        clc21 = new Calculator(mInputParser21.getCiphersList(), mInputParser21.getSignsList());

/*init clc22*/
        mInputParser22 = new UserInputParser(exp21);
        clc22 = new Calculator(mInputParser22.getCiphersList(), mInputParser22.getSignsList());

/*init clc23*/
        mInputParser23 = new UserInputParser(exp22);
        clc23 = new Calculator(mInputParser23.getCiphersList(), mInputParser23.getSignsList());

/*init clc24*/
        mInputParser24 = new UserInputParser(exp23);
        clc24 = new Calculator(mInputParser24.getCiphersList(), mInputParser24.getSignsList());

/*init clc25*/
        mInputParser25 = new UserInputParser(exp24);
        clc25= new Calculator(mInputParser25.getCiphersList(), mInputParser25.getSignsList());
    }


    @Test
    public void testCalculateExpression() {
        /*test clc1*/
        double x = clc1.calculateExpression();
        BigDecimal bd = new BigDecimal(x, MathContext.DECIMAL32);
        BigDecimal res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc1", BigDecimal.valueOf(5.000), res);

        /*test clc2*/
        x = clc2.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        System.out.println("res = " + res);
        assertEquals("clc2", BigDecimal.valueOf(1.0), res);

        /*test clc3*/
        System.out.println("\n5+2*(3+2*(3+2))");
        x = clc3.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc3", BigDecimal.valueOf(7.0), res);

        /*test clc4*/
        x = clc4.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc4", BigDecimal.valueOf(5.0), res);

        /*test clc5*/
        x = clc5.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc5", BigDecimal.valueOf(22.0), res);

         /*test clc6*/
        x = clc6.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc6", BigDecimal.valueOf(31.0), res);

        /*test clc7*/
        x = clc7.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc7", BigDecimal.valueOf(15.0), res);

        /*test clc8*/
        x = clc8.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc8", BigDecimal.valueOf(-9.0), res);

        /*test clc9*/
        x = clc9.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc9", BigDecimal.valueOf(71.0), res);

/*test clc10*/
        x = clc10.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc10", BigDecimal.valueOf(74.0), res);

/*test clc11*/
        x = clc11.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc11", BigDecimal.valueOf(15.0), res);

/*test clc12*/
        x = clc12.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc12", BigDecimal.valueOf(15.0), res);

/*test clc13*/
        x = clc13.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc13", BigDecimal.valueOf(9.0), res);

/*test clc14*/
        x = clc14.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc14", BigDecimal.valueOf(15.0), res);

/*test clc15*/
        x = clc15.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc15", BigDecimal.valueOf(-9.0), res);

/*test clc16*/
        x = clc16.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc16", BigDecimal.valueOf(159.0), res);

/*test clc17*/

        try {
            new UserInputParser(exp16);
            fail("clc17 6*+11 didn't throw exception");
        } catch (Exception e) { }


/*test clc18*/
        x = clc18.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc18", BigDecimal.valueOf(66.0), res);

/*test clc19*/
        try {
            new UserInputParser(exp18);
            fail("clc19 -+111 didn't throw exception");
        } catch (Exception e) { }

/*test clc20*/
        try {
            x = clc20.calculateExpression();
            fail("clc20 5/0 didn't throw exception");
        } catch (Exception e) { }


    /*test clc21*/
        try {
            x = clc21.calculateExpression();
            fail("clc20 divide by zero expr20 didn't throw exception");
        } catch (Exception e) { }

 /*test clc22*/
        x = clc22.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc22", BigDecimal.valueOf(60.0), res);

 /*test clc23*/
        x = clc23.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc23", BigDecimal.valueOf(-268.0), res);

 /*test clc24*/
        x = clc24.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc24", BigDecimal.valueOf(-7.0), res);

 /*test clc25*/
        x = clc25.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc25", BigDecimal.valueOf(-5.0), res);
    }
}
