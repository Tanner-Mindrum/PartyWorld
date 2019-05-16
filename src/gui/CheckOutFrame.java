package gui;

import AquaWorld.PartyGoer;
import AquaWorld.PartyRoom;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.*;

/**
 * CheckOutFrame is used to check out a guest that was already checked in
 */
public class CheckOutFrame {

	private JFrame frame;
	private JPanel panel;
	private JList<String> guestsList;
	private JTextField damageCharges = new JTextField(5);
	private JTextField damageDescription = new JTextField(10);
	private JButton checkOut = new JButton("check out");
	private JButton cancel = new JButton("cancel");
	private static PartyRoom partyRoom = new PartyRoom();
	private static PartyGoer partyGoer;
	private JLabel damageCostLabel = new JLabel("Damage cost: ");
	private JLabel damageDescriptionLabel = new JLabel("Damage description: ");
	private JTextArea finalInvoice;
	private int totalCost = 0;




	/**
	 * Constructor for the class, it initializes a new frame with added components
	 */
	public CheckOutFrame() {
		frame = new JFrame();
        panel = new JPanel();
        

        frame.setTitle("Check out");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        createComponents();
	}
	/**
	 * Components are added to the panel and to the frame 
	 */
	public void createComponents() {
		finalInvoice = new JTextArea(20, 50);
		checkOut.addActionListener(new ButtonListener());
		cancel.addActionListener(new ButtonListener());
		DefaultListModel<String> listModel = new DefaultListModel<>();

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);

		for (int i = 0; i < partyRoom.getCurrentCheckInPartyGoers().size(); i++) {
			System.out.println("yoo");
			if (partyRoom.getCurrentCheckInPartyGoers().get(i).getMonthRes() == calendar.get(calendar.MONTH) && partyRoom.getCurrentCheckInPartyGoers().get(i).getDayRes() == calendar.get(calendar.DAY_OF_MONTH)
					&& partyRoom.getCurrentCheckInPartyGoers().get(i).getYearRes() == calendar.get(calendar.YEAR)) {
				System.out.println("yoo2");

				partyGoer = partyRoom.getCurrentCheckInPartyGoers().get(i);
				listModel.addElement(partyRoom.getCurrentCheckInPartyGoers().get(i).getName());
			}
		}

		guestsList = new JList(listModel);

		panel.add(guestsList);
		panel.add(damageCostLabel);
		panel.add(damageCharges);
		panel.add(damageDescriptionLabel);
		panel.add(damageDescription);
		panel.add(checkOut);
		panel.add(cancel);
		frame.add(panel);
		
	}
	/**
	 * This inner class dictates the behavior of the check out and the cancel button
	 */
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == checkOut) {
				if (partyGoer.getRoomType().equals("Small Party Room")) {
					totalCost = Integer.parseInt(damageCharges.getText().toString()) + 150;
				}
				else if (partyGoer.getRoomType().equals("Medium Party Room")) {
					totalCost = Integer.parseInt(damageCharges.getText().toString()) + 250;
				}
				if (partyGoer.getRoomType().equals("Aqua World")) {
					totalCost = Integer.parseInt(damageCharges.getText().toString()) + 700;
				}
				if (partyGoer.getRoomType().equals("Karaoke Lounge")) {
					totalCost = Integer.parseInt(damageCharges.getText().toString()) + 30;
				}
				if (partyGoer.getRoomType().equals("Adult Billiards Lounge")) {
					totalCost = Integer.parseInt(damageCharges.getText().toString()) + 25;
				}
				panel.remove(finalInvoice);
				panel.repaint();
				finalInvoice.setText("                              ~~~~~~~~~~~~~~~~~~~~~~~   Final Invoice  ~~~~~~~~~~~~~~~~~~~~~\n\n" +
						"Extra damage charges: " + damageCharges.getText().toString() + "from " + damageDescription.getText().toString() + "\n" +
						partyGoer.toString() +
						"Total Cost: $" + totalCost + "\n");
				panel.add(finalInvoice);
				panel.revalidate();
			}

			else {
				System.out.println("Canceled the check out");
			}
		}
	}
	
}
