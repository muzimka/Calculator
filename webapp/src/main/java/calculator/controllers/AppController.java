package calculator.controllers;


import calculator.model.Calculator;
import calculator.model.UserInputParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
        UserInputParser userInputParser = new UserInputParser(input);
        Calculator calculator = new Calculator(userInputParser.getCiphersList(),userInputParser.getSignsList());
         model.addAttribute("result",calculator.calculateExpression());
        model.addAttribute("expression",input+" = ");
        return "calculator";
    }
}
