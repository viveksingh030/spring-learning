package com.visher.spring.aop.repo;

import org.springframework.stereotype.Repository;

@Repository
public class User {
	
	public String getUserDetails() {
		return "user details";		
	}
}