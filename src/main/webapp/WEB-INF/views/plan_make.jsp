<%@ page import="com.main.TravU.dto.PlanCardDTO" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>

<meta charset="UTF-8"/>

<link href="/css/planViewStyle.css" rel="stylesheet"/>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet"/>

<%
    PlanCardDTO planCardDTO = (PlanCardDTO) request.getAttribute("planCardDTO");
%>

<div id="layoutSidenav_content">
    <div class="container-fluid px-4" style="margin-left: 20px;">
        <div id="schedule" class="pt90 pb90">
            <div class="container">
                <div class="row" style="margin-left: 630px">
                    <div class="col-sm-8 mr-auto ml-auto text-center">
                        <div class="center-title mb60">
                            <br>
                            <h2 style="font-weight: bold"><%=planCardDTO.getPlanName()%>
                            </h2>
                            <p class="lead">
                                <%=planCardDTO.getStartDate()%> ~
                                <%=planCardDTO.getEndDate()%>
                            </p>
                        </div>
                    </div>
                </div>
                <br>
                <br>
                <br>

                <div class="row margin-b-30" style="margin-left: 150px; width: 1400px">
                    <div class="col-md-10 mr-auto ml-auto">
                        <div>
                            <!-- Nav tabs -->
                            <ul class="nav tabs-schedule nav-tabs list-inline" role="tablist">

                                <%
                                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                                    Date startDate = planCardDTO.getStartDate();
                                    Date endDate = planCardDTO.getEndDate();

                                    // 총 날짜 계산
                                    long timeDiff = Math.abs(endDate.getTime() - startDate.getTime());
                                    int daysDiff = (int) (timeDiff / (1000 * 60 * 60 * 24));
                                %>

                                <%-- 탭 반복 --%>
                                <% for (int i = 1; i <= daysDiff; i++) { %>

                                <li role="presentation" class="nav-item">
                                    <a class="nav-link" href="#01" aria-controls="01" role="tab"
                                       data-toggle="tab" aria-selected="false" id="day+${i}" onclick="showThis(this)">
                                        Day <%=i%>
                                    </a>
                                </li>
                                <% } %>
                            </ul>

                            <!-- 탭 별 계획 디테일 반복 -->
                            <% for (int i = 1; i <= 1; i++) { %>
                            <div class="tab-content" id="dayPlan">
                                <div role="tabpanel" class="tab-pane fade active show" id="days+${i}">
                                    <div class="plans">
                                        <%-- 세부 계획 --%>
                                        <div class="row margin-b-30">
                                            <div class="col-sm-3 event-info">
                                                <input type="time" name="startTime">
                                                <span class="event-hall"><input type="text" name="place"></span>
                                            </div>
                                            <div class="col-sm-9 event-detail">
                                                <h3><input type="text" name="title"></h3>
                                                <div class="row margin-b-20">
                                                    <div class="col-sm-10">
                                                        <p>
                                                            <textarea type="text" name="content" style="width: 700px; height: 200px"></textarea>
                                                        </p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <br>
                                    </div>
                                </div>
                                <button type="button" onclick="addPlan();"
                                        style="width: 50px; height: 50px;font-weight: bold; font-size: xx-large; float:right; background-color: rgb(251,230,225)">
                                    +
                                </button>
                            </div>
                        </div>
                    </div>
                    <% } %>
                </div>
            </div>
        </div>
    </div>
</div>

</div>

<script type="text/javascript" src="/js/plan.js"></script>