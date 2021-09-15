package diexp.di20;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import diexp.vo6.Note;
import diexp.vo6.Pencil;


public class DI26_autoPackExp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("diexp\\di20\\a26_autoPackExp3.xml");


		Note n01 = ctx.getBean("note", Note.class);
		System.out.println(n01);
		n01.showNote(); // 이때 연관관계가 설정되지않음
		
		// @Autowired 선언시 
		n01.setNname("연습장");
		
		Pencil pen = ctx.getBean("pencil", Pencil.class);
		System.out.println(pen);
		
		// @Autowired 선언시 
		pen.setKind("4B");
		
		
		/*
			응용) vo7 패키지에 Product, Mart 클래스를 선언하고, 객체를 로딩할 수 있게 한다
				a27.xml 컨테이너를 활용하세요 (4조 제출, 나머지 손들기) 
		*/
		
		
		ctx.close();
		
	}
}
