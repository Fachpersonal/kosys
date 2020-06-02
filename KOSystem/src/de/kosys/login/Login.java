package de.kosys.login;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import de.kosys.mainFrame.Window;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;

public class Login extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPasswordField passwordField;
	private JTextField usernameField;
	
	private String username;
	private String password;

	public Login() {
		getContentPane().setBackground(Color.GRAY);
		getContentPane().setLayout(null);
		
		JPanel top = new JPanel();
		top.setLocation(0, 0);
		top.setSize(800,26);
		getContentPane().add(top);
		top.setLayout(null);
		
		JLabel title = new JLabel("Login");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(349, 5, 102, 14);
		top.add(title);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(260, 286, 306, 44);
		getContentPane().add(passwordField);
		
		usernameField = new JTextField();
		usernameField.setBounds(260, 231, 306, 44);
		getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JLabel usernameLabel = new JLabel("Username :");
		usernameLabel.setFont(new Font("Ink Free", Font.BOLD, 14));
		usernameLabel.setBounds(148, 231, 102, 44);
		getContentPane().add(usernameLabel);
		
		JLabel passwordLable = new JLabel("Password : ");
		passwordLable.setFont(new Font("Ink Free", Font.BOLD, 14));
		passwordLable.setBounds(148, 286, 102, 44);
		getContentPane().add(passwordLable);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,600);
		setUndecorated(true);
		setBackground(Color.DARK_GRAY);
		
		JButton closebtn = new JButton("X");
		closebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		closebtn.setBorder(null);
		closebtn.setBackground(new Color(0,0,0,0));
		closebtn.setBounds(726, 0, 74, 26);
		top.add(closebtn);
		
		JButton loginbtn = new JButton("Login");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username = usernameField.getText();
				password = new String(passwordField.getPassword());
				if(login(username, password)) {
					dispose();
					new Window();
				}
				
//				JOptionPane.showMessageDialog(null, username);		// Shows given username
//				JOptionPane.showMessageDialog(null, password);		// Shows given password
			}
		});
		loginbtn.setBounds(477, 341, 89, 23);
		getContentPane().add(loginbtn);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private boolean login(String username, String password) {
		//TODO connect to database and check if everything is all right!
		try	{
			String url = "jdbc:mysql://localhost:3306/kosys";
			// Connect to database
			Connection myConn = DriverManager.getConnection(url, "root", "");
			// Create statement
			Statement myStmt = myConn.createStatement();
			// Execute SQL query
			ResultSet myRs = myStmt.executeQuery("SELECT * FROM `register` ORDER BY `id` ASC");
			// Process result set
//			while(myRs.next()) {
//				System.out.println(myRs.getInt("id") + ", " + myRs.getString("username") + ", " + myRs.getString("password") + ", " + myRs.getString("email") + ", " + myRs.getInt("power"));
//			}
			while(myRs.next()) {				
				if(username.equals(myRs.getString("username"))) {
					if(password.equals(myRs.getString("password"))) {
//						System.out.println("YUHU U LOGGED IN");
						return true;
					}
					else {
						JOptionPane.showMessageDialog(null, "Wrong Password");
						System.exit(0);
					}
				}
//				else {
//					System.out.println("Next");
// 				}
			}
			JOptionPane.showMessageDialog(null, "Account does not exist!");
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Cannot connect to Database!");
			System.exit(0);
		}
		return false;
	}
}
