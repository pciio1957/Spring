package diexp.vo9;

import org.springframework.stereotype.Component;

@Component
public class Dron extends Larba{

	public Dron() {
		super("드론", "날아다닌다");
		//super(name, work);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println(getKind() + "이 날라다닌다");
	}
	
}
