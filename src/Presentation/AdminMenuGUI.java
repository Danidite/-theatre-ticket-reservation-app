//package Presentation;
//
//import java.awt.BorderLayout;
//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//
//import Controller.MenuController;
//import Presentation.RegisteredUserMenuGUI.RegisteredUserMenuListener;
//
//public class AdminMenuGUI {
//	private JFrame frame;
//	private JPanel southPanel = new JPanel();
//	private JPanel masterPanel = new JPanel();
//	
//	private JButton 
//	private JButton logoutButton = new JButton("Logout");
//	
//	
//	private JTextArea theText;
//	private JScrollPane scroll;
//	private AdminMenuListener listener;
//	
//	class AdminMenuListener implements ActionListener{
//	
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			
//		}
//		
//	}
//	
//	AdminMenuGUI(){
//		//add listner
//		listener = new RegisteredUserMenuListener();
//		
//		viewReservations.addActionListener(listener);
//		bookReservationButton.addActionListener(listener);
//		cancelReservationButton.addActionListener(listener);
//		paySubscriptionButton.addActionListener(listener);
//		newsButton.addActionListener(listener);
//		logoutButton.addActionListener(listener);
//		
//		
//		//create GUI
//		frame = new JFrame();
//		frame.setTitle("Registered User Menu");
//		
//		frame.setResizable(false); 		//user can't resize GUI on their own
//		frame.setSize(1000,800);			//set size of this
//		southPanel.setLayout(new FlowLayout());
//		
//		southPanel.add(viewReservations);
//		southPanel.add(bookReservationButton);
//		southPanel.add(cancelReservationButton);
//		southPanel.add(paySubscriptionButton);
//		southPanel.add(newsButton);
//		southPanel.add(logoutButton);
//		
//		theText = new JTextArea();
//		scroll = new JScrollPane(theText);
//		
//		masterPanel.setLayout(new BorderLayout());
//		
//		masterPanel.add(southPanel, BorderLayout.PAGE_END);
//		masterPanel.add(scroll,BorderLayout.CENTER);
//		
//		frame.add(masterPanel);
//		frame.setVisible(true); 		//make this visible
//		
//		ImageIcon image = new ImageIcon("src/MoviesJavaApp.png");		//create an image icon
//		frame.setIconImage(image.getImage()); 	
//		
//	}
//
//	
//	//getters and setters
//	public JFrame getFrame() {
//		return frame;
//	}
//
//	public void setFrame(JFrame frame) {
//		this.frame = frame;
//	}
//
//	public JTextArea getTheText() {
//		return theText;
//	}
//
//	public void setTheText(JTextArea theText) {
//		this.theText = theText;
//	}
//}
