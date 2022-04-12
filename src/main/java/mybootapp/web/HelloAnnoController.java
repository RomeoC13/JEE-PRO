package mybootapp.web;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller()
@RequestMapping("/tests")
public class HelloAnnoController {

    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView sayHello() {
        String now = (new Date()).toString();
        logger.info("Running " + this);
        return new ModelAndView("hello", "now", now);
    }

    @RequestMapping(value = "/counter", method = RequestMethod.GET)
    public ModelAndView counter(HttpSession session){
        Integer counter = (Integer) session.getAttribute("counter");
        if(counter == null)
            session.setAttribute("counter", 0);
        else
            session.setAttribute("counter", ++counter);
        return new ModelAndView("counter");
    }

    @RequestMapping(value = "/plus10", method = RequestMethod.GET)
    public ModelAndView plus10(
            @RequestParam(value = "num", defaultValue = "100") Integer value) {
        logger.info("Running plus10 controler with param = " + value);
        return new ModelAndView("hello", "now", value + 10);
    }

    @RequestMapping(value = "date", method = RequestMethod.GET)
    public ModelAndView dateTest(@RequestParam(value = "date", defaultValue = "1970-01-01") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date){
        return new ModelAndView("hello", "now", date);
    }

    @RequestMapping(value = "/voir/{param}/{param2}", method = RequestMethod.GET)
    public ModelAndView voir(@PathVariable("param") Integer param, @PathVariable("param2") String message) {
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("now", param);
        modelAndView.addObject("msg", message);
        return modelAndView;
    }

    @RequestMapping(value = "/matrix/{param}", method = RequestMethod.GET)
    @ResponseBody
    public String testMatrix(//
                             @PathVariable("param") String param, //
                             @MatrixVariable(name = "a", defaultValue = "A") String a, //
                             @MatrixVariable(name = "b", defaultValue = "1") Integer b//
    ) {
        return String.format("param=%s, a=%s, b=%d", param, a, b);
    }
}