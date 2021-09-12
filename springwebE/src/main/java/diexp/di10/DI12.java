package diexp.di10;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import diexp.vo.Product;

public class DI12 {
	// http://localhost:7080/diexp/DI12
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Resource rs = new ClassPathResource("a12.xml");
		BeanFactory bean = new XmlBeanFactory(rs);
		
		Product pro01 = (Product) bean.getBean("pro01");
		System.out.println(pro01.getName());
		System.out.println(pro01.getPrice());
		System.out.println(pro01.getCnt());
	}

}
