package mybootapp.web;

import mybootapp.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MyControler {
    Person person;

    @RequestMapping("")
    public String index() {
        return "index";
    }

    @RequestMapping("/login2")
    public String login(@ModelAttribute Person p) {
        return "loginForm";
    }

    @RequestMapping("/register")
    public String register(@ModelAttribute Person p) {
        return "registerForm";
    }

    @RequestMapping("/viewMail")
    public ModelAndView viewMail(@RequestParam String key){
        return new ModelAndView("viewMail", "mail",key);
    }

    @RequestMapping("/viewGroup")
    public ModelAndView viewGroup(@RequestParam String key){
        return new ModelAndView("viewGroup", "group",key);
    }

}
