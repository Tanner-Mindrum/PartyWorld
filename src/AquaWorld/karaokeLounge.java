package AquaWorld;

import java.util.ArrayList;

/**
 * 
 * @author steven, tymee, Justin, Tanner
 *
 * This class is the kareoke class that holds the waitlist, has a description and holds a kareoke lounge type
 */
public class karaokeLounge extends PartyRoom {
	private karaokeLounge partyRoom;
	private String Description = "Capacity: 10 people\nCost: $30/hr\nIncluded in cost:\n\t-Access to the karaoke machine\n"
	+ "Upgrades Available:\n\t-Add Meal Plan\tCost: $(meal plan cost)\n";
	private ArrayList<PartyGoer> reservationList;
	private ArrayList<PartyGoer> waitList;
	private ArrayList<String> reservationDates;
	private ArrayList<Integer> reservationTimes;
	private String fullDate;
	private int startTime;
	private int endTime;
	private static int confirmationNum;

	public karaokeLounge() {
		fullDate = "";
		reservationTimes = new ArrayList<>();
		reservationDates = new ArrayList<>();
		waitList = new ArrayList<PartyGoer>();
		reservationList = new ArrayList<>();
	}
	/**
	 * calculates the cost of the lounge
	 * @return the cost as a double
	 */
	public double calculateCost() {
		return 30;
	}

	/**
	 * reserves the room
	 * @return the PartyGoer that reserved the room
	 */
	public boolean reserveRoom(int month, int day, int year, int startTime, int endTime, PartyGoer partyGoer, boolean justChecking) {
		//OPEN BUG: RES DONT WORK IN SPACED TIMES
		boolean boolToReturn = false;
		this.startTime = startTime;
		this.endTime = endTime;
		fullDate = Integer.toString(month) + Integer.toString(day) + Integer.toString(year);
		System.out.println("Their room date: " + fullDate);
		System.out.println("Their start time: " + startTime);
		System.out.println("Their end time: " + endTime);

		//Check date
		if (!reservationDates.contains(fullDate)) {
			confirmationNum++;
			partyGoer.setConfirmationNum(Integer.toString(confirmationNum));
			reservationList.add(partyGoer);
			super.addPartyGoer(partyGoer);
			reservationDates.add(fullDate);
			reservationTimes.add(startTime);
			reservationTimes.add(endTime);
			boolToReturn = false;
		}
		else {
			System.out.println(reservationTimes);
			int addCounter = 0;
			for (int i = 0; i < reservationTimes.size(); i += 2) {
				//If start time or end time are inclusively in between two prior times
				if (reservationTimes.get(i) <= startTime && startTime <= reservationTimes.get(i + 1)
						|| reservationTimes.get(i) <= endTime && endTime <= reservationTimes.get(i + 1)) {

					if (!justChecking) {
						//boolToReturn = true;
						//boolToReturn = true; //steven
						partyGoer.setConfirmationNum(null);
						waitList.add(partyGoer);
						super.addWaitlistPartyGoer(partyGoer);
						addCounter += 1;
					}
					boolToReturn = true;
				}
				else if (addCounter == 0) {
					confirmationNum++;
					addCounter++;
					System.out.println("yooo");
					partyGoer.setConfirmationNum(Integer.toString(confirmationNum));
					reservationList.add(partyGoer);
					reservationDates.add(fullDate);
					reservationTimes.add(startTime);
					reservationTimes.add(endTime);
					super.addPartyGoer(partyGoer);
					boolToReturn = false;
					break;
				}
				System.out.println(boolToReturn);
			}
		}

		System.out.println("current conf num" + confirmationNum);

		System.out.println("Reservation List: ");
		for (int i = 0; i < reservationList.size(); i++) {
			System.out.println(reservationList.get(i).getName() + " for room " + reservationList.get(i).getRoomNum() + " confirmation #: " + reservationList.get(i).getConfirmationNum());
		}
		System.out.println("Waitlist: ");
		for (int i = 0; i < waitList.size(); i++) {
			System.out.println(waitList.get(i).getName() + " for room " + waitList.get(i).getRoomNum() + " confirmation #: " + waitList.get(i).getConfirmationNum());
		}

		return boolToReturn;
	}

