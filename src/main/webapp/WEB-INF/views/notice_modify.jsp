<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
	main {
	display: flex;
	flex-direction: row;
}

main section {
	width: 1200px;
	height: 680px;
	margin: auto;
}

/* article1 */

main section article #noticeBoard {
	height:620px;
	margin: 20px 25px 0 25px;
	padding: 25px;
	border: 25px solid #f9f1c0;
    border-radius: 25px;
    overflow: auto;
}

main section #arti1 #noticeBoard h1:nth-child(1)::after {
	content: "";
	display: block;
	width: 100%;
	border-bottom: 2px solid black;
	margin-top: 10px;
}

main section #arti1 #noticeBoard h2{
	background-color: #f9f1c0;
	border-top: 1px solid black;
	border-bottom: 1px solid black;
}

main section #arti1 #noticeBoard h4{
	border-bottom: 1px solid black;
	padding:5px;
}

main section #arti1 #noticeBoard p{
	padding:10px;
}

main section #arti1 #noticeButtons{
	text-align: end;
    margin: 5px 60px 0 0px;
}

.button {
  width: 180px;
  height: 60px;
  position: absolute;
}
button {
  width: 60px;
  height: 25px;
  cursor: pointer;
  background: transparent;
  border: 1px solid #FBD157;
  outline: none;
  transition: 1s ease-in-out;
}
svg {
  position: absolute;
  left: 0;
  top: 0;
  fill: none;
  stroke: #fff;
  stroke-dasharray: 150 480;
  stroke-dashoffset: 150;
  transition: 1s ease-in-out;
}
button:hover {
  transition: 1s ease-in-out;
  background: #FBD157;
}
button:hover svg {
  stroke-dashoffset: -480;
}
button span {
  color: black;
  font-size: 15px;
  font-weight: 500;
}
</style>
</head>
<body>
	<div class="totalContainer">
		<jsp:include page="/WEB-INF/views/layout/header.jsp" />
		
		<main>
			<section>
				<article id="arti1">
					
					
					<div id="noticeBoard">
						<h1>${NoticeVO.title} 수정</h1><br /><br />
						
						<form:form modelAttribute="NoticeVO" action="${pageContext.request.contextPath}/Notice/modify_result">
							<ul>
								<li><label for="title"></label><form:input path="title" 
								style="width:100%; border:none; outline:none; background-color:#f9f1c0;
										border-top:1px solid black; border-bottom:1px solid black;
										font-size:1.5rem; padding:5px;"/></li>
								<h4>${NoticeVO.name } | ${NoticeVO.date }</h4><br />
								<li><form:textarea path="content" cols="145" rows="19"/></li>
								<form:hidden path="num"/>
								<form:hidden path="filelist"/>
							</ul>
						</form:form>
						<c:forEach var="file" items="${filelist}">
							<div class="file-item">
								<a href="${pageContext.request.contextPath}/downloadFile/${file.localName}/${file.serverName}">${file.localName}</a>
								<button data-num="${file.num}" class="deleteFile">삭제</button>
							</div>
						</c:forEach>
						
						<button class="alldelete" data-bnum="${NoticeVO.num}">전체삭제</button><br>
						<label for="upload">파일 추가 :</label><input type="file" id="upload" name="upload" multiple>
		
					</div>
					
					<div id="noticeButtons">
						<button id="delete">
					         <svg width="60px" height="25px" viewBox="0 0 180 60" class="border">
					           <polyline points="179,1 179,59 1,59 1,1 179,1" class="bg-line" />
					           <polyline points="179,1 179,59 1,59 1,1 179,1" class="hl-line" />
					         </svg>
					         <span>삭제</span>
					    </button>
					    <button id="modify">
					         <svg width="60px" height="25px" viewBox="0 0 180 60" class="border">
					           <polyline points="179,1 179,59 1,59 1,1 179,1" class="bg-line" />
					           <polyline points="179,1 179,59 1,59 1,1 179,1" class="hl-line" />
					         </svg>
					         <span>수정</span>
					    </button>
					    <button id="listMove">
					         <svg width="60px" height="25px" viewBox="0 0 180 60" class="border">
					           <polyline points="179,1 179,59 1,59 1,1 179,1" class="bg-line" />
					           <polyline points="179,1 179,59 1,59 1,1 179,1" class="hl-line" />
					         </svg>
					         <span>목록</span>
					    </button>
					</div>
				</article>
			</section>
		</main>
		
	
		<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
	</div>
	<script>
		$(function(){
			let flagSingle = false;
			let flagAll = false;
			let bnum = 0;
			let num = [];
			
			$(".deleteFile").click(function(){
				flagSingle = true;
				num.push({num : this.dataset.num});
				$(this).parent().remove();
			});
			
			$(".alldelete").click(function(){
				flagAll = true;
				bnum = this.dataset.bnum;
				$(".file-item").remove();
			});
			
			
			
			$("#modify").click(function(){
				if(confirm("정말로 수정하시겠습니까?")){
					if(flagAll){
						$.ajax({
							url : '${pageContext.request.contextPath}/Notice/deleteFileAll',
							data : JSON.stringify({bnum : bnum}),
							type : "post",
							contentType:"application/json; charset=utf-8",
							datatype : "json",
							success: function(result){
								console.log(JSON.stringify(result));
							}	
						});	
					}else if(flagSingle){
						$.ajax({
							url : '${pageContext.request.contextPath}/Notice/deleteFile',
							data : JSON.stringify(num),
							type : "post",
							contentType:"application/json; charset=utf-8",
							datatype : "json",
							success: function(result){
								console.log(JSON.stringify(result));
							}
						});		
					}
					
					const formData = new FormData();
					const $upload = $("#upload");
					let files = $upload[0].files;
					
					if(files.length != 0){
						for (var i = 0; i < files.length; i++) {
							formData.append("uploadFile", files[i])	
						}
						
						$.ajax({
							url : '${pageContext.request.contextPath}/Notice/uploadfile',
							processData : false,
							contentType : false,
							data : formData,
							type : "post",
							datatype : "json",
							success: function(result){
								$("#filelist").val(JSON.stringify(result));
								console.log(result);
								$("#NoticeVO").submit();
							}
						});
					}else{
						$("#NoticeVO").submit();
					}
				}
			});
			
		});
	</script>
</body>
</html>