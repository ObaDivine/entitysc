/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity.entitysc.service;

import com.entity.entitysc.model.NewsLetter;
import com.entity.entitysc.payload.ContactPayload;
import com.entity.entitysc.repository.ContactRepository;
import java.time.LocalDateTime;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bokon
 */
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;
    @Autowired
    MessageSource messageSource;

    @Override
    public String addNewsletter(ContactPayload payload) {
        NewsLetter newsletter = contactRepository.getNewsletterSubscriberUsingEmail(payload.getEmail().trim());
        if (newsletter == null) {
            NewsLetter newObject = new NewsLetter();
            newObject.setSubscriberName(payload.getFullname());
            newObject.setSubscriberEmail(payload.getEmail());
            newObject.setCreatedAt(LocalDateTime.now());
            newObject.setStatus("Active");
            newObject.setRemovedAt(LocalDateTime.now());
            newObject.setRemovedReason("");
            NewsLetter createdObject = contactRepository.addNewsletter(newObject);
        }

        return messageSource.getMessage("appMessages.newsletter.subscription", new Object[0], Locale.ENGLISH);
    }

}
