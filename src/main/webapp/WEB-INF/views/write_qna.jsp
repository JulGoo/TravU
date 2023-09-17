<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<meta charset="UTF-8" />

<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4">Q&A</h1>
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item active">질문해주세요!!</li>
			</ol>
			<form method="post" action="writeAction.jsp">
				<table class="table table-bordered">
					<tr>
						<th>제목</th>
						<td><input type="text" class="form-control"
							placeholder="제목을 적어주세요." name="title" maxlength="30"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea class="form-control" placeholder="내용을 적어주세요."
								name="content" maxlength="1024"></textarea></td>
					</tr>
					<tr>
						<th>파일 업로드</th>
						<td>
							<div class="file_list">
								<div>
									<div class="file_input">
										<input type="file" name="files" onchange="selectFile(this);" /> 
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
				<input type="submit" class="btn btn-outline-dark" value="작성"
					id="save">
			</form>
		</div>
	</main>
</div>

<%@ include file="footer.jsp"%>