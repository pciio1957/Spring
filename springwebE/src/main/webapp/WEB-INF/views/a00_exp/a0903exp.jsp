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

3. 기본 스프링 개발환경을 설정할 때 필요한 부분을 기술하기
	
4. 스프링에서 front controller란 무엇을 말하는가?
5. http://localhost:7080/springweb/call.do
	1) 7080 : 어디에서 설정하는 내용인가?
	2) springweb : 어떤 기준을 통해서 설정되는가?
	3) call.do와 연결되는 부분을 controller, view가 처리되는 과정을 
		web.xml, dispatcher-servlet.xml, controller.java, 
		화면 view.jsp 를 활용하여 기술하기 
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