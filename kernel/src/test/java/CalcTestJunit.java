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
    UserInputParser mInputParser26;
    UserInputParser mInputParser27;
    UserInputParser mInputParser28;
    UserInputParser mInputParser29;
    UserInputParser mInputParser30;
    UserInputParser mInputParser31;
    UserInputParser mInputParser32;
    UserInputParser mInputParser33;
    UserInputParser mInputParser34;
    UserInputParser mInputParser35;
    UserInputParser mInputParser36;
    UserInputParser mInputParser37;
    UserInputParser mInputParser38;
    UserInputParser mInputParser39;
    UserInputParser mInputParser40;
    UserInputParser mInputParser41;
    UserInputParser mInputParser42;
    UserInputParser mInputParser43;
    UserInputParser mInputParser44;
    UserInputParser mInputParser45;
    UserInputParser mInputParser46;
    UserInputParser mInputParser47;
    UserInputParser mInputParser48;
    UserInputParser mInputParser49;
    UserInputParser mInputParser50;
    UserInputParser mInputParser51;

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
    Calculator clc26;
    Calculator clc27;
    Calculator clc28;
    Calculator clc29;
    Calculator clc30;
    Calculator clc31;
    Calculator clc32;
    Calculator clc33;
    Calculator clc34;
    Calculator clc35;
    Calculator clc36;
    Calculator clc37;
    Calculator clc38;
    Calculator clc39;
    Calculator clc40;
    Calculator clc41;
    Calculator clc42;
    Calculator clc43;
    Calculator clc44;
    Calculator clc45;
    Calculator clc46;
    Calculator clc47;
    Calculator clc48;
    Calculator clc49;
    Calculator clc50;
    Calculator clc51;
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
    String exp25 ="2*(3+2*(2+2)+2)";//26
    String exp26 ="2*(3+2*(2+2)+2+3+4)";//40
    String exp27 ="10-(77/7+3*9-28)";//0
    String exp28 ="132*(64/8-3*2*(3+2)+2)";// - 2640
    String exp29 ="2*(2/2-3*2*(3+2*(3+2))+2)";//-150
    String exp30 ="1-78+2";// - 75
    String exp31 ="(1-78+2)";// - 75
    String exp32 ="2-1-78+2";//-75
    String exp33 ="-2-1-78+2";//-79
    String exp34 ="-2-1+78+2";//77
    String exp35 ="2-1-(-78)+2";//81
    String exp36 ="-2-1-(-78)+2";//77
    String exp37 ="-2-1+(-78)+2";//-79
    String exp38 ="2-1+(-78)";//-77
    String exp39 ="(-78)-2-1";//-81
    String exp40 ="(78)-2-1";//75
    String exp41 ="(+78)-2-1";//75
    String exp42 ="-2-(+78)-1";//-81
    String exp43 ="78-2-1";//75
    String exp44 ="78+321-(64-((-35)+98))*4";// 395
    String exp45 ="78+321-(64-(98-35))*4";//395
    String exp46 ="78+321-(64-((-35)+98))";// 398
    String exp47 ="-2+(-2)+(2-3)";// -5
    String exp48 ="((-5)+(-6))";// -11
    String exp49 ="2-((-5)-6)";// 13
    String exp50 ="2+((-5)-6)";//-9




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


/*init clc18 should be initialized in test method below*/


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
        clc25 = new Calculator(mInputParser25.getCiphersList(), mInputParser25.getSignsList());


/*init clc26*/
        mInputParser26 = new UserInputParser(exp25);
        clc26 = new Calculator(mInputParser26.getCiphersList(), mInputParser26.getSignsList());


/*init clc27*/
        mInputParser27 = new UserInputParser(exp26);
        clc27 = new Calculator(mInputParser27.getCiphersList(), mInputParser27.getSignsList());


/*init clc28*/
        mInputParser28 = new UserInputParser(exp27);
        clc28 = new Calculator(mInputParser28.getCiphersList(), mInputParser28.getSignsList());


