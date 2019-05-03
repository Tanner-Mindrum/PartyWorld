package AquaWorld;

import java.util.ArrayList;

public class AdultBilliardsLounge extends PartyRoom {
	private String Restrictions = "21+ only";
	private AdultBilliardsLounge partyRoom;
	private String Description = "Enclosed lounge with pool table";
	ArrayList<PartyGoer> waitList = new ArrayList<PartyGoer>();
	ArrayList<PartyGoer> reserveList = new ArrayList<>();



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
	public ArrayList<PartyGoer> reserveRoom() {
		return reserveList;
	}

}
