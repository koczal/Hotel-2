package DataStoreOperations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import classes.Booking;

public class BookingDataStore {

		static String  bookingsDataStore_FilePath = "./DataStore/bookings.csv";
		public static ArrayList<Booking> readCSV_Bookings() {  
			   
			ArrayList<Booking> allBookings = new ArrayList<Booking>();
			
			try {
				
				// Create a new BufferedReader instance for reading the text file.
				BufferedReader bufferReader = new BufferedReader(new FileReader(bookingsDataStore_FilePath));
				
				// Read the lines from the text file row by row.
				String dataRow = null;
				while ((dataRow = bufferReader.readLine()) != null) {
					
					String[] tokens=dataRow.split(",");
					 int bookingId= Integer.parseInt( tokens[0]);;
				     int guestId= Integer.parseInt(tokens[1]);
				     int roomId=Integer.parseInt(tokens[2]);		     
				     
				     Date checkInDate=null,checkOutDate=null;
						try {
							checkInDate = new SimpleDateFormat("dd/MM/yyyy").parse(tokens[3]);
							checkOutDate =new SimpleDateFormat("dd/MM/yyyy").parse(tokens[4]);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						Booking booking = new Booking(bookingId,guestId,roomId,checkInDate,checkOutDate);
					allBookings.add(booking);
				}
				
				// Close the BufferedReader instance now that we have finished writing to the text file. 
				bufferReader.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
			// Return the ArrayList of lines of text read from the text file.
			return allBookings;
			
			
		}
		public static void writeCSV_Bookings(List<Booking> allbookings) {
			
			try {
				
				// Create a new bufferWriter instance for writing the text file.
				BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(bookingsDataStore_FilePath));
				
				for (int i=0; i<allbookings.size(); i++) {
					
					// Write the row of text to the text file.
					Booking booking = allbookings.get(i);
					
					bufferWriter.write(booking.getBookingId() + "," + booking.getGuestId() + "," +
					booking.getRoomId() +"," +new  SimpleDateFormat("dd/MM/yyyy").format(booking.getCheckInDate()) +"," + new  SimpleDateFormat("dd/MM/yyyy").format(booking.getCheckOutDate()) );
					
					// Write the new line character(s) to the text file for each new line of data.
					bufferWriter.newLine();
				}
				
				// Close the bufferWriter file stream when done.
				bufferWriter.close();
				
			}  catch (Exception e) {
				
				// An unexpected error occurred so we print out the error message to the Console. 
				e.printStackTrace();
			}
		}
	}