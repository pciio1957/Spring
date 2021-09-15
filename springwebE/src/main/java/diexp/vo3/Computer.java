package diexp.vo3;

import java.util.ArrayList;

public class Computer {
	private String company;
	private ArrayList<PartDevice> plist;

	public Computer(String company) {
		this.company = company;
		plist = new ArrayList<PartDevice>();
	}
	
	// 자동 패키지할당 처리 
	public void textExp() {
		company = "삼성전자";
		plist.add(new Cpu());
		plist.add(new Ram());
		plist.add(new Hdd());
		showParts();
	}

	public void setPlist(ArrayList<PartDevice> plist) {
		this.plist = plist;
	}

	public void showParts() {
		System.out.println("컴퓨터 제조사 : " + company);
		System.out.println("포함된 부품들");
		
		for(PartDevice p:plist) {
			p.showDevice();
		}
	}	
}
