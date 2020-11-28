package Domain;

public class Admin extends User {
	
	Admin(String username, String password) {
		super(username, password, true);
	}
}
