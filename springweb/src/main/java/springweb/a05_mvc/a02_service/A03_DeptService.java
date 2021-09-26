package springweb.a05_mvc.a02_service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springweb.a05_mvc.a03_dao.A03_DeptDao;
import springweb.z01_vo.Dept;

@Service
public class A03_DeptService {
	@Autowired
	private A03_DeptDao dao;
	public ArrayList<Dept> dlist(Dept dept){
		// null값 처리방식 2번) service단에서 null확인 후 값 변경
		if(dept.getLoc()== null) {
			dept.setLoc("");
		}
		return dao.dlist(dept);	
	}
	
	public void insertDept(Dept dept) {
		dao.insertDept(dept);
	}
	
	public void updateDept(Dept dept) {
		dao.updateDept(dept);
	}
	
	public void deleteDept(int deptno) {
		dao.deleteDept(deptno);
	}
}
