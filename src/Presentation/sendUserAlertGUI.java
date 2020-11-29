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
import Presentation.SelectMovieGUI.SelectMovieListener;

public class sendUserAlertGUI {
	private JButton cancelButton;
	private JLabel label1;
	private JPanel masterPanel;
	private JPanel north;
	private JPanel south;
	private JPanel centre;
	private JFrame frame;
	private SendUserAlertListener listener;

	public class SendUserAlertListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == cancelButton) {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			} 
		}
		
	}
	
	sendUserAlertGUI(){
		
		cancelButton = new JButton("Cancel");
		masterPanel = new JPanel();
		frame = new JFrame();
		label1 = new JLabel("Error!");
		listener = new SendUserAlertListener();
		
		
		cancelButton.addActionListener(listener);

		frame.setSize(350,200);
		frame.setTitle("Alert");
		
		masterPanel = new JPanel();
		masterPanel.setLayout(new BorderLayout());

		north = new JPanel();
		north.setLayout(new FlowLayout());

		centre = new JPanel();
		centre.setLayout(new FlowLayout());

		south = new JPanel();
		south.setLayout(new FlowLayout());

		centre.add(label1);

		


		
		south.add(cancelButton);


		masterPanel.add(north, BorderLayout.PAGE_START);
		masterPanel.add(centre, BorderLayout.CENTER);
		masterPanel.add(south, BorderLayout.PAGE_END);

		frame.setContentPane(masterPanel);
		frame.setVisible(true);
		
		ImageIcon image = new ImageIcon("src/MoviesJavaApp.png");		//create an image icon
		frame.setIconImage(image.getImage()); 	
	}
	
	sendUserAlertGUI(String alertMessage){
		
		cancelButton = new JButton("Cancel");
		masterPanel = new JPanel();
		frame = new JFrame();
		label1 = new JLabel(alertMessage);
		listener = new SendUserAlertListener();
		
		
		cancelButton.addActionListener(listener);

		frame.setSize(350,200);
		frame.setTitle("Alert");
		
		masterPanel = new JPanel();
		masterPanel.setLayout(new BorderLayout());

		north = new JPanel();
		north.setLayout(new FlowLayout());

		centre = new JPanel();
		centre.setLayout(new FlowLayout());

		south = new JPanel();
		south.setLayout(new FlowLayout());

		centre.add(label1);

		


		
		south.add(cancelButton);


		masterPanel.add(north, BorderLayout.PAGE_START);
		masterPanel.add(centre, BorderLayout.CENTER);
		masterPanel.add(south, BorderLayout.PAGE_END);

		frame.setContentPane(masterPanel);
		frame.setVisible(true);
		
		ImageIcon image = new ImageIcon("src/MoviesJavaApp.png");		//create an image icon
		frame.setIconImage(image.getImage()); 	
	}
}
