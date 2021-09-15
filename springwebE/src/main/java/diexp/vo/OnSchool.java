package diexp.vo;

import java.util.Map;

/*
OnSchool클래스에 학교명, Map<Integer, Student> stus로 
	<번호, 학생정보>를 설정하여 컨테이너에 의해 데이터를 할당하여
	해당 학교, 번호, 학생정보를 출력하기 
*/
public class OnSchool {
	private String name; 
	private Map<Integer, Student> stuInfo;
	/**
	 * @param name
	 */
	public OnSchool(String name) {
		this.name = name;
	}
	public void setStuInfo(Map<Integer, Student> stuInfo) {
		this.stuInfo = stuInfo;
	}
	
	public void showInfo() {
		System.out.println("# 학교명 : " + name + " #");
		
		// stuInfo.ketSet() : map안에 있는 key만 가져와서 반복문 수행 (해당 내용만 가져옴)
		for(int no:stuInfo.keySet()) {
			Student s = stuInfo.get(no); // key를 통해서 연결된 학생정보를 가져온다
			System.out.print(no + "\t");
			System.out.print(s.getName() + "\t");
			System.out.print(s.getKor() + "\t");
			System.out.print(s.getEng() + "\t");
			System.out.print(s.getKor() + "\n");	
		}
	}
}
