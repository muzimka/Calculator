import calcmodel.Calculator;
import calcmodel.UserInputParser;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;

/**
 * Created by MainW8 on 15.03.2016.
 */
public class CalcTest {


    public static void main(String[] args)  {

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


        String exp48 ="(-5)+6)";// 1



        UserInputParser userInputParser = new UserInputParser(exp17);
        Calculator calculator = new Calculator(userInputParser.getCiphersList(),
                userInputParser.getSignsList(),
                userInputParser.isHasFirstNegativeCipher(),
                userInputParser.getMinusAfterParenth());
        System.out.println(calculator.calculateExpression());
    }
}
