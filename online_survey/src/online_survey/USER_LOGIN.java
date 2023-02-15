package online_survey;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class USER_LOGIN {

	private JFrame frame;
	private ResultSet rs;
	private String user_id;
	private String ques_id;
public  USER_LOGIN(String user) {
	user_id=user;
}
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public void USER_LOGIN() {
		initialize();
		frame.setVisible(true);
		
		}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		frame = new JFrame();
		frame.setBounds(100, 100, 686, 508);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.setBounds(354, 400, 143, 38);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(btnClose);
		
		JButton btnNewButton_1 = new JButton("LOGOUT");
		btnNewButton_1.setBounds(507, 15, 131, 49);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("USER LOGIN");
		lblNewLabel.setBounds(260, 11, 153, 49);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setBounds(141, 400, 131, 38);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(btnNewButton);
		
		
		
		try {
			
	        try {
	        	SQLmanage manage = new SQLmanage();
				String question_id;
				String question = "";
		        String option1 = "";
		        String option2 = "";
		        String option3 = "";
		        String option4 = "";
	        	
	           rs = manage.getQuestions();
	            int i = 0;
	            if (rs.next()) {
	            	
	            	question_id = rs.getString("question_id");
	            	question = rs.getString("question");
	            	option1 = rs.getString("option1");
	            	option2 = rs.getString("option2");
	            	option3 = rs.getString("option3");
	            	option4 = rs.getString("option4");
	        		JLabel lblNewLabel_2 = new JLabel(question_id);
	        		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	        		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 26));
	        		lblNewLabel_2.setBounds(10, 101, 76, 74);
	        		frame.getContentPane().add(lblNewLabel_2);
	        		
	        		JLabel lblNewLabel_1 = new JLabel(question);
	        		lblNewLabel_1.setBounds(65, 71, 536, 121);
	        		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	        		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        		frame.getContentPane().add(lblNewLabel_1);
	        		
	        		JRadioButton rdbtnNewRadioButton = new JRadioButton(option1);
	        		rdbtnNewRadioButton.setBounds(92, 245, 173, 31);
	        		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        		frame.getContentPane().add(rdbtnNewRadioButton);
	        		
	        		JRadioButton rdbtnOption = new JRadioButton(option2);
	        		rdbtnOption.setBounds(374, 233, 173, 31);
	        		rdbtnOption.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        		frame.getContentPane().add(rdbtnOption);
	        		
	        		JRadioButton rdbtnOption_1 = new JRadioButton(option3);
	        		rdbtnOption_1.setBounds(92, 321, 173, 31);
	        		rdbtnOption_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        		frame.getContentPane().add(rdbtnOption_1);
	        		
	        		JRadioButton rdbtnOption_2 = new JRadioButton(option4);
	        		rdbtnOption_2.setBounds(374, 321, 173, 31);
	        		rdbtnOption_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        		frame.getContentPane().add(rdbtnOption_2);
	        		
	        		
	    			btnNewButton.addActionListener(new ActionListener() {
	    				
	    				public void actionPerformed(ActionEvent e) {
	    					
	    					try {
	    					if(rdbtnNewRadioButton.isSelected()) {
								manage.userquestion(user_id,question_id,"1","0","0","0" );
								JOptionPane.showMessageDialog(null, "done", "Error", JOptionPane.ERROR_MESSAGE);
	    					}
	    	        		
	    	        		else if(rdbtnOption.isSelected()) {
	    	        		
									manage.userquestion(user_id,question_id,"0","1","0","0" );
									JOptionPane.showMessageDialog(null, "done", "Error", JOptionPane.ERROR_MESSAGE);
								
	    	        		}
	    	        		else if(rdbtnOption_1.isSelected()) {
	    	        			
									manage.userquestion(user_id,question_id,"0","0","1","0" );
									JOptionPane.showMessageDialog(null, "done", "Error", JOptionPane.ERROR_MESSAGE);
								
	    	        		}
	    	        		else if(rdbtnOption_2.isSelected()) {
	    	        			
									manage.userquestion(user_id,question_id,"0","0","0","1" );
									JOptionPane.showMessageDialog(null, "done", "done", JOptionPane.ERROR_MESSAGE);
								
								
	    	        		}
	    	        		else {
	    	        			 JOptionPane.showMessageDialog(null, "No option selected", "Error", JOptionPane.ERROR_MESSAGE);
	    	        		}
	    				}
	    					catch(Exception ex) {
	    						ex.printStackTrace();
	    					}
//	    					
//	        		
	        		
	               
	    				}	});
	    			 i++;}
	    			
	    			try {
	            if (i < 1) {
	                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	            if (i == 1) {
	                System.out.println(i + " Record Found");
	            } else {
	                System.out.println(i + " Records Found");
	            }}
	            catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        
	          
	            }}
	        catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        
          
            }}
		 catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        
       
         }}

	
}
			
			
			
	     

	       

	            
		
		
	      	
