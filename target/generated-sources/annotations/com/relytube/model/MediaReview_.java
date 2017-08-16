package com.relytube.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MediaReview.class)
public abstract class MediaReview_ {

	public static volatile ListAttribute<MediaReview, Review> controversialReviewList;
	public static volatile ListAttribute<MediaReview, Review> negativeReviewList;
	public static volatile SingularAttribute<MediaReview, String> videoHash;
	public static volatile SingularAttribute<MediaReview, Long> id;
	public static volatile ListAttribute<MediaReview, Review> positiveReviewList;

}

