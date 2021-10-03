package springweb.a00_exp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

public class a0930exp {
	
	/*
	  
	#정리문제
	1. 파일업로드를 컨테이너단/화면단 설정을 기술하기
		파일업로드시 컨테이너단의 설정
		1) dispatcher-servlet.xml에 첨부파일을 위한 viewresolver 선언
			<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
		 	</bean>
		
		파일업로드시 화면단의 설정
		1) 파일을 업로드하려는 form에 enctype="multipart/form-data" 선언
		2) 첨부파일 추가할 수 있도록 <input type="file" 선언
		3) 동적 이벤트 처리를 통해 업로드한 파일의 이름을 출력하도록 설정
		
	
	2. MultipartFile객체는 어떤 역할을 하는지 기술하기
		사용자가 첨부한 파일을 서버를 통해서 특정한 장소에 저장하게 해야하는데 
		이때 MultipartFile을 이용해 File객체로 변환할 수 있도록 도와주는 역할이다.
		
		화면단 <input type="file" 을 이용해서 서버로 전송했을 때 받을 수 있는 객체
		vo에 MultipartFile유형으로 선언하여 사용하면 File을 받을 수 있다.
	
	3. 파일업로드 처리를 위한 service처리 내용을 File 객체 만들기, 변환 처리하기, 파일복사의 단계로 나누어 기술하기
	
		파일업로드 처리를 위한 service(uploadFile(int no, MultipartFile report)) 처리순서 
		1) File객체 만들기
			- 서버를 통해서 입력된 파일의 이름을 가져온다
				String fileName = report.getOriginalFilename();
			- info 파일에 저장한 파일의 임시저장 경로, 실제저장 경로를 이용해 File객체 변환 후 임시저장
				@Value("${upload}") private String upload; // 실제 저장 경로
				@Value("${tmpUpload}") private String tmpUpload; // 임시 저장 경로
				
				if(fileName != null && !fileName.equals("")) { // 파일이름이 추출될 경우
					File tmpFile = new File(tmpUpload + fileName); // 임시경로에 파일 생성
					File orgFile = new File(upload + fileName); // 실제경로에 파일 생성
					
		2) 변환 처리하기			
			- 위에서 임시경로에 생성한 파일을 File로 변환처리
				report.transferTo(tmpFile); // 위에서 생성판 파일을 File로 변환

		3) 파일 복사
			- File 객체로 생성된 파일은 임시경로에 저장되었으므로 
				실제 저장할 경로로 파일을 복사
				Files.copy(tmpFile.toPath(), orgFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		
	
	4. springweb 프로젝트에 자료명[ ] 첨부파일[ ]로 z01_upload폴더를 만들고 파일 첨부하기  
	
	
	*/

}
