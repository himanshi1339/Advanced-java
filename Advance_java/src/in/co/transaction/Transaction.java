package in.co.transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import in.co.util.JDBCDataSource;

public class Transaction {
public static void main(String[] args) throws Exception {
	Connection conn=null;
	
	try {
		conn=JDBCDataSource.getConnection();
		
		Statement stmt = conn.createStatement();
		
		//step1
		conn.setAutoCommit(false);
		
		int i = stmt.executeUpdate("insert into newstudent values(3 , 'neeraj' , 'chopra' ,'neer@123' ,'chopra12','2002-05-25' , 'male') ");
		
		i = stmt.executeUpdate("insert into newstudent values(3 ,'megha' , 'yadav' , 'yadav11@gmail.com','yadav11' , '1996-06-24' , 'female')");
		i = stmt.executeUpdate("insert into newstudent values(3 ,'shivi' , 'mehra' , 'mehra@gmail.com','mehra12' , '2000-06-24' , 'female')");
		
		System.out.println("data inserted");
		
		//step2
		
		conn.commit();
		
	}catch(Exception e) {
		
		//step3
		conn.rollback();
		
		System.out.println("data not inserted");
		
		System.out.println(e.getMessage());
	}
}
}
