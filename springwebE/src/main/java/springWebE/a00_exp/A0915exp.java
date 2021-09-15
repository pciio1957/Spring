package springWebE.a00_exp;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;

import diexp.vo9.Buyer;
import diexp.vo9.Dron;
import diexp.vo9.Larba;
import diexp.vo9.Product;
import diexp.vo9.ZergUser;

@Controller
public class A0915exp {

	/*
	
	 #정리문제
	1. component-scan의 base-package vo8를 다른 속성설정없이 객체를 호출처리하기 
		1) xml에 component-scan 속성을 설정한다. 
		<context:component-scan base-package="diexp.vo8">
		</context:component-scan>
		2) 해당 폴더의 객체를 이용하여 객체 생성시 import되는 폴더를 vo7로 지정한다. 
		
		풀이 ->
		1) 문제에서 말하는 다른 속성설정없이 객체 호출이라 filter가 없는 조건임 
		2) 사용하려는 클래스에는 @Component 설정 필수
		3) 필터 없이 default로 사용하기 위해서는 사용하려는 객체에 이름을 지정해야한다
		
	2. component-scan의 base-package vo9를 Buyer와 Product의 1:1 autowiring처리하여 출력하기
		(아래)
		
	3. component-scan의 base-package v09에 소스상의 autowiring 처리를 하려고 한다. 
		ZergUser(이름), Larba(추상클래스) - 상속 Dron, Zerggling, Hydra 구조를 만들고 Autowiring 처리하기
		
	4. @ModelAttribute는 어떤 역할을 하는지 기술하고, Member 등록화면과 등록된 내용을 출력하기 
		ModelAttribute 
		1) 컨트롤러의 요청값과 모델데이터를 동시에 처리해준다.
		2) 컨트롤단에서 사용하는 공통 모델데이터를 처리한다. 
		
		-> Member 등록화면 
			컨트롤러 : A04_ModelController.java에 작성
			화면 : a11_modelAttr.jsp
	 
	*/
	
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("springWebE\\a00_exp\\a915.xml");
		
		// 2번
		Buyer byr = ctx.getBean("buyer", Buyer.class);
		Product prod = ctx.getBean("product", Product.class);
		prod.setName("젤리");
		prod.setPrice(1000);
		prod.setCnt(100);
		byr.showBuyer();
		
		// 3번
		ZergUser zerg = ctx.getBean("zergUser", ZergUser.class);
		zerg.playGmaes();		
		
				
		ctx.close();
	}
}
