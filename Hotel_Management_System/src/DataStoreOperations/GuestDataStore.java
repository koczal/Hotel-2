package DataStoreOperations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import classes.Guest;

public class GuestDataStore {

		static String  guestDataStore_FilePath = "./DataStore/guests.csv";
		public static ArrayList<Guest> readCSV_Guests() {  
			   
			ArrayList<Guest> allGuests = new ArrayList<Guest>();
			
			try {
				
				// Create a new BufferedReader instance for reading the text file.
				BufferedReader bufferReader = new BufferedReader(new FileReader(guestDataStore_FilePath));
				
				// Read the lines from the text file row by row.
				String dataRow = null;
				while ((dataRow = bufferReader.readLine()) != null) {
					
					String[] tokens=dataRow.split(",");
					 int guestId= Integer.parseInt( tokens[0]);;
				     String guestFirstName= tokens[1];
				     String guestLastName=tokens[2];
				     String guestPhoneNo=tokens[3];				
				     String guestNationality=tokens[4];	
					Guest guest= new Guest(guestId,guestFirstName,guestLastName,guestPhoneNo,guestNationality);
					//  Add the single row data the ArrayList.   
					allGuests.add(guest);
				}
				
				// Close the BufferedReader instance now that we have finished writing to the text file. 
				bufferReader.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
			// Return the ArrayList of lines of text read from the text file.
			return allGuests;
			
			
		}
		public static void writeCSV_Guests(List<Guest> allguests) {
			
			try {
				
				// Create a new bufferWriter instance for writing the text file.
				BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(guestDataStore_FilePath));
				
				for (int i=0; i<allguests.size(); i++) {
					
					// Write the row of text to the text file.
					Guest guest = allguests.get(i);
					
					bufferWriter.write(guest.getGuestId() + "," + guest.getFirstName() + "," +
					guest.getLastName() +"," + guest.getPhoneNo() + "," + guest.getNationality() );
					
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