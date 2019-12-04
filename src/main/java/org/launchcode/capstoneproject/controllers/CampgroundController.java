package org.launchcode.capstoneproject.controllers;

import org.launchcode.capstoneproject.models.Campground;
import org.launchcode.capstoneproject.models.data.CampgroundDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "campgrounds")
public class CampgroundController {
    @Autowired
    private CampgroundDao campgroundDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Campground");
        model.addAttribute("campgrounds", campgroundDao.findAll());
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

        campgroundDao.save(newCampground);

        return "redirect:";
    }
}
