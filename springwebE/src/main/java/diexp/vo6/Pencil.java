package diexp.vo6;

import org.springframework.stereotype.Controller;

@Controller
public class Pencil {
	private String kind;


	public Pencil(String kind) {
		this.kind = kind;
	}


	public String getKind() {
		return kind;
	}


	public void setKind(String kind) {
		this.kind = kind;
	}
}
