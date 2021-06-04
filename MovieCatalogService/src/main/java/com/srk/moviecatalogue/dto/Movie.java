package com.srk.moviecatalogue.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Movie {

	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long id;
	 
	 private long movieId;
	 
	 private String movieName;
	 
	 private String director;
	 
	 private String cast;
	 
	 private String releaseDate;

	 public Movie()
	 {
		 
	 }
	 
	

	public Movie(long id, long movieId, String movieName, String director, String cast, String releaseDate) {
		super();
		this.id = id;
		this.movieId = movieId;
		this.movieName = movieName;
		this.director = director;
		this.cast = cast;
		this.releaseDate = releaseDate;
	}



	public long getMovieId() {
		return movieId;
	}



	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cast == null) ? 0 : cast.hashCode());
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((movieName == null) ? 0 : movieName.hashCode());
		result = prime * result + ((releaseDate == null) ? 0 : releaseDate.hashCode());
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
		Movie other = (Movie) obj;
		if (cast == null) {
			if (other.cast != null)
				return false;
		} else if (!cast.equals(other.cast))
			return false;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		if (id != other.id)
			return false;
		if (movieName == null) {
			if (other.movieName != null)
				return false;
		} else if (!movieName.equals(other.movieName))
			return false;
		if (releaseDate == null) {
			if (other.releaseDate != null)
				return false;
		} else if (!releaseDate.equals(other.releaseDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", movieName=" + movieName + ", director=" + director + ", cast=" + cast
				+ ", releaseDate=" + releaseDate + "]";
	}
	 
	 
	
}
