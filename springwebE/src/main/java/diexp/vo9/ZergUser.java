package diexp.vo9;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ZergUser {
	private String name;

	private Larba unit;

	public ZergUser() {
		name = "저거유저1"; // default 이름
	}
	
	public void playGmaes() {
		System.out.println("player : " + name);
		if(unit != null) {
			unit.attack();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Larba getUnit() {
		return unit;
	}

	public void setUnit(Larba unit) {
		this.unit = unit;
	}

}
