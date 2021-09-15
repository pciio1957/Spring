package diexp.di20;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import diexp.vo4.Person;
import diexp.vo4.Product;

public class DI24_autoPackExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("diexp\\di20\\a24_autoPackExp.xml");

		Person obj1 = ctx.getBean("person", Person.class);
		Product obj2 = ctx.getBean("product", Product.class);
		
		System.out.println(obj1);
		System.out.println(obj2);
		
		obj1.setName("홍길동");
		obj2.setName("사과");
		
		System.out.println("이름 : " + obj1.getName());
		System.out.println("물건명 : " + obj2.getName());
		
		
		ctx.close();
		
	}
}
