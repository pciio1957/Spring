package springweb.a00_exp;

public class a1005exp {

	/*
	  
	#정리문제 
	1. 이벤트 처리를 위한 vue 기본 코드형식을 기술하기

		vue의 이벤트 처리 
		1) 기본 구조
			methods:{
				함수명1:function(){
					// 처리할 내용
					// this. : 모델데이터나 함수를 호출할 수 있다.
				}, 
				함수명2:function(){
					// 처리할 내용
				}
			}
		2) 사용
			<속성 v-on:이벤트명="함수명">
			<속성 @이벤트명="함수명">
			
		
	2. 양방향 directive와 이벤트를 활용하여 금액[ ] (입금) (출금) 잔액 : @@@을 처리하기 
	
		- 1005.html
		<body>
			<div id="show" align="center">
				<h2 align="center">{{msg}}</h2>
				금액 : <input align="center" type="text" v-model="money">
				<input type="button" v-on:click="plus" value="입금">
				<input type="button" v-on:click="minus" value="출금">
				<h3>현재 계좌 잔액 : {{account}}</h3>
			</div>
		</body>
		<script>
			var vm = new Vue({
				el:"#show",
				data:{msg:"입출금 계좌", account:0, money:0},
				methods:{
					plus:function(){
						this.account += parseInt(this.money);
					}, 
					minus:function(){
						this.account -= parseInt(this.money);
					}
				}
			});
		</script>
	
	3. vue를 활용하여 ajax로 데이터를 처리하려고 한다. 처리를 위한 기본 코드를 기술하기 
		vue를 활용한 ajax 처리
		1) 라이브러리 선언 : vue의 ajax 처리를 도와주는 fetch api 선언
			<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" 
				type="text/javascript"></script>
		2) 모델 vue의 선언 후 처리 
			<script>
				var vm = new Vue({
					el:"#show",
					// 모델데이터의 초기화
					data:{msg:"입출금 계좌", ename:"", elist:[]},
					// 기능메소드 작성
					methods:{
						기능메소드1:function(){
							// 유효성 체크나, 공백 처리
						}, 
						기능메소드2:function(){
							// 유효성체크 후 ajax 처리 부분
							// 1. 위의 배열로 선언된 elist의 초기화
							// 2. url 선언 (데이터 전달도 해야함)
							// fetch api로 처리 : fetch(url).then(함수1).then(함수2).catch(함수3);
							익명 함수1:
								서버에서 온 response값 확인 및 이 중에서 json 데이터 retrun 처리
									return response.json();
							익명 함수2: 
								받은 json 데이터를 
								현재 model에 있는 데이터에 할당
							익명 함수3:
								error 내용 처리 
						}
					}
				});
			</script>
			
			1) lib 선언
			
			2) 모델 데이터 선언
			 	검색 요청값, 리스트할 데이터 선언
			 	ex) data:{ename:'', job:'', empList:[]}
			 	
			3) methods 하위의 기능메소드 선언 : 이벤트 핸들러를 통해서 처리할 내용 선언 
				메소드1 : 요청데이터에 대한 filltering을 위하여 선언
				메소드2 : 주된 ajax 처리를 위하여 선언 
			
			4) fetch api 활용
				- 기본형식 : fetch(url).then(익명함수1).then(익명함수2).catch(익명함수3);
				- var vm = this : 익명함수 안에서 vue의 모델 데이터나 메소드를 접근해서 호출할 때 활용된다.
				- 익명함수1
					function(response) {
						// 서버에서 온 결과 response를 객체형태로 가져온다
						// 그 중에서 json데이터를 fitering하여 다음 익명함수2에 매개변수로 넘긴다.
						return response.json();
				- 익명함수2
					function(json) {
						익명함수1에서 넘겨온 json데이터를 받아서 실제, 모델데이터와 연결처리한다
						vm.empList = json.empList;
									
			5) 화면 처리 
				요청값 처리 : v-model="요청모델데이터"
				서버에서 온 리스트형 데이터 처리 
					<tr v-for="emp in empList">
					 	<td>{{emp.empno}}</td>
					 	<td>{{emp.ename}}</td>
					
					}
	
	4. vue와 fetch api를 이용하여 회원정보를 검색처리하기. A04_MemberController 활용하기  
	 	- a05_memSearch.jsp에 풀이
	*/
}
