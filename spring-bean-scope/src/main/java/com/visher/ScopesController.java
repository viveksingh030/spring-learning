package com.visher;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/*
link: https://www.baeldung.com/spring-bean-scopes
 */
@Controller
public class ScopesController {
    @Resource(name = "requestScopedBean")
    HelloMessageGenerator requestScopedBean;

    @Resource(name = "sessionScopedBean")
    HelloMessageGenerator sessionScopedBean;
    @RequestMapping("/scopes/request")
    public String getRequestScopeMessage(final Model model) {
        model.addAttribute("previousMessage", requestScopedBean.getMessage());
        requestScopedBean.setMessage("Good morning!");
        model.addAttribute("currentMessage", requestScopedBean.getMessage());
        return "scopesExample";
    }

    @RequestMapping("/scopes/session")
    public String getSessionScopeMessage(final Model model) {
        model.addAttribute("previousMessage", sessionScopedBean.getMessage());
        sessionScopedBean.setMessage("Good afternoon!");
        model.addAttribute("currentMessage", sessionScopedBean.getMessage());
        return "scopesExample";
    }
}