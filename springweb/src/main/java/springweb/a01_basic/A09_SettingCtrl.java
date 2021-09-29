package springweb.a01_basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import springweb.z01_vo.Student;

@Controller
public class A09_SettingCtrl {

	@Autowired
	private Student stud;
	
	// http://localhost:7080/springweb/setStud.do
	@GetMapping("setstud.do")
	public String setStud(Model d) {
		d.addAttribute("stud", stud);
		return "WEB-INF\\views\\a01_basic\\a21_setting.jsp";
	}
	
}
