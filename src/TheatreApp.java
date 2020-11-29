import Controller.TheatreProgram;
import Domain.Database;
import Presentation.InitialMenuGUI;

public class TheatreApp {
	private Database database;
	private TheatreProgram prog;
	
	TheatreApp() {
		database = Database.getInstance();
		prog = new TheatreProgram(database);
	}
	
	public void startApp()
	{
		new InitialMenuGUI();
	}
	
	public static void main(String[] args) {
		TheatreApp serverApp = new TheatreApp();
		serverApp.startApp();
	}
}
