package gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DateTimeFrame extends JFrame {

    //Date/Time info
    private JLabel monthLabel;
    private JLabel dayLabel;
    private JLabel yearLabel;
    private JLabel timeLabel;
    private JSpinner monthSpinner;
    private JSpinner daySpinner;
    private JSpinner yearSpinner;
    private JSpinner timeSpinner;
    private Calendar calender;
    private Date date;
    String[] monthStrings;
    ArrayList<Integer> dayInts;
    private JTextField textField;
    private JPanel panel;

    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 400;

    public DateTimeFrame() {
        this.setTitle("Select Date/Time");
        this.monthStrings = getMonthStrings();
        this.dayInts = new ArrayList<>();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        createComponents();
    }

    public void createComponents() {
        panel = new JPanel();
        monthLabel = new JLabel("Month: ");
        dayLabel = new JLabel("Day: ");
        yearLabel = new JLabel("Year: ");
        timeLabel = new JLabel("Time: ");

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
        for (int i = 800; i < 2615; i += 15) {
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
            StringBuilder str = new StringBuilder(Integer.toString(j));
            timeInts.add(str.insert(Integer.toString(j).length() - 2, ":").toString());
        }
        System.out.println(timeInts);

        //Make day spinner
        SpinnerListModel dayModel = new SpinnerListModel(dayInts);
        daySpinner = new JSpinner(dayModel);
        Dimension dimension2 = daySpinner.getPreferredSize();
        dimension2.width = 50;
        daySpinner.setPreferredSize(dimension2);

        SpinnerListModel yearModel = new SpinnerListModel(yearInts);
        yearSpinner = new JSpinner(yearModel);
        Dimension dimension3 = yearSpinner.getPreferredSize();
        dimension3.width = 82;
        yearSpinner.setPreferredSize(dimension3);

        SpinnerListModel timeModel = new SpinnerListModel(timeInts);
        timeSpinner = new JSpinner(timeModel);
        Dimension dimension4 = timeSpinner.getPreferredSize();
        dimension4.width = 60;
        timeSpinner.setPreferredSize(dimension4);

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
                    panel.repaint();


                    SpinnerListModel dayModel = new SpinnerListModel(dayInts.subList(0, 28));
                    daySpinner = new JSpinner(dayModel);
                    Dimension dimension = daySpinner.getPreferredSize();
                    dimension.width = 50;
                    daySpinner.setPreferredSize(dimension);

                    panel.add(daySpinner);
                    panel.add(yearLabel);
                    panel.add(yearSpinner);
                    panel.revalidate();
                }
                else {
                    panel.remove(daySpinner);
                    panel.remove(yearLabel);
                    panel.remove(yearSpinner);
                    panel.repaint();

                    SpinnerListModel dayModel = new SpinnerListModel(dayInts);
                    daySpinner = new JSpinner(dayModel);
                    Dimension dimension = daySpinner.getPreferredSize();
                    dimension.width = 82;
                    daySpinner.setPreferredSize(dimension);

                    panel.add(daySpinner);
                    panel.add(yearLabel);
                    panel.add(yearSpinner);
                    panel.revalidate();
                }
            }
        });

        panel.add(yearLabel);
        panel.add(yearSpinner);
        panel.add(timeLabel);
        panel.add(timeSpinner);
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
}