package com.srk.moviecatalogue.dto;

import java.util.List;

public class UserMovieCatalogueMaster {

	
	 
	 private UserMaster userMaster;
	 
	 private List<MovieCatalogue> movieCatalogue;
	 
	 public UserMovieCatalogueMaster()
	 {
		 
	 }

	public UserMovieCatalogueMaster(UserMaster userMaster, List<MovieCatalogue> movieCatalogue) {
		super();
		this.userMaster = userMaster;
		this.movieCatalogue = movieCatalogue;
	}

	public UserMaster getUserMaster() {
		return userMaster;
	}

	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}

	public List<MovieCatalogue> getMovieCatalogue() {
		return movieCatalogue;
	}

	public void setMovieCatalogue(List<MovieCatalogue> movieCatalogue) {
		this.movieCatalogue = movieCatalogue;
	}
	 
     	 
}
