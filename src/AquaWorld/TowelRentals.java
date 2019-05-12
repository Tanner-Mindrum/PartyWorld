package AquaWorld;

/**
 * 
 * @author steve
 *
 *
 * enables the ability to rent towels for the party rooms
 */
public class TowelRentals extends partyRoomDecorator{
	PartyRoom partyRoom;
	
	/**
	 * constructor that adds towel rental
	 * @param partyRoom to add towel rental to
	 */
	public TowelRentals(PartyRoom partyRoom) {
		this.partyRoom = partyRoom;
	}
	@Override
	/**
	 * gets the description of the party room
	 * @return the party rooms description as a string
	 */
	public String getDescription() {
		return partyRoom.getDescription() + ", towel rental for 2$ each";
	}

}
