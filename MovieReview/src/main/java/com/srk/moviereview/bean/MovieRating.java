package com.srk.moviereview.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class MovieRating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pkid;
	
	@NotNull(message = "Can Not Be Null")
	private long movieId;
	
	
	@NotNull(message="can not beNull")
	private long userId;
	
	
	private String review;
	
	@Max(value = 5,message = "Max Rating is 5")
	private float rating;
	
	public MovieRating()
	{
		
	}

	public long getPkid() {
		return pkid;
	}

	public void setPkid(long pkid) {
		this.pkid = pkid;
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public MovieRating(long pkid,
			@NotNull(message = "Can Not Be Null") long movieId,
			@NotNull(message = "can not beNull") long userId, String review,
			@Max(value = 5, message = "Max Rating is 5") float rating) {
		super();
		this.pkid = pkid;
		this.movieId = movieId;
		this.userId = userId;
		this.review = review;
		this.rating = rating;
	}


	
	
	
}
