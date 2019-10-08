package com.epam.spring.controller.modelandview;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    //@Secured({"ROLE_ADMIN", "ROLE_USER"}) //must have either ADMIN or USER role, enabled by @EnableGlobalMethodSecurity
    public String index() {
        return "root";
    }

}
