package AquaWorld;

public class smallPartyRoom extends PartyRoom{
	private smallPartyRoom partyRoom;

	public double calculateCost() {
		return 0;
	}

	@Override
	public PartyRoom reserveRoom() {
		return partyRoom;
	}

}
