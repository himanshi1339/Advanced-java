package in.co.preparedStatement1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UserModel2 {
	//ResourceBundle rb=ResourceBundle.getBundle("cin.co.bundle.System");
	
	public void add(UserBean1 bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/institute", "root", "root");

		UserBean1 us = FindByloginId(bean.getLoginid()); // yaha login id se find krne k liye condition lgai h,iski ek
															// or method bnani pdegi findbyloginid

		if (us != null) {
			System.out.println("login id already exist please use different id ");
		} else {
			PreparedStatement pstmt = conn.prepareStatement("insert into newstudent values(?,?,?,?,?,?,?)");

			pstmt.setInt(1, bean.getId());
			pstmt.setString(2, bean.getFirstname());
			pstmt.setString(3, bean.getLastname());
			pstmt.setString(4, bean.getLoginid());
			pstmt.setString(5, bean.getPassword());
			pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(7, bean.getGender());

			int i = pstmt.executeUpdate();
			System.out.println("data insert successfully....");
		}
	}

	public UserBean1 FindByloginId(String loginid) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/institute", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("select * from newstudent where loginid=?");

		pstmt.setString(1,loginid); // ye smjh nhi aaya yaha parameter q nhi dia h

		ResultSet rs = pstmt.executeQuery();
		UserBean1 bean = null;
		while (rs.next()) {
			bean = new UserBean1();
			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLoginid(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setGender(rs.getString(7));

		}
		return bean;
	}
	public int nextPk() throws Exception {
		int pk=0;                //ye yaha nhi chlegi q ki ye add wali query ka bu data include kr rhi h output m,ise humne usermodel1 m chlaya h
		
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