/*init clc29*/
        mInputParser29 = new UserInputParser(exp28);
        clc29 = new Calculator(mInputParser29.getCiphersList(), mInputParser29.getSignsList());


/*init clc30*/
        mInputParser30 = new UserInputParser(exp29);
        clc30 = new Calculator(mInputParser30.getCiphersList(), mInputParser30.getSignsList());

/*init clc31*/
        mInputParser31 = new UserInputParser(exp30);
        clc31 = new Calculator(mInputParser31.getCiphersList(), mInputParser31.getSignsList());

/*init clc32*/
        mInputParser32 = new UserInputParser(exp31);
        clc32 = new Calculator(mInputParser32.getCiphersList(), mInputParser32.getSignsList());

/*init clc33*/
        mInputParser33 = new UserInputParser(exp32);
        clc33 = new Calculator(mInputParser33.getCiphersList(), mInputParser33.getSignsList());

/*init clc34*/
        mInputParser34 = new UserInputParser(exp33);
        clc34 = new Calculator(mInputParser34.getCiphersList(), mInputParser34.getSignsList(),mInputParser34.isHasFirstNegativeCipher());

/*init clc35*/
        mInputParser35 = new UserInputParser(exp34);
        clc35 = new Calculator(mInputParser35.getCiphersList(), mInputParser35.getSignsList(),mInputParser35.isHasFirstNegativeCipher());

/*init clc36*/
        mInputParser36 = new UserInputParser(exp35);
        clc36 = new Calculator(mInputParser36.getCiphersList(), mInputParser36.getSignsList(),mInputParser36.isHasFirstNegativeCipher());

/*init clc37*/
        mInputParser37 = new UserInputParser(exp36);
        clc37 = new Calculator(mInputParser37.getCiphersList(), mInputParser37.getSignsList(),mInputParser37.isHasFirstNegativeCipher());

/*init clc38*/
        mInputParser38 = new UserInputParser(exp37);
        clc38 = new Calculator(mInputParser38.getCiphersList(), mInputParser38.getSignsList(),mInputParser38.isHasFirstNegativeCipher());

/*init clc39*/
        mInputParser39 = new UserInputParser(exp38);
        clc39 = new Calculator(mInputParser39.getCiphersList(), mInputParser39.getSignsList(),mInputParser39.isHasFirstNegativeCipher());

/*init clc40*/
        mInputParser40 = new UserInputParser(exp39);
        clc40 = new Calculator(mInputParser40.getCiphersList(), mInputParser40.getSignsList(),mInputParser40.isHasFirstNegativeCipher());

/*init clc41*/
        mInputParser41 = new UserInputParser(exp40);
        clc41 = new Calculator(mInputParser41.getCiphersList(), mInputParser41.getSignsList());

/*init clc42*/
        mInputParser42 = new UserInputParser(exp41);
        clc42 = new Calculator(mInputParser42.getCiphersList(), mInputParser42.getSignsList());

/*init clc43*/
        mInputParser43 = new UserInputParser(exp42);
        clc43 = new Calculator(mInputParser43.getCiphersList(), mInputParser43.getSignsList(),mInputParser43.isHasFirstNegativeCipher());

/*init clc44*/
        mInputParser44 = new UserInputParser(exp43);
        clc44 = new Calculator(mInputParser44.getCiphersList(), mInputParser44.getSignsList());

/*init clc45*/
        mInputParser45 = new UserInputParser(exp44);
        clc45 = new Calculator(mInputParser45.getCiphersList(), mInputParser45.getSignsList(),mInputParser45.getMinusAfterParenth());

/*init clc46*/
        mInputParser46 = new UserInputParser(exp45);
        clc46 = new Calculator(mInputParser46.getCiphersList(), mInputParser46.getSignsList(),mInputParser46.getMinusAfterParenth());

/*init clc47*/
        mInputParser47 = new UserInputParser(exp46);
        clc47 = new Calculator(mInputParser47.getCiphersList(), mInputParser47.getSignsList(),mInputParser47.getMinusAfterParenth());

