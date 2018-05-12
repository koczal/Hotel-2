package tableModels;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import classes.Room;

public class RoomTableModel extends AbstractTableModel {

	String[] columnNames = {"roomId", "roomNo", "capacity","price"};
	List<Room> rooms = new ArrayList<Room>();
	public RoomTableModel(List<Room> rooms ){
		this.rooms = rooms;
	}
	public int getColumnCount() {
        return columnNames.length;
    }
    public int getRowCount() {
        return rooms.size();
    }
    public String getColumnName(int col) {
        return columnNames[col];
    }
    public Object getValueAt(int row, int col)     
   {			
				if (col == 0) {
					return rooms.get(row).getRoomId();
				} else if (col == 1) {
					return rooms.get(row).getRoomNo();
				} else if (col == 2) {
					return rooms.get(row).getCapacity();
				} else if (col == 3) {
					return rooms.get(row).getPrice();
				}
				else return null;
    }
    public Class getColumnClass(int col) {
       // return getValueAt(0, c).getClass();
    	if (col == 0){
            return int.class;
    	}
        	else if (col == 1){
        		return String.class;
        				}
        	else if (col == 2){
        		return byte.class;
    		}
        	else if (col == 3){
        		return Float.class;
    		}
        	
        	else {
        		return null;
        	}
	}
}