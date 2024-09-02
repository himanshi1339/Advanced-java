package in.co.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchDelete {
public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/liabrary","root","root");
	Statement stmt=conn.createStatement();
    ResultSet rs=stmt.executeQuery("select*from studentuser");
	System.out.println("data delete successfully:" );
}
}
