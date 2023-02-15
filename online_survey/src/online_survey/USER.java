package online_survey;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class USER {

	private JFrame frame;
	private JTextField user;
	private JTextField pass;
	private ResultSet rs1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public void USER() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 847, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUser = new JLabel("USER");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblUser.setBounds(223, 11, 367, 129);
		frame.getContentPane().add(lblUser);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(180, 130, 203, 76);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(180, 217, 203, 76);
		frame.getContentPane().add(lblPassword);
		
		user = new JTextField();
		user.setColumns(10);
		user.setBounds(424, 147, 218, 39);
		frame.getContentPane().add(user);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			private int id;
			private SQLmanage manage;
			

			public void actionPerformed(ActionEvent e) {
				
				String username = user.getText();
				String password = pass.getText();
				
				try {
					 manage = new SQLmanage();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				if(username.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Please Enter All Details!!!", "Warning Message", JOptionPane.WARNING_MESSAGE);
				}
				else {
					
					try {
						
						
						id = manage.authUserpublic(username, password);
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
						
							
							try {
								String id1="";
								rs1=manage.getid(username);
								while (rs1.next())
								{
									id1=rs1.getString("user_id");
									break;
								}
								USER_LOGIN ul=new USER_LOGIN(id1);
								ul.USER_LOGIN();
								
								System.out.println(id1);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						
						
						
						
						
					}

					
				}
				
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(223, 319, 161, 62);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SIGNUP");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SIGNUP su=new SIGNUP();
				su.SIGNUP();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(499, 319, 143, 62);
		frame.getContentPane().add(btnNewButton_1);
		
		pass = new JTextField();
		pass.setBounds(423, 237, 219, 32);
		frame.getContentPane().add(pass);
		pass.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("close");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(619, 35, 120, 49);
		frame.getContentPane().add(btnNewButton_2);
	}
}
