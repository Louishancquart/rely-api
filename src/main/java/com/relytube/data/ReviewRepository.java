package com.relytube.data;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.relytube.model.Member;
import com.relytube.model.Review;

public class ReviewRepository {
	
	
		@Inject
	    private EntityManager em;

	    public Member findById(Long id) {
	        return em.find(Member.class, id);
	    }
	    


	    public Member findByEmail(String email) {
	        CriteriaBuilder cb = em.getCriteriaBuilder();
	        CriteriaQuery<Member> criteria = cb.createQuery(Member.class);
	        Root<Member> member = criteria.from(Member.class);
	        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
	        // feature in JPA 2.0
	        // criteria.select(member).where(cb.equal(member.get(Member_.name), email));
	        criteria.select(member).where(cb.equal(member.get("email"), email));
	        return em.createQuery(criteria).getSingleResult();
	    }

	    public List<Member> findAllOrderedByName() {
	        CriteriaBuilder cb = em.getCriteriaBuilder();
	        CriteriaQuery<Member> criteria = cb.createQuery(Member.class);
	        Root<Member> member = criteria.from(Member.class);
	        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
	        // feature in JPA 2.0
	        // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
	        criteria.select(member).orderBy(cb.asc(member.get("name")));
	        return em.createQuery(criteria).getResultList();
	    }

		@SuppressWarnings("unchecked")
		public List<Review> findAllReviews() {			
			
			final List<Review> results =
			em.createQuery(
			"select r from Review r order by r.type")
			.getResultList();
		return results;
		}


		@SuppressWarnings("unchecked")
		public List<Review> findReviewsByReviewedMediaUrl(String reviewedMediaUrl) {		
			final List<Review> results =
				em.createQuery(
				"from Review r where r.reviewedMediaUrl like :mediaUrl")
				.setParameter("mediaUrl", reviewedMediaUrl)
				.getResultList();
			return results;
		
		}
		
		@SuppressWarnings("unchecked")
		public List<Review> findReviewsByReviewedMediaUrlAndByType(String reviewedMediaUrl, String type) {		
			final List<Review> results =
				em.createQuery(
				"from Review r where r.reviewedMediaUrl like :mediaUrl and r.type = :type")
				.setParameter("mediaUrl", reviewedMediaUrl)
				.setParameter("type", type)
				.getResultList();
			return results;
		
		}
}
