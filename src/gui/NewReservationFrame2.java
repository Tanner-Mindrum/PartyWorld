package gui;

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

public class NewReservationFrame2 {
    // Frame info

    // Guest Info
    private JPanel panel;
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
    private JButton cancelButton; 
    private JFrame frame;

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

    //Meal plan stuff
    private JComboBox<String> mealPlanBox; 
    private String[] MEALPLANS = {"Basic", "Bronze", "Silver", "Gold", "Platinum"};
    private String[] PIZZATOPPINGS = {"Cheese", "Pepperoni", "Ham", "Jalapeno", "Sausage", "Mushroom", "Pineapple", "Bell pepper", "Onion", "Garlic Chicken"};
    private String[] SODA_BOTTLE_FLAVORS = {""};
    private JComboBox<String> toppings = new JComboBox<String>(PIZZATOPPINGS);
    private static int ender = 0;

    public NewReservationFrame2() {
        frame = new JFrame();
        panel = new JPanel();

        frame.setTitle("New Reservation");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        this.monthStrings = getMonthStrings();
        guestInfo();
        mealPlans();
        panel.add(toppings);
        panel.add(reserveButton);
        panel.add(cancelButton);
        frame.add(panel);
    }

    public void guestInfo() {

        monthLabel = new JLabel("Month: ");
        dayLabel = new JLabel("Day: ");
        yearLabel = new JLabel("Year: ");
        startTimeLabel = new JLabel("Start Time: ");
        endTimeLabel = new JLabel("End Time: ");


        nameField = new JTextField(5);
        nameLabel = new JLabel("Name");
        phoneNumField = new JTextField(5);
        phoneNumLabel = new JLabel("Phone number");
        addressField = new JTextField(5);
        addressLabel = new JLabel("Address");
        emailField = new JTextField(10);
        emailLabel = new JLabel("Email address");
        dateOfBirth = new JLabel("Date of birth");
        cardName = new JTextField(5);
        cardNameLabel = new JLabel("Name");

        initialMonthIndex = dateTimeFrame.getMonthIndex();
        initialDayIndex = dateTimeFrame.getDayIndex();
        initialYearIndex = dateTimeFrame.getYearIndex();
        initialStartTimeIndex = dateTimeFrame.getStartTimeIndex();
        initialEndTimeIndex = dateTimeFrame.getEndTimeIndex();

        ArrayList<String> monthsToAdd = new ArrayList<>();
        for (int i = 0; i < monthStrings.length; i++) {
            monthsToAdd.add(monthStrings[i]);
        }

        System.out.println(monthsToAdd);
        System.out.println(monthsToAdd.subList(initialMonthIndex, monthsToAdd.size()));

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
            System.out.println(initialYearIndex);
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
            System.out.println(initialStartTimeIndex);
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
                    panel.remove(cancelButton);
                    panel.remove(reserveButton);
                    panel.repaint();


                    SpinnerListModel dayModel = new SpinnerListModel(dayInts.subList(0, 28));
                    daySpinner = new JSpinner(dayModel);
                    Dimension dimension = daySpinner.getPreferredSize();
                    dimension.width = 50;
                    daySpinner.setPreferredSize(dimension);

                    panel.add(daySpinner);
                    panel.add(yearLabel);
                    panel.add(yearSpinner);
                    panel.add(startTimeLabel);
                    panel.add(startTimesBox);
                    panel.add(endTimeLabel);
                    panel.add(endTimesBox);
                    panel.add(cancelButton);
                    panel.add(reserveButton);
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
                    panel.repaint();


                    SpinnerListModel dayModel = new SpinnerListModel(dayInts.subList(0, 30));
                    daySpinner = new JSpinner(dayModel);
                    Dimension dimension = daySpinner.getPreferredSize();
                    dimension.width = 50;
                    daySpinner.setPreferredSize(dimension);

                    panel.add(daySpinner);
                    panel.add(yearLabel);
                    panel.add(yearSpinner);
                    panel.add(startTimeLabel);
                    panel.add(startTimesBox);
                    panel.add(endTimeLabel);
                    panel.add(endTimesBox);
                    panel.add(cancelButton);
                    panel.add(reserveButton);
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
                    panel.remove(cancelButton);
                    panel.remove(reserveButton);
                    panel.repaint();

                    SpinnerListModel dayModel = new SpinnerListModel(dayInts);
                    daySpinner = new JSpinner(dayModel);
                    Dimension dimension = daySpinner.getPreferredSize();
                    dimension.width = 50;
                    daySpinner.setPreferredSize(dimension);

                    panel.add(daySpinner);
                    panel.add(yearLabel);
                    panel.add(yearSpinner);
                    panel.add(startTimeLabel);
                    panel.add(startTimesBox);
                    panel.add(endTimeLabel);
                    panel.add(endTimesBox);
                    panel.add(cancelButton);
                    panel.add(reserveButton);
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
        
        creditCardInfoLabel = new JLabel("Card information");
        cardNumberLabel = new JLabel("Credit card information");
        securityCodeLabel = new JLabel("Security code (3 digits)");
        expirationDateLabel = new JLabel("Expiration date");

        cardNumberField = new JTextField(15);
        securityCodeField = new JTextField(5);
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
        panel.add(creditCardInfoLabel);
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
        if (initialRoomDisplay.equals("Aqua World")) {
            panel.remove(roomNumberBox);
            panel.repaint();
        }
        panel.add(monthLabel);
        panel.add(monthSpinner);
        panel.add(dayLabel);
        panel.add(daySpinner);
        panel.add(yearLabel);
        panel.add(yearSpinner);
        panel.add(startTimeLabel);
//        panel.add(timeSpinner);
        panel.add(startTimesBox);
        panel.add(endTimeLabel);
        panel.add(endTimesBox);
    
      

    }

