function reallyDelete() {
	if(!confirm("정말로 삭제하시겠습니까?")) {
		return;
	} else {
		document.delete.submit();
	}
}