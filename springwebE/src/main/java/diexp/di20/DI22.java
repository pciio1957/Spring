package diexp.di20;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import diexp.vo.Mart;
import diexp.vo.Note;
import diexp.vo.Person;

public class DI22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("diexp\\di20\\a22.xml");
		
		// 다른것들과 합쳐져서 제대로 인식이 안되는 문제! 다른건 주석 처리 후 실행 
		// 단독 실행시 제대로 실행되는 것 확인!!
		//Note note = ctx.getBean("note", Note.class);
		//note.showNote();
		//System.out.println();
		
		
		// 마트 객체의 메소드 호출, 같은 Product1을 가진 객체만 실행 -> 바나나 객체
		Mart mt1 = ctx.getBean("mt1", Mart.class);
		mt1.show();
		
		
		// 응용) autowire 예제 - pen3만 메소드 적용
		// 다른 예제에서 이미 선언한 메소드를 수정해서 오류나서 원래 메소드도 추가함
		// a22.xml에 설정한 이름과 같은 setXXX만 실행시켜서 결과는 같음 
		Note noteS = ctx.getBean("noteS", Note.class);
		noteS.showNote();
		
		
		
		ctx.close();
		
		/*
			AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext(Con10.class);
			Person p01= ctx2.getBean("getPerson", Person.class);
			System.out.println(p01.getName());
			ctx2.close();
		*/
	}

}
