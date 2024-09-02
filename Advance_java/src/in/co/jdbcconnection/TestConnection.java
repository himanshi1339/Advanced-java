package in.co.jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestConnection {
public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/liabrary","root" ,"root");
	Statement stmt= conn.createStatement();
	int i = stmt.executeUpdate("create table studentuser(id int primary key,firstname varchar(52),lastname varchar(51),dob date)");
	System.out.println("table created:" + i);
	System.out.println("connection is successfully");
}
}
