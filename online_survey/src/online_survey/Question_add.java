package online_survey;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Question_add  {

	private JFrame ques;
	ResultSet rs;
	Connection con1;
	PreparedStatement pat;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	public void launch2() {
		try {
			ques.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();}
		}
	/**
	 * Launch the application.

	/**
	 * Create the application.
	 */
	public void Question_add() {
		initialize2();
		launch2();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize2() {
		ques = new JFrame();
		ques.setBounds(100, 100, 528, 444);
		ques.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ques.getContentPane().setLayout(null);
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 496, 372);
		ques.getContentPane().add(contentPane);
		
		JLabel lblNewLabel = new JLabel("ADD QUESTION");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(182, 25, 168, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("QUESTION");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(36, 78, 103, 38);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(163, 89, 187, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(163, 138, 187, 20);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("OPTION1");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(36, 127, 103, 38);
		contentPane.add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(163, 192, 187, 20);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("OPTION2");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(36, 181, 103, 38);
		contentPane.add(lblNewLabel_1_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(160, 249, 187, 20);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("OPTION3");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(36, 238, 103, 38);
		contentPane.add(lblNewLabel_1_3);
		
		JButton btnNewButton = new JButton("DONE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String question,option1,option2,option3,option4;
				question=textField.getText();
				option1=textField_1.getText();
				option2=textField_2.getText();
				option3=textField_3.getText();
				option4=textField_4.getText();
				Statement stat;
				try {
					SQLmanage s=new SQLmanage();
					s.newQuestion(question, option1, option2, option3, option4);
					JOptionPane.showMessageDialog(ques, "added succesfully", "Warning Message", JOptionPane.WARNING_MESSAGE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(373, 89, 89, 98);
		contentPane.add(btnNewButton);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(163, 302, 187, 20);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_1_4 = new JLabel("OPTION4");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(36, 291, 103, 38);
		contentPane.add(lblNewLabel_1_4);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ques.dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnClose.setBounds(373, 224, 89, 98);
		contentPane.add(btnClose);
	}
}
