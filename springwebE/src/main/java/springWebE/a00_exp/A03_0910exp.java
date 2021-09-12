package springWebE.a00_exp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import diexp.vo.Computer;
import diexp.vo.Cpu;
import diexp.vo.Hdd;
import diexp.vo.Note;
import diexp.vo.Person;
import diexp.vo.Ram;


public class A03_0910exp {
	
	/*

	정리문제
	1. IOC란 무엇이며, 가상으로 컨테이너 설정하기 위해 처리할 부분을 기술하기
		Inversion of control, 제어의 역전이라는 말로 인스턴스 생성부터 소멸까지의 인스턴스 생명주기 관리를 
			개발자가 아닌 컨테이너가 대신 해준다는 뜻이다.
		IoC컨테이너는 객체의 생성을 책임지고 의존성을 관리한다
		
	2. 컨테이너의 property, constructor의 차이를 기술하기
		1) constructor
			컨테이너 내부에 선언된 변수, 객체
		2) property
			컨테이너 내부의 객체의 필드값 
	
	3. Note와 Pencil 클래스를 선언하고 1:1관계의 내용을 a18.xml, D18.java를 통해서 설정하여 출력하기
	
	4. Compute와 PartDevice(컴퓨터부품(추상클래스) 하위 상속 Ram, Hdd, Cpu) 클래스를 선언하고 
		1:다 관계의 내용을 a18.xml, D18.java를 통해서 설정하여 출력하기 
		
		다형성 처리 PartDevice pd = new Ram();
		다형성 처리 PartDevice pd = new Hdd();
		
		plist.add(new Ram());
		plist.add(new Hdd());
		plist.add(new Cpu());


		Class Computer {
			ArrayList<PartDevice> plist;
		}	
			
		abstract class PartDevice {
			private String device;
			PartDevice(String device){
				this.device = device;
			}
			public void showDice() {
				System.out.println("부품종류 : " + device);
			}
		}
		
		class Ram extends PartDevice{
			Ram() {
				super("램");
			}
		}	
			
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 컨테이너에 설정
		AbstractApplicationContext ctx1 = new GenericXmlApplicationContext("diexp\\a18.xml");
		Note note = ctx1.getBean("note", Note.class);
		note.showNote();
		
		Computer com = ctx1.getBean("com", Computer.class);
		com.showParts();
		ctx1.close();
		
		/*
		AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext(Con18.class);
		Note n02= ctx2.getBean("getNote", Note.class);
		n02.showNote();
		ctx2.close();
		*/
	
	}
}
