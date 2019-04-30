package AquaWorld;

public class karaokeLounge extends PartyRoom {
	private karaokeLounge partyRoom;

	public double calculateCost() {
		return 0;
	}


	@Override
	public PartyRoom reserveRoom() {
		return partyRoom;
	}

}
