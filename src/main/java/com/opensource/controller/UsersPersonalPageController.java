package com.opensource.controller;

import com.opensource.Constants;
import com.opensource.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class UsersPersonalPageController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "personalPage", method = RequestMethod.GET)
    public String redirectToPersonalPage(ModelMap model, Principal principal) {
        if (principal != null && userService.hasRole(principal.getName(), Constants.ADMIN_ROLE)) {
            return "redirect:/admin/";
        }
        fillGreetingMessageForPersonalPage(model, principal);
        return "personalPage";
    }

    public void fillGreetingMessageForPersonalPage(ModelMap model, Principal principal) {
        String greetingMessage = "Hello "+getUserName(principal)+". What's up?";
        model.addAttribute("greetingMessage", greetingMessage);
    }

    private String getUserName(Principal principal) {
        if (principal != null) {
            return principal.getName();
        } else {
            return "User";
        }
    }
}
