package gui;

import AquaWorld.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static java.awt.Frame.MAXIMIZED_BOTH;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import AquaWorld.*;
//import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import static gui.DateTimeFrame.getMonthStrings;
/**
 * This class opens a editFrame with a jtextfield where a guest 
 * can put their confirmation number to make edits to their existing reservations  
 */
public class EditReservationFrame {

    //private JFrame editFrame = new JFrame();
    private JPanel panel = new JPanel();
    private JTextField confirmNumberField;
    private JLabel confirmLabel;
    private JButton checkButton;
    private JButton cancelButton;
    private JLabel notFoundLabel;

    /**
     * The constructor that initializes the editFrame 
     */
    public EditReservationFrame() {

        frame = new JFrame();
        panel = new JPanel();

        //frame.setTitle("New Reservation");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        this.monthStrings = getMonthStrings();
        panelComponents();
//        guestInfo();
//        upgrades();
//        mealPlans();
//        generateRooms();
//        currentDate();
    }
    //Only use this method to add components to the editFrame
    /**
     * This method adds the jlabel, jtextfield, jbuttons to the panel and adds
     * it to the editFrame
     */
    public void panelComponents() {

        confirmNumberField = new JTextField(5);
        confirmLabel = new JLabel("Please enter your confirmation number");
        checkButton = new JButton("Find reservation");
        notFoundLabel = new JLabel("That confirmation number does not exist.");
        cancelButton = new JButton("Cancel");

        checkButton.addActionListener(new buttonListener());
        cancelButton.addActionListener(new buttonListener());

        panel.add(confirmLabel);
        panel.add(confirmNumberField);
        panel.add(checkButton);
        panel.add(cancelButton);

        frame.add(panel);

    }


    // Frame info

    // Guest Info
    //private JPanel panel;
    private JTextField nameField;
    private JLabel nameLabel;
    private JTextField phoneNumField;
    private JLabel phoneNumLabel;
    private JTextField addressField;
    private JLabel addressLabel;
    private JTextField emailField;
    private JLabel emailLabel;
    private JLabel dateOfBirth;
    private JComboBox<Integer> year;
    private JComboBox<Integer> day;
    private JComboBox<Integer> month;
    private JLabel contactPreferenceLabel = new JLabel("Contact preference:  Phone:");
    //private JLabel phonePreferenceLabel;
    private JLabel emailPreferenceLabel = new JLabel("Email:");
    private JCheckBox phonePreferenceBox = new JCheckBox();
    private JCheckBox emailPreferenceBox = new JCheckBox();
    private JLabel visaLabel = new JLabel("Card type:  Visa:");
    private JCheckBox visaCardBox = new JCheckBox();
    private JLabel masterCardLabel = new JLabel("Master Card:");
    private JCheckBox masterCardBox = new JCheckBox();
    private JLabel americanExpressLabel = new JLabel("American Express:");
    private JCheckBox americanExpressBox = new JCheckBox();


    private boolean pgPhonePref;
    private boolean pgEmailPref;
    private boolean pgVisa;
    private boolean pgMaster;
    private boolean pgAE;

    private PartyGoer partyGoer;
    //private static ArrayList<PartyGoer> globalPartyGoerList =



    private PartyRoomFactory partyRoomFactory = new PartyRoomFactory();

    //private static AquaWorldRoom aquaWorldRoom = AquaWorldRoom.getInstance();

    private static ArrayList<PartyRoom> smallPartyRooms = new ArrayList<>();
    private static ArrayList<PartyRoom> medPartyRooms = new ArrayList<>();
    private static ArrayList<PartyRoom> karaokeLounges = new ArrayList<>();
    private static ArrayList<PartyRoom> adultBilliardsLounges = new ArrayList<>();
    private static ArrayList<PartyRoom> aquaWorlds = new ArrayList<>();

    //Spinners
    private JLabel monthLabel;
    private String[] monthStrings;
    private JSpinner monthSpinner;
    private JSpinner monthSpinner2;
    private JLabel dayLabel;
    private JSpinner daySpinner;
    private JLabel yearLabel;
    private JSpinner yearSpinner;
    private JSpinner.NumberEditor editor;
    private JLabel startTimeLabel;
    private JSpinner timeSpinner;
    private JLabel endTimeLabel;
    private JSpinner endTimeSpinner;

    // Credit Card Info
    private JLabel cardNameLabel;
    private JLabel creditCardInfoLabel;
    private JLabel cardNumberLabel;
    private JLabel securityCodeLabel;
    private JLabel expirationDateLabel;

    private JTextField cardNumberField;
    private JTextField cardName;
    private JTextField securityCodeField;
    private JComboBox<Integer> expirationMonth;
    private JComboBox<Integer> expirationYear;

    // Room info
    private JComboBox<String> roomTypeBox;
    private JComboBox<Integer> roomNumberBox;
    private JLabel roomNumberLabel;
    private JLabel roomTypeLabel;


    private JButton reserveButton;
   // private JButton cancelButton;
    protected JFrame frame;

    private String[] roomTypes = {"Small Party Room", "Medium Party Room", "Aqua World", "Karaoke Lounge", "Adult Billiards Lounge"};
    private final ArrayList<String> roomTypesArrayList = new ArrayList<>();

    private DateTimeFrame dateTimeFrame = new DateTimeFrame(false, null);
    private static String initialRoomDisplay = "";
    private static int initialRoomIndex = 0;
    private static int initialMonthIndex = 0;
    private static int initialDayIndex = 0;
    private static int initialYearIndex = 0;
    private static int initialStartTimeIndex = 0;
    private static int initialEndTimeIndex = 0;
    private static int foundRoom;
    private static String aRoomType;

    private static ArrayList<String> timeInts = new ArrayList<>();
    private JComboBox<String> startTimesBox;
    private JComboBox<String> endTimesBox;

    //Upgrade Stuff
    private String[] THEMES = {"Choose One", "Hawaiian", "Sea Life", "Jungle", "Space", "Modern"};

    private JLabel partyBagLabel = new JLabel("Party Favor Bags (5$ per Bag)");
    private JLabel towelLabel = new JLabel("Towel Rentals (2$ Each)");
    private JLabel projectorLabel = new JLabel("Projector (10$/hr)");
    private JLabel decorationsLabel = new JLabel("Party Decorations & Set Up (100$)");


    private JComboBox<String> partyDecorationsBox = new JComboBox<String>(THEMES);
    private JCheckBox projectorBox = new JCheckBox();
    private JCheckBox partyBagsBox = new JCheckBox();
    private JCheckBox towelBox = new JCheckBox();

    //Meal plan stuff
    private JComboBox<String> mealPlanBox;
    private String[] MEALPLANS = {"Basic Meal Plan", "Bronze Meal Plan", "Silver Meal Plan", "Gold Meal Plan", "Platinum Meal Plan"};
    private String[] SODA = {"Coca Cola", "Diet Coke", "Canada Dry", "Orange Crush", "Squirt", "Root Beer"};
    private String[] SOS = {"Bread Sticks", "Salad"};
    private String[] PIZZATOPPINGS = {"Cheese", "Pepperoni", "Ham", "Jalapeno", "Sausage", "Mushroom", "Pineapple", "Bell pepper", "Onion", "Garlic Chicken"};
    private String[] WINGS = {"Spicy Mild", "Lemon Pepper", "BBQ", "Sesame", "Diablo"};
    private String[] BONE = {"Bone in", "Bone Out"};
    private String[] ICECREAM = {"Chocolate Fudge", "Vanilla Bean", "Strawberry Shortcake", "Choco Mint", "Butter Pecan"};

    private JComboBox<String> iceCream1 = new JComboBox<String>(ICECREAM);
    private JComboBox<String> iceCream2 = new JComboBox<String>(ICECREAM);
    private JComboBox<String> toppings1 = new JComboBox<String>(PIZZATOPPINGS);
    private JComboBox<String> toppings2 = new JComboBox<String>(PIZZATOPPINGS);
    private JComboBox<String> toppings3 = new JComboBox<String>(PIZZATOPPINGS);
    private JComboBox<String> toppings4 = new JComboBox<String>(PIZZATOPPINGS);
    private JComboBox<String> toppings5 = new JComboBox<String>(PIZZATOPPINGS);
    private JComboBox<String> toppings6 = new JComboBox<String>(PIZZATOPPINGS);
    private JComboBox<String> toppings7 = new JComboBox<String>(PIZZATOPPINGS);
    private JComboBox<String> toppings8 = new JComboBox<String>(PIZZATOPPINGS);
    private JComboBox<String> toppings9 = new JComboBox<String>(PIZZATOPPINGS);
    private JComboBox<String> toppings10 = new JComboBox<String>(PIZZATOPPINGS);
    private JComboBox<String> toppings11 = new JComboBox<String>(PIZZATOPPINGS);
    private JComboBox<String> toppings12 = new JComboBox<String>(PIZZATOPPINGS);
    private JComboBox<String> toppings13 = new JComboBox<String>(PIZZATOPPINGS);
    private JComboBox<String> toppings14 = new JComboBox<String>(PIZZATOPPINGS);
    private JComboBox<String> toppings15 = new JComboBox<String>(PIZZATOPPINGS);
    private JComboBox<String> toppings16 = new JComboBox<String>(PIZZATOPPINGS);
    private JComboBox<String> soda1 = new JComboBox<String>(SODA);
    private JComboBox<String> soda2 = new JComboBox<String>(SODA);
    private JComboBox<String> soda3 = new JComboBox<String>(SODA);
    private JComboBox<String> soda4 = new JComboBox<String>(SODA);
    private JComboBox<String> soda5 = new JComboBox<String>(SODA);
    private JComboBox<String> wings = new JComboBox<String>(WINGS);
    private JComboBox<String> bone = new JComboBox<String>(BONE);
    private JComboBox<String> sticksOrSalad = new JComboBox<String>(SOS);

