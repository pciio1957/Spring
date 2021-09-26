package springweb.a00_exp;

import java.util.ArrayList;

import springweb.z01_vo.Dept;

public class a0923exp {

	/*
		#정리문제
		1. dao와 mapper.xml의 연동 규칙을 정의해보기
		
			1) interface로 생성된 dao에 사용할 메소드를 내용없이 선언한다
			2) 해당 dao와 mapping할 XXmapper.xml을 만든다
			3) mybatis.Spring.xml에 사용할 vo를 간단히 선언하여 사용하기 위해서 
				alias를 지정해준다
			4) mybatis.Spring.xml에 만든 XXmapper.xml를 resource 선언하여
				연동한다
			5) XXmapper.xml에 dao와 연동하기 위해 mapper 선언 후 
				선언한 메소드들의 sql문을 작성한다.
				
			연동규칙
			dao.java 				mapper.xml
			패키지명.인터페이스명			namespace="패키지명.인터페이스명"
			메소드명					<select/update/delete
										id="메소드명"
			리턴타입					resultType="String/int/객체"
			매개변수유형				parameterType="매개변수유형"
			
		2. 부서정보의 조회/등록/수정/삭제 dao와 mapper.xml을 만들기
		
			dao
			public interface A03_DeptDao {
				public ArrayList<Dept> dlist();
				
				public void insertDept(Dept dept);
				
				public void updateDept(Dept dept);
				
				public void deleteDept(int deptno);
			}
			
			mapper.xml
			<mapper namespace="springweb.a05_mvc.a03_dao.A03_DeptDao">
				<select id="dlist" resultType="dept">
					select * from dept
				</select>
				
				<insert id="insertDept" parameterType="dept">
					insert into dept values(#{deptno}, #{dname}, #{loc})
				</insert>
				
				<update id="updateDept" parameterType="dept">
					update dept set dname=#{dname}, loc=#{loc} where deptno=#{deptno}
				</update>
			
				<delete id="deleteDept" parameterType="int">
					delete from dept where deptno=#{deptno}
				</delete>
			</mapper>
		
		3. 부서정보의 조회/등록/수정/삭제 MVC 패턴으로 화면단과 함께 구현하기 
			
			dao
			service
			controller
				1) 기능메소드 초기화면 호출
				2) service단 호출 model 데이터 처리
				3) 화면단에서 el, jstl을 통한 데이터처리
		
	*/
	
	
}
