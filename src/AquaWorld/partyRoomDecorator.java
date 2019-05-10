package AquaWorld;
/**
 * 
 * @author steven, tymee, Justin, Tanner
 *
 * This class is the decorator class for the party room that gets its cost, reserves the room and gets 
 * the description
 */
public abstract class partyRoomDecorator extends PartyRoom{
	
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
	 * reserves the room of the partyGoer
	 * @return the partygoer as a PartyGoer type
	 */
	public PartyGoer reserveRoom() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * abstract method that gets the description of the room
	 * @return thre description as a string
	 */
	public abstract String getDescription();

}
