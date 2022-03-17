# 🐶OKEEDOKEE | 오키도키
OPEN API를 활용한 유기견 입양 / 보호소 / 봉사•후원 정보 제공 프로젝트

## 🗂️INDEX
- [Introduction](#introduction)
- [Goal](#goal)
- [User](#user)
- [Period](#period)
- [Tech Stack](#tech-stack)
- [Detail of Development](#detail-of-development)
- [My Position](#my-position)
- [Demonstration](#demonstration)
- [Attached](#attached)
</br>


## 📢Introduction
> ### 농림축산본부 추산, 한 해 버려지는 유기동물, 약 13만.([첨부1](#첨부1))       
>(공식 보호소 한정. 사설 보호소 미포함)       
> #### 2021 오픈서베이 반려동물 트렌드 리포트
> - 반려동물을 키우지 않는 응답자 10명 중 3명이 향후 양육 의향이 있음([첨부2](#첨부2))         
> - '사지말고 입양해야 한다’는 응답이 69.4%로 높은 수치를 보여줌 ([첨부3](#첨부3))  
#
## 🎯Goal
> - #### 입양 정보에 대한 접근성 향상을 통해 반려동물 양육 계획있는 표본 유인       
> - #### 기존 견주들의 실종 및 목격 제보, 셀프 전단지 게시판을 통해 유기 발생률 감소 도모 
#
## 👨‍👩‍👧‍👦User
> - 유기견 입양 계획이 있는,
> - 보호소 봉사 활동을 원하는,
> - 보호소 후원을 원하는,
> - 유기견을 목격한,
> - 반려견 실종 신고가 필요한,
#
## ⏰Period 
> #### 2022.01.14 ~ 2022.02.09 (27 Days)
#
## 🛠Tech Stack
> - #### BackEnd       
>   - <img src="https://img.shields.io/badge/Java-007396?style=plastic&logo=Java&logoColor=white"> <b>SE-14</b></br>
>   - <img src="https://img.shields.io/badge/Spring-6DB33F?style=plastic&logo=Spring&logoColor=white"> <b>5.2.2.RELEASE</b></br>
>   - <img src="https://img.shields.io/badge/MariaDB-003545?style=plastic&logo=MariaDB&logoColor=white"> <b>10.6.5</b></br>
>   
> - #### FrontEnd
>   - <img src="https://img.shields.io/badge/HTML5-E34F26?style=plastic&logo=HTML5&logoColor=white"></br>
>   - <img src="https://img.shields.io/badge/CSS3-1572B6?style=plastic&logo=CSS3&logoColor=white"></br>
>   - <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=plastic&logo=JavaScript&logoColor=white"></br>
>   - <img src="https://img.shields.io/badge/jQuery-0769AD?style=plastic&logo=jQuery&logoColor=white"></br>
>   
> - #### WAS
>    - <img src="https://img.shields.io/badge/ApacheTomcat-F8DC75?style=plastic&logo=ApacheTomcat&logoColor=white"> <b>9.0.54</b></br>
>    
> - #### API
>   - 농림축산식품부 농림축산검역본부_동물보호관리시스템 유기동물 조회 서비스
>   - <b>Naver Smart Editor 2.0 - WYSIWYG Text Editor</b>
>   - <b>i'mport - Payment System</b>
#
## 📝Detail of Development
> - [Project Kanban Board](https://trello.com/b/cot384sf/%EA%B5%AC%EB%94%9439-%EC%83%98%ED%94%8C)</br>
>   <img src="https://user-images.githubusercontent.com/88533162/158531003-83cd28f6-85ac-488e-850b-28cf7439fb4a.png" style="width: 300px; height: 150px;">
> - [요구사항정의서](https://docs.google.com/spreadsheets/d/1NDEw2g-ZNCsZRSz5HKTX8BzRfY2dpyYh53sfyahZxcs/edit#gid=0)</br>
>   <img src="https://user-images.githubusercontent.com/88533162/158531740-8c87c81a-cbf1-446a-9cea-d41ba8fafb87.png" style="width: 300px; height: 150px;">
> - [WireFrame](https://www.figma.com/file/ZX4QgZMIwL0gpdIOsKW28h/Untitled?node-id=0%3A1)</br>
>   <img src="https://user-images.githubusercontent.com/88533162/158532250-6a82f084-358d-4dae-8190-974f5c633020.png" style="width: 300px; height: 150px;">
> - [Front Design](https://www.figma.com/file/ZX4QgZMIwL0gpdIOsKW28h/Untitled?node-id=10%3A8)</br>
>   <img src="https://user-images.githubusercontent.com/88533162/158532605-3a023730-72a7-4c92-92f2-da36a415e696.png" style="width: 300px; height: 150px;">
> - [ERD Design](https://www.erdcloud.com/d/wsbrPm9qiGXQc4Krd)</br>
>   <img src="https://user-images.githubusercontent.com/88533162/158532912-5da5dfaf-a527-4aa9-8ba2-44aeccda6259.png" style="width: 300px; height: 150px;">
#
## 🙋My Position
> - #### 유기견 공고
>   - XML 포맷 데이터 JSON화 > Map<String, Ojbect>화
>     1. XML 포맷 OPEN API를 StringBuilder로 범위 한정해 url 문자열 생성 
>     2. URL 클래스로 url 객체화
>     3. HttpURLConnection으로 웹에서 url 출력해 XML구조 파악
>     4. InputStream(byte 단위 입력) > InputStreamReader(char로 중개) > BufferedReader(stream 버퍼걸어 한 번에 전달)로 XML받기
>     5. 입력받은 XML을 한 줄씩 읽어 String에 담아 StringBuffer에 저장
>     6. StringBuffer를 String 캐스팅해 불변화
>     7. XML.toJSONObject() 메서드 이용해 JSON 객체로 변환
>     8. JSONObject.toString() 메서드로 문자열화
>     9. 필요한 정보가 담긴 item태그만 List<Map<String, Object>>로 추출
>     10. Map<String, Object> 이용해 List로 추출한 item에 키 값 지정
>     11. model로 attribute 추가해 view로 가져가기 </br>
>               <img src="https://user-images.githubusercontent.com/88533162/158581293-9bd76955-b8da-4ec2-86cd-bc70c9d2a3e5.png" style="width: 300px; height: 150px;">
>               
> - #### 유기견 실종•목격 게시판
>   - 게시글 슬라이드
>     1. 오리지널 슬라이드 앞 뒤로 cloneNode() 메서드 이용해 클론 슬라이드 추가
>     2. 추가 슬라이드 너비 추가 (슬라이드 div의 부모태그에 overflow:hidden)
>     3. 슬라이드 1개 너비 * 오리지널 슬라이드 갯수 만큼 왼쪽(-)이동해 초기위치 설정
>     4. 화면 로드시 초기위치 설정 보이지 않도록 setTimeout 100ms
>     5. 좌우버튼 클릭시 클릭 횟수 * 슬라이드 너비 만큼 좌우이동
>     6. 슬라이드 이동시 transition .5s를 classList.add()
>     7. 클릭수가 오리지널 슬라이드 갯수(±)와 같을 시 remove()
>     8. 초기 설정 위치 이동
>     9. 이동 후 다시 transition .5s class 추가
>     10. mouseenter, mouseleave로 변수의 특정 값에 따라 setInterval, clearInterval 반복해 오토 슬라이드 또는 중지
>     
>   - 게시글 페이징
>     1. 게시글VO 생성자를 통한 start(첫번째 index)=0, count(페이지당 게시글 수)=5 초기화 
>     2. 총 게시글 수 이용해 블록 범위, 최초 숫자, 최후 숫자 연산
>     3. 연산 숫자 대소 비교해 페이지 블록 또는 페이지 이동 버튼 유무 결정
>     4. 페이지 번호 별 a태그 href설정해 페이지 번호 파라미터로 전달 (defaultValue = 1)
>     
>   - 게시글 검색
>     1. SELECT태그 이용해 검색 카테고리 설정
>     2. OPTION에 담긴 VALUE에 따라 파라미터 전달 경로 설정
>     3. input태그에 작성된 검색어와 함께 조건에 맞는 경로로 controller 이동
>     4. @RequestParam 이용해 path에 담긴 파라미터 값 사용
>     5. 검색 시 페이징 작동위해 페이징 메서드 사용
>     
>   - 게시글 상세페이지
>     1. 게시글 별 number를 파라미터로 갖는 a태그 클릭 시 해당 number 조건으로 SELECT
>     2. SELECTED ROW를 Model 이용해 view단에서 사용
>   
>   - 게시글 상태
>     1. DB status컬럼 값 따라 종료(E), 귀가(B) 상태 tr::after로 커버 
>     2. 게시글 상세내역에서 status 해당 버튼 클릭시 게시글 테이블 status컬럼 UPDATE  
>     
>   - 게시글 댓글
>     1. ajax 이용해 이미 등록된 댓글 가져오기
>     2. 신규 댓글 등록 시 ajax 통해 댓글 테이블 ROW INSERT
>     3. 트래픽 조절 위해 등록, 수정, 삭제 후 reload() 아닌 동적 태그 생성
>     4. session 정보와 댓글 작성자 체크해 삭제, 수정버튼 작성자 한정 생성
>     
>   - 게시글 신고
>     1. 게시글 num을 파라미터로 갖는 a태그의 신고버튼 클릭시 num을 이용해 게시글 제목 추출
>     2. 신고하기 페이지 이동시 제목, 해당 글 번호 가져가 대상 게시글 이동 가능
>     3. 신고 작성완료 작성 시 controller에서 request.getHeader()통해 url 획득 
>     4. service에서 VO로 value받아 신고테이블 row INSERT  
>     
>   - 게시글 수정(UPDATE)
>     1. 수정 클릭 시 게시글 number 파라미터로 전달해 DB에서 해당 정보 SELECT
>     2. 수정 완료 시 CREATE과 같은 방법으로 UPDATE 쿼리 실행
>     3. 등록된 파일 모두 삭제시 hasimg='N'변경 반대의 경우 'Y' WHERE절 추가
>   
>   - 게시글 삭제(DELETE)
>     1. 삭제 아닌 DB isdelete 컬럼 'Y'처리
>     2. selectList시 WHERE절 isdelete = 'N'  
>     
>   - 게시글 작성(CREATE)
>     1. 파일 업로드 후 sumbit시 ajax로 controller에 넘겨진 파일명 & UUID json화, 지정path에 파일 저장 
>     2. 파일 위한 form태그에 파일명 & UUID json화된 내용 할당
>     3. 게시판 쿼리에 설정한 useGeneratedKeys="true" 통해 PK(게시글번호) 획득
>     4. DB 파일 테이블에 PK, 파일명, UUID추가
>     5. 스마트 에디터 내 작성 내용 form:textarea로 전달
>     6. submit시 form:form modelAttribute 설정된 VO에 VALUE 할당
>     7. controller통해 SERVICE로 전달된 json화 파일 정보는 GSON 통해 배열화 거쳐 List타입 변환
>     8. 등록된 파일 없을 시 hasimg 컬럼 'N', 있을 시 'Y' WHERE절 추가
>     9. 복수개 파일일 때 모두 완료시에만 DB INSERT 되도록 메서드에 @Transactional 추가 
>     10. 로그인 세션 정보 유무에 따른 게시글 작성 가능 여부
>     
> - #### 셀프 전단지
>   - 전단지 내역
>     1. WHERE isdelete = 'N' 조건 selectList 가져오기
>     2. 복수개 파일은 c:set으로 flag값 설정해 파일 1개 가져왔을 시 flag 변경으로 출력 제한 
>     3. 리스트마다 a태그에 전단지 테이블 num값 부여해 상세 내역 이동 가능
>     
>   - 전단지 상태
>     1. DB status컬럼 값 따라 종료(E), 귀가(B) 상태 div::after로 커버 
>     2. 전단지 상세내역에서 status 해당 버튼 클릭시 전단지 테이블 status컬럼 UPDATE
>     
>   - 전단지 제작
>     1. form:input태그 value 작성 후 modelAttribute 지정된 VO에 맞춰 값 할당 
>     2. 전단지 컬러는 input:color value change시 form:hidden value에 color 코드 삽입
>     3. controller 통해 service로 전달 후 전단지 테이블 ROW INSERT
>     
>   - 전단지 미리보기
>     1. JSTL로 parent페이지의 value를 미리보기 팝업 child로 전달
>     
>   - 전단지 프린트
>     1. @media print 이용한 프린트 영역 설정
>     2. 프린트 영역 제외 나머지 display:none
>     
>   - 전단지 댓글
>     1. ajax 이용해 이미 등록된 댓글 가져오기
>     2. 신규 댓글 등록 시 ajax 통해 댓글 테이블 ROW INSERT
>     3. 트래픽 조절 위해 등록, 수정, 삭제 후 reload() 아닌 동적 태그 생성
>     4. session 정보와 댓글 작성자 체크해 삭제, 수정버튼 작성자 한정 생성
>     
> - #### 봉사 게시판
>   - 봉사 게시판
>     1. c:if로 관리자 레벨 시에만 글쓰기 버튼 생성
>     
>   - 봉사 게시판 상세내역
>     1. 로그인 세션 유무에 따라 게시글 상세내역 이동 가능
>     2. 봉사 테이블 DB 등록된 dateFrom, dateTo 따라 input:date min, max 설정
>     
>   - 봉사 게시판 댓글
>     1. 세션에 저장된 정보 getSession()통해 contact 컬럼 가져와 신청시 자동 등록
>     2. 타인 번호이거나 관리자 레벨이 아닌 경우 연락처 일부 마스킹 처리 
>     
> - #### 후원 게시판 
>   - 후원하기
>     1. 후원 금액 0원 이상 선택시 i'mport API 실행
>     2. JSTL이용해 i'mport 포맷에 회원 정보 및 금액 지정
>     3. 결제 성공시 DB 후원 테이블 ROW INSERT
>     4. 마이페이지의 후원 이동되며 SELECT SUM(donation)으로 금액 표시
>     
> - #### 마이페이지 
>   - 유기견 실종•목격 내역
>     1. 로그인 세션 getSession()으로 id 추출해 실종테이블 selectList
>     2. status에 따른 상태 표시 
>     3. 제목 클릭시 게시판 num, 게시글 num 파라미터 controller로 전송해 해당 글 이동
>     
>   - 기부 현황
>     1. 로그인 세션 getSession()으로 id 추출해 donation테이블 SELECT SUM(donation)
>     2. model로 해당 값 view단 출력
>     
>   - 봉사 현황
>     1. 로그인 세션 getSession()으로 id 추출해 volunteer테이블 selectList
>     2. 제목 클릭시 게시판 num, 게시글 num 파라미터 controller로 전송해 해당 글 이동
>     
>   - 신고 내역
>     1. 로그인 세션 getSession()으로 id 추출해 report테이블 selectList
>     2. 관리자 레벨 댓글 작성시 status = 'Y' UPDATE로 답변완료 처리
>     
#
## 📸Demonstration
#
## 📑Attached
#### 첨부1        
<img src="https://user-images.githubusercontent.com/88533162/158518244-aac08a6c-86fb-4d8a-a4cd-65f10e7cc92c.png" style="width: 300px; height: 250px;">
        
#### 첨부2        
<img src="https://user-images.githubusercontent.com/88533162/158519441-372c7ae9-0ca5-4d53-9047-6b2a394193c4.png" style="width: 300px; height: 250px;">
        
#### 첨부3
<img src="https://user-images.githubusercontent.com/88533162/158519623-c8f37cb2-9d31-4fda-b4b4-468719d90670.png" style="width: 300px; height: 250px;">
