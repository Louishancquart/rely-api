package com.relytube.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class MediaReview implements Serializable{


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Size(min = 11, max = 25)
	private String videoHash;

	@OneToMany
	@NotNull
	private List<Review> positiveReviewList;

	@OneToMany
	@NotNull
	private List<Review> negativeReviewList;

	@OneToMany
	@NotNull
	private List<Review> controversialReviewList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVideoHash() {
		return videoHash;
	}

	public void setVideoHash(String videoHash) {
		this.videoHash = videoHash;
	}

	public List<Review> getPositiveReviewList() {
		return positiveReviewList;
	}

	public void setPositiveReviewList(List<Review> positiveReviewList) {
		this.positiveReviewList = positiveReviewList;
	}

	public List<Review> getNegativeReviewList() {
		return negativeReviewList;
	}

	public void setNegativeReviewList(List<Review> negativeReviewList) {
		this.negativeReviewList = negativeReviewList;
	}

	public List<Review> getControversialReviewList() {
		return controversialReviewList;
	}

	public void setControversialReviewList(List<Review> controversialReviewList) {
		this.controversialReviewList = controversialReviewList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((controversialReviewList == null) ? 0 : controversialReviewList.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((negativeReviewList == null) ? 0 : negativeReviewList.hashCode());
		result = prime * result + ((positiveReviewList == null) ? 0 : positiveReviewList.hashCode());
		result = prime * result + ((videoHash == null) ? 0 : videoHash.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MediaReview other = (MediaReview) obj;
		if (controversialReviewList == null) {
			if (other.controversialReviewList != null)
				return false;
		} else if (!controversialReviewList.equals(other.controversialReviewList))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (negativeReviewList == null) {
			if (other.negativeReviewList != null)
				return false;
		} else if (!negativeReviewList.equals(other.negativeReviewList))
			return false;
		if (positiveReviewList == null) {
			if (other.positiveReviewList != null)
				return false;
		} else if (!positiveReviewList.equals(other.positiveReviewList))
			return false;
		if (videoHash == null) {
			if (other.videoHash != null)
				return false;
		} else if (!videoHash.equals(other.videoHash))
			return false;
		return true;
	}
}
