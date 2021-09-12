package diexp.vo;

import java.util.Properties;
import java.util.Set;

public class Sensor {

	// set 인터페이스가 처리되는 객체 선언과 할당 메소드 선언
	private Set<String> agent;
	
	// key/value 형식의 properties 객체 선언
	private Properties addInfo;

	public Set<String> getAgent() {
		return agent;
	}

	public void setAgent(Set<String> agent) {
		this.agent = agent;
	}
	
	public String toString() {
		return "Sensor [agent=" +agent+ ", addInfo=" +addInfo+ "]";
	}


	// properties 
	public Properties getAddInfo() {
		return addInfo;
	}

	public void setAddInfo(Properties addInfo) {
		this.addInfo = addInfo;
	}	
}
