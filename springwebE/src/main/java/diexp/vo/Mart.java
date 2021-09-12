package diexp.vo;

import java.util.ArrayList;

public class Mart {
	private String mname;
	private Product prod;
	private ArrayList<Product> pList;

	public Mart(String mname) {
		this.mname = mname;
		pList = new ArrayList<Product>();
	}
	
	public void show() {
		
		System.out.println("마트명 : " + mname);
		if(prod != null) {
			System.out.println("구매한 물건 정보");
			System.out.println(prod.getName());
			System.out.println(prod.getPrice());
			System.out.println(prod.getCnt());
		}
	}
	
	public void showAllProList() {
		System.out.println("마트의 물건 목록");
		if(pList.size() > 0) {
			for(Product p:pList) {
				System.out.print(p.getName() + "\t");
				System.out.print(p.getPrice() + "\t");
				System.out.print(p.getCnt() + "\n");
			}
		}
	}
	
	

	public ArrayList<Product> getpList() {
		return pList;
	}

	public void setpList(ArrayList<Product> pList) {
		this.pList = pList;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public Product getProd() {
		return prod;
	}

	public void setProd(Product prod) {
		this.prod = prod;
	}
}
