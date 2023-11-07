<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="com.main.TravU.dto.qna.Bbs_qnaDTO"%>

<%
ArrayList<Bbs_qnaDTO> bqdto = (ArrayList<Bbs_qnaDTO>) request.getAttribute("list");
%>

<meta charset="UTF-8" />
<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<div class="container">
			<h1 class="mt-4">Q&A</h1>
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item active">질문있어요! 답변해주세요</li>
			</ol>
			</div>
			<br>
			<div class="container">
				<div class="row">
					<table class="table table-hover" style="text-align: center;">
						<thead class="table-dark">
							<tr>
								<th width="3%"></th>
								<th width="42%">제목</th>
								<th width="20%">작성자</th>
								<th width="15%">작성일</th>
								<th width="10%">추천수</th>
								<th width="10%">조회수</th>
							</tr>
						</thead>
						<tbody>
							<%
							for (int i = 0; i < bqdto.size(); i++) {
							%>

							<tr onclick="location.href='/board/view/QnA.do?no=<%=bqdto.get(i).getNo() %>'">
								<td></td>
								<td style="text-align: left;"><%=bqdto.get(i).getTitle()%></td>
								<td><%=bqdto.get(i).getUserID()%></td>
								<td><%=bqdto.get(i).getDate()%></td>
								<td><%=bqdto.get(i).getLikeC()%></td>
								<td><%=bqdto.get(i).getViewC()%></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>

					<!-- 페이징 처리 영역 -->

				</div>
				<!-- 글쓰기 버튼 생성 -->
				<input type="button" class="btn btn-dark" value="글쓰기" id="write"
					onClick="location.href='/board/write/QnA.do'">
			</div>
			<br>
			<br>

		</div>

	</main>
	<%@ include file="footer.jsp"%>

<%--/div footer에서 닫음--%>

</body>
</html>