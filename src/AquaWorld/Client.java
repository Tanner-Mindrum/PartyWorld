package AquaWorld;

import java.util.ArrayList;
import java.util.Scanner;
import gui.*;
public class Client {

    public static void main(String[] args) {
        System.out.println("Test");
        ArrayList<String> reservationDates = new ArrayList<>();
        ArrayList<Integer> reservationTimes = new ArrayList<>();
        PartyGoer partyGoer = null;
        PartyRoom partyRoom = null;
        Pizza pizza1 = new Pizza();
        pizza1 = new Cheese(pizza1);
        pizza1 = new Pepperoni(pizza1);
        pizza1 = new Ham(pizza1);
        pizza1 = new Pineapple(pizza1);
        System.out.println(pizza1.getDescription());


        PartyRoom partyRoom1 = AquaWorldRoom.getInstance();
        partyRoom1 = new Projector(partyRoom1);
        partyRoom1 = new TowelRentals(partyRoom1);
        System.out.println(partyRoom1.getDescription());
        PartyRoom partyRoom2 = new mediumPartyRoom();
        partyRoom2 = new PartyFavorBag(partyRoom2);
        partyRoom2 = new Projector(partyRoom2);
        System.out.println(partyRoom2.getDescription());


        //AquaWorldRoom aqua = AquaWorldRoom.getInstance();
//        AquaWorldRoom newAqua = AquaWorldRoom.getInstance();
//        aqua.addRestrictions("You must wear bathing suits to the pool");
//        System.out.println(newAqua.getRestrictions());

        //Testing PartyRoomFactory class
//        PartyRoomFactory roomFactory = new PartyRoomFactory();
//        roomFactory.aquaFactory();
//        roomFactory.aquaFactory();
//        mediumPartyRoom medRoom1 = roomFactory.mediumFactory();
//        mediumPartyRoom medRoom2 = roomFactory.mediumFactory();
//        medRoom1.setDescription("First object");
//       // medRoom2.setDescription("Second object");
//        System.out.println(medRoom1.getDescription());
//        System.out.println(medRoom2.getDescription());
        MainFrame frame = new MainFrame();

        Scanner in = new Scanner(System.in);
        System.out.println("BUSINESS HOURS: 9:00 AM to 12:00 AM");

        System.out.println("1. Make a reservation!");
        System.out.println("2. Quit");
        while (true) {
            String choice = in.nextLine().trim();
            if (choice.equals("2")) {
                System.out.println("Thank you!");
                break;
            }

            //Start date
            System.out.println("Enter reservation date: ");
            String month = in.nextLine().trim();
            String day = in.nextLine().trim();
            String year = in.nextLine().trim();
            String date = month + day + year;
            if (reservationDates.size() == 0) {
                reservationDates.add(date);
                reservationDates.add("N/A");
            }

            //Start Time
            System.out.println("Start Time?:");
            String startTime = in.nextLine().trim();
            String[] startTimes = startTime.split("\\s+");
            startTime = startTimes[0];
            String AMPM = startTimes[1];
            String milStartTime = "";
            for (int i = 0; i < startTime.length(); i++) {
                char c = startTime.charAt(i);
                if (c != ':') {
                    milStartTime += c;
                }
            }
            int milStartTimeInt = Integer.parseInt(milStartTime);
            AMPM.toUpperCase();
            if (AMPM.equals("PM")) {
                if (milStartTimeInt != 1200) {
                    milStartTimeInt += 1200;
                }
            } else if (AMPM.equals("AM") && milStartTimeInt == 1200) {
                milStartTimeInt += 1200;
            }

            if (reservationDates.size() != 0) {
//                while (true) {
                if (reservationDates.contains(date)) {
                    ArrayList<String> takenDates = new ArrayList<>();
                    ArrayList<Integer> takenTimes = new ArrayList<>();
                    boolean roomTaken = false;
                    for (int i = 0; i < reservationDates.size(); i++) {
                        if (reservationDates.get(i).equals(date)) {
                            takenDates.add(reservationDates.get(i));
                            takenTimes.add(reservationTimes.get(i));
                            takenTimes.add(reservationTimes.get(i + 1));
                        }
                    }
                    for (int i = 0; i < reservationTimes.size() - 1; i++) {
                        if (milStartTimeInt < reservationTimes.get(i) && milStartTimeInt < reservationTimes.get(i + 1)) {
                            roomTaken = true;
                            break;
                        }
                    }

                    //Observer begin
                    if (roomTaken) {
                        System.out.println("You have been added to a wait list");
                        partyRoom.getNotification();
                    }
                    else {
                        System.out.println("You have been added to a wait list");
                    }
                }
//                    for (int i = 0; i < reservationTimes.size() - 1; i++) {
//                        if (milStartTimeInt < reservationTimes.get(i) && milStartTimeInt < reservationTimes.get(i + 1)) {
//                            if (reservationDates.get(i).equals(date)) {
//                                System.out.println("This room is already reserved at that time.");
//                            }
//                            else {
//                                reservationDates.add(date);
//                                reservationDates.add("N/A");
//                                reservationTimes.add(milStartTimeInt);
//                            }
//                        }
//                    }
//                }
            }
            else {
                reservationTimes.add(milStartTimeInt);
            }
            //reservationTimes.add(milStartTimeInt);

            //End time
            System.out.println("End Time?:");
            String endTime = in.nextLine().trim();
            String[] endTimes = endTime.split("\\s+");
            endTime = endTimes[0];
            AMPM = endTimes[1];
            String milEndTime = "";
            for (int i = 0; i < endTime.length(); i++) {
                char c = endTime.charAt(i);
                if (c != ':') {
                    milEndTime += c;
                }
            }
            int milEndTimeInt = Integer.parseInt(milEndTime);
            AMPM.toUpperCase();
            if (AMPM.equals("PM")) {
                if (milEndTimeInt != 1200) {
                    milEndTimeInt += 1200;
                }
            } else if (AMPM.equals("AM") && milEndTimeInt == 1200) {
                milEndTimeInt += 1200;
            }
            reservationTimes.add(milEndTimeInt);

            for (int i = 0; i < reservationTimes.size(); i++) {
                System.out.println(reservationTimes.get(i));
            }

            for (int i = 0; i < reservationDates.size(); i++) {
                System.out.println(reservationDates.get(i));
            }
        }
    }
}

