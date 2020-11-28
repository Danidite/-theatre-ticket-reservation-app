package Controller;

import java.util.ArrayList;

import Domain.*;

public class TheatreProgram {
	private Database database;
	private User currentUser;
	
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
	
	/**
	 * Add a register to database, return true if successful, false if fail
	 * @param register
	 * @return
	 */
	public boolean addRegister(Register register) {
		if (database.addRegister(register.getMovie().getMovieID(), register.getTheatre().getTheatreID(), register.getPrice(), register.getSeatRow(), register.getSeatColumn(), register.getShowYear(), register.getShowMonth(), register.getShowDay(), register.getShowHour(), register.getAnnouncementYear(), register.getAnnouncementMonth(), register.getAnnouncementDay())) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Create new user, return true if successful, false if not 
	 * @param user
	 * @return
	 */
	public boolean addUser(RegisteredUser user) {
		User newUser = database.signUp(user.getUsername(), user.getPassword(), user.getName(), user.getPaymentInfo());
		if (newUser != null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Login and replace user with the new specified user, also returns the username
	 * @param username
	 * @param password
	 * @return
	 */
	public String login(String username, String password) {
		User retrivedUser = database.verifyAccount(username, password);
		if (retrivedUser != null) {
			currentUser = retrivedUser;
			return currentUser.getUsername();
		} else {
			return null;
		}
	}
	
	/**
	 * Get login status 0 = not login, 1 = registered user, 2 = admin
	 * @return
	 */
	public int getLoginStatus() {
		if (currentUser != null) {
			return 0;
		} else if (currentUser.isAdmin() == false) {
			return 1;
		} else {
			return 2;
		}
	}
	
	/**
	 * Return the list of news
	 * @return
	 */
	public ArrayList<News> getNewsList() {
		return database.getNewsList();
	}
	
	/**
	 * Return reservation by id
	 * @param reservationID
	 * @return
	 */
	public Reservation getReservation(String reservationID) {
		return database.getReservationByID(reservationID);
	}
	
	/**
	 * Return the seat list if registerID found, return null otherwise
	 * @param RegisterID
	 * @return
	 */
	public char[][] getSeatList(String RegisterID) {
		return database.getSeatListByRegisterID(RegisterID);
	}
	
	/**
	 * Book a reservation and return registrationID if successful
	 * @param registerID
	 * @param seatRow
	 * @param seatColumn
	 * @param voucherID
	 * @param paymentInfo
	 * @return
	 */
	public String bookReservation(String registerID, int seatRow, int seatColumn, String voucherID, Payment paymentInfo) {
		return database.addReservation(registerID, seatRow, seatColumn, currentUser.getUserID(), voucherID, paymentInfo);
	}
	
	/**
	 * Cancel reservation, create a voucher and returns the voucher
	 * @param reservationID
	 * @return
	 */
	public Voucher cancelReservation(String reservationID) {
		Reservation reservation = database.getReservationByID(reservationID);
		double price = reservation.getTicket().getRegister().getPrice();
		if (database.removeReservationByID(reservationID) == true) {
			if (currentUser == null) {
				price *= 0.75;
			}
			return database.addVoucher(price, (RegisteredUser) currentUser);
		} else {
			return null;
		}
	}
	
	/**
	 * Return voucher, null if cannot be found
	 * @param voucherID
	 * @return
	 */
	public Voucher searchVoucher(String voucherID) {
		return database.getVoucherByID(voucherID);
	}
	
	
	
	
	
	
	// Getters and setters
	public User getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
}