	public boolean removeReservation(PartyGoer p) {
		boolean wasDeletedThenAdded = false;
		for (int i = 0; i < reservationList.size(); i++) {
			if (reservationList.get(i).getConfirmationNum().equals(p.getConfirmationNum())) {
				reservationList.remove(reservationList.get(i));
				reservationDates.remove(i);
				reservationTimes.remove(i);
				reservationTimes.remove(i);
				super.removeReservation(p);

				for (int j = 0; i < waitList.size(); i++) {
					if (waitList.get(i).getMonthRes() == p.getMonthRes() && waitList.get(i).getDayRes() == p.getDayRes()
							&& waitList.get(i).getYearRes() == p.getYearRes() && waitList.get(i).getStartTime() == p.getStartTime()
							&& waitList.get(i).getEndTime() == p.getEndTime()) {
						PartyGoer p2 = waitList.remove(i);
						reservationList.add(p2);
						super.addPartyGoer(p2);
						p.setConfirmationNum(Integer.toString(confirmationNum));
						confirmationNum++;
						wasDeletedThenAdded = true;
					}
				}
			}
		}

		for (int i = 0; i < waitList.size(); i++) {
			if (waitList.get(i).getName().equals(p.getName())) {
				waitList.remove(waitList.get(i));
				super.removeReservation(p);
			}
		}

		System.out.println("JUST DELETED");
		System.out.println("Reservation List: ");
		for (int i = 0; i < reservationList.size(); i++) {
			System.out.println(reservationList.get(i).getName() + " for room " + reservationList.get(i).getRoomNum() + " confirmation #: " + reservationList.get(i).getConfirmationNum());
		}
		System.out.println("Waitlist: ");
		for (int i = 0; i < waitList.size(); i++) {
			System.out.println(waitList.get(i).getName() + " for room " + waitList.get(i).getRoomNum() + " confirmation #: " + waitList.get(i).getConfirmationNum());
		}
		return wasDeletedThenAdded;
	}

	/**
	 * gets the description of the lounge
	 * @return the description as a String
	 */
	public String getDescription() {
		return Description;
	}
	
	/**
	 * adds the partyGoer to the waitlist
	 * @param partyGoer thats to be added to the list
	 */
	public void addWaitList(PartyGoer partyGoer) {
		waitList.add(partyGoer);
	}

	/**
	 * the to string method returning the info as a string
	 * @return the info as a string
	 */
//	public String toString() {
//		return "Capacity: 10 people\nCost: $30/hr\nIncluded in cost:\n\t-Basic Meal Plan\n\t-Table & Chair Set-up\n";
//				+ "Upgrades Available:\n\t-Upgrade Meal Plan\tCost: $(meal plan cost)\n\t-Party favor bags\t Cost: $5 per bag\n\t"
//				+ "-Projector\t\tCost: $10/hour\n\t-Party Decorations & set-Up       Cost: $100\n\t"
//				+ "     Themes: Hawaiian, Sea Life, Jungle, Space, or Modern";;

//		return "Capacity: 30 people\nCost: $150/hr\nIncluded in cost:\n\t-Basic Meal Plan\n\t-Table & Chair Set-up\n"
//				+ "Upgrades Available:\n\t-Upgrade Meal Plan\tCost: $(meal plan cost)\n\t-Party favor bags\t Cost: $5 per bag\n\t"
//				+ "-Projector\t\tCost: $10/hour\n\t-Party Decorations & set-Up       Cost: $100\n\t"
//				+ "     Themes: Hawaiian, Sea Life, Jungle, Space, or Modern";
//	}
}
