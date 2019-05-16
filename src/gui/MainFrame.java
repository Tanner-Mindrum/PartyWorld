package gui;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import AquaWorld.*;
// import backend.MediumPartyRoom;
 import AquaWorld.smallPartyRoom;

public class MainFrame {
	private JMenuBar menuBar;
	private JScrollPane scrollPane;
	private JPanel centerPanel;
	private JFrame frame;

	private smallPartyRoom smallRoom = new smallPartyRoom();
	private mediumPartyRoom mediumRoom = new mediumPartyRoom();
	private karaokeLounge karaokeLounge = new karaokeLounge();
	private AquaWorldRoom aquaRoom = AquaWorldRoom.getInstance();
	private AdultBilliardsLounge adultRoom = new AdultBilliardsLounge();

	private static JButton smallButton = new JButton("Book Now");
	private static JButton medButton = new JButton("Book Now");
	private static JButton aquaButton = new JButton("Book Now");
	private static JButton billiardButton = new JButton("Book Now");
	private static JButton karaokeButton = new JButton("Book Now");

	private static String titleChoice;

	private static boolean partyRoomWasClicked;
	private static boolean loungeWasClicked;

	private JLabel panelTitle = new JLabel("Party World Rooms");
	//border settings used in the method addARoomDescription()
 	Border raisedbevel = BorderFactory.createRaisedBevelBorder();
 	Border loweredbevel = BorderFactory.createLoweredBevelBorder();

	private boolean breadStickOrSalad;
	private String breadStickOrSalads;
	private String soda1;
	private String soda2;
	private String soda3;
	private String soda4;
	private String soda5;
	private String pizza1s;
	private String pizza2s;
	private String pizza3s;
	private ArrayList<PizzaDecorator> pizza1;
	private ArrayList<PizzaDecorator> pizza2;
	private ArrayList<PizzaDecorator> pizza3;
	private ArrayList<PizzaDecorator> pizza4;
	private String wingFlavor;
	private String boneInorOut;
	private String iceCream1;
	private String iceCream2;
	private boolean hasBeenPressed = false;

	public MainFrame(){

		frame = new JFrame();
		frame.setTitle("Reservation System");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //makes window screen size
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.createMenuBar();
		this.createDefaultPanel();
		frame.setVisible(true);

		partyRoomWasClicked = false;
		loungeWasClicked = false;
	}



	/*
	 * initializes the default center panel and adds it to this frame
	 * */
	private void createDefaultPanel() {
		centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		//Title of default view
		panelTitle.setFont(new Font(Font.SERIF, Font.BOLD, 30));

//		JButton smallButton = new JButton("Book Now");
//		JButton medButton = new JButton("Book Now");
//		JButton aqauButton =new JButton("Book Now");
//		JButton billiardButton = new JButton("Book Now");
//		JButton karaokeButton = new JButton("Book Now");

		centerPanel.add(panelTitle);
		addARoomDescription(centerPanel, "C:\\Users\\drizz\\OneDrive\\Pictures\\Saved Pictures\\smallParty.jpg", "Small Party Room", smallRoom.getDescription(), smallButton);
		addARoomDescription(centerPanel, "C:\\Users\\drizz\\OneDrive\\Pictures\\Saved Pictures\\mediumParty.jpg","Medium Party Room", mediumRoom.getDescription(), medButton);
		addARoomDescription(centerPanel, "C:\\Users\\drizz\\OneDrive\\Pictures\\Saved Pictures\\AquaRoom.jpg","Aqua World", aquaRoom.getDescription(), aquaButton);
		addARoomDescription(centerPanel, "C:\\Users\\drizz\\OneDrive\\Pictures\\Saved Pictures\\karaokeLounge.jpg","Karaoke Lounge", karaokeLounge.getDescription(), karaokeButton);
		addARoomDescription(centerPanel, "C:\\Users\\drizz\\OneDrive\\Pictures\\Saved Pictures\\billiardLounge.jpg","Adult Billiard Lounge", adultRoom.getDescription(), billiardButton);

		smallButton.addActionListener(new ButtonListener());
		medButton.addActionListener(new ButtonListener());
		aquaButton.addActionListener(new ButtonListener());
		karaokeButton.addActionListener(new ButtonListener());
		billiardButton.addActionListener(new ButtonListener());


		scrollPane = new JScrollPane(centerPanel);
		scrollPane.getViewport().setViewPosition(new Point(0,0));
		frame.add(scrollPane, BorderLayout.CENTER);
	}

