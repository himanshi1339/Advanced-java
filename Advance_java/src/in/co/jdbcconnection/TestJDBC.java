package in.co.jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestJDBC {
public static void main(String[] args) throws Exception {
	 //step1 load driver
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	//driver ko address dene k liye
	//step 2 get connectivity
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
	
	//step3 create object of statement
	Statement stmt=conn.createStatement();
	
	System.out.println("Connection is successfully");
}
}
