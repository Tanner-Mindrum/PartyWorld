package AquaWorld;

import java.util.ArrayList;

public class AdultBilliardsLounge extends PartyRoom {
	private String Restrictions = "21+ only";
	private AdultBilliardsLounge partyRoom;
	private String Description = "Capacity: 10 people\nCost: $25/hr\nIncluded in cost:\n\t-Access to the pool table and cues\n"
			+ "Upgrades Available:\n\t-Add Meal Plan\tCost: $(meal plan cost)\n\nRestrictions:\n\t-21+ only";
	ArrayList<PartyGoer> waitList = new ArrayList<PartyGoer>();



	public String getDescription() {
		return Description; 
	}
	
	public String getRestriction() {
		return Restrictions;
	}
	
	public void addWaitList(PartyGoer partyGoer) {
		waitList.add(partyGoer);
	}
	
	public double calculateCost() {
		return 0;
	}

	@Override
	public PartyGoer reserveRoom() {
		return null;
	}

}
