package com.epam.spring.controller.modelandview;

import com.epam.spring.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * localhost:8080/spring/greeting
 */
@Controller
@RequestMapping("/greeting")
public class GreetingController {

    /**
     * localhost:8080/spring/greeting/static
     */
    @RequestMapping(path = "/static", method = {RequestMethod.GET})
    public ModelAndView staticGreeting() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "static greeting");
        modelAndView.setViewName("greeting");
        return modelAndView;
    }

    /**
     * localhost:8080/spring/greeting/dynamic/single?name=...&age=...
     */
    @GetMapping("/dynamic/single")
    public ModelAndView requestParamGreeting(@RequestParam(value = "name", required = false, defaultValue = "default dynamic name")
                                                         String name,
                                             @RequestParam(value = "age", required = false)
                                                         String age,
                                                        ModelAndView modelAndView) {
        modelAndView.addObject("name", name);
        modelAndView.addObject("age", age);
        modelAndView.setViewName("greeting");
        return modelAndView;
    }

    /**
     * http://localhost:8080/spring/greeting/dynamic/allparamsmap?name=misha&age=23&nosuch=123
     */
    @GetMapping("/dynamic/allparamsmap")
    public ModelAndView allRequestMapParamGreeting(@RequestParam Map<String, String> all,
                                             ModelAndView modelAndView) {
        Map<String, Object> model = modelAndView.getModel();
        all.forEach(model::put);
        modelAndView.setViewName("mapgreeting");
        return modelAndView;
    }

    /**
     * localhost:8080/spring/greeting/dynamic/allparamslist?name=1,2,3
     */
    @GetMapping("/dynamic/allparamslist")
    public ModelAndView allRequestListParamGreeting(@RequestParam List<String> all,
                                                   ModelAndView modelAndView) {
        modelAndView.addObject("all", all);
        modelAndView.setViewName("listgreeting");
        return modelAndView;
    }

    /**
     * localhost:8080/spring/greeting/dynamic/anythingherebecomesavariable/show
     */
    @GetMapping("/dynamic/{name}/show}")
    public ModelAndView pathVariableGreeting(@PathVariable(value = "name") String name,
                                          ModelAndView modelAndView) {
        modelAndView.addObject("name", name);
        modelAndView.setViewName("greeting");
        return modelAndView;
    }

    /**
     * localhost:8080/spring/greeting/dynamic/single/model?name=...&age=...
     */
    @GetMapping("/dynamic/single/model")
    public ModelAndView modelAttributeGreeting(@Validated @ModelAttribute Message message, ModelAndView modelAndView) {
        modelAndView.addObject("name", message.getName());
        modelAndView.addObject("age", message.getAge());
        modelAndView.setViewName("greeting");
        return modelAndView;
    }
}
