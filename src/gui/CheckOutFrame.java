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

public class CheckOutFrame {

	private JFrame frame;
	private JPanel panel;
	private JLabel panelTitle = new JLabel("Check out list");
	private JList guestsList;
	private JTextField damageCharges = new JTextField(5);
	private JTextField damageDescription = new JTextField(10);
	private JButton checkOut = new JButton("check out");
	private JButton cancel = new JButton("cancel");
	
	public CheckOutFrame() {
		frame = new JFrame();
        panel = new JPanel();
        

        frame.setTitle("Check in");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        createComponents();
	}
	
	public void createComponents() {
		panelTitle.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		checkOut.addActionListener(new cancel());
		cancel.addActionListener(new checkOut());
		
		panel.add(guestsList);
		panel.add(damageCharges);
		panel.add(damageDescription);
		panel.add(checkOut);
		panel.add(cancel);
		
	}
	
	class cancel implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
		}
	
	}
	
	class checkOut implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
