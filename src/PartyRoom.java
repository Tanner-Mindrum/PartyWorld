public abstract class PartyRoom {
    private String description; //description of what room has e.g. party tables, chairs
    private int capacity; //capacity how much people room can fit
    private double cost; //cost per hour to rent room
    private String upgrades; //available upgrades for room
    //private MealPlan meals;


    /**
     * Default constructor used to initialize instance variables
     */
    public PartyRoom() {
        this.description = "N/A";
        this.capacity = 0;
        this.cost = 0;
        this.upgrades = "N/A";
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


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getUpgrades() {
        return upgrades;
    }

    public void setUpgrades(String upgrades) {
        this.upgrades = upgrades;
    }

    public abstract double calculateCost();
}
