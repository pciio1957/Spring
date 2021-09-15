package diexp.vo9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Buyer {
	private String bname;
	@Autowired
	private Product prod;

	public Buyer() {
		;
	}

	public Buyer(String bname) {
		this.bname = bname;
	}
	
	public void showBuyer() {
		System.out.println("# 구매자의 이름 #");
		System.out.println(bname);
		if(prod != null) {
			System.out.println("물건명 : " + prod.getName());
			System.out.println("물건가격 : " + prod.getPrice());
			System.out.println("물건갯수 : " + prod.getCnt());
		}
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Product getProd() {
		return prod;
	}

	public void setProd(Product prod) {
		this.prod = prod;
	}
}
