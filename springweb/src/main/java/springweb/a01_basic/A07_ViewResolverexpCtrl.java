package springweb.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.z01_vo.Person;
import springweb.z01_vo.Product;

@Controller
public class A07_ViewResolverexpCtrl {

	// http://localhost:7080/springweb/jspCall.do
	@RequestMapping("jspCall.do")
	public String list() {
		System.out.println("기본 jsp 호출");
		return "WEB-INF\\views\\a01_basic\\a18_call.jsp";
		// dispatcher-servlet에 pre, suffix를 선언해서 사용하면 해당 파일명만으로 호출가능
	}
	
	// json데이터 호출
	// http://localhost:7080/springweb/jsonCall.do
	@RequestMapping("jsonCall.do")
	public String jsonCall(Model d) {
		System.out.println("기본 pageJsonReport 호출");
		d.addAttribute("p01", new Person("홍길동", 25, "서울"));
		return "pageJsonReport";
	}
	
	// 응용) http://localhost:7080/springweb/jsonCall2.do
	//		Product 객체를 활용하여 사과, 3000, 2를 jsonView로 
	//		화면에 출력하도록 하기 (4조 제출, 나머지 손들기) 
	
	// http://localhost:7080/springweb/jsonCall2.do
	@RequestMapping("jsonCall2.do")
	public String jsonCall2(Model d) {
		System.out.println("Product 객체 호출(JSON)");
		d.addAttribute("pro01", new Product("사과", 3000, 2));
		return "pageJsonReport";
	}
}
