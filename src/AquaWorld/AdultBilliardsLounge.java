package AquaWorld;

import java.util.ArrayList;

/**
 * 
 * @author steven, tymee, Justin, Tanner
 *
 * This class is the room for adult billiards
 */
public class AdultBilliardsLounge extends PartyRoom {
	private String Restrictions = "21+ only";
	private AdultBilliardsLounge partyRoom;
	private String Description = "Capacity: 10 people\nCost: $25/hr\nIncluded in cost:\n\t-Access to the pool table and cues\n"
			+ "Upgrades Available:\n\t-Add Meal Plan\tCost: $(meal plan cost)\n\nRestrictions:\n\t-21+ only";
	private ArrayList<PartyGoer> reservationList;
	private ArrayList<PartyGoer> waitList;
	private ArrayList<String> reservationDates;
	private ArrayList<Integer> reservationTimes;
	private String fullDate;


	/**
	 * gets the description of the room
	 * @return the description as a String
	 */
	public String getDescription() {
		return Description; 
	}
	
	/**
	 * gets the restriction of the room as a String
	 * @return the restrictions as a String
	 */
	public String getRestriction() {
		return Restrictions;
	}
	
	/**
	 * adds a party goer to the room's waitlist
	 * @param partyGoer as a parameter to be added to the list
	 */
	public void addWaitList(PartyGoer partyGoer) {
		waitList.add(partyGoer);
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

}
