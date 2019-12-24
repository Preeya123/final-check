package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public interface FavouriteDao {
	public void addFavouriteList(long userId, long movieId);

	public List<Movie> getAllFavouriteList(long userId) throws FavouriteEmptyException;

	public void removeFavouiteList(long userId, long MovieList);
}
