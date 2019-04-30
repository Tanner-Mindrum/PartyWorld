package AquaWorld;

public class mediumPartyRoom extends PartyRoom{
	private mediumPartyRoom partyRoom;

	public double calculateCost() {
		return 0;
	}

	@Override
	public PartyRoom reserveRoom() {
		return partyRoom;
	}

}
