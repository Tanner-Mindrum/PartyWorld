package AquaWorld;
/**
 * 
 * @author steven, tanner, tymee, justin
 *
 * this class holds all of the party goers information and what room they have been assigned
 */
public class PartyGoer {
    private String name;
    private String phoneNum;
    private String email;
    private String address;
//    private String creditCardInfo;
    private String roomType;
//    private String date;
//    private PartyRoom partyRoom;
//    private PartyGoer partyGoer;
//    private String notification;
//    private String Info;
//    private int month;
//    private int day;
//    private int year;
//    private String cardName;
//    private int expirationMonth;
//    private int expirationYear;


    private String dobMonth;
    private String dobDay;
    private String dobYear;
    private boolean phonePref;
    private boolean emailPref;
    private boolean visaCard;
    private boolean masterCard;
    private boolean aeCard;
    private String nameOnCard;
    private String cardNum;
    private String secCode;
    private String expDateMonth;
    private String expDateYear;
    private int roomNum;
    private int monthRes;
    private int dayRes;
    private int yearRes;
    private int startTime;
    private int endTime;
    private boolean partyFavorBag;
    private boolean projector;
    private String partyDec;
    private String mealPlanType;
    private MealPlan mealPlan;
    private String confirmationNum;

    public PartyGoer(String name, String phoneNum, String email, String address, String roomType, String dobMonth, String dobDay, String dobYear, boolean phonePref, boolean emailPref, boolean visaCard, boolean masterCard, boolean aeCard, String nameOnCard, String cardNum, String secCode, String expDateMonth, String expDateYear, int roomNum, int monthRes, int dayRes, int yearRes, int startTime, int endTime, boolean partyFavorBag, boolean projector, String partyDec, String mealPlanType) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
        this.address = address;
        this.roomType = roomType;
        this.dobMonth = dobMonth;
        this.dobDay = dobDay;
        this.dobYear = dobYear;
        this.phonePref = phonePref;
        this.emailPref = emailPref;
        this.visaCard = visaCard;
        this.masterCard = masterCard;
        this.aeCard = aeCard;
        this.nameOnCard = nameOnCard;
        this.cardNum = cardNum;
        this.secCode = secCode;
        this.expDateMonth = expDateMonth;
        this.expDateYear = expDateYear;
        this.roomNum = roomNum;
        this.monthRes = monthRes;
        this.dayRes = dayRes;
        this.yearRes = yearRes;
        this.startTime = startTime;
        this.endTime = endTime;
        this.partyFavorBag = partyFavorBag;
        this.projector = projector;
        this.partyDec = partyDec;
        this.mealPlanType = mealPlanType;
        this.mealPlan = mealPlan;
        this.confirmationNum = "";
    }

    public String getName() {
    	//System.out.println(name);
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getDobMonth() {
        return dobMonth;
    }

    public String getDobDay() {
        return dobDay;
    }

    public String getDobYear() {
        return dobYear;
    }

    public boolean isPhonePref() {
        return phonePref;
    }

    public boolean isEmailPref() {
        return emailPref;
    }

    public boolean isVisaCard() {
        return visaCard;
    }

    public boolean isMasterCard() {
        return masterCard;
    }

    public boolean isAeCard() {
        return aeCard;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public String getCardNum() {
        return cardNum;
    }

    public String getSecCode() {
        return secCode;
    }

    public String getExpDateMonth() {
        return expDateMonth;
    }

    public String getExpDateYear() {
        return expDateYear;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public int getMonthRes() {
        return monthRes;
    }

    public int getDayRes() {
        return dayRes;
    }

    public int getYearRes() {
        return yearRes;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public boolean isPartyFavorBag() {
        return partyFavorBag;
    }

    public boolean isProjector() {
        return projector;
    }

    public String getPartyDec() {
        return partyDec;
    }

    public String getMealPlanType() {
        return mealPlanType;
    }

    public MealPlan getMealPlan() {
        return mealPlan;
    }

    public String getConfirmationNum() {
        return confirmationNum;
    }

    public void setConfirmationNum(String confirmationNum) {
        this.confirmationNum = confirmationNum;
    }

    public String toString() {
        String partialCard = getCardNum().substring(getCardNum().length() - 4, getCardNum().length());
        String timeThingStart = Integer.toString(getStartTime()).substring(0) + ":" + Integer.toString(getStartTime()).substring(1, Integer.toString(getStartTime()).length());
        String timeThingEnd = Integer.toString(getEndTime()).substring(0) + ":" + Integer.toString(getEndTime()).substring(1, Integer.toString(getEndTime()).length());
        return getName() + "\n" + getPhoneNum() + "\n" + getEmail() + "\n" + getAddress() + "\n" + getRoomType() + "\n" + getDobMonth() + "/" +
                getDobDay() + "/" + getDobYear() + "\n" + getNameOnCard() + "\n" + partialCard + "\n" + getRoomNum() + "\n" + getMonthRes() + "/" +
                getDayRes() + "/" + getYearRes() + "\n" + timeThingStart + "-" + timeThingEnd + "\n" + getMealPlanType() + "\n" + getConfirmationNum();

    }
}
