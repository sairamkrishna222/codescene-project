package com.srk.moviereview.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srk.moviereview.bean.MovieRating;
import com.srk.moviereview.bean.MultiMovieRating;
import com.srk.moviereview.exceptions.ResourceNotFoundException;
import com.srk.moviereview.service.MovieReviewService;

@RestController
@RequestMapping(path = "/rate")
public class MovieReviewController {
	
	@Autowired
	private MovieReviewService serv;

	@PostMapping(path="/saverating")
	public ResponseEntity<MovieRating> saveMovieRating(@RequestBody @Valid MovieRating mv)
	{
		MovieRating mbb = serv.saveRating(mv);
		
		return  new ResponseEntity<MovieRating>(mbb,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping(path = "/{movieId}/review")
	public ResponseEntity<MultiMovieRating> getReviewforMovieId(@PathVariable("movieId") long mvId)
	{
		List<MovieRating> mbb = serv.getRatingofMovie(mvId);
		Boolean tr= mbb.isEmpty() ? false : true;
		if(tr)
		{
			return new ResponseEntity<MultiMovieRating>(new MultiMovieRating(mbb) ,HttpStatus.FOUND);
		}
		throw new ResourceNotFoundException("Corresponding MovieId Is Not Found"+mvId);
	}
	
	@GetMapping(path = "/{userId}")
	public ResponseEntity<MultiMovieRating> getListOfMovieByUserId(@PathVariable("userId") long userId)
	{
		List<MovieRating> mbb = serv.getlistOfRatingByUserId(userId);
		if(mbb != null && mbb.size() >0 )
		{
			return new ResponseEntity<MultiMovieRating>(new MultiMovieRating(mbb) ,HttpStatus.FOUND);
		}
		throw new ResourceNotFoundException("Corresponding Movie Ratings Is Not Found"+userId);
	}
	
}
