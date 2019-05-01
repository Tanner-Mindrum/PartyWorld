package AquaWorld;

public class PartyRoomFactory {
	private static int numSmallRooms = 10;
	private static int numMedRooms = 2;
	private static int numKaraokeRooms = 10;
	private static int numAdultLounge = 5;
	private static int bookedAquaRoom = 1;
	
//	private PartyRoom partyRoom;
	private smallPartyRoom smallRoom;
	private mediumPartyRoom mediumRoom;
	private karaokeLounge karaokeRoom; 
	private AdultBilliardsLounge adultRoom; 
	private AquaWorldRoom aquaRoom; 
	
	public PartyRoomFactory() {
		smallRoom = new smallPartyRoom(); 
		mediumRoom = new mediumPartyRoom();
		karaokeRoom = new karaokeLounge();
		adultRoom = new AdultBilliardsLounge();
		aquaRoom = AquaWorldRoom.getInstance();
	}
//	public PartyRoom factoryRoom(){
//		return partyRoom;
//	}
	
	public smallPartyRoom smallFactory() { 
		if (numSmallRooms == 0) {
			return null;
		
		}
		
		else {
			
			numSmallRooms--;
			return smallRoom;
		}
		
	}
	
	public mediumPartyRoom mediumFactory() {
		if (numMedRooms == 0 ) {
			return null; 
		}
		else { 

			numMedRooms--;
			return mediumRoom;
		}
		 
	}
	
	public karaokeLounge karaokeFactory() {
		if (numKaraokeRooms == 0 ) {
			return null; 
		}
		else {

			numKaraokeRooms--;
			return karaokeRoom;
		}	
	}

	
	public AdultBilliardsLounge loungeFactory() {
		if (numAdultLounge == 0) {
			return null; 
		}
		else {

			numAdultLounge--;
			return adultRoom; 
		}
	}
	
	public AquaWorldRoom aquaFactory() {
		if (bookedAquaRoom == 0) {
			System.out.println("Added to waitlist");
			return null; 
		}
		else {

			bookedAquaRoom--;
			return aquaRoom;	
		}
		
	}
}


