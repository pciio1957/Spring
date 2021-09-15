package diexp.di20;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import diexp.vo5.Dept;
import diexp.vo5.Emp;


public class DI25_autoPackExp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("diexp\\di20\\a25_autoPackExp2.xml");

		// 응용) vo5 패키지 기준으로 a25.xml에서 컴포넌트 스캔을 처리하여 객체를 로딩하고
		//		데이터를 할당하여 출력하기 (2조, 3조 제출, 나머지 손들기)
		Emp emp = ctx.getBean("emp", Emp.class);
		emp.setEname("이길동");
		emp.setEmpno(3350);
		emp.showInfo();
		

		/*
		1. 특정한 package의 클래스에 @Component로 선언하면 해당 클래스들을 객체로 로딩한다
		2. @Component("아이디명")을 지정하면 bean의 id를 설정한 것과 동일한 효과를 볼 수 있다
		*/
		
		// @Component("d01")로 Dept클래스에 지정해줬기 때문에 getBean시 d01과 연결해야 해당 컴포넌트를 찾아 할당한다
		// 그렇게 되면 객체의 id값을 찾아서 처리할 수 있다.
		// 해당 xml에서 필터를 없애지않아도 Component로 처리됨
		Dept dept = ctx.getBean("d01", Dept.class);
		dept.setDeptno(50);
		dept.setDname("문제풀이부");
		dept.setLoc("집");
		dept.deptInfo();
		
		
		ctx.close();
		
	}
}
