package AquaWorld;

public class AdultBilliardsLounge extends PartyRoom {
	private String Restrictions;
	private AdultBilliardsLounge partyRoom;
	
	public void  addRestrictions() {
		
	}
	public double calculateCost() {
		return 0;
	}

	@Override
	public PartyRoom reserveRoom() {
		return partyRoom;
	}

}
