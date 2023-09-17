<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<%
String userPW = (String) session.getAttribute("userPW");

//페이징 처리 필요
%>

<meta charset="UTF-8" />
<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4">여행 후기</h1>
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item active">여행 추억 공유해요!</li>
			</ol>
			
			<div class="container">
			<div class="row">
				<table class="table table-hover">
					<thead class="table-dark">
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>여행지</th>
							<th>여행기간</th>	
							<th>작성자</th>
							<th>작성일</th>
							<th>추천수</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody>
						
						<tr>
							<td>ㄱ</td>
							<td>ㄴ</td>
							<td>ㄷ</td>
							<td>ㄹ</td>
							<td>ㅁ</td>
							<td>ㅂ</td>
							<td>ㅅ</td>
							<td>ㅇ</td>
						</tr>
					
					</tbody>
				</table>

				<!-- 페이징 처리 영역 -->
					
			</div>
			<!-- 글쓰기 버튼 생성 -->
				<input type="button" class="btn btn-dark" value="글쓰기"
					id="write" onClick="location.href='write_review.jsp'">
		</div>
			
			
		</div>

	</main>
	<%@ include file="footer.jsp"%>

</div>


</body>
</html>