package AquaWorld;
/**
 * 
 * @author steven, tymee, Justin, Tanner
 *
 * This class is the decorator class for the party room that gets its cost, reserves the room and gets 
 * the description
 */
public abstract class partyRoomDecorator extends PartyRoom {
	
	@Override
	/**
	 * calculates the cost of the room
	 * @return the cost of the party room as a double
	 */
	public double calculateCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	/**
	 * reserves the room to a partygoer
	 * @return a PartyGoer
	 */
	public PartyGoer reserveRoom(int month, int day, int year, int startTime, int endTime) {
		return null;
	}

	/**
	 * abstract method that gets the description of the room
	 * @return thre description as a string
	 */
	public abstract String getDescription();

}
