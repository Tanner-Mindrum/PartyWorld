package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * CheckOutFrame is used to check out a guest that was already checked in
 */
public class CheckOutFrame {

	private JFrame frame;
	private JPanel panel;
	private JLabel panelTitle = new JLabel("Check out list");
	private JList<String> guestsList;
	private JTextField damageCharges = new JTextField(5);
	private JTextField damageDescription = new JTextField(10);
	private JButton checkOut = new JButton("check out");
	private JButton cancel = new JButton("cancel");
	/**
	 * Constructor for the class, it initializes a new frame with added components
	 */
	public CheckOutFrame() {
		frame = new JFrame();
        panel = new JPanel();
        

        frame.setTitle("Check in");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        createComponents();
	}
	/**
	 * Components are added to the panel and to the frame 
	 */
	public void createComponents() {
		panelTitle.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		checkOut.addActionListener(new ButtonListener());
		cancel.addActionListener(new ButtonListener());
		guestsList = new JList<String>(); 
		
		panel.add(guestsList);
		panel.add(damageCharges);
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
				System.out.println("You checked out!");
			}

			else {
				System.out.println("Canceled the check out");
			}
		}
	
	}
	
}
