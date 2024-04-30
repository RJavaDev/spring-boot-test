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
        userInfo.append("<h2>");
        userInfo.append("HTTP Method: ").append(request.getMethod()).append("\n");
        userInfo.append("<hr>");
        userInfo.append("IP Address: ").append(request.getRemoteAddr()).append("\n");

        userInfo.append("<hr>");
        userInfo.append("Content Type: ").append(request.getContentType()).append("\n");
        userInfo.append("<hr>");
        userInfo.append("Content Length: ").append(request.getContentLength()).append("\n");
        userInfo.append("<hr>");
        userInfo.append("HTTP Headers:\n");
        java.util.Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            userInfo.append("    ").append(headerName).append(": ").append(request.getHeader(headerName)).append("\n");
        }
        userInfo.append("<hr>");
        userInfo.append("Cookies: ").append(java.util.Arrays.toString(request.getCookies())).append("\n");
        userInfo.append("<hr>");
        userInfo.append("Query Parameters:\n");
        userInfo.append("<hr>");
        java.util.Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            userInfo.append("    ").append(paramName).append(": ").append(request.getParameter(paramName)).append("\n");
        }
        userInfo.append("<hr>");
        userInfo.append("Session ID: ").append(request.getSession().getId()).append("\n");
        userInfo.append("<hr>");
        userInfo.append("Context Path: ").append(request.getContextPath()).append("\n");
        userInfo.append("<hr>");
        userInfo.append("Servlet Path: ").append(request.getServletPath()).append("\n");
        userInfo.append("<hr>");
        userInfo.append("Path Info: ").append(request.getPathInfo()).append("\n");
userInfo.append("</h2>");
        return userInfo.toString();
    }
}
