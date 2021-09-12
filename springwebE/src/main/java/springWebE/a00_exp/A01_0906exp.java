package springWebE.a00_exp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class A01_0906exp {
// 주소 : springWebE.a00_exp.A01_0906exp
	
	/*
	
	#정리문제 
	5. dynamic web 개발환경에서 spirng환경으로 처리하기 위한 필요한 내용을 기술하기
		1) WEB-INF 하위에 dispatcher-servlet.xml, web.xml 작성하기 
		2) WEB-INF > lib 에 spring에서 사용하는 라이브러리 넣기 
		3) 별개의 폴더에 부트스트랩이나 제이쿼리 js파일 저장 
		
	6. spring의 요청값과 모델 처리 기본 코드를 설명하기
		spring의 요청값 처리 
		1) 매개변수 부분에 변수로 선언
			@RequestParam("요청key") String 요청key를 할당할 변수
		2) 변수의 디폴트값 지정
		3) bean을 이용해 객체로 값 지정
		4) 매개변수에 대한 option 설정	
		 	- value : 요청key에 대한 설정
		 	- defaultValue : default 요청key를 설정
		 	- required : 필수 여부에 대한 설정
		 		==> 요청값이 없더라도 호출되어 처리가능하게 해준다
	
	7. 아래 주소를 통해 내용이 처리되게 하기 
	http://localhost:6080/springwebE/requestexp04.do
	-> 이름:익명, 나이:0, 사는곳:입력필요
	http://localhost:6080/springweb/requestexp04.do?name=홍길동&age=25&loc=서울신림동
	-> 이름:홍길동, 나이:25, 사는곳:서울신림동

	*/
	
	
	@RequestMapping("requestexp04.do")
	public String request04(Model m, @RequestParam(value="name", defaultValue="익명") String name,
										@RequestParam(value="age", defaultValue="0") int age,
										@RequestParam(value="loc", defaultValue="입력필요") String loc) {
		m.addAttribute("memberCk", "회원정보 확인중입니다");
		m.addAttribute("name", name);
		m.addAttribute("age", age);
		m.addAttribute("loc", loc);
		return "WEB-INF\\views\\a00_exp\\a0906exp.jsp";
	}

}
