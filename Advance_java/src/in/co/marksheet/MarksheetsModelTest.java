package in.co.marksheet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MarksheetsModelTest {
public static void main(String[] args) throws Exception {
	//testAdd();
	//testUpdate();
	//testDelete();
	//testgetrollno();
	testsearch();
	//testgetmerit();
}

private static void testsearch() throws Exception {
	 MarksheetsBean bean=new MarksheetsBean();
	 
	 MarksheetsModel model=new MarksheetsModel();
	 
	 List list=new ArrayList();
	 
	 bean.setName("avi");
	 
	 list=model.search(bean);
	 
	 Iterator it=list.iterator();
	 
	 while(it.hasNext()) {
		 bean=(MarksheetsBean) it.next();
		 
		 System.out.println("\t" + bean.getRollno());
		 System.out.println("\t" + bean.getName());
		 System.out.println("\t" + bean.getChemistry());
		 System.out.println("\t" + bean.getPhysics());
		 System.out.println("\t" + bean.getMaths());


	 }
	
}

private static void testgetmerit() throws Exception {
	
	MarksheetsBean bean=new MarksheetsBean();
	
	MarksheetsModel model=new MarksheetsModel();
	
	List list=new ArrayList();
	list=model.getmerit(bean);
	
	Iterator it=list.iterator();
	
	while(it.hasNext()) {
		bean=(MarksheetsBean) it.next();
		System.out.println(bean.getRollno());
		System.out.println(bean.getName());
		System.out.println(bean.getChemistry());
		System.out.println(bean.getPhysics());
		System.out.println(bean.getMaths());
	}
}

private static void testgetrollno() throws Exception {
	
	MarksheetsBean bean =new MarksheetsBean();
	bean.setRollno("h102");
	
	MarksheetsModel model=new MarksheetsModel();
	model.getrollno(bean);
	
}

private static void testDelete() throws Exception {
	
	MarksheetsBean bean=new MarksheetsBean();
	bean.setRollno("h105");
	
	MarksheetsModel model=new MarksheetsModel();
	model.delete(bean);
	
}

private static void testUpdate() throws Exception {
	
	MarksheetsBean bean=new MarksheetsBean();
	bean.setName("isha");
	bean.setRollno("h106");
	
	MarksheetsModel model = new MarksheetsModel();
	model.update(bean);
	
}

private static void testAdd() throws Exception {
	
	MarksheetsBean bean = new MarksheetsBean();
	bean.setRollno("h106");
	bean.setName("jaadu");
	bean.setChemistry(63);
	bean.setPhysics(84);
	bean.setMaths(55);
	
	MarksheetsModel model= new MarksheetsModel();
	model.add(bean);
	
}


}
