package diexp.di20;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import diexp.vo7.exp.Bus;
import diexp.vo7.exp.Driver;
import diexp.vo7.Mart;
import diexp.vo7.Product;


public class DI27_autoPackExp4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("diexp\\di20\\a27_autoPackExp4.xml");
		
		
		/*
			응용) vo7 패키지에 Product, Mart 클래스를 선언하고, 객체를 로딩할 수 있게 한다
				a27.xml 컨테이너를 활용하세요 (4조 제출, 나머지 손들기) 
		*/
		
		Product pro = ctx.getBean("product" , Product.class);
		Mart mart = ctx.getBean("mart", Mart.class);
		System.out.println("# 마트정보 #");
		pro.setName("누룽지");
		pro.setPrice(3000);
		pro.setCnt(10);
		mart.show();
		
		
		
		//Driver dri = ctx.getBean("driver", Driver.class);
		Bus bus = ctx.getBean("bus", Bus.class);
		System.out.println("# 버스정보 #");
		//dri.setName("동동이");
		//dri.setRole("노선돌기");
		bus.setNumber("7730");
		bus.showBusInfo();
		
		// driver를 주석처리 후 bus만 실행하면 autowired로 받을 수 있는 드라이버가 없어서
		// null로 처리가 된다. 
		
		ctx.close();
		
	}
}
