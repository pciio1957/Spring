package springweb.a05_mvc.a02_service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springweb.a05_mvc.a03_dao.A07_CalendarDao;
import springweb.z01_vo.Calendar;

@Service
public class A07_CalendarService {

	@Autowired
	A07_CalendarDao dao;
	
	public ArrayList<Calendar> calList() {
		return dao.calList();
	}
	
	public void insertCalendar(Calendar ins) {
		dao.insertCalendar(ins);
	}
	
	public void uptCalendar(Calendar upt) {
		
		System.out.println("id값 : " + upt.getId());
		System.out.println("id값 : " + upt.getStart());
		dao.uptCalendar(upt);
	};
	public void delCalendar(Calendar del) {
		dao.delCalendar(del);
	};
}
