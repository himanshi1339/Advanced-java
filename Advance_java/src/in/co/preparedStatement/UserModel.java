package in.co.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserModel {
public void add(UserBean bean) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/liabrary","root","root");
	PreparedStatement psmt=conn.prepareStatement("insert into studentuser values(?,?,?,?)");
	psmt.setInt(1, bean.getId());
	psmt.setString(2, bean.getFirstname());
	psmt.setString(3, bean.getLastname());
	psmt.setDate(4 , new java.sql.Date(bean.getDob().getTime()));
	
	int i=psmt.executeUpdate();
	System.out.println("done");
}
public void delete(UserBean bean) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/liabrary","root","root");
	PreparedStatement psmt=conn.prepareStatement("delete from studentuser where id=?");
	psmt.setInt(1, bean.getId());
	
	int i=psmt.executeUpdate();
	System.out.println("delete successfull");
}
public void update(UserBean bean) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/liabrary","root","root");
	PreparedStatement psmt=conn.prepareStatement("update studentuser set firstname=? where id=?");
	
	psmt.setString(1, bean.getFirstname());
	psmt.setInt(2, bean.getId());
	int i =psmt.executeUpdate();
	System.out.println("update query");
	
}
}
