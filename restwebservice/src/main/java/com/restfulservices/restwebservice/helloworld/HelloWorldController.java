package com.restfulservices.restwebservice.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

/*    public  HelloWorldController(MessageSource messageSource)
    {
        this.messageSource = messageSource;
    }*/

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/hello-inter")
    public String Internationalized() {

        Locale locale = LocaleContextHolder.getLocale();
       return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
    }
}
