package GUI;
//Testing GitHub
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Main_GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_GUI frame = new Main_GUI();
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
	public Main_GUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 252, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnManageRooms = new JButton("Manage Rooms");
		btnManageRooms.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnManageRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rooms_GUI roomsGUI = new Rooms_GUI();
				dispose();
			}
		});
		btnManageRooms.setBounds(38, 21, 164, 58);
		contentPane.add(btnManageRooms);
		
		JButton buttonManageGuests = new JButton("Manage Guests");
		buttonManageGuests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Guests_GUI guestGUI = new Guests_GUI();
				dispose();
			}
		});
		buttonManageGuests.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonManageGuests.setBounds(38, 90, 164, 58);
		contentPane.add(buttonManageGuests);
		
		JButton buttonManageBookings = new JButton("Manage Bookings");
		buttonManageBookings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Booking_GUI bookingGUI = new Booking_GUI();
				dispose();
			}
		});
		buttonManageBookings.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonManageBookings.setBounds(38, 159, 164, 58);
		contentPane.add(buttonManageBookings);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setSelectedIcon(null);
		btnExit.setIconTextGap(0);
		btnExit.setIcon(null);
		btnExit.setBounds(38, 228, 164, 27);
		contentPane.add(btnExit);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}
}
