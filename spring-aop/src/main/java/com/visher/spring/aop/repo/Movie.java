package com.visher.spring.aop.repo;

import org.springframework.stereotype.Repository;

@Repository
public class Movie {

	public String getMovieDetails() {
		return "movie details";		
	}
}