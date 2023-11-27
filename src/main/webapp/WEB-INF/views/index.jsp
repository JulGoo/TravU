<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>

<meta charset="UTF-8"/>

<div id="layoutSidenav_content">

    <div class="container-fluid px-4" style="margin-left: 120px; margin-top: 50px;">
        <div class="container">
            <h1 class="mt-4">나의 여행 지도</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item active">여행 일정을 추가하면 지도에 표시됩니다!</li>
            </ol>
        </div>
        <br>

        <div style="border: black 2px; width: 1300px;">
            <div id="map" style="height:1300px;"></div>
            <script type="text/javascript"
                    src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8172b88ec2c23b8d15e973024008164a"></script>
            <script>
                var container = document.getElementById('map');
                var options = {
                    center: new kakao.maps.LatLng(35, 128),
                    level: 12
                };

                var map = new kakao.maps.Map(container, options);
            </script>
        </div>
    </div>
</div>
</div>


<%@include file="footer.jsp" %>
</body>
</html>
