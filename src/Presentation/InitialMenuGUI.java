package Presentation;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.MenuController;

public class InitialMenuGUI{
	
	private JFrame frame;
	private JButton loginButton = new JButton("Login");
	private JButton guestButton = new JButton("Guest");
	private JButton exitButton = new JButton("Exit");
	private JPanel mainPanel = new JPanel();
	private FlowLayout layout = new FlowLayout();
	private InitialMenuListener listener;
	
	
	/**
	 * for when button pressed
	 * @author Nicho
	 *
	 */
	class InitialMenuListener implements ActionListener{
		
		public InitialMenuListener() {
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == exitButton) {
				MenuController.initialMenuExitButtonPressed();
			} else if(e.getSource() == guestButton) {
				MenuController.initialMenuguestButtonPressed();
				getFrame().dispatchEvent(new WindowEvent(getFrame(), WindowEvent.WINDOW_CLOSING));
				
			} else if(e.getSource() == loginButton) {
				MenuController.initialMenuloginButtonPressed();
				getFrame().dispatchEvent(new WindowEvent(getFrame(), WindowEvent.WINDOW_CLOSING));
			}
		}
		
	}
	
	public InitialMenuGUI(){
		showInitialMenu();
		listener = new InitialMenuListener();
		exitButton.addActionListener(listener);
		guestButton.addActionListener(listener);
		loginButton.addActionListener(listener);
	}
	
	void showInitialMenu() {
		frame = new JFrame();
		frame.setTitle("Initial Menu");
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 		//when x clicked nothing happens
		frame.setResizable(false); 		//user can't resize GUI on their own
		frame.setSize(500,200);			//set size of this
		mainPanel.setLayout(layout);
		mainPanel.add(loginButton);
		mainPanel.add(guestButton);
		mainPanel.add(exitButton);
		frame.add(mainPanel);
		frame.setVisible(true); 		//make this visible
		
		ImageIcon image = new ImageIcon("src/MoviesJavaApp.png");		//create an image icon
		frame.setIconImage(image.getImage()); 						//set GUI logo to image created above
	}
		
	
	
	
	//getters and setters -------------------------------------
	
	public JButton getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(JButton loginButton) {
		this.loginButton = loginButton;
	}

	public JButton getGuestButton() {
		return guestButton;
	}

	public void setGuestButton(JButton guestButton) {
		this.guestButton = guestButton;
	}

	public JButton getExitButton() {
		return exitButton;
	}

	public void setExitButton(JButton exitButton) {
		this.exitButton = exitButton;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public FlowLayout getLayout() {
		return layout;
	}

	public void setLayout(FlowLayout layout) {
		this.layout = layout;
	}

	public InitialMenuListener getListener() {
		return listener;
	}

	public void setListener(InitialMenuListener listener) {
		this.listener = listener;
	}
	
	public JFrame getFrame() {
		return frame;
	}

	
}