    public void mealPlans() {
        mealPlanBox = new JComboBox<String>(MEALPLANS);
        panel.add(mealPlanBox);
        mealPlanBox.addActionListener(new MealPlanListener());
        
        
    }
    /**
     * DateFormatSymbols returns an extra, empty value at the
     * end of the array of months.  Remove it.
     */
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
        @Override
        public void actionPerformed(ActionEvent e) {
            String roomType = (String) roomTypeBox.getSelectedItem();

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

            Calendar calendar = Calendar.getInstance(); 
        
            calendar.get(Calendar.YEAR);
            calendar.get(Calendar.MONTH);
            calendar.get(Calendar.DAY_OF_MONTH);
            
            
            PartyGoer guest = new PartyGoer();     
            
            if (e.getSource() == reserveButton) {
                guest.setName(tempName);
                guest.setPhoneNum(tempPhoneNum);
                guest.setAddress(tempAddress);
                guest.setDOB(tempMonth, tempDay, tempYear);
                guest.setCreditCardInfo(tempCreditCardInfo);
                guest.setRoomType(roomType);
                guest.setEmail(tempEmail);
                guest.setCardName(tempCardName);
                guest.setExpirationDate(tempExpirationMonth, tempExpirationYear);
                
                LocalDate today = LocalDate.now();
                LocalDate birthDay = LocalDate.of(1998, 5, 15);
                int years = Period.between(birthDay, today).getYears();
                panel.remove(ageCheck);
                panel.repaint();
     
                if (years <= 21 && roomType.equals("Adult Billiards Lounge")) {
                   
                    panel.add(ageCheck);
                    panel.revalidate();
                   
                }
                smallPartyRoom smallPartyRoom = new smallPartyRoom();
                mediumPartyRoom medPartyRoom = new mediumPartyRoom();
                AquaWorldRoom aquaWorldRoom = AquaWorldRoom.getInstance();
                karaokeLounge karaokeLounge = new karaokeLounge();
                AdultBilliardsLounge adultBilliardsLounge = new AdultBilliardsLounge();
                final PartyRoom[] ROOM_TYPE_OBJECTS = {smallPartyRoom, medPartyRoom, aquaWorldRoom, karaokeLounge, adultBilliardsLounge};
                String[] ROOM_TYPES = {"Small Party Room", "Medium Party Room", "Aqua World", "Karaoke Lounge", "Adult Billiards Lounge"};
                foundRoom = 0;
                for (int i = 0; i < ROOM_TYPES.length; i++) {
                    if (ROOM_TYPES[i].equals(aRoomType)) {
                        System.out.println(ROOM_TYPES[i]);
                        foundRoom = i;
                    }
                }
                System.out.println(foundRoom);

                String numString = "";
                String numStringEnd = "";

                for (int i = 0; i < timeSpinner.getValue().toString().length(); i++) {
                    char c = timeSpinner.getValue().toString().charAt(i);
                    if (Character.isDigit(c)) {
                        numString += c;
                    }
                }
                String[] startTimes = timeSpinner.getValue().toString().split("\\s+");
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

                for (int i = 0; i < endTimeSpinner.getValue().toString().length(); i++) {
                    char c = endTimeSpinner.getValue().toString().charAt(i);
                    if (Character.isDigit(c)) {
                        numStringEnd += c;
                    }
                }
                String[] startTimes2 = endTimeSpinner.getValue().toString().split("\\s+");
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
                for (int i = 0; i < monthStrings.length; i++) {
                    if (monthStrings[i].equals(monthSpinner.getValue().toString())) {
                        monthInt = i + 1;
                    }
                }
                ROOM_TYPE_OBJECTS[foundRoom].reserveRoom(monthInt, Integer.parseInt(daySpinner.getValue().toString()), Integer.parseInt(yearSpinner.getValue().toString()), milStartTimeInt, milEndTimeInt);
            }
            
            else if (e.getSource() == cancelButton) {
                System.out.println("The cancel button was pressed");
            }

            else if (e.getSource() == roomTypeBox) {
                if (roomType.equals("Small Party Room")) {
                    aRoomType = "Small Party Room";
                    roomNumberBox.removeAllItems();

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
                    panel.repaint();
                    
                    for (int i = 1; i <= 10; i++) {
                        roomNumberBox.addItem(i);
                    }

                    startTimesBox = new JComboBox<String>();
                    startTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 9).toArray()));
                    startTimesBox.setSelectedIndex(initialStartTimeIndex - 4);

