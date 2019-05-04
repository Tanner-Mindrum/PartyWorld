package AquaWorld;

public class PartyDecorations extends partyRoomDecorator{
	PartyRoom partyRoom;
	public PartyDecorations(PartyRoom partyRoom) {
		this.partyRoom = partyRoom;
	}
	@Override
	public String getDescription() {
		return partyRoom.getDescription() + ", party decorations for 15$";
	}
}
