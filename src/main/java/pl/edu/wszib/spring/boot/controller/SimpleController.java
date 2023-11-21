package pl.edu.wszib.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.spring.boot.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    @RequestMapping(path = "/test3", method = RequestMethod.GET)
    public String test3(@RequestParam("parametr1") String imie,
                        @RequestParam("parametr2") int wiek) {
        System.out.println(imie);
        System.out.println(wiek);
        return "strona";
    }

    @RequestMapping(path = "/test4/{imie}/{wiek}", method = RequestMethod.GET)
    public String test4(@PathVariable String imie,
                        @PathVariable int wiek) {
        System.out.println(imie);
        System.out.println(wiek);
        return "strona";
    }

    @RequestMapping(path = "/form", method = RequestMethod.GET)
    public String form() {
        return "form";
    }

    @RequestMapping(path = "/form", method = RequestMethod.POST)
    public String form(@RequestParam String name,
                        @RequestParam String surname) {
        System.out.println(name);
        System.out.println(surname);
        /*System.out.println(age);
        System.out.println(password);*/
        return "strona";
    }

    @RequestMapping(path = "/test5", method = RequestMethod.GET)
    public String test5(Model model) {
        List<String> names = List.of("Janusz", "Zbyszek", "Karol", "Wiesiek");
        String randomName = names.get(new Random().nextInt(names.size()));
        model.addAttribute("imie", randomName);
        model.addAttribute("imiona", names);
        return "names";
    }

    @RequestMapping(path = "/form2", method = RequestMethod.GET)
    public String form2(Model model) {
        User user = new User();
        user.setName("Wiesiek");
        System.out.println(user);
        model.addAttribute("modelUsera", user);
        return "form2";
    }

    @RequestMapping(path = "/form2", method = RequestMethod.POST)
    public String form2(@ModelAttribute User user) {
        System.out.println(user);
        System.out.println(user.getName());
        System.out.println(user.getSurname());
        System.out.println(user.getAge());
        System.out.println(user.getPassword());
        return "strona";
    }
}
