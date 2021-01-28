/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity.entitysc.repository;

import com.entity.entitysc.model.NewsLetter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bokon
 */
@Repository
public class ContactRepositoryImpl implements ContactRepository {
    
    @PersistenceContext
    EntityManager em;
    
    @Override
    @Transactional
    public NewsLetter addNewsletter(NewsLetter newsletter) {
        em.persist(newsletter);
        em.flush();
        return newsletter;
    }
    
    @Override
    public NewsLetter getNewsletterSubscriberUsingEmail(String subscriberEmail) {
        TypedQuery<NewsLetter> query = em.createQuery("SELECT p FROM NewsLetter p WHERE p.subscriberEmail = :subscriberEmail", NewsLetter.class)
                .setParameter("subscriberEmail", subscriberEmail);
        List<NewsLetter> record = query.getResultList();
        if (record.isEmpty()) {
            return null;
        }
        return record.get(0);
    }
}
