package Controller;

import javax.swing.JOptionPane;

import Domain.*;
import Presentation.*;

public class MenuController {
	static TheatreProgram prog = TheatreProgram.getInstance();

	//RegisteredUserMenuGUI functions-----------------------------------------------------
	public static void RegisteredUserViewReservationsButtonPressed() {
		// Some gui to give info
	}
	
	public static void RegisteredUserBookReservationButtonPressed() {
		new SelectMovieGUI();
	}
	
	public static void RegisteredUserCancelReservationButtonPressed() {
		new CancelReservationGUI();
	}
	
	public static void RegisteredUserPaySubscriptionButtonPressed() {
		
		
	}
	
	public static void RegisteredUserViewNewsButtonPressed() {
		
	}
	
	public static void RegisteredUserLogoutButtonPressed() {
		prog.logout();
		new GuestMenuGUI();
	}
	
	//signUpGUI functions------------------------------------------------------------
	public static void SignUPButtonPressed(String username, String password) {
		System.out.println("signup Pressed");
		if (prog.signUp("Username", "password", new Name(null, null, null), new Payment(null, null, null, null, 0, 0, 0, 0)) == true) {
			JOptionPane.showMessageDialog(null, "Account successfully created! Try to login with it!", "Success", JOptionPane.INFORMATION_MESSAGE);
			backToMenu();
		} else {
			JOptionPane.showMessageDialog(null, "Username was alread used! Try again!", "Error", JOptionPane.ERROR_MESSAGE);
			new SignupGUI();
		}
	}
	
	public static void SignUpCancelButtonPressed() {
		System.out.println("Cancel pressed");
		backToMenu();
	}
	
	//CancelReservationGUI Functions------------------------------------------------
	public static void CancelReservationGUIcancelReservationPressed(String reservationID) {
		System.out.println("cancel reservation pressed");
	}
	
	public static void CancelReservationGUICancelButtonPressed() {
		System.out.println("cancel");
		backToMenu();
	}
	
	//SelectSeatGUI functions--------------------------------------------------------
	public static void selectSeatGUISelectSeatButtonPressed(String seatRow, String seatCol) {
		System.out.println("select seat pressed");
		
		
		
	}
	
	public static void selectSeatGUICancelButtonPressed() {
		System.out.println("cancel pressed");
		backToMenu();
	}
	
	//SelectTheatreGUI functions--------------------------------------------------------
	public static void selectTheatreGUISelectTheatreButtonPressed(String theatreID) {
		System.out.println("select theatre pressed");
		System.out.println(theatreID);
		new SelectSeatGUI();
	}
	
	public static void selectTheatreGUICancelButtonPressed() {
		System.out.println("cancel pressed");
		backToMenu();
	}
	
	//SelectMovieGUI functions--------------------------------------------------------
	public static void selectMovieGUISelectMovieButtonPressed(String movieName) {
		System.out.println("select movie pressed");
		System.out.println(movieName);
		new SelectTheatreGUI();
	}
	
	public static void selectMovieGUICancelButtonPressed() {
		System.out.println("cancel pressed");
		backToMenu();
	}
	
	//guestMenuGUI functions--------------------------------------------------------
	public static void guestMenuBookReservationButtonPressed() {
		System.out.println("book reservation pressed");
		new SelectMovieGUI();
	}
	
	public static void guestMenuCancelReservationButtonPressed() {
		System.out.println("cancel Reservation pressed");
		new CancelReservationGUI();
	}
	
	public static void guestMenuLoginButtonPressed() {
		System.out.println("login pressed");
		new LoginMenuGUI();
	}
	
	public static void guestMenuSignUpButtonPressed() {
		System.out.println("sign up pressed");
		
		new SignupGUI();
	}
	
	public static void guestMenuExitButtonPressed() {
		System.out.println("exit pressed");
		prog.exitProgram();
	}
	
	//LoginMenuGUI functions--------------------------------------------------------
	public static void loginMenuLoginButtonPressed(String username, String password) {
		System.out.println("login Pressed");
		String newUsername = prog.login(username, password);
		
		if (newUsername == null) {
			JOptionPane.showMessageDialog(null, "Username or Password are incorrect!", "Error", JOptionPane.ERROR_MESSAGE);
			new GuestMenuGUI();
		} else if (prog.getLoginStatus() == 1) {
			// Registered User
			JOptionPane.showMessageDialog(null, "Success fully logged on! Welcome: \""+newUsername+"\"", "Success", JOptionPane.INFORMATION_MESSAGE);
			new RegisteredUserMenuGUI();
		} else if (prog.getLoginStatus() == 2) {
			// Admin
			JOptionPane.showMessageDialog(null, "Success fully logged on to admin", "Success", JOptionPane.INFORMATION_MESSAGE);
//			new AdminMenuGUI();
		}
		
	}
	
	public static void loginMenuCancelButtonPressed() {
		System.out.println("Cancel pressed");
		new GuestMenuGUI();
	}
	
	public static void backToMenu() {
		if (prog.getLoginStatus() == 0) {
			new GuestMenuGUI();
		} else if (prog.getLoginStatus() == 1) {
			// Registered User
			new RegisteredUserMenuGUI();
		} else if (prog.getLoginStatus() == 2) {
			// Admin 
//			new AdminMenuGUI();
		}
	}
	
	
	
	
	
	
	
	
	
	//Initial Menu Functions----------------------------------------------- (Deprecated)
	public static void initialMenuloginButtonPressed(){
		System.out.println("loginButtonPressed");
		new LoginMenuGUI();
	}
	
	public static void initialMenuguestButtonPressed() {
		System.out.println("guestButtonPressed");
		new GuestMenuGUI();
	}
	
	public static void initialMenuExitButtonPressed() {
		System.out.println("exit pressed");
		System.exit(0);
	}
}
