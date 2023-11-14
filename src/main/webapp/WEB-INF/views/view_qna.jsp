<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="com.main.TravU.dto.qna.Bbs_qnaDTO"%>
<%@ page import="com.main.TravU.dto.qna.File_qnaDTO" %>

<%
Bbs_qnaDTO bqdto = (Bbs_qnaDTO) request.getAttribute("bqdto");
List<File_qnaDTO> fqdto = (ArrayList)request.getAttribute("fqdto");
%>

<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<script src="/js/likeCount.js"></script>
<script src="/js/delete.js"></script>

<meta charset="UTF-8" />
<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<br> <br> <br>

			<div class="container">
				<div class="row">
					<h2><%=bqdto.getTitle()%></h2>
					<br> <br> <br> <br>
					<h6 align="right"><%=bqdto.getUserID()%>
						<%=bqdto.getDate()%></h6>
					<br>
					
					<% if(userID.equals(bqdto.getUserID())){ %>
					<div>
						<button id="update" onclick="location.href='/board/update/QnA.do?no=<%=bqdto.getNo() %>'">수정</button>
						<button id="delete" onclick="reallyDelete();">삭제</button>
					</div>
					<%} %>
				
					<div style="display:none;">
						<form action="/board/delete/QnA.do" method="post" name="delete">
							<input type="number" value="<%=bqdto.getNo() %>" name="no">
						</form> 
					</div>
				</div>
			</div>
			<hr>
			<div class="container">
				<br>
				<h5><%=bqdto.getContent()%></h5>

				<div>
					<%
						for(int i=0; i<fqdto.size(); i++) {
					%>
					<img src="/upload_files/<%=fqdto.get(i).getSave() %>" width="400px">
					<%
						}
					%>
				</div>

				<div align="right">
					<input type="text" id="userID" style="display: none;"
						value="<%=userID%>"> <input type="text" id="no"
						style="display: none;" value="<%=bqdto.getNo()%>">
					<%
					boolean check = (boolean) request.getAttribute("check");
					if (check) {
					%>
					<button id="bt" class="bt likeup" onclick="likeAction()">
						좋아요 +<%=bqdto.getLikeC()%></button>
					<%
					} else {
					%>
					<button id="bt" class="bt likedown" onclick="likeAction()">
						좋아요 +<%=bqdto.getLikeC()%></button>
					<%
					}
					%>
				</div>

			</div>
		</div>
	</main>

	<%@ include file="footer.jsp"%>

</div>
</body>
</html>