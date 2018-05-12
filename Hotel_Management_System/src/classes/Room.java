package classes;

public class Room {
	private int roomId;
    private String roomNo;
    private byte capacity;
    private float price;
    
	public Room(int roomId, String roomNo, byte capacity, float price) {
		this.roomId = roomId;
		this.roomNo = roomNo;
		this.capacity = capacity;
		this.price = price;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public byte getCapacity() {
		return capacity;
	}
	public void setCapacity(byte capacity) {
		this.capacity = capacity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}    
}
