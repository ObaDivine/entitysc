/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity.entitysc.model;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author bokon
 */
@Entity
@Table(name = "newsletter")
public class NewsLetter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "subscriber_name")
    private String subscriberName;
    @Column(name = "subscriber_email")
    private String subscriberEmail;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "removed_at")
    private LocalDateTime removedAt;
    @Column(name = "status")
    private String status;
    @Column(name = "removed_reason")
    private String removedReason;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public void setSubscriberName(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    public String getSubscriberEmail() {
        return subscriberEmail;
    }

    public void setSubscriberEmail(String subscriberEmail) {
        this.subscriberEmail = subscriberEmail;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getRemovedAt() {
        return removedAt;
    }

    public void setRemovedAt(LocalDateTime removedAt) {
        this.removedAt = removedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemovedReason() {
        return removedReason;
    }

    public void setRemovedReason(String removedReason) {
        this.removedReason = removedReason;
    }
    
}
