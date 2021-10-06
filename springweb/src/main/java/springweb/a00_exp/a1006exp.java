package springweb.a00_exp;

public class a1006exp {

	/*
	
	#정리문제
	1. 파일을 다운로드 처리하려고 한다. 필요한 설정 부분을 컨테이너, 컨트롤러, viewer를 나누어서 기술하기
		파일 다운로드 처리 프로세스
		1) 컨테이너 
			AbstractView를 상속받은 사용자 정의 다운로드Viewer를 맵핑한다
		
		2) 컨트롤러
			게시판의 상세화면에서 출력되는 fname을 매개변수로 받아서 모델데이터로 선언한 뒤
			다운로드Viewer로 연결한다. 
		
		3) viewer
			- 다운로드Viewer에서는 AbstractView를 상속받아 다운로드를 처리한다.
			- 파일을 업로드했던 폴더위치를 @Value를 이용해 위치를 가져온다.
			- 모델데이터에 선언했던 fname을 가져온다 
			- File 객체를 선언하여 파일위치와 파일이름을 결합하여 파일로 만든다
			- File의 정보를 선언한다 (contentType, 파일의 길이, 한글변환, 헤더 등)
			- 설정이 완료되면 파일을 InputStream으로 전환하여 response의 OutStream에 삽입한다.
				그리고 파일을 복사하여 전송한다.
		
	2. springweb에서 A10_FileUploadCtrl를 통해 업로드 처리된 내용을 다운로드 처리되게 하기
		
	
	3. 계층형 sql을 위해 필요한 코드와 의미를 기술하기
		1) start with 컬럼명 = 최상위 레벨의 데이터의 조건을 선언, 계층형에서 최상위는 0번
		2) connect by prior 연관관계컬럼명 = 연관관계가 있는 컬럼명 지정
		3) order siblings by 컬럼명 asc/desc = 계층적 데이터의 정렬 순서를 지정, 
			계층형에서는 최신글이 위에 있기 때문에 desc 지정
			
		
		1) 계층적 데이터가 만들어지는 구조로 되어 있어야 한다
			no vs refno, empno vs mgr
		2) start with 컬럼명=조건데이터 : 최상위 레벨의 데이터의 조건을 선언
		3) connect by prior 컬럼1 = 컬럼2 : 계층적 처리가 되어 있는 컬럼간의 
			연관관계 설정
		4) order siblings by 컬럼명 asc/desc 
			계층적 sql 데이터 처리의 정렬에 대한 설정 

	4. 페이징 처리를 위한 vo의 중요속성을 기술하기 
		// 1. 검색 : 제목/작성자
		private String subject;
		private String writer;
		
		// 2. 페이징 처리를 위한 속성
		private int count; 		// 총 데이터 건수 (DB)
		private int pageSize; 	// 한번에 보여줄 페이지크기 (요청값)
		private int pageCount;	// 총 페이지수 count/pageSize (로직)
		private int curPage;	// 클릭한 현재 페이지번호 (요청값)
		private int start;		// 현재 페이지의 시작번호 (로직)
		private int end;		// 현재 페이지의 마지막 번호  (로직)
	
	*/
}
