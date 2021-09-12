package diexp.di10;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import diexp.vo.Dept;
import diexp.vo.Student;

public class DI15 {
	// http://localhost:6080/springwebE/diexp/DI15
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 응용) DI15.java, a15.xml을 만들고 Student.java를 활용하여 생성자를 통해
		// 		데이터를 할당하고 출력하기  (4조 제출, 나머지 손들기) 
		
		Resource rs = new ClassPathResource("a12.xml");
		BeanFactory bean = new XmlBeanFactory(rs);
		Student stu01 = (Student) bean.getBean("stu");
		System.out.println(stu01.getSno());
		System.out.println(stu01.getName());
		System.out.println(stu01.getKor());
		System.out.println(stu01.getEng());
		System.out.println(stu01.getMath());
	}

}
