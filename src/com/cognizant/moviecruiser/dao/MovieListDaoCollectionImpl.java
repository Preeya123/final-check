package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieListDaoCollectionImpl implements MovieDao {
	private static List<Movie> movieList;

	public MovieListDaoCollectionImpl() throws ParseException {
		super();
		if (movieList == null) {
			movieList = new ArrayList<>();
			movieList.add(new Movie(1L, "Avatar", 2787965087L, true, DateUtil.convertToDate("15/03/2017"),
					"Science Fiction", true));
			movieList.add(new Movie(2L, "The Avengers", 1518812988L, true, DateUtil.convertToDate("23/12/2017"),
					"Superhero", false));
			movieList.add(new Movie(3L, "Titanic", 2187463944L, true, DateUtil.convertToDate("21/08/2017"), "Romance",
					false));
			movieList.add(new Movie(4L, "Jurassic World", 1671713208L, false, DateUtil.convertToDate("02/07/2017"),
					"Science Fiction", true));
			movieList.add(new Movie(5L, "Avengers:End Game", 2750760348L, true, DateUtil.convertToDate("02/11/2022"),
					"Superhero", true));

		}
	}

	@Override
	public List<Movie> getMovieListAdmin() {

		return movieList;
	}

	@Override
	public List<Movie> getMovieCustomer() {
		ArrayList<Movie> newMovies = new ArrayList<Movie>();
		Date today=new Date();
		for (Movie movie : movieList) {
			if (movie.getDateOfLaunch().before(today)) {
				newMovies.add(movie);
			}
		}
		return newMovies;
	}

	@Override
	public void modifyMovie(Movie movie) {
		Movie x = getMovie(movie.getId());
		x.setTitle(movie.getTitle());
		x.setBoxOffice(movie.getBoxOffice());
		x.setActive(movie.isActive());
		x.setDateOfLaunch(movie.getDateOfLaunch());
		x.setGenre(movie.getGenre());
		x.setHasTeaser(movie.isHasTeaser());
	}

	@Override
	public Movie getMovie(long movieId) {
		for (Movie movie : movieList) {
			if (movie.getId() == movieId) {
				return movie;
			}
		}
		return null;
	}
}
