package AquaWorld;

public class PartyRoomFactory {
	private static int numSmallRooms;
	private static int numMedRooms;
	private static int numKaraokeRooms;
	private static int numAdultLounge;
	private static boolean bookedAquaRoom;
	private PartyRoom partyRoom;
	
	public PartyRoom factoryRoom(){
		return partyRoom;
	}
}
