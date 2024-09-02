package in.co.preparedStatement1;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UserModelTest1 {
public static void main(String[] args) throws Exception {
	testAdd();
}

private static void testAdd() throws Exception {
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
	
	UserBean1 bean=new UserBean1();
	bean.setId(62);
	bean.setFirstname("mangilal");
	bean.setLastname("kataria");
	bean.setLoginid("kataria@1234gmai.com");
	bean.setPassword("mohana12");
	bean.setDob(sdf.parse("2000-11-04"));
	bean.setGender("female");
	
	UserModel1 model=new UserModel1();
	model.add(bean);
	//model.delete(bean);
	//model.update(bean);
}
}
