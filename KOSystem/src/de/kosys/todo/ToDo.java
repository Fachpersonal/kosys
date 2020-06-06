package de.kosys.todo;

import javax.swing.JPanel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ToDo{
	
	private int maxId = 0;
	
	private int[] id;
	
	private String[] Title;
	private String[] Status;
		
	public void getToDoList() {
		try {
			String url = "jdbc:mysql://localhost:3306/kosys";
			// Connect to database
			Connection myConn = DriverManager.getConnection(url, "root", "");
			// Create statement
			Statement myStmt = myConn.createStatement();
			// Execute SQL query
			ResultSet myRs = myStmt.executeQuery("SELECT * FROM `todo`");
			// Process result set
			while(myRs.next()) {
				id[maxId] = myRs.getInt("id");
				Title[maxId] = myRs.getString("title");
				switch(myRs.getInt("status")) {
				case 1:
					Status[maxId] = "ToDo";
					break;
				case 2:
					Status[maxId] = "In Work";
					break;
				case 3:
					Status[maxId] = "Done";
					break;
				default:
					Status[maxId] = "ERROR";
					break;
				}
				maxId++;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public int getId(int index) {
		return id[index];
	}
	
	public int getmaxID() {
		return maxId;
	}
	
	public String getTitle(int index) {
		return Title[index];
	}
	public String getStatus(int index) {
		return Status[index];
	}
}
