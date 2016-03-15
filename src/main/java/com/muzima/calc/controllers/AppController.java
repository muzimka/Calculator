package com.muzima.calc.controllers;

import com.muzima.calc.calculator.Calculating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Method;


@Controller
@RequestMapping({"/", "/home"})
@ComponentScan
public class AppController {


    Calculating calcInterface;
    int x = 1;
    int y = 3;

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
       model.addAttribute("result",calcInterface.add(x,y));
        return "home";
    }
}
