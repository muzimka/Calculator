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

        /*LinkedList<Double> ciphers = new LinkedList<Double>();
        LinkedList<Character> signs = new LinkedList<Character>();

        *//*5+2*(3-2) = 7*//*
        ciphers.addAll(Arrays.asList(5.,2.,3.,2.));
        signs.addAll(Arrays.asList( '+','*','(','-',')'));
        //signs.addAll(Arrays.asList(   '+', '*', '+'));

        Calculator clc = new Calculator(ciphers,signs);

        double x = 0;

            x = clc.calculateExpression();


        BigDecimal bd = new BigDecimal(x,MathContext.DECIMAL32);
        BigDecimal res = bd.setScale(4, RoundingMode.UP);
        System.out.println(res);*/
        String exp = "2+3*(2+2)-3*(2+1)";//5
        String exp1 = "2/2";
        String exp2 = "5+2*(3-2)"; //=7
        String exp3 = "2+(12-9)"; //=5
        String exp4 = "2*(3+2*(2+2))"; //=22
        String exp5 = "5+2*(3+2*(3+2))"; //=31

        UserInputParser userInputParser = new UserInputParser(exp2);
        Calculator calculator = new Calculator(userInputParser.getCiphersList(),userInputParser.getSignsList());
        System.out.println(calculator.calculateExpression());

    }



}
