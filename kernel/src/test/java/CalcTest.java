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

        UserInputParser userInputParser = new UserInputParser(exp25);
        Calculator calculator = new Calculator(userInputParser.getCiphersList(),userInputParser.getSignsList());
        System.out.println(calculator.calculateExpression());
    }
}
