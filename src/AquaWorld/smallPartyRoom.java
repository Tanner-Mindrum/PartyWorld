package AquaWorld;

import java.util.ArrayList;

public class smallPartyRoom extends PartyRoom{
	private smallPartyRoom partyRoom;
	private String Description = "Capacity: 30 people\nCost: $150/hr\nIncluded in cost:\n\t-Basic Meal Plan\n\t-Table & Chair Set-up\n"
			+ "Upgrades Available:\n\t-Upgrade Meal Plan\tCost: $(meal plan cost)\n\t-Party favor bags\t Cost: $5 per bag\n\t"
			+ "-Projector\t\tCost: $10/hour\n\t-Party Decorations & set-Up       Cost: $100\n\t"
			+ "     Themes: Hawaiian, Sea Life, Jungle, Space, or Modern";
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
