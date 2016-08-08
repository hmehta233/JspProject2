package com.bitwise.model;

import java.util.ArrayList;

public class Movies {
	ArrayList<Movie> movies = new ArrayList<Movie>();

	public void addMovie(Movie movie) {
		if (movies.size() != 3) {
			movies.add(movie);
		}
	}

	public void removeMovie(Movie movie) {
		movies.remove(movie);
	}

	public ArrayList<Movie> getMovies() {
		return this.movies;
	}

}
