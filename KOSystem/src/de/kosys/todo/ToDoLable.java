package de.kosys.todo;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ToDoLable extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String Title;
	private String Status;
	/**
	 * Create the panel.
	 */
	public ToDoLable() {
		setBackground(Color.PINK);
		setSize(200, 65);
		setLayout(null);
		
		JLabel title = new JLabel(Title);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(0, 0, 200, 30);
		add(title);
		
		JPanel StatusPanel = new JPanel();
		StatusPanel.setBackground(Color.GREEN);
		StatusPanel.setBounds(0, 30, 200, 30);
		add(StatusPanel);
		
		JLabel status = new JLabel(Status);
		StatusPanel.add(status);
		switch(status.getText()) {
		case "ToDo":
			status.setBackground(Color.RED);
			break;
		case "In Work":
			status.setBackground(Color.YELLOW);
			break;
		case "Done":
			status.setBackground(Color.GREEN);
			break;
		default:
			status.setBackground(Color.MAGENTA);
			break;
		}
		status.setForeground(Color.BLACK);
		status.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	public void getToDoList(int id) {
		try {
			String url = "jdbc:mysql://localhost:3306/kosys";
			// Connect to database
			Connection myConn = DriverManager.getConnection(url, "root", "");
			// Create statement
			Statement myStmt = myConn.createStatement();
			// Execute SQL query
			ResultSet myRs = myStmt.executeQuery("SELECT * FROM `todo`");
			// Process result set
			for(int i = 0; i < id; i++) {
				myRs.next();
			}
			id = myRs.getInt("id");
			Title = myRs.getString("title");
			switch(myRs.getInt("status")) {
			case 1:
				Status = "ToDo";
				break;
			case 2:
				Status = "In Work";
				break;
			case 3:
				Status = "Done";
				break;
			default:
				Status = "ERROR";
				break;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}
	
}
