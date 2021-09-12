package springWebE.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// springWebE.a01_basic.A04_RequestController
@Controller
public class A04_RequestController {

	/*
	응용) http://localhost:6080/springwebE/requestexp02.do
		?bname=자바시작&publisher=자바나라&pay=33000
		화면에 출력은 도서명 : @@@, 출판사 : @@@, 도서정보 : 도서명(33000)로
		모델로 처리하기
		
		-> 실행시 파라미터값이 있어야 화면에 제대로 출력됨 
	*/
	@RequestMapping("requestexp02.do")
	public String requestexp02(Model m, @RequestParam("bname") String bname,
										@RequestParam("publisher") String publisher,
										@RequestParam("pay") int pay) {
		m.addAttribute("book", "응용예제입니당");
		return "WEB-INF\\views\\a01_basic\\a02_request2.jsp";
	}
}