    private JLabel sosLabel = new JLabel("Bread Sticks or Salad: ");
    private JLabel sasLabel = new JLabel("Comes With Bread Sticks and Salad --- ");
    private JLabel sodaLabel1 = new JLabel("Soda #1: ");
    private JLabel sodaLabel2 = new JLabel("Soda #2: ");
    private JLabel sodaLabel3 = new JLabel("Soda #3: ");
    private JLabel sodaLabel4 = new JLabel("Soda #4: ");
    private JLabel sodaLabel5 = new JLabel("Soda #5: ");
    private JLabel wingsLabel = new JLabel("Wings Flavor: ");
    private JLabel iceCreamLabel = new JLabel("Ice Cream Flavors: ");
    private JLabel Pizza1 = new JLabel("Pizza #1: ");
    private JLabel Pizza2 = new JLabel("Pizza #2: ");
    private JLabel Pizza3 = new JLabel("Pizza #3: ");
    private JLabel Pizza4 = new JLabel("Pizza #4: ");
    private JLabel boneLabel = new JLabel("Bone In or Bone Out?: ");

    private JButton deleteButton = new JButton("Delete Reservation");

    private static PartyGoer currentPartyGoer;

    Client client = new Client();

    ArrayList<ArrayList<PartyRoom>> ROOM_TYPE_OBJECTS = client.getROOM_TYPE_OBJECTS();

    private static int ender = 0;

    private static ArrayList<String> monthsToAdd;

    private JButton acceptButton;

//    public EditReservationFrame() {
//        frame = new JFrame();
//        panel = new JPanel();
//
//        frame.setTitle("New Reservation");
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//        this.monthStrings = getMonthStrings();
//        guestInfo();
//        upgrades();
//        mealPlans();
//        generateRooms();
//        currentDate();
//    }

//    private void generateRooms() {
//        for (int i = 0; i < 10; i++) {
//            smallPartyRooms.add(partyRoomFactory.smallFactory());
//        }
//        for (int i = 0; i < 2; i++) {
//            medPartyRooms.add(partyRoomFactory.mediumFactory());
//        }
//        for (int i = 0; i < 10; i++) {
//            karaokeLounges.add(partyRoomFactory.karaokeFactory());
//        }
//        for (int i = 0; i < 5; i++) {
//            adultBilliardsLounges.add(partyRoomFactory.loungeFactory());
//        }
//        aquaWorlds.add(partyRoomFactory.aquaFactory());
//
//    }

//    public void edit(int i) {
//        frame.setTitle("Edit Reservation");
//        deleteButton = new JButton("Delete Reservation");
//        //acceptButton = new JButton("Edit Reservation");
//        //panel.add(acceptButton);
//        panel.add(deleteButton);
//        panel.revalidate();
//    }

    public void currentDate() {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        System.out.println(calendar.get(Calendar.MONTH) + "/"  + calendar.get(Calendar.DAY_OF_MONTH)  + "/" + calendar.get(Calendar.YEAR));

    }



