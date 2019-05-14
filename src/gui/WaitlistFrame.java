package gui;

import AquaWorld.PartyRoom;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * 
 * @author steven, tymee, Justin, Tanner
 *
 * This class is the frame to add a guest to the waitlist
 */
public class WaitlistFrame {

	private static JButton yesButton = new JButton("Accept");
	private static JButton noButton = new JButton("Decline");
	private JLabel panelTitle = new JLabel("This room is currently booked at this time. Would you like to be added to the waitlist?");
	private JFrame waitlistFrame;
	private JPanel panel;
	private PartyRoom partyRoom;



	private static final int FRAME_WIDTH = 450;
	private static final int FRAME_HEIGHT = 350;
	
	/**
	 * the constructor for the waitlist
	 */
	public WaitlistFrame(PartyRoom p) {
		waitlistFrame = new JFrame();
        panel = new JPanel();
        partyRoom = p;

		waitlistFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		waitlistFrame.setTitle("Wait List");
        waitlistFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        waitlistFrame.setVisible(true);

        addComponents();
        
	}
	
	/**
	 * adds the necessary components to the frame
	 */
	public void addComponents() {
		yesButton.addActionListener(new YesButton());
		noButton.addActionListener(new YesButton());
		panel.add(panelTitle);
		panel.add(yesButton);
		panel.add(noButton);
		waitlistFrame.add(panel);
	}
	
	/**
	 * 
	 * @author steve, tanner, justin, tymee
	 *
	 * action listener for the yes button, adds the guest to the waitlist
	 */
	class YesButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == yesButton) {
				MainFrame mainFrame = new MainFrame();
				//frame.setVisible(false);
				waitlistFrame.setVisible(false);
			}
			else if (e.getSource() == noButton){
				NewReservationFrame newReservationFrame = new NewReservationFrame();
				waitlistFrame.setVisible(false);
			}
			//add to waitlist &
			
		}
		
	}
}
