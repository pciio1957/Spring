package diexp.di20;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import diexp.vo.Person;

@Configuration
public class Con20 {

	public Con20() {
		
	}
	
	@Bean
	public Person getPerson() {
		Person p01 = new Person();
		p01.setName("홍길동");
		return p01;
	}

}
