package springWebE.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


//컨테이너에 포함시킬 controller
// springWebE.a01_basic.A01_StartCtrl

@Controller
public class A01_StartCtrl {
	// http://localhost:6080/springwebE/start.do
	@GetMapping("start.do")
	public String start(Model d) {
		// 모델 데이터 선언
		d.addAttribute("start", "어서오세요! 스프링 시작입니다!");
		
		// view단 호출 
		return "WEB-INF\\views\\a01_start.jsp";
		
		
	}
	
	/* 응용) A02_SecondCtrl.java
			http://localhost:6080/springwebE/second.do
			"두번째 스프링! 친숙합니까?" 출력하기 
			"WEB-INF\\views\\a02_second.jsp"
			(4조 제출, 나머지 손들기)
	*/
}

