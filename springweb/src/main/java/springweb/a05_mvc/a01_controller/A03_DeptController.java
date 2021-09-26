package springweb.a05_mvc.a01_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springweb.a05_mvc.a02_service.A03_DeptService;
import springweb.z01_vo.Dept;

@Controller
public class A03_DeptController {
	// 컨테이너의 객체끼리 자동 메모리 할당으로 처리한다.
	@Autowired
	private A03_DeptService service;
	// http://localhost:7080/springweb/deptList.do
	@RequestMapping("deptList.do")
	public String mvc01(Dept dept, Model d) {
		d.addAttribute("deptList", service.dlist(dept));
		return "WEB-INF\\views\\a05_mvc\\a03_deptList.jsp";
	}
	
	@RequestMapping("insertDept.do")
	public String insertDept(Dept dept) {
		System.out.println("등록할 번호 : " + dept.getDeptno());
		service.insertDept(dept);
		return "redirect:/deptList.do";
	}
	
	@RequestMapping("updateDept.do")
	public String updateDept(Dept dept) {
		System.out.println("수정할 번호 : " + dept.getDeptno());
		service.updateDept(dept);
		return "redirect:/deptList.do";
	}
	
	@RequestMapping("deleteDept.do")
	public String deleteDept(@RequestParam("deptno") int deptno) {
		System.out.println("삭제할 번호 : " + deptno);
		service.deleteDept(deptno);
		return "redirect:/deptList.do";
	}
	
	
	/*
 	EX) 부서정보를 KEYUP으로 검색 처리. 5조
 	1) 초기화면 호출 http://localhost:7080/springweb/deptForm.do
 	   	a05_deptList.jsp
 	   	
 	   	WEB-INF\views\a05_mvc\a05_deptList.jsp
 	2) ajax 처리  http://localhost:7080/springweb/deptListAjax.do
 	3) 화면단 jquery Ajax 처리(a05_deptList.jsp)
 	  	
	*/	
	
	
	// http://localhost:7080/springweb/deptForm.do
	@RequestMapping("deptForm.do")
	public String deptForm() {
		return "WEB-INF\\views\\a05_mvc\\a05_deptList2.jsp";
	}	
	// http://localhost:7080/springweb/deptAjax.do
	@RequestMapping("deptAjax.do")
	public String deptAjax(Dept sch, Model d) {
		d.addAttribute("deptList", service.dlist(sch));
		return "pageJsonReport";
	}	

	
}
