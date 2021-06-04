package com.srk.moviereview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srk.moviereview.bean.MovieRating;
import com.srk.moviereview.repo.MovieReviewRepo;

@Service
public class MovieReviewService {

	@Autowired
	private MovieReviewRepo repo;
	
	public MovieRating saveRating(MovieRating mr)
	{
		return repo.save(mr);
	}
	
	public List<MovieRating> getRatingofMovie(long Id)
	{
		List<MovieRating> ratings=null;
		ratings= repo.findByMovieId(Id);
		return ratings;
	}

	public List<MovieRating> getlistOfRatingByUserId(long userId)
	{
		List<MovieRating> ratings=null;
		ratings= repo.findByUserId(userId);
		return ratings;
	}
	
}
