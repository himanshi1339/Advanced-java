package in.co.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MarksheetsModel {
    public void add(MarksheetsBean bean) throws Exception {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/work" , "root" ,"root");
    	PreparedStatement pstmt = conn.prepareStatement("insert into marksheets values(?,?,?,?,?)");
    	
    	pstmt.setString(1, bean.getRollno());
    	pstmt.setString(2, bean.getName());
    	pstmt.setInt(3, bean.getChemistry());
    	pstmt.setInt(4, bean.getPhysics());
    	pstmt.setInt(5, bean.getMaths());
    	
    	int i =pstmt.executeUpdate();
    	System.out.println("created successfully......");
    }
    
    public void update(MarksheetsBean bean) throws Exception {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/work","root","root");
    	PreparedStatement pstmt= conn.prepareStatement("update marksheets set name=? where rollno=?");
    	
    	pstmt.setString(1, bean.getName());
    	pstmt.setString(2, bean.getRollno());
    	int i=pstmt.executeUpdate();
    	System.out.println("update query.......hureee");
    }
    
    public void delete(MarksheetsBean bean) throws Exception {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/work" , "root" ,"root");
    	PreparedStatement pstmt = conn.prepareStatement("delete from marksheets where rollno=?");
    	
    	pstmt.setString(1, bean.getRollno());
    	int  i=pstmt.executeUpdate();
    	System.out.println("delete successfully....yeeee");
    }
    
    public void getrollno(MarksheetsBean bean) throws Exception   {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/work" , "root" ,"root");
    	PreparedStatement pstmt = conn.prepareStatement("select * from marksheets where rollno=?");
    	
    	pstmt.setString(1, bean.getRollno());    	
    	ResultSet rs=pstmt.executeQuery();
    	System.out.println("finding successfully....wow");
    }
    
    public List getmerit(MarksheetsBean bean) throws Exception {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/work" , "root" ,"root");
    	PreparedStatement pstmt = conn.prepareStatement("select * ,(chemistry+physics+maths) as total from marksheets where chemistry >= 33 and physics >= 33 and maths >= 33 order by total desc limit 0,3 ");
	
    	ResultSet rs=pstmt.executeQuery();
    	
    	System.out.println("done");
    	
    	
    	List list=new ArrayList();
    	
    	while(rs.next()) {
    		bean=new MarksheetsBean();
    		
    		bean.setRollno(rs.getString(1));
    		bean.setName(rs.getString(2));
    		bean.setChemistry(rs.getInt(3));
    		bean.setPhysics(rs.getInt(4));
    		bean.setMaths(rs.getInt(5));
    		
    		list.add(bean);
    	}
    	return list;
    }
    
    public List  search(MarksheetsBean bean) throws Exception {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/work","root","root");
    	StringBuffer sb= new StringBuffer("select*from marksheets where 1=1");
    	
    	if(bean != null) {
    		if(bean.getName() !=null && bean.getName().length()>0) {
    		sb.append(" and name like ' " + bean.getName()+ " ' ");
    		
		}
    		
   }
    	System.out.println("sql query ====>" + sb.toString());
    	PreparedStatement pstmt=conn.prepareStatement(sb.toString());
    	ResultSet rs =pstmt.executeQuery();
    	List list=new ArrayList();
    	
    	while(rs.next()) {
    		bean=new MarksheetsBean();
    		
    		bean.setRollno(rs.getString(1));
    		bean.setName(rs.getString(2));
    		bean.setChemistry(rs.getInt(3));
    		bean.setPhysics(rs.getInt(4));
    		bean.setMaths(rs.getInt(5));
    		
    		list.add(bean);
    		}
		return list;
    }
}
