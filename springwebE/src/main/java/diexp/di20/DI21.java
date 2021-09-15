package diexp.di20;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import diexp.vo.Mart;
import diexp.vo.Note;
import diexp.vo.Person;

public class DI21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("diexp\\di20\\a21.xml");
		Person p01 = ctx.getBean("p01", Person.class);
		System.out.println(p01.getName() + " : " + p01.getAge() + " : " + p01.getLoc());
		Person p02 = ctx.getBean("p02", Person.class);
		System.out.println(p02.getName() + " : " + p02.getAge() + " : " + p02.getLoc());
		Person p03 = ctx.getBean("p03", Person.class);
		System.out.println(p03.getName() + " : " + p03.getAge() + " : " + p03.getLoc());
		
		// autowire
		Mart mt = ctx.getBean("mt", Mart.class);
		mt.show();
		
		
		// 다른것들과 합쳐져서 제대로 인식이 안되는 문제! 다른건 주석 처리 후 실행 
		Note note = ctx.getBean("note", Note.class);
		note.showNote();
		//System.out.println();
		ctx.close();
		
		
		
		
		/*
		AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext(Con10.class);
		Person p01= ctx2.getBean("getPerson", Person.class);
		System.out.println(p01.getName());
		ctx2.close();
		*/
	}

}
