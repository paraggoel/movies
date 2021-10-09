package com.parag.movie.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.parag.movie.entity.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
	
}
