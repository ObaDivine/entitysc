/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity.entitysc.controller;

import com.entity.entitysc.payload.ContactPayload;
import com.entity.entitysc.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author bokon
 */
@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    ContactService contactService;
    private String alertMessage = "";

    @GetMapping("/")
    public String contact(Model model) {
        return "contact";
    }

    @PostMapping("/newsletter")
    public String newsletter(@ModelAttribute("contactPayload") ContactPayload payload, Model model) {
        String result = contactService.addNewsletter(payload);
        model.addAttribute("alertMessage", alertMessage);
        resetAlertMessage();
        return "redirect:/";
    }

    private void resetAlertMessage() {
        alertMessage = "";
    }
}
