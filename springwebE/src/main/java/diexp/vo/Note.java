package diexp.vo;

public class Note {
	private String nname;
	private String owner;
	private Pencil pen;
	
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
	public void setPen(Pencil pen) {
		this.pen = pen;
	}
	

	
	
}
