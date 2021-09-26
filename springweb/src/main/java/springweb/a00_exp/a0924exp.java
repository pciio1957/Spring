package springweb.a00_exp;

public class a0924exp {

	
	/*
	
	#정리문제
	1. 스프링 MVC에서 view란 무엇인가?
		스프링에서는 Model, View, Controller로 프로그램적으로 웹 구현에 대한 역할 분담을 하고 있고
		그 중에 view는 최종 결과를 나타내는 부분으로 jsp, html과 같은 기본 웹 화면 출력과
		json 데이터 출력, pdf/excel 파일 다운로드, 첨부파일 업로드/다운로드를 할 수 있다. 
		
	2. 스프링 컨테이너의 view처리 설정 방식 기술하기
		1) 특정 뷰 선언 : dispatcher-servlet에 사용할 특정한 뷰를 선언한다
		2) 우선순위 설정 : 선언된 해당 뷰는 bean으로 생성되어 처리되며 해당 뷰의 우선순위를 최우선으로 설정하고
					나머지 .jsp로 나타나는 뷰를 후순위로 설정한다
		3) return 처리 : 선언한 뷰를 Controller의 return값으로 사용한다. 
		
		크게 2가지로 나뉠 수 있다.
		1) 일반적인 jsp 방식의 처리방법 : InternalResourceViewResolver
			객체로 선언하여 접두어/접미어 우선순위 메소드를 통해 설정할 수 있다.
		2) 그 외에 추가되는 bean이름으로 설정하기 위한 view : BeanNameViewResolver
			우선순위를 최우선으로 하고 있다.
			ex) 추가되는 bean이 json처리할 경우  <bean id="pageJsonReport"
				controller의 기능 메소드의 return값으로 
				return "pageJsonReport"; // 선언된 json뷰호출
				return "WEB-INF\\views\\a05_mvc\\a022_empListAjax.jsp"; // jsp호출
	
	3. A01_mvcController에 추가하여 Student.java를 요청값으로 등록한 내용을 jsonView를 통해 출력처리하기
		(모르겠음.. )
		
	4. 요청값을 통해 ajax로 회원등록을 하고 등록된 회원정보 dao를 통해 스프링 json 뷰로 출력하기 
		a03_dao\A04_MemberDao.java 의 기능 메소드
		public inserMember(Member m); 추가 후 db처리도 하기 
		
		1) sql 확인
		2) vo 확인
		3) dao 등록, xxxmapper 처리
		4) service단 처리
		5) controller단 화면구성 
		6) view단 처리 
	
	*/
}
