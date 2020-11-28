package Controller;

import java.util.ArrayList;

import Domain.*;

public class TheatreProgram {
	private Database database;
	
	public TheatreProgram(Database database) {
		this.database = database;
	}
	
	/**
	 * Return the list of movie
	 * 
	 * @return
	 */
	public ArrayList<Movie> getMovieList() {
		return database.getMovieList();
	}
	
	/**
	 * Add a movie to the database, return false if a movie of that name already exist
	 * @param movie
	 * @return
	 */
	public boolean addMovie(Movie movie) {
		if (database.addMovie(movie.getMovieName(), movie.getReleaseYear(), movie.getReleaseMonth(), movie.getReleaseDay(), movie.getMovieDescription()) == true) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Add a theatre to the database, return false if a theatre of that name already exist
	 * @param theatre
	 * @return
	 */
	public boolean addTheatre(Theatre theatre) {
		if (database.addThreater(theatre.getTheatreName(), theatre.getTheatreAddress())) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean addRegister(Register register) {
		if (database.addRegister(register.getMovie().getMovieID(), register.getTheatre().getTheatreID(), register.getPrice(), register.getSeatRow(), register.getSeatColumn(), register.getShowYear(), register.getShowMonth(), register.getShowDay(), register.getShowHour(), register.getAnnouncementYear(), register.getAnnouncementMonth(), register.getAnnouncementDay())) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
