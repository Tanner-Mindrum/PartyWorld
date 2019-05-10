package AquaWorld;

/**
 * 
 * @author steven, tymee, Justin, Tanner
 *
 * This class is the class to add party decorations
 */
public class PartyDecorations extends partyRoomDecorator{
	PartyRoom partyRoom;
	
	/**
	 * this is the constructor for the PartyDecorations
	 * @param partyRoom (the party room to add decorations to)
	 */
	public PartyDecorations(PartyRoom partyRoom) {
		this.partyRoom = partyRoom;
	}
	@Override
	/**
	 * gets the description of the party decoartions as a string
	 * @return the description as a String
	 */
	public String getDescription() {
		return partyRoom.getDescription() + ", party decorations for 15$";
	}
}
