import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class test {

	public static void main(String[] args) {
		try	{
			String url = "jdbc:mysql://192.168.1.2:3306/users";
			// Connect to database
			Connection myConn = DriverManager.getConnection(url, "root", "");
			// Create statement
			Statement myStmt = myConn.createStatement();
			// Execute SQL query
			ResultSet myRs = myStmt.executeQuery("SELECT * FROM `register` ORDER BY `id` ASC");
			// Process result set
			while(myRs.next()) {
				System.out.println(myRs.getInt("id") + ", " + myRs.getString("username") + ", " + myRs.getString("password") + ", " + myRs.getString("email") + ", " + myRs.getInt("power"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
