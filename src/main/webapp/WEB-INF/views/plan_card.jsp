<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.main.TravU.dto.PlanCardDTO" %>
<%@ page import="java.io.Console" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>

<meta charset="UTF-8"/>

<%
    ArrayList<PlanCardDTO> planCardDTO = (ArrayList<PlanCardDTO>) request.getAttribute("cards");
%>


<div id="layoutSidenav_content">

    <div class="container-fluid px-4" style="margin-left: 120px; margin-top: 50px;">
        <div class="container">
            <h1 class="mt-4">Make a Plan</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item active">나의 여행 계획을 작성하고 추억해보세요!</li>
            </ol>
        </div>
        <br>
        <div class="container" style="margin-top: 20px;">
            <div class="row" style="margin-top: 20px; width: 1500px">
                <%
                    for (int i = 0; i < planCardDTO.size(); i++) {
                %>
                <div class="col-md-4" style="height: 310px; width: 410px; margin-right: 70px; margin-bottom: 50px">
                    <div class="profile-card-2" style="height: 300px; width: 400px"
                         onclick="location.href='plan?no=<%=planCardDTO.get(i).getPlanNo()%>'">
                        <img
                                src="/profile_img/<%=planCardDTO.get(i).getImgName() %>"
                                class="img img-responsive" style="height: 300px; width: 400px">
                        <div class="profile-name"
                             style="text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;"><%=planCardDTO.get(i).getPlanName()%>
                        </div>
                        <div class="profile-username"
                             style="text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;"><%=planCardDTO.get(i).getStartDate()%>
                            ~ <%=planCardDTO.get(i).getEndDate()%>
                        </div>
                    </div>
                </div>
                <%
                    }
                %>
            </div>
        </div>

        <%-- 카드 추가 --%>
        <div class="col-md-4" onclick="addCard();"
             style="position: fixed; width: 100px; height: 100px; bottom: 60px; right: 50px; margin: 35px 25px;">
            <div class="profile-card-2"
                 style="height: 100px; width: 100px; background-color: rgb(253,194,190); text-align: center">
                <img
                        src="/img/plus_skinny.png"
                        class="img img-responsive" style="height: 50px; width: 50px; margin-top: 25px">
            </div>
        </div>

    </div>

    <script type="text/javascript" src="/js/plan.js"></script>
    <script src="/js/profileimg.js"></script>

<%@ include file="footer.jsp" %>