package springWebE.a00_exp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import diexp.di10.Con19;
import diexp.vo.Bus;
import diexp.vo.OnSchool;

public class A04_a0913exp {

	
/*
	  
정리문제
1. 스프링 개발 환경에 사용하는 lib 설정 형식 3가지 기술하기
	스프링 개발 환경의 lib 설정 형식 
	0) dynamic 웹 프로젝트 : 
		필요한 라이브러리를 직접 다운받아 \webapp\WEB-INF\lib 하위에 삽입
	1) maven : 
		pom.xml에 지정된 xml형시기으로 온라인으로 lib 파일들을 받아서 설정
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-core</artifactId>
			<version>5.3.9</version>
		</dependency>
	2) gradle :
		gradle 파일로 지정된 온라인으로 lib 파일을 다운받아서 처리 
		build.gradle 파일에 lib 선언
		implementation group: 'org.springframework', name: 'spring-core', version: '5.3.9'
	3) 스프링부트(maven, gradle)
		Spring Tool Suits(sts)의 설치를 통해 설정

2. 스프링에서 aop란 무엇인가? 개념을 찾아보고 기술하기
	aspect oriented programming, 문제를 바라보는 관점을 기준으로 프로그래밍하는 기법
	컨테이너 기반으로 객체가 로딩된 상황에서 특정한 프로그램이 시행되는 시점을 기준으로 처리할 때 사용된다
	
	-> AOP(Aspect-Oriented Programming)는 관점 지향 프로그래밍이다.
	관점 지향은 쉽게 말해 어떤 로직을 기준으로 핵심적인 관점, 부가적인 관점으로 나누어서 보고 
	그 관점을 기준으로 각각 모듈화하겠다는 것이다.
	위의 각 관점에 따른 코드의 영역을 구분하여 쉽게 탈착할 수 있도록 하는 프로그래밍 방법론이다.

3. 스프링 컨테이너의 구조체 선언 3가지 방식에 대하여 예제를 통해서 기술하기
	1) list형식 : ArrayList 이용, <list>안에 ref로 처리 	
	2) set형식 : set<T>이용, <set>안에 value로 처리
	3) map형식 : 
		 - property로 <props> 안에 <prop key="">value값</prop>로 처리
		 - map<key, value>, <entry>에 key/value 형식으로 처리
		 
		 
	#컨테이너 호출 방식
	1) xml컨테이너 호출 (옛날버전)
	Resource rs = new ClassPathResource("경로.xml");
	BeanFactory bean = new XmlBeanFactory(rs);
	
	2) xml컨테이너 호출방식
	AbstractApplicationContext ctx = new GenericXmlApplicationContext("diexp\\a16.xml");
	Mart mt = ctx.getBean("mt", Mart.class);
	
	3) 객체로된 컨테이너 호출 방식
	AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext(Con10.class);
		Person p01= ctx2.getBean("getPerson", Person.class);
		System.out.println(p01.getName());
		ctx2.close();
		
	#컨테이너 내의 구조체(collections) 
		List : <list>
		Set : <set>
		Map<key, value> : <map>
		Properties : <prop>
	
4. Bus클래스에 Set<String> 버스번호 Properties를 시작/종점을 처리하게 하고 
	Container에 설정하여 처리하기. 
	main\java\diexp\Con10.java(자바형 컨테이너)를 설정해서 처리되게 하기 
	(잘 모르겠음..)

5. 컨테이너의 namespace 선언방식을 생성자와 property를 나누어 설명하고 
	물건정보를 기본 예제 처리하기
	1) 라이브러리
	xmlns:p="~/p"
	xmlns:c="~/c" 사용
	
	2) 사용
	<bean c:매개변수="데이터할당"> 생성자
		c:_0="데이터할당"
		p:프로퍼티명="데이터할당"
	
6. OnSchool클래스에 학교명, Map<Integer, Student> stus로 
	<번호, 학생정보>를 설정하여 컨테이너에 의해 데이터를 할당하여
	해당 학교, 번호, 학생정보를 출력하기 

7. autowire란 무엇인가? 개념을 정리하고 Note와 Pencil을 기준으로 처리하기
	속성(field), setter method, constructor(생성자)에서 사용하며 Type에 따라 
	알아서 Bean을 주입 해준다. 무조건적인 객체에 대한 의존성을 주입시킨다.
	
	컨테이너에서 객체와 객체간의 연관관계 할당 메소가 있을 때
	자동으로 설정에 의해서 할당 처리되게 하는 것을 말한다 

	*/
	
	
	public static void main(String[] args) {
		
		
		
		/*
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("a00_exp\\a04_a0913.xml"); 
		 
		// 1) list 
		Computer com = ctx.getBean("com", Computer.class);
		com.showParts();

		// 2) set 
		Sensor obj2 = ctx.getBean("sensor1", Sensor.class);
		System.out.println(obj2);
		
		// 3) map
		FruitShop fInfo = ctx.getBean("fruits", FruitShop.class);
		fInfo.show();
		
		Monitor m1 = ctx.getBean("monitor", Monitor.class);
		System.out.println(m1);
		ctx.close();
		
		*/
		
		// 구조체 선언 1) 구방식
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("springWebE\\a00_exp\\a04_a0913.xml"); 
		Bus bus = ctx.getBean("bus", Bus.class);
		System.out.println(bus);
		
		// 6번문제)
		OnSchool sInfo = ctx.getBean("sInfo", OnSchool.class);
		sInfo.showInfo();
		
		ctx.close();
		
		// 구조체 선언 2) 자바컨테이너 객체 방식
		AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext(Con19.class);
		Bus bus2= ctx2.getBean("getBus", Bus.class);
		System.out.println(bus2);
		ctx2.close();
		
		
	}
}
