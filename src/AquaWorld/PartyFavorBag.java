package AquaWorld;

public class PartyFavorBag extends partyRoomDecorator{
	PartyRoom partyRoom;
	public PartyFavorBag(PartyRoom partyRoom) {
		this.partyRoom = partyRoom;
	}
	@Override
	public String getDescription() {
		return partyRoom.getDescription() + ", Party Favor bags for 5$";
	}

}
