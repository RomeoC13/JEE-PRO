package mybootapp.web;

import mybootapp.dao.DirectoryDao;
import mybootapp.model.Group;
import mybootapp.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/")
public class MyControler {
    DirectoryDao dir;

    @PostConstruct
    public void init(){
        dir = new DirectoryDao();

        //TO TEST
        Group testGroup = new Group("FSI");


        Person per1 = new Person();
        per1.setId(0);
        per1.setFirstName("Roméo");
        per1.setLastName("CHATEL");
        per1.setEmailAddress("romeo@romeo.fr");
        per1.setUserGroup(testGroup);
        dir.addPerson(per1);

        Person per2 = new Person();
        per2.setId(1);
        per2.setFirstName("Louis");
        per2.setLastName("DE CAMPOU");
        per2.setEmailAddress("louis@louis.com");
        per2.setUserGroup(testGroup);
        dir.addPerson(per2);
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
        modelAndView.addObject("mailList",dir.searchPersonsByEmailAddress(key));
        modelAndView.addObject("key", key);
        return modelAndView;
    }

    @RequestMapping("/viewGroup")
    public ModelAndView viewGroup(@RequestParam String key){
        ModelAndView modelAndView=  new ModelAndView("viewGroup");
        modelAndView.addObject("groupList",dir.searchGroupsByName(key));
        modelAndView.addObject("key", key);
        return modelAndView;
    }

}
