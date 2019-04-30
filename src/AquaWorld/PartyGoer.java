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

    public PartyGoer() {
        name = "N/A";
        phoneNum = "N/A";
        email = "N/A";
        address = "N/A";
        creditCardInfo = "N/A";
        roomType = "N/A";
        date = "N/A";
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

	public void Update() {
        partyRoom.getReservation(partyGoer);
    }
}
