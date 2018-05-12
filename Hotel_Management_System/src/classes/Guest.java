package classes;

public class Guest {
	private int guestId;
    private String firstName;
    private String lastName;
	private String phoneNo;
	private String nationality;
	
    public Guest(int guestId, String firstName, String lastName, String phoneNo, String nationality) {
		super();
		this.guestId = guestId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.nationality = nationality;
	}
	public int getGuestId() {
		return guestId;
	}
	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	/*@Override
	public String toString() {
		return "Guest [guestId=" + guestId + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNo="
				+ phoneNo + "]";
	}*/
	
	
	
	
	@Override
	public String toString() {
		return "Guest [guestId=" + guestId + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNo="
				+ phoneNo + ", nationality=" + nationality + "]";
	}
	
}
