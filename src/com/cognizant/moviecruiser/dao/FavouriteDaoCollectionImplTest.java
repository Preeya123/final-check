package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Favourite;
import com.cognizant.moviecruiser.model.Movie;

public class FavouriteDaoCollectionImplTest {

	public static void main(String[] args) throws FavouriteEmptyException {
		testGetAllFavourite();
		testAddFavouritelist();
		testRemoveFavourite();
		

	}

	public static void testAddFavouritelist() throws FavouriteEmptyException {
		FavouriteDao favouriteDao = new FavouriteDaoCollectionImpl();
		long totalGross = 01;
		favouriteDao.addFavouriteList(1, 2l);
		favouriteDao.addFavouriteList(1, 5l);
		favouriteDao.addFavouriteList(2, 3l);
		List<Movie> movieListCustomer = favouriteDao.getAllFavouriteList(1);
		System.out.println("Added to Favourite List");
		for (Movie movie : movieListCustomer) {
			System.out.println(movie);
			totalGross += movie.getBoxOffice();

		}

	}

	public static void testRemoveFavourite() throws FavouriteEmptyException {
		FavouriteDao favouriteDao = new FavouriteDaoCollectionImpl();
		try {
		List<Movie> movieListCustomer = favouriteDao.getAllFavouriteList(1);
		System.out.println("After Removed from Favourites");
		for (Movie movies : movieListCustomer) {
			System.out.println(movies);
			long totalGross = movies.getBoxOffice();
		}
		}catch (Exception e) {
			e.getMessage();
		}

	}

	public static void testGetAllFavourite() throws FavouriteEmptyException {
		FavouriteDao favouriteDao = new FavouriteDaoCollectionImpl();
		try {
		List<Movie> movieListCustomer = favouriteDao.getAllFavouriteList(1);
		System.out.println("All Favourite movie");
		for (Movie movie : movieListCustomer) {
			System.out.println(movie);
		}
		}catch (Exception e) {
			e.getMessage();
			}
		}
	}

