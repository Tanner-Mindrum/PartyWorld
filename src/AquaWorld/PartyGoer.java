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

//    /**
//     * constructs the party goer
//     */
//    public PartyGoer() {
//        name = "N/A";
//        phoneNum = "N/A";
//        email = "N/A";
//        address = "N/A";
//        creditCardInfo = "N/A";
//        roomType = "N/A";
//        date = "N/A";
//        Info = "";
//        partyRoom = null;
//        partyGoer = null;
//    }

    public PartyGoer(String name, String phoneNum, String email, String address, String roomType, String dobMonth, String dobDay, String dobYear, boolean phonePref, boolean emailPref, boolean visaCard, boolean masterCard, boolean aeCard, String nameOnCard, String cardNum, String secCode, String expDateMonth, String expDateYear, int roomNum, int monthRes, int dayRes, int yearRes, int startTime, int endTime, boolean partyFavorBag, boolean projector, String partyDec, String mealPlanType, MealPlan mealPlan, String confirmationNum) {
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
        this.confirmationNum = confirmationNum;
    }

    public String getName() {
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

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
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

//    public PartyGoer(String name, String phoneNum, String address, String email, String dobMonth, String dobDay, String dobYear, boolean phonePref, boolean emailPref,
//                     boolean visaCard, boolean masterCard, boolean aeCard, String nameOnCard, String cardNum, String secCode, String expDateMonth,
//                     String expDateYear, String roomType, int roomNum, int monthRes, int dayRes, int yearRes, String startTime, String endTime, boolean partyFavorBag, boolean projector,
//                     String partyDec, String mealPlanType, MealPlan mealPlan) {
//
//    }

//    /**
//     * gets the name of the party goer
//     * @return the name as a string
//     */
//    public String getName() {
//        return name;
//    }
//
//    /**
//     * sets the name of the party goer
//     * @param name as a string
//     */
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    /**
//     * gets the phone number of the party goer
//     * @return the phone # as a string
//     */
//    public String getPhoneNum() {
//        return phoneNum;
//    }
//
//    /**
//     * sets the phone number of the aprty goer
//     * @param phoneNum as a string
//     */
//    public void setPhoneNum(String phoneNum) {
//        this.phoneNum = phoneNum;
//    }
//
//    /**
//     * gets the party goers email
//     * @return the email as a string
//     */
//    public String getEmail() {
//        return email;
//    }
//
//    /**
//     * sets the party goers email as a string
//     * @param email as a string
//     */
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    /**
//     * gets the party goers address
//     * @return the address as a string
//     */
//    public String getAddress() {
//        return address;
//    }
//
//    /**
//     * sets the address of the party goer
//     * @param address as a string
//     */
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    /**
//     * gets the credit card info
//     * @return the card info as a string
//     */
//    public String getCreditCardInfo() {
//        return creditCardInfo;
//    }
//
//    /**
//     *  sets the credit cards info
//     * @param creditCardInfo
//     */
//    public void setCreditCardInfo(String creditCardInfo) {
//        this.creditCardInfo = creditCardInfo;
//    }
//
//    /**
//     * gets the room type
//     * @return the room type as a string
//     */
//    public String getRoomType() {
//        return roomType;
//    }
//
//    /**
//     * sets the room type that they reserved
//     * @param roomType as a string
//     */
//    public void setRoomType(String roomType) {
//        this.roomType = roomType;
//    }
//
//    /**
//     * gets the date of reservation
//     * @return the date as a string
//     */
//	public String getDate() {
//		return date;
//	}
//
//	/**
//	 * sets the date of reservation
//	 * @param date as a string
//	 */
//	public void setDate(String date) {
//		this.date = date;
//	}
//
//	/**
//	 * gets the info of the guest
//	 * @return the info as a string
//	 */
//    public String getInfo() {
//		return Info;
//    }
//
//    /**
//     * updates the information for the guest
//     * @param info as a string
//     */
//    public void updateInfo(String info) {
//        this.Info = info;
//    }
//
//    /**
//     * updates so the guest receives the info
//     */
//	public void Update() {
//        partyRoom.setReservation(partyGoer);
//    }
//
//	/**
//	 * sets the date of birth for the guest
//	 * @param month as an int
//	 * @param day as an int
//	 * @param year as an int
//	 */
//    public void setDOB(int month, int day, int year) {
//        this.month = month;
//        this.day = day;
//        this.year = year;
//    }
//
//    /**
//     * gets the birthday month
//     * @return the month as an int
//     */
//    public int getBirthMonth() {
//        return month;
//    }
//
//    /**
//     * gets the birthday day
//     * @return the day as an int
//     */
//    public int getBirthDay() {
//        return day;
//    }
//
//    /**
//     * gets the birth year
//     * @return the birth year as an int
//     */
//    public int getBirthYear() {
//        return year;
//    }
//
//    /**
//     * sets the card name (brand)
//     * @param name of the card as a string
//     */
//    public void setCardName(String name) {
//        cardName = name;
//    }
//
//    /**
//     * gets the cards name
//     * @return the cards name as a string
//     */
//    public String getCardName() {
//        return cardName;
//    }
//
//    /**
//     * sets the cards expiration month and year
//     * @param month as an int
//     * @param year as an int
//     */
//    public void setExpirationDate(int month, int year) {
//        expirationMonth = month;
//        expirationYear = year;
//    }
//
//    /**
//     * gets the expiration month
//     * @return the expiration month as an int
//     */
//    public int getExpirationMonth() {
//        return expirationMonth;
//    }
//
//    /**
//     * gets the expiration year
//     * @return the expiration year as an int
//     */
//    public int getExpirationYear() {
//        return expirationYear;
//    }
}
