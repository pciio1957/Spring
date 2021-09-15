package diexp.vo9;

public abstract class Larba {
	private String name;
	private String work;
	private String kind;
	/**
	 * @param name
	 * @param work
	 */
	public Larba(String name, String work) {
		this.name = name;
		this.work = work;
	}

	public void showLarba() {
		System.out.println("# 상속받은객체 #");
		System.out.println("이름 : " + name);
		System.out.println("하는일 : " + work);
	}
	
	// 추가
	public abstract void attack();

	public String getKind() {
		return kind;
	}
}