/*init clc48*/
        mInputParser48 = new UserInputParser(exp47);
        clc48 = new Calculator(mInputParser48.getCiphersList(),
                mInputParser48.getSignsList(),
                mInputParser48.isHasFirstNegativeCipher(),
                mInputParser48.getMinusAfterParenth());

/*init clc49*/
        mInputParser49 = new UserInputParser(exp48);
        clc49 = new Calculator(mInputParser49.getCiphersList(),
                mInputParser49.getSignsList(),
                mInputParser49.isHasFirstNegativeCipher(),
                mInputParser49.getMinusAfterParenth());

/*init clc50*/
        mInputParser50 = new UserInputParser(exp49);
        clc50 = new Calculator(mInputParser50.getCiphersList(),
                mInputParser50.getSignsList(),
                mInputParser50.isHasFirstNegativeCipher(),
                mInputParser50.getMinusAfterParenth());

/*init clc5 51*/
        mInputParser51 = new UserInputParser(exp50);
        clc51 = new Calculator(mInputParser51.getCiphersList(),
                mInputParser51.getSignsList(),
                mInputParser51.isHasFirstNegativeCipher(),
                mInputParser51.getMinusAfterParenth());

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
        try {
            new UserInputParser(exp17);
            fail("clc18 6**11 didn't throw exception");
        } catch (Exception e) { }

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

/*test clc26*/
        x = clc26.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc26", BigDecimal.valueOf(26.0), res);

/*test clc27*/
        x = clc27.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc27", BigDecimal.valueOf(40.0), res);

/*test clc28*/
        x = clc28.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc28", BigDecimal.valueOf(0.0), res);

/*test clc29*/
        x = clc29.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc29", BigDecimal.valueOf(-2640.0), res);

/*test clc30*/
        x = clc30.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc30", BigDecimal.valueOf(-150.0), res);

/*test clc31*/
        x = clc31.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc31", BigDecimal.valueOf(-75.0), res);

/*test clc32*/
        x = clc32.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc32", BigDecimal.valueOf(-75.0), res);

/*test clc33*/
        x = clc33.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc33", BigDecimal.valueOf(-75.0), res);

/*test clc34*/
        x = clc34.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc34", BigDecimal.valueOf(-79.0), res);

/*test clc35*/
        x = clc35.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc35", BigDecimal.valueOf(77.0), res);

/*test clc36*/
        x = clc36.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc36", BigDecimal.valueOf(81.0), res);

/*test clc37*/
        x = clc37.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc37", BigDecimal.valueOf(77.0), res);

/*test clc38*/
        x = clc38.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc38", BigDecimal.valueOf(-79.0), res);

/*test clc39*/
        x = clc39.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc39", BigDecimal.valueOf(-77.0), res);

/*test clc40*/
        x = clc40.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc40", BigDecimal.valueOf(-81.0), res);

/*test clc41*/
        x = clc41.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc41", BigDecimal.valueOf(75.0), res);

/*test clc42*/
        x = clc42.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc42", BigDecimal.valueOf(75.0), res);

/*test clc43*/

        x = clc43.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc43", BigDecimal.valueOf(-81.0), res);


/*test clc44*/
        x = clc44.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc44", BigDecimal.valueOf(75.0), res);

/*test clc45*/
        x = clc45.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc45", BigDecimal.valueOf(395.0), res);

/*test clc46*/
        x = clc46.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc46", BigDecimal.valueOf(395.0), res);

/*test clc47*/
        x = clc47.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc47", BigDecimal.valueOf(398.0), res);

/*test clc48*/
        x = clc48.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc48", BigDecimal.valueOf(-5.0), res);

/*test clc49*/
        x = clc49.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc49", BigDecimal.valueOf(-11.0), res);

/*test clc50*/
        x = clc50.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc50", BigDecimal.valueOf(13.0), res);

/*test clc51*/
        x = clc51.calculateExpression();
        bd = new BigDecimal(x, MathContext.DECIMAL32);
        res = bd.setScale(1, RoundingMode.UP);
        assertEquals("clc51", BigDecimal.valueOf(-9.0), res);




    }

}
