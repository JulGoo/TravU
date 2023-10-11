<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%@ page import="com.main.TravU.dto.qna.Bbs_qnaDTO"%>

<meta charset="UTF-8" />

<%
Bbs_qnaDTO bqdto = (Bbs_qnaDTO) request.getAttribute("bqdto");
%>

<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4">Q&A</h1>
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item active">질문해주세요!!</li>
			</ol>
			<form method="post" action="/board/update/QnA.do">
				<table class="table table-bordered">
					<tr>
						<th>제목</th>
						<td><input type="text" class="form-control"
							value="<%=bqdto.getTitle()%>" name="title" maxlength="30"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea class="form-control" name="content"
								maxlength="1024"><%=bqdto.getContent()%></textarea></td>
					</tr>
					<tr>
						<th>파일 업로드</th>
						<td>
							<div class="file_list">
								<div>
									<div class="file_input">
										<input type="file" name="files" onchange="selectFile(this);"
											value="file" />
										<button type="button" onclick="removeFile(this);">
											<span>삭제</span>
										</button>
										<button type="button" onclick="addFile();">
											<span>파일추가</span>
										</button>
									</div>
								</div>
							</div>
						</td>
					</tr>
				</table>
				<input type="submit" class="btn btn-outline-dark" value="수정"
					id="save" onClick="location.href='/board/update/QnA.do'">
				<div style="display:none">
				 <input type="number" value="<%=bqdto.getNo()%>" name="no"></div>
			</form>
		</div>
	</main>
</div>

<%@ include file="footer.jsp"%>