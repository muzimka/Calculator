package calculator.controllers;


import calcmodel.Calculator;
import calcmodel.UserInputParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Controller
public class AppController {

    @RequestMapping ("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/calculator")
    public String calculator(){
        return "calculator";
    }

    @RequestMapping(value = "/calculator", method = RequestMethod.POST)
    public String calculator(@RequestParam(value = "calc") String input, Model model){
        String error = null;
        UserInputParser userInputParser = null;
        try {
            userInputParser = new UserInputParser(input);
        } catch (Exception e) {
            error = "Ошибка пользовательского ввода: "+input + ".\n"+e.getMessage();
            model.addAttribute("error",error);
            return "calculator";
        }
        Calculator calculator = new Calculator(userInputParser.getCiphersList(),
                userInputParser.getSignsList(),
                userInputParser.isHasFirstNegativeCipher(),
                userInputParser.getMinusAfterParenth());

        double x = 0;
        try {
            x = calculator.calculateExpression();
        } catch (ArithmeticException e){
            error = "Арифметическая ошибка: "+input+"."+e.getMessage();
            model.addAttribute("error",error);
            return "calculator";
        }
        catch (Exception e) {
            error = "Не могу вычислить это выражение: "+input+". "+e.getMessage()+
                    "\nЕсли выражение в скобках начинается с отрицательной цифры, заключите ее в скобки.\n" +
                    "Например: 2+((-3)+2)";
            model.addAttribute("error",error);
            return "calculator";
        }


        BigDecimal bd = new BigDecimal(x, MathContext.DECIMAL32);
        BigDecimal res = bd.setScale(3, RoundingMode.FLOOR);
        model.addAttribute("result",res);
        model.addAttribute("expression",input+" = ");

        return "calculator";
    }
}
