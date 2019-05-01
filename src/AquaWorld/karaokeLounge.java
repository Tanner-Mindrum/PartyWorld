package AquaWorld;

import java.util.ArrayList;

public class karaokeLounge extends PartyRoom {
	private karaokeLounge partyRoom;
	private String Description = "Enclosed lounge with karaoke machine";
	ArrayList<PartyGoer> waitList = new ArrayList<PartyGoer>();

	public double calculateCost() {
		return 0;
	}
	
	public String getDescription() {
		return Description;
	}
	
	public void addWaitList(PartyGoer partyGoer) {
		waitList.add(partyGoer);
	}

	@Override
	public PartyRoom reserveRoom() {
		return partyRoom;
	}

}
