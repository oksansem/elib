package com.opensource.controller.admin;


import com.opensource.model.Role;
import com.opensource.model.User;
import com.opensource.service.RoleService;
import com.opensource.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminPageController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String fillParametersForAdminPage(ModelMap model, Principal principal) {
        fillParameters(model, principal);
        return "admin";
    }

    private void fillParameters(ModelMap model, Principal principal) {
        String greetingMessage = getGreetingMessage(principal);
        model.addAttribute("greetingMessage", greetingMessage);

        List<Role> roles = roleService.getRoles();
        model.addAttribute("userRoles", roles);

        List<User> users = userService.getUsers();
        removeCurrentUserFromList(principal, users);
        model.addAttribute("users", users);
    }

    private void removeCurrentUserFromList(Principal principal, List<User> users) {
        Iterator<User> usersIterator = users.iterator();
        while (usersIterator.hasNext()) {
            User user = usersIterator.next();
            if (user.getUserName().equals(principal.getName())) {
                usersIterator.remove();
            }
        }
    }

    private String getGreetingMessage(Principal principal) {
        return "Hello "+principal.getName()+". How Do You do?";
    }
}
