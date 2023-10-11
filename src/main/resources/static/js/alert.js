window.addEventListener('DOMContentLoaded', function() {
	msg = document.getElementById("msg").innerText;
	
	if(msg == null) {
		return;
	}
	
	if(msg == 0) {
		alert("아이디가 존재하지 않습니다.");
		location.href="login.do";
		return;
	} else if(msg == 1) {
		alert("아이디와 비밀번호가 일치하지 않습니다.");
		location.href="login.do";
		return;
	} else if(msg == 2) {
		alert("로그인되었습니다.");
		location.href="/";
		return;
	} else if(msg == 3) {
		alert("database error");
		location.href="login.do";
		return;
	}
	
	
	
	
});