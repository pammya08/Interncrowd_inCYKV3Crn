package online_survey;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class contact_us {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public void contact_us() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 503);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu Say Hello! NYC \r\n+919822029391 \r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 67, 410, 157);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CONTACT US");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(203, 11, 286, 58);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblPammyadevakategmailcomKatrajpune = new JLabel("pammyadevakate08@gmail.com\r\n katraj,pune-46");
		lblPammyadevakategmailcomKatrajpune.setHorizontalAlignment(SwingConstants.CENTER);
		lblPammyadevakategmailcomKatrajpune.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblPammyadevakategmailcomKatrajpune.setBounds(107, 160, 601, 207);
		frame.getContentPane().add(lblPammyadevakategmailcomKatrajpune);
		
		JButton btnNewButton = new JButton("close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(506, 359, 174, 51);
		frame.getContentPane().add(btnNewButton);
	}
}
