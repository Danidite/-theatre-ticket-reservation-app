package Presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.MenuController;

public class LoginMenuGUI {
	private JButton login;
	private JButton cancel;
	private JPanel masterPanel;
	private JPanel north;
	private JPanel south;
	private JPanel centre;
	private JFrame frame;
	private JTextField username;
	private JTextField password;
	private LoginListener listener;

	/**
	 * for second gui
	 * @author Nicho
	 *
	 */
	public class LoginListener implements ActionListener{
	
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == login) {
				MenuController.loginMenuLoginButtonPressed(username.getText(), password.getText());
				getFrame().dispatchEvent(new WindowEvent(getFrame(), WindowEvent.WINDOW_CLOSING));
			} else if(e.getSource() == cancel) {
				MenuController.loginMenuCancelButtonPressed();
				getFrame().dispatchEvent(new WindowEvent(getFrame(), WindowEvent.WINDOW_CLOSING));
			}
		}
	}
	
	
	public LoginMenuGUI() {

		listener = new LoginListener();
		
		login = new JButton("login");
		cancel = new JButton("Cancel");

		login.addActionListener(listener);
		cancel.addActionListener(listener);

		JLabel a = new JLabel("Please fill out fields");
		JLabel b = new JLabel("username");
		JLabel c = new JLabel("password");

		username = new JTextField(30);
		password = new JTextField(30);

		frame = new JFrame();
		frame.setSize(350,200);
		frame.setTitle("login");
		
		masterPanel = new JPanel();
		masterPanel.setLayout(new BorderLayout());

		north = new JPanel();
		north.setLayout(new FlowLayout());

		centre = new JPanel();
		centre.setLayout(new FlowLayout());

		south = new JPanel();
		south.setLayout(new FlowLayout());

		north.add(a);

		centre.add(b);
		centre.add(username);

		centre.add(c);
		centre.add(password);

		south.add(login);
		south.add(cancel);


		masterPanel.add(north, BorderLayout.PAGE_START);
		masterPanel.add(centre, BorderLayout.CENTER);
		masterPanel.add(south, BorderLayout.PAGE_END);

		frame.setContentPane(masterPanel);
		frame.setVisible(true);
		
		ImageIcon image = new ImageIcon("src/MoviesJavaApp.png");		//create an image icon
		frame.setIconImage(image.getImage()); 						//set GUI logo to image created above

	}


	
	//getters and setters --------------------------------------------------
	public JButton getCancel() {
		return cancel;
	}

	public void setCancel(JButton cancel) {
		this.cancel = cancel;
	}

	public JPanel getMasterPanel() {
		return masterPanel;
	}

	public void setMasterPanel(JPanel masterPanel) {
		this.masterPanel = masterPanel;
	}

	public JPanel getNorth() {
		return north;
	}

	public void setNorth(JPanel north) {
		this.north = north;
	}

	public JPanel getSouth() {
		return south;
	}

	public void setSouth(JPanel south) {
		this.south = south;
	}

	public JPanel getCentre() {
		return centre;
	}

	public void setCentre(JPanel centre) {
		this.centre = centre;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getUsername() {
		return username;
	}



	public JTextField getPassword() {
		return password;
	}

}
