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
			return new smallPartyRoom();
		}
		
	}
	
	public mediumPartyRoom mediumFactory() {
		if (numMedRooms == 0 ) {
			return null; 
		}
		else { 

			numMedRooms--;
			return new mediumPartyRoom();
		}
		 
	}
	
	public karaokeLounge karaokeFactory() {
		if (numKaraokeRooms == 0 ) {
			return null; 
		}
		else {

			numKaraokeRooms--;
			return new karaokeLounge();
		}	
	}

	
	public AdultBilliardsLounge loungeFactory() {
		if (numAdultLounge == 0) {
			return null; 
		}
		else {

			numAdultLounge--;
			return new AdultBilliardsLounge(); 
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


