package org.bms.user.controller;

import org.bms.model.User;
import org.bms.model.UserType;
import org.bms.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    public User createUser(String name, String email, String mobile, UserType userType) {
        return userService.createUser( name,  email,  mobile,  userType);

    }
}
