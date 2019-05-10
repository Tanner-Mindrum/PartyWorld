package gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DateTimeFrame extends JFrame {

    //Date/Time info
    private JLabel monthLabel;
    private JLabel dayLabel;
    private JLabel yearLabel;
    private JLabel startTimeLabel;
    private JLabel endTimeLabel;
    private JSpinner monthSpinner;
    private JSpinner daySpinner;
    private JSpinner yearSpinner;
    private JSpinner timeSpinner;
    private JSpinner endTimeSpinner;
    private JButton reserveButton;
    private Calendar calender;
    private Date date;
    String[] monthStrings;
    ArrayList<Integer> dayInts;
    private JTextField textField;
    private JPanel panel;
    private boolean roomLoungeCheck;
    private int starter;
    private int ender;


    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 400;

    public DateTimeFrame(boolean roomOrLounge, String roomType) {
        this.setTitle(roomType);
        this.monthStrings = getMonthStrings();
        this.dayInts = new ArrayList<>();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        roomLoungeCheck = roomOrLounge;
        createComponents();
    }

    public void createComponents() {
        panel = new JPanel();
        monthLabel = new JLabel("Month: ");
        dayLabel = new JLabel("Day: ");
        yearLabel = new JLabel("Year: ");
        startTimeLabel = new JLabel("Start Time: ");
        endTimeLabel = new JLabel("End Time: ");

        reserveButton = new JButton("Reserve now");

        //Month spinner
        SpinnerListModel monthModel = new SpinnerListModel(this.monthStrings);
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

        ArrayList<String> timeInts = new ArrayList<>();
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

        ender = 4;
        if (roomLoungeCheck) {
            ender = 8;
        }

        //Start time spinner
        SpinnerListModel timeModel = new SpinnerListModel(timeInts.subList(4, timeInts.size() - 1 - ender));
        timeSpinner = new JSpinner(timeModel);
        Dimension dimension4 = timeSpinner.getPreferredSize();
        dimension4.width = 75;
        timeSpinner.setPreferredSize(dimension4);

        //End time spinner
        SpinnerListModel timeModel2 = new SpinnerListModel(timeInts.subList(5, timeInts.size() - ender));
        endTimeSpinner = new JSpinner(timeModel2);
        Dimension dimension5 = endTimeSpinner.getPreferredSize();
        dimension5.width = 75;
        endTimeSpinner.setPreferredSize(dimension5);

        panel.add(monthLabel);
        panel.add(monthSpinner);
        panel.add(dayLabel);
        panel.add(daySpinner);
        this.add(panel);

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
                    if (timeInts.get(i) == timeValue) {
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
                panel.add(reserveButton);
                panel.revalidate();
            }
        });

        reserveButton.addActionListener(new ButtonListener());

        panel.add(yearLabel);
        panel.add(yearSpinner);
        panel.add(startTimeLabel);
        panel.add(timeSpinner);
        panel.add(endTimeLabel);
        panel.add(endTimeSpinner);
        panel.add(reserveButton);
    }

    /**
     * Return the formatted text field used by the editor, or
     * null if the editor doesn't descend from JSpinner.DefaultEditor.
     */
    public JFormattedTextField getTextField(JSpinner spinner) {
        JComponent editor = spinner.getEditor();
        if (editor instanceof JSpinner.DefaultEditor) {
            return ((JSpinner.DefaultEditor)editor).getTextField();
        } else {
            System.err.println("Unexpected editor type: "
                    + spinner.getEditor().getClass()
                    + " isn't a descendant of DefaultEditor");
            return null;
        }
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

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent click) {
            if (click.getSource() == reserveButton) {
                setVisible(false);
                NewReservationFrame aFrame = new NewReservationFrame();
            }
        }
    }
}