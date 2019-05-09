package AquaWorld;

import java.util.ArrayList;

public class karaokeLounge extends PartyRoom {
	private karaokeLounge partyRoom;
//	private String Description = "Enclosed karaoke lounge with karaoke machine";
	ArrayList<PartyGoer> waitList = new ArrayList<PartyGoer>();


	public double calculateCost() {
		return 0;
	}

	@Override
	public PartyGoer reserveRoom() {
		return null;
	}

//	public String getDescription() {
//		return Description;
//	}
	
	public void addWaitList(PartyGoer partyGoer) {
		waitList.add(partyGoer);
	}

	public String toString() {
		return "Capacity: 10 people\nCost: $30/hr\nIncluded in cost:\n\t-Basic Meal Plan\n\t-Table & Chair Set-up\n";
//				+ "Upgrades Available:\n\t-Upgrade Meal Plan\tCost: $(meal plan cost)\n\t-Party favor bags\t Cost: $5 per bag\n\t"
//				+ "-Projector\t\tCost: $10/hour\n\t-Party Decorations & set-Up       Cost: $100\n\t"
//				+ "     Themes: Hawaiian, Sea Life, Jungle, Space, or Modern";;

//		return "Capacity: 30 people\nCost: $150/hr\nIncluded in cost:\n\t-Basic Meal Plan\n\t-Table & Chair Set-up\n"
//				+ "Upgrades Available:\n\t-Upgrade Meal Plan\tCost: $(meal plan cost)\n\t-Party favor bags\t Cost: $5 per bag\n\t"
//				+ "-Projector\t\tCost: $10/hour\n\t-Party Decorations & set-Up       Cost: $100\n\t"
//				+ "     Themes: Hawaiian, Sea Life, Jungle, Space, or Modern";
	}

}
