package springWebE.a05_mvc.a02_service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springWebE.a05_mvc.a03_dao.A02_EmpDao;
import springWebE.z02_vo.Emp;

@Service
public class A02_EmpService {
	@Autowired
	private A02_EmpDao dao;
	public ArrayList<Emp> getEmpList(){
		return dao.getEmpList();
	}
}