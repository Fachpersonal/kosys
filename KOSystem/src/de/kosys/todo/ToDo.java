package de.kosys.todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ToDo{
	
	private int maxId;
	
	private int[] id = new int[16];
	
	private String[] Title = new String[16];
	private String[] Status = new String[16];
		
	public void getToDoList() {
		maxId = 0;
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
			myConn.close();
			myStmt.close();
			myRs.close();
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
