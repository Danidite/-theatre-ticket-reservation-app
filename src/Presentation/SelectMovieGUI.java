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

public class SelectMovieGUI {
	private JButton selectMovie;
	private JButton cancel;
	private JLabel label1;
	private JPanel masterPanel;
	private JPanel north;
	private JPanel south;
	private JPanel centre;
	private JFrame frame;
	private JTextField movieName;
	private SelectMovieListener listener;
	
	public class SelectMovieListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == selectMovie) {
				MenuController.selectMovieGUISelectMovieButtonPressed(movieName.getText());
				getFrame().dispatchEvent(new WindowEvent(getFrame(), WindowEvent.WINDOW_CLOSING));
			} else if(e.getSource() == cancel) {
				MenuController.selectMovieGUICancelButtonPressed();
				getFrame().dispatchEvent(new WindowEvent(getFrame(), WindowEvent.WINDOW_CLOSING));
			}
			
		}
		
	}
	
	public SelectMovieGUI(){
		selectMovie = new JButton("Select Movie");
		cancel = new JButton("Cancel");
		masterPanel = new JPanel();
		frame = new JFrame();
		movieName = new JTextField(30);
		label1 = new JLabel("Enter Movie Name");
		listener = new SelectMovieListener();
		
		selectMovie.addActionListener(listener);
		cancel.addActionListener(listener);

		frame.setSize(350,200);
		frame.setTitle("Enter Movie");
		
		masterPanel = new JPanel();
		masterPanel.setLayout(new BorderLayout());

		north = new JPanel();
		north.setLayout(new FlowLayout());

		centre = new JPanel();
		centre.setLayout(new FlowLayout());

		south = new JPanel();
		south.setLayout(new FlowLayout());

		north.add(label1);

		centre.add(movieName);


		south.add(selectMovie);
		south.add(cancel);


		masterPanel.add(north, BorderLayout.PAGE_START);
		masterPanel.add(centre, BorderLayout.CENTER);
		masterPanel.add(south, BorderLayout.PAGE_END);

		frame.setContentPane(masterPanel);
		frame.setVisible(true);
		
		ImageIcon image = new ImageIcon("src/MoviesJavaApp.png");		//create an image icon
		frame.setIconImage(image.getImage()); 	
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getMovieName() {
		return movieName;
	}

	public void setMovieName(JTextField movieName) {
		this.movieName = movieName;
	}
	
	
	
}
