// 파일 선택
function selectFile(element) {

    const file = element.files[0];
    const filename = element.closest('.file_input').firstElementChild;

    // 1. 파일 선택 창에서 취소 버튼이 클릭된 경우 또는 파일 선택이 취소된 경우
    if (!file) {
        filename.value = '';
        return false;
    }

    // 2. 파일 크기가 10MB를 초과하는 경우
    const fileSize = Math.floor(file.size / 1024 / 1024);
    if (fileSize > 10) {
        alert('10MB 이하의 파일로 업로드해 주세요.');
        filename.value = '';
        element.value = '';
        return false;
    }

    // 3. 파일명 지정
    filename.value = file.name;
}

//파일 추가
function addFile() {
    const fileDiv = document.createElement('div');
    fileDiv.innerHTML = `
         <div class="file_input">
            <input type="text" readonly />
            <input type="file" name="files" onchange="selectFile(this);" />
         </div>
         <button type="button" onclick="removeFile(this);" class="btns del_btn"><span>삭제</span></button>
         		        `;
    document.querySelector('.file_list').appendChild(fileDiv);
}

// 파일 등록 삭제
function removeFile(element) {
    const fileAddBtn = element.nextElementSibling;
    if (fileAddBtn) {
        const inputs = element.previousElementSibling.querySelectorAll('input');
        inputs.forEach(input => input.value = '')
        return false;
    }
    element.parentElement.remove();
}

// 파일 수정 삭제
function deleteButton(element, num, fileNo){
    const deleteF = document.querySelector('#deleteFile');
    deleteF.remove();
    const imgNum = document.getElementById(num);
    imgNum.remove();

    var deleteFN = document.createElement("input");
    deleteFN.setAttribute("type", "number");
    deleteFN.setAttribute("style", "display:none;");
    deleteFN.setAttribute("name", "deleteIt")
    deleteFN.setAttribute("value", fileNo);
    document.getElementById("fileProcess").appendChild(deleteFN);

}
