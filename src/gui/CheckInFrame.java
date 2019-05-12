package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
/**
 * Check in frame is uses a jlist that 
 * can check people into the rooms
 */
public class CheckInFrame {
	private JFrame frame;
	private JPanel panel;
	private JLabel panelTitle = new JLabel("Check in list");
	private JList<String> guestsList;
	private JButton checkIn = new JButton("check in");
	private JButton cancel = new JButton("cancel");
	/**
	 * The constructor for the class that creates a frame
	 * and calls the method createComponents() that adds
	 * components to the frame 
	 */
	public CheckInFrame() {
		frame = new JFrame();
        panel = new JPanel();
        

        frame.setTitle("Check in");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        createComponents();
	}
	/**
	 * Creates new components such as jbuttons and jlists 
	 * that are added to the panel and then added to the frame
	 */
	public void createComponents() {
		panelTitle.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		checkIn.addActionListener(new ButtonListener());
		cancel.addActionListener(new ButtonListener());
		guestsList = new JList<String>(); 
		
		panel.add(guestsList);
		panel.add(checkIn);
		panel.add(cancel);
		frame.add(panel);
		
	}
	/**
	 * ButtonListener creates actions for the check in and 
	 * the cancel button
	 */
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == checkIn) {
				System.out.println("You are now checked into the room");
			}
			else {
				//We need to change this later
				frame.setVisible(false);
			}
		}
	
	}
	
}
