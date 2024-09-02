package in.co.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {
public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/liabrary","root","root");
	Statement stmt=conn.createStatement();
	int i=stmt.executeUpdate("insert into studentuser values(111 ,'raman','raghuvanshi','2001-12-24'),(222,'himanshi','sharma','2001-05-28'),(333,'krishna','yaduvanshi','1999-01-14')");
	System.out.println("data insert successfully:" + i);
	
}
}
