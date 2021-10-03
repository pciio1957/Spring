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
<script src="https://unpkg.com/vue/dist/vue.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var vm = new Vue({
			el:".container",
			data:{msg:"시작!!(뷰와함께)", id:"", pass:"",
				kor:0, eng:0, math:0,
				dlist:[
					{deptno:10, dname:"인사", loc:"서울"},
					{deptno:20, dname:"회계", loc:"대구"},
					{deptno:30, dname:"총무", loc:"부산"}
				]
				
			}
		});	
		<%-- 
		
		--%>	
	});
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2 data-toggle="modal" data-target="#exampleModalCenter">타이틀</h2>

</div>
<div class="container">
    <h2 align='center'>{{msg}}</h2>
	<form id="frm01" class="form-inline"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input class="form-control mr-sm-2" placeholder="아이디" v-model="id"/>
	    <input class="form-control mr-sm-2" placeholder="비번" v-model="pass"/>
	    <button class="btn btn-info" type="submit">{{id=='himan' && pass=='7777'?'로그인성공':'로그인실패'}}</button><br>
	    <input class="form-control mr-sm-2" placeholder="국어" v-model="kor"/>
	    <input class="form-control mr-sm-2" placeholder="영어" v-model="eng"/>
	    <input class="form-control mr-sm-2" placeholder="수학" v-model="math"/>
 	</nav>
	</form>
   <table class="table table-hover table-striped">
   	<col width="50%">
   	<col width="50%">
      <tr class="table-success text-center">
        <th>총점</th><td>{{parseInt(kor)+parseInt(eng)+parseInt(math)}}</td>
        <th>평균</th><td>{{(parseInt(kor)+parseInt(eng)+parseInt(math))/3}}</td>
        <th>등급</th>
		<td v-if="(parseInt(kor)+parseInt(eng)+parseInt(math))/3>= 90">A등급</td>
		<td v-else-if="(parseInt(kor)+parseInt(eng)+parseInt(math))/3>= 90">B등급</td>
		<td v-else-if="(parseInt(kor)+parseInt(eng)+parseInt(math))/3>= 80">C등급</td>
		<td v-else-if="(parseInt(kor)+parseInt(eng)+parseInt(math))/3>= 70">D등급</td>
		<td v-else-if="(parseInt(kor)+parseInt(eng)+parseInt(math))/3>= 60">E등급</td>
		<td v-else>F등급</td>
      </tr>
	</table>   
	
	<table class="table table-hover table-striped">
   		<col width="50%">
   		<col width="50%"> 
   		<thead>
   			<tr class="table-success text-center"><th>부서번호</th><th>부서명</th><th>부서위치</th></tr>
   		</thead>
   		<tbody>
   			<tr class="text-center" v-for="(dept, idx) in dlist">
   				<td>{{dept.deptno}}</td><td>{{dept.dname}}</td><td>{{dept.loc}}</td>
   			</tr>
   		</tbody>
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