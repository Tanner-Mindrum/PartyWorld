package AquaWorld;

import java.util.ArrayList;

public class smallPartyRoom extends PartyRoom{
	private smallPartyRoom partyRoom;
	private String Description = "Small Room with party tables, chairs, and adjacent to arcade";
	private ArrayList<PartyGoer> waitList = new ArrayList<PartyGoer>();
	
//	public smallPartyRoom() {
//		partyRoom = new smallPartyRoom();
//	}
//	
	public void addWaitlist(PartyGoer partyGoer) {
		waitList.add(partyGoer);
	}
	
	public String getDescription() {
		return Description; 
	}
	
	public double calculateCost() {
		return 0;
	}

	@Override
	public PartyGoer reserveRoom() {
		return null;
	}

}
