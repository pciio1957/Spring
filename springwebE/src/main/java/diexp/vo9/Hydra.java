package diexp.vo9;

import org.springframework.stereotype.Component;

@Component
public class Hydra extends Larba{

	public Hydra() {
		super("하이드라", "도망간다");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println(getKind() + "가 물대포 공격을 한다");
	}

}
