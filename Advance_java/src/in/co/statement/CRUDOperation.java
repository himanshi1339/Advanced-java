package in.co.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CRUDOperation {
public static void main(String[] args) throws Exception {
	//add();
	update();
	delete();
	authenticate();
	search();
	findbyloginId();
	
}

private static void findbyloginId() throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/liabrary","root","root");
	Statement stmt=conn.createStatement();
	ResultSet rs =stmt.executeQuery("select*from  studentuser where id =444");
	System.out.println("find data by id successfully");
	
	
	
}

private static void search() throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/liabrary","root","root");
	Statement stmt=conn.createStatement();
	ResultSet rs =stmt.executeQuery("select*from  studentuser");
	System.out.println("find all data successfully");
	
}

private static void authenticate() throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/liabrary","root","root");
	Statement stmt=conn.createStatement();
	ResultSet rs =stmt.executeQuery("select*from studentuser where id=222 and firstname='himanshi'");
	System.out.println("find data successfully");
	
}

private static void delete() throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/liabrary","root","root");
	Statement stmt=conn.createStatement();
	int i =stmt.executeUpdate("delete from studentuser where id=333");
	System.out.println("delete data successfully");
	
}

private static void update() throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/liabrary","root","root");
	Statement stmt=conn.createStatement();
	int i =stmt.executeUpdate("update studentuser set lastname='mishra' where id=444");
	System.out.println("update data successfully");
	
}

private static void add() throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/liabrary","root","root");
	Statement stmt =conn.createStatement();
	int i=stmt.executeUpdate("insert into studentuser values(444,'chhaganlal','khan','1991-05-22')");
	System.out.println("table created:" + i);
	System.out.println("successfully data insert");
	
}
}
