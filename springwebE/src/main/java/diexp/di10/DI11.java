package diexp.di10;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import diexp.vo.Person;

public class DI11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// spring 관련된 클래스들을 import
		Resource rs = new ClassPathResource("diexp\\a11.xml");
		BeanFactory bean = new XmlBeanFactory(rs);
		
		// 외부에서 contain한 객체를 가져올 수 있음 (x11.xml에 작성한 내용?)
		Person p01 = (Person)bean.getBean("p01");
		System.out.println(p01.getName());
		System.out.println(p01.getAge());
		System.out.println(p01.getLoc());
		
		// 응용) a12.xml을 만들고 Product 필드를 할당
		// 	DI12.java를 통해서 호출하여 출력하기(4조 제출, 나머지 손들기)
	}

}
