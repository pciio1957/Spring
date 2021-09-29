package springweb.a00_exp;

public class a0928exp {

	/*
	
	#정리문제
	1. 스프링에서 dao/mapper처리 연동 부분 매커니즘 기술하기
	
		1) web.xml
			dispatcher 선언
			한글인코딩 선언
		2) dispatcher-servlet.xml 
			mvc 패턴에 맞춰 구현하기 때문에 Controller, service, dao 객체의 사용 선언
			DB의 공통 정보 작성하여 선언 (컨테이너에 선언/외부 파일에 선언)
			mybatis정보를 작성할 xml파일 선언 
			인터페이스로 선언되는 dao폴더의 위치 설정
			한글인코딩과 view에 대한 선언 
		3) java 하위에 폴더 생성 (controller, service, dao, resource)
			controller, service, dao에는 클래스를 작성
			resource에는 사용할 vo의 sql문 작성할 mapper와 그런 mapper를 할당해주는 mybatis.Spring.xml파일 작성
			properties폴더를 더 추가하여 DB공통정보의 외부파일 위치
			
	
	2. 스프링 화면처리 MVC 패턴 구조에 대해 기술하기 
		
		mvc패턴 : Model-View-Controller로 로직을 처리하는 모델과 결과 화면을 보여주는 뷰가 분리되어 있다.  
			흐름 제어나 사용자의 처리 요청은 컨트롤러에 집중된다.
		1) Model : 비즈니스 영역의 상태 정보를 처리한다. 
		2) View : 비즈니스 영역에 대한 프레젠테이션 뷰(사용자가 보게될 화면)을 담당한다.
		3) Controller : 사용자의 입력 및 흐름 제어를 담당한다.
		
		
		1) url을 통해서 페이지명과 요청값을 전달 및 해당하는 메소드 호출
			// url.do?name=사과&price=2500&cnt=5
			 @RequestMapping("url.do")
			 public String call(Product d) {
			 	@RequestParam("name") String name,
			 }	 
		2) 호출된 메소드의 Model 매개변수에 d.add("모델명", "모델값");
		3) 메소드 마지막에 return 결과로 jsp/기타뷰를 호출 return "@@@.jsp"
		4) 화면단 호출 jsp 화면호출에서 el을 통해 출력처리
		
	3. 전날 게시판 기본 조회 화면 구현하기
		
		
	4. 답변형 게시판의 주요 기능 기술하기
		
		1) 게시판 리스트 조회
		2) 게시글의 상세화면 조회
		3) 게시판의 CRUD(글 작성/수정/삭제)
		4) 답글 처리
		5) 페이징
		6) 첨부파일 
		
		
		1) 게시물리스트 
			계층형 sql을 활용한 하단의 페이지별 리스트 처리 
		2) 게시물 등록
			파일 업로드
		3) 게시물 상세
			파일다운로드
			수정
			삭제
		
	5. 게시판 board 테이블의 기본적인 등록, 수정, 삭제 처리하기
	
	*/
}
