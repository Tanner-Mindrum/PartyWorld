package AquaWorld;

import java.util.ArrayList;

public class karaokeLounge extends PartyRoom {
	private karaokeLounge partyRoom;
	private String Description = "Enclosed lounge with karaoke machine";
	ArrayList<PartyGoer> waitList = new ArrayList<PartyGoer>();


	public double calculateCost() {
		return 0;
	}

	@Override
	public PartyGoer reserveRoom() {
		return null;
	}

	public String getDescription() {
		return Description;
	}
	
	public void addWaitList(PartyGoer partyGoer) {
		waitList.add(partyGoer);
	}

}
