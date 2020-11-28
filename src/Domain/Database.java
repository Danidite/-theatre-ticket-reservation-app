package Domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * Singleton class
 * @author 10993
 *
 */
public class Database {
	private ArrayList<User> userList;
	private ArrayList<News> newsList;
	private ArrayList<Reservation> reservationList;
	private ArrayList<Movie> movieList;
	private ArrayList<Register> registerList;
	private ArrayList<Theatre> theatreList;
	private ArrayList<Voucher> voucherList;
	
	private static Database database_instance = null; 
	
	/**
	 * static method to create instance of Singleton class 
	 * @return
	 */
    public static Database getInstance() 
    { 
        if (database_instance == null) 
        	database_instance = new Database(); 
  
        return database_instance; 
    }
	
	Database() {
		userList = new ArrayList<User>();
		newsList = new ArrayList<News>();
		reservationList = new ArrayList<Reservation>();
		movieList = new ArrayList<Movie>();
		registerList = new ArrayList<Register>();
		theatreList = new ArrayList<Theatre>();
		voucherList = new ArrayList<Voucher>();
	}
	
	/**
	 * Load data from online database
	 */
	public void loadFromDatabase() {
		// Clear the database first
		userList = new ArrayList<User>();
		newsList = new ArrayList<News>();
		reservationList = new ArrayList<Reservation>();
		movieList = new ArrayList<Movie>();
		registerList = new ArrayList<Register>();
		theatreList = new ArrayList<Theatre>();
		voucherList = new ArrayList<Voucher>();
		
		// LOAD data from online database
	}
	
	/**
	 * Save data to database
	 */
	public void saveToDatabase() {
		// SAVE data to online database
		
	}
	
