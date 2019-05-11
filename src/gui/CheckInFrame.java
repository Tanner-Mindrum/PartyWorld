package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import gui.WaitlistFrame.NoButton;
import gui.WaitlistFrame.YesButton;

public class CheckInFrame {
	private JFrame frame;
	private JPanel panel;
	private JLabel panelTitle = new JLabel("Check in list");
	private JList guestsList;
	private JButton checkIn = new JButton("check in");
	private JButton cancel = new JButton("cancel");
	
	public CheckInFrame() {
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
		checkIn.addActionListener(new cancel());
		cancel.addActionListener(new checkIn());
		
		panel.add(guestsList);
		panel.add(checkIn);
		panel.add(cancel);
		
	}
	
	class cancel implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
		}
	
	}
	
	class checkIn implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