                    //End time spinner
                    endTimesBox = new JComboBox<String>();
                    endTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 8).toArray()));
                    endTimesBox.setSelectedIndex(initialEndTimeIndex - 4);

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
                    panel.add(cancelButton);
                    panel.add(reserveButton);
                    panel.revalidate();
                                      
                }

                else if (roomType.equals("Medium Party Room")) {
                    aRoomType = "Medium Party Room";
                    roomNumberBox.removeAllItems();

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
                    panel.repaint();

                    for (int i = 1; i <= 2; i++) {
                        roomNumberBox.addItem(i);
                    }

                    startTimesBox = new JComboBox<String>();
                    startTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 9).toArray()));
                    startTimesBox.setSelectedIndex(initialStartTimeIndex - 4);

                    //End time spinner
                    endTimesBox = new JComboBox<String>();
                    endTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 8).toArray()));
                    endTimesBox.setSelectedIndex(initialEndTimeIndex - 4);

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
                    panel.add(cancelButton);
                    panel.add(reserveButton);
                    panel.revalidate();

                }

                else if (roomType.equals("Karaoke Lounge")) {
                    aRoomType = "Karaoke Lounge";
                    roomNumberBox.removeAllItems();

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
                    panel.repaint();

                    for (int i = 1; i <= 10; i++) {
                        roomNumberBox.addItem(i);
                    }

                    startTimesBox = new JComboBox<String>();
                    startTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 5).toArray()));
                    startTimesBox.setSelectedIndex(initialStartTimeIndex - 4);

                    endTimesBox = new JComboBox<String>();
                    endTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 4).toArray()));
                    endTimesBox.setSelectedIndex(initialEndTimeIndex - 4);

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
                    panel.add(cancelButton);
                    panel.add(reserveButton);
                    panel.revalidate();

                }

                else if (roomType.equals("Adult Billiards Lounge")) {
                    aRoomType = "Adult Billiards Lounge";

                    roomNumberBox.removeAllItems();

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
                    panel.repaint();

                    for (int i = 1; i <= 5; i++) {
                        roomNumberBox.addItem(i);
                    }

                    startTimesBox = new JComboBox<String>();
                    startTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 5).toArray()));
                    startTimesBox.setSelectedIndex(initialStartTimeIndex - 4);

                    endTimesBox = new JComboBox<String>();
                    endTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 4).toArray()));
                    endTimesBox.setSelectedIndex(initialEndTimeIndex - 4);

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
                    panel.add(cancelButton);
                    panel.add(reserveButton);
                    panel.revalidate();
                }

                else {
                    aRoomType = "Aqua World";
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
                    panel.repaint();

                    startTimesBox = new JComboBox<String>();
                    startTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 9).toArray()));
                    startTimesBox.setSelectedIndex(initialStartTimeIndex - 4);

                    //End time spinner
                    endTimesBox = new JComboBox<String>();
                    endTimesBox.setModel(new DefaultComboBoxModel(timeInts.subList(0, timeInts.size() - 8).toArray()));
                    endTimesBox.setSelectedIndex(initialEndTimeIndex - 4);

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
                    panel.add(cancelButton);
                    panel.add(reserveButton);
                    panel.revalidate();
                }
            }
        }
    }
    
    class MealPlanListener implements ActionListener {
        
        
        @Override
        
        public void actionPerformed(ActionEvent e) {
            String mealChoice = (String) mealPlanBox.getSelectedItem();
            
            if (mealChoice.equals("Basic")) {

                panel.remove(cancelButton);
                panel.remove(reserveButton);
                panel.repaint(); 
                panel.add(toppings);
                panel.add(reserveButton);    
                panel.add(cancelButton);
                panel.revalidate();
            }
            else if (mealChoice.equals("Bronze")) {
                
            }
        }

    }
}

