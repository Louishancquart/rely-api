package com.relytube.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Review.class)
public abstract class Review_ {

	public static volatile SingularAttribute<Review, String> reviewedMediaUrl;
	public static volatile SingularAttribute<Review, String> reviewedTimes;
	public static volatile SingularAttribute<Review, String> description;
	public static volatile SingularAttribute<Review, Long> id;
	public static volatile SingularAttribute<Review, String> type;
	public static volatile SingularAttribute<Review, String> referenceUrl;

}

