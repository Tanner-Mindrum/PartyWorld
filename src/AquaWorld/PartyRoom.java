package AquaWorld;

import java.util.ArrayList;

public class PartyRoom {
    private String description; //description of what room has e.g. party tables, chairs
    private int capacity; //capacity how much people room can fit
    private double cost; //cost per hour to rent room
    private String upgrades; //available upgrades for room
    private MealPlan meals;
    private PartyGoer partyGoerInfo;
    private boolean reservationMade;
    private String notification;

    private static ArrayList<PartyGoer> allPartyGoers = new ArrayList<>();
    private static ArrayList<PartyGoer> allWaitlistPartyGoers = new ArrayList<>();
    private static ArrayList<PartyGoer> removedPartyGoers = new ArrayList<>();
    private static ArrayList<PartyGoer> removedPartyGoersWaitlist = new ArrayList<>();

    /**
     * Default constructor used to initialize instance variables
     */
    public PartyRoom() {
        this.description = "N/A";
        this.capacity = 0;
        this.cost = 0;
        this.upgrades = "N/A";
        this.setPartyGoerInfo(null);
        this.reservationMade = false;
        this.notification = "N/A";
    }

    /**
     * Gets the description of a room
     * @return - a string representing the description of a room
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of a room
     * @param description - a string representing the description of a room
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the possible capacity of a room
     * @return - an int representing how many people can fit in the room
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets the possible capacity of a room
     * @param capacity - an int representing the new amount of people that can fit in a room
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Gets the current cost of a room
     * @return - a double representing the cost of a room per hour
     */
    public double getCost() {
        return cost;
    }

    /**
     * Sets the current cost of a room
     * @param cost - a double representing the new cost per hour of a room
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Gets the available upgrades for a room
     * @return - a string representing the possible
     */
    public String getUpgrades() {
        return upgrades;
    }

    /**
     * sets the upgrades to the room
     * @param upgrades to be added as a string
     */
    public void setUpgrades(String upgrades) {
        this.upgrades = upgrades;
    }

    /**
     * sets the reservation of the room
     * @param currentPartyGoer as a PartyGoer
     */
    public void setReservation(PartyGoer currentPartyGoer) {

    }

    /**
     * gets the notification
     * @return the notification as a string
     */
    public String getNotification() {
        return notification;
    }

    /**
     * sets the notification to the room
     * @param notification as a string
     */
    public void setNotification(String notification) {
        this.notification = notification;
    }

    /**
     *  cancels the reservation of the partygoer
     * @param currentPartyGoer to remove from the reservation
     */
    public void cancelReservation(PartyGoer currentPartyGoer) {
        //If a user cancels their reservation, then set the reservation times back to true (remove from arraylist)

    }

    /**
     * calculates the cost
     * @return the cost as a double
     */
    public double calculateCost() {
        return 0;
    }

    /**
     * gets the meal plans
     * @return the MealPlan
     */
	public MealPlan getMeals() {
		return meals;
	}

	/**
	 * sets new meal plans
	 * @param meals as a MealPlan
	 */
	public void setMeals(MealPlan meals) {
		this.meals = meals;
	}

	/**
	 * gets the party goers information
	 * @return the PartyGoer
	 */
	public PartyGoer getPartyGoerInfo() {
		return partyGoerInfo;
	}

	/**
	 * sets the partyGoers info
	 * @param partyGoerInfo as a PartyGoer
	 */
	public void setPartyGoerInfo(PartyGoer partyGoerInfo) {
		this.partyGoerInfo = partyGoerInfo;
	}

	public void addPartyGoer(PartyGoer p) {
	    allPartyGoers.add(p);
    }

    public void addWaitlistPartyGoer(PartyGoer p) {
        System.out.println("hey");
	    allWaitlistPartyGoers.add(p);
    }


	/**
	 * reserves the room for the partyGoer
	 * @return the partyGoer 
	 */
	public boolean reserveRoom(int month, int day, int year, int startTime, int endTime, PartyGoer partyGoer, boolean checkingAvaliability) {
	    return false;
    };

	public ArrayList<PartyGoer> getAllPartyGoers() {
	    return allPartyGoers;
    }

    public ArrayList<PartyGoer> getAllWaitlistPartyGoers() {
        return allWaitlistPartyGoers;
    }

    public boolean removeReservation(PartyGoer p) {
	    allPartyGoers.remove(p);
	    removedPartyGoers.clear();
	    removedPartyGoers.add(p);
	    return false;
    }

    public void removeWaitlist(PartyGoer p) {
	    allWaitlistPartyGoers.remove(p);
	    removedPartyGoersWaitlist.clear();
	    removedPartyGoersWaitlist.add(p);
    }

    public PartyGoer getRemovedPartyGoer() {
	    return removedPartyGoers.get(0);
    }

    public PartyGoer getRemovedPartyGoerWaitlist() {
        return removedPartyGoersWaitlist.get(0);
    }

    public ArrayList<PartyGoer> getRemovedPartyGoerWaitlistList() {
        return removedPartyGoersWaitlist;
    }
}
