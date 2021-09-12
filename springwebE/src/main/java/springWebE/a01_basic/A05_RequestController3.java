package springWebE.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 주소 : springWebE.a01_basic.A05_RequestController3
@Controller
public class A05_RequestController3 {
	
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
