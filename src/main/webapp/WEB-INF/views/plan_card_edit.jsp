<%@ page import="java.util.ArrayList" %>
<%@ page import="com.main.TravU.dto.PlanCardDTO" %>
<%@ page import="java.io.Console" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>

<meta charset="UTF-8"/>

<%
    ArrayList<PlanCardDTO> planCardDTO = (ArrayList<PlanCardDTO>) request.getAttribute("cards");
    if(planCardDTO == null){
        PrintWriter errOut = response.getWriter();
        errOut.println("<script>alert('hihi');</script>");
        errOut.close();
    }
%>

<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4" style="margin-left: 20px">
            <div class="container" style="margin-left: 0px">
                <h1 class="mt-4">Make a Plan</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item active">나의 여행 계획을 작성하고 추억해보세요!</li>
                </ol>
            </div>
            <br>
            <div class="container" style="margin-top: 20px;">
                <div class="row" style="margin-top: 20px;">
                    <%
                        for (int i = 0; i < planCardDTO.size(); i++) {
                    %>
                    <div class="col-md-4" style="height: 310px; width: 410px">
                        <div class="profile-card-2" style="height: 300px; width: 400px"
                             onclick="location.href='plan?no=<%=planCardDTO.get(i).getPlanNo()%>'">
                            <img
                                    src="/upload_files/cd2db071e796481cbdb334dc4bdb0651.png"
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
    </main>
</div>