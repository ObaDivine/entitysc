/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity.entitysc;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 *
 * @author Brian A. Okon bokon@entitysc.com
 */
public class SessionListener implements HttpSessionListener {

    @Autowired
    Environment env;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setMaxInactiveInterval(new Integer(env.getProperty("session_timeout")));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }

}
