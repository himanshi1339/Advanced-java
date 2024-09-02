
package in.co.preparedStatement1;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UserModelTest2 {
public static void main(String[] args) throws Exception {
	//testAdd();
	//testUpdate();
	//testDelete();
	testFindByloginid();
	
}

private static void //testUpdate() {
	// TODO Auto-generated method stub
	
private static void //testDelete() {
	// TODO Auto-generated method stub
	
}

}

private static void testFindByloginid() throws Exception {
	
	UserBean1 bean= new UserBean1();
	
	UserModel2 model=new UserModel2();
	
	bean=model.FindByloginId("hari@gmail.com");
	
	System.out.println(bean.getFirstname());
	System.out.println(bean.getLastname());
	
}

private static void testAdd() throws Exception {
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
	
	UserBean1 bean=new UserBean1();
	//bean.setId(222);
	bean.setFirstname("himanshi");
	bean.setLastname("sharma");
	bean.setLoginid("himanshisharma@gmail.com");
	bean.setPassword("himanshi!@#$");
	bean.setDob(sdf.parse("2001-05-28"));
	bean.setGender("female");
	
	System.out.println("done");
	
	UserModel2 model=new UserModel2();
	model.add(bean);
    
}


}
