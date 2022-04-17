package mybootapp.web;

import mybootapp.business.DirectoryManager;
import mybootapp.dao.DirectoryDao;
import mybootapp.model.Group;
import mybootapp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.Date;

@Controller
@RequestMapping("/")
//@SpringBootApplication(scanBasePackages={"mybootapp.dao", "mybootapp.business"})
@ComponentScan(basePackages= {"mybootapp.dao", "mybootapp.business"})
public class MyControler {

    @Autowired
    DirectoryDao dao;

    @Autowired
    DirectoryManager dm;

    @PostConstruct
    public void init(){
        Group groupe1 = new Group("groupe 1");
        Group groupe2 = new Group("groupe 2");
        Group group3 = new Group("groupe test");

        Person p1 = new Person(groupe1, "Jean", "Dupont", "jean@protonmail.com", "jean.com", new Date(01 / 01 / 1921), "password_jean");
        Person p2 = new Person(group3, "Pierre", "Dupont", "pierre@protonmail.com", "pierre.com", new Date(01 / 01 / 1921), "password_pierre");
        Person p3 = new Person(groupe2, "Thomas", "Dupont", "thomas@protonmail.ch", "thomas.com", new Date(01 / 01 / 1921), "password_thomas");

        dao.addPerson(p1);
        dao.addPerson(p2);
        dao.addPerson(p3);
    }

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
        ModelAndView modelAndView = new ModelAndView("viewMail");
        modelAndView.addObject("mailList",dm.searchPersonsByEmailAddress(key));
        modelAndView.addObject("key", key);
        return modelAndView;
    }

    @RequestMapping("/viewGroup")
    public ModelAndView viewGroup(@RequestParam String key){
        ModelAndView modelAndView=  new ModelAndView("viewGroup");
        modelAndView.addObject("groupList",dm.searchGroupsByName(key));
        modelAndView.addObject("key", key);
        return modelAndView;
    }
}
