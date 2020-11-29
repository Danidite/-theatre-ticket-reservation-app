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



public class SelectSeatGUI {
	private JButton selectSeatButton;
	private JButton cancelButton;
	private JLabel label1;
	private JLabel label2;
	private JPanel masterPanel;
	private JPanel north;
	private JPanel south;
	private JPanel centre;
	private JFrame frame;
	private JTextField seatRow;
	private JTextField seatCol;
	private SelectSeatListener listener;
	
	public class SelectSeatListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == selectSeatButton) {
				MenuController.selectSeatGUISelectSeatButtonPressed(seatRow.getText(), seatCol.getText());
				getFrame().dispatchEvent(new WindowEvent(getFrame(), WindowEvent.WINDOW_CLOSING));
			} else if(e.getSource() == cancelButton) {
				MenuController.selectSeatGUICancelButtonPressed();
				getFrame().dispatchEvent(new WindowEvent(getFrame(), WindowEvent.WINDOW_CLOSING));
			}
			
		}
		
	}
	
	public SelectSeatGUI(){
		selectSeatButton = new JButton("Select Seat");
		cancelButton = new JButton("Cancel");
		masterPanel = new JPanel();
		frame = new JFrame();
		seatRow = new JTextField(30);
		seatCol = new JTextField(30);
		label1 = new JLabel("Enter Seat row");
		label2 = new JLabel("Enter Seat Column");
		listener = new SelectSeatListener();
		
		selectSeatButton.addActionListener(listener);
		cancelButton.addActionListener(listener);

		frame.setSize(350,200);
		frame.setTitle("select Seat");
		
		masterPanel = new JPanel();
		masterPanel.setLayout(new BorderLayout());

		north = new JPanel();
		north.setLayout(new FlowLayout());

		centre = new JPanel();
		centre.setLayout(new FlowLayout());

		south = new JPanel();
		south.setLayout(new FlowLayout());

		centre.add(label1);
		centre.add(seatRow);

		centre.add(label2);
		centre.add(seatCol);

		south.add(selectSeatButton);
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
