package org.launchcode.capstoneproject.controllers;

import org.launchcode.capstoneproject.models.Campground;
import org.launchcode.capstoneproject.models.User;
import org.launchcode.capstoneproject.models.data.CampgroundDao;
import org.launchcode.capstoneproject.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "campgrounds")
public class CampgroundController {
    @Autowired
    private CampgroundDao campgroundDao;

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        //Get the current users details
        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userDao.findByUsername(userDetails.getUsername());
        ArrayList<Campground> campgrounds = campgroundDao.findAllByUserId(user.getId());

        model.addAttribute("title", "Campgrounds");
        model.addAttribute("campgrounds", campgrounds);
        return "campgrounds/index";
    }

    @RequestMapping(value = "add-campground/{username}", method = RequestMethod.GET)
    public String addCampsite(Model model, @PathVariable String username) {
        model.addAttribute("title", "Add Campground");
        model.addAttribute("user", userDao.findByUsername(username));
        model.addAttribute(new Campground());
        return "campgrounds/add-campground";
    }

    @RequestMapping(value = "add-campground", method = RequestMethod.POST)
    public String processAddCampsite(@ModelAttribute @Valid Campground newCampground, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Campground");
            return "campgrounds/add-campground";
        }

        campgroundDao.save(newCampground);

        return "redirect:";
    }
}
