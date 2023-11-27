<%@ page import="java.util.ArrayList" %>
<%@ page import="com.main.TravU.dto.PlanCardDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>

<meta charset="UTF-8"/>

<%
    ArrayList<PlanCardDTO> planCardDTO = (ArrayList<PlanCardDTO>) request.getAttribute("planCardDTO");
%>


<div id="layoutSidenav_content">

    <div class="container-fluid px-4" style="margin-left: 120px; margin-top: 50px;">
        <div class="container">
            <h1 class="mt-4">나의 여행 지도</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item active">여행 일정을 추가하고 나만의 여행 지도를 만들어보세요!</li>
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

                var positions = [];

                console.log(<%=planCardDTO.size()%>);

                <%
                for (int i = 0;i < planCardDTO.size(); i++) {
                %>

                positions[<%=i%>] = {
                    content: '<div style="font-weight:bold; font-size:larger;"><%=planCardDTO.get(i).getPlanName()%></div>',
                    latlng: new kakao.maps.LatLng(<%=planCardDTO.get(i).getLat()%>, <%=planCardDTO.get(i).getLng()%>)
                }

                <%
                }
                %>

                for (var i = 0; i < positions.length; i++) {
                    // 마커를 생성합니다
                    var marker = new kakao.maps.Marker({
                        map: map, // 마커를 표시할 지도
                        position: positions[i].latlng // 마커의 위치
                    });

                    // 마커에 표시할 인포윈도우를 생성합니다
                    var infowindow = new kakao.maps.InfoWindow({
                        content: positions[i].content // 인포윈도우에 표시할 내용
                    });

                    // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
                    // 이벤트 리스너로는 클로저를 만들어 등록합니다
                    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
                    kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
                    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
                }

                // 인포윈도우를 표시하는 클로저를 만드는 함수입니다
                function makeOverListener(map, marker, infowindow) {
                    return function () {
                        infowindow.open(map, marker);
                    };
                }

                // 인포윈도우를 닫는 클로저를 만드는 함수입니다
                function makeOutListener(infowindow) {
                    return function () {
                        infowindow.close();
                    };
                }
            </script>
        </div>
    </div>
</div>
</div>


<%@include file="footer.jsp" %>
</body>
</html>
