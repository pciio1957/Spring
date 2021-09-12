package diexp.di10;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import diexp.vo.FruitShop;
import diexp.vo.Monitor;
import diexp.vo.Sensor;


public class DI19 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractApplicationContext ctx1 = new GenericXmlApplicationContext("diexp\\a19.xml");
		Sensor obj2 = ctx1.getBean("sensor1", Sensor.class);
		System.out.println(obj2);
		
		
		
		// 응용) 과일가게 FruitShop : Set<String> 판매하는 과일들, 
		//		Properties 과일과 가격이 설정된 내용  (5조 제출, 나머지 손들기)
		FruitShop fInfo = ctx1.getBean("fruits", FruitShop.class);
		fInfo.show();
		
	
		
		// map 형식
		Monitor m1 = ctx1.getBean("monitor", Monitor.class);
		System.out.println(m1);
		
		
		ctx1.close();
	}
}
