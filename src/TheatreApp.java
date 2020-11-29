import Presentation.GuestMenuGUI;

public class TheatreApp {
//	private Database database;
//	private TheatreProgram prog;
//	
//	TheatreApp() {
////		database = Database.getInstance();
////		prog = new TheatreProgram(database);
//		prog = TheatreProgram.getInstance();
//	}
//	
	public void startApp()
	{
		new GuestMenuGUI();
	}
	
	public static void main(String[] args) {
		TheatreApp app = new TheatreApp();
		app.startApp();
	}
}
