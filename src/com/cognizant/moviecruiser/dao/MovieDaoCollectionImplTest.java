package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieDaoCollectionImplTest {
	public static void main(String args[]) throws ParseException {
		testGetMovieListAdmin();
		testGetMovieListCustomer();
		testModifyMovie();
		System.out.println("After Modify");
		testGetMovieListAdmin();
	}

	public static void testGetMovieListAdmin() throws ParseException {
		MovieDao movieDao = new MovieListDaoCollectionImpl();
		List<Movie> movieList = movieDao.getMovieListAdmin();
		for (Movie movie : movieList) {
			System.out.println(movie);
		}

	}

	public static void testGetMovieListCustomer() throws ParseException {
		MovieDao movieDao = new MovieListDaoCollectionImpl();
		List<Movie> movieList = movieDao.getMovieCustomer();
		for (Movie movie : movieList) {
			System.out.println(movie);
		}

	}

	public static void testModifyMovie() throws ParseException {
		Movie item = new Movie(4l, "Stree", 64825846, true, DateUtil.convertToDate("23/03/2019"), "Haunted", true);
		MovieDao movieDao = new MovieListDaoCollectionImpl();
		movieDao.modifyMovie(item);
		System.out.println();
		Movie modifyMovie = movieDao.getMovie(item.getId());
	}

}
