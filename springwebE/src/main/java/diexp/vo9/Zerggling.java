package diexp.vo9;

import org.springframework.stereotype.Component;

@Component
public class Zerggling extends Larba {

	public Zerggling() {
		super("저글링", "공격한다");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println(getKind() + "이 근접에서 빠른 공격을 하다");
	}

}
