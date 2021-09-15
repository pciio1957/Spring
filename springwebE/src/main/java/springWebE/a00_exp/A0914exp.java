package springWebE.a00_exp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import diexp.vo.Bus;
import springWebE.z02_vo.OnEmp;

public class A0914exp {

	/*
	 
	#정리문제
	1. OnEmp클래스 사원명, Map<Integer, Emp> <사원번호, 사원정보>를 설정하여 컨테이너에 의해 데이터를 출력하기 
	2. autowire의 속성값을 선언하고 각각의 내용의 차이점 기술하기 
		autowire란? 
			컨테이너 내부 객체의 메모리의 연관관계를 자동으로 처리하는 것을 말함
		1) byType : 메소드의 parameter값으로 할당되어 type이 같을 때 자동으로 할당
		2) byName : 메소드의 매개변수에 해당 타입으로 할당하고, property 기준으로 이름이 같을 때 할당된다
		3) constructor : 생성자가 해당 type으로 할당된 것이 있을 때 자동으로 할당된다
		4) autodetext : 생성자나 메소드가 해당 type이 있을 때 자동으로 할당된다 
		
	3. Bus와 Driver(운전기사)를 1:1관계로 설정하고 해당 객체를 생성자를 통해서 할당할 때, autowire 처리를 통해 설정하기
	(아래) 
	
	4. 컨테이너에 특정 패키지를 기준으로 설정형식 기술하기 
	<context:component-scan base-package="지정한패키지">
	1. 특정패키지 기준으로 객체가 메모리 로딩되게 한다
		- default 각 클래스 마다 @Component로 선언하면 객체가 컨테이너 메모리에 로딩된다
		- type을 지정하면 해당 type의 성격에 따라 객체를 컨테이너 메모리에 로딩해준다 
		
	2. context:include-filter : 필터 기준으로 포함될 내용
		context:exclude-filter : 필터 기준으로 배제할 내용 
	
	3. expression : 실제 쓰이는 대상이 되는 클래스 ex) Controller, Service, Repository
	
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("springWebE\\a00_exp\\a0914.xml"); 
		OnEmp emp = ctx.getBean("empInfo", OnEmp.class);
		emp.showInfo();
		
		
		Bus bus = ctx.getBean("bus", Bus.class);
		bus.showBusInfo();
		
		ctx.close();

	}

}
