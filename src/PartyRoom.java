public abstract class PartyRoom {
    private String description; //description of what room has e.g. party tables, chairs
    private int capacity; //capacity how much people room can fit
    private double cost; //cost per hour to rent room
    private String upgrades; //available upgrades for room
    //private MealPlan meals;
    private PartyGoer partyGoerInfo;
    private boolean reservationMade;


    /**
     * Default constructor used to initialize instance variables
     */
    public PartyRoom() {
        this.description = "N/A";
        this.capacity = 0;
        this.cost = 0;
        this.upgrades = "N/A";
        this.partyGoerInfo = null;
        this.reservationMade = false;
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

    public void setUpgrades(String upgrades) {
        this.upgrades = upgrades;
    }

    public void setReservation(PartyGoer currentPartyGoer) {

    }

    public void cancelReservation(PartyGoer currentPartyGoer) {

    }

    public String notifyPartyGoer() {
        //Notifying whether they set or cancel
        if (reservationMade) {
            //if room is full, add to wait list
            return "Your reservation has been set!";
        }
        else {
            return "Your reservation has been cancelled.";
        }
    }

    public abstract double calculateCost();
}
