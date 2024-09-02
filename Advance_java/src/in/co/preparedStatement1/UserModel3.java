
package in.co.preparedStatement1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UserModel3 {
public List search(UserBean1 bean) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
	StringBuffer sql=new StringBuffer("select*from newstudent where 1=1");
	
	if(bean !=null) {
		if(bean.getFirstname() !=null && bean.getFirstname().length()>0) {
			sql.append(" and firstname like'"+ bean.getFirstname()+"'");
			
		}
	}
	System.out.println("sql query ====>" + sql.toString());
	PreparedStatement pstmt=conn.prepareStatement(sql.toString());
	ResultSet rs= pstmt.executeQuery();
	List list = new ArrayList();
	
	while (rs.next()) {
		bean=new UserBean1();
		
		bean.setId(rs.getInt(1));
		bean.setFirstname(rs.getString(2));
		bean.setLastname(rs.getString(3));
		bean.setLoginid(rs.getString(4));
		bean.setPassword(rs.getString(5));
		bean.setDob(rs.getDate(6));
		bean.setGender(rs.getString(7));
		
		list.add(bean);
	}
	return list;
	
}
}
