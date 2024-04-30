package org.example.test2.controller;

import lombok.RequiredArgsConstructor;
import org.example.test2.config.MyLocaleResolver;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class GreetingController {

    private final MessageSource messageSource;
    private final MyLocaleResolver myLocaleResolver;

    @GetMapping("")
    public String message(HttpServletRequest request) {
        return messageSource.getMessage("greeting", null, myLocaleResolver.resolveLocale(request));
    }
}
