package com.relytube.rest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.relytube.data.ReviewRepository;
import com.relytube.model.Review;
import com.relytube.service.MemberRegistration;
import com.relytube.service.ReviewRegistration;
import com.relytube.model.Review;

@Path("/")
@RequestScoped
public class ReviewRESTService {
	
	
	@Inject
	private Logger log;
	
	@Inject
	private Validator validator;
	
	@Inject
	private ReviewRepository repository;
	
    @Inject
    ReviewRegistration registration;

	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Review> listAllReviews() {
		return repository.findAllReviews();
	}
	
	@GET
	@Path("{url}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Review> listAllReviewsBydMedia(@PathParam("url") String reviewedMediaUrl) {
		return repository.findReviewsByReviewedMediaUrl(reviewedMediaUrl);

	}
	
	@GET
	@Path("{url}/pos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Review> listPositiveReviewsByMedia(@PathParam("url") String reviewedMediaUrl) {
		return repository.findReviewsByReviewedMediaUrlAndByType(reviewedMediaUrl, "POSITIVE");
	}

	
	@GET
	@Path("{url}/neg")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Review> listNegativeReviewsByMedia(@PathParam("url") String reviewedMediaUrl) {
		return repository.findReviewsByReviewedMediaUrlAndByType(reviewedMediaUrl, "NEGATIVE");
	}

	@GET
	@Path("{url}/cont")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Review> listControversialReviewsByMedia(@PathParam("url") String reviewedMediaUrl) {
		return repository.findReviewsByReviewedMediaUrlAndByType(reviewedMediaUrl, "CONTROVERSIAL");
	}
	
	
	
	
	/**
	 * create a review in the database
	 * @param review
	 * @return response with 200 ok
	 */
	@POST
	@Path("{url}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createReview(Review review) {
		Response.ResponseBuilder builder = null;

        try {
            // Validates review using bean validation
            validateReview(review);

            registration.register(review);

            // Create an "ok" response
            builder = Response.ok();
        } catch (ConstraintViolationException ce) {
            // Handle bean validation issues
            builder = createViolationResponse(ce.getConstraintViolations());
//        }
//        catch (ValidationException e) {
//            // Handle the unique constrain violation
//            Map<String, String> responseObj = new HashMap<>();
//            responseObj.put("email", "Email taken");
//            builder = Response.status(Response.Status.CONFLICT).entity(responseObj);
        } catch (Exception e) {
            // Handle generic exceptions
            Map<String, String> responseObj = new HashMap<>();
            responseObj.put("error", e.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }

        return builder.build();
    }


	   /**
     * <p>
     * Validates the given Member variable and throws validation exceptions based on the type of error. If the error is standard
     * bean validation errors then it will throw a ConstraintValidationException with the set of the constraints violated.
     * </p>
     * <p>
     * If the error is caused because an existing member with the same email is registered it throws a regular validation
     * exception so that it can be interpreted separately.
     * </p>
     * 
     * @param review Member to be validated
     * @throws ConstraintViolationException If Bean Validation errors exist
     * @throws ValidationException If member with the same email already exists
     */
    private void validateReview(Review review) throws ConstraintViolationException, ValidationException {
        // Create a bean validator and check for issues.
        Set<ConstraintViolation<Review>> violations = validator.validate(review);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
        }
    }

    /**
     * Creates a JAX-RS "Bad Request" response including a map of all violation fields, and their message. This can then be used
     * by clients to show violations.
     * 
     * @param violations A set of violations that needs to be reported
     * @return JAX-RS response containing all violations
     */
    private Response.ResponseBuilder createViolationResponse(Set<ConstraintViolation<?>> violations) {
        log.fine("Validation completed. violations found: " + violations.size());

        Map<String, String> responseObj = new HashMap<>();

        for (ConstraintViolation<?> violation : violations) {
            responseObj.put(violation.getPropertyPath().toString(), violation.getMessage());
        }

        return Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
    }
//
//    /**
//     * Checks if a member with the same email address is already registered. This is the only way to easily capture the
//     * "@UniqueConstraint(columnNames = "email")" constraint from the Member class.
//     * 
//     * @param email The email to check
//     * @return True if the email already exists, and false otherwise
//     */
//    public boolean reviewAlreadyExists(String reviewed media) {
//        Review member = null;
//        try {
//            member = repository.findByEmail(email);
//        } catch (NoResultException e) {
//            // ignore
//        }
//        return member != null;
//    }


}
