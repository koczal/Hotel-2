package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

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

import classes.Booking;
import classes.Guest;
import classes.Hotel;
import classes.Room;
import DataStoreOperations.BookingDataStore;
import DataStoreOperations.GuestDataStore;
import DataStoreOperations.RoomDataStore;
import tableModels.BookingTableModel;
import org.jdatepicker.JDatePicker;


import org.jdatepicker.JDatePanel;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.UtilDateModel;

public class Booking_GUI extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private JLabel lblBookingId;
	private JLabel lblGuestId;
	private JLabel lblCheckInDate;
	
	private JTextField textField_BookingId;
	private JTextField textField_GuestId;
	private JTextField textField_CheckInDate;
	private JTextField textField_CheckOutDate;
	private JButton btnNewButton;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnRefresh;
	Hotel hotel;
	private JLabel lbl_CheckOutDate;
	private JTextField textField_RoomId;
	private JLabel lblRoomId;
	private JLabel lblCheckIn;
	private JLabel lblCheckOut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Booking_GUI frame = new Booking_GUI();
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
	public Booking_GUI() {
		hotel = new Hotel();
		setTitle("Bookings");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 688);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		hotel.setBookings(BookingDataStore.readCSV_Bookings());
		BookingTableModel bookingtablemodel = new BookingTableModel(hotel.getBookings());
		
		table = new JTable(bookingtablemodel);
		table.setBounds(380, 281, -14, -69);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
			    if (e.getValueIsAdjusting()|| table.getSelectedRow()==-1) //this event is not the last in the chain - This is a mouseDown event.
	                   return;
	  
	    textField_BookingId.setText(table.getValueAt(table.getSelectedRow(),0). toString());
	    textField_GuestId.setText(table.getValueAt(table.getSelectedRow(),1). toString());
	    textField_RoomId.setText(table.getValueAt(table.getSelectedRow(),2). toString());
	    //String x=  new  SimpleDateFormat("dd/MM/yyyy").format("10/10/2018");
	    textField_CheckInDate.setText(new  SimpleDateFormat("dd/MM/yyyy").format(table.getValueAt(table.getSelectedRow(),3)));
	    textField_CheckOutDate.setText(new  SimpleDateFormat("dd/MM/yyyy").format(table.getValueAt(table.getSelectedRow(),4)));
	       }

			
		});

		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(10, 381, 692, 268);
		contentPane.add(scrollPane_5);
		
		
		scrollPane_5.setViewportView(table);
		
		JLabel lblBooking = new JLabel("Manage Booking");
		lblBooking.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblBooking.setBounds(34, 11, 223, 33);
		contentPane.add(lblBooking);
		
		lblBookingId = new JLabel("Booking ID");
		lblBookingId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBookingId.setBounds(34, 65, 65, 24);
		contentPane.add(lblBookingId);
		
		lblGuestId = new JLabel("Guest ID");
		lblGuestId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGuestId.setBounds(34, 108, 91, 14);
		contentPane.add(lblGuestId);
		
		lblCheckInDate = new JLabel("Check In Date");
		lblCheckInDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCheckInDate.setBounds(34, 182, 91, 14);
		contentPane.add(lblCheckInDate);
		
	
		
		textField_BookingId = new JTextField();
		textField_BookingId.setColumns(10);
		textField_BookingId.setBounds(152, 61, 273, 22);
		contentPane.add(textField_BookingId);
		// validation check only integers
		textField_BookingId.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				// allows only numbers and back space
				 char c = e.getKeyChar();
			      if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
			         e.consume();  // ignore event
			      }
			}
		});
		
		textField_GuestId = new JTextField();
		textField_GuestId.setColumns(10);
		textField_GuestId.setBounds(152, 100, 273, 22);
		contentPane.add(textField_GuestId);
		
		textField_CheckInDate = new JTextField();
		textField_CheckInDate.setColumns(10);
		textField_CheckInDate.setBounds(152, 178, 273, 22);
		contentPane.add(textField_CheckInDate);
		
		textField_CheckOutDate = new JTextField();
		textField_CheckOutDate.setColumns(10);
		textField_CheckOutDate.setBounds(152, 211, 273, 22);
		contentPane.add(textField_CheckOutDate);
		textField_CheckOutDate.addKeyListener(new KeyAdapter() {
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
		TableRowSorter<TableModel>sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		
		btnNewButton = new JButton("Add Booking");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Booking booking =getinputBookingData();
			if (booking!=null)
			{
				hotel.addNewBooking(booking);
				saveAndRefresh();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Please add booking details first","Error", JOptionPane.WARNING_MESSAGE);
			}
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(478, 56, 205, 38);
		contentPane.add(btnNewButton);
		
		btnUpdate = new JButton("Update Booking");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Booking booking = getinputBookingData();
				if (booking !=null)
				{
				hotel.updateBooking(booking);
				saveAndRefresh();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please select a booking to update", "Error", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(478, 103, 205, 38);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete Booking");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// check for selected row first
				if (!textField_BookingId.getText().isEmpty() ) {
					// remove selected row from the model
					hotel.deleteBooking(Integer.parseInt(textField_BookingId.getText())) ;
					saveAndRefresh();
	                clearInput();			
			}
				else
				{
					JOptionPane.showMessageDialog(null, "Please select a booking to delete", "Error", JOptionPane.WARNING_MESSAGE);
				}
			}});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(480, 152, 203, 38);
		contentPane.add(btnDelete);
		
		btnRefresh = new JButton("Exit");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRefresh.setBounds(611, 201, 72, 38);
		contentPane.add(btnRefresh);
		
		JButton btnNewButton_1 = new JButton("Main Menu");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main_GUI mainGUI = new Main_GUI();
				dispose();
			}
		});
		btnNewButton_1.setBounds(480, 202, 121, 38);
		contentPane.add(btnNewButton_1);
		/*try {
    	} catch (MalformedURLException e1) {
    		// TODO Auto-generated catch block
    		e1.printStackTrace();
    	}*/
		
		lbl_CheckOutDate = new JLabel("Check Out Date");
		lbl_CheckOutDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_CheckOutDate.setBounds(34, 215, 91, 14);
		contentPane.add(lbl_CheckOutDate);
		
		textField_RoomId = new JTextField();
		textField_RoomId.setColumns(10);
		textField_RoomId.setBounds(152, 135, 273, 22);
		contentPane.add(textField_RoomId);
		
		lblRoomId = new JLabel("Room Id");
		lblRoomId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRoomId.setBounds(34, 139, 91, 14);
		contentPane.add(lblRoomId);
		
		JDatePicker startDatePicker = new JDatePicker();
		startDatePicker.setBounds(152, 258, 202, 21);
		contentPane.add(startDatePicker);
		
		JDatePicker endDatePicker = new JDatePicker();
		endDatePicker.setBounds(152, 302, 202, 21);
		contentPane.add(endDatePicker);
		
		lblCheckIn = new JLabel("Check In");
		lblCheckIn.setBounds(34, 265, 46, 14);
		contentPane.add(lblCheckIn);
		
		lblCheckOut = new JLabel("Check Out");
		lblCheckOut.setBounds(34, 302, 91, 14);
		contentPane.add(lblCheckOut);
		
		
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
	}
	
	public Booking getinputBookingData()
	{
		if (textField_BookingId.getText().isEmpty())
			return null;
		int bookingID =Integer.parseInt(textField_BookingId.getText()) ;
		int guestId = Integer.parseInt(textField_GuestId.getText());
		int roomId = Integer.parseInt(textField_RoomId.getText());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
		String localDateStart;
		String localDateEnd;
		//////////
		JDatePicker startDatePicker = new JDatePicker();
		JDatePicker endDatePicker = new JDatePicker();
		//////////
		localDateStart = startDatePicker.getFormattedTextField().getText()
				;
		localDateEnd = endDatePicker.getFormattedTextField().getText()
				;
		
		
		
		Date checkInDate=null,checkOutDate=null;
		try {
			checkInDate = new SimpleDateFormat("dd/MM/yyyy").parse(textField_CheckInDate.getText());
			checkOutDate =new SimpleDateFormat("dd/MM/yyyy").parse(textField_CheckOutDate.getText());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Booking booking = new Booking(bookingID,guestId,roomId,checkInDate,checkOutDate);
		return booking;
	}
	private void saveAndRefresh()
	{
	((BookingTableModel)table.getModel()).fireTableDataChanged();
	BookingDataStore.writeCSV_Bookings(hotel.getBookings());
	}
	private void clearInput()
	{
		textField_BookingId.setText("");
		textField_GuestId.setText("");
		textField_RoomId.setText("");
		textField_CheckInDate.setText("");
		textField_CheckOutDate.setText("");
	}
}
