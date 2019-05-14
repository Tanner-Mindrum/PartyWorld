package AquaWorld;

import java.util.ArrayList;

/**
 *
 * @author steven, tymee, Justin, Tanner
 *
 * This class is the small party room that holds the waitlist and description
 */
public class smallPartyRoom extends PartyRoom {
	private String Description = "Capacity: 30 people\nCost: $150/hr\nIncluded in cost:\n\t-Basic Meal Plan\n\t-Table & Chair Set-up\n"
			+ "Upgrades Available:\n\t-Upgrade Meal Plan\tCost: $(meal plan cost)\n\t-Party favor bags\t Cost: $5 per bag\n\t"
			+ "-Projector\t\tCost: $10/hour\n\t-Party Decorations & set-Up       Cost: $100\n\t"
			+ "     Themes: Hawaiian, Sea Life, Jungle, Space, or Modern";
	private ArrayList<PartyGoer> reservationList;
	private ArrayList<PartyGoer> waitList;
	private ArrayList<String> reservationDates;
	private ArrayList<Integer> reservationTimes;
	private String fullDate;
<<<<<<< HEAD

=======
	
>>>>>>> 32cabf56c88068eb02d7ac347047ae5add619ef9
	public smallPartyRoom() {
		fullDate = "";
		reservationTimes = new ArrayList<>();
		reservationDates = new ArrayList<>();
		waitList = new ArrayList<PartyGoer>();
		reservationList = new ArrayList<>();
	}

	/**
	 * adds to the waitlist
	 * @param partyGoer to be added to the waitlist
	 */
	public void addWaitlist(PartyGoer partyGoer) {
		waitList.add(partyGoer);
	}

	/**
	 * gets the description of the room
	 * @return the description as a String
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * calculates the cost of the room
	 * @return the rooms cost as a double
	 */
	public double calculateCost() {
		return 0;
	}

	/**
	 * reserves the room
	 * @return the PartyGoer that reserved the room
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
<<<<<<< HEAD
						|| reservationTimes.get(i) <= endTime || endTime <= reservationTimes.get(i + 1)) {
=======
				|| reservationTimes.get(i) <= endTime || endTime <= reservationTimes.get(i + 1)) {
>>>>>>> 32cabf56c88068eb02d7ac347047ae5add619ef9
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