package in.co.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestDelete {
public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/liabrary","root","root");
	Statement stmt=conn.createStatement();
	int i=stmt.executeUpdate("delete from studentuser where id=111");
	System.out.println("data delete successfully:" + i);
}
}
