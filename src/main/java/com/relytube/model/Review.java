package com.relytube.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.validation.constraints.Pattern;

@Entity
public class Review implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column
	@Pattern(message = "type should be \"POSITIVE | NEGATIVE | CONTROVERSIAL\"", regexp = "POSITIVE|NEGATIVE|CONTROVERSIAL")
	private String type;

	@Column
	private String reviewedMediaUrl;
	
	@Column
	private String referenceUrl;
	
	@Column
	private Long reviewedTimes;
	
	@Column
	private String description;
	
	
	
	
	

	
	public Long getId() {
		return this.id;
	}
	
	public void setId(final Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public String getReviewedMediaUrl() {
		return reviewedMediaUrl;
	}

	public void setReviewedMediaUrl(String reviewedMediaUrl) {
		this.reviewedMediaUrl = reviewedMediaUrl;
	}

	public String getReferenceUrl() {
		return referenceUrl;
	}

	public void setReferenceUrl(String referenceUrl) {
		this.referenceUrl = referenceUrl;
	}

	public Long getReviewedTimes() {
		return reviewedTimes;
	}

	public void setReviewedTimes(Long reviewedTimes) {
		this.reviewedTimes = reviewedTimes;
	}
	
	

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (type != null && !type.trim().isEmpty())
			result += "type: " + type;
		if (description != null && !description.trim().isEmpty())
			result += ", description: " + description;
		if (reviewedMediaUrl != null && !reviewedMediaUrl.trim().isEmpty())
			result += ", mediaUrl: " + reviewedMediaUrl;
		if (referenceUrl != null && !referenceUrl.trim().isEmpty())
			result += ", referenceUrl: " + referenceUrl;
		
		return result;
	}
	
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Review)) {
			return false;
		}
		Review other = (Review) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

}