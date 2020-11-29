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
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.MenuController;
import Presentation.LoginMenuGUI.LoginListener;

public class SignupGUI {
	private JButton signup;
	private JButton cancel;
	private JPanel masterPanel;
	private JPanel north;
	private JPanel south;
	private JPanel centre;
	private JFrame frame;
	private JTextField username;
	private JTextField password;
	private SignupListener listener;
	
	public class SignupListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == signup) {
				MenuController.SignUPButtonPressed(username.getText(), password.getText());
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			} else if(e.getSource() == cancel) {
				MenuController.SignUpCancelButtonPressed();
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		}
	}
	
	public SignupGUI() {

		listener = new SignupListener();
		
		signup = new JButton("Sign up");
		cancel = new JButton("Cancel");

		signup.addActionListener(listener);
		cancel.addActionListener(listener);

		JLabel a = new JLabel("Please fill out fields");
		JLabel b = new JLabel("username");
		JLabel c = new JLabel("password");

		username = new JTextField(30);
		password = new JTextField(30);

		frame = new JFrame();
		frame.setSize(350,200);
		frame.setTitle("signup");
		
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

		south.add(signup);
		south.add(cancel);


		masterPanel.add(north, BorderLayout.PAGE_START);
		masterPanel.add(centre, BorderLayout.CENTER);
		masterPanel.add(south, BorderLayout.PAGE_END);

		frame.setContentPane(masterPanel);
		frame.setVisible(true);
		
		ImageIcon image = new ImageIcon("src/MoviesJavaApp.png");		//create an image icon
		frame.setIconImage(image.getImage()); 						//set GUI logo to image created above

	}
}
