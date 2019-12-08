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
import org.springframework.web.bind.annotation.*;

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
        ArrayList<Campground> campgrounds = campgroundDao.findAllByUser_Id(user.getId());

        model.addAttribute("title", "Campgrounds");
        model.addAttribute("campgrounds", campgrounds);
        return "campgrounds/index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String processIndex(Model model, @RequestParam String) {

        return "campgrounds/index";
    }

    @RequestMapping(value = "add-campground", method = RequestMethod.GET)
    public String addCampsite(Model model) {
        model.addAttribute("title", "Add Campground");
        model.addAttribute(new Campground());
        return "campgrounds/add-campground";
    }

    @RequestMapping(value = "add-campground", method = RequestMethod.POST)
    public String processAddCampsite(@ModelAttribute @Valid Campground newCampground, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Campground");
            return "campgrounds/add-campground";
        }

        //Get the current users details
        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        //Find user and set User in campground
        newCampground.setUserId(userDao.findByUsername(userDetails.getUsername()));

        campgroundDao.save(newCampground);

        return "redirect:";
    }
}
