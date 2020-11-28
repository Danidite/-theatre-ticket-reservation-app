import Controller.TheatreProgram;
import Domain.Database;

public class TheatreServerApp {
	private Database database;
	private TheatreProgram prog;
	
	TheatreServerApp() {
		database = Database.getInstance();
		prog = new TheatreProgram(database);
	}
	
	public void startApp()
	{
		
	}
	
	public static void main(String[] args) {
		TheatreServerApp serverApp = new TheatreServerApp();
		
	}

}
