package springWebE.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// springWebE.a01_basic.A04_RequestController
@Controller
public class A0302_RequestControllerExp {

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
	
	
	/*
	 	응용2) http://localhost:6080/springwebE/requestexp03.do?pay=5000
		=> 영화제목 : 없음, 관객수=1, 총비용=5000
		http://localhost:6080/springwebE/requestexp01.do?name=영화1&cnt=5&pay=5000
		=> 영화제목: 영화1, 관객수=5, 총비용 25000
		기본 주소로 위와 같이 입력이 되도록 작성하고 총계도 출력되도록 구현한다.
		hint) 화면에 param.@@이 아닌 모델데이터를 이용해 처리하기 (1조 제출, 나머지 손들기)
	*/

	@RequestMapping("requestexp03.do")
	public String requestexp03(Model m, @RequestParam(value="name", defaultValue="없음") String name, 
									@RequestParam(value="cnt", defaultValue="1") int cnt,
									@RequestParam(value="pay", required=true) int pay) {
			
		m.addAttribute("movie", "영화보러왔씁니다!");
		m.addAttribute("name", name);
		m.addAttribute("cnt", cnt);
		m.addAttribute("sum", cnt * pay);
		return "WEB-INF\\views\\a01_basic\\a03_request3.jsp";
}
}
