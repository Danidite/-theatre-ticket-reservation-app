package Controller;

import Presentation.LoginMenuGUI;

public class MenuController {

	
	//guestMenuGUI functions--------------------------------------------------------
	public static void bookReservationButtonPressed() {
		
	}
	
	//LoginMenuGUI functions--------------------------------------------------------
	public static void loginMenuLoginButtonPressed(String username, String password) {
		System.out.println("login Pressed");
		System.out.println(username+ password);
		new LoginMenuGUI();
	}
	
	public static void loginMenuCancelButtonPressed() {
		System.out.println("Cancel pressed");
	}
	
	
	//Initial Menu Functions-----------------------------------------------
	public static void initialMenuloginButtonPressed(){
		System.out.println("loginButtonPressed");
	}
	
	public static void initialMenuguestButtonPressed() {
		System.out.println("guestButtonPressed");
	}
	
	public static void initialMenuExitButtonPressed() {
		System.out.println("exit pressed");
		System.exit(0);
	}
	
}
