/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity.entitysc.repository;

import com.entity.entitysc.model.NewsLetter;

/**
 *
 * @author bokon
 */
public interface ContactRepository {

    NewsLetter addNewsletter(NewsLetter newsletter);
    
    NewsLetter getNewsletterSubscriberUsingEmail(String subscriberEmail);
}
