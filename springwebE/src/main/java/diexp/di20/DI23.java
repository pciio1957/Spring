package diexp.di20;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import diexp.vo2.Person;
import diexp.vo3.Computer;

public class DI23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("diexp\\di20\\a23.xml");

		// 자동 패키지 선언으로 바로 할당되어서 나옴 
		Person p01 = ctx.getBean("person", Person.class);
		p01.showAutoExp();
		
		// 응용) diexp.vo2 패키지 생성, Computer, Ram, Hdd, Cpu 를 복사하여 
		//		할당하고 Computer에 초기값을 설정하여 해당 객체들을 호출하기 
		//		a23.xml에 패키지 선언처리 (2조 제출, 나머지 손들기)
		Computer com = ctx.getBean("computer", Computer.class);
		com.textExp();
		
		
		
		ctx.close();
		
	}
}
