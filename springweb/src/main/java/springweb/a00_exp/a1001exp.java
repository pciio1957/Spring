package springweb.a00_exp;

public class a1001exp {

	/*
	 
	1. 답글처리의 핵심로직 기술하기
		1) 답글처리 프로세스 : 게시판 목록에서 한 글을 선택해서 들어가면 상세화면이 나오고 
			상세화면에서 답글을 클릭하면 제목에는 'Re:'가 추가되고 글내용은 선택한 글의 내용이 출력됨 
		2) 핵심로직 
			- insert.jsp 화면에서 답글을 작성할 때 추가되는 내용을 출력하기 위해서
				글번호, 글제목, 내용을 el태그로 처리한다
			- 상세화면(detail.jsp)에서 답글 버튼을 누르면 답글 작성화면이 나오도록 이벤트 처리
				js에 글번호, 글제목, 글 내용이 수정되도록 작성한 뒤 method=insertForm으로 action 처리후 
				submit();
				
				
		상세화면 답글 클릭 -> (요청값변경) -> 등록화면
		no -> refno로 할당
		subject -> "RE:" + subject
		content -> "\n\n\n\n===<이전글>===\n" + content
		$("form").attr("action", "${path}/board.do?method=insertFrm");
					
	2. 단방향 directive의 종류를 화면출력과 속성을 나누어 기술하기
		1) 화면출력
			{{모델명}} 
			<태그 v-text="모델명"></태그>
			<태그 v-html="모델명"></태그>
			
		2) 속성	
			<태그 v-bind:속성명="모델명"/>
			<태그:속성명="모델명"/>


		1) 화면출력형 요소객체 : h1~h6, option, span, td ..
		2) 화면 출력 처리 
			- mustache ex) <h2>{{모델명}}</h2>
			- v-text ex) <h2 v-text="모델명"></h2>
			- v-html ex) <h2 v-html="모델명"></h2>
		3) 속성에 모델데이터 처리
			- v-bind:속성명="모델명" ex) <h2 v-bind:align="align01">
			- :속성명="모델명" ex) <input :value="data01">
			
			
	3. 양방향 directive를 활용하여 회원로그인의 id/pass 입력시 인증여부 출력하기
		hint) vue는 js이다! 삼항연산자 활용
		var vm = new Vue({
			el:".container",
			data:{msg:"시작!!(뷰와함께)", id:"", pass:""}
		});	
		
		<input class="form-control mr-sm-2" placeholder="제목" v-model="id"/>
	    <input class="form-control mr-sm-2" placeholder="내용" v-model="pass"/>
	    <button class="btn btn-info" type="submit">{{id=='himan' && pass=='7777'?'로그인성공':'로그인실패'}}</button>
	    
	4. 조건문의 기본형식을 기술하고, 입력한 국어/영어/수학 점수의 평균에 대한 A~F등급을 부여하기 
		<td v-if="(parseInt(kor)+parseInt(eng)+parseInt(math))/3>= 90">A등급</td>
		<td v-else-if="(parseInt(kor)+parseInt(eng)+parseInt(math))/3>= 90">B등급</td>
		<td v-else-if="(parseInt(kor)+parseInt(eng)+parseInt(math))/3>= 80">C등급</td>
		<td v-else-if="(parseInt(kor)+parseInt(eng)+parseInt(math))/3>= 70">D등급</td>
		<td v-else-if="(parseInt(kor)+parseInt(eng)+parseInt(math))/3>= 60">E등급</td>
		<td v-else>F등급</td>
		
	5. 반복문에서 객체와 배열의 차이를 기술하고 부서정보 리스트 출력하기 
		객체 : <요소객체 v-for="(value, prop) in 객체">
		배열 : <요소객체 v-for="(단위객체, index) in 배열">  
	*/
}
