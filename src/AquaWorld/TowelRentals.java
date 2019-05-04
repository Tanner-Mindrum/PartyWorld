package AquaWorld;

public class TowelRentals extends partyRoomDecorator{
	PartyRoom partyRoom;
	public TowelRentals(PartyRoom partyRoom) {
		this.partyRoom = partyRoom;
	}
	@Override
	public String getDescription() {
		return partyRoom.getDescription() + ", towel rental for 2$ each";
	}

}
