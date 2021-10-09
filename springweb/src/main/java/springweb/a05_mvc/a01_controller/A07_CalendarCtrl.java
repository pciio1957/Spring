package springweb.a05_mvc.a01_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.a05_mvc.a02_service.A07_CalendarService;
import springweb.z01_vo.Calendar;

@Controller
public class A07_CalendarCtrl {
	
	@Autowired
	A07_CalendarService service;

	// http://localhost:7080/springweb/calendar.do
	@RequestMapping("calendar.do")
	public String calendar() {
		return "WEB-INF\\views\\a05_mvc\\a20_calendar.jsp";
	}
	
	@RequestMapping("uptcalendar.do")
	public String uptCalendar(Calendar upt, Model m) {
		service.uptCalendar(upt);
		m.addAttribute("calList", service.calList());
		return "pageJsonReport";
	};
	
	@RequestMapping("delcalendar.do")
	public String delCalendar(Calendar del, Model m) {
		service.delCalendar(del);
		m.addAttribute("calList", service.calList());
		return "pageJsonReport";
	};
}
