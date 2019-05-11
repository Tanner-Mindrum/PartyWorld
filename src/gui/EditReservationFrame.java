package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class EditReservationFrame {

    JFrame frame = new JFrame(); 
    JPanel panel = new JPanel(); 
    
    public EditReservationFrame() {

        frame.setTitle("Edit reservation");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        
        
    }
    
}