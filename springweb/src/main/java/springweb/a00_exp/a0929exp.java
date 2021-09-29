package springweb.a00_exp;

public class a0929exp {

	/*
		#정리문제
		1. 게시판 board 테이블의 기본적인 등록처리 순서 기술하기
			board 등록 처리
			1) dao에 insert()메소드 선언 후 boardMapper.xml에 sql문 작성하기
			2) controller에서 insert()메소드를 작성한 후 화면출력은 원래의 LIST화면으로 설정(redirect)
			3) List화면에서 등록버튼을 누르면 창이 뜨도록 버튼 생성, js 이벤트 작성
			4) jsp 파일 생성 후 등록화면 작성, 등록화면에서 등록버튼을 누르면 db에 등록완료
			5) controller에 해당 등록창에 대한 메소드를 작성해서 List화면에서 등록 누르면 뜨도록 설정
			
			
			등록처리 순서
			1) 데이터베이스 처리 파트
			등록 sql 작성 - insert into 테이블 values()
			vo 작성(전달 데이터) - 결과값, 입력/수정/삭제, 조회조건
			dao/mapper 작성 (sql <--> 객체/변수)
				dao명/namespace, 메소드명/id, 리턴유형/resultType, 매개변수유형/parameterType
				
			2) 서버단 처리 파트
			service : dao 호출
			controller : 요청값, 모델데이터
				service 호출, 서비스에서 데이터모델로 처리
				뷰호출
			ex) 리스트 화면에서 입력화면 호출 controller 기능 메소드
				리스트 화면에서 이벤트를 통해 입력 화면 호출
				입력 화면에서 데이터를 등록할 요청 처리 
				
			3) 화면 구현 파트 
			js - 유효성 check/기타 서버에 전달되기 전에 처리할 내용 구현
			form - name/value 요청값 전달 action="컨트롤러 호출"
				${모델데이터} <c:forEach var="" items="${모델명}">
			
			
		2. 스프링의 요청값/모델데이터처리/화면처리의 주요 코드 기술하기
			스프링 controller에서의 주요 처리방법
			0) url호출 : @RequestMapping(params="method=list")
				
				contorller 상단 : @RequestMapping("board.do")
				http://localhost:7080/board/board.do?method=list
			
			1) 요청값 : 메소드의 매개변수로 요청값 처리
				public String showMember(Member m) {}
				public String showMember(RequestParam("요청키") String 요청키변수, Model d) {}
				
			2) 모델데이터 처리 : 화면에 처리할 데이터를 모델데이터로 처리
				public String showMemberList(Model d, Member m) {
					d.addAttribute("list", service.showMemberList(m));
				} 
			3) 화면처리 : 메소드의 리턴값을 화면으로 지정해 로직결과로 화면이 출력되도록 설정
				public String showMemberFrm(Model d) {
					d.addAttribute("list", service.showMemberList(m));
					return "memberList.jsp";
				}
				jsp에서 <c:forEach var="board" items="${list}">
				
				
			ex) 1) public String showMember(RequestParam("no") String no, Model d) {}
				2) d.addAttribute("list", service.showMemberList(no));
				3) jsp에서 <c:forEach var="board" items="${list}">
					${board.no} ${board.subject}..
			
				
		3. url 주소가 정확한 경우에도 controller의 url을 찾지 못하는 못하는 경우(404)가 있다. 어떤 경우인지 기술하기 
			404에러 원인
			1) @Controller 어노테이션 설정을 안한 경우
			
			에러가 난 경우 확인 순서
			1) console 화면을 일단 확인
				서버가 켜져있는지? main\java\log4j.properties 에서 제공하는 내용 확인
				아래의 4개 정보를 표기해주기 때문에 확인 
			2) url 호출시 확인되는 내용
				- controller가 컴파일이 안되서 변경된 url이 반영이 안된 경우
					jdk version이 맞지않아서 
					tomcat version/
					상단메뉴 > Project > build automatically unchecked
					=> 위 내용을 처리하고
						tomcat 서버 오른쪽 마우스 클릭해서 clean이나 tomcat 새로 설치
				- url 주소
					url 주소 확인
				- 요청값 
					<input name="no" value=""/> 으로 작성하면 ?no=& 이렇게 처리됨
					form(@RequestParam(no)) int no도 위와 같음 
					=> 100% 404에러 발생 
					
					form(Board d) {}
					class Board {
						private int no;
						// int no가 ""이거나 null인 경우 에러발생
						public void setNo(int no) {}
					}
					
					=> <input name="no" value="0"> 으로 초기값 설정하거나
					아예 해당 선언부분을 삭제하거나 hidden으로 처리해야함 
					
				- 뷰단에 호출
					return ".jsp" : 해당 jsp 파일명이 잘못 되어있을때
			
		
		4. vue의 MVVM 패턴으로 이름/나이/사는 곳을 출력해보기
		
		
	*/
	
	
}
