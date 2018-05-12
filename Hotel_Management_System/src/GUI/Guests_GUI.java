package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

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

import classes.Guest;
import classes.Hotel;
import DataStoreOperations.GuestDataStore;

public class Guests_GUI extends JFrame{

		private JPanel contentPane;
		private JLabel lblguestid;
		private JLabel lblguestFirstName;
		private JLabel lblguestLastName;
		private JLabel lblguestPhoneNo;
		private JTextField textField_GuestId;
		private JTextField textField_GuestFirstName;
		private JTextField textField_GuestLastName;
		private JTextField textField_GuestPhoneNumber;
		private JTextField textField_GuestNationality;
		private JButton btnNewGuest;
		Hotel hotel;
		private JButton btnExit;
		
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Guests_GUI frame = new Guests_GUI();
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
		public Guests_GUI() {
			hotel = new Hotel();
			setTitle("Guests");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 476, 318);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			hotel.setGuests(GuestDataStore.readCSV_Guests());		
					
			JLabel lblAddNewMember = new JLabel("Add new Guest");
			lblAddNewMember.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblAddNewMember.setBounds(34, 11, 223, 33);
			contentPane.add(lblAddNewMember);
			
			lblguestid = new JLabel("GuestID");
			lblguestid.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblguestid.setBounds(34, 60, 65, 24);
			contentPane.add(lblguestid);
			
			lblguestFirstName = new JLabel("First Name");
			lblguestFirstName.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblguestFirstName.setBounds(34, 104, 91, 14);
			contentPane.add(lblguestFirstName);
			
			lblguestLastName = new JLabel("Last Name");
			lblguestLastName.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblguestLastName.setBounds(34, 138, 65, 14);
			contentPane.add(lblguestLastName);
			
			lblguestPhoneNo = new JLabel("Phone Number");
			lblguestPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblguestPhoneNo.setBounds(34, 176, 91, 14);
			contentPane.add(lblguestPhoneNo);
			
			
			
			
			
			
			textField_GuestId = new JTextField();
			textField_GuestId.setColumns(10);
			textField_GuestId.setBounds(152, 61, 273, 22);
			contentPane.add(textField_GuestId);
			// validation check only integers
			textField_GuestId.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					// allows only numbers and back space
					 char c = e.getKeyChar();
				      if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
				         e.consume();  // ignore event
				      }
				}
			});
			
			textField_GuestFirstName = new JTextField();
			textField_GuestFirstName.setColumns(10);
			textField_GuestFirstName.setBounds(152, 100, 273, 22);
			contentPane.add(textField_GuestFirstName);
			
			textField_GuestLastName = new JTextField();
			textField_GuestLastName.setColumns(10);
			textField_GuestLastName.setBounds(152, 134, 273, 22);
			contentPane.add(textField_GuestLastName);
			
			textField_GuestPhoneNumber = new JTextField();
			textField_GuestPhoneNumber.setColumns(10);
			textField_GuestPhoneNumber.setBounds(152, 172, 273, 22);
			contentPane.add(textField_GuestPhoneNumber);
			textField_GuestPhoneNumber.addKeyListener(new KeyAdapter() {
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
			
			
			
			/*textField_GuestNationality = new JTextField();
			textField_GuestNationality.setColumns(10);
			textField_GuestNationality.setBounds(152, 134, 273, 22);
			contentPane.add(textField_GuestNationality);
			
			*/
			
			
			btnNewGuest = new JButton("Add Guest");
			btnNewGuest.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				Guest guest = getinputGuestData();
				if (guest!=null)
				{
					hotel.addNewGuest(guest);
				    saveAndRefresh();
				    JOptionPane.showMessageDialog(null, "Guest Added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
				    clearInput();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please add guest details first", "Error", JOptionPane.WARNING_MESSAGE);
				}
				}
			});
			btnNewGuest.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnNewGuest.setBounds(34, 240, 163, 38);
			contentPane.add(btnNewGuest);
			
			JButton btnNewButton_1 = new JButton("Main Menu");
			btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Main_GUI mainGUI = new Main_GUI();
					dispose();
				}
			});
			btnNewButton_1.setBounds(207, 241, 123, 38);
			contentPane.add(btnNewButton_1);
			
			JLabel labelbackground = new JLabel("");
			labelbackground.setFont(new Font("Tahoma", Font.BOLD, 14));
			try {
				labelbackground.setIcon(new ImageIcon (new URL("https://avante.biz/wp-content/uploads/Golf-Ball-Wallpapers/Golf-Ball-Wallpapers-043.jpg")));
	    	} catch (MalformedURLException e1) {
	    		// TODO Auto-generated catch block
	    		e1.printStackTrace();
	    	}
			labelbackground.setBounds(495, -227, 686, 749);
			contentPane.add(labelbackground);
			
			btnExit = new JButton("Exit");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnExit.setBounds(340, 240, 85, 38);
			contentPane.add(btnExit);
			
			JLabel lblguestNationality = new JLabel("Nationality");
			lblguestNationality.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblguestNationality.setBounds(34, 215, 91, 14);
			contentPane.add(lblguestNationality);
			
			textField_GuestNationality = new JTextField();
			textField_GuestNationality.setColumns(10);
			textField_GuestNationality.setBounds(152, 207, 273, 22);
			contentPane.add(textField_GuestNationality);
			setVisible(true);
			setLocationRelativeTo(null);
			setResizable(false);
			
			
		}
		
		private Guest getinputGuestData()
		{
			if (textField_GuestId.getText().isEmpty())
				return null;
			int guestID =Integer.parseInt(textField_GuestId.getText()) ;
			String guestNo = textField_GuestFirstName.getText();
			String guestCapacity = textField_GuestLastName.getText();
			String guestPrice = textField_GuestPhoneNumber.getText();
			String guestNat = textField_GuestNationality.getText();
			
			Guest guest = new Guest(guestID,guestNo,guestCapacity,guestPrice,guestNat);
			return guest;
		}
		private void saveAndRefresh()
		{
		
		GuestDataStore.writeCSV_Guests(hotel.getGuests());
		}
		private void clearInput()
		{
			textField_GuestId.setText("");
			textField_GuestFirstName.setText("");
			textField_GuestLastName.setText("");
			textField_GuestPhoneNumber.setText("");
			textField_GuestNationality.setText("");
		}
	}
