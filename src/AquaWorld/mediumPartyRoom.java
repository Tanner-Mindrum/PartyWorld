package AquaWorld;

import java.util.ArrayList;

public class mediumPartyRoom extends PartyRoom{
	private mediumPartyRoom partyRoom; //This could be dangerous as it is already created by the factory
	private String Description = "Capacity: 45 people\nCost: $250/hr\nIncluded in cost:\n\t-Basic Meal Plan\n\t-Table & Chair Set-up\n\t-DJ\n"
			+ "Upgrades Available:\n\t-Upgrade Meal Plan\tCost: $3 X (meal plan cost)\n\t-Party favor bags\t Cost: $5 per bag\n\t"
			+ "-Projector\t\tCost: $10/hour\n\t-Party Decorations & set-Up       Cost: $100\n\t"
			+ "     Themes: Hawaiian, Sea Life, Jungle, Space, or Modern";
	ArrayList<PartyGoer> waitList = new ArrayList<PartyGoer>();
	
	
	public double calculateCost() {
		return 0;
	}

	@Override
	public PartyGoer reserveRoom() {
		return null;
	}

	public void setDescription(String description) {
		Description = description;
	}
	public void addWaitList(PartyGoer partyGoer) {
		waitList.add(partyGoer);
	}
	
	public String getDescription() { 
		return Description; 
	}
	
	//We need to fix this for all classes

}