    public void guestInfo(PartyGoer p) {

        monthLabel = new JLabel("Month: ");
        dayLabel = new JLabel("Day: ");
        yearLabel = new JLabel("Year: ");
        startTimeLabel = new JLabel("Start Time: ");
        endTimeLabel = new JLabel("End Time: ");


        nameField = new JTextField(5);
        nameField.setText(p.getName());
        nameLabel = new JLabel("Name");
        phoneNumField = new JTextField(5);
        phoneNumField.setText(p.getPhoneNum());
        phoneNumLabel = new JLabel("Phone number");
        addressField = new JTextField(5);
        addressField.setText(p.getAddress());
        addressLabel = new JLabel("Address");
        emailField = new JTextField(10);
        emailField.setText(p.getAddress());
        emailLabel = new JLabel("Email address");
        dateOfBirth = new JLabel("Date of birth");
        cardName = new JTextField(5);
        cardName.setText(p.getNameOnCard());
        cardNameLabel = new JLabel("Name on card: ");

        initialMonthIndex = dateTimeFrame.getMonthIndex();
        initialDayIndex = dateTimeFrame.getDayIndex();
        initialYearIndex = dateTimeFrame.getYearIndex();
        initialStartTimeIndex = dateTimeFrame.getStartTimeIndex();
        initialEndTimeIndex = dateTimeFrame.getEndTimeIndex();

        monthsToAdd = new ArrayList<>();
        for (int i = 0; i < monthStrings.length; i++) {
            monthsToAdd.add(monthStrings[i]);
        }

        //SpinnerListModel monthModel = new SpinnerListModel(monthStrings);
        SpinnerModel monthModel = new SpinnerNumberModel(1, 1, monthsToAdd.size(), 1);
        if (initialMonthIndex != -1) {
            //monthModel = new SpinnerListModel(monthsToAdd.subList(initialMonthIndex, monthsToAdd.size()));
            monthModel = new SpinnerNumberModel(initialMonthIndex + 1, 1, monthsToAdd.size(), 1);
        }

        //Month spinner
        monthSpinner = new JSpinner(monthModel);
        Dimension dimension = monthSpinner.getPreferredSize();
        dimension.width = 82;
        monthSpinner.setPreferredSize(dimension);

        //monthSpinner.getValue();

        //Make 31 days
        ArrayList<Integer> dayInts = new ArrayList<>();
        for (int i = 1; i < 32; i++) {
            dayInts.add(i);
        }

        //Make years
        ArrayList<Integer> yearInts = new ArrayList<>();
        for (int i = 2019; i <= 2021; i++) {
            yearInts.add(i);
        }

        SpinnerModel dayModel = new SpinnerNumberModel(1, 1, dayInts.size(), 1);
        if (initialDayIndex != -1) {
            dayModel = new SpinnerNumberModel(initialDayIndex + 1, 1, dayInts.size(), 1);
        }

        //Make day spinner
        daySpinner = new JSpinner(dayModel);
        Dimension dimension2 = daySpinner.getPreferredSize();
        dimension2.width = 50;
        daySpinner.setPreferredSize(dimension2);

        SpinnerModel yearModel = new SpinnerNumberModel(2019, 2019, 2021, 1);
        if (initialYearIndex != -1) {
            initialYearIndex = yearInts.get(initialYearIndex);
            yearModel = new SpinnerNumberModel(initialYearIndex, 2019, 2021, 1);
        }

        //Year spinner
        yearSpinner = new JSpinner(yearModel);
        editor = new JSpinner.NumberEditor(yearSpinner, "#");
        yearSpinner.setEditor(editor);
        Dimension dimension3 = yearSpinner.getPreferredSize();
        dimension3.width = 70;
        yearSpinner.setPreferredSize(dimension3);

        int j = 0;
        //17
        int amPmCount = 0;
        //String finalString = "";
        for (int i = 900; i < 2615; i += 15) {
            amPmCount++;
            j += 15;
            if (i % 100 == 60) {
                i += 40;
                j += 40;

            }
            j = i;
            if (i >= 1300) {
                j -= 1200;
            }
            if (i >= 2500) {
                j -= 1200;
            }
            if (amPmCount <= 12 || amPmCount >= 61) {
                StringBuilder str = new StringBuilder(Integer.toString(j));
                str = str.insert(Integer.toString(j).length() - 2, ":");
                //finalString = str.toString() + " AM";
                timeInts.add(str.toString() + " AM");
            }
            else if (amPmCount >= 12 && amPmCount <= 61) {
                StringBuilder str = new StringBuilder(Integer.toString(j));
                str = str.insert(Integer.toString(j).length() - 2, ":");
                //finalString = str.toString() + " PM";
                timeInts.add(str.toString() + " PM");
            }
        }

        //Manipulating array for book now button does not work currently

        initialRoomIndex = dateTimeFrame.getFoundRoomIndex();
        initialRoomDisplay = roomTypes[initialRoomIndex];
        if (initialRoomDisplay.equals("Small Party Room")) {
            ender = 8;
            roomNumberBox = new JComboBox<Integer>();
            for (int i = 1; i <= 10; i++) {
                roomNumberBox.addItem(i);
            }

            startTimesBox = new JComboBox<String>();
            startTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 9).toArray()));
            if (initialStartTimeIndex != 0) {
                startTimesBox.setSelectedIndex(initialStartTimeIndex - 4);
            }
            //End time spinner
            endTimesBox = new JComboBox<String>();
            endTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 8).toArray()));
            if (initialStartTimeIndex != 0) {
                endTimesBox.setSelectedIndex(initialEndTimeIndex - 4);
            }
        }
        else if (initialRoomDisplay.equals("Medium Party Room")) {
            ender = 8;

            roomNumberBox = new JComboBox<Integer>();
            for (int i = 1; i <= 2; i++) {
                roomNumberBox.addItem(i);
            }

            startTimesBox = new JComboBox<String>();
            startTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 9).toArray()));
            if (initialStartTimeIndex != 0) {
                startTimesBox.setSelectedIndex(initialStartTimeIndex - 4);
            }
            //End time spinner
            endTimesBox = new JComboBox<String>();
            endTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 8).toArray()));
            if (initialStartTimeIndex != 0) {
                endTimesBox.setSelectedIndex(initialEndTimeIndex - 4);
            }

        }
        else if (initialRoomDisplay.equals("Aqua World")) {
            ender = 8;

            roomNumberBox = new JComboBox<Integer>();

            roomNumberBox.addItem(1);


            startTimesBox = new JComboBox<String>();
            startTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 9).toArray()));
            if (initialStartTimeIndex != 0) {
                startTimesBox.setSelectedIndex(initialStartTimeIndex - 4);
            }
            //End time spinner
            endTimesBox = new JComboBox<String>();
            endTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 8).toArray()));
            if (initialStartTimeIndex != 0) {
                endTimesBox.setSelectedIndex(initialEndTimeIndex - 4);
            }
        }
        else if (initialRoomDisplay.equals("Karaoke Lounge")) {
            ender = 4;

            roomNumberBox = new JComboBox<Integer>();
            for (int i = 1; i <= 10; i++) {
                roomNumberBox.addItem(i);
            }

            startTimesBox = new JComboBox<String>();
            startTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 5).toArray()));
            if (initialStartTimeIndex != 0) {
                startTimesBox.setSelectedIndex(initialStartTimeIndex - 4);
            }
            //End time spinner
            endTimesBox = new JComboBox<String>();
            endTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 4).toArray()));
            if (initialStartTimeIndex != 0) {
                endTimesBox.setSelectedIndex(initialEndTimeIndex - 4);
            }
        }
        else if (initialRoomDisplay.equals("Adult Billiards Lounge")) {
            ender = 4;

            roomNumberBox = new JComboBox<Integer>();
            for (int i = 1; i <= 5; i++) {
                roomNumberBox.addItem(i);
            }

            startTimesBox = new JComboBox<String>();
            startTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 5).toArray()));
            if (initialStartTimeIndex != 0) {
                startTimesBox.setSelectedIndex(initialStartTimeIndex - 4);
            }
            //End time spinner
            endTimesBox = new JComboBox<String>();
            endTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 4).toArray()));
            if (initialStartTimeIndex != 0) {
                endTimesBox.setSelectedIndex(initialEndTimeIndex - 4);
            }
        }

        roomTypeBox = new JComboBox<String>(roomTypes);
        roomTypeBox.setSelectedIndex(initialRoomIndex);

        monthSpinner.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {

                String value = monthSpinner.getValue().toString();
                if (value.equals("February")) {
                    panel.remove(daySpinner);
                    panel.remove(yearLabel);
                    panel.remove(yearSpinner);
                    panel.remove(startTimeLabel);
                    panel.remove(startTimesBox);
                    panel.remove(endTimeLabel);
                    panel.remove(endTimesBox);
                    panel.remove(partyBagLabel);
                    panel.remove(partyBagsBox);
                    panel.remove(projectorLabel);
                    panel.remove(projectorBox);
                    panel.remove(decorationsLabel);
                    panel.remove(partyDecorationsBox);
                    panel.remove(cancelButton);
                    panel.remove(reserveButton);
                    panel.remove(deleteButton);
                    panel.remove(cancelButton);
                    panel.remove(reserveButton);
                    panel.remove(roomNumberBox);
                    panel.remove(monthLabel);
                    panel.remove(monthSpinner);
                    panel.remove(dayLabel);
                    panel.remove(daySpinner);
                    panel.remove(yearLabel);
                    panel.remove(yearSpinner);
                    panel.remove(startTimeLabel);
                    panel.remove(startTimesBox);
                    panel.remove(endTimeLabel);
                    panel.remove(endTimesBox);
                    panel.remove(sosLabel);
                    panel.remove(sticksOrSalad);
                    panel.remove(sodaLabel5);
                    panel.remove(soda5);
                    panel.remove(toppings4);
                    panel.remove(toppings5);
                    panel.remove(toppings6);
                    panel.remove(toppings7);
                    panel.remove(toppings8);
                    panel.remove(toppings9);
                    panel.remove(toppings10);
                    panel.remove(toppings11);
                    panel.remove(toppings12);
                    panel.remove(toppings10);
                    panel.remove(toppings11);
                    panel.remove(toppings12);
                    panel.remove(toppings13);
                    panel.remove(toppings14);
                    panel.remove(toppings15);
                    panel.remove(toppings16);
                    panel.remove(sodaLabel4);
                    panel.remove(soda4);
                    panel.remove(Pizza4);
                    panel.remove(sasLabel);
                    panel.remove(boneLabel);
                    panel.remove(bone);
                    panel.remove(wingsLabel);
                    panel.remove(wings);
                    panel.remove(iceCreamLabel);
                    panel.remove(iceCream1);
                    panel.remove(iceCream2);
                    panel.remove(sodaLabel1);
                    panel.remove(soda1);
                    panel.remove(sodaLabel2);
                    panel.remove(soda2);
                    panel.remove(sodaLabel3);
                    panel.remove(soda3);
                    panel.remove(Pizza1);
                    panel.remove(toppings1);
                    panel.remove(Pizza2);
                    panel.remove(toppings2);
                    panel.remove(Pizza3);
                    panel.remove(toppings3);
                    panel.remove(partyBagLabel);
                    panel.remove(partyBagsBox);
                    panel.remove(projectorLabel);
                    panel.remove(projectorBox);
                    panel.remove(decorationsLabel);
                    panel.remove(partyDecorationsBox);
                    panel.remove(mealPlanBox);
                    panel.remove(towelLabel);
                    panel.remove(towelBox);
                    panel.repaint();


                    SpinnerListModel dayModel = new SpinnerListModel(dayInts.subList(0, 28));
                    daySpinner = new JSpinner(dayModel);
                    Dimension dimension = daySpinner.getPreferredSize();
                    dimension.width = 50;
                    daySpinner.setPreferredSize(dimension);

                    panel.add(roomNumberBox);
                    panel.add(monthLabel);
                    panel.add(monthSpinner);
                    panel.add(dayLabel);
                    panel.add(daySpinner);
                    panel.add(yearLabel);
                    panel.add(yearSpinner);
                    panel.add(startTimeLabel);
                    panel.add(startTimesBox);
                    panel.add(endTimeLabel);
                    panel.add(endTimesBox);
                    panel.add(partyBagLabel);
                    panel.add(partyBagsBox);
                    panel.add(projectorLabel);
                    panel.add(projectorBox);
                    panel.add(decorationsLabel);
                    panel.add(partyDecorationsBox);
                    panel.add(mealPlanBox);
                    panel.add(cancelButton);
                    panel.add(reserveButton);
                    panel.add(deleteButton);
                    panel.revalidate();
                }
                else if (value.equals("April") || value.equals("June") || value.equals("September") || value.equals("November")) {
                    panel.remove(daySpinner);
                    panel.remove(yearLabel);
                    panel.remove(yearSpinner);
                    panel.remove(startTimeLabel);
                    panel.remove(startTimesBox);
                    panel.remove(endTimeLabel);
                    panel.remove(endTimesBox);
                    panel.remove(cancelButton);
                    panel.remove(reserveButton);
                    panel.remove(deleteButton);
                    panel.remove(partyBagLabel);
                    panel.remove(partyBagsBox);
                    panel.remove(projectorLabel);
                    panel.remove(projectorBox);
                    panel.remove(decorationsLabel);
                    panel.remove(partyDecorationsBox);
                    panel.remove(cancelButton);
                    panel.remove(reserveButton);
                    panel.remove(roomNumberBox);
                    panel.remove(monthLabel);
                    panel.remove(monthSpinner);
                    panel.remove(dayLabel);
                    panel.remove(daySpinner);
                    panel.remove(yearLabel);
                    panel.remove(yearSpinner);
                    panel.remove(startTimeLabel);
                    panel.remove(startTimesBox);
                    panel.remove(endTimeLabel);
                    panel.remove(endTimesBox);
                    panel.remove(sosLabel);
                    panel.remove(sticksOrSalad);
                    panel.remove(sodaLabel5);
                    panel.remove(soda5);
                    panel.remove(toppings4);
                    panel.remove(toppings5);
                    panel.remove(toppings6);
                    panel.remove(toppings7);
                    panel.remove(toppings8);
                    panel.remove(toppings9);
                    panel.remove(toppings10);
                    panel.remove(toppings11);
                    panel.remove(toppings12);
                    panel.remove(toppings10);
                    panel.remove(toppings11);
                    panel.remove(toppings12);
                    panel.remove(toppings13);
                    panel.remove(toppings14);
                    panel.remove(toppings15);
                    panel.remove(toppings16);
                    panel.remove(sodaLabel4);
                    panel.remove(soda4);
                    panel.remove(Pizza4);
                    panel.remove(sasLabel);
                    panel.remove(boneLabel);
                    panel.remove(bone);
                    panel.remove(wingsLabel);
                    panel.remove(wings);
                    panel.remove(iceCreamLabel);
                    panel.remove(iceCream1);
                    panel.remove(iceCream2);
                    panel.remove(sodaLabel1);
                    panel.remove(soda1);
                    panel.remove(sodaLabel2);
                    panel.remove(soda2);
                    panel.remove(sodaLabel3);
                    panel.remove(soda3);
                    panel.remove(Pizza1);
                    panel.remove(toppings1);
                    panel.remove(Pizza2);
                    panel.remove(toppings2);
                    panel.remove(Pizza3);
                    panel.remove(toppings3);
                    panel.remove(partyBagLabel);
                    panel.remove(partyBagsBox);
                    panel.remove(projectorLabel);
                    panel.remove(projectorBox);
                    panel.remove(decorationsLabel);
                    panel.remove(partyDecorationsBox);
                    panel.remove(mealPlanBox);
                    panel.remove(towelLabel);
                    panel.remove(towelBox);
                    panel.repaint();


                    SpinnerListModel dayModel = new SpinnerListModel(dayInts.subList(0, 30));
                    daySpinner = new JSpinner(dayModel);
                    Dimension dimension = daySpinner.getPreferredSize();
                    dimension.width = 50;
                    daySpinner.setPreferredSize(dimension);

                    panel.add(roomNumberBox);
                    panel.add(monthLabel);
                    panel.add(monthSpinner);
                    panel.add(dayLabel);
                    panel.add(daySpinner);
                    panel.add(yearLabel);
                    panel.add(yearSpinner);
                    panel.add(startTimeLabel);
                    panel.add(startTimesBox);
                    panel.add(endTimeLabel);
                    panel.add(endTimesBox);
                    panel.add(partyBagLabel);
                    panel.add(partyBagsBox);
                    panel.add(projectorLabel);
                    panel.add(projectorBox);
                    panel.add(decorationsLabel);
                    panel.add(partyDecorationsBox);
                    panel.add(mealPlanBox);
                    panel.add(cancelButton);
                    panel.add(reserveButton);
                    panel.add(deleteButton);
                    panel.revalidate();

                }
                else {
                    panel.remove(daySpinner);
                    panel.remove(yearLabel);
                    panel.remove(yearSpinner);
                    panel.remove(startTimeLabel);
                    panel.remove(startTimesBox);
                    panel.remove(endTimeLabel);
                    panel.remove(endTimesBox);
                    panel.remove(partyBagLabel);
                    panel.remove(partyBagsBox);
                    panel.remove(projectorLabel);
                    panel.remove(projectorBox);
                    panel.remove(decorationsLabel);
                    panel.remove(partyDecorationsBox);
                    panel.remove(cancelButton);
                    panel.remove(reserveButton);
                    panel.remove(deleteButton);
                    panel.remove(cancelButton);
                    panel.remove(reserveButton);
                    panel.remove(roomNumberBox);
                    panel.remove(monthLabel);
                    panel.remove(monthSpinner);
                    panel.remove(dayLabel);
                    panel.remove(daySpinner);
                    panel.remove(yearLabel);
                    panel.remove(yearSpinner);
                    panel.remove(startTimeLabel);
                    panel.remove(startTimesBox);
                    panel.remove(endTimeLabel);
                    panel.remove(endTimesBox);
                    panel.remove(sosLabel);
                    panel.remove(sticksOrSalad);
                    panel.remove(sodaLabel5);
                    panel.remove(soda5);
                    panel.remove(toppings4);
                    panel.remove(toppings5);
                    panel.remove(toppings6);
                    panel.remove(toppings7);
                    panel.remove(toppings8);
                    panel.remove(toppings9);
                    panel.remove(toppings10);
                    panel.remove(toppings11);
                    panel.remove(toppings12);
                    panel.remove(toppings10);
                    panel.remove(toppings11);
                    panel.remove(toppings12);
                    panel.remove(toppings13);
                    panel.remove(toppings14);
                    panel.remove(toppings15);
                    panel.remove(toppings16);
                    panel.remove(sodaLabel4);
                    panel.remove(soda4);
                    panel.remove(Pizza4);
                    panel.remove(sasLabel);
                    panel.remove(boneLabel);
                    panel.remove(bone);
                    panel.remove(wingsLabel);
                    panel.remove(wings);
                    panel.remove(iceCreamLabel);
                    panel.remove(iceCream1);
                    panel.remove(iceCream2);
                    panel.remove(sodaLabel1);
                    panel.remove(soda1);
                    panel.remove(sodaLabel2);
                    panel.remove(soda2);
                    panel.remove(sodaLabel3);
                    panel.remove(soda3);
                    panel.remove(Pizza1);
                    panel.remove(toppings1);
                    panel.remove(Pizza2);
                    panel.remove(toppings2);
                    panel.remove(Pizza3);
                    panel.remove(toppings3);
                    panel.remove(partyBagLabel);
                    panel.remove(partyBagsBox);
                    panel.remove(projectorLabel);
                    panel.remove(projectorBox);
                    panel.remove(decorationsLabel);
                    panel.remove(partyDecorationsBox);
                    panel.remove(mealPlanBox);
                    panel.remove(towelLabel);
                    panel.remove(towelBox);
                    panel.repaint();

                    SpinnerListModel dayModel = new SpinnerListModel(dayInts);
                    daySpinner = new JSpinner(dayModel);
                    Dimension dimension = daySpinner.getPreferredSize();
                    dimension.width = 50;
                    daySpinner.setPreferredSize(dimension);

                    panel.add(roomNumberBox);
                    panel.add(monthLabel);
                    panel.add(monthSpinner);
                    panel.add(dayLabel);
                    panel.add(daySpinner);
                    panel.add(yearLabel);
                    panel.add(yearSpinner);
                    panel.add(startTimeLabel);
                    panel.add(startTimesBox);
                    panel.add(endTimeLabel);
                    panel.add(endTimesBox);
                    panel.add(partyBagLabel);
                    panel.add(partyBagsBox);
                    panel.add(projectorLabel);
                    panel.add(projectorBox);
                    panel.add(decorationsLabel);
                    panel.add(partyDecorationsBox);
                    panel.add(mealPlanBox);
                    panel.add(cancelButton);
                    panel.add(reserveButton);
                    panel.add(deleteButton);
                    panel.revalidate();
                }
            }
        });

        roomTypeBox.addActionListener(new guestInfoListener());

        year = new JComboBox<Integer>();
        month = new JComboBox<Integer>();
        day = new JComboBox<Integer>();


        reserveButton = new JButton("Reserve");
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new guestInfoListener());
        reserveButton.addActionListener(new guestInfoListener());
        deleteButton.addActionListener(new guestInfoListener());

        creditCardInfoLabel = new JLabel("Card information");
        cardNumberLabel = new JLabel("Card number: ");
        securityCodeLabel = new JLabel("Security code (3 digits)");
        expirationDateLabel = new JLabel("Expiration date");

        cardNumberField = new JTextField(15);
        cardNumberField.setText(p.getCardNum());
        securityCodeField = new JTextField(5);
        securityCodeField.setText(p.getSecCode());
        expirationMonth = new JComboBox<Integer>();
        expirationYear = new JComboBox<Integer>();

        // setting 12 months in the month dropdown menu
        for (int i = 1; i <= 12; i++) {
            month.addItem(i);
            expirationMonth.addItem(i);
        }
        // Settings the amount of days per month
        for (int i = 1; i <= 30; i++) {
            day.addItem(i);
        }
        // Settings years for date of birth
        for (int i = 2019; i >= 1900; i--) {
            year.addItem(i);

        }
        // Setting years for expiration date for credit card
        for (int i = 2019; i <= 2030; i++) {
            expirationYear.addItem(i);
        }

