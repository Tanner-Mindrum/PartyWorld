package AquaWorld;

/**
 * 
 * @author steven, justin, tymee, tanner
 *
 */
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
	
	/**
	 * the default constructor for the party room factory
	 */
	public PartyRoomFactory() {
		aquaRoom = AquaWorldRoom.getInstance();
	}
//	public PartyRoom factoryRoom(){
//		return partyRoom;
//	}
	
	/**
	 * a factory for the small party room
	 * @return the small party room that has been created
	 */
	public smallPartyRoom smallFactory() { 
		if (numSmallRooms == 0) {
			return null;
		
		}
		
		else {
			
			numSmallRooms--;
			return new smallPartyRoom();
		}
		
	}
	
	/**
	 * creates the medium party rooms
	 * @return a medium party room
	 */
	public mediumPartyRoom mediumFactory() {
		if (numMedRooms == 0 ) {
			return null; 
		}
		else { 

			numMedRooms--;
			return new mediumPartyRoom();
		}
		 
	}
	
	/**
	 * createes a kareoke room
	 * @return a kareoke lounge
	 */
	public karaokeLounge karaokeFactory() {
		if (numKaraokeRooms == 0 ) {
			return null; 
		}
		else {

			numKaraokeRooms--;
			return new karaokeLounge();
		}	
	}

	/**
	 * creates the adult billards lounge
	 * @return the adult billiards lounge 
	 */
	public AdultBilliardsLounge loungeFactory() {
		if (numAdultLounge == 0) {
			return null; 
		}
		else {

			numAdultLounge--;
			return new AdultBilliardsLounge(); 
		}
	}
	
	/**
	 * creates the aqua factory
	 * @return an aquaroom
	 */
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


