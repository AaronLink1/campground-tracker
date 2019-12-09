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

    @RequestMapping(value = "/")
    public String index(Model model) {

        //Get the current users details and user
        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findByUsername(userDetails.getUsername());

        //Get list of all the active users campgrounds
        ArrayList<Campground> campgrounds = campgroundDao.findAllByUser_Id(user.getId());

        model.addAttribute("title", "Campgrounds");
        model.addAttribute("campgrounds", campgrounds);
        return "campgrounds/index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String processIndex(Model model, @RequestParam String searchOption, @RequestParam String searchTerm) {

        //Get the current users details and find the user
        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findByUsername(userDetails.getUsername());

        ArrayList<Campground> searchResults = findCampgrounds(searchOption, searchTerm, user);

        if (searchResults.isEmpty()) {
            model.addAttribute("title", "No Results Found");
        } else {
            model.addAttribute("title", "Search Results: " + searchOption);
        }

        //Add the campgrounds that matched the searchOption and searchTerm
        model.addAttribute("campgrounds", searchResults);

        return "campgrounds/index";
    }

    @RequestMapping(value = "add-campground/", method = RequestMethod.GET)
    public String addCampsite(Model model) {
        model.addAttribute("title", "Add Campground");
        model.addAttribute(new Campground());
        return "campgrounds/add-campground";
    }

    @RequestMapping(value = "add-campground/", method = RequestMethod.POST)
    public String processAddCampsite(@ModelAttribute @Valid Campground newCampground, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Campground");
            return "campgrounds/add-campground";
        }

        //Get the current users details and find the user
        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findByUsername(userDetails.getUsername());

        //Give the new campground an assigned user
        newCampground.setUser(user);

        campgroundDao.save(newCampground);

        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String removeCampground(Model model) {

        //Get the current users details and find the user
        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findByUsername(userDetails.getUsername());

        //Get a list of the active users campgrounds
        ArrayList<Campground> campgrounds = campgroundDao.findAllByUser_Id(user.getId());

        model.addAttribute("title", "Remove Campground");
        model.addAttribute("campgrounds", campgrounds);

        return "campgrounds/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCampground(Model model, @RequestParam int[] campgroundIds) {
            for (int campgroundId : campgroundIds)
                campgroundDao.deleteById(campgroundId);

        return "redirect:";
    }

    @RequestMapping(value = "remove/search", method = RequestMethod.POST)
    public String processRemoveCampgroundSearchResults(Model model, @RequestParam String searchOption,
                                                       @RequestParam String searchTerm) {

            //Get the current users details and find the user
            UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = userDao.findByUsername(userDetails.getUsername());

            ArrayList<Campground> searchResults = findCampgrounds(searchOption, searchTerm, user);
            model.addAttribute("campgrounds", searchResults);

            if (searchResults.isEmpty())
                model.addAttribute("title", "No Results Found");
            else
                model.addAttribute("title", "Search Results: " + searchOption);

        return "campgrounds/remove";
    }

    private ArrayList<Campground> findCampgrounds(String searchOption, String searchTerm, User user) {
        ArrayList<Campground> searchResults = new ArrayList();
        if (searchOption.equals("name")) {
            for (Campground campground : campgroundDao.findAllByName(searchTerm))
                if (campground.getUser().getId() == user.getId())
                    searchResults.add(campground);
        } else if (searchOption.equals("price")) {
            for (Campground campground : campgroundDao.findAllByPrice(Integer.parseInt(searchTerm)))
                if (campground.getUser().getId() == user.getId())
                    searchResults.add(campground);
        } else if (searchOption.equals("location")) {
            for (Campground campground : campgroundDao.findAllByLocation(searchTerm))
                if (campground.getUser().getId() == user.getId())
                    searchResults.add(campground);
        } else if (searchOption.equals("electric")) {
            for (Campground campground : campgroundDao.findAllByHasElectric(true))
                if (campground.getUser().getId() == user.getId())
                    searchResults.add(campground);
        } else if (searchOption.equals("water")) {
            for (Campground campground : campgroundDao.findAllByHasWater(true))
                if (campground.getUser().getId() == user.getId())
                    searchResults.add(campground);
        } else if (searchOption.equals("dump")) {
            for (Campground campground : campgroundDao.findAllByHasDump(true))
                if (campground.getUser().getId() == user.getId())
                    searchResults.add(campground);
        } else if (searchOption.equals("facilities")) {
            for (Campground campground : campgroundDao.findAllByHasFacilities(true))
                if (campground.getUser().getId() == user.getId())
                    searchResults.add(campground);
        }

        return searchResults;
    }
}
