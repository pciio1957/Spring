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
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		<%-- 
		
		--%>	
		
		// url로 json데이터로 나타내는 view를 연결 
		$("#regBtn").click(function(){
			$.ajax({
				type:"post",
				url:"${path}/addStudentInfo.do", 
				data:$("#frm01").serialize(),
				dataType:"json",
				success:function(data){
					console.log(data.student);
					
					var stud = data.student;
					$(".data").eq(0).text(stud.sno);
					$(".data").eq(1).text(stud.name);
					$(".data").eq(2).text(stud.kor);
					$(".data").eq(3).text(stud.eng);
					$(".data").eq(4).text(stud.math);
				},
				error:function(err){
					console.log(err);
				}
			});
		});
	});
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2 data-toggle="modal" data-target="#exampleModalCenter">회원 등록</h2>

</div>
<div class="container">
    <h2 align='center'></h2>
	<form id="frm01" class="form-inline"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input class="form-control mr-sm-2" placeholder="번호 입력" name="sno"/>
	    <input class="form-control mr-sm-2" placeholder="이름 입력" name="name"/>
	    <input class="form-control mr-sm-2" placeholder="국어점수 입력" name="kor"/>
	    <input class="form-control mr-sm-2" placeholder="영어점수 입력" name="eng"/>
	    <input class="form-control mr-sm-2" placeholder="수학점수 입력" name="math"/>
	    <button class="btn btn-info" type="button" id="regBtn">등록</button>
 	</nav>
	</form>
   <table class="table table-hover table-striped">
   	<col width="10%">
   	<col width="50%">
   	<col width="15%">
   	<col width="15%">
   	<col width="10%">
    <thead>
      <tr class="table-success text-center"><th>번호</th><td class="data"></td></tr>
      <tr class="table-success text-center"><th>이름</th><td class="data"></td></tr>
      <tr class="table-success text-center"><th>국어</th><td class="data"></td></tr>
      <tr class="table-success text-center"><th>영어</th><td class="data"></td></tr>
      <tr class="table-success text-center"><th>수학</th><td class="data"></td></tr>  
    </thead>	
	</table>    
    
</div>
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">타이틀</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
		<form id="frm02" class="form"  method="post">
	     <div class="row">
	      <div class="col">
	        <input type="text" class="form-control" placeholder="사원명 입력" name="ename">
	      </div>
	      <div class="col">
	        <input type="text" class="form-control" placeholder="직책명 입력" name="job">
	      </div>
	     </div>
	    </form> 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>