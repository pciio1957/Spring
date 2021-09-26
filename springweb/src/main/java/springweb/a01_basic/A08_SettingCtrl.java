package springweb.a01_basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import springweb.z01_vo.Person;

// 컨테이너에 포함시키리 controller 
// springweb.a01_basic.A01_StartCtrl
@Controller
public class A08_SettingCtrl {

	
	// 환경설정으로 설정된 내용 처리 
	@Value("${upload1}")
	private String upload1;
	
	// http://localhost:7080/springweb/setting01.do
	@GetMapping("setting01.do")
	public String start(Model d) {
		
		// 모델 데이터 선언
		d.addAttribute("upload1", upload1);
		
		// view단 호출 
		return "WEB-INF\\views\\a01_basic\\a19_setting.jsp";
	}
	
	// 응용) info 파일에 name, age, loc을 설정한 후 
	//		화면에 a20_setting.jsp에 출력하기 (4,5조 제출, 나머지 손내리기)

	// 1. info에 있는 변수선언
	@Value("${name}")
	private String name;
	
	@Value("${age}")
	private int age;
	
	@Value("${loc}")
	private String loc;
	
	// 컨테이너 값 자동 할당
	@Autowired
	private Person person;
	
	// http://localhost:7080/springweb/setting02.do
	// 2. 모델데이터 선언
	@GetMapping("setting02.do")
	public String start2(Model d) {
		d.addAttribute("name", name);
		d.addAttribute("age", age);
		d.addAttribute("loc", loc);
		
		// Person 객체 하나로 모델데이터를 넘기는게 효율적
		d.addAttribute("p01" , new Person(name, age, loc));
		
		// 컨테이너에 설정한 값 받아오기
		d.addAttribute("p02", person);
		
		return "WEB-INF\\views\\a01_basic\\a20_setting.jsp";
	}
	
}