	/* initializes menu bar items and adds them to this window*/
	private void createMenuBar() {
		menuBar = new JMenuBar();
		//-------
				JMenu menu;
				JMenu submenu;
				JMenuItem menuItem;

				//-------  DESCRIPTIONS MENU------------------
				menu = new JMenu("Descriptions");

				//Party Room Sub Menu
				submenu = new JMenu("Party Rooms");


				menuItem = new JMenuItem("All Party Rooms");
				menuItem.addActionListener(new RoomItemListener());
				submenu.add(menuItem);

				menuItem = new JMenuItem("Small Party Rooms");
				menuItem.addActionListener(new RoomItemListener());
				submenu.add(menuItem);

				menuItem = new JMenuItem("Medium Party Rooms");
				menuItem.addActionListener(new RoomItemListener());
				submenu.add(menuItem);

				menuItem = new JMenuItem("Aqua Room");
				menuItem.addActionListener(new RoomItemListener());
				submenu.add(menuItem);
				menu.add(submenu);

				//Lounges Sub Menu
				submenu = new JMenu("Lounges");

				menuItem = new JMenuItem("All Lounges");
				menuItem.addActionListener(new RoomItemListener());
				submenu.add(menuItem);

				menuItem = new JMenuItem("Karaoke Lounges");
				menuItem.addActionListener(new RoomItemListener());
				submenu.add(menuItem);

				menuItem = new JMenuItem("Billiards Lounges");
				menuItem.addActionListener(new RoomItemListener());
				submenu.add(menuItem);

				menu.add(submenu);
				menu.addSeparator();

				//Meal Plans Sub Menu
				submenu = new JMenu("Meal Plans");

				menuItem = new JMenuItem("All");
				submenu.add(menuItem);
				menuItem.addActionListener(new MealItemListener());

				menuItem = new JMenuItem("Basic");
				submenu.add(menuItem);
				menuItem.addActionListener(new MealItemListener());

				menuItem = new JMenuItem("Bronze");
				submenu.add(menuItem);
				menuItem.addActionListener(new MealItemListener());

				menuItem = new JMenuItem("Silver");
				submenu.add(menuItem);
				menuItem.addActionListener(new MealItemListener());

				menuItem = new JMenuItem("Gold");
				submenu.add(menuItem);
				menuItem.addActionListener(new MealItemListener());

				menuItem = new JMenuItem("Platinum");
				submenu.add(menuItem);
				menuItem.addActionListener(new MealItemListener());

				menu.add(submenu);



				menuBar.add(menu);


				//-------  RESERVATIONS MENU------------------
				menu = new JMenu("Reservations");

						//New reservation item
						menuItem = new JMenuItem("New Reservation");
						menuItem.addActionListener(new ReservationListener());
						menu.add(menuItem);

						menu.addSeparator();

						//Edit reservation item
						menuItem = new JMenuItem("Edit Existing Reservation");
						menuItem.addActionListener(new ReservationListener());
						menu.add(menuItem);
						menu.addSeparator();


						//Manage reservation sub menu
						submenu = new JMenu("Manage Current Reservation");
						submenu.setMnemonic(KeyEvent.VK_S);

						menuItem = new JMenuItem("Check-in");
						menuItem.addActionListener(new ReservationListener());
						submenu.add(menuItem);

						menuItem = new JMenuItem("Check-out");
						menuItem.addActionListener(new ReservationListener());
						submenu.add(menuItem);


						menu.add(submenu);


				menuBar.add(menu);
				frame.add(menuBar, BorderLayout.NORTH);
	}



	/*
	 * adds room image and description to a given container
	 * @param container - the container onto which to add the new description
	 * @param imgDir - the directory of the image
	 * @param roomName - the name of the room
	 * @param roomDesc - the description of the room
	 *
	 * */
	 private void addARoomDescription(Container container, String imgDir, String roomName, String roomDesc, JButton button) {
		 	JPanel p = new JPanel();


		 	ImageIcon icon = new ImageIcon(imgDir);
		 	JLabel picture = new JLabel(roomName, icon, JLabel.CENTER);
		 	picture.setFont(new Font(Font.SERIF, Font.BOLD, 20));

		 	//Set the position of the text, relative to the icon:
		 	picture.setVerticalTextPosition(JLabel.TOP);
		 	picture.setHorizontalTextPosition(JLabel.CENTER);
		 	//Set border around
		 	picture.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));

		 	p.add(picture);


		 	JTextArea description = new JTextArea(5,10);

		 	description.append(roomDesc);
		 	description.setEditable(false);
		 	description.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
		 	description.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			p.add(description);

