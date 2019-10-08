package com.epam.spring.controller.modelandview;

import com.epam.spring.model.User;
import com.epam.spring.repository.UserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Setter(onMethod_= {@Autowired})
    private PasswordEncoder encoder;

    @Setter(onMethod_= {@Autowired})
    private UserRepository repository;

    @GetMapping
    public String registration() {
        return "/user/registration";
    }

    @PostMapping
    public String doRegister(@RequestBody User user) {
        String encoded = encoder.encode(user.getPassword());
        user.setPassword(encoded);
        repository.save(user);
        return "redirect:/spring/login";
    }
}