//        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
//        experimentLayout.setAlignment(FlowLayout.TRAILING);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(phoneNumLabel);
        panel.add(phoneNumField);
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(dateOfBirth);
        panel.add(month);
        panel.add(day);
        panel.add(year);
        panel.add(contactPreferenceLabel);
        panel.add(phonePreferenceBox);
        panel.add(emailPreferenceLabel);
        panel.add(emailPreferenceBox);
        //panel.add(creditCardInfoLabel);
        panel.add(visaLabel);
        panel.add(visaCardBox);
        panel.add(masterCardLabel);
        panel.add(masterCardBox);
        panel.add(americanExpressLabel);
        panel.add(americanExpressBox);
        //panel.add(creditCardInfoLabel);
        panel.add(cardNameLabel);
        panel.add(cardName);
        panel.add(cardNumberLabel);
        panel.add(cardNumberField);
        panel.add(securityCodeLabel);
        panel.add(securityCodeField);
        panel.add(expirationDateLabel);
        panel.add(expirationMonth);
        panel.add(expirationYear);
        panel.add(roomTypeBox);
        panel.add(roomNumberBox);
        panel.add(monthLabel);
        panel.add(monthSpinner);
        panel.add(dayLabel);
        panel.add(daySpinner);
        panel.add(yearLabel);
        panel.add(yearSpinner);
        panel.add(startTimeLabel);
