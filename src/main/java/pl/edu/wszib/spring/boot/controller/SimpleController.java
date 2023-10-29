package pl.edu.wszib.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SimpleController {

    @RequestMapping(path = "/adres1", method = RequestMethod.GET)
    public String reakcja() {
        System.out.println("Cos dziala !!!");
        return "strona";
    }

    @RequestMapping(path = "/test2", method = RequestMethod.GET)
    public String test2() {
        System.out.println("odpalil sie test2 !!!");
        return "strona2";
    }
}
