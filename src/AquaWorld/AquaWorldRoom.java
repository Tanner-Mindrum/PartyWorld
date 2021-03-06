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
	private int startTime;
	private int endTime;
	private static int confirmationNum;

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
		return 700;
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


}
