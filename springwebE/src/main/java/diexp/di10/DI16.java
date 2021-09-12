package diexp.di10;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import diexp.vo.Dept;
import diexp.vo.Mart;
import diexp.vo.Student;

public class DI16 {
	// http://localhost:6080/springwebE/diexp/DI15
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("diexp\\a16.xml");
		Mart mt = ctx.getBean("mt", Mart.class);
		mt.show();
		
		
		// 응용) DI17.java a17.xml을 만들고 shoppingMal.java, Member.java의 
		//		1:1 연관관계 설정 후 호출하여 출력하기 (5조 제출, 나머지 손들기) 
		
		Mart mt2 = ctx.getBean("mt2", Mart.class);
		mt2.showAllProList();
		ctx.close();
	}
}
