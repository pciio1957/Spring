package springWebE.a01_basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import diexp.vo.Dept;
import springWebE.z02_vo.Member;
import springWebE.z02_vo.Person;

@Controller
public class A04_ModelController {

	
	/*  ModelAttribute 
		1) 요청값과 모델데이터를 동시에 처리해준다.
		2) 컨트롤단에서 사용하는 공통 모델 데이터를 처리한다. 	
	*/
	
	@RequestMapping("modelAttr01.do")
	// http://localhost:7080/springwebE/modelAttr01.do
	public String modelAttr01(@ModelAttribute("p01") Person p) {
		return "WEB-INF\\views\\a01_basic\\a10_model.jsp";
	}
	@RequestMapping("memberReg.do")
	// http://localhost:7080/springwebE/modelAttr01.do
	public String modelAttr01(@ModelAttribute("mem") Member p) {
		return "WEB-INF\\views\\a01_basic\\a11_modelAttr.jsp";
	}
	
	// 응용) modelAttr02.do 물건 정보를 요청해서 모델명 prod로 처리하게 하기 (5조 제출, 나머지 손들기)
	@ModelAttribute("dilst")
	public ArrayList<Dept> dlist() {
		ArrayList<Dept> list = new ArrayList<Dept>();
		list.add(new Dept(10, "회계", "강남"));
		list.add(new Dept(20, "인사", "명동"));
		list.add(new Dept(30, "재무", "역삼"));
		return list;
	}
	
	
	// 응용) Member (id/pass) 입력된 ArrayList를 모델어트리뷰트(3명)을 
	//		선언하고 각 화면에서 select를 이용해 출력하기 
	@ModelAttribute("mlist")
	public List<Member> mlist() {
		List<Member> list = Arrays.asList(new Member("himan", "7777", "홍길동"),
										new Member("higirl", "8888", null),
										new Member("goodMan", "5555", "마길동"));
		return list;
	}
	
}
