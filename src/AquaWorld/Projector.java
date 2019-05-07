package AquaWorld;

public class Projector extends partyRoomDecorator{
	PartyRoom partyRoom;
	public Projector(PartyRoom partyRoom) {
		this.partyRoom = partyRoom;
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return partyRoom.getDescription() + ", Projector for 10$ per hour";
	}
	
}
