package springWebE.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springWebE.z02_vo.Person;


// 생성후 클래스 등록부터! springWebE.a01_basic.A03_RequestController
@Controller
public class A03_RequestController {
	
	/*
	 #스프링의 요청값 처리 방식
	 1. 변수로 설정
	 	@RequestParam("요청key") String 요청key를 할당할 변수
	 	@RequestParam("요청key") int 요청key를 할당할 변수
	 	매개변수로 @RequestParam을 쓰면 반드시 요청값이 해당 갯수와 동일한 type으로 있어야한다
	 	
	 2. 변수로 설정하되 defalut값 설정
	 3. bean과 같이 객체로 요청값을 property로 가져오기 
	 
	 -> 스프링은 return을 통한 view 출력과 함께 forward형식으로 
	 	전달하기 때문에 요청값과 model데이터를 전달할 수 있다
	 	
	 	
	 	
	 #매개변수에 대한 option 설정
	 	- value : 요청key에 대한 설정
	 	- defaultValue : default 요청key를 설정
	 	- required : 필수 여부에 대한 설정
	 		==> 요청값이 없더라도 호출되어 처리가능하게 해준다
	 */

	

	// http://localhost:6080/springwebE/requestexp01.do
	// http://localhost:6080/springwebE/requestexp01.do?name=홍길동&price=1000&cnt=3
	@RequestMapping("requestexp01.do")
	public String requestexp01(Model d, @RequestParam(value="name", defaultValue="입력안됨", required=false) String name,
										@RequestParam(value="price", defaultValue="1000", required=true) int price,
										@RequestParam(value="cnt", defaultValue="2") int cnt) {
										// @RequestParam("price") int price, 
										// 기본 파라미터
		System.out.println("요청값의 이름" + name);
		System.out.println("요청값의 가격" + price);
		System.out.println("요청값의 갯수" + cnt);
		
		d.addAttribute("great", "안녕하세욥 요청값 연습중입니다");
		return "WEB-INF\\views\\a01_basic\\a01_request.jsp";
		// 스프링은 return을 통한 view 출력과 함께 forward형식으로
		// 전달하기 때문에 요청값과 model데이터를 전달할 수 있다
		
		
		/*
		응용) http://localhost:6080/springwebE/requestexp02.do
			?bname=자바시작&publisher=자바나라&pay=33000
			화면에 출력은 도서명 : @@@, 출판사 : @@@, 도서정보 : 도서명(33000)로
			모델로 처리하기 (5조 제출, 나머지 손들기)
			
		응용2) http://localhost:6080/springwebE/requestexp03.do?pay=5000
			=> 영화제목 : 없음, 관객수=1, 총비용=5000
			http://localhost:6080/springwebE/requestexp01.do?name=영화1&cnt=5&pay=5000
			=> 영화제목: 영화1, 관객수=5, 총비용 25000
			기본 주소로 위와 같이 입력이 되도록 작성하고 총계도 출력되도록 구현한다.
			hint) 화면에 param.@@이 아닌 모델데이터를 이용해 처리하기 (1조 제출, 나머지 손들기)
		
		*/
	}
	
	/*
	 0908 추가
	 #get/post 방식으로 요청값 받아서 처리하기 
	 1. 명시적으로 get방식으로 받을 때 처리한다
	 2. requestMapping : get/post 방식 둘 다 처리 가능, 요청값 데이터 유형이 맞을 때 가능

	*/
	
	// http://localhost:7080/springwebE/requestexp05.do?name=홍길동
	@GetMapping("requestexp05.do")
	public String requestexp05(@RequestParam("name") String name) {
		return "WEB-INF\\views\\a01_basic\\a05_request.jsp";
	}
	
	@PostMapping("requestexp06.do")
	public String requestexp06(@RequestParam("name") String name) {
		return "WEB-INF\\views\\a01_basic\\a06_request.jsp";
	}
	
	/*
	
	응용) requestexp07.do로 get방식으로 초기화면인 a07_request.jsp를 출력한 후 
		a07_request.jsp에서 선택해서 선택(get/post) 중 post일 경우 a08_request.jsp로 호출되게 하기 
		요청값은 greet로 처리하기 (3조 제출, 나머지 손들기) 	
	*/
	
	/*
	// http://localhost:7080/springwebE/requestexp07.do
	@GetMapping("requestexp07.do")
	public String requestexp07(@RequestParam("greet") String greet) {
		return "WEB-INF\\views\\a01_basic\\a07_request.jsp";
	}
	
	@PostMapping("requestexp08.do")
	public String requestexp08(@RequestParam("greet") String greet) {
		return "WEB-INF\\views\\a01_basic\\a08_request.jsp";
	}
	*/
	
	
	// 1. 요청화면 호출은 ReqeustMapping으로는 get/post 방식 둘 다 처리가 가능하지만
	// 메소드를 중복해서 선언은 불가능 하다, 단 get/post 방식을 명시적으로 선언해서 사용할 경우 가능하다.
	
	@GetMapping("requestexp07.do")
	public String requestexp07(@RequestParam(value="greet", defaultValue="") String greet) {
		// 요청값이 있어야 호출되지만 defaultVale를 선언하면 가능
		return "WEB-INF\\views\\a01_basic\\a07_request.jsp";
	}
	
	@PostMapping("requestexp07.do")
	public String requestexp08(@RequestParam(value="greet", defaultValue="") String greet) {
		return "WEB-INF\\views\\a01_basic\\a08_request.jsp";
	}
	
	// http://localhost:7080/springwebE/requestexp09.do
	// useBean과 같이 요청 객체를 선언해놓으면 요청값이 property와 동일하면 할당이 된다
	@RequestMapping("requestexp09.do")
	public String requestexp09(Model d, Person p) {
		d.addAttribute("p01", p); // 모델데이터로 전송
		return "WEB-INF\\views\\a01_basic\\a09_request.jsp";
	}
}
