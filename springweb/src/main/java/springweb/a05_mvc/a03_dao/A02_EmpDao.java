package springweb.a05_mvc.a03_dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
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
	
	// 0928 연습문제 
	public ArrayList<Emp> schJob(String job);
	public ArrayList<Emp> groupDept(double sal);
	
	public int countEmp(@Param("minsal") int minsal, @Param("maxsal") int maxsal);
	// service단 처리 : return dao.countEmp(1000, 3000);
	
	public int countEmp2(Map<String, Integer> map);
	// service단 처리 : Map<String, Integer> map = new HashMap<String, Integer>();
	// map.put("minsal", 1000);
	// map.put("maxsal", 1000);
	// return dao.countEmp2(map);
	
	/*
		응용) 다음 sql을 처리한 dao, mapper 내용 선언하기 
		
		1) select * from emp like '%'||#{job}||'@'
		결과값 : ArrayList<Emp>
		입력값 : String job
		
		2) select deptno, max(sal) sal 
			from emp 
			group by deptno
			having max(sal) > #{sal}
		결과값 : ArrayList<Emp>
		입력값 : double sal
			
		3) select count(*)
			from emp
			where sal between #{minsal} and #{maxsal}
		결과값 : int 
		입력값 : (int minsal, int maxsal) 나 (Map<String, Integer>)
			
		
	
	*/
}
