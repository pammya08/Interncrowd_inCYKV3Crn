package online_survey;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class SIGNUP {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public void SIGNUP() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 905, 498);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUser = new JLabel("USER");
		lblUser.setBounds(272, 0, 293, 98);
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 30));
		frame.getContentPane().add(lblUser);
		
		JLabel lblNewLabel = new JLabel("NAME");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(228, 109, 97, 40);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(383, 109, 204, 34);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEmailid = new JLabel("EMAILID");
		lblEmailid.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmailid.setBounds(228, 164, 97, 40);
		frame.getContentPane().add(lblEmailid);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(383, 164, 204, 34);
		frame.getContentPane().add(textField_1);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(213, 231, 112, 40);
		frame.getContentPane().add(lblUsername);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(383, 231, 204, 34);
		frame.getContentPane().add(textField_2);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(209, 298, 131, 40);
		frame.getContentPane().add(lblPassword);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(383, 298, 204, 34);
		frame.getContentPane().add(textField_3);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name="";
				String email_id="";
				String username="";
				String password="";
				
				
				
				SQLmanage sq;
				try {
					name=textField.getText();
					email_id=textField_1.getText();
					username=textField_2.getText();
					password=textField_3.getText();
					sq = new SQLmanage();
					sq.user( name, email_id, username, password);
					JOptionPane.showMessageDialog(frame, "singup succesfully", "Warning Message", JOptionPane.WARNING_MESSAGE);
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(213, 376, 161, 62);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancel.setBounds(423, 376, 161, 62);
		frame.getContentPane().add(btnCancel);
	}

}
