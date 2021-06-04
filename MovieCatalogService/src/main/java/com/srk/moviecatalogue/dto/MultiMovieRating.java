package com.srk.moviecatalogue.dto;

import java.util.List;

public class MultiMovieRating {

	private List<MovieRating> movieRating;

	public List<MovieRating> getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(List<MovieRating> movieRating) {
		this.movieRating = movieRating;
	}
	
	public MultiMovieRating()
	{
		
	}

	public MultiMovieRating(List<MovieRating> movieRating) {
		super();
		this.movieRating = movieRating;
	}
	
	
}
