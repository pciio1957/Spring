package diexp.vo;

import java.util.Properties;
import java.util.Set;

/*  Bus클래스에 Set<String> 버스번호 Properties를 시작/종점을 처리하게 하고 
	Container에 설정하여 처리하기. 
	main\java\diexp\Con10.java(자바형 컨테이너)를 설정해서 처리되게 하기 */

// 주소 : diexp.vo.Bus
public class Bus {
	private Set<String> busNumber;
	private Properties section;
	private Driver driver;
	
	public Bus() {
	}
	
	public Set<String> getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(Set<String> busNumber) {
		this.busNumber = busNumber;
	}
	public Properties getSection() {
		return section;
	}
	public void setSection(Properties section) {
		this.section = section;
	}
	
	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public String toString() {
		return "버스번호 = [" + busNumber + "], 추가정보 = [" + section + "]";
	}
	
	public String showDriver() {
		return "버스번호 = [" + busNumber + "}, 운전기사 = [" + driver + "]";
	}
	
	public void showBusInfo() {
		System.out.println("버스번호 [" + busNumber + "]");
		if(driver != null) {
			
		}
	}
}
