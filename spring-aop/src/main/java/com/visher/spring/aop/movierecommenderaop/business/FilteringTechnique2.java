package com.visher.spring.aop.movierecommenderaop.business;

import com.visher.spring.aop.annotation.MeasureTime;
import com.visher.spring.aop.repo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilteringTechnique2 {

	@Autowired
	private User user;
	@MeasureTime
	public String collaborativeFiltering() {
		String userDetails =  user.getUserDetails();
		return userDetails;
	}
}