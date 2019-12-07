package org.launchcode.capstoneproject.controllers;

import org.launchcode.capstoneproject.models.data.CampgroundDao;
import org.launchcode.capstoneproject.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
    @Autowired
    private CampgroundDao campgroundDao;

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "search")
    public String index(Model model, @RequestParam String searchTerm) {
        model.addAttribute("title", "Search Results: Campgrounds");



        return "campgrounds/index";
    }
}
