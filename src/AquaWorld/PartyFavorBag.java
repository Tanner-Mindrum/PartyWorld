package AquaWorld;

/**
 * 
 * @author steven, tymee, justin, tanner
 *
 * party favor class to add to the party room
 */
public class PartyFavorBag extends partyRoomDecorator{
	PartyRoom partyRoom;
	
	/**
	 * adds a party favor bag to the party room
	 * @param partyRoom to add the party favor bag
	 */
	public PartyFavorBag(PartyRoom partyRoom) {
		this.partyRoom = partyRoom;
	}
	@Override
	/**
	 * gets the description of the party room
	 * @return the information of the room as a string
	 */
	public String getDescription() {
		return partyRoom.getDescription() + ", Party Favor bags for 5$";
	}

}
