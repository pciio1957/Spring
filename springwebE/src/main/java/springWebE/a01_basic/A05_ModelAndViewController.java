package springWebE.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springWebE.z02_vo.Person;

@Controller
public class A05_ModelAndViewController {

	
	/*  ModelAndViewController 
		1) 모델과 뷰를 같이 사용할 수 있는 객체를 말한다.	
	*/
	
	// http://localhost:7080/springwebE/modelAndView01.do	
	@RequestMapping("modelAndView01.do")
	public ModelAndView modelAttr01() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF\\views\\a01_basic\\a12_modelAndView.jsp"); // 화면단
		mav.addObject("msg", "모델 호출");
		return mav;
	}
	
	
	// 응용) http://localhost:7080/springweb/modelAndView2.do를 통해서
	//		a13_modelAndView.jsp를 처리하기
	//		모델데이터는 Person 객체의 이름, 나이, 사는 곳을 설정하기 (4조 제출, 나머지 손들기)
	
	// http://localhost:7080/springwebE/modelAndView02.do	
	@RequestMapping("modelAndView02.do")
	public ModelAndView modelAttr02() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF\\views\\a01_basic\\a13_modelAndViewExp.jsp");
		mav.addObject("p01", new Person("홍길순", 20, "홍대"));
		return mav;
	}
	
}
