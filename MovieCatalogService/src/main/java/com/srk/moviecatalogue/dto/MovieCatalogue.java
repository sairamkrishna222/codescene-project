package com.srk.moviecatalogue.dto;

public class MovieCatalogue {

	 
	private long movieId;
	
	private String movieDesc;
	
	private float rating;

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public String getMovieDesc() {
		return movieDesc;
	}

	public void setMovieDesc(String movieDesc) {
		this.movieDesc = movieDesc;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public MovieCatalogue(long movieId, String movieDesc, float rating) {
		super();
		this.movieId = movieId;
		this.movieDesc = movieDesc;
		this.rating = rating;
	}
	
	public MovieCatalogue()
	{
		
	}
	 
}
