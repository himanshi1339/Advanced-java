package in.co.preparedStatement1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserModelTest3 {
public static void main(String[] args) throws Exception {
	testSearch();
}

private static void testSearch() throws Exception {
	UserBean1 bean=new UserBean1();
	
	UserModel3 model=new UserModel3();
	
	List list =new ArrayList();
	
	bean.setFirstname("siya");  //yaha hum firstname ,lastname kisise bi search kr skte h ,yaha dena hoga hume
	
	list=model.search(bean);
	
	Iterator it=list.iterator();
	
	while(it.hasNext()) {
		bean=(UserBean1)it.next();
		
		System.out.println(bean.getId());
		System.out.println("\t" + bean.getFirstname());
		System.out.println("\t" + bean.getLastname());
		System.out.println("\t" + bean.getLoginid());
		System.out.println("\t" + bean.getPassword());
		System.out.println("\t" + bean.getDob());
		System.out.println("\t" + bean.getGender());
	}
	
}
}
