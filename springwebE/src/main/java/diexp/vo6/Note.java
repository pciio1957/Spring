package diexp.vo6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("not")
public class Note {
	private String nname;
	// 소스코드상에 같은 컨테이너 객체가 있으면 로딩된다.
	@Autowired
	private String owner;
	private Pencil pen;

	public Note() {
	}

	public Note(String nname, String owner) {
		this.nname = nname;
		this.owner = owner;
	}
	
	public void showNote() {
		System.out.println(" #" + owner + "의 " + nname + "# ");
		if(pen != null) {
			System.out.println(" #노트 사용펜# ");
			System.out.println(" -> " + pen.getKind());
		}
	}
	
	public String getNname() {
		return nname;
	}
	public void setNname(String nname) {
		this.nname = nname;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Pencil getPen() {
		return pen;
	}
	public void setPencil3(Pencil pen) {
		this.pen = pen;
	}
	
	public void setPen(Pencil pen) {
		this.pen = pen;
	}
	
	
}
