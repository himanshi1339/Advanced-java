package in.co.preparedStatement1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestCreate {
public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
	Statement stmt=conn.createStatement();
	int i=stmt.executeUpdate("create table Newstudent(id int primary key,firstname varchar(50),lastname varchar(50),loginId varchar(50),password varchar(50),dob date ,gender varchar(50))");
	System.out.println("table created =" + i);
	System.out.println("created successfully....");
}
}
