package in.co.preparedStatement1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CRUDOperation {
public static void main(String[] args) throws Exception {
	//add();
	delete();
	//search();
	//findbyloginid();
	//findbyid();
	authentication();
	//update();
	
	
}

private static void delete() throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
	Statement stmt=conn.createStatement();
	int i=stmt.executeUpdate("");
	System.out.println("table created =" + i);
	System.out.println("created successfully....");
	
	
}

private static void authentication() throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
	Statement stmt=conn.createStatement();
	ResultSet rs=stmt.executeQuery("select*from Newstudent where loginId='siya@gmail.com' and password='siya!@'");
	
	if(rs.next()) {
		System.out.println(rs.getInt(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getString(3));
		System.out.println(rs.getString(4));
		System.out.println(rs.getString(5));
		System.out.println(rs.getDate(6));
		System.out.println(rs.getString(7));
	}else {
		System.out.println("login id or password is invalid");
	}
	
	
}

private static void add() throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
	Statement stmt=conn.createStatement();
	int i=stmt.executeUpdate("insert into Newstudent values(55,'siya','mehta','siya@gmail.com','siya!@','1888-08-26','female')");
	System.out.println("table created =" + i);
	System.out.println("created successfully....");
	
}
}
