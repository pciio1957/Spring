package springWebE.a00_exp;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springWebE.z02_vo.Emp;
import springWebE.z02_vo.Person;
import springWebE.z02_vo.Product;

public class A0916exp {

	/*
	  
	#정리문제
	1. ModelAttribute와 ModelAndView객체의 주요 기능을 요청값, 모델, 뷰로 설정하고, 두 객체를 다 활용하여 화면을 호출해보기
		(아래)
		
		controller
		public String call(@RequestParam("name") String name, model d) {
			return "jsp 뷰화면";
		}
		
		 요청값 : @RequestParam("name") String name
		 모델데이터 : Model d
		 뷰 : jsp파일
		 
		 public ModelAndView call(@ModelAttribute("emp") Emp emp) {
		 	ModelAndView mav = new ModelAndView();
		 	return mav;
		 }
		 
		 요청값 + 모델 : @ModelAttibute로 처리
		 모델 + 뷰 : ModelAndView 
		 
		 아니면 공유해서 사용한다고 하면 같이 선언해서 사용
		
	2. Redirect와 forward의 차이점을 기술하고, 사용되는 기본형식을 기술하기
		1) Redirect는 페이지 이동시 요청값이 없는 경우 사용할 수 있는 형식
			- "redirect:/list.do"
		2) forward는 페이지 이동시 요청값이 필요한 페이지에서 사용가능한 형식 
			- "forward:/list.do"
	
	3. 회원 리스트 화면에서 회원정보를 등록 후 등록된 정보를 상세화면으로 이동하면서 회원 아이디를 넘기는 경우(forward)와 회원정보 삭제 후 회원정보 리스트 화면으로 이동하는 경우(redirect)를 나누어 처리하기 
	- memberList.do(회원리스트-메인화면)
	- memberRegister.do(회원정보 등록),
	- memberDetail.do(회원정보 상세)
	- memberDelete(회원정보 삭제)
	
	
	4. 스프링의 데이터 베이스 설정 절차(mybatis) 중 컨테이너에서 설정 내용을 간략하게 기술하기 
		dispatcher-servlet에서 설정해야하는 것
		1) DB Pool 작성
		2) my batis 설정

	5. mybatis.Spring.xml의 설정내용 기술하기
 		mybatis.Spring.xml과 empMapper.xml 설정
 		1) java 바로 하위에 resource 패키지 생성
 		2) 하위에 mybatis.Spring.xml/empMapper.xml 파일 생성 후 작성
 		3) mybatis 안에 vo 선언/XXMapper 선언
 	
	
	6. dao와 XXXMapper.xml의 설정내용의 연관관계를 기술하기  
		1) 인터페이스 형태로 DAO를 선언한다.
		2) 선언한 내용을 EmpMapper.xml에 내용을 작성해준다
			- 인터페이스이므로 사용할 sql문을 작성해준다... 
	
	
	
	*/
	
	// 1번문제
	// http://localhost:7080/springwebE/modelAttribute0916.do
	@ModelAttribute("modelAttribute0916.do")
	public List<String> listView () {
		List<String> memList = Arrays.asList(new String("길동"), new String("호동"));
		return memList;
	}
	
	// http://localhost:7080/springwebE/modelAndView0916.do
	@RequestMapping("modelAndView0916.do")
	public ModelAndView modelandV(@ModelAttribute("emp") Emp emp) {
		emp.setEname(emp.getEname() + "모델값 추가");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF\\views\\a00_exp\\a0916exp2.jsp"); // 화면단
		mav.addObject("prod", new Product("사과", 3000, 2));
		return mav;
	}
	
	// 2번
	@RequestMapping("memberList.do")
	public String memberList(@RequestParam(value="id", defaultValue="") String id) {
		System.out.println("#memList.do 호출#");
		System.out.println("#초기화면으로 리스트화면#");
		return "WEB-INF\\views\\a01_basic\\a16_memberlist.jsp";
	}
	
	@RequestMapping("memberDetail.do")
	public String memberDetail(@RequestParam(value="id", defaultValue="") String id) {
		System.out.println("#memList.do 호출#");
		System.out.println("#detail 화면#");
		return "WEB-INF\\views\\a01_basic\\a17_memberDetail.jsp";
	}
	
	@RequestMapping("memberRegister.do")
	public String memberRegister() {
		System.out.println("# 등록처리 (forward) #");
		return "forward:/memberDetail.do";
	}
	
	@RequestMapping("memberDelete.do")
	public String memberDelete() {
		System.out.println("삭제 처리(redirect");
		return "redirect:/memberList";
	}
}
