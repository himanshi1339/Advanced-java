package in.co.preparedStatement1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserModel1 {
public void add(UserBean1 bean) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
	PreparedStatement pstmt=conn.prepareStatement("insert into newstudent values(?,?,?,?,?,?,?)");
	
	pstmt.setInt(1, nextPk());
	pstmt.setString(2,bean.getFirstname());
	pstmt.setString(3, bean.getLastname());
	pstmt.setString(4, bean.getLoginid());
	pstmt.setString(5, bean.getPassword());
	pstmt.setDate(6, new java.sql.Date(bean.getDob().getDate()));
	pstmt.setString(7, bean.getGender());
	
	int i=pstmt.executeUpdate();
	System.out.println("created successfully....");
	
}
public void delete(UserBean1 bean) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
	PreparedStatement pstmt=conn.prepareStatement("delete from newstudent where id=?");
	
	pstmt.setInt(1, bean.getId());
	
	int i=pstmt.executeUpdate();
	System.out.println("delete successfully....");
	
}
public void update(UserBean1 bean) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
	PreparedStatement pstmt=conn.prepareStatement("update newstudent set firstname=? where id=?");
	
	pstmt.setString(1, bean.getFirstname());
	pstmt.setInt(2, bean.getId());
	
	int i=pstmt.executeUpdate();
	System.out.println("update successfully");
	
}
public int nextPk() throws Exception {
	int pk=0;
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root" , "root");
	PreparedStatement pstmt =conn.prepareStatement("select max(id) from newstudent");
	
	ResultSet rs= pstmt.executeQuery();
	
	while(rs.next()) {
		pk = rs.getInt(1);
		
		System.out.println("max id =" + pk);
	}
	
	return pk + 1;
	
}
}
