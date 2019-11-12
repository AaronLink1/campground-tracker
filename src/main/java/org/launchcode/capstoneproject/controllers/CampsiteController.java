package org.launchcode.capstoneproject.controllers;

import org.launchcode.capstoneproject.models.data.CampsiteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "campsites")
public class CampsiteController {
    @Autowired
    private CampsiteDao campsiteDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        return "campsites/index";
    }
}
