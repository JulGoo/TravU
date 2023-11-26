<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>

<meta charset="UTF-8"/>

<link href="/css/planViewStyle.css" rel="stylesheet"/>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet"/>

<div id="layoutSidenav_content">
    <div class="container-fluid px-4" style="margin-left: 20px;">
        <div id="schedule" class="pt90 pb90">
            <div class="container">
                <div class="row" style="margin-left: 630px">
                    <div class="col-sm-8 mr-auto ml-auto text-center">
                        <div class="center-title mb60">
                            <br>
                            <h2 style="font-weight: bold">Event Schedule</h2>
                            <p class="lead">
                                02 - 04 November 2016.
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
                                <%-- 탭 반복 --%>
                                <% for (int i = 0; i < 2; i++) { %>

                                <li role="presentation" class="nav-item">
                                    <a class="nav-link" href="#01" aria-controls="01" role="tab"
                                       data-toggle="tab" aria-selected="false" id="day+${i}" onclick="showThis(this)">
                                        Day 1
                                        <span>1 November 2016</span>
                                    </a>
                                </li>
                                <% } %>
                            </ul>

                            <!-- 탭 별 계획 디테일 반복 -->
                            <% for (int i = 0; i < 2; i++) { %>
                            <div class="tab-content" id="dayPlan">
                                <div role="tabpanel" class="tab-pane fade active show" id="01">

                                    <%-- 세부 계획 반복 --%>
                                    <% for (int j = 0; j < 5; j++) { %>
                                    <div class="row margin-b-30">
                                        <div class="col-sm-3 event-info">
                                            <span>Monday</span>
                                            <span>9:00 AM to 10:45 AM</span>
                                            <span class="event-hall">Basement R1</span>
                                        </div>
                                        <div class="col-sm-9 event-detail">
                                            <h3>Introducing bootstrap4 features</h3>
                                            <div class="row margin-b-20">
                                                <div class="col-sm-10">
                                                    <h4>Nikita Miller</h4>
                                                    <p>
                                                        But I must explain to you how all this mistaken idea of
                                                        denouncing pleasure and praising pain was born and I will give
                                                        you a complete account of the system, and expound the actual
                                                        teachings, the master-builder of human happiness
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <br>
                                    <% } %>

                                </div>
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