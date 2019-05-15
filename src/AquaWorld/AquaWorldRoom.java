package AquaWorld;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * 
 * @author steven, tymee, Justin, Tanner
 *
 * This class is the aquaWorldRoom class that holds the wait list, the restrictions, 
 * description and the single instance attributes
 */
public class AquaWorldRoom extends PartyRoom{
	private String restrictions;
	private static AquaWorldRoom singleInstance = null; 
	private String description;
	private ArrayList<PartyGoer> reservationList;
	private ArrayList<PartyGoer> waitList;
	private ArrayList<String> reservationDates;
	private ArrayList<Integer> reservationTimes;
	private String fullDate;

	/**
	 * constructor of the aquaworldroom
	 */
	private AquaWorldRoom() {
		fullDate = "";
		reservationTimes = new ArrayList<>();
		reservationDates = new ArrayList<>();
		waitList = new ArrayList<PartyGoer>();
		reservationList = new ArrayList<>();
		restrictions = "To access water facilities, bathing suits must be worn at all times.";
		description = "Capacity: 75 people\nCost: $700/hr\nIncluded in cost:\n\t-Basic Meal Plan\n\t-Table & Chair Set-up\n\t-access to showers/lockers\n\t"
				+ "-life guards on duty\n\t-DJ\n"
				+ "Upgrades Available:\n\t-Upgrade Meal Plan\tCost: $(meal plan cost)\n\t-Party favor bags\t Cost: $5 per bag\n\t"
				+ "-Projector\t\tCost: $10/hour\n\t-Towel Rental\t\tCost: $2 each\n\t-Party Decorations & set-Up       Cost: $100\n\t"
				+ "     Themes: Hawaiian, Sea Life, Jungle, Space, or Modern\nRestrictions:\n\t-Bathing suits must be worn at all times.";
	}

	/**
	 * gets the instance of the singular class
	 * @return the AquaWorldRoom
	 */
	public static AquaWorldRoom getInstance() {
		if (singleInstance == null) {
			singleInstance = new AquaWorldRoom(); 
		}
		
		return singleInstance;
	}
	
	/**
	 * adds to the waitlist
	 * @param partyGoer as a partyGoer
	 */
	public void addWaitList(PartyGoer partyGoer) {
		
		waitList.add(partyGoer);
	
	}
	
	/**
	 * gets the description of the rooms
	 * @return the description as a string
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * adds a new restriction to the room
	 * @param newRestriction the restriction to the room
	 */
	public void addRestrictions(String newRestriction) {
		restrictions = newRestriction;
		
	}
	
	/**
	 * gets the restrictions
	 * @return the restrictions as a string
	 */
	public String getRestrictions() {
		return restrictions;
	}
	
	/**
	 * calculates the cost of the room
	 * @return the cost as a double
	 */
	public double calculateCost() {
		return 0;
	}

	@Override
	/**
	 * reserves the room to a partygoer
	 * @return a PartyGoer
	 */
	public boolean reserveRoom(int month, int day, int year, int startTime, int endTime, PartyGoer partyGoer, boolean justChecking) {
		boolean boolToReturn = false;
		fullDate = Integer.toString(month) + Integer.toString(day) + Integer.toString(year);
		System.out.println("Their room date: " + fullDate);
		System.out.println("Their start time: " + startTime);
		System.out.println("Their end time: " + endTime);

		//Check date
		if (!reservationDates.contains(fullDate)) {
			reservationList.add(partyGoer);
			reservationDates.add(fullDate);
			reservationTimes.add(startTime);
			reservationTimes.add(endTime);
		}
		else {
			System.out.println(reservationTimes);
			int addCounter = 0;
			for (int i = 0; i < reservationTimes.size(); i += 2) {
				if (reservationTimes.get(i) <= startTime || startTime <= reservationTimes.get(i + 1)
				|| reservationTimes.get(i) <= endTime || endTime <= reservationTimes.get(i + 1)) {
					if (!justChecking && addCounter == 0) {
						waitList.add(partyGoer);
						addCounter +=1;
					}
					boolToReturn = true;
				}
				else {
					reservationList.add(partyGoer);
					boolToReturn = false;
				}
			}
		}

		System.out.println("Reservation List: ");
		for (int i = 0; i < reservationList.size(); i++) {
			System.out.println(reservationList.get(i).getName() + reservationList.get(i).getRoomNum());
		}
		System.out.println("Waitlist: ");
		for (int i = 0; i < waitList.size(); i++) {
			System.out.println(waitList.get(i).getName() + waitList.get(i).getRoomNum());
		}


		return boolToReturn;
	}

	public void removeReservation(PartyGoer p) {
	}


}
