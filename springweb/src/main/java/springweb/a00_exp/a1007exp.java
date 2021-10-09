package springweb.a00_exp;

public class a1007exp {

	/*
	 
	#정리문제
	1. 페이징 처리시 각 속성값의 처리방법을 간단하게 기술하기 
		count(총 건수), pageSize(페이지크기), pageCount(총페이지수), curPage(현재 페이지번호), start(시작번호), end(마지막번호)
		
	  count(총건수) - DB, 
	  pageSize(페이지크기) - 요청값(<select name="pageSize")
	  pageCount(총페이지수) - service로직(총건수/페이지크기-올림처리)
	  curPage(현재페이지번호) - 요청값(<input name="curPage"> <a href="goPage(번호)"> 
      start(시작번호), end(마지막번호) - service로직(페이지크기*현재페이지번호)
      ==> 최종적으로
      DB  처리  where rownum between #{start} and #{end}
			
	2. 하단 페이지 처리시 << 1  2  3  4  5  >> 각 내용을 클릭시 처리되는 내용 기술하기 
		<a class="page-link" 
		  	href="javascript:goPage(${boardSch.startBlock-1})">Previous</a>
		이전 페이지블럭은 시작하는 블럭 페이지번호-1로 처리   	
		  	
		<c:forEach var="cnt" begin="${boardSch.startBlock}" end="${boardSch.endBlock}">
		반복을 통해 페이지의 시작블럭과 마지막블럭 범위로 처리
		
		<a class="page-link" href="javascript:goPage(${cnt})">${cnt}</a></li>
		클릭했을 때, 해당하는 페이지 번호를 함수에 의해 호출하여 curPage를 처리한다.
	
		 <li class="page-item"><a class="page-link" 
		   href="javascript:goPage(${boardSch.endBlock+1})">Next</a></li>
		마지막 페이지블럭은 현재 표시되는 블럭의 마지막 페이지번호 + 1로 호출하여 처리한다.  
		
	3. fullcalendar 환경설정 방법 기술하기 
		1) fullcalendar api 다운로드 및 webapp에 해당 폴드 복사하여 화면확인.
		2) controller과 연결된 jsp 파일 만들기.
	    3) 주로 사용되는 lib webapp\a00_com에 설정.
	    4) jsp상단에 호출되는 부분 선언 처리..
	       <link href='${path}/a00_com/lib/main.css' rel='stylesheet' />
		   <script src='${path}/a00_com/lib/main.js'></script>
	   
	   
	*/
}
