package springWebE.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class A06_RedirectForwardCtrl {

	
	/* 

	#redirect/forward
	1. controller의 요청처리가 끝난 후, 다시 특정한 controller의 요청 url을 호출하는 경우에 사용하는데
		redirect를 요청값없이 controller의 다른 url을 호출, 
		forward는 요청값과 함께 controller의 다른 url을 호출할 때 사용된다
		ex) 등록화면 처리 후, 조회 페이지로 가는 처리를 할 때
			수정처리 후 상세화면으로 가는 처리를 할 때 
	*/
	
	// http://localhost:7080/springwebE/list.do	
	@RequestMapping("list.do")
	public String list(@RequestParam(value="sch", defaultValue="") String sch) {
		System.out.println("요청값 : " + sch);
		System.out.println("리스트 화면 호출");
		return "WEB-INF\\views\\a01_basic\\a14_list.jsp";
	}
	
	// http://localhost:7080/springwebE/insert.do	
	@RequestMapping("insert.do")
	public String insert() {
		// 등록 후 리스트 url 호출
		System.out.println("등록처리! (redirect)");
		return "redirect:/list.do";
	}
	
	// http://localhost:7080/springwebE/insert2.do	
	@RequestMapping("insert2.do")
	public String insert2() {
		// 등록 후 리스트 url 호출
		System.out.println("등록처리! (forward)");
		return "forward:/list.do";
	}
	

	
}
