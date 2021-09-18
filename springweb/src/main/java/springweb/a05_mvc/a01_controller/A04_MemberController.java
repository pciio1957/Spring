package springweb.a05_mvc.a01_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springweb.a05_mvc.a02_service.A04_MemberService;
import springweb.z01_vo.Member;


@Controller
public class A04_MemberController {

	@Autowired
	private A04_MemberService service;
	
	// http://localhost:7080/springweb/memberSchList.do
	@RequestMapping("memberSchList.do")
	public String schMember(Member sch, Model d) {
		d.addAttribute("memList", service.memberList(sch));
		return "WEB-INF\\views\\a05_mvc\\a04_memList.jsp";
	}
	
	// http://localhost:7080/springweb/memberInsert.do
	@RequestMapping("memberInsert.do")
	public String insertMember(Member ins) {
		service.insertMember(ins);
		return "redirect:/memberSchList.do";
	}
	
	// http://localhost:7080/springweb/updateMember.do
	@RequestMapping("updateMember.do")
	public String updateMember(Member upt) {
		service.updateMember(upt);
		return "redirect:/updateMember.do";
	}
		
	// http://localhost:7080/springweb/deleteMember.do
	@RequestMapping("deleteMember.do")
	public String deleteMember(@RequestParam("id") String id) {
		service.deleteMember(id);
		return "redirect:/deleteMember.do";
	}
}
