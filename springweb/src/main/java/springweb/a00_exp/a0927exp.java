package springweb.a00_exp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.a05_mvc.a02_service.A03_DeptService;
import springweb.z01_vo.Dept;

@Controller
public class a0927exp {

	private A03_DeptService service;
	/*
	
	 #정리문제
	1. 스프링 컨테이너의 공통 설정 파일 처리 방식을 기술하고, 컨테이너와 외부클래스에서 사용 방법을 기술하기
		스프링의 공통 설정 파일 처리 방식 (DB연동시 필요한 정보 설정 처리)
		1) 컨테이너에서의 처리 방식
			- dispatcher-servlet.xml에 org.apache.commons.dbcp.BasicDataSource를 할당받은
				datasource Bean을 생성한다 
			- 해당 bean에서 property를 이용해 DB연동에 필요한 정보들을 직접 기술한다
				<property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"/>	
			- 출력시 @Autowired wire처리를 통해서 입력한 데이터를 출력한다.
			
		2) 외부클래스를 이용한 처리 방식
			- Text File을 생성하여 공통적으로 사용할 DB정보들을 key=value 형식으로 선언한다. (주석을 이용하여 구분하여 작성한다)
				#DB 서버 설정 정보 
				driver=oracle.jdbc.driver.OracleDriver
			- dispatcher-servlet.xml에 공통 설정 파일의 위치를 설정시킨다. 
				<context:property-placeholder location="classpath:/resource/properties/info"/>
			- 공통정보가 작성된 파일의 key를 이용하여 값을 할당한다
				<bean class="springweb.z01_vo.Person" p:name="${name1}" p:age="${age1}" p:loc="${loc1}"/> 
			- 출력시 @Value("${name}") 를 할당하여 사용한다
			
		
		공통 설정 파일 처리 방식 : 특정한 정보를 가지고 해당 내용을 파일로 저장되어
			개발 환경이 변하거나 외부 서버가 변경될 때도 효과적으로 설정을 변경처리할 수 있는 것을 말한다.
			src\resource\properties\info에 key=value 형식으로 저장하며
			컨테이너 안에서 ${키}로 호출하고 일반 클래스에서는 @Value("key") private String 변수명;
			형태로 사용할 수 있다
			
	2. 컨테이너에서 객체(Product)에 property로 할당하고, 해당 객체를 호출(autowiring)하는 내용을 A09_SettingCtrl.java를 통해서 처리하기 
		컨트롤러 : A09_SettingCtrl.java
		화면 : a21_setting.jsp
		
	3. Mybatis를 활용하여 데이터베이스를 연동하려고 한다. 기본 설정을 컨테이너, mybatis config파일, dao, XXXmapper.xml를 통해 처리할 내용 기술하기 
		Mybatis 연동하기
		컨테이너 : 
			1) web에 dispatcher 설정을 매핑시킨다음 dispathcer-servlet에 connection pool 설정 한다. 
				컨테이너나 외부 파일로 설정한 공통 정보를 가져와 DB연결에 필요한 데이터를 설정한다. 
			2) mybatis와 연동하기 위해 dbcp에 연결한 다음 mybatis config 파일의 위치를 설정한다.
		mybatis config파일 : 
			3) dao 클래스를 간편하게 사용하기 위해 alias 설정을 한다
			4) dao의 sql문을 작성하는 XXXmapper.xml을 선언하여 연결한다.
		dao : 
			5) 인터페이스 형태로 생성하여 실제 사용될 메소드의 리턴형식/메소드명/매개변수를 작성한다
		XXXmapper.xml : 
			6) dao에 작성된 내용을 토대로 sql문을 작성한다. sql문 작성시 returnType, parameterType 등 
				dao의 내용에 유의하여 작성한다.
		
	4. dept01로 복사테이블을 만들고, json Viewresolver를 활용하여 ajax로 조회 리스트 처리하기 
		
	
	*/
	
	@RequestMapping("dept01List.do")
	public String dept01List(Dept dept, Model d) {
		d.addAttribute("dept01List", service.dept01List(dept));
		return "pageJsonReport";
	}
	
	@GetMapping("dept01Show.do")
	public String dept01Show() {	
		return "a00_exp\\0927.jsp";
	}
}
