package com.parag.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parag.movie.entity.Movie;
import com.parag.movie.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	@Autowired
	private MovieService service;
	
	@GetMapping("/")
	public List<Movie> getAllMovies() {
		return service.getAllMovies();
	}
	
	@GetMapping("/{id}")
	public Movie getMovieById(@PathVariable long id) throws Exception {
		return service.getMovieById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteMovie(@PathVariable long id) {
		service.deleteMovie(id);
	}
	
	
	@PostMapping
	public Movie createMovie(@RequestBody Movie movie) {
		Movie savedMovie = service.createMovie(movie);
		return savedMovie;
	}
	
	
	@PutMapping("/{id}")
	public Movie updateMovie(@RequestBody Movie body, @PathVariable long id) {
		return service.updateMovie(body, id);
		
	}
}
