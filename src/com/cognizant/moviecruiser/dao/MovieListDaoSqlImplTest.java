package com.cognizant.moviecruiser.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieListDaoSqlImplTest {
	public static void main(String args[]) throws ParseException, SQLException {
		testGetMovieListAdmin();
		testGetMovieListCustomer();
		testModifyMovie();
		System.out.println("After Modify");
		testGetMovieListAdmin();
	}

	public static void testGetMovieListAdmin() throws ParseException, SQLException {
		MovieDao movieDao = new MovieListDaoSqlImpl();
		List<Movie> movieList = movieDao.getMovieListAdmin();
		for (Movie movie : movieList) {
			System.out.println(movie);
		}

	}

	public static void testGetMovieListCustomer() throws ParseException, SQLException {
		MovieDao movieDao = new MovieListDaoSqlImpl();
		List<Movie> movieList = movieDao.getMovieCustomer();
		for (Movie movie : movieList) {
			System.out.println(movie);
		}

	}

	public static void testModifyMovie() throws ParseException, SQLException {
		Movie item = new Movie(4l, "Stree", 64825846, true, DateUtil.convertToDate("23/03/2019"), "Haunted", true);
		MovieDao movieDao = new MovieListDaoSqlImpl();
		movieDao.modifyMovie(item);
		System.out.println();
		Movie modifyMovie = movieDao.getMovie(item.getId());
	}

}

