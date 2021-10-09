package springweb.a00_exp;

public class a1008exp {

	/*
	 
	
	#정리문제
	1. plugin 프로그램을 이용하여 json 데이터를 controller단을 통해서 가져올 수 있는 백엔드단 처리 내용을 기술하기 
		sql 작성 -> dao -> mapper 
		json 데이터 처리방식 1) RestController 2) view pageJsonRespot 활용
		ex) @RestController 활용
		
	
	2. fullcalendar api에서 사용되는 json 데이터와 주요 이벤트에 대해 기술하기
			
		#json 데이터를 서버에서 가져오는 부분 
		events: function(info,successCallback, failureCallback){
			1) 서버와 ajax를 통해서 화면에 일정 데이터를 json으로 가져오는 부분
			2) successCallback : 결과화면에 데이터를 전달할 함수는 매개변수로 전달된 부분 
					ex) successCallback(실제데이터) 
					
    	  $.ajax({
    		  url:"${path}/calList.do", // json 데이터로 가져옴
    		  success:function(data){
    			  console.log(data)
    			  successCallback(data); // 캘린더로 전달
    			  
		- RestController는 객체를 통째로 바로 넘김 successCallback(data);
		- pageJsonReport는 모델명을 선언해줘야함  successCallback(data.모델명);
    	  
    	  
    	#주요이벤트
    	select: function(arg) { : 클릭, 스크롤로 선택시 일정이 없는 곳에 해당 
    		이벤트를 했을때 등록되도록 처리한다.
    	 
      	
	3. 데이터를 가져올 때 사용되는 속성과 매개변수와 ajax 처리 형식 기술하기
		
		1) 가져오는 속성/매개변수
			allDay: true 
			allow: null
			backgroundColor: ""
			borderColor: ""	
			classNames: Array(0)
			constraint: (...)
			display: (...)
			durationEditable: (...)
			end: null
			endStr: ""
			extendedProps: Object // 확장된 일정
			groupId: ""
			id: ""		// 일정 id값 설정..
			overlap: (...)
			source: (...)
			start: (...) // 시작일
			startEditable: (...)
			startStr: (...)
			textColor: (...) // 글자색상
			title: (...) // 타이틀
			url: (...)
			
		2) 주요 이벤트
			initialDate: 캘린더의 기준날짜(초기값)
			select: 빈 일정을 클릭했을때
			eventClick: 이미 작성된 일정을 클릭했을 때 
			events: 캘린더가 로딩될때 이벤트 처리될 내용
			 
		
	4. 등록시 모달창 로딩 처리 방법과 특정 일정 클릭시 받는 매개변수 기술하기 
		
		0) 모달창 선언, 호출
			선언 : <div class="modal fade" id="exampleModalCenter" tabindex="-1" 
				role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			호출 : 아래 속성이 있는 대상 객체 클릭시 호출
				<h2 data-toggle="modal" data-target="#exampleModalCenter"></h2>
			js로 강제 click이벤트 수행
				이벤트별 강제 실행, $("h2").click();
			등록된 특정 일정 클릭시, 받는 매개변수 처리 
				eventClick : function(arg) {
					arg.event();
	
		1) 특정 일정 클릭시 받을 수 있는 매개변수
			select: function(arg) {
	    	console.log("시작일:"+arg.start);
	    	console.log("종료일:"+arg.end);
	    	console.log("종일여부:"+arg.allDay);
	    	.. 
	    	
	    2) 등록 모달창에 클릭한 날짜와 종일여부를 나타내야함
	    
	    	- 나타나는 모달창의 Form의 내용을 초기화
		    	$("form")[0].reset(); 

			- 사용자가 보는 모달창의 데이터는 String으로 나타냄
		    	$("#start").val(arg.start.toLocaleString());
		    	$("#end").val(arg.end.toLocaleString());
		    	$("#allDay").val(""+arg.allDay);
	    	
	    	- 처리될 내용은 hidden으로 처리하여 컴퓨터가 인식할 수 있도록 변환
		    	$("[name=start]").val(arg.start.toISOString());
		    	$("[name=end]").val(arg.end.toISOString());
		    	$("[name=allDay]").val((arg.allDay?1:0));
	
	*/
}
