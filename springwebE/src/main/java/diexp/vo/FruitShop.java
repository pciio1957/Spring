package diexp.vo;

import java.util.Properties;
import java.util.Set;

public class FruitShop {

	private Set<String> sellList;
	private Properties fruitInfo;
	
	public Set<String> getSellList() {
		return sellList;
	}
	public void setSellList(Set<String> sellList) {
		this.sellList = sellList;
	}
	public Properties getFruitInfo() {
		return fruitInfo;
	}
	public void setFruitInfo(Properties fruitInfo) {
		this.fruitInfo = fruitInfo;
	}
	
	public void show() {
		System.out.println("# 과일가게 #");
		System.out.println("판매과일: " + sellList);
		System.out.println("과일정보: " + fruitInfo);
		
		// key를 이용해 value를 가져옴
		for(String key:sellList) {
			System.out.println(key + ":" + fruitInfo.get(key));
		}
	}
}
