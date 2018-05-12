package classes;

import java.util.Date;

public class Booking {

	private int bookingId;
	private int guestId;
	private int roomId;
	private Date checkInDate;
	private Date checkOutDate;

	public Booking() {

	}
	
	public Booking(int bookingId, int guestId, int roomId, Date checkInDate, Date checkOutDate) {
		this.bookingId = bookingId;
		this.guestId = guestId;
		this.roomId = roomId;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}

	/**
	 * @return the bookingId
	 */
	public int getBookingId() {
		return bookingId;
	}

	/**
	 * @param bookingId
	 *            the bookingId to set
	 */
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	/**
	 * @return the guestId
	 */
	public int getGuestId() {
		return guestId;
	}

	/**
	 * @param guestId
	 *            the guestId to set
	 */
	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	/**
	 * @return the roomId
	 */
	public int getRoomId() {
		return roomId;
	}

	/**
	 * @param roomId
	 *            the roomId to set
	 */
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}


	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

}
