package com.relytube.service;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.relytube.model.Review;

@Stateless
public class ReviewRegistration {
	
	  	@Inject
	    private Logger log;

	    @Inject
	    private EntityManager em;

//	    @Inject
//	    private Event<Review> memberEventSrc;

	    public void register(Review review) throws Exception {
	        log.info("Registering " + review.toString());
	        em.persist(review);
//	        memberEventSrc.fire(member);
	    }
}
