package in.co.preparedStatement;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UserModelTest {
public static void main(String[] args) throws Exception {
	testAdd();
}

private static void testAdd() throws Exception {
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
	
	UserBean bean=new UserBean();
	bean.setId(444);
	bean.setFirstname("chunnilal");
	bean.setLastname("sharma");
	bean.setDob(sdf.parse("1991-05-22"));
	
	UserModel model=new UserModel();
	//model.add(bean);
	//model.delete(bean);
	model.update(bean);
}
}
