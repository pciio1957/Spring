package springWebE.a05_mvc.a03_dao;

import java.util.ArrayList;

import springWebE.z02_vo.Emp;

public interface A01_CommDao {

	public ArrayList<Emp> empList();
	// 실체를 상속받는 객체는 framework에서 만들어준다
	// mybatis frame (xml로 설정된 내용)을 기준으로 실제 
	// 객체를 만들어준다
}
