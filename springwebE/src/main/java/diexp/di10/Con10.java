package diexp.di10;

import org.apache.jasper.tagplugins.jstl.core.Set;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import diexp.vo.Bus;
import diexp.vo.Person;

@Configuration
public class Con10 {

	public Con10() {
		
	}
	
	@Bean
	public Person getPerson() {
		Person p01 = new Person();
		p01.setName("홍길동");
		return p01;
	}
	
	@Bean
	public Bus getBus() {
		Bus bus01 = new Bus();
		//Set<String> busNumber1 = null;
		//bus01.setBusNumber();
		return bus01;
	}

}
