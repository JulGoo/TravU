function addCard(){
    const cardDiv = document.createElement('div');
    cardDiv.innerHTML = `
    <div class="col-md-4" style="height: 310px; width: 410px; margin-right: 70px; margin-bottom: 50px">
        <div class="profile-card-2" style="height: 300px; width: 400px">
        <form method="post" action="/travel/plan_card/save.do" autocomplete="off" enctype="multipart/form-data">
            <img id="preview" name="imgName"
            src="/profile_img/default.jpg"
            class="img img-responsive" style="height: 300px; width: 400px">
            <div class="file_input" style="position: absolute; bottom: 180px; left: 30px;">
                <input type="text" readonly />
                <input type="file" name="file" onchange="fileProcess(this);" style="background-color: whitesmoke"/>
            </div>
            <div class="profile-name" style="text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;">
                <input type="text" name="planName" placeholder="여행 이름을 입력하세요." style="margin-bottom: 35px">
            </div>
            <div class="profile-username" style="text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black; margin-bottom: 0px">
                 <input type="date" name="startDate"> ~ 
                 <input type="date" name="endDate">
            </div>
            <button type="submit" name="save" style="position: absolute; bottom: 250px; left: 330px;">저장</button>
        </form>
        </div>
    </div>
    <hr>
    `;
    document.querySelector('.container').appendChild(cardDiv);
}



