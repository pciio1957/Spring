package diexp.di10;

import diexp.vo.Note;
import diexp.vo.Pencil;

public class Con18 {

	// xml된 container 선언 방식 -> java 클래스로 된 container 선언방식 
	public Note getNote() {
		Pencil pc = new Pencil("HB");
		Note nt = new Note("수업 필기용 노트", "홍길동");
		nt.setPen(pc);
		return nt;
	}
}
