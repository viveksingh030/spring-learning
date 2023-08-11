package com.visher.spring.data.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="athletes") //change the path
public interface PlayerRepository extends JpaRepository<Player, Integer> {

}