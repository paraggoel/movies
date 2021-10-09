package com.parag.movie.service;

import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.parag.movie.entity.Movie;
import com.parag.movie.repository.MovieRepository;

@Service
public class MovieService {

  @Autowired
  private MovieRepository movieRepository;
  
  public List<Movie> getAllMovies() {
		Spliterator<Movie> itr =  movieRepository.findAll().spliterator();
		return StreamSupport.stream(itr, false).collect(Collectors.toList());
  }
  
  public Movie getMovieById(long id) throws Exception {
		Optional<Movie> movieOpt = movieRepository.findById(id);
		if(movieOpt.isPresent()) {
			return movieOpt.get();
		}else {
			 new Exception("User Not found with id "+id);
		}
		return movieOpt.get();
	}
	
	public void deleteMovie(@PathVariable long id) {
		movieRepository.deleteById(id);
	}
	
	public Movie createMovie(@RequestBody Movie movie) {
		Movie savedMovie = movieRepository.save(movie);
		return savedMovie;
	}
	
	public Movie updateMovie(@RequestBody Movie body, @PathVariable long id) {
		Optional<Movie> movieOptional = movieRepository.findById(id);
		Movie movie = null;
		if (movieOptional.isPresent()) {
			movieRepository.save(body);
			movie = movieOptional.get();
		}
	    return movie;
	}
}