//	        JButton bookButton = new JButton("Book Now");
//	        bookButton.addActionListener(new ButtonListener());
			if(button != null) {
				p.add(button);
			}
	        container.add(p);
	    }



	class MealItemListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent click) {
			JMenuItem menuItem = (JMenuItem) click.getSource();
			panelTitle = new JLabel("Meal Items");
			String item = menuItem.getText();
		
			basicMeal basic = new basicMeal(soda1, soda2, soda3, pizza1s, pizza2s, pizza3s);
			bronzeMeal bronze = new bronzeMeal(null, null, null, null, null, null, null);
			silverMeal silver = new silverMeal(false, null, null, null, null, null, null, null, null);
			goldMeal gold = new goldMeal(false, null, null, null, null, null, null, null, null, null, null);
			platMeal plat = new platMeal(false, null, null, null, null, null, null, null, null, null, null, null, null, null);
			//item needs to be replaced for drop down menu
			
			if(item.equals("All")) {
				centerPanel.removeAll();
				centerPanel.add(panelTitle);
				panelTitle.setFont(new Font(Font.SERIF, Font.BOLD, 30));
				addARoomDescription(centerPanel, "C:\\Users\\drizz\\OneDrive\\Pictures\\Saved Pictures\\smallParty.jpg", "Basic Meal Plan", basic.getDescription(), null);
				addARoomDescription(centerPanel, "C:\\Users\\drizz\\OneDrive\\Pictures\\Saved Pictures\\mediumParty.jpg","Bronze Meal Plan", bronze.getDescription(), null);
				addARoomDescription(centerPanel, "C:\\Users\\drizz\\OneDrive\\Pictures\\Saved Pictures\\AquaRoom.jpg","Silver Meal Plan", silver.getDescription(), null);
				addARoomDescription(centerPanel, "C:\\Users\\drizz\\OneDrive\\Pictures\\Saved Pictures\\karaokeLounge.jpg","Gold Meal Plan", gold.getDescription(), null);
				addARoomDescription(centerPanel, "C:\\Users\\drizz\\OneDrive\\Pictures\\Saved Pictures\\billiardLounge.jpg","Platinum Meal Plan", plat.getDescription(), null);
				centerPanel.repaint();
			}
			
			else if(item.equals("Basic")) {
				centerPanel.removeAll();
				centerPanel.add(panelTitle);
				panelTitle.setFont(new Font(Font.SERIF, Font.BOLD, 30));
				addARoomDescription(centerPanel, "C:\\Users\\drizz\\OneDrive\\Pictures\\Saved Pictures\\smallParty.jpg", "Basic Meal Plan", basic.getDescription(), null);
				centerPanel.repaint();
			} 
			
			else if(item.equals("Bronze")) {
				centerPanel.removeAll();
				centerPanel.add(panelTitle);
				panelTitle.setFont(new Font(Font.SERIF, Font.BOLD, 30));
				addARoomDescription(centerPanel, "C:\\Users\\drizz\\OneDrive\\Pictures\\Saved Pictures\\mediumParty.jpg","Bronze Meal Plan", bronze.getDescription(), null);
				centerPanel.repaint();
			}

			else if (item.equals("Silver")){
				centerPanel.removeAll();
				centerPanel.add(panelTitle);
				panelTitle.setFont(new Font(Font.SERIF, Font.BOLD, 30));
				addARoomDescription(centerPanel, "C:\\Users\\drizz\\OneDrive\\Pictures\\Saved Pictures\\AquaRoom.jpg","Silver Meal Plan", silver.getDescription(), null);
				centerPanel.repaint();
			}

			else if (item.equals("Gold")) {
				centerPanel.removeAll();
				centerPanel.add(panelTitle);
				panelTitle.setFont(new Font(Font.SERIF, Font.BOLD, 30));
				addARoomDescription(centerPanel, "C:\\Users\\drizz\\OneDrive\\Pictures\\Saved Pictures\\karaokeLounge.jpg","Gold Meal Plan", gold.getDescription(), null);
				centerPanel.repaint();
			}

			else {
				centerPanel.removeAll();
				centerPanel.add(panelTitle);
				panelTitle.setFont(new Font(Font.SERIF, Font.BOLD, 30));
				addARoomDescription(centerPanel, "C:\\Users\\drizz\\OneDrive\\Pictures\\Saved Pictures\\billiardLounge.jpg","Platinum Meal Plan", plat.getDescription(), null);
				centerPanel.repaint();
			}
			



		}

	}

	class RoomItemListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent select) {

			JMenuItem item = (JMenuItem) select.getSource();
			panelTitle = new JLabel("Party World Rooms");

			if(item.getText().equals("Medium Party Rooms")) {
				centerPanel.removeAll();
				centerPanel.add(panelTitle);
				panelTitle.setFont(new Font(Font.SERIF, Font.BOLD, 30));
				addARoomDescription(centerPanel, "C:\\Users\\drizz\\OneDrive\\Pictures\\Saved Pictures\\mediumParty.jpg","Medium Party Room", mediumRoom.getDescription(), new JButton("Book now"));
				centerPanel.repaint();
			}else if(item.getText().equals("Small Party Rooms")) {
				centerPanel.removeAll();
				centerPanel.add(panelTitle);
				panelTitle.setFont(new Font(Font.SERIF, Font.BOLD, 30));
				addARoomDescription(centerPanel, "C:\\Users\\drizz\\OneDrive\\Pictures\\Saved Pictures\\smallParty.jpg","Small Party Room", smallRoom.getDescription(), new JButton("Book now"));
				centerPanel.repaint();
			}else if(item.getText().equals("Aqua Room")) {
				centerPanel.removeAll();
				centerPanel.add(panelTitle);
				panelTitle.setFont(new Font(Font.SERIF, Font.BOLD, 30));
				addARoomDescription(centerPanel, "C:\\Users\\drizz\\OneDrive\\Pictures\\Saved Pictures\\aquaRoom.jpg","Aqua Room", aquaRoom.getDescription(), new JButton("Book now"));
				centerPanel.repaint();
			}else if(item.getText().equals("Billiards Lounges")) {
				centerPanel.removeAll();
				centerPanel.add(panelTitle);
				panelTitle.setFont(new Font(Font.SERIF, Font.BOLD, 30));
				addARoomDescription(centerPanel, "C:\\Users\\drizz\\OneDrive\\Pictures\\Saved Pictures\\billiardLounge.jpg","Billiards Lounges", adultRoom.getDescription(), new JButton("Book now"));
				centerPanel.repaint();
			}else if(item.getText().equals("Karaoke Lounges")) {
				centerPanel.removeAll();
				centerPanel.add(panelTitle);
				panelTitle.setFont(new Font(Font.SERIF, Font.BOLD, 30));
				addARoomDescription(centerPanel, "C:\\Users\\drizz\\OneDrive\\Pictures\\Saved Pictures\\karaokeLounge.jpg","Karaoke Lounges", karaokeLounge.getDescription(), new JButton("Book now"));
				centerPanel.repaint();
			}else if(item.getText().equals("All Party Rooms")){
				centerPanel.removeAll();
				centerPanel.add(panelTitle);
				panelTitle.setFont(new Font(Font.SERIF, Font.BOLD, 30));
				addARoomDescription(centerPanel, "C:\\Users\\drizz\\OneDrive\\Pictures\\Saved Pictures\\smallParty.jpg", "Small Party Room", smallRoom.getDescription(), new JButton("Book now"));
				addARoomDescription(centerPanel, "C:\\Users\\drizz\\OneDrive\\Pictures\\Saved Pictures\\mediumParty.jpg","Medium Party Room", mediumRoom.getDescription(), new JButton("Book now"));
				addARoomDescription(centerPanel, "C:\\Users\\drizz\\OneDrive\\Pictures\\Saved Pictures\\AquaRoom.jpg","Aqua Room", aquaRoom.getDescription(), new JButton("Book now"));
				centerPanel.repaint();
			}else if(item.getText().equals("All Lounges")){
				centerPanel.removeAll();
				centerPanel.add(panelTitle);
				panelTitle.setFont(new Font(Font.SERIF, Font.BOLD, 30));
				addARoomDescription(centerPanel, "C:\\Users\\drizz\\OneDrive\\Pictures\\Saved Pictures\\karaokeLounge.jpg","Karaoke Lounges", karaokeLounge.getDescription(), new JButton("Book now"));
				addARoomDescription(centerPanel, "C:\\Users\\drizz\\OneDrive\\Pictures\\Saved Pictures\\billiardLounge.jpg","Billiards Lounges", adultRoom.getDescription(), new JButton("Book now"));
				centerPanel.repaint();
			}
		}
	}


	
	public static void main(String[] args) {
		MainFrame f = new MainFrame();
	}

	public void edit(boolean w) {
		PartyRoom p = new PartyRoom();
	 	if (p.getRemovedPartyGoerWaitlistList().size() == 1) {
			JLabel remover = new JLabel(p.getRemovedPartyGoer().getName() + " was removed and " + p.getRemovedPartyGoerWaitlist().getName() + " was added to the reservation list.");
			centerPanel.remove(remover);
	 		//panelTitle.remove(remover2);
	 		centerPanel.repaint();
			centerPanel.add(remover);
			centerPanel.revalidate();
		}
	 	else if (w) {
			JLabel remover3 = new JLabel(p.getRemovedPartyGoer().getName() + " was removed and " + p.getAllPartyGoers().get(p.getAllPartyGoers().size() - 1).getName() + " was added to the reservation list.");
			//panelTitle.remove(remover);
			centerPanel.remove(remover3);
			centerPanel.repaint();
			centerPanel.add(remover3);
			centerPanel.revalidate();
		}
		else {
			JLabel remover2 = new JLabel(p.getRemovedPartyGoer().getName() + " was removed");
			//panelTitle.remove(remover);
			centerPanel.remove(remover2);
			centerPanel.repaint();
			centerPanel.add(remover2);
			centerPanel.revalidate();
		}
	}

	public void edit2() {
		PartyRoom p = new PartyRoom();

		JLabel confirmer = new JLabel(p.getAllPartyGoers().get(p.getAllPartyGoers().size() - 1).getName() + "'s confirmation number is: " +
				p.getAllPartyGoers().get(p.getAllPartyGoers().size() - 1).getConfirmationNum());
		centerPanel.remove(confirmer);
		//panelTitle.remove(remover2);
		centerPanel.repaint();
		centerPanel.add(confirmer);
		centerPanel.revalidate();
	}

	public void edit3() {
		PartyRoom p = new PartyRoom();

		JLabel confirmer = new JLabel(p.getAllWaitlistPartyGoers().get(p.getAllWaitlistPartyGoers().size() - 1).getName() + " has been added to the waitlist.");
		centerPanel.remove(confirmer);
		//panelTitle.remove(remover2);
		centerPanel.repaint();
		centerPanel.add(confirmer);
		centerPanel.revalidate();
	}


	class ReservationListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			JMenuItem item = (JMenuItem) e.getSource();

			if (item.getText().equals("New Reservation")) {

				NewReservationFrame reservationFrame = new NewReservationFrame();
				frame.setVisible(false);
			}
			
			else if (item.getText().equals("Edit Existing Reservation")) {

				EditReservationFrame editFrame = new EditReservationFrame();
				frame.setVisible(false);
				
			}

			else if (item.getText().equals("Check-in")) {
				CheckInFrame checkIn = new CheckInFrame();
				frame.setVisible(false);
			}

			else {
				CheckOutFrame checkOut = new CheckOutFrame();
				frame.setVisible(false);
			}
		}
	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent click) {
			if(!hasBeenPressed) {
				hasBeenPressed = true;
				if (click.getSource() == smallButton) {
					System.out.println("SMALL ROOM");
					DateTimeFrame dateTimeFrame = new DateTimeFrame(true, "Small Party Room");
					//partyRoomWasClicked = true;
					frame.setVisible(false);
					dateTimeFrame.setVisible(true);
					dateTimeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
				else if (click.getSource() == medButton) {
					System.out.println("MED ROOM");
					DateTimeFrame dateTimeFrame = new DateTimeFrame(true, "Medium Party Room");
					frame.setVisible(false);
					dateTimeFrame.setVisible(true);
					dateTimeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
				else if (click.getSource() == aquaButton) {
					System.out.println("AQUA ROOM");
					DateTimeFrame dateTimeFrame = new DateTimeFrame(true, "Aqua World");
					frame.setVisible(false);
					dateTimeFrame.setVisible(true);
					dateTimeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
				else if (click.getSource() == karaokeButton) {
					System.out.println("KARAOKE ROOM");
					DateTimeFrame dateTimeFrame = new DateTimeFrame(false, "Karaoke Lounge");
					frame.setVisible(false);
					dateTimeFrame.setVisible(true);
					dateTimeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
				else if (click.getSource() == billiardButton) {
					System.out.println("BILLIARD ROOM");
					DateTimeFrame dateTimeFrame = new DateTimeFrame(false, "Adult Billiards Lounge");
					frame.setVisible(false);
					dateTimeFrame.setVisible(true);
					dateTimeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
				partyRoomWasClicked = false;
				loungeWasClicked = false;
			}
		}
	}
}
