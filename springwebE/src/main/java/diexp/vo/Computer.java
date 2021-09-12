package diexp.vo;

import java.util.ArrayList;

public class Computer {
	private String company;
	private ArrayList<PartDevice> plist;

	public Computer(String company) {
		this.company = company;
		plist = new ArrayList<PartDevice>();
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