//        panel.add(timeSpinner);
        panel.add(startTimesBox);
        panel.add(partyBagLabel);
        panel.add(partyBagsBox);
        panel.add(projectorLabel);
        panel.add(projectorBox);
        panel.add(decorationsLabel);
        panel.add(partyDecorationsBox);
        panel.add(endTimeLabel);
        panel.add(endTimesBox);



    }

    public void mealPlans() {

        mealPlanBox = new JComboBox<String>(MEALPLANS);
        panel.add(mealPlanBox);
        panel.add(sodaLabel1);
        panel.add(soda1);
        panel.add(sodaLabel2);
        panel.add(soda2);
        panel.add(sodaLabel3);
        panel.add(soda3);
        panel.add(Pizza1);
        panel.add(toppings1);
        panel.add(Pizza2);
        panel.add(toppings2);
        panel.add(Pizza3);
        panel.add(toppings3);
        panel.add(reserveButton);
        panel.add(deleteButton);
        panel.add(cancelButton);
        frame.add(panel);

        mealPlanBox.addActionListener(new MealPlanListener());


    }
    public void upgrades() {
        panel.add(partyBagLabel);
        panel.add(partyBagsBox);
        panel.add(projectorLabel);
        panel.add(projectorBox);
        panel.add(decorationsLabel);
        panel.add(partyDecorationsBox);
        panel.add(reserveButton);
        panel.add(deleteButton);
        panel.add(cancelButton);



    }

    static protected String[] getMonthStrings() {
        String[] months = new java.text.DateFormatSymbols().getMonths();
        int lastIndex = months.length - 1;

        if (months[lastIndex] == null
                || months[lastIndex].length() <= 0) { //last item empty
            String[] monthStrings = new String[lastIndex];
            System.arraycopy(months, 0,
                    monthStrings, 0, lastIndex);
            return monthStrings;
        } else { //last item not empty
            return months;
        }
    }

    class guestInfoListener implements ActionListener {
        JLabel ageCheck = new JLabel("You are not old enough");
        JLabel timeNotValid = new JLabel("Reservation time not valid.");
        boolean waitlistCheck = false;

        @Override
        public void actionPerformed(ActionEvent e) {
            String roomType = (String) roomTypeBox.getSelectedItem();
            String startTime = (String) startTimesBox.getSelectedItem();
            String endTime = (String) endTimesBox.getSelectedItem();

            //Guest information to save
            String tempName = nameField.getText();
            String tempPhoneNum = phoneNumField.getText();
            String tempAddress = addressField.getText();

            int tempDay = (Integer) day.getSelectedItem();
            int tempMonth = (Integer) month.getSelectedItem();
            int tempYear = (Integer) year.getSelectedItem();

            String tempCreditCardInfo = cardNumberField.getText();
            String tempEmail = emailField.getText();
            String tempCardName = cardName.getText();
            int tempExpirationMonth = (Integer) expirationMonth.getSelectedItem();
            int tempExpirationYear = (Integer) expirationYear.getSelectedItem();

            ArrayList<ArrayList<PartyRoom>> ROOM_TYPE_OBJECTS = new ArrayList<>();
//            ROOM_TYPE_OBJECTS.add(smallPartyRooms);
//            ROOM_TYPE_OBJECTS.add(medPartyRooms);
//            ROOM_TYPE_OBJECTS.add(aquaWorlds);
//            ROOM_TYPE_OBJECTS.add(karaokeLounges);
//            ROOM_TYPE_OBJECTS.add(adultBilliardsLounges);


            if (e.getSource() == reserveButton) {

                if (mealPlanBox.getSelectedItem().equals("Basic Meal Plan")) {
                    MealPlan baMealPlan = new basicMeal((String) soda1.getSelectedItem(), (String) soda2.getSelectedItem(), (String) soda3.getSelectedItem(), (String) toppings1.getSelectedItem(),
                            (String) toppings2.getSelectedItem(), (String) toppings3.getSelectedItem());
                }
//                else if (mealPlanBox.getSelectedItem().equals("Bronze Meal Plan")) {
//                    MealPlan brMealPlan = new bronzeMeal((String) sticksOrSalad.getSelectedItem(), (String) soda1.getSelectedItem(), (String) soda2.getSelectedItem(), (String) soda3.getSelectedItem(), (String) toppings1.getSelectedItem(),
//                            (String) toppings2.getSelectedItem(), (String) toppings3.getSelectedItem());
//                }
//                else if (mealPlanBox.getSelectedItem().equals("Silver Meal Plan")) {
//                    MealPlan baMealPlan = new basicMeal((String) soda1.getSelectedItem(), (String) soda2.getSelectedItem(), (String) soda3.getSelectedItem(), (String) toppings1.getSelectedItem(),
//                            (String) toppings2.getSelectedItem(), (String) toppings3.getSelectedItem());
//                }
//                else if (mealPlanBox.getSelectedItem().equals("Gold Meal Plan")) {
//                    MealPlan baMealPlan = new basicMeal((String) soda1.getSelectedItem(), (String) soda2.getSelectedItem(), (String) soda3.getSelectedItem(), (String) toppings1.getSelectedItem(),
//                            (String) toppings2.getSelectedItem(), (String) toppings3.getSelectedItem());
//                }
//                else if (mealPlanBox.getSelectedItem().equals("Platnium Meal Plan")) {
//                    MealPlan baMealPlan = new basicMeal((String) soda1.getSelectedItem(), (String) soda2.getSelectedItem(), (String) soda3.getSelectedItem(), (String) toppings1.getSelectedItem(),
//                            (String) toppings2.getSelectedItem(), (String) toppings3.getSelectedItem());
//                }


                LocalDate today = LocalDate.now();
                LocalDate birthDay = LocalDate.of(1998, 5, 15);
                int years = Period.between(birthDay, today).getYears();
                panel.remove(ageCheck);
                panel.repaint();

                if (years <= 21 && roomType.equals("Adult Billiards Lounge")) {

                    panel.add(ageCheck);
                    panel.revalidate();

                }

//                ArrayList<ArrayList<PartyRoom>> ROOM_TYPE_OBJECTS = new ArrayList<>();
//                ROOM_TYPE_OBJECTS.add(smallPartyRooms);
//                ROOM_TYPE_OBJECTS.add(medPartyRooms);
//                ROOM_TYPE_OBJECTS.add(aquaWorlds);
//                ROOM_TYPE_OBJECTS.add(karaokeLounges);
//                ROOM_TYPE_OBJECTS.add(adultBilliardsLounges);
                String[] ROOM_TYPES = {"Small Party Room", "Medium Party Room", "Aqua World", "Karaoke Lounge", "Adult Billiards Lounge"};

                String numString = "";
                String numStringEnd = "";

                for (int i = 0; i < startTime.length(); i++) {
                    char c = startTime.charAt(i);
                    if (Character.isDigit(c)) {
                        numString += c;
                    }
                }

                String[] startTimes = startTime.split("\\s+");
                String AMPM = startTimes[1];
                int milStartTimeInt = 0;
                milStartTimeInt = Integer.parseInt(numString);

                if (AMPM.equals("PM")) {
                    if (milStartTimeInt != 1200) {
                        milStartTimeInt += 1200;
                    }
                }
                else if (AMPM.equals("AM") && milStartTimeInt == 1200) {
                    milStartTimeInt += 1200;
                }

                for (int i = 0; i < endTime.length(); i++) {
                    char c = endTime.charAt(i);
                    if (Character.isDigit(c)) {
                        numStringEnd += c;
                    }
                }

                String[] startTimes2 = endTime.split("\\s+");
                String AMPM2 = startTimes2[1];
                int milEndTimeInt = 0;
                milEndTimeInt = Integer.parseInt(numStringEnd);
                if (AMPM2.equals("PM")) {
                    if (milEndTimeInt != 1200) {
                        milEndTimeInt += 1200;
                    }
                }
                else if (AMPM2.equals("AM") && milEndTimeInt == 1200) {
                    milEndTimeInt += 1200;
                }

                int monthInt = 0;
                for (int i = 1; i < 13; i++) {
                    if (i == Integer.parseInt(monthSpinner.getValue().toString())) {
                        monthInt = i;
                    }
                }

                panel.remove(timeNotValid);
                panel.repaint();
                if (milEndTimeInt <= milStartTimeInt) {
                    panel.add(timeNotValid);
                    panel.revalidate();
                }

                else {
//                    partyGoer = new PartyGoer(nameField.getText(), phoneNumField.getText(), emailField.getText(), addressField.getText(), roomTypeBox.getSelectedItem().toString(),
//                            month.getSelectedItem().toString(), day.getSelectedItem().toString(), year.getSelectedItem().toString(), phonePreferenceBox.isSelected(), emailPreferenceBox.isSelected(), visaCardBox.isSelected(),
//                            masterCardBox.isSelected(), americanExpressBox.isSelected(), cardName.getText(), cardNumberField.getText(), securityCodeField.getText(), expirationMonth.getSelectedItem().toString(),
//                            expirationYear.getSelectedItem().toString(), (int) roomNumberBox.getSelectedItem(), (int) monthSpinner.getValue(), (int) daySpinner.getValue(), (int) yearSpinner.getValue(),
//                            milStartTimeInt, milEndTimeInt, partyBagsBox.isSelected(), projectorBox.isSelected(), partyDecorationsBox.getSelectedItem().toString(),
//                            mealPlanBox.getSelectedItem().toString());
                    waitlistCheck = ROOM_TYPE_OBJECTS.get((int) roomTypeBox.getSelectedIndex()).get((int) (roomNumberBox.getSelectedItem()) - 1).reserveRoom(monthInt, Integer.parseInt(daySpinner.getValue().toString()), Integer.parseInt(yearSpinner.getValue().toString()), milStartTimeInt, milEndTimeInt, currentPartyGoer, true);
                    //globalPartyGoerList.add(partyGoer);

                    if (waitlistCheck) {
                        WaitlistFrame waitlistFrame = new WaitlistFrame(ROOM_TYPE_OBJECTS.get((int) roomTypeBox.getSelectedIndex()).get((int) roomNumberBox.getSelectedItem() - 1), Integer.parseInt(daySpinner.getValue().toString()), monthInt,Integer.parseInt(yearSpinner.getValue().toString()), milStartTimeInt, milEndTimeInt, currentPartyGoer);
                        boolean tempCheck = waitlistFrame.getStatus();
                        if (!tempCheck) {
                            frame.setVisible(false);

                        }
                    }
                    else {
                        MainFrame mainFrame = new MainFrame();
                        frame.setVisible(false);
                    }
                }

            }

            else if (e.getSource() == cancelButton) {
                MainFrame mainFrame = new MainFrame();
                frame.setVisible(false);
            }

            else if (e.getSource() == deleteButton) {
                System.out.println("made it");
                System.out.println((int)roomTypeBox.getSelectedIndex());
                System.out.println((int) (roomNumberBox.getSelectedItem()) - 1);
                System.out.println(currentPartyGoer.getName());
                System.out.println(ROOM_TYPE_OBJECTS);
                client.getROOM_TYPE_OBJECTS().get((int) roomTypeBox.getSelectedIndex()).get((int) (roomNumberBox.getSelectedItem()) - 1).removeReservation(currentPartyGoer);

            }

            else if (e.getSource() == roomTypeBox) {
                if (roomType.equals("Small Party Room")) {
                    aRoomType = "Small Party Room";
                    roomNumberBox.removeAllItems();

                    panel.remove(timeNotValid);
                    panel.remove(ageCheck);
                    panel.remove(cancelButton);
                    panel.remove(reserveButton);
                    panel.remove(deleteButton);
                    panel.remove(roomNumberBox);
                    panel.remove(monthLabel);
                    panel.remove(monthSpinner);
                    panel.remove(dayLabel);
                    panel.remove(daySpinner);
                    panel.remove(yearLabel);
                    panel.remove(yearSpinner);
                    panel.remove(startTimeLabel);
                    panel.remove(startTimesBox);
                    panel.remove(endTimeLabel);
                    panel.remove(endTimesBox);
                    panel.remove(sosLabel);
                    panel.remove(sticksOrSalad);
                    panel.remove(sodaLabel5);
                    panel.remove(soda5);
                    panel.remove(toppings4);
                    panel.remove(toppings5);
                    panel.remove(toppings6);
                    panel.remove(toppings7);
                    panel.remove(toppings8);
                    panel.remove(toppings9);
                    panel.remove(toppings10);
                    panel.remove(toppings11);
                    panel.remove(toppings12);
                    panel.remove(toppings10);
                    panel.remove(toppings11);
                    panel.remove(toppings12);
                    panel.remove(toppings13);
                    panel.remove(toppings14);
                    panel.remove(toppings15);
                    panel.remove(toppings16);
                    panel.remove(sodaLabel4);
                    panel.remove(soda4);
                    panel.remove(Pizza4);
                    panel.remove(sasLabel);
                    panel.remove(boneLabel);
                    panel.remove(bone);
                    panel.remove(wingsLabel);
                    panel.remove(wings);
                    panel.remove(iceCreamLabel);
                    panel.remove(iceCream1);
                    panel.remove(iceCream2);
                    panel.remove(sodaLabel1);
                    panel.remove(soda1);
                    panel.remove(sodaLabel2);
                    panel.remove(soda2);
                    panel.remove(sodaLabel3);
                    panel.remove(soda3);
                    panel.remove(Pizza1);
                    panel.remove(toppings1);
                    panel.remove(Pizza2);
                    panel.remove(toppings2);
                    panel.remove(Pizza3);
                    panel.remove(toppings3);
                    panel.remove(partyBagLabel);
                    panel.remove(partyBagsBox);
                    panel.remove(projectorLabel);
                    panel.remove(projectorBox);
                    panel.remove(decorationsLabel);
                    panel.remove(partyDecorationsBox);
                    panel.remove(mealPlanBox);
                    panel.remove(towelLabel);
                    panel.remove(towelBox);
                    panel.repaint();

                    for (int i = 1; i <= 10; i++) {
                        roomNumberBox.addItem(i);
                    }

                    startTimesBox = new JComboBox<String>();
                    startTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 9).toArray()));
                    if (initialStartTimeIndex != 0) {
                        startTimesBox.setSelectedIndex(initialStartTimeIndex - 4);
                    }

                    //End time spinner
                    endTimesBox = new JComboBox<String>();
                    endTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 8).toArray()));
                    if (initialEndTimeIndex != 0) {
                        endTimesBox.setSelectedIndex(initialEndTimeIndex - 4);
                    }

                    panel.add(roomNumberBox);
                    panel.add(monthLabel);
                    panel.add(monthSpinner);
                    panel.add(dayLabel);
                    panel.add(daySpinner);
                    panel.add(yearLabel);
                    panel.add(yearSpinner);
                    panel.add(startTimeLabel);
                    panel.add(startTimesBox);
                    panel.add(endTimeLabel);
                    panel.add(endTimesBox);
                    panel.add(partyBagLabel);
                    panel.add(partyBagsBox);
                    panel.add(projectorLabel);
                    panel.add(projectorBox);
                    panel.add(decorationsLabel);
                    panel.add(partyDecorationsBox);
                    panel.add(mealPlanBox);
                    panel.add(cancelButton);
                    panel.add(reserveButton);
                    panel.add(deleteButton);
                    panel.revalidate();

                }

                else if (roomType.equals("Medium Party Room")) {
                    aRoomType = "Medium Party Room";
                    roomNumberBox.removeAllItems();

                    panel.remove(timeNotValid);
                    panel.remove(ageCheck);
                    panel.remove(cancelButton);
                    panel.remove(reserveButton);
                    panel.remove(deleteButton);
                    panel.remove(roomNumberBox);
                    panel.remove(monthLabel);
                    panel.remove(monthSpinner);
                    panel.remove(dayLabel);
                    panel.remove(daySpinner);
                    panel.remove(yearLabel);
                    panel.remove(yearSpinner);
                    panel.remove(startTimeLabel);
                    panel.remove(startTimesBox);
                    panel.remove(endTimeLabel);
                    panel.remove(endTimesBox);
                    panel.remove(sosLabel);
                    panel.remove(sticksOrSalad);
                    panel.remove(sodaLabel5);
                    panel.remove(soda5);
                    panel.remove(toppings4);
                    panel.remove(toppings5);
                    panel.remove(toppings6);
                    panel.remove(toppings7);
                    panel.remove(toppings8);
                    panel.remove(toppings9);
                    panel.remove(toppings10);
                    panel.remove(toppings11);
                    panel.remove(toppings12);
                    panel.remove(toppings10);
                    panel.remove(toppings11);
                    panel.remove(toppings12);
                    panel.remove(toppings13);
                    panel.remove(toppings14);
                    panel.remove(toppings15);
                    panel.remove(toppings16);
                    panel.remove(sodaLabel4);
                    panel.remove(soda4);
                    panel.remove(Pizza4);
                    panel.remove(sasLabel);
                    panel.remove(boneLabel);
                    panel.remove(bone);
                    panel.remove(wingsLabel);
                    panel.remove(wings);
                    panel.remove(iceCreamLabel);
                    panel.remove(iceCream1);
                    panel.remove(iceCream2);
                    panel.remove(sodaLabel1);
                    panel.remove(soda1);
                    panel.remove(sodaLabel2);
                    panel.remove(soda2);
                    panel.remove(sodaLabel3);
                    panel.remove(soda3);
                    panel.remove(Pizza1);
                    panel.remove(toppings1);
                    panel.remove(Pizza2);
                    panel.remove(toppings2);
                    panel.remove(Pizza3);
                    panel.remove(toppings3);
                    panel.remove(partyBagLabel);
                    panel.remove(partyBagsBox);
                    panel.remove(projectorLabel);
                    panel.remove(projectorBox);
                    panel.remove(decorationsLabel);
                    panel.remove(partyDecorationsBox);
                    panel.remove(mealPlanBox);
                    panel.remove(towelLabel);
                    panel.remove(towelBox);
                    panel.repaint();

                    for (int i = 1; i <= 2; i++) {
                        roomNumberBox.addItem(i);
                    }

                    startTimesBox = new JComboBox<String>();
                    startTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 9).toArray()));
                    if (initialStartTimeIndex != 0) {
                        startTimesBox.setSelectedIndex(initialStartTimeIndex - 4);
                    }

                    //End time spinner
                    endTimesBox = new JComboBox<String>();
                    endTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 8).toArray()));
                    if (initialEndTimeIndex != 0) {
                        endTimesBox.setSelectedIndex(initialEndTimeIndex - 4);
                    }

                    panel.add(roomNumberBox);
                    panel.add(monthLabel);
                    panel.add(monthSpinner);
                    panel.add(dayLabel);
                    panel.add(daySpinner);
                    panel.add(yearLabel);
                    panel.add(yearSpinner);
                    panel.add(startTimeLabel);
                    panel.add(startTimesBox);
                    panel.add(endTimeLabel);
                    panel.add(endTimesBox);
                    panel.add(partyBagLabel);
                    panel.add(partyBagsBox);
                    panel.add(projectorLabel);
                    panel.add(projectorBox);
                    panel.add(decorationsLabel);
                    panel.add(partyDecorationsBox);
                    panel.add(mealPlanBox);
                    panel.add(cancelButton);
                    panel.add(reserveButton);
                    panel.add(deleteButton);

                    panel.revalidate();

                }

                else if (roomType.equals("Karaoke Lounge")) {
                    aRoomType = "Karaoke Lounge";
                    roomNumberBox.removeAllItems();

                    panel.remove(timeNotValid);
                    panel.remove(ageCheck);
                    panel.remove(cancelButton);
                    panel.remove(reserveButton);
                    panel.remove(deleteButton);
                    panel.remove(roomNumberBox);
                    panel.remove(monthLabel);
                    panel.remove(monthSpinner);
                    panel.remove(dayLabel);
                    panel.remove(daySpinner);
                    panel.remove(yearLabel);
                    panel.remove(yearSpinner);
                    panel.remove(startTimeLabel);
                    panel.remove(startTimesBox);
                    panel.remove(endTimeLabel);
                    panel.remove(endTimesBox);
                    panel.remove(sosLabel);
                    panel.remove(sticksOrSalad);
                    panel.remove(sodaLabel5);
                    panel.remove(soda5);
                    panel.remove(toppings4);
                    panel.remove(toppings5);
                    panel.remove(toppings6);
                    panel.remove(toppings7);
                    panel.remove(toppings8);
                    panel.remove(toppings9);
                    panel.remove(toppings10);
                    panel.remove(toppings11);
                    panel.remove(toppings12);
                    panel.remove(toppings10);
                    panel.remove(toppings11);
                    panel.remove(toppings12);
                    panel.remove(toppings13);
                    panel.remove(toppings14);
                    panel.remove(toppings15);
                    panel.remove(toppings16);
                    panel.remove(sodaLabel4);
                    panel.remove(soda4);
                    panel.remove(Pizza4);
                    panel.remove(sasLabel);
                    panel.remove(boneLabel);
                    panel.remove(bone);
                    panel.remove(wingsLabel);
                    panel.remove(wings);
                    panel.remove(iceCreamLabel);
                    panel.remove(iceCream1);
                    panel.remove(iceCream2);
                    panel.remove(sodaLabel1);
                    panel.remove(soda1);
                    panel.remove(sodaLabel2);
                    panel.remove(soda2);
                    panel.remove(sodaLabel3);
                    panel.remove(soda3);
                    panel.remove(Pizza1);
                    panel.remove(toppings1);
                    panel.remove(Pizza2);
                    panel.remove(toppings2);
                    panel.remove(Pizza3);
                    panel.remove(toppings3);
                    panel.remove(partyBagLabel);
                    panel.remove(partyBagsBox);
                    panel.remove(projectorLabel);
                    panel.remove(projectorBox);
                    panel.remove(decorationsLabel);
                    panel.remove(partyDecorationsBox);
                    panel.remove(mealPlanBox);
                    panel.remove(towelLabel);
                    panel.remove(towelBox);
                    panel.repaint();

                    for (int i = 1; i <= 10; i++) {
                        roomNumberBox.addItem(i);
                    }

                    startTimesBox = new JComboBox<String>();
                    startTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 5).toArray()));
                    if (initialStartTimeIndex != 0) {
                        startTimesBox.setSelectedIndex(initialStartTimeIndex - 4);
                    }

                    endTimesBox = new JComboBox<String>();
                    endTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 4).toArray()));
                    if (initialEndTimeIndex != 0) {
                        endTimesBox.setSelectedIndex(initialEndTimeIndex - 4);
                    }

                    panel.add(roomNumberBox);
                    panel.add(monthLabel);
                    panel.add(monthSpinner);
                    panel.add(dayLabel);
                    panel.add(daySpinner);
                    panel.add(yearLabel);
                    panel.add(yearSpinner);
                    panel.add(startTimeLabel);
                    panel.add(startTimesBox);
                    panel.add(endTimeLabel);
                    panel.add(endTimesBox);
                    panel.add(partyBagLabel);
                    panel.add(partyBagsBox);
                    panel.add(projectorLabel);
                    panel.add(projectorBox);
                    panel.add(decorationsLabel);
                    panel.add(partyDecorationsBox);
                    panel.add(mealPlanBox);
                    panel.add(cancelButton);
                    panel.add(reserveButton);
                    panel.add(deleteButton);
                    panel.revalidate();

                }

                else if (roomType.equals("Adult Billiards Lounge")) {
                    aRoomType = "Adult Billiards Lounge";

                    roomNumberBox.removeAllItems();
                    roomNumberBox.repaint();

                    panel.remove(timeNotValid);
                    panel.remove(ageCheck);
                    panel.remove(cancelButton);
                    panel.remove(reserveButton);
                    panel.remove(deleteButton);
                    panel.remove(roomNumberBox);
                    panel.remove(monthLabel);
                    panel.remove(monthSpinner);
                    panel.remove(dayLabel);
                    panel.remove(daySpinner);
                    panel.remove(yearLabel);
                    panel.remove(yearSpinner);
                    panel.remove(startTimeLabel);
                    panel.remove(startTimesBox);
                    panel.remove(endTimeLabel);
                    panel.remove(endTimesBox);
                    panel.remove(sosLabel);
                    panel.remove(sticksOrSalad);
                    panel.remove(sodaLabel5);
                    panel.remove(soda5);
                    panel.remove(toppings4);
                    panel.remove(toppings5);
                    panel.remove(toppings6);
                    panel.remove(toppings7);
                    panel.remove(toppings8);
                    panel.remove(toppings9);
                    panel.remove(toppings10);
                    panel.remove(toppings11);
                    panel.remove(toppings12);
                    panel.remove(toppings10);
                    panel.remove(toppings11);
                    panel.remove(toppings12);
                    panel.remove(toppings13);
                    panel.remove(toppings14);
                    panel.remove(toppings15);
                    panel.remove(toppings16);
                    panel.remove(sodaLabel4);
                    panel.remove(soda4);
                    panel.remove(Pizza4);
                    panel.remove(sasLabel);
                    panel.remove(boneLabel);
                    panel.remove(bone);
                    panel.remove(wingsLabel);
                    panel.remove(wings);
                    panel.remove(iceCreamLabel);
                    panel.remove(iceCream1);
                    panel.remove(iceCream2);
                    panel.remove(sodaLabel1);
                    panel.remove(soda1);
                    panel.remove(sodaLabel2);
                    panel.remove(soda2);
                    panel.remove(sodaLabel3);
                    panel.remove(soda3);
                    panel.remove(Pizza1);
                    panel.remove(toppings1);
                    panel.remove(Pizza2);
                    panel.remove(toppings2);
                    panel.remove(Pizza3);
                    panel.remove(toppings3);
                    panel.remove(partyBagLabel);
                    panel.remove(partyBagsBox);
                    panel.remove(projectorLabel);
                    panel.remove(projectorBox);
                    panel.remove(decorationsLabel);
                    panel.remove(partyDecorationsBox);
                    panel.remove(mealPlanBox);
                    panel.remove(towelLabel);
                    panel.remove(towelBox);
                    panel.repaint();

                    for (int i = 1; i <= 5; i++) {
                        roomNumberBox.addItem(i);
                    }

                    startTimesBox = new JComboBox<String>();
                    startTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 5).toArray()));
                    if (initialStartTimeIndex != 0) {
                        startTimesBox.setSelectedIndex(initialStartTimeIndex - 4);
                    }

                    endTimesBox = new JComboBox<String>();
                    endTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 4).toArray()));
                    if (initialEndTimeIndex != 0) {
                        endTimesBox.setSelectedIndex(initialEndTimeIndex - 4);
                    }

                    panel.add(roomNumberBox);
                    panel.add(monthLabel);
                    panel.add(monthSpinner);
                    panel.add(dayLabel);
                    panel.add(daySpinner);
                    panel.add(yearLabel);
                    panel.add(yearSpinner);
                    panel.add(startTimeLabel);
                    panel.add(startTimesBox);
                    panel.add(endTimeLabel);
                    panel.add(endTimesBox);
                    panel.add(partyBagLabel);
                    panel.add(partyBagsBox);
                    panel.add(projectorLabel);
                    panel.add(projectorBox);
                    panel.add(decorationsLabel);
                    panel.add(partyDecorationsBox);
                    panel.add(mealPlanBox);
                    panel.add(cancelButton);
                    panel.add(reserveButton);
                    panel.add(deleteButton);
                    panel.revalidate();
                }

                else {
                    aRoomType = "Aqua World";

                    roomNumberBox.removeAllItems();
                    roomNumberBox.repaint();

                    panel.remove(timeNotValid);
                    panel.remove(ageCheck);
                    panel.remove(cancelButton);
                    panel.remove(reserveButton);
                    panel.remove(deleteButton);
                    panel.remove(roomNumberBox);
                    panel.remove(monthLabel);
                    panel.remove(monthSpinner);
                    panel.remove(dayLabel);
                    panel.remove(daySpinner);
                    panel.remove(yearLabel);
                    panel.remove(yearSpinner);
                    panel.remove(startTimeLabel);
                    panel.remove(startTimesBox);
                    panel.remove(endTimeLabel);
                    panel.remove(endTimesBox);
                    panel.remove(sosLabel);
                    panel.remove(sticksOrSalad);
                    panel.remove(sodaLabel5);
                    panel.remove(soda5);
                    panel.remove(toppings4);
                    panel.remove(toppings5);
                    panel.remove(toppings6);
                    panel.remove(toppings7);
                    panel.remove(toppings8);
                    panel.remove(toppings9);
                    panel.remove(toppings10);
                    panel.remove(toppings11);
                    panel.remove(toppings12);
                    panel.remove(toppings10);
                    panel.remove(toppings11);
                    panel.remove(toppings12);
                    panel.remove(toppings13);
                    panel.remove(toppings14);
                    panel.remove(toppings15);
                    panel.remove(toppings16);
                    panel.remove(sodaLabel4);
                    panel.remove(soda4);
                    panel.remove(Pizza4);
                    panel.remove(sasLabel);
                    panel.remove(boneLabel);
                    panel.remove(bone);
                    panel.remove(wingsLabel);
                    panel.remove(wings);
                    panel.remove(iceCreamLabel);
                    panel.remove(iceCream1);
                    panel.remove(iceCream2);
                    panel.remove(sodaLabel1);
                    panel.remove(soda1);
                    panel.remove(sodaLabel2);
                    panel.remove(soda2);
                    panel.remove(sodaLabel3);
                    panel.remove(soda3);
                    panel.remove(Pizza1);
                    panel.remove(toppings1);
                    panel.remove(Pizza2);
                    panel.remove(toppings2);
                    panel.remove(Pizza3);
                    panel.remove(toppings3);
                    panel.remove(partyBagLabel);
                    panel.remove(partyBagsBox);
                    panel.remove(projectorLabel);
                    panel.remove(projectorBox);
                    panel.remove(decorationsLabel);
                    panel.remove(partyDecorationsBox);
                    panel.remove(mealPlanBox);
                    panel.remove(towelLabel);
                    panel.remove(towelBox);
                    panel.repaint();


                    roomNumberBox.addItem(1);


                    startTimesBox = new JComboBox<String>();
                    startTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 9).toArray()));
                    if (initialStartTimeIndex != 0) {
                        startTimesBox.setSelectedIndex(initialStartTimeIndex - 4);
                    }

                    //End time spinner
                    endTimesBox = new JComboBox<String>();
                    endTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 8).toArray()));
                    if (initialEndTimeIndex != 0) {
                        endTimesBox.setSelectedIndex(initialEndTimeIndex - 4);
                    }

                    panel.add(roomNumberBox);
                    panel.add(monthLabel);
                    panel.add(monthSpinner);
                    panel.add(dayLabel);
                    panel.add(daySpinner);
                    panel.add(yearLabel);
                    panel.add(yearSpinner);
                    panel.add(startTimeLabel);
                    panel.add(startTimesBox);
                    panel.add(endTimeLabel);
                    panel.add(endTimesBox);
                    panel.add(partyBagLabel);
                    panel.add(partyBagsBox);
                    panel.add(projectorLabel);
                    panel.add(projectorBox);
                    panel.add(towelLabel);
                    panel.add(towelBox);
                    panel.add(decorationsLabel);
                    panel.add(partyDecorationsBox);
                    panel.add(mealPlanBox);
                    panel.add(cancelButton);
                    panel.add(reserveButton);
                    panel.add(deleteButton);
                    panel.revalidate();
                }
            }
        }
    }

    class MealPlanListener implements ActionListener {


        @Override

        public void actionPerformed(ActionEvent e) {
            String mealChoice = (String) mealPlanBox.getSelectedItem();

            if (mealChoice.equals("Basic Meal Plan")) {

                panel.remove(cancelButton);
                panel.remove(reserveButton);
                panel.remove(deleteButton);
                panel.remove(sosLabel);
                panel.remove(sticksOrSalad);
                panel.remove(sodaLabel5);
                panel.remove(soda5);
                panel.remove(toppings4);
                panel.remove(toppings5);
                panel.remove(toppings6);
                panel.remove(toppings7);
                panel.remove(toppings8);
                panel.remove(toppings9);
                panel.remove(toppings10);
                panel.remove(toppings11);
                panel.remove(toppings12);
                panel.remove(toppings10);
                panel.remove(toppings11);
                panel.remove(toppings12);
                panel.remove(toppings13);
                panel.remove(toppings14);
                panel.remove(toppings15);
                panel.remove(toppings16);
                panel.remove(sodaLabel4);
                panel.remove(soda4);
                panel.remove(Pizza4);
                panel.remove(sasLabel);
                panel.remove(boneLabel);
                panel.remove(bone);
                panel.remove(wingsLabel);
                panel.remove(wings);
                panel.remove(iceCreamLabel);
                panel.remove(iceCream1);
                panel.remove(iceCream2);
                panel.repaint();
                panel.add(mealPlanBox);
                panel.add(sodaLabel1);
                panel.add(soda1);
                panel.add(sodaLabel2);
                panel.add(soda2);
                panel.add(sodaLabel3);
                panel.add(soda3);
                panel.add(Pizza1);
                panel.add(toppings1);
                panel.add(Pizza2);
                panel.add(toppings2);
                panel.add(Pizza3);
                panel.add(toppings3);
                panel.add(reserveButton);
                panel.add(deleteButton);
                panel.add(cancelButton);
                panel.revalidate();
            }else if (mealChoice.equals("Bronze Meal Plan")) {
                panel.remove(cancelButton);
                panel.remove(reserveButton);
                panel.remove(deleteButton);
                panel.remove(sodaLabel4);
                panel.remove(soda4);
                panel.remove(sodaLabel5);
                panel.remove(soda5);
                panel.remove(toppings7);
                panel.remove(toppings8);
                panel.remove(toppings9);
                panel.remove(toppings10);
                panel.remove(toppings11);
                panel.remove(toppings12);
                panel.remove(toppings13);
                panel.remove(toppings14);
                panel.remove(toppings15);
                panel.remove(toppings16);
                panel.remove(Pizza4);
                panel.remove(sasLabel);
                panel.remove(boneLabel);
                panel.remove(bone);
                panel.remove(wingsLabel);
                panel.remove(wings);
                panel.remove(iceCreamLabel);
                panel.remove(iceCream1);
                panel.remove(iceCream2);
                panel.repaint();
                panel.add(mealPlanBox);
                panel.add(sosLabel);
                panel.add(sticksOrSalad);
                panel.add(sodaLabel1);
                panel.add(soda1);
                panel.add(sodaLabel2);
                panel.add(soda2);
                panel.add(sodaLabel3);
                panel.add(soda3);
                panel.add(Pizza1);
                panel.add(toppings1);
                panel.add(toppings2);
                panel.add(Pizza2);
                panel.add(toppings3);
                panel.add(toppings4);
                panel.add(Pizza3);
                panel.add(toppings5);
                panel.add(toppings6);
                panel.add(reserveButton);
                panel.add(deleteButton);
                panel.add(cancelButton);
                panel.revalidate();
            }else if (mealChoice.equals("Silver Meal Plan")) {
                panel.remove(cancelButton);
                panel.remove(reserveButton);
                panel.remove(deleteButton);
                panel.remove(sosLabel);
                panel.remove(sticksOrSalad);
                panel.remove(toppings10);
                panel.remove(toppings11);
                panel.remove(toppings12);
                panel.remove(toppings13);
                panel.remove(toppings14);
                panel.remove(toppings15);
                panel.remove(toppings16);
                panel.remove(Pizza4);
                panel.remove(boneLabel);
                panel.remove(bone);
                panel.remove(wingsLabel);
                panel.remove(wings);
                panel.remove(iceCreamLabel);
                panel.remove(iceCream1);
                panel.remove(iceCream2);
                panel.repaint();
                panel.add(mealPlanBox);
                panel.add(sasLabel);
                panel.add(sodaLabel1);
                panel.add(soda1);
                panel.add(sodaLabel2);
                panel.add(soda2);
                panel.add(sodaLabel3);
                panel.add(soda3);
                panel.add(sodaLabel4);
                panel.add(soda4);
                panel.add(sodaLabel5);
                panel.add(soda5);
                panel.add(Pizza1);
                panel.add(toppings1);
                panel.add(toppings2);
                panel.add(toppings3);
                panel.add(Pizza2);
                panel.add(toppings4);
                panel.add(toppings5);
                panel.add(toppings6);
                panel.add(Pizza3);
                panel.add(toppings7);
                panel.add(toppings8);
                panel.add(toppings9);
                panel.add(reserveButton);
                panel.add(deleteButton);
                panel.add(cancelButton);
                panel.revalidate();
            }else if (mealChoice.equals("Gold Meal Plan")) {
                panel.remove(cancelButton);
                panel.remove(reserveButton);
                panel.remove(deleteButton);
                panel.remove(sosLabel);
                panel.remove(sticksOrSalad);
                panel.remove(sodaLabel5);
                panel.remove(soda5);
                panel.remove(toppings10);
                panel.remove(toppings11);
                panel.remove(toppings12);
                panel.remove(toppings13);
                panel.remove(toppings14);
                panel.remove(toppings15);
                panel.remove(toppings16);
                panel.remove(Pizza4);
                panel.remove(iceCreamLabel);
                panel.remove(iceCream1);
                panel.remove(iceCream2);
                panel.repaint();
                panel.add(mealPlanBox);
                panel.add(sasLabel);
                panel.add(wingsLabel);
                panel.add(wings);
                panel.add(boneLabel);
                panel.add(bone);
                panel.add(sodaLabel1);
                panel.add(soda1);
                panel.add(sodaLabel2);
                panel.add(soda2);
                panel.add(sodaLabel3);
                panel.add(soda3);
                panel.add(sodaLabel4);
                panel.add(soda4);
                panel.add(sodaLabel5);
                panel.add(soda5);
                panel.add(Pizza1);
                panel.add(toppings1);
                panel.add(toppings2);
                panel.add(toppings3);
                panel.add(Pizza2);
                panel.add(toppings4);
                panel.add(toppings5);
                panel.add(toppings6);
                panel.add(Pizza3);
                panel.add(toppings7);
                panel.add(toppings8);
                panel.add(toppings9);
                panel.add(reserveButton);
                panel.add(deleteButton);
                panel.add(cancelButton);
                panel.revalidate();
            }else if (mealChoice.equals("Platinum Meal Plan")) {
                panel.remove(cancelButton);
                panel.remove(reserveButton);
                panel.remove(deleteButton);
                panel.remove(sosLabel);
                panel.remove(sticksOrSalad);
                panel.remove(sodaLabel5);
                panel.remove(soda5);
                panel.repaint();
                panel.add(mealPlanBox);
                panel.add(sasLabel);
                panel.add(wingsLabel);
                panel.add(wings);
                panel.add(boneLabel);
                panel.add(bone);
                panel.add(iceCreamLabel);
                panel.add(iceCream1);
                panel.add(iceCream2);
                panel.add(sodaLabel1);
                panel.add(sodaLabel1);
                panel.add(soda1);
                panel.add(sodaLabel2);
                panel.add(soda2);
                panel.add(sodaLabel3);
                panel.add(soda3);
                panel.add(sodaLabel4);
                panel.add(soda4);
                panel.add(sodaLabel5);
                panel.add(soda5);
                panel.add(Pizza1);
                panel.add(toppings1);
                panel.add(toppings2);
                panel.add(toppings3);
                panel.add(toppings4);
                panel.add(Pizza2);
                panel.add(toppings5);
                panel.add(toppings6);
                panel.add(toppings7);
                panel.add(toppings8);
                panel.add(Pizza3);
                panel.add(toppings9);
                panel.add(toppings10);
                panel.add(toppings11);
                panel.add(toppings12);
                panel.add(Pizza4);
                panel.add(toppings13);
                panel.add(toppings14);
                panel.add(toppings15);
                panel.add(toppings16);
                panel.add(reserveButton);
                panel.add(deleteButton);
                panel.add(cancelButton);
                panel.revalidate();
            }
        }

    }
























































































    /**
     * This class is used to check if the buttons were clicked
     */
    class buttonListener implements ActionListener {
        /**
         * checks which button is pressed, if the checked in button is pressed 
         * it will go the newreservationframe, the cancel button will exit the editFrame
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            panel.remove(notFoundLabel);
            panel.repaint();

            if (e.getSource() == checkButton) {

                PartyRoom partyRoom = new PartyRoom();

                for (int i = 0; i < partyRoom.getAllPartyGoers().size(); i++) {
                    if (partyRoom.getAllPartyGoers().get(i).getConfirmationNum().equals(confirmNumberField.getText())) {
                        System.out.println(partyRoom.getAllPartyGoers().get(i).getName());
                        //reservationFrame.edit();
                        panel.removeAll();
                        panel.repaint();

                        frame.setTitle("Edit Reservation");

                        currentPartyGoer = partyRoom.getAllPartyGoers().get(i);

                        guestInfo(currentPartyGoer);
                        upgrades();
                        mealPlans();
                        //generateRooms();
                        currentDate();

                        panel.revalidate();

                    }
                    else {
                        panel.add(notFoundLabel);
                        panel.revalidate();
                    }
                }
            }

            else {
                
                MainFrame mainFrame = new MainFrame(); 
                frame.setVisible(false);
            }
            
        }
        
    }
}