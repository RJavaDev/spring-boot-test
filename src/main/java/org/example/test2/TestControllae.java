package org.example.test2;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@RestController
@RequestMapping("/test")
public class TestControllae {

    @GetMapping("/user/ip")
    public String getUserIP(HttpServletRequest request) {
        StringBuilder userInfo = new StringBuilder();

        Locale currentLocale = request.getLocale();
        String country = currentLocale.getCountry();
        String displayCountry = currentLocale.getDisplayCountry();
        String language = currentLocale.getLanguage();
        String displayLanguage = currentLocale.getDisplayLanguage();

        userInfo.append("<h1>");

        userInfo.append(country).append(": ").append(displayCountry).append("<hr>");
        userInfo.append(language).append(": ").append(displayLanguage).append("<hr>");

        userInfo.append("</h1>");

        return userInfo.toString();
    }
}
