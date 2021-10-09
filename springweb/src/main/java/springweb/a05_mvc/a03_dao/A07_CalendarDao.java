package springweb.a05_mvc.a03_dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import springweb.z01_vo.Calendar;

@Repository
public interface A07_CalendarDao {
	public ArrayList<Calendar> calList();
	
	public void insertCalendar(Calendar ins);
	
	public void uptCalendar(Calendar upt);
	public void delCalendar(Calendar del);
	
}
