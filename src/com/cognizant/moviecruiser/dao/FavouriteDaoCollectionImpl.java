package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.moviecruiser.model.Favourite;
import com.cognizant.moviecruiser.model.Movie;

public class FavouriteDaoCollectionImpl implements FavouriteDao {
	private static HashMap<Long, Favourite> userFavourite;

	public FavouriteDaoCollectionImpl() {
		super();
		if (userFavourite == null) {
			userFavourite = new HashMap<>();
			userFavourite.put(1L,new Favourite());
		}
	}

	public void addFavouriteList(long userId, long movieListId) {
		try {
			MovieDao movieDao = new MovieListDaoCollectionImpl();
			Movie movies = movieDao.getMovie(movieListId);
			if (userFavourite.containsKey(userId)) {
				userFavourite.get(userId).getMovieList().add(movies);
			} else {
				Favourite fav = new Favourite();
				ArrayList<Movie> movieList = new ArrayList<>();
				movieList.add(movies);
				fav.setMovieList(movieList);
				userFavourite.put(userId, fav);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void removeFavouiteList(long userId, long MovieList) {
		List<Movie> movieList = userFavourite.get(userId).getMovieList();
		for (int i = 0; i < movieList.size(); i++) {
			movieList.remove(i);
			return;
		}
	}

	@Override
	public List<Movie> getAllFavouriteList(long userId) throws FavouriteEmptyException {
		long noOfFav = 0;
		List<Movie> movieList = userFavourite.get(userId).getMovieList();
		Favourite fav = userFavourite.get(userId);
		if (fav == null || movieList.isEmpty()) {
			try {
				throw new FavouriteEmptyException();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			for (Movie x : movieList) {
				noOfFav = noOfFav + x.getBoxOffice();
			}
		}
		return movieList;

	}
}
