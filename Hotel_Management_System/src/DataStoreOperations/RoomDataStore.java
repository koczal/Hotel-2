package DataStoreOperations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import classes.Room;

public class RoomDataStore {
	static String  roomDataStore_FilePath = "./DataStore/rooms.csv";
	public static ArrayList<Room> readCSV_Rooms() {  
		   
		ArrayList<Room> allRooms = new ArrayList<Room>();
		
		try {
			
			// Create a new BufferedReader instance for reading the text file.
			BufferedReader bufferReader = new BufferedReader(new FileReader(roomDataStore_FilePath));
			
			// Read the lines from the text file row by row.
			String dataRow = null;
			while ((dataRow = bufferReader.readLine()) != null) {
				
				String[] tokens=dataRow.split(",");
				 int roomId= Integer.parseInt( tokens[0]);;
			     String roomNo= tokens[1];
			     byte capacity=Byte.parseByte(tokens[2]);
			     float price=Float.parseFloat(tokens[3]);				
				Room room= new Room(roomId,roomNo,capacity,price);
				//  Add the single row data the ArrayList.   
				allRooms.add(room);
			}
			
			// Close the BufferedReader instance now that we have finished writing to the text file. 
			bufferReader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		// Return the ArrayList of lines of text read from the text file.
		return allRooms;
		
		
	}
	public static void writeCSV_Rooms(List<Room> allrooms) {
		
		try {
			
			// Create a new bufferWriter instance for writing the text file.
			BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(roomDataStore_FilePath));
			
			for (int i=0; i<allrooms.size(); i++) {
				
				// Write the row of text to the text file.
				Room room = allrooms.get(i);
				
				bufferWriter.write(room.getRoomId() + "," + room.getRoomNo() + "," +
				room.getCapacity() +"," + room.getPrice() );
				
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
