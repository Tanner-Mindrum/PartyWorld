package gui;

import AquaWorld.PartyGoer;
import AquaWorld.PartyRoom;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.*;

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
	private static PartyRoom partyRoom = new PartyRoom();
	private static PartyGoer partyGoer;

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
//		PartyRoom partyRoom = new PartyRoom();
		panelTitle.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		checkIn.addActionListener(new ButtonListener());
		cancel.addActionListener(new ButtonListener());
		DefaultListModel<String> listModel = new DefaultListModel<>();

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);

		for (int i = 0; i < partyRoom.getAllPartyGoers().size(); i++) {
			System.out.println("yoo");
			if (partyRoom.getAllPartyGoers().get(i).getMonthRes() == calendar.get(calendar.MONTH) && partyRoom.getAllPartyGoers().get(i).getDayRes() == calendar.get(calendar.DAY_OF_MONTH)
					&& partyRoom.getAllPartyGoers().get(i).getYearRes() == calendar.get(calendar.YEAR)) {
				System.out.println("yoo2");

				partyGoer = partyRoom.getAllPartyGoers().get(i);
				listModel.addElement(partyRoom.getAllPartyGoers().get(i).getName());
			}
		}

		guestsList = new JList(listModel);

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
				partyRoom.addToCheckedInList(partyGoer);
				MainFrame mainFrame = new MainFrame();
				frame.setVisible(false);
			}
			else {
				//We need to change this later
				MainFrame mainFrame = new MainFrame();
				frame.setVisible(false);
			}
		}
	
	}
	
}
