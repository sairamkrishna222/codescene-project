package com.srk.moviereview.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srk.moviereview.bean.MovieRating;

@Repository
public interface MovieReviewRepo extends JpaRepository<MovieRating, Long> {

	List<MovieRating> findByMovieId(long id);

	List<MovieRating> findByUserId(long userId);

}
