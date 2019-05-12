package AquaWorld;

/**
 * 
 * @author steve
 *
 * is the projector class that is added to the party rooms
 */
public class Projector extends partyRoomDecorator{
	PartyRoom partyRoom;
	
	/**
	 * constructor that adds the projector to the party room
	 * @param partyRoom to add the projector to
	 */
	public Projector(PartyRoom partyRoom) {
		this.partyRoom = partyRoom;
	}
	@Override
	/**
	 * gets the description of the room
	 * @return the description as a string
	 */
	public String getDescription() {
		// TODO Auto-generated method stub
		return partyRoom.getDescription() + ", Projector for 10$ per hour";
	}
	
}
