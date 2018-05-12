package classes;

import java.util.ArrayList;

public class Hotel {
	private String hotelName;
    private ArrayList<Room> rooms;
    private ArrayList<Guest> guests;
    private ArrayList<Booking> bookings;
    public Hotel()
    {
    	rooms = new ArrayList<Room>();
    	guests = new ArrayList<Guest>();
    	setBookings(new ArrayList<Booking>());
    }
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	/******************** Room Methods ******************************/
	public ArrayList<Room> getRooms() {
		return rooms;
	}
	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}

/**
 * @add  new room
 */
 public void addNewRoom(Room room){
	 getRooms().add(room);
 }
 
 /**
  * @update room
  */
 public void updateRoom(Room room){
	for(int i = 0; i < getRooms().size(); i++){
		if (room.getRoomId()==getRooms().get(i).getRoomId())
		getRooms().set(i,room);
	}
	 
 }
 
 /**
  * @delete room
  */
 public void deleteRoom(int roomId){
	 for(int i = 0; i < getRooms().size(); i++){
			if (roomId==getRooms().get(i).getRoomId())
				getRooms().remove(i);}
 }
 
 /**
  * @search room
  */
 public Room searchRoom(int roomId){
	 Room room = null;
	 for(int i = 0; i < getRooms().size(); i++){
			if (roomId==getRooms().get(i).getRoomId())
				room = getRooms().get(i);
			}
	        return room; 
 }
 
 /********************* Guest Methods *****************************/
 
    public ArrayList<Guest> getGuests() {
		return guests;
	}
	public void setGuests(ArrayList<Guest> guests) {
		this.guests = guests;
	}
	
 /**
  * @add  new guest
  */
  public void addNewGuest(Guest guest){
 	 getGuests().add(guest);
  }
  
  /**
   * @search guest
   */
  public Guest searchGuest(int guestId){
 	 Guest guest = null;
 	 for(int i = 0; i < getGuests().size(); i++){
 			if (guestId ==getGuests().get(i).getGuestId())
 				guest = getGuests().get(i);
 			}
 	        return guest; 
  }
  

  /******************** Booking Methods ******************************/
/**
 * @add  new booking
 */
  public ArrayList<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}
 public void addNewBooking(Booking booking){
	 getBookings().add(booking);
 }
 
 /**
  * @update booking
  */
 public void updateBooking(Booking booking){
	for(int i = 0; i < getBookings().size(); i++){
		if (booking.getBookingId()==getBookings().get(i).getBookingId())
		getBookings().set(i,booking);
	}
	 
 }
 
 /**
  * @delete booking
  */
 public void deleteBooking(int bookingId){
	 for(int i = 0; i < getBookings().size(); i++){
			if (bookingId==getBookings().get(i).getBookingId())
				getBookings().remove(i);}
 }
 
 /**
  * @search booking
  */
 public Booking searchBooking(int bookingId){
	 Booking booking = null;
	 for(int i = 0; i < getBookings().size(); i++){
			if (bookingId==getBookings().get(i).getBookingId())
				booking = getBookings().get(i);
			}
	        return booking; 
 }




}
