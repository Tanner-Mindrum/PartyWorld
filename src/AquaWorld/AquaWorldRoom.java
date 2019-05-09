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
		description = "Olympic-sized pool with water slide, kiddie pool, and large jacuzzi";
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
