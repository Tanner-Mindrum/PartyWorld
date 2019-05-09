package AquaWorld;

public class PartyGoer {
    private String name;
    private String phoneNum;
    private String email;
    private String address;
    private String creditCardInfo;
    private String roomType;
    private String date;
    private PartyRoom partyRoom;
    private PartyGoer partyGoer;
    private String notification;
    private String Info;
    private int month; 
    private int day; 
    private int year; 

    public PartyGoer() {
        name = "N/A";
        phoneNum = "N/A";
        email = "N/A";
        address = "N/A";
        creditCardInfo = "N/A";
        roomType = "N/A";
        date = "N/A";
        Info = "";
        partyRoom = null;
        partyGoer = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreditCardInfo() {
        return creditCardInfo;
    }

    public void setCreditCardInfo(String creditCardInfo) {
        this.creditCardInfo = creditCardInfo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
    public String getInfo() {
		return Info;
    }

    public void updateInfo(String info) {
        this.Info = info;
    }
    
	public void Update() {
        partyRoom.setReservation(partyGoer);
    }

    public void setDOB(int month, int day, int year) {
        this.month = month;
        this.day = day; 
        this.year = year; 
    }

    public int getBirthMonth() {
        return month; 
    }

    public int getBirthDay() {
        return day; 
    }

    public int getBirthYear() {
        return year; 
    }
    
}
