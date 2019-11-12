package org.launchcode.capstoneproject.controllers;

import org.launchcode.capstoneproject.models.Campsite;
import org.launchcode.capstoneproject.models.data.CampsiteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "campsites")
public class CampsiteController {
    @Autowired
    private CampsiteDao campsiteDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Campsites");
        model.addAttribute("campsites", campsiteDao.findAll());
        return "campsites/index";
    }

    @RequestMapping(value = "add-campsite", method = RequestMethod.GET)
    public String addCampsite(Model model) {
        model.addAttribute("title", "Add Campsite");
        model.addAttribute(new Campsite());
        return "campsites/add-campsite";
    }

    @RequestMapping(value = "add-campsite", method = RequestMethod.POST)
    public String processAddCampsite(@ModelAttribute @Valid Campsite newCampsite, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Campsite");
            return "campsites/add-campsite";
        }

        campsiteDao.save(newCampsite);

        return "redirect:";
    }
}
