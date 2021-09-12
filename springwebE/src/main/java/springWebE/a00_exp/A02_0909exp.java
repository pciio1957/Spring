package springWebE.a00_exp;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import springWebE.z02_vo.Product;

public class A02_0909exp {

	/*
	  
	정리문제
	1. jquery Ajax를 활용하여 회원정보를 조회/등록처리 
		controller : A27_AjaxController.java 
		view : a04_ajaxEmp.jsp
		
	2. 스프링의 요청값 get/post방식처리에 있어서 controller단과 화면단 form 설정과의 관계를 기술하기
		#get/post방식처리의 화면단 form 설정과의 관계
		 1. 명시적으로 get방식으로 받을 때 처리된다.
		 2. requestMapping : get/post 방식 둘 다 처리 가능, 요청값 데이터 유형이 맞을 때 가능
		 		메소드를 중복해서 선언은 불가능하지만, get/post 방식을 각각 명시적으로 선언해서 사용할 경우 가능
	
		1) controller단
			@requestMapping("url매핑") : get/post 둘 다 처리, 매개변수로 구분 가능
			@gepMapping("url매핑") : get방식 처리
			@PostMapping("url매핑") : get방식 처리
			
		2) form 
			1. 속성으로 method에 get/post 방식의 속성값 선언
				선언되지않으면 default로 get방식으로 전송된다
			2. 속성 action으로 "url매핑"을 선언할 수 있다
				선언하지않으면 현재 화면을 호출한 jsp나 controller단의 url매핑주소로 호출된다
				ex) login.jsp > result.jsp > default action은 login.jsp
				ex) call.do > result.jsp > default action으로는 call.do
				
		** 만약에 get방식으로 요청값을 가지고 호출되었다면 
		다시 호출될 때 post방식으로 요청
				
	3. 회원가입 입력화면을 get방식으로 호출하고, 입력처리를 post방식으로 처리하려고 한다. spring 요청방식을 통해 처리하기
	
	4. 물건등록화면에서 물건등록은 요청하여 처리하되, controller단에서 요청값을 객체로 받아서 출력되게 처리하기 
	5. DI13.java, a13.xml을 만들고 회원정보를 xml을 통해서 등록하고 등록된 내용을 DI13.java를 통해서 출력하기 
	
	*/
	
	// http://localhost:7080/springwebE/regMember.do
	@GetMapping("regmember.do")
	public String regmemberGet() {
		return "views\\a00_exp\\a0909exp1.jsp";
	}
	
	@PostMapping("regmember.do")
	public String regmemberPost() {
		return "views\\a00_exp\\a0909exp2.jsp";
	}
	
	// http://localhost:7080/springwebE/regProduct.do
	@PostMapping("regProduct.do")
	public String regProduct(Product prod, Model d){
		d.addAttribute("prod", prod);
		return "views\\a00_exp\\a0909exp1.jsp";
	}
}
