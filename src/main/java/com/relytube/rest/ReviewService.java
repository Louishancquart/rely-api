//package com.relytube.rest;
//
//import java.util.List;
//import java.util.logging.Logger;
//
//import javax.enterprise.context.RequestScoped;
//import javax.inject.Inject;
//import javax.persistence.EntityManager;
//import javax.validation.Validator;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//
//import com.relytube.data.MemberRepository;
//import com.relytube.data.ReviewRepository;
//import com.relytube.model.Review;
//
//
//
//	@Path("/")
//	@RequestScoped
//	public class ReviewService {
//		
//		
//		@Inject
//		private Logger log;
//		
//		@Inject
//		private Validator validator;
//		
//		@Inject
//		private ReviewRepository repository;
//		
//
//		@SuppressWarnings("unchecked")
//		@GET
//		@Produces(MediaType.APPLICATION_JSON)
//		public List<Review> listAllReviews() {
//			return repository.findAllReviews();
//		}
//		
//
//		@Path("{url}")
//		@GET
//		@Produces(MediaType.APPLICATION_JSON)
//		public List<Review> getAllReviewsByMedia(@PathParam("url") String mediaUrl) {	
//			
//			@SuppressWarnings("unchecked")
//			final List<Review> results =
//				em.createQuery(
//				"from Review r where r.mediaUrl like :mediaUrl").setParameter("mediaUrl", mediaUrl).getResultList();
//			return results;
//		}
//	}
