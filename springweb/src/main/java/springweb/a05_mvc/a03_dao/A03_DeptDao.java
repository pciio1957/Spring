package springweb.a05_mvc.a03_dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import springweb.z01_vo.Dept;

@Repository
public interface A03_DeptDao {

	public ArrayList<Dept> dlist(Dept dept);
	
	public void insertDept(Dept dept);
	
	public void updateDept(Dept dept);
	
	public void deleteDept(int deptno);
}
