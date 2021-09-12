<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import = "java.util.*"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  

<c:set var="path" value="${pageContext.request.contextPath}"/>
<fmt:requestEncoding value="utf-8"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Front 연습</title>
<link rel="stylesheet" href="${path}/z00_com/a01_com.css">
<style>

table {
	width:70%;
	margin-bottom:20px;
	padding:20px;
}

td {
	text-align:center;	
}

</style>
</head>
<%-- 

#정리문제
1. $("form").serialize()는 어떤 역할을 하는지 기술하기
	form 요소에 작성된 내용들을 json 데이터 형식으로 만들어준다
	
	form객체의 내용을 ajax에서 요청값으로 처리할 때 보다 효과적으로 key=value 형식으로 처리하기 위한 메소드
	form 하위에 있는 모든 요소들이 name, value 속성을 한글 encoding까지 처리하여 key1=value&key2=value 
	형식으로 만들어주는 메소드이다 
	
2. ajax로 하나의 프로그램을 처리(등록, 수정, 삭제)할 때 필요한 내용을
js단, controller, service, dao단으로 나누어 설명하기
	1) controller
		- 화면의 구분을 위한 hidden 요청값을 입력받는 변수를 생성한 뒤 
		해당 변수 데이터의 유무로 초기화면 설정
		- ajax는 json데이터를 이용하여 구현되므로 model데이터 선언X
			=> 이경우 service단에서 Gson라이브러리를 이용해 json데이터 변환 필요
		- hidden값을 통해 제어를 하기 때문에 조건식을 이용해 화면 제어
	2) view (js)
		- 초기화면으로 설정된 화면에서는 UI 작성 후 이벤트가 일어나는 부분에
			form으로 작성하여 <input type="hidden" name="proc"/> 선언
		- 수정/삭제의 경우 변경할 데이터가 있어야하므로 특정 데이터를 검색하는 부분 추가
			원하는 데이터가 오면 수정/삭제를 눌러 이벤트 처리
		- 등록의 경우 비어있는 폼에 작성한 후 작성된 데이터를 등록하는 이벤트 처리 
		- 이때 json을 이용하기 때문에 $("form").serialize(); 를 통해 
			입력한 데이터를 json 데이터로 변환해줘야한다
	3) service
		- view에서 데이터를 조회할 경우 toJson을 통해서 
			데이터를 변환하여 전송 
		- 등록/수정/삭제의 경우 view에서 변환되어온 데이터를
			각각 프로세스에 맞는 dao의 메소드 호출로 처리 
	4) dao
		- DB 처리가 필요한 데이터들의 처리로 조회/등록/수정/삭제 처리를 한다
		
		
	기능버튼을 통한 처리
	1) 클릭시
		- <input type="hidden" name="proc"/> 생성
			$("[name=proc]").val("등록/수정/삭제 구분값 설정");  
		- ajax를 위한 XMLHttpRequest 객체 생성
		- xhr.open
		- xhr.send
		- xhr.onreadystatechange = function() { /내용.. }
		
	2) controller (호출 uri = @@@.do)
		- 요청값 처리 (request.getParameter()) 
			여러 기능일때 요청 proc를 받아온다
		- proc의 조건에 따라서 service단의 메소드 호출
	
	3) service -> dao 호출
		- 요청값을 받아 dao 호출
		- dao의 결과메소드 객체 gson 객체에 의해 json 데이터로 변환 후 return 처리
	
	4) controller (service에서 return된 json 데이터)
		- response.getWriter().print(service.기능메소드()) 기능메소드를 통해 리턴된 데이터를 client에 출력
		
	5) view
		- xhr.responseText를 이용해서 out.print("json 데이터")로 변환된 문자열을 받는다
		- var obj = JSON.parse(xhr.responseText) 이렇게 객체를 받아서 객체의 데이터를 활용하여 출력

