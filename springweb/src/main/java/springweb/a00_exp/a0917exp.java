package springweb.a00_exp;

public class a0917exp {
	
	/*
	
	#정리문제
	1. spring/mybatis 환경에서 데이터를 처리하려고 한다. 기본 처리 작업을 순서별로 기술하기 
		1) web.xml에 dispatcher-servlet.xml 등록
		2) dispatcher-servlect.xml에 mybatis 환경 설정
			- connection pool 처리
			- Mybatis와 연동
			- dao 인터페이스 페이지 폴더 위치를 설정
		3) 사용할 vo와 인터페이스 형식의 dao를 작성한다
		3) 연결한 controller, service를 작성한다
		4) 작성한 vo와 dao를 기준으로 XXXMapper.xml을 작성한 후 mybatis.Spring.xml에 등록한다	
		
		
		->풀이
		컨테이너에 등록 처리
		1) DB연동
		2) mybatis 프레임워크
				- db연결
				- mybatis 공통 파일 설정
		3) interface를 통해 만들어지는 실제 객체가 만들어지는 패키지 선언
		
		공통 mybatis 설정파일
			- vo의 alias명 설정
			- XXXmapper.xml 등록 
		4) Dao와 Mapper.xml의 연동 
			dao인터페이스명 -> namespace 
			메소드명 -> 아이디 
			
			
	2. A04_MemberDao를 통해 Member테이블의 등록/수정/삭제 처리하는 dao와 resource\memberMapper.xml를 통해서 처리하기
		
		등록 : insert into member values(#{id}, #{pass}, #{name}, #{auth}, #{point})
		수정 : update member set pass=#{pass}, name=#{name}, auth=#{auth}, point=#{point} where id=#{id}
		삭제 : delete from member where id=#{id}
		
	
	3. member리스트를 DB와 연동되어 스프링 MVC 패턴으로 name\auth를 통해 조회되도록 하기  
	
	*/

}
