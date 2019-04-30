package AquaWorld;

public class AquaWorldRoom extends PartyRoom{
	private String restrictions;
	private static AquaWorldRoom singleInstance = null; 

	private AquaWorldRoom() {
		restrictions = "Nothing";
	}

	public static AquaWorldRoom getInstance() {
		if (singleInstance == null) {
			singleInstance = new AquaWorldRoom(); 
		}
		
		return singleInstance;
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
	public PartyRoom reserveRoom() {
		return singleInstance;
	}
	

}
