package online_survey;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;

import javax.swing.SwingConstants;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ADMIN{

	private JFrame admin;
	private JTextField name;
	
	Connection con;
	PreparedStatement pat;
	Window main;
	private JTextField pass;
	
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_survey_system","root","Pravin08@");
			System.out.println("connection succesful");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Launch the application.
	 */
public void launch() {
		try {
			admin.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public void ADMIN1() {
		initialize();
		launch();
		connect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		admin = new JFrame();
		admin.setBounds(100, 100, 768, 453);
		admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		admin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(172, 0, 367, 129);
		admin.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(77, 140, 203, 76);
		admin.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(77, 227, 203, 76);
		admin.getContentPane().add(lblPassword);
		
		name = new JTextField();
		name.setBounds(321, 157, 218, 39);
		admin.getContentPane().add(name);
		name.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			private ResultSet rs;
			private Component frame;
			private int id;

			public void actionPerformed(ActionEvent e) {
				String username = name.getText();
				String password = pass.getText();
				
				if(username.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Please Enter All Details!!!", "Warning Message", JOptionPane.WARNING_MESSAGE);
				}
				else {
					
					try {
						SQLmanage manage= new SQLmanage();
						id = manage.authUser(username, password);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					if (id == -1) {
						JOptionPane.showMessageDialog(frame, "No User Found!!!", "Warning Message", JOptionPane.WARNING_MESSAGE);
					}
					else if(id == 0) {
						JOptionPane.showMessageDialog(frame, "Wrong Password!!!", "Warning Message", JOptionPane.WARNING_MESSAGE);
					}
					else if(id == 1) {
						JOptionPane.showMessageDialog(frame, "correct Password!!!", "Warning Message", JOptionPane.WARNING_MESSAGE);
						ADMIN_LOGIN ad=new ADMIN_LOGIN();
						ad.ADMIN_LOGIN();
						
					}

					
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(144, 330, 161, 62);
		admin.getContentPane().add(btnNewButton);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin.dispose();
				
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancel.setBounds(354, 330, 161, 62);
		admin.getContentPane().add(btnCancel);
		
		pass = new JTextField();
		pass.setColumns(10);
		pass.setBounds(321, 244, 218, 39);
		admin.getContentPane().add(pass);
	}
}
