package AquaWorld;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;

import gui.*;

/**
 * 
 * @author steven, tanner, justin, tymee
 * 
 * is the main that runs the classes
 *
 */
public class Client {

    private static ArrayList<PartyRoom> smallPartyRooms = new ArrayList<>();
    private static ArrayList<PartyRoom> medPartyRooms = new ArrayList<>();
    private static ArrayList<PartyRoom> karaokeLounges = new ArrayList<>();
    private static ArrayList<PartyRoom> adultBilliardsLounges = new ArrayList<>();
    private static ArrayList<PartyRoom> aquaWorlds = new ArrayList<>();

    private PartyRoomFactory partyRoomFactory = new PartyRoomFactory();

    private static ArrayList<ArrayList<PartyRoom>> ROOM_TYPE_OBJECTS = new ArrayList<>();

//    public static void main(String[] args) {
//        System.out.println("Test");
//        ArrayList<String> reservationDates = new ArrayList<>();
//        ArrayList<Integer> reservationTimes = new ArrayList<>();
//        PartyGoer partyGoer = null;
//        PartyRoom partyRoom = null;
//        Pizza pizza1 = new Pizza();
//        pizza1 = new Cheese(pizza1);
//        pizza1 = new Pepperoni(pizza1);
//        pizza1 = new Ham(pizza1);
//        pizza1 = new Pineapple(pizza1);
//        System.out.println(pizza1.getDescription());
//
//
//        PartyRoom partyRoom1 = AquaWorldRoom.getInstance();
//        partyRoom1 = new Projector(partyRoom1);
//        partyRoom1 = new TowelRentals(partyRoom1);
//        System.out.println(partyRoom1.getDescription());
//        PartyRoom partyRoom2 = new mediumPartyRoom();
//        partyRoom2 = new PartyFavorBag(partyRoom2);
//        partyRoom2 = new Projector(partyRoom2);
//        System.out.println(partyRoom2.getDescription());
//
////        PartyGoer justin = new PartyGoer();
////        justin.setName("justin q-bagel ");
////        partyRoom1.setNotification("ur reservation for the aqua room has been set");
////        justin.updateInfo(justin.getName() + partyRoom1.getNotification());
////        System.out.println(justin.getInfo());
////        PartyGoer tanner =  new PartyGoer();
////        tanner.setName("tanner m-bagel ");
////        partyRoom1.setNotification("you have been added to the aqua room waitlist");
////        tanner.updateInfo(tanner.getName() + partyRoom1.getNotification());
////        System.out.println(tanner.getInfo());
//
//        AquaWorldRoom aqua = AquaWorldRoom.getInstance();
//        AquaWorldRoom newAqua = AquaWorldRoom.getInstance();
//        aqua.addRestrictions("You must wear bathing suits to the pool");
//        System.out.println(newAqua.getRestrictions());

//        MainFrame frame = new MainFrame();
//    }

    public void generateRooms() {
        for (int i = 0; i < 10; i++) {
            smallPartyRooms.add(partyRoomFactory.smallFactory());
        }
        for (int i = 0; i < 2; i++) {
            medPartyRooms.add(partyRoomFactory.mediumFactory());
        }
        for (int i = 0; i < 10; i++) {
            karaokeLounges.add(partyRoomFactory.karaokeFactory());
        }
        for (int i = 0; i < 5; i++) {
            adultBilliardsLounges.add(partyRoomFactory.loungeFactory());
        }
        aquaWorlds.add(partyRoomFactory.aquaFactory());

        ROOM_TYPE_OBJECTS.add(smallPartyRooms);
        ROOM_TYPE_OBJECTS.add(medPartyRooms);
        ROOM_TYPE_OBJECTS.add(aquaWorlds);
        ROOM_TYPE_OBJECTS.add(karaokeLounges);
        ROOM_TYPE_OBJECTS.add(adultBilliardsLounges);
    }

    public ArrayList<ArrayList<PartyRoom>> getROOM_TYPE_OBJECTS() {
        return ROOM_TYPE_OBJECTS;
    }
}

