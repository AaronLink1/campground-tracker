package org.launchcode.capstoneproject.controllers;

import org.launchcode.capstoneproject.models.User;
import org.launchcode.capstoneproject.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/")
public class UserController {

    @Autowired
    private UserDao userDao;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("title", "Login");
        return "login/index";
    }

    @RequestMapping(value = "registration", method = RequestMethod.GET)
    public String newUser(Model model) {
        model.addAttribute("title", "Register New User");
        model.addAttribute(new User());
        return "login/registration";
    }

    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public String processNewUser(@ModelAttribute @Valid User newUser, @RequestParam String confirmPassword,
                                  Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "New User");
            model.addAttribute(new User());
            return "login/registration";
        }

        User userExists = userDao.findByUsername(newUser.getUsername());
        if(userExists != null) {
            model.addAttribute("title", "Registration");
            model.addAttribute(new User());
            return "login/registration";
        }

        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        newUser.setRoles("USER");
        newUser.setActive(1);
        userDao.save(newUser);

        return "redirect:campground";
    }
}
