package com.srk.moviecatalogue.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.srk.moviecatalogue.dto.Movie;
import com.srk.moviecatalogue.dto.MovieCatalogue;
import com.srk.moviecatalogue.dto.MovieRating;
import com.srk.moviecatalogue.dto.MultiMovieRating;
import com.srk.moviecatalogue.dto.UserMaster;
import com.srk.moviecatalogue.dto.UserMovieCatalogueMaster;
import com.srk.moviecatalogue.exception.ResourceNotFoundException;

@RestController
@RequestMapping(path = "/Catalogue")
public class CatalogueController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(path = "/{userId}")
	public ResponseEntity<?> getMovieCatalogue(@PathVariable(name = "userId") long userId)
	{
		
		UserMovieCatalogueMaster master = new UserMovieCatalogueMaster();
		
		UserMaster Usrmst =restTemplate.getForObject("http://user-master-service/user/"+userId, UserMaster.class);
		
		if(Usrmst ==null || Usrmst.getUserName().isEmpty())
		    throw new ResourceNotFoundException("data not avaible for the UserId" + userId);
		
		master.setUserMaster(Usrmst);
		 
		 MultiMovieRating multimv = restTemplate.getForObject("http://movie-rating-service/rate/"+userId, MultiMovieRating.class);
		 
		 if(multimv ==null || multimv.getMovieRating().size() ==0)
			    throw new ResourceNotFoundException("data not avaible for the UserId" + userId);
			
		  List<MovieCatalogue> catlogue =   multimv.getMovieRating().stream().map(ratings -> {
			   Movie mv= restTemplate.getForObject("http://movie-master-service/movie/getmovie/"+ratings.getMovieId(), Movie.class);
		      return new MovieCatalogue(mv.getMovieId(), mv.getMovieName(), ratings.getRating());
		   }).collect(Collectors.toList());
		  
		  if(catlogue ==null || catlogue.size()==0)
			    throw new ResourceNotFoundException("data not avaible for the UserId" + userId);
		  master.setMovieCatalogue(catlogue);
		  
		  return new ResponseEntity<>(master,HttpStatus.FOUND);
	}
	
}
