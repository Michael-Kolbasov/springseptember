package com.epam.spring.model.validator;

import com.epam.spring.model.Message;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MessageValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Message.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Message message = (Message) target;
        if (message.getName().equals("bad words")) {
            errors.rejectValue(message.getName(), "badbadbad");
        }
    }
}
