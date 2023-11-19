function addCard(){
    const cardDiv = document.createElement('div');
    cardDiv.innerHTML = `
    <div class="col-md-4" style="height: 310px; width: 410px; margin-right: 70px; margin-bottom: 50px">
        <div class="profile-card-2" style="height: 300px; width: 400px">
            <img 
            src="/upload_files/cd2db071e796481cbdb334dc4bdb0651.png"
            class="img img-responsive" style="height: 300px; width: 400px">
            <div class="profile-name" style="text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;">
                <input type="text" name="planName" placeholder="여행 이름을 입력하세요." style="margin-bottom: 35px">
            </div>
            <div class="profile-username" style="text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black; margin-bottom: 0px">
                 <input type="date" name="startDate"> ~ 
                 <input type="date" name="endDate">
            </div>
            <button type="submit" value="저장" style="margin-top: 0px;"></button>
        </div>
    </div>
    `;
    document.querySelector('.row').appendChild(cardDiv);
}

