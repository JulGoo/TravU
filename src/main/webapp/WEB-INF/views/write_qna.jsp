<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%@ page import="com.main.TravU.dto.qna.Bbs_qnaDTO"%>

<meta charset="UTF-8" />

<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4">Q&A</h1>
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item active">질문해주세요!!</li>
			</ol>
			<form method="post" action="/board/save/QnA.do" autocomplete="off" enctype="multipart/form-data">
				<table class="table table-bordered customize">
					<tr>
						<th>제목</th>
						<td><input type="text" class="form-control"
							placeholder="제목을 적어주세요." name="title" maxlength="30"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea id="summernote" class="form-control" placeholder="내용을 적어주세요."
								name="content" maxlength="1024" value="content"></textarea></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td colspan="3">
							<div class="file_list">
								<div>
									<div class="file_input">
										<input type="text" readonly />
											<input type="file" name="files" onchange="selectFile(this);" />
									</div>
									<button type="button" onclick="removeFile(this);" class="btns del_btn"><span>삭제</span></button>
									<button type="button" onclick="addFile();" class="btns fn_add_btn"><span>파일 추가</span></button>
								</div>
							</div>
						</td>
					</tr>
				</table>
				<input type="submit" class="btn btn-outline-dark" value="작성"
					id="save" onClick="location.href='/board/save/QnA.do'">
			</form>
		</div>
	</main>

<script type="text/javascript" src="/js/file.js"></script>
<script>
	$('#summernote').summernote({
		height: 400,                 // 에디터 높이
		minHeight: null,             // 최소 높이
		maxHeight: null,             // 최대 높이
		focus: false,                  // 에디터 로딩후 포커스를 맞출지 여부
		lang: "ko-KR",					// 한글 설정
		placeholder: '최대3000자까지 쓸 수 있습니다'	,//placeholder 설정
		toolbar: [
			// [groupName, [list of button]]
			['fontname', ['fontname']],
			['fontsize', ['fontsize']],
			['color', ['color']],
			['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
			['para', ['ul', 'ol', 'paragraph']],
			['height', ['height']]
		],
		fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
		fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']

	});
</script>

<%@ include file="footer.jsp"%>



