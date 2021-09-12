package diexp.di20;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import diexp.vo.Person;

public class DI20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("diexp\\a10.xml");
		Object obj2 = ctx.getBean("obj", Object.class);
		System.out.println(obj2);
		ctx.close();
		
		/*
		AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext(Con10.class);
		Person p01= ctx2.getBean("getPerson", Person.class);
		System.out.println(p01.getName());
		ctx2.close();
		*/
	}

}
