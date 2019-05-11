package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class NewReservationFrame {
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
    private static int foundRoom;
    private static String aRoomType;
    private static int sideCounter;

    private static ArrayList<String> timeInts = new ArrayList<>();

    private static int ender = 0;

    public NewReservationFrame() {
        frame = new JFrame();
        panel = new JPanel();

        frame.setTitle("New Reservation");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        this.monthStrings = getMonthStrings();
        guestInfo();
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

        //hey
        ArrayList<String> monthsToAdd = new ArrayList<>();
        for (int i = 0; i < monthStrings.length; i++) {
            monthsToAdd.add(monthStrings[i]);
        }

        SpinnerListModel monthModel = new SpinnerListModel(monthStrings);
        if (initialMonthIndex != -1) {
            monthModel = new SpinnerListModel(monthsToAdd.subList(initialMonthIndex, monthsToAdd.size()));
        }

        //Month spinner
        monthSpinner = new JSpinner(monthModel);
        Dimension dimension = monthSpinner.getPreferredSize();
        dimension.width = 82;
        monthSpinner.setPreferredSize(dimension);

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

        //Make day spinner
        SpinnerListModel dayModel = new SpinnerListModel(dayInts);
        daySpinner = new JSpinner(dayModel);
        Dimension dimension2 = daySpinner.getPreferredSize();
        dimension2.width = 50;
        daySpinner.setPreferredSize(dimension2);

        //Year spinner
        SpinnerListModel yearModel = new SpinnerListModel(yearInts);
        yearSpinner = new JSpinner(yearModel);
        Dimension dimension3 = yearSpinner.getPreferredSize();
        dimension3.width = 70;
        yearSpinner.setPreferredSize(dimension3);

        int j = 0;
        //17
        int amPmCount = 0;
        //String finalString = "";
        for (int i = 800; i < 2615; i += 15) {
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
            if (amPmCount <= 16 || amPmCount >= 65) {
                StringBuilder str = new StringBuilder(Integer.toString(j));
                str = str.insert(Integer.toString(j).length() - 2, ":");
                //finalString = str.toString() + " AM";
                timeInts.add(str.toString() + " AM");
            }
            else if (amPmCount >= 16 && amPmCount <= 65) {
                StringBuilder str = new StringBuilder(Integer.toString(j));
                str = str.insert(Integer.toString(j).length() - 2, ":");
                //finalString = str.toString() + " PM";
                timeInts.add(str.toString() + " PM");
            }
        }

//        ender = 4;
//        if (roomLoungeCheck) {
//            ender = 8;
//        }

//        //Start time spinner
//        SpinnerListModel timeModel = new SpinnerListModel(timeInts.subList(4, timeInts.size() - 1 - ender));
//        timeSpinner = new JSpinner(timeModel);
//        Dimension dimension4 = timeSpinner.getPreferredSize();
//        dimension4.width = 75;
//        timeSpinner.setPreferredSize(dimension4);
      

        //Manipulating array for book now button does not work currently

        initialRoomIndex = dateTimeFrame.getFoundRoomIndex();
        initialRoomDisplay = roomTypes[initialRoomIndex];
        if (initialRoomDisplay.equals("Small Party Room")) {
            ender = 8;
            roomNumberBox = new JComboBox<Integer>();
            for (int i = 1; i <= 10; i++) {
                roomNumberBox.addItem(i);
            }
            //Start time spinner
            SpinnerListModel timeModel = new SpinnerListModel(timeInts.subList(4, timeInts.size() - 1 - 8));
            timeSpinner = new JSpinner(timeModel);
            Dimension dimension4 = timeSpinner.getPreferredSize();
            dimension4.width = 75;
            timeSpinner.setPreferredSize(dimension4);

            //End time spinner
            SpinnerListModel timeModel2 = new SpinnerListModel(timeInts.subList(5, timeInts.size() - 8));
            endTimeSpinner = new JSpinner(timeModel2);
            Dimension dimension5 = endTimeSpinner.getPreferredSize();
            dimension5.width = 75;
            endTimeSpinner.setPreferredSize(dimension5);
        }
        else if (initialRoomDisplay.equals("Medium Party Room")) {
            ender = 8;

            roomNumberBox = new JComboBox<Integer>();
            for (int i = 1; i <= 2; i++) {
                roomNumberBox.addItem(i);
            }
            SpinnerListModel timeModel = new SpinnerListModel(timeInts.subList(4, timeInts.size() - 1 - 8));
            timeSpinner = new JSpinner(timeModel);
            Dimension dimension4 = timeSpinner.getPreferredSize();
            dimension4.width = 75;
            timeSpinner.setPreferredSize(dimension4);

            SpinnerListModel timeModel2 = new SpinnerListModel(timeInts.subList(5, timeInts.size() - 8));
            endTimeSpinner = new JSpinner(timeModel2);
            Dimension dimension5 = endTimeSpinner.getPreferredSize();
            dimension5.width = 75;
            endTimeSpinner.setPreferredSize(dimension5);
        }
        else if (initialRoomDisplay.equals("Aqua World")) {
            ender = 8;

            roomNumberBox = new JComboBox<Integer>();
            SpinnerListModel timeModel = new SpinnerListModel(timeInts.subList(4, timeInts.size() - 1 - 8));
            timeSpinner = new JSpinner(timeModel);
            Dimension dimension4 = timeSpinner.getPreferredSize();
            dimension4.width = 75;
            timeSpinner.setPreferredSize(dimension4);

            SpinnerListModel timeModel2 = new SpinnerListModel(timeInts.subList(5, timeInts.size() - 8));
            endTimeSpinner = new JSpinner(timeModel2);
            Dimension dimension5 = endTimeSpinner.getPreferredSize();
            dimension5.width = 75;
            endTimeSpinner.setPreferredSize(dimension5);
        }
        else if (initialRoomDisplay.equals("Karaoke Lounge")) {
            ender = 4;

            roomNumberBox = new JComboBox<Integer>();
            for (int i = 1; i <= 10; i++) {
                roomNumberBox.addItem(i);
            }
            SpinnerListModel timeModel = new SpinnerListModel(timeInts.subList(4, timeInts.size() - 1 - 4));
            timeSpinner = new JSpinner(timeModel);
            Dimension dimension4 = timeSpinner.getPreferredSize();
            dimension4.width = 75;
            timeSpinner.setPreferredSize(dimension4);

            SpinnerListModel timeModel2 = new SpinnerListModel(timeInts.subList(5, timeInts.size() - 4));
            endTimeSpinner = new JSpinner(timeModel2);
            Dimension dimension5 = endTimeSpinner.getPreferredSize();
            dimension5.width = 75;
            endTimeSpinner.setPreferredSize(dimension5);
        }
        else if (initialRoomDisplay.equals("Adult Billiards Lounge")) {
            ender = 4;

            roomNumberBox = new JComboBox<Integer>();
            for (int i = 1; i <= 5; i++) {
                roomNumberBox.addItem(i);
            }
            SpinnerListModel timeModel = new SpinnerListModel(timeInts.subList(4, timeInts.size() - 1 - 4));
            timeSpinner = new JSpinner(timeModel);
            Dimension dimension4 = timeSpinner.getPreferredSize();
            dimension4.width = 75;
            timeSpinner.setPreferredSize(dimension4);

            SpinnerListModel timeModel2 = new SpinnerListModel(timeInts.subList(5, timeInts.size() - 4));
            endTimeSpinner = new JSpinner(timeModel2);
            Dimension dimension5 = endTimeSpinner.getPreferredSize();
            dimension5.width = 75;
            endTimeSpinner.setPreferredSize(dimension5);
        }
//        for (int i = 0; i < roomTypes.length; i++) {
//            roomTypesArrayList.add(roomTypes[i]);
//        }
//        System.out.println(roomTypesArrayList);
//        roomTypesArrayList.remove(initialRoomIndex);
//        roomTypesArrayList.add(0, initialRoomDisplay);
//        System.out.println(roomTypesArrayList);
//        roomTypes = new String[5];
//        for (int i = 0; i < roomTypesArrayList.size(); i++) {
//            roomTypes[i] = roomTypesArrayList.get(i);
//        }

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
                    panel.remove(timeSpinner);
                    panel.remove(endTimeLabel);
                    panel.remove(endTimeSpinner);
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
                    panel.add(timeSpinner);
                    panel.add(endTimeLabel);
                    panel.add(endTimeSpinner);
                    panel.add(cancelButton);
                    panel.add(reserveButton);
                    panel.revalidate();
                }
                else if (value.equals("April") || value.equals("June") || value.equals("September") || value.equals("November")) {
                    panel.remove(daySpinner);
                    panel.remove(yearLabel);
                    panel.remove(yearSpinner);
                    panel.remove(startTimeLabel);
                    panel.remove(timeSpinner);
                    panel.remove(endTimeLabel);
                    panel.remove(endTimeSpinner);
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
                    panel.add(timeSpinner);
                    panel.add(endTimeLabel);
                    panel.add(endTimeSpinner);
                    panel.add(cancelButton);
                    panel.add(reserveButton);
                    panel.revalidate();

                }
                else {
                    panel.remove(daySpinner);
                    panel.remove(yearLabel);
                    panel.remove(yearSpinner);
                    panel.remove(startTimeLabel);
                    panel.remove(timeSpinner);
                    panel.remove(endTimeLabel);
                    panel.remove(endTimeSpinner);
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
                    panel.add(timeSpinner);
                    panel.add(endTimeLabel);
                    panel.add(endTimeSpinner);
                    panel.add(cancelButton);
                    panel.add(reserveButton);
                    panel.revalidate();
                }
            }
        });



        timeSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                String timeValue = timeSpinner.getValue().toString();
                int timeValueIndex = 0;
                for (int i = 0; i < timeInts.size(); i++) {
                    if (timeInts.get(i).equals(timeValue)) {
                        timeValueIndex = i;
                    }
                }

                panel.remove(daySpinner);
                panel.remove(yearLabel);
                panel.remove(yearSpinner);
                panel.remove(startTimeLabel);
                panel.remove(timeSpinner);
                panel.remove(endTimeLabel);
                panel.remove(endTimeSpinner);
                panel.remove(cancelButton);
                panel.remove(reserveButton);
                panel.repaint();

                SpinnerListModel timeModel = new SpinnerListModel(timeInts.subList(timeValueIndex+1, timeInts.size() - ender));
                endTimeSpinner = new JSpinner(timeModel);
                Dimension dimension = endTimeSpinner.getPreferredSize();
                dimension.width = 75;
                endTimeSpinner.setPreferredSize(dimension);

                panel.add(daySpinner);
                panel.add(yearLabel);
                panel.add(yearSpinner);
                panel.add(startTimeLabel);
                panel.add(timeSpinner);
                panel.add(endTimeLabel);
                panel.add(endTimeSpinner);
                panel.add(cancelButton);
                panel.add(reserveButton);
                panel.revalidate();
            }
        });

       
        //roomTypeBox = new JComboBox<String>(roomTypes);
        //roomNumberBox = new JComboBox<Integer>();
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
        panel.add(timeSpinner);
        panel.add(endTimeLabel);
        panel.add(endTimeSpinner);
        panel.add(cancelButton);
        panel.add(reserveButton);
        frame.add(panel);

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

    public static int getSelectedIndex(JSpinner spinner, String[] monthStrings) {
        int index = 0;
        for(String s : monthStrings) {
            if (s.equals(spinner.getValue())) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static void setSelectedIndex(JSpinner spinner, String[] monthStrings, int index) {
        spinner.setValue(monthStrings[(index)]);
    }

//    public int getSelectedIndex2(JSpinner spinner, ArrayList<?> values) {
//        int index = 0;
//        for(Object o : values) {
//            if (o.equals(spinner.getValue())) {
//                return index;
//            }
//            index++;
//        }
//        return -1;
//    }
//
//    public void setSelectedIndex2(JSpinner spinner, String[] monthStrings, int index) {
//        spinner.setValue(monthStrings[(index)]);
//    }

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
                    panel.remove(timeSpinner);
                    panel.remove(endTimeLabel);
                    panel.remove(endTimeSpinner);
                    panel.repaint();
                    
                    for (int i = 1; i <= 10; i++) {
                        roomNumberBox.addItem(i);
                    }

                    //Start time spinner
                    SpinnerListModel timeModel = new SpinnerListModel(timeInts.subList(4, timeInts.size() - 1 - 8));
                    timeSpinner = new JSpinner(timeModel);
                    Dimension dimension4 = timeSpinner.getPreferredSize();
                    dimension4.width = 75;
                    timeSpinner.setPreferredSize(dimension4);

                    SpinnerListModel timeModel2 = new SpinnerListModel(timeInts.subList(5, timeInts.size() - 8));
                    endTimeSpinner = new JSpinner(timeModel2);
                    Dimension dimension5 = endTimeSpinner.getPreferredSize();
                    dimension5.width = 75;
                    endTimeSpinner.setPreferredSize(dimension5);


                    panel.add(roomNumberBox);
                    panel.add(monthLabel);
                    panel.add(monthSpinner);
                    panel.add(dayLabel);
                    panel.add(daySpinner);
                    panel.add(yearLabel);
                    panel.add(yearSpinner);
                    panel.add(startTimeLabel);
                    panel.add(timeSpinner);
                    panel.add(endTimeLabel);
                    panel.add(endTimeSpinner);
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
                    panel.remove(timeSpinner);
                    panel.remove(endTimeLabel);
                    panel.remove(endTimeSpinner);
                    panel.repaint();

                    for (int i = 1; i <= 2; i++) {
                        roomNumberBox.addItem(i);
                    }

                    //Start time spinner
                    SpinnerListModel timeModel = new SpinnerListModel(timeInts.subList(4, timeInts.size() - 1 - 8));
                    timeSpinner = new JSpinner(timeModel);
                    Dimension dimension4 = timeSpinner.getPreferredSize();
                    dimension4.width = 75;
                    timeSpinner.setPreferredSize(dimension4);

                    SpinnerListModel timeModel2 = new SpinnerListModel(timeInts.subList(5, timeInts.size() - 8));
                    endTimeSpinner = new JSpinner(timeModel2);
                    Dimension dimension5 = endTimeSpinner.getPreferredSize();
                    dimension5.width = 75;
                    endTimeSpinner.setPreferredSize(dimension5);


                    panel.add(roomNumberBox);
                    panel.add(monthLabel);
                    panel.add(monthSpinner);
                    panel.add(dayLabel);
                    panel.add(daySpinner);
                    panel.add(yearLabel);
                    panel.add(yearSpinner);
                    panel.add(startTimeLabel);
                    panel.add(timeSpinner);
                    panel.add(endTimeLabel);
                    panel.add(endTimeSpinner);
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
                    panel.remove(endTimeLabel);
                    panel.remove(endTimeSpinner);
                    panel.remove(timeSpinner);
                    panel.repaint();

                    for (int i = 1; i <= 10; i++) {
                        roomNumberBox.addItem(i);
                    }

                    //Start time spinner
                    SpinnerListModel timeModel = new SpinnerListModel(timeInts.subList(4, timeInts.size() - 1 - 4));
                    timeSpinner = new JSpinner(timeModel);
                    Dimension dimension4 = timeSpinner.getPreferredSize();
                    dimension4.width = 75;
                    timeSpinner.setPreferredSize(dimension4);

                    SpinnerListModel timeModel2 = new SpinnerListModel(timeInts.subList(5, timeInts.size() - 4));
                    endTimeSpinner = new JSpinner(timeModel2);
                    Dimension dimension5 = endTimeSpinner.getPreferredSize();
                    dimension5.width = 75;
                    endTimeSpinner.setPreferredSize(dimension5);

                    panel.add(roomNumberBox);
                    panel.add(monthLabel);
                    panel.add(monthSpinner);
                    panel.add(dayLabel);
                    panel.add(daySpinner);
                    panel.add(yearLabel);
                    panel.add(yearSpinner);
                    panel.add(startTimeLabel);
                    panel.add(timeSpinner);
                    panel.add(endTimeLabel);
                    panel.add(endTimeSpinner);
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
                    panel.remove(timeSpinner);
                    panel.remove(endTimeLabel);
                    panel.remove(endTimeSpinner);
                    panel.repaint();

                    for (int i = 1; i <= 5; i++) {
                        roomNumberBox.addItem(i);
                    }

                    //Start time spinner
                    SpinnerListModel timeModel = new SpinnerListModel(timeInts.subList(4, timeInts.size() - 1 - 4));
                    timeSpinner = new JSpinner(timeModel);
                    Dimension dimension4 = timeSpinner.getPreferredSize();
                    dimension4.width = 75;
                    timeSpinner.setPreferredSize(dimension4);

                    SpinnerListModel timeModel2 = new SpinnerListModel(timeInts.subList(5, timeInts.size() - 4));
                    endTimeSpinner = new JSpinner(timeModel2);
                    Dimension dimension5 = endTimeSpinner.getPreferredSize();
                    dimension5.width = 75;
                    endTimeSpinner.setPreferredSize(dimension5);

                    panel.add(roomNumberBox);
                    panel.add(monthLabel);
                    panel.add(monthSpinner);
                    panel.add(dayLabel);
                    panel.add(daySpinner);
                    panel.add(yearLabel);
                    panel.add(yearSpinner);
                    panel.add(startTimeLabel);
                    panel.add(timeSpinner);
                    panel.add(endTimeLabel);
                    panel.add(endTimeSpinner);
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
                    panel.remove(timeSpinner);
                    panel.remove(endTimeLabel);
                    panel.remove(endTimeSpinner);
                    panel.repaint();

                    //Start time spinner
                    SpinnerListModel timeModel = new SpinnerListModel(timeInts.subList(4, timeInts.size() - 1 - 8));
                    timeSpinner = new JSpinner(timeModel);
                    Dimension dimension4 = timeSpinner.getPreferredSize();
                    dimension4.width = 75;
                    timeSpinner.setPreferredSize(dimension4);

                    SpinnerListModel timeModel2 = new SpinnerListModel(timeInts.subList(5, timeInts.size() - 8));
                    endTimeSpinner = new JSpinner(timeModel2);
                    Dimension dimension5 = endTimeSpinner.getPreferredSize();
                    dimension5.width = 75;
                    endTimeSpinner.setPreferredSize(dimension5);

                    //panel.add(roomNumberBox);

                    panel.add(monthLabel);
                    panel.add(monthSpinner);
                    panel.add(dayLabel);
                    panel.add(daySpinner);
                    panel.add(yearLabel);
                    panel.add(yearSpinner);
                    panel.add(startTimeLabel);
                    panel.add(timeSpinner);
                    panel.add(endTimeLabel);
                    panel.add(endTimeSpinner);
                    panel.add(cancelButton);
                    panel.add(reserveButton);
                    panel.revalidate();
                }
            }
        }
    }
}
