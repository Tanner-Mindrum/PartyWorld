package AquaWorld;

/**
 * 
 * @author steven, taner, tymee, justin
 *
 * the soda class thaat holds its flavor
 */
public class Soda {

    private String sodaDescription; 

    /**
     * constructor that holds its flavor
     * @param flavor as a string
     */
    public Soda(String flavor) {
        this.sodaDescription = flavor;
    }

    /**
     * gets the flavor of the soda
     * @return the flavor as a string
     */
    public String getSodaFlavor() {
    	return this.sodaDescription;
    }
}
