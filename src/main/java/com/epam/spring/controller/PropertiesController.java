package com.epam.spring.controller;

import com.epam.spring.util.RootProperties;
import com.epam.spring.util.PropertyHolder;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/properties")
public class PropertiesController {

    @Setter(onMethod_= @Autowired)
    PropertyHolder holder;

    @Setter(onMethod_= @Autowired)
    RootProperties rootProperties;

    @GetMapping
    @ResponseBody
    public void checkProperties() {
        System.out.println("just to stop here");
    }
}
