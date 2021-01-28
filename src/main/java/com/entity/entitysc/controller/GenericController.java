/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity.entitysc.controller;

import com.entity.entitysc.payload.ContactPayload;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author bokon
 */
@ControllerAdvice(basePackages = "com.entity.entitysc.controller")
public class GenericController {

    @ModelAttribute("contactPayload")
    public void contact(Model model) {
        model.addAttribute("contactPayload", new ContactPayload());
    }
}
