package AquaWorld;

import java.util.ArrayList;
import java.util.Calendar;

public class AquaWorldRoom extends PartyRoom{
	private String restrictions;
	private static AquaWorldRoom singleInstance = null; 
	private String description;
	private ArrayList<PartyGoer> waitList = new ArrayList<PartyGoer>();

	private AquaWorldRoom() {
		restrictions = "To access water facilities, bathing suits must be worn at all times.";
		description = "Capacity: 75 people\nCost: $700/hr\nIncluded in cost:\n\t-Basic Meal Plan\n\t-Table & Chair Set-up\n\t-access to showers/lockers\n\t"
				+ "-life guards on duty\n\t-DJ\n"
				+ "Upgrades Available:\n\t-Upgrade Meal Plan\tCost: $(meal plan cost)\n\t-Party favor bags\t Cost: $5 per bag\n\t"
				+ "-Projector\t\tCost: $10/hour\n\t-Towel Rental\t\tCost: $2 each\n\t-Party Decorations & set-Up       Cost: $100\n\t"
				+ "     Themes: Hawaiian, Sea Life, Jungle, Space, or Modern\nRestrictions:\n\t-Bathing suits must be worn at all times.";
	}

	public static AquaWorldRoom getInstance() {
		if (singleInstance == null) {
			singleInstance = new AquaWorldRoom(); 
		}
		
		return singleInstance;
	}
	public void addWaitList(PartyGoer partyGoer) {
		
		waitList.add(partyGoer);
	
	}
	public String getDescription() {
		return description;
	}
	
	public void addRestrictions(String newRestriction) {
		restrictions = newRestriction;
		
	}
	
	public String getRestrictions() {
		return restrictions;
	}
	public double calculateCost() {
		return 0;
	}

	@Override
	public PartyGoer reserveRoom() {
		return null;
	}


}
