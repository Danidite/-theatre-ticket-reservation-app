package Presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Presentation.InitialMenuGUI.InitialMenuListener;

public class guestMenuGUI {
	private JFrame frame;
	private JPanel southPanel = new JPanel();
	private JPanel masterPanel = new JPanel();
	
	private JButton signUpButton = new JButton("Sign Up");
	private JButton loginButton = new JButton("Login");
	private JButton cancelReservationButton = new JButton("Cancel Reservation");
	private JButton bookReservationButton = new JButton("Book Reservation");
	private JButton exitButton = new JButton("Exit");
	
	private JTextArea theText;
	private JScrollPane scroll;
	private guestMenuListener listener;
	
	class guestMenuListener implements ActionListener{
	
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
		
	
	
	guestMenuGUI(){
		//add listner
		listener = new guestMenuListener();
		bookReservationButton.addActionListener(listener);
		cancelReservationButton.addActionListener(listener);
		loginButton.addActionListener(listener);
		signUpButton.addActionListener(listener);
		exitButton.addActionListener(listener);
		
		//create GUI
		frame = new JFrame();
		frame.setTitle("Guest Menu");
		
		frame.setResizable(false); 		//user can't resize GUI on their own
		frame.setSize(800,200);			//set size of this
		southPanel.setLayout(new FlowLayout());
		southPanel.add(bookReservationButton);
		southPanel.add(cancelReservationButton);
		southPanel.add(loginButton);
		southPanel.add(signUpButton);
		southPanel.add(exitButton);
		
		theText = new JTextArea();
		scroll = new JScrollPane(theText);
		
		masterPanel.setLayout(new BorderLayout());
		
		masterPanel.add(southPanel, BorderLayout.PAGE_END);
		masterPanel.add(scroll,BorderLayout.CENTER);
		
		frame.add(masterPanel);
		frame.setVisible(true); 		//make this visible
		
		ImageIcon image = new ImageIcon("src/MoviesJavaApp.png");		//create an image icon
		frame.setIconImage(image.getImage()); 	
		
		
		
		
		theText.setText("Apples\n\n\n\n\n\n\n\n apples \n\n\n\n\n\n\n\n\n\n apples \n\n\n\n\n\n\n\n\n apples");
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	
	
}
