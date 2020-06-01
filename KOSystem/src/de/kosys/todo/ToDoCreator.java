package de.kosys.todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;

public class ToDoCreator {
	
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
				System.out.println(myRs.getString("title") + ", " + myRs.getString("user") + ", " + myRs.getInt("status") + ", " + myRs.getDate("commitdate") + "/" + myRs.getTime("commitdate") + ", " + myRs.getDate("finishdate") + "/" + myRs.getTime("finishdate"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void makeToDo() {
		JLabel jl = new JLabel();
		jl.setSize(150,350);
		
	}
}
