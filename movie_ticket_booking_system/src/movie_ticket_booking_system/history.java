package movie_ticket_booking_system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class history extends JFrame {

	private JPanel contentPane;
	private JTable table;
	String[] columnNames = {"name", "no_of_ticket", "Theatre", "Movie","Date","Fare"};
	private String username;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public history(String name1) {
		
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		username=name1;
		table = new JTable();
		table.setBounds(21, 23, 603, 417);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				new login().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(253, 481, 112, 38);
		contentPane.add(btnNewButton);
        	
	        try {
	        	 Class.forName("com.mysql.cj.jdbc.Driver");

	 			String name="";
	 	        String no_of_ticket = "";
	 	        String theatre = "";
	 	        String movie = "";
	 	        String date = "";
	 	        String fare = "";
	 	        DefaultTableModel  model=new DefaultTableModel ();
	 	        model.setColumnIdentifiers(columnNames);
	         	table.setModel(model);
	      	Connection	c=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_ticket_system","root","Pravin08@");
	      		System.out.println("connection succesful");
	        Statement s = c.createStatement();
	        
			ResultSet rs = s.executeQuery("select * from history where name1='"+username+"'");
	            
	          
	            int i = 0;
	            if (rs.next()) {
	            	name = rs.getString("name1");
	            	no_of_ticket = rs.getString("notic");
	            	theatre = rs.getString("theatre");
	            	movie = rs.getString("movie");
	            	date = rs.getString("date1");
	            	fare=rs.getString("fare");
	            	model.addRow(new Object[] {"name", "no_of_ticket", "theatre", "movie","date","fare"});
	                model.addRow(new Object[]{name, no_of_ticket, theatre, movie,date,fare});
	                i++;
	            }
	            if (i < 1) {
	                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	            if (i == 1) {
	                System.out.println(i + " Record Found");
	            } else {
	                System.out.println(i + " Records Found");
	            }
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        }
	}}
	
	
		
