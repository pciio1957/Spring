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
		$("#frm01").on("submit", function(){
			//alert(("#paramSelect").val());
			// 전송 프로세스를 처리할 때 완료되기까지 process()
			if($("#paramSelect").val() == "POST"){
				// 이전의 url주소에 get방식으로 ?greet=안녕 선언되어 있으면
				// 계속 주소창에 남아있기 때문에 아래와 같이 새로운 
				// action값으로 설정해주면 주소에 요청값이 없어진다.
				$(this).attr("action", "${path}/requestexp07.do")
			}
			$(this).attr("method", $("#paramSelect").val()); // 선택된 내용 처리 
		});
	});
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2 data-toggle="modal" data-target="#exampleModalCenter">응용 post 호출</h2>
	<h1> requestexp08의 요청값! : ${param.greet}</h1>
</div>
<div class="container">
    <h2 align='center'></h2>
	<form id="frm01" class="form-inline"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  	<select class="form-control" id="paramSelect">
  		<option value="get">get방식</option>
  		<option value="post">post방식</option>
  	</select>
    <input class="form-control mr-sm-2" placeholder="greet" name="greet"/>
	    <button class="btn btn-info" type="submit">Search</button>
 	</nav>
	</form>

    
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
        내용!!!
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