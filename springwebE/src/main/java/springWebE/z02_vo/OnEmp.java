package springWebE.z02_vo;

import java.util.Map;

public class OnEmp {
	private String ename;
	private Map<Integer, Emp> empInfo;

	public OnEmp() {
	}
	
	public OnEmp(String ename) {
		this.ename = ename;
	}

	public void showInfo() {
		System.out.println("# 사원정보 #");
		System.out.println("사원이름 : " + ename);
		
		for(int e:empInfo.keySet()) {
			Emp emp = empInfo.get(e);
			System.out.println("사원번호 : " + emp.getEmpno());
			System.out.println("사원직급 : " + emp.getJob());
			System.out.println("사원월급 : " + emp.getSal());
		}	
	}

	public void setEmpInfo(Map<Integer, Emp> empInfo) {
		this.empInfo = empInfo;
	}
	
	
}
