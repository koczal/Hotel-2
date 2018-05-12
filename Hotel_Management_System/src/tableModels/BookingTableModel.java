package tableModels;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import classes.Booking;

public class BookingTableModel extends AbstractTableModel {
	String[] columnNames = {"BookingId", "GuestId", "RoomId","CheckInDate","CheckOutDate"};
	List<Booking> bookings = new ArrayList<Booking>();
	public BookingTableModel(List<Booking> bookings ){
		this.bookings = bookings;
	}
	public int getColumnCount() {
        return columnNames.length;
    }
    public int getRowCount() {
        return bookings.size();
    }
    public String getColumnName(int col) {
        return columnNames[col];
    }
    public Object getValueAt(int row, int col)     
   {			
				if (col == 0) {
					return bookings.get(row).getBookingId();
				} else if (col == 1) {
					return bookings.get(row).getGuestId();
				} else if (col == 2) {
					return bookings.get(row).getRoomId();
				} else if (col == 3) {
					return bookings.get(row).getCheckInDate();
				} else if (col == 4) {
					return bookings.get(row).getCheckOutDate();
				}
				else return null;
    }
    public Class getColumnClass(int col) {
       // return getValueAt(0, c).getClass();
    	if (col == 0){
            return int.class;
    	}
        	else if (col == 1){
        		return int.class;
        				}
        	else if (col == 2){
        		return int.class;
    		}
        	else if (col == 3){
        		return Date.class;
    		}
        	else if (col == 4){
        		return Date.class;
    		}
        	
        	else {
        		return null;
        	}
	}
}