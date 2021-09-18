package springweb.a05_mvc.a03_dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import springweb.z01_vo.Emp;

// springweb.a05_mvc.a03_dao.A02_EmpDao
@Repository
public interface A02_EmpDao {
	public ArrayList<Emp> getEmpList(Emp sch);
	
	
	// 0916. 오후 2:48분 응용문제 아래의 메소드 empMapper.xml에 적용시키기 
	public void updateEmp(Emp upt);
	
	public void DeleteEmp(int empno);
	
	public ArrayList<Emp> schDept(int deptno);
}
