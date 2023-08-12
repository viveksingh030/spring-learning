package com.visher.spring.aop.movierecommenderaop.business;

import com.visher.spring.aop.annotation.MeasureTime;
import com.visher.spring.aop.repo.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilteringTechnique1 {

    @Autowired
    private Movie movie;

    @MeasureTime
    public String contentBasedFiltering() {
        String movieDetails = movie.getMovieDetails();
        return movieDetails;
    }
}