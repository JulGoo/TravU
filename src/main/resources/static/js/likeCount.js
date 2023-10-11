function likeAction() {
	var userID = $("#userID").val();
	var no = $("#no").val();
	
	if(userID == "null") {
		alert("로그인 후 이용해주세요!");
		return;
	}
	
	$.ajax({
		url:"/board/view/QnA/Like.do",
		type:"post",
		dataType:"text",
		data:{"userID" : userID, "no" : no},
		success: function(data) {
			if(data == -1) {
				likeDown();
				document.getElementById("bt").className="likedown";
			} else{
				document.getElementById("bt").innerText="좋아요 +" + data;
				document.getElementById("bt").className="likeup";
			}
		},
		error: function(request, error) {
			console.log("code : " + request.status);
			console.log("message : " + request.responseText);
			console.log("error : " + error);
		}
	});
};


function likeDown() {
	var userID = $("#userID").val();
	var no = $("#no").val();
	
	$.ajax({
		url:"/board/view/QnA/LikeDown.do",
		type:"post",
		dataType:"text",
		data:{"userID" : userID, "no" : no},
		success: function(data) {
			document.getElementById("bt").innerText="좋아요 +" + data;
		},
		error: function(request, error) {
			console.log("code : " + request.status);
			console.log("message : " + request.responseText);
			console.log("error : " + error);
		}
	});
};


