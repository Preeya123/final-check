package com.cognizant.moviecruiser.model;

import java.util.ArrayList;
import java.util.List;

public class Favourite {
	private List<Movie> movieList;
	private long noofFavourite;

	public Favourite() {
		super();
		movieList = new ArrayList<>();
	}

	public Favourite(List<Movie> movieList, long noofFavourite) {
		super();
		this.movieList = movieList;
		this.noofFavourite = noofFavourite;
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	public long getNoofFavourite() {
		return noofFavourite;
	}

	public void setNoofFavourite(long noofFavourite) {
		this.noofFavourite = noofFavourite;
	}

}
