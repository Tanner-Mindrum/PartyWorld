package AquaWorld;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuiTest {
	
	private JFrame frame;
	private JPanel panel;
	private JComboBox<String> month;
	private JTextField day; 
	private JTextField year;
	private JComboBox<String> ampm; 
	private JComboBox<Integer> hour;
	private JComboBox<Integer> minute;
	
	private final String[] monthList = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	public GuiTest() {
		frame = new JFrame("Check Reservation");
		frame.setSize(800, 600);
		constructFrame();
	
	}
	
	
	public void constructFrame() {
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		month = new JComboBox<String>(monthList);
		
		day = new JTextField(5);
		
		year = new JTextField(5);
		
		ampm = new JComboBox<String>();
		hour = new JComboBox<Integer>();
		ampm.addItem("am");
		ampm.addItem("pm");
		
		minute = new JComboBox<Integer>();
		minute.addItem(15);
		minute.addItem(30);
		minute.addItem(45);
		for (int i = 1; i <= 12; i++) {
			hour.addItem(i);
		}
		
		panel = new JPanel();
		
		panel.add(month);
		panel.add(day);
		panel.add(year);
		panel.add(hour);
		panel.add(minute);
		panel.add(ampm);
		
		
		frame.add(panel);
		frame.revalidate();
	}
	
}
