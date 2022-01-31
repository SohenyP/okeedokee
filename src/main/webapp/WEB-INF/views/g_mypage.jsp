<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/mypage.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>

<div class="container">
	<!-- 헤더 불러오기 -->
	<jsp:include page="/WEB-INF/views/layout/header.jsp"/>
	
	<main>
		<nav>
			<div class="mypageNav">
				<div class="mypageTitle">
					<h3>개인정보</h3>
				</div>
				<div class="mypageSubTitle">
					<a href="mypage" id="focus"><h4>개인정보 변경</h4></a>
				</div>
				<br />
				<div class="mypageTitle">
					<h3>나의 상담 일정</h3>
				</div>
				<div class="mypageSubTitle">
					<a href="reservation" ><h4>상담 예약 내역</h4></a>
				</div>
				<br />
				<div class="mypageTitle">
					<h3>나의 실종 • 목격 신고</h3>
				</div>
				<div class="mypageSubTitle">
					<a href="missingList" ><h4>실종 신고 내역</h4></a>
					<a href="witnessingList" ><h4>목격 신고 내역</h4></a>
				</div>
				<br />
				<div class="mypageTitle">
					<h3>나의 기부 • 자원봉사</h3>
				</div>
				<div class="mypageSubTitle">
					<a href="donationList" ><h4>기부 현황</h4></a>
					<a href="volunteerList" ><h4>자원봉사 현황</h4></a>
				</div>
				<br />
				<div class="mypageTitle">
					<h3>나의 신고 내역</h3>
				</div>
				<div class="mypageSubTitle">
					<a href="reportList" ><h4>신고 내역</h4></a>
				</div>
			</div>
		</nav>
		<section>
			<!-- 개인정보 변경 -->
			<article id="arti1">
				<div class="content">
					<h1>개인정보변경</h1>
					<!-- 여기서부터 작업 시작하세요 -->
					
				</div>
			</article>
			
		</section>
	</main>
	
	<!-- 푸터 불러오기 -->
	<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>
</div>

<script type="text/javascript" src="js/mnw.js"></script>
</body>
</html>