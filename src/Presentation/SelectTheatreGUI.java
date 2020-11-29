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


public class SelectTheatreGUI {
	
	private JButton selectTheatreButton;
	private JButton cancelButton;
	private JLabel label1;
	private JPanel masterPanel;
	private JPanel north;
	private JPanel south;
	private JPanel centre;
	private JFrame frame;
	private JTextField theatreID;
	private SelectTheatreListener listener;

	
	public class SelectTheatreListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == selectTheatreButton) {
				MenuController.selectTheatreGUISelectTheatreButtonPressed(theatreID.getText());
				getFrame().dispatchEvent(new WindowEvent(getFrame(), WindowEvent.WINDOW_CLOSING));
			} else if(e.getSource() == cancelButton) {
				MenuController.selectTheatreGUICancelButtonPressed();
				getFrame().dispatchEvent(new WindowEvent(getFrame(), WindowEvent.WINDOW_CLOSING));
			}
			
		}
		
	}
	
	public SelectTheatreGUI(){
		selectTheatreButton = new JButton("Select Theatre");
		cancelButton = new JButton("Cancel");
		masterPanel = new JPanel();
		frame = new JFrame();
		theatreID = new JTextField(30);
		label1 = new JLabel("Enter Theatre ID");
		listener = new SelectTheatreListener();
		
		selectTheatreButton.addActionListener(listener);
		cancelButton.addActionListener(listener);

		frame.setSize(350,200);
		frame.setTitle("select Theatre");
		
		masterPanel = new JPanel();
		masterPanel.setLayout(new BorderLayout());

		north = new JPanel();
		north.setLayout(new FlowLayout());

		centre = new JPanel();
		centre.setLayout(new FlowLayout());

		south = new JPanel();
		south.setLayout(new FlowLayout());

		north.add(label1);

		centre.add(theatreID);


		south.add(selectTheatreButton);
		south.add(cancelButton);


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
	
	
}
