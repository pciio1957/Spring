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

#vue를 통한 ajax 처리
1. 핵심 프로세스
	0) lib 선언 
		<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
	0) 모델데이터 초기 선언 : data:{ename:"", job:"", emplist:[]}
	1) key/click 이벤트를 통해서 methods에 있는 특정 기능메소드 호출
	2) 기능메소드1 : 검색데이터의 유효성
		공백이 아닐때 등 
	3) 기능메소드2 : 유효성check된 후, ajax 처리
		- 위 모델 데이터의 초기화 : this.emplist = [];
		- ajax 처리될 url선언 : var url = "${path}/empListAjax.do?ename=" + this.ename + "&job=" + this.job;
		- fetch(url).then(함수1).then(함수2).catch(함수3);
			익명 함수1:
				서버에서 온 response값 확인 및 이 중에서 json 데이터 retrun 처리
					return response.json();
			익명 함수2: 
				받은 json 데이터를 
				현재 model에 있는 데이터에 할당
			익명 함수3:
				error 내용 처리 
				
		응용) a04_deptSearch.jsp로 부서정보를 vue로 출력하기 
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
			data:{msg:"시작!!(뷰와함께)", ename:"", job:"", empList:[]},
			methods:{
				search1:function(e){
					if(e.keyCode==13){
						console.log("enter키 입력");
						this.fetchList();
					}
				},
				search2:function(){
					console.log("버튼 클릭");
					this.fetchList();
				},
				fetchList:function(){
					this.empList=[]; // 초기화
					var url = "${path}/empListAjax.do?ename=" + this.ename + "&job=" + this.job;
					// this : 현재 Vue 객체를 지정하는데 fetch api를 쓰면 this가 fetch api 객체를 지정하기에 
					// 			Vue 객체를 지징하는 변수를 따로 선언
					var vm = this;
					fetch(url).then(function(response){
						// 출력할 json 데이터 선언
						console.log("#서버에서 온 response #");
						console.log(response);
						return response.json();
					}).then(function(json){
						// 서버에서 온 json 데이터 확인
						console.log("#서버에서 온 json 데이터 #");
						console.log(json);
						
						// 할당처리
						vm.empList = json.empList;
					}).catch(function(err){
						// 오류 확인
						console.log(err);
					});
				}
			}		
		});	
		<%-- 
		
		--%>	
	});
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2 data-toggle="modal" data-target="#exampleModalCenter">사원정보검색(Vue)</h2>

</div>
<div class="container">
    <h2 align='center'>{{msg}}</h2>
	<form id="frm01" class="form-inline"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input class="form-control mr-sm-2" placeholder="사원명" v-model="ename" @keyup="search1"/>
	    <input class="form-control mr-sm-2" placeholder="직급" v-model="job" @keyup="search1"/>
	    <button class="btn btn-info" type="button" @click="search2">Search</button>
 	</nav>
	</form>
   <table class="table table-hover table-striped">
   	<col width="20%">
   	<col width="20%">
   	<col width="20%">
   	<col width="20%">
   	<col width="20%">
    <thead>
    
      <tr class="table-success text-center">
        <th>사원번호</th>
        <th>사원명</th>
        <th>직책명</th>
        <th>급여</th>
        <th>부서번호</th>
      </tr>
    </thead>	
    <tbody>
    	<tr class="text-center" v-for="emp in empList">
    		<td>{{emp.empno}}</td>
    		<td>{{emp.ename}}</td>
    		<td>{{emp.job}}</td>
    		<td>{{emp.sal}}</td>
    		<td>{{emp.deptno}}</td>
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