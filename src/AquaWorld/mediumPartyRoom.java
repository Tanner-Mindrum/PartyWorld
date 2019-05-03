package AquaWorld;

import java.util.ArrayList;

public class mediumPartyRoom extends PartyRoom{
	private mediumPartyRoom partyRoom; //This could be dangerous as it is already created by the factory
	private String Description = "Room with party tables and chairs, quick access to arcade";
	ArrayList<PartyGoer> waitList = new ArrayList<PartyGoer>();
	ArrayList<PartyGoer> reserveList = new ArrayList<>();
	
	
	public double calculateCost() {
		return 0;
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
	@Override
	public ArrayList<PartyGoer> reserveRoom() {
		return reserveList;
	}

}
