package com.cognizant.moviecruiser.dao;

import java.sql.SQLException;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public interface MovieDao {
	public List<Movie> getMovieListAdmin() throws SQLException;

	public List<Movie> getMovieCustomer() throws SQLException;

	public void modifyMovie(Movie movie) throws SQLException;

	public Movie getMovie(long movieId);
}
