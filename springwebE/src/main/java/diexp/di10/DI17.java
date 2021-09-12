package diexp.di10;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import diexp.vo.Mart;
import diexp.vo.ShoppingMall;

public class DI17 {
	// http://localhost:6080/springwebE/diexp/DI15
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 응용) DI17.java a17.xml을 만들고 shoppingMal.java, Member.java의 
		//		1:1 연관관계 설정 후 호출하여 출력하기 (5조 제출, 나머지 손들기) 
		
		// Member가 단일일 때
		AbstractApplicationContext ctx1 = new GenericXmlApplicationContext("diexp\\a17.xml");
		ShoppingMall shop = ctx1.getBean("shop", ShoppingMall.class);
		shop.showMember();
		ctx1.close();
		
		// Member가 다중일 때
		AbstractApplicationContext ctx2 = new GenericXmlApplicationContext("diexp\\a17.xml");
		ShoppingMall shop2 = ctx2.getBean("shop2", ShoppingMall.class);
		shop2.showAllMembers();
		ctx2.close();
	}
}