3. 기본 스프링 개발환경을 설정할 때 필요한 부분을 기술하기
	1) 추가 lib 추가 - maven(pom.xml), gradle은 온라인 상으로 받아서 처리할 수 있게 한다
		- springweb\src\main\webapp\WEB-INF\lib에 추가
	2) web.xml : 스프링 기본 구조 선언
		(컨테이너, front controller 선언)
		
	
4. 스프링에서 front controller란 무엇을 말하는가?
	1) 스프링에서 모든 요청 페이지가 호출되면 처리되는 컨테이너(dispatcher-servlet.xml)과
		연결되어 있는 컨트롤러를 말한다
	2) 요청값이 나 세션, 모델 처리등을 효과적으로 처리할 수 있게 spring 프레임워크에서 지원하고 있다
		org.springframework.web.servlet.DispatcherServlet
	3) web.xml에서 선언하고 url 패턴 방식이나 컨테이너를 호출할 수 있게 한다
		
	*주의 : front controller 단에서 servlet이 실행되기에 일반적으로 정의된 
		controller에서 실행해서 화면을 호출할 수 없다. 다만 url을 통해서 호출 가능하다
		http:/localhost:7080/springwebE/start.do
		@GetMapping("start.do")
		

5. http://localhost:7080/springweb/call.do
	1) 7080 : 어디에서 설정하는 내용인가?
		tomcat 서버의 http/1.1 port 설정 부분과 동일하여야 한다
	2) springweb : 어떤 기준을 통해서 설정되는가?
		프로젝트명으로 context명으로 설정된 것을 말한다
		<contex docBase="springweb" path="\springweb" path="/springweb"
	3) call.do와 연결되는 부분을 controller, view가 처리되는 과정을 
		web.xml, dispatcher-servlet.xml, controller.java, 
		화면 view.jsp 를 활용하여 기술하기 
		
		 
	    
		- web.xml : <servlet-mapping>
			   		 <servlet-name>
			   		 <url-pattern>
			.do로 끝나는 url은 front컨트롤단으로 처리되고
			dispatcher-servlet.xml 에 등록된 해당 패턴의 컨트롤러의 메소드를 찾는다
			
		- dispatcher-servlet.xml : 
			일단 컨트롤러 클래스가 패키지명과 클래스명으로 등록되어 있어야 하고
			해당 기능 메소드를 찾아간다 
			=> tomcat이 로딩되고 해당 url을 호출하는 순간 등록된 모든 클래스는 메모리에
				로딩되어 객체가 생성된 상태에서 시작한다
			=> 추후에는 자동등록 설정값으로 특정 패키지와 @(어노테이션) 패턴으로 등록된다 
			
		- controller의 메소드 
			@Controller로 되어있고 각 메소드의 상단에 해당 url패턴이 설정되어 있어야지
			해당 기능 메소드를 찾아간다.
			상단에 @GetMapping("call.do")	
			
			메소드에 public String call(Model d) {
				d.addAttribute("모델명", 객체);
				return "화면jsp 호출"; // forward 방식으로 특정view를 호출한다
			}
			
		
6. springweb2로 다이나믹 웹 프로젝트를 만들고 
	http://localhost:7080/springweb2/restart.do로 
	모델데이터가 출력되는 스프링환경의 화면을 구현하기 

--%>
<%

%>
<script src="${path}/z00_com/jquery-3.6.0.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){

	});
</script>
<body>
	<h2 align="center"></h2>
	<form id="frm01">
	<table align="center" class="listTable">
		<tr><th>사원명</th><td><input type="text" name="ename" value=""/></td></tr>
		<tr><td colspan="2" style="text-align:center">
			<input type="submit" value="검색"/>
		</td></tr>
	</table>	
	</form>
	
	<table align="center" class="listTable">
		<tr><th></th><th></th><th></th></tr>
		<tr><td></td><td></td><td></td></tr>
	</table>	
	
</body>
</html>