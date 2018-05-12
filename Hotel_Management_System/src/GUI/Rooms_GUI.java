package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FocusTraversalPolicy;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import classes.Hotel;
import classes.Room;
import DataStoreOperations.RoomDataStore;
import tableModels.RoomTableModel;

public class Rooms_GUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblRoomid;
	private JLabel lblRoomNumber;
	private JLabel lblCapacity;
	private JLabel lblPrice;
	private JTextField textField_RoomId;
	private JTextField textField_RoomNo;
	private JTextField textField_RoomCapacity;
	private JTextField textField_RoomPrice;
	private JTextField textField_9;
	private JLabel lblSearch;
	private JButton btnNewButton;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnRefresh;
	Hotel hotel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rooms_GUI frame = new Rooms_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Rooms_GUI() {
		hotel = new Hotel();
		setTitle("Rooms");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 688);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		hotel.setRooms(RoomDataStore.readCSV_Rooms());		
		RoomTableModel roomtablemodel = new RoomTableModel(hotel.getRooms());
		
		table = new JTable(roomtablemodel);
		table.setBounds(380, 281, -14, -69);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
			    if (e.getValueIsAdjusting()|| table.getSelectedRow()==-1) //this event is not the last in the chain - This is a mouseDown event.
	                   return;
	  
	    textField_RoomId.setText(table.getValueAt(table.getSelectedRow(),0). toString());
	    textField_RoomNo.setText(table.getValueAt(table.getSelectedRow(),1). toString());
	    textField_RoomCapacity.setText(table.getValueAt(table.getSelectedRow(),2). toString());
	    textField_RoomPrice.setText(table.getValueAt(table.getSelectedRow(),2). toString());
	       }

			
		});

		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(10, 279, 678, 370);
		contentPane.add(scrollPane_5);
		
		
		scrollPane_5.setViewportView(table);
		
		JLabel lblAddNewRoom = new JLabel("Manage Room");
		lblAddNewRoom.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddNewRoom.setBounds(29, 11, 223, 33);
		contentPane.add(lblAddNewRoom);
		
		lblRoomid = new JLabel("RoomID");
		lblRoomid.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRoomid.setBounds(34, 65, 65, 24);
		contentPane.add(lblRoomid);
		
		lblRoomNumber = new JLabel("Room Number");
		lblRoomNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRoomNumber.setBounds(34, 108, 91, 14);
		contentPane.add(lblRoomNumber);
		
		lblCapacity = new JLabel("Capacity");
		lblCapacity.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCapacity.setBounds(34, 142, 65, 14);
		contentPane.add(lblCapacity);
		
		lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrice.setBounds(34, 180, 46, 14);
		contentPane.add(lblPrice);
		
		textField_RoomId = new JTextField();
		textField_RoomId.setColumns(10);
		textField_RoomId.setBounds(152, 61, 273, 22);
		contentPane.add(textField_RoomId);
		// validation check only integers
		textField_RoomId.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				// allows only numbers and back space
				 char c = e.getKeyChar();
			      if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
			         e.consume();  // ignore event
			      }
			}
		});
		
		textField_RoomNo = new JTextField();
		textField_RoomNo.setColumns(10);
		textField_RoomNo.setBounds(152, 100, 273, 22);
		contentPane.add(textField_RoomNo);
		
		textField_RoomCapacity = new JTextField();
		textField_RoomCapacity.setColumns(10);
		textField_RoomCapacity.setBounds(152, 134, 273, 22);
		contentPane.add(textField_RoomCapacity);
		
		textField_RoomPrice = new JTextField();
		textField_RoomPrice.setColumns(10);
		textField_RoomPrice.setBounds(152, 172, 273, 22);
		contentPane.add(textField_RoomPrice);
		textField_RoomPrice.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				//allows only numbers, back space, delete, and slash. 
				 char c = e.getKeyChar();
			      if ( ((c < '0') || (c > '9')) &&
			         (c != KeyEvent.VK_BACK_SPACE) &&
			         (c != KeyEvent.VK_DELETE) && (c != KeyEvent.VK_SLASH))        
			      {
			        e.consume(); // ignore event
			}
			}
			
		});
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(63, 246, 158, 22);
		contentPane.add(textField_9);
		TableRowSorter<TableModel>sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		textField_9.addKeyListener(new KeyAdapter() {
			// Selecting the rows with selecting PersonID or FName or LName
			public void keyReleased(KeyEvent e) {
				ArrayList<RowFilter<TableModel,Object>> rfs = new ArrayList<RowFilter<TableModel,Object>>();
				RowFilter<TableModel,Object> rf=null;
				 try {
					// Try block to handle code that may cause exception
				     rfs.add(RowFilter.regexFilter(textField_9.getText(), 0));
				     rfs.add(RowFilter.regexFilter ("(?i)"+textField_9.getText(), 1));
				     rfs.add(RowFilter.regexFilter ("(?i)"+textField_9.getText(), 2));
				     rfs.add(RowFilter.regexFilter ("(?i)"+textField_9.getText(), 3));
				     rf = RowFilter.orFilter(rfs);
				    } catch (java.util.regex.PatternSyntaxException ee) {  return;  }
				    sorter.setRowFilter(rf);
			}
			});
		
		lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSearch.setBounds(19, 250, 46, 14);
		contentPane.add(lblSearch);
		
		btnNewButton = new JButton("Add Room");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Room room =getinputRoomData();
			if (room!=null)
			{
				hotel.addNewRoom(room);
				saveAndRefresh();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Please add room details first","Error", JOptionPane.WARNING_MESSAGE);
			}
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(460, 56, 192, 38);
		contentPane.add(btnNewButton);
		
		btnUpdate = new JButton("Update Room");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Room room = getinputRoomData();
				if (room!=null)
				{
				hotel.updateRoom(room);
				saveAndRefresh();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please select a room to update", "Error", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(460, 100, 192, 38);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete Room");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// check for selected row first
				if (!textField_RoomId.getText().isEmpty() ) {
					// remove selected row from the model
					hotel.deleteRoom(Integer.parseInt(textField_RoomId.getText())) ;					
					saveAndRefresh();
	                clearInput();			
			}
				
				else
				{
					JOptionPane.showMessageDialog(null, "Please select a room to delete", "Error", JOptionPane.WARNING_MESSAGE);
				}
			}});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(460, 142, 192, 38);
		contentPane.add(btnDelete);
		
		btnRefresh = new JButton("Exit");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRefresh.setBounds(581, 186, 71, 38);
		contentPane.add(btnRefresh);
		
		JButton btnNewButton_1 = new JButton("Main Menu");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main_GUI mainGUI = new Main_GUI();
				dispose();
			}
		});
		btnNewButton_1.setBounds(460, 187, 117, 38);
		contentPane.add(btnNewButton_1);
		
		JLabel labelbackground = new JLabel("");
		try {
			labelbackground.setIcon(new ImageIcon (new URL("https://avante.biz/wp-content/uploads/Golf-Ball-Wallpapers/Golf-Ball-Wallpapers-043.jpg")));
    	} catch (MalformedURLException e1) {
    		// TODO Auto-generated catch block
    		e1.printStackTrace();
    	}
		labelbackground.setBounds(-51, -183, 1171, 749);
		contentPane.add(labelbackground);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
	}
	
	private Room getinputRoomData()
	{
		if (textField_RoomId.getText().isEmpty())
			return null;
		int roomID =Integer.parseInt(textField_RoomId.getText()) ;
		String roomNo = textField_RoomNo.getText();
		byte roomCapacity = Byte.parseByte(textField_RoomCapacity.getText());
		float roomPrice = Float.parseFloat(textField_RoomPrice.getText());
		
		Room room = new Room(roomID,roomNo,roomCapacity,roomPrice);
		return room;
	}
	private void saveAndRefresh()
	{
	((RoomTableModel)table.getModel()).fireTableDataChanged();
	RoomDataStore.writeCSV_Rooms(hotel.getRooms());
	}
	private void clearInput()
	{
		textField_RoomId.setText("");
		textField_RoomNo.setText("");
		textField_RoomCapacity.setText("");
		textField_RoomPrice.setText("");
	}
}
