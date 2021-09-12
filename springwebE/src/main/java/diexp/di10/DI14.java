package diexp.di10;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import diexp.vo.Dept;

public class DI14 {
	// http://localhost:7080/diexp/DI12
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Resource rs = new ClassPathResource("a12.xml");
		BeanFactory bean = new XmlBeanFactory(rs);
		
		Dept dept = (Dept) bean.getBean("dept");
		System.out.println(dept.getDeptno());
		System.out.println(dept.getDname());
		System.out.println(dept.getLoc());
		
		// 응용) DI15.java, a15.xml을 만들고 Student.java를 활용하여 생성자를 통해
		// 		데이터를 할당하고 출력하기 
	}

}
