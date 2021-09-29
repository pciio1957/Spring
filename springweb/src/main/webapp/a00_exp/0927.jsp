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
		schAjax();
		
	});
	
	function schAjax() {
		
		$.ajax({
			type:"post",
			url:"${path}/dept01List.do",
			data:$(form).serialize(),
			dataType:"json",
			success:function(data){
				console.log(data.dept01List);
				var list = data.dept01List;
				var show = "";
				
				$(list).each(function(idx, dept){
					show += "<tr class='table-success text-center'><td>" + dept.deptno;
					show += "</td><td>" + dept.dname + "</td><td>" + dept.loc + "</td></tr>";
				});
				
				$("tbody").html(show);
			},
			error:function(err){
				console.log(err);
			}
		});
	}
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2 data-toggle="modal" data-target="#exampleModalCenter">타이틀</h2>

	<h4>${dept01List.list}</h4>
</div>
<div class="container">
	<h2 align='center'></h2>
	<form id="frm01" class="form-inline"  method="post">
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<input class="form-control mr-sm-2" placeholder="부서명" name="dname"/>
	    <input class="form-control mr-sm-2" placeholder="위치" name="loc"/>
	    <button class="btn btn-info" type="submit">조회</button>
 	</nav>
	</form>
	<table class="table table-hover table-striped">
		<col width="10%">
		<col width="50%">
		<col width="15%">
		<col width="15%">
		<col width="10%">
	<thead>
		<tr class="table-success text-center">
			<th>부서번호</th>
			<th>부서명</th>
			<th>위치</th>
		</tr>
	</thead>	
	<tbody></tbody>
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