<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>     
<!DOCTYPE html>
<%--


 --%>
<html>
<head>
<meta charset="UTF-8">
<title>부서 정보 확인 시스템</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		// 테이블의 tr을 클릭했을 때 상세정보 출력
		$(".data").click(function(){
			$("#exampleModalLongTitle").text("부서 상세 정보");
			var deptno = $(this).children(0).eq(0).text();
			var dname = $(this).children(0).eq(1).text();
			var loc = $(this).children(0).eq(2).text();
			
			$("#frm11 [name=deptno]").val(deptno);
			$("#frm11 [name=dname]").val(dname);
			$("#frm11 [name=loc]").val(loc);
			
			$("#deptRegBtn").hide();
			$("#deptUptBtn").show();
			$("#deptDelBtn").show();
		});
		
		// 화면의 등록버튼을 클릭했을 때 
		$("#regBtn").click(function(){
			$("#exampleModalLongTitle").text("부서 정보 등록");
			$("#deptRegBtn").show();
			$("#deptUptBtn").hide();
			$("#deptDelBtn").hide();
			
			// 상세화면 확인 후 등록 처리할 때 초기값으로 설정하기 
			$("#frm11 input").val("");
		});
		
		$("#deptRegBtn").click(function(){
			if(confirm("등록하시겠습니까?")){
				$("#frm11").attr("action", "${path}/insertDept.do");
				$("#frm11").submit();
			}
		});
		
		$("#deptUptBtn").click(function(){
			if(confirm("수정하시겠습니까?")){
				$("#frm11").attr("action", "${path}/updateDept.do");
				$("#frm11").submit();
			}
		});
		
		$("#deptDelBtn").click(function(){
			if(confirm("삭제하시겠습니까?")){
				$("#frm11").attr("action", "${path}/deleteDept.do");
				$("#frm11").submit();
			}
		});
		
		
	});
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2>부서 정보 확인 시스템</h2>

</div>
<div class="container">
    <h2 align='center'></h2>
	<form id="frm01" class="form-inline"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input class="form-control mr-sm-2" placeholder="부서명 입력" name="dname" value="${param.dname}"/>
	    <input class="form-control mr-sm-2" placeholder="위치 입력" name="loc" value="${param.loc}"/>
	    <button class="btn btn-info" type="submit">조회</button>
	    <button class="btn btn-info" type="button" id="regBtn"
	    	data-toggle="modal" data-target="#exampleModalCenter">등록</button>
 	</nav>
	</form>
   <table class="table table-hover table-striped">
   	<col width="33%">
   	<col width="33%">
   	<col width="33%">
    <thead>
    
      <tr class="table-success text-center">
        <th>부서번호</th>
        <th>부서명</th>
        <th>부서위치</th>
      </tr>
    </thead>	
    <tbody>
    	<c:forEach var="dept" items="${deptList}">
    		<tr class="data text-center" data-toggle="modal" data-target="#exampleModalCenter">
    			<td>${dept.deptno}</td>
    			<td>${dept.dname}</td>
    			<td>${dept.loc}</td>
    		</tr>
    	</c:forEach>
    </tbody>
	</table>    
    
</div>
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">부서 등록</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
		<form id="frm11" class="form" method="post">
		<div class="modal-body">
			<div class="row">
				<div class="col">
					<input class="form-control mr-sm-2" placeholder="부서번호 입력" name="deptno"/>
				</div>
			</div> 
			<div class="row">
				<div class="col">
					<input class="form-control mr-sm-2" placeholder="부서명 입력" name="dname"/>
				</div>
			</div> 
			<div class="row">
				<div class="col">
					<input class="form-control mr-sm-2" placeholder="위치 입력" name="loc"/>
				</div>
			</div> 
      </div>
      </form>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
        <button type="button" class="btn btn-primary" id="deptRegBtn">등록</button>
        <button type="button" class="btn btn-primary" id="deptUptBtn">수정</button>
        <button type="button" class="btn btn-primary" id="deptDelBtn">삭제</button>  
      </div>
    </div>
  </div>
</div>
</body>
</html>