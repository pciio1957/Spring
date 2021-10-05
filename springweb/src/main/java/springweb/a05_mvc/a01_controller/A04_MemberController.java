package springweb.a05_mvc.a01_controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springweb.a05_mvc.a02_service.A04_MemberService;
import springweb.z01_vo.Member;


@Controller
public class A04_MemberController {

	@Autowired
	private A04_MemberService service;
	
	// 0924 spring에서의 세션설정을 위해 로그인 처리 
	@ModelAttribute("member")
	public Member getMember() {
		return new Member();
	}
	
	// 묵시적 세션 설정
	// http://localhost:7080/springweb/login.do
	@RequestMapping("login.do")
	public String login(Member member) {
		return "WEB-INF\\views\\a05_mvc\\a10_login.jsp";
	}
	
	// 명시적 세션 설정
	// http://localhost:7080/springweb/login2.do
	@RequestMapping("login2.do")
	public String login2(Member member, HttpSession session) {
		if(member.getId() != null) {
			session.setAttribute("member", new Member("himan", "7777", "고길동", "관리자", 1000));
		}
		return "WEB-INF\\views\\a05_mvc\\a10_login.jsp";
	}
	
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
		return "redirect:/memberSchList.do";
	}
		
	// http://localhost:7080/springweb/deleteMember.do
	@RequestMapping("deleteMember.do")
	public String deleteMember(@RequestParam("id") String id) {
		service.deleteMember(id);
		return "redirect:/memberSchList.do";
	}
	
	// 0924 정리문제 4번 - member 등록 후 json 데이터로 화면출력
	// 1005 정리문제 4번 - member리스트를 vue로 ajax 처리하기 
	// http://localhost:7080/springweb/inserMember.do
	@RequestMapping("memberListAjax.do")
	public String memberListAjax(Member sch, Model d) {
		d.addAttribute("memList", service.memberList(sch));
		return "pageJsonReport";
	}
	
	@RequestMapping("inserMember.do")
	public String insertMemberAjax(Member ins, Model d) {
		service.insertMember(ins);
		return "redirect:/memberListAjax.do";
	}
	
	// 화면출력용 
	// http://localhost:7080/springweb/memberForm.do
	@GetMapping("memberForm.do")
	public String memberForm() {
		return "WEB-INF\\views\\a05_mvc\\a07_memberAjax.jsp";
	}
}
