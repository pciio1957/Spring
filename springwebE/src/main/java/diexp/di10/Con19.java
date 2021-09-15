package diexp.di10;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.annotation.Bean;

import diexp.vo.Bus;
import diexp.vo.Note;
import diexp.vo.Pencil;

public class Con19 {

	// xml된 container 선언 방식 -> java 클래스로 된 container 선언방식 
	public Note getNote() {
		Pencil pc = new Pencil("HB");
		Note nt = new Note("수업 필기용 노트", "홍길동");
		nt.setPen(pc);
		return nt;
	}
	
	@Bean
	public Bus getBus() {
		Bus b1 = new Bus();
		b1.setBusNumber(null);
		// Set이 인터페이스라서 객체 생성을 못하므로 HashSet이용
		Set<String> sets = new HashSet<String>(); 
		sets.add("7780");
		sets.add("7790");
		sets.add("7800");
		
		
		Properties props = new Properties();
		props.setProperty("7780", "서울~수원");
		props.setProperty("7790", "서울~인천");
		props.setProperty("7800", "하남~서울");
		
		b1.setBusNumber(sets);
		b1.setSection(props);
		
		
		return b1;
	}
}
