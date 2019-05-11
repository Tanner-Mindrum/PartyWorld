package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WaitlistFrame {

	private static JButton yesButton = new JButton("Yes");
	private static JButton noButton = new JButton("No");
	private JLabel panelTitle = new JLabel("This room is currently booked. Would you like to be added to the waitlist?");
	private JFrame frame;
	private JPanel panel;
	
	public WaitlistFrame() {
		frame = new JFrame();
        panel = new JPanel();
        

        frame.setTitle("Wait List");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        addComponents();
        
	}
	
	public void addComponents() {
		panelTitle.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		yesButton.addActionListener(new YesButton());
		noButton.addActionListener(new NoButton());
		panel.add(panelTitle);
		panel.add(yesButton);
		panel.add(noButton);
		frame.add(panel);
	}
	
	class NoButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	class YesButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
