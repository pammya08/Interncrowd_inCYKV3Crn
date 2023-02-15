package online_survey;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class ADMIN_LOGIN {

	private JFrame al;
	private ResultSet rs;
	private JTable table_1;
	String[] columnNames = {"question_id", "question", "option1", "option2","option3","option4"};
	String[] columnNames1 = {"question_id_ref", "option1", "option2","option3","option4"};	
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public void launch1() {
		try {
			al.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	public void  ADMIN_LOGIN() {
		initialize1();
		launch1();
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize1() {
		al = new JFrame();
		al.setBounds(100, 100, 910, 563);
		al.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		al.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN_LOGIN");
		lblNewLabel.setBounds(295, 3, 258, 57);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		al.getContentPane().add(lblNewLabel);
		
		
		JButton btnNewButton = new JButton("ADD QUESITION");
		btnNewButton.setBounds(59, 128, 321, 45);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Question_add q=new Question_add();
				q.Question_add();
						}

			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al.getContentPane().add(btnNewButton);
		
		JButton btnDeleteQuesition = new JButton("DELETE QUESITION");
		btnDeleteQuesition.setBounds(59, 197, 321, 45);
		btnDeleteQuesition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deletequestion DE=new Deletequestion();
				DE.Deletequestion();
			}
		});
		btnDeleteQuesition.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al.getContentPane().add(btnDeleteQuesition);
		
		JButton btnViewQuesition = new JButton("VIEW QUESITION ");
		btnViewQuesition.setBounds(59, 273, 321, 45);
		btnViewQuesition.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				SQLmanage manage;
				try {
					manage = new SQLmanage();
					String question_id;
					String question = "";
			        String option1 = "";
			        String option2 = "";
			        String option3 = "";
			        String option4 = "";
			        DefaultTableModel  model=new DefaultTableModel ();
			        model.setColumnIdentifiers(columnNames);
	            	table_1.setModel(model);
	            	
			        try {
			            
			           rs = manage.getQuestions();
			            int i = 0;
			            if (rs.next()) {
			            	question_id = rs.getString("question_id");
			            	question = rs.getString("question");
			            	option1 = rs.getString("option1");
			            	option2 = rs.getString("option2");
			            	option3 = rs.getString("option3");
			            	option4 = rs.getString("option4");
			            	model.addRow(new Object[] {"question_id","question","option1","option2","option3","option4"});
			                model.addRow(new Object[]{question_id,question, option1, option2, option3,option4});
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

					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(872, 502, -450, -401);
			        al.getContentPane().add(scrollPane);
			        al.setVisible(true);
			       
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		       
		
				
			
		}});
		btnViewQuesition.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al.getContentPane().add(btnViewQuesition);
		
		JButton btnViewPolls = new JButton("VIEW POLLS");
		btnViewPolls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SQLmanage manage;
				try {
					manage = new SQLmanage();
					String question_id_ref="";
			        String option1 = "";
			        String option2 = "";
			        String option3 = "";
			        String option4 = "";
			        DefaultTableModel  model=new DefaultTableModel ();
			        model.setColumnIdentifiers(columnNames);
	            	table_1.setModel(model);
	            	
			        try {
			            
			           rs = manage.getpolls();
			            int i = 0;
			            if (rs.next()) {
			            	question_id_ref = rs.getString("question_id_ref");
			            	option1 = rs.getString("sum(option1)");
			            	option2 = rs.getString("sum(option2)");
			            	option3 = rs.getString("sum(option3)");
			            	option4 = rs.getString("sum(option4)");
			            	model.addRow(new Object[] {"question_id_ref","option1","option2","option3","option4"});
			                model.addRow(new Object[]{question_id_ref, option1, option2, option3,option4});
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

					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(872, 502, -450, -401);
			        al.getContentPane().add(scrollPane);
			        al.setVisible(true);
			       
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				
				
			}
		});
		btnViewPolls.setBounds(59, 350, 321, 45);
		btnViewPolls.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al.getContentPane().add(btnViewPolls);
		
		JButton btnNewButton_3_1 = new JButton("LOGOUT");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				al.dispose();
			}
		});
		btnNewButton_3_1.setBounds(59, 429, 321, 45);
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		al.getContentPane().add(btnNewButton_3_1);
		
		table_1 = new JTable();
		table_1.setFillsViewportHeight(true);
		table_1.setColumnSelectionAllowed(true);
		table_1.setCellSelectionEnabled(true);
		table_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table_1.setBounds(426, 104, 441, 387);
		al.getContentPane().add(table_1);
		
	}
}