	/**
	 * Return the registers of an movie, return null if no movie can be found
	 * @param movieID
	 * @return
	 */
	public ArrayList<Register> getRegisterListByMovieID(String movieID) {
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getMovieID().equals(movieID)) {
				return movieList.get(i).getRegisterList();
			}
		}
		return null;
	}
	
	
	/**
	 * Get register by ID, return null if cannot be found
	 * @param registerID
	 * @return
	 */
	public Register getRegisterByID(String registerID) {
		for (int i = 0; i < registerList.size(); i++) {
			if (registerList.get(i).getRegisterID().equals(registerID)) {
				return registerList.get(i);
			}
		}
		return null;
	}
	
	
	/**
	 * Create a register object
	 * @param movieID
	 * @param theatreID
	 * @param seatRow
	 * @param seatColumn
	 * @param showYear
	 * @param showMonth
	 * @param showDay
	 * @param showHour
	 * @param announcementYear
	 * @param announcementMonth
	 * @param announcementDay
	 * @return
	 */
	public boolean addRegister(String movieID, String theatreID, double price, int seatRow, int seatColumn, int showYear, int showMonth, int showDay, int showHour, int announcementYear, int announcementMonth, int announcementDay) {
		Movie movie = getMovieByID(movieID);
		Theatre theatre = getTheatreByID(theatreID);
		
		if(movie == null || theatre == null) {
			return false;
		}
		
		boolean earlyBooking = false;
		
		LocalDate today = LocalDate.now();
		LocalDate announcementDate = LocalDate.of(announcementYear, announcementMonth, announcementDay);
		
		
		// If announces in the future
		if (ChronoUnit.DAYS.between(today, announcementDate) > 0) {
			earlyBooking = true;
		}
		
		Register newRegister = new Register(movie, theatre, price, seatRow, seatColumn, earlyBooking, showYear, showMonth, showDay, showHour, announcementYear, announcementMonth, announcementDay);
		
		movie.addRegister(newRegister);
		
		registerList.add(newRegister);
		
		return true;
	}
	
	/**
	 * Create a theatre object, return false if already exist
	 * @param theatreName
	 * @param theatreAddress
	 * @return
	 */
	public boolean addThreater(String theatreName, String theatreAddress) {
		if (getTheatreByNameAndAddress(theatreName, theatreAddress) == null) {
			theatreList.add(new Theatre(theatreName, theatreAddress));
			return true;
		} else {
			return false;
		}
	}
	
	public Theatre getTheatreByNameAndAddress(String theatreName, String theatreAddress) {
		for (int i = 0; i < theatreList.size(); i++) {
			if (theatreList.get(i).getTheatreName().equals(theatreName)) {
				if (theatreList.get(i).getTheatreAddress().equals(theatreAddress)) {
					return theatreList.get(i);
				}
			}
		}
		return null;
	}
	
	public Theatre getTheatreByID(String theatreID) {
		for (int i = 0; i < theatreList.size(); i++) {
			if (theatreList.get(i).getTheatreID().equals(theatreID)) {
				return theatreList.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Create a movie object and add movie to the list
	 * @param movieName
	 * @param year
	 * @param month
	 * @param day
	 * @param movieDescription
	 * @return
	 */
	public boolean addMovie(String movieName, int year, int month, int day, String movieDescription) {
		if (getMovieByName(movieName) == null) {
			movieList.add(new Movie(movieName, year, month, day, movieDescription));
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Get movie by movie name
	 * @param movieName
	 * @return
	 */
	public Movie getMovieByName(String movieName) {
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getMovieName().equals(movieName)) {
				return movieList.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Return a movie with the argument ID, return null if cannot be found
	 * @param movieID
	 * @return
	 */
	public Movie getMovieByID(String movieID) {
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getMovieID().equals(movieID)) {
				return movieList.get(i);
			}
		}
		return null;
	}
	

	
	/**
	 * Remove register by ID, return true if successful, return false if it cannot be found
	 * @param registerID
	 * @return
	 */
	public boolean removeRegisterByID(String registerID) {
		for (int i = 0; i < registerList.size(); i++) {
			if (registerList.get(i).getRegisterID().equals(registerID)) {
				registerList.remove(i);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Add a new reservation and also return the reservation (Also occupy the seat)
	 * @param registerID
	 * @param seatRow
	 * @param seatColumn
	 * @param user
	 * @param paymentInfo
	 * @param isEarly
	 * @return
	 */
	public Reservation addReservation(String registerID, int seatRow, int seatColumn, RegisteredUser user, Payment paymentInfo, boolean isEarly) {
		Register currentRegister = getRegisterByID(registerID);
		
		String userID = null;
		if (user != null) {
			userID = user.getUserID();
		}
		
		// Create reservation
		Reservation reservation = new Reservation(seatRow, seatColumn, currentRegister, currentRegister.getPrice(), userID, paymentInfo);
		
		// Occupy Seat
		currentRegister.occupySeat(seatRow, seatColumn, isEarly);
		
		// Add to user
		if (user != null) {
			user.addReservation(reservation);
		}
		
		return reservation;
	}
	
	/**
	 * Get reservation by ID, return null otherwise
	 * @param reservationID
	 * @return
	 */
	public Reservation getReservationByID(String reservationID) {
		for (int i = 0; i < reservationList.size(); i++) {
			if (reservationList.get(i).getReservationID().equals(reservationID)) {
				return reservationList.get(i);
			}
		}
		
		return null;
	}
	
	/**
	 * Remove a reservation by ID
	 * @param reservationID
	 * @return
	 */
	public boolean removeReservationByID(String reservationID) {
		for (int i = 0; i < reservationList.size(); i++) {
			if (reservationList.get(i).getReservationID().equals(reservationID)) {
				reservationList.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Verify and return account
	 * @param username
	 * @param password
	 * @return
	 */
	public User verifyAccount(String username, String password) {
		User current = getUserWithUsername(username);
		if (current != null) {
			if (current.getPassword().equals(password)) {
				return current;
			}
		}
		
		return null;
	}
	
	/**
	 * Get user with username, return null otherwise
	 * @param username
	 * @return
	 */
	public User getUserWithUsername(String username) {
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUsername().equals(username)) {
				return userList.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Get user with userID, return null otherwise
	 * @param userID
	 * @return
	 */
	public User getUserByID(String userID) {
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUserID().equals(userID)) {
				return userList.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Sign up for new account, return null if fail
	 * @param userName
	 * @param password
	 * @param name
	 * @param paymentInfo
	 * @return
	 */
	public User signUp(String userName, String password, Name name, Payment paymentInfo) {
		if (getUserWithUsername(userName) == null) {
			User newUser = new RegisteredUser(userName, password, name, paymentInfo);
			userList.add(newUser);
			return newUser;
		}
		return null;
	}
	
	/**
	 * Create voucher and return that voucher
	 * @param amount
	 * @param user
	 * @return
	 */
	public Voucher addVoucher(double amount, RegisteredUser user) {
		Voucher newVoucher;
		if (user != null) {
			newVoucher = new Voucher(amount, user.getUserID());
			user.addVoucher(newVoucher);
		} else {
			newVoucher = new Voucher(amount, null);
		}
		return newVoucher;
	}
	
	/**
	 * Return voucher with ID
	 * @param voucherID
	 * @return
	 */
	public Voucher getVoucherByID(String voucherID) {
		for (int i = 0; i < voucherList.size(); i++) {
			if (voucherList.get(i).getVoucherID().equals(voucherID)) {
				return voucherList.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Remove voucher, return true if successful, false of voucher cannot be found
	 * @param voucherID
	 * @return
	 */
	public boolean removeVoucherByID(String voucherID) {
		for (int i = 0; i < voucherList.size(); i++) {
			if (voucherList.get(i).getVoucherID().equals(voucherID)) {
				voucherList.remove(i);
				return true;
			}
		}
		return false;
	}
	
	
	
	
	/*
	 * Getters and savvers
	 */
	public ArrayList<User> getUserList() {
		return userList;
	}
	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}
	public ArrayList<News> getNewsList() {
		return newsList;
	}
	public void setNewsList(ArrayList<News> newsList) {
		this.newsList = newsList;
	}
	public ArrayList<Reservation> getReservationList() {
		return reservationList;
	}
	public void setReservationList(ArrayList<Reservation> reservationList) {
		this.reservationList = reservationList;
	}
	public ArrayList<Movie> getMovieList() {
		return movieList;
	}
	public void setMovieList(ArrayList<Movie> movieList) {
		this.movieList = movieList;
	}
	public ArrayList<Register> getRegisterList() {
		return registerList;
	}
	public void setRegisterList(ArrayList<Register> registerList) {
		this.registerList = registerList;
	}
	public ArrayList<Theatre> getTheatreList() {
		return theatreList;
	}
	public void setTheatreList(ArrayList<Theatre> theatreList) {
		this.theatreList = theatreList;
	}
	public ArrayList<Voucher> getVoucherList() {
		return voucherList;
	}
	public void setVoucherList(ArrayList<Voucher> voucherList) {
		this.voucherList = voucherList;
	}
}
