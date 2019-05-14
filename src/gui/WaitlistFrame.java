package gui;

import AquaWorld.PartyGoer;
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
	private boolean checkWaitList; 

	private boolean instantiatedforFrame = false;
	private int day;
	private int month;
	private int year;
	private int startTime;
	private int endTime;
	private PartyGoer partyG;
	

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
	
	public WaitlistFrame(PartyRoom p, int day, int month, int year, int startTime, int endTime, PartyGoer partyG){
		waitlistFrame = new JFrame();
        panel = new JPanel();
        partyRoom = p;

		waitlistFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		waitlistFrame.setTitle("Wait List");
        waitlistFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        waitlistFrame.setVisible(true);
        
        instantiatedforFrame = true;
        this.day = day;
        this.month = month;
        this.year = year;
        this.startTime = startTime;
        this.endTime = endTime;
        this.partyG = partyG;

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

	public void setStatus(boolean check) {
		checkWaitList = check; 
	}

	public boolean getStatus() {
		
		return checkWaitList; 
	
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
				checkWaitList = false; 
				waitlistFrame.setVisible(false);
				if (partyRoom != null) {
					partyRoom.reserveRoom(month, day, year, startTime, endTime, partyG, false);
				}
			}
			else if (e.getSource() == noButton){
				NewReservationFrame newReservationFrame = new NewReservationFrame();
				checkWaitList = true; 
				waitlistFrame.setVisible(false);
				partyRoom = null;
			}
			//add to waitlist &
			
		}
		
	}
}
