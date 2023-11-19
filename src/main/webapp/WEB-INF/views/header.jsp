<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>TravU</title>
    <link
            href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css"
            rel="stylesheet"/>
    <link href="/css/styles.css" rel="stylesheet"/>
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
            crossorigin="anonymous"></script>

    <!--summernote-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="/js/summernote/summernote-lite.js"></script>
    <script src="/js/summernote/lang/summernote-ko-KR.js"></script>
    <link rel="stylesheet" href="/css/summernote/summernote-lite.css">

</head>
<body class="sb-nav-fixed">
<nav class="sb-topnav navbar navbar-expand navbar-setting bg-setting">
    <!-- Navbar Brand-->
    <a class="navbar-brand ps-3" href="/">TravU</a>
    <!-- Sidebar Toggle-->
    <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
            id="sidebarToggle" href="#!">
        <i class="fas fa-bars"></i>
    </button>
    <!-- Navbar Search-->
    <form
            class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
        <div class="input-group">
            <input class="form-control" type="text" placeholder="Search for..."
                   aria-label="Search for..." aria-describedby="btnNavbarSearch"/>
            <button class="btn btn-primary" id="btnNavbarSearch" type="button">
                <i class="fas fa-search"></i>
            </button>
        </div>
    </form>
    <!-- Navbar-->
    <%
        String userID = (String) session.getAttribute("userID");

        //로그인 전
        if (userID == null) {
    %>
    <nav class="login">
        <div class="loginregister">
            <a href="/login.do" class="loginregister">로그인</a> <a
                href="/register.do" class="loginregister">회원가입</a>
        </div>
    </nav>

    <%
        //로그인 후
    } else {
    %>
    <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
        <li class="nav-item dropdown"><a
                class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
                role="button" data-bs-toggle="dropdown" aria-expanded="false"><i
                class="fas fa-user fa-fw"></i></a>
            <ul class="dropdown-menu dropdown-menu-end"
                aria-labelledby="navbarDropdown">
                <li><a class="dropdown-item" href="#!">설정</a></li>
                <li><a class="dropdown-item" href="#!">마이페이지</a></li>
                <li>
                    <hr class="dropdown-divider"/>
                </li>
                <li><a class="dropdown-item" href="/logout.do">로그아웃</a></li>
            </ul>
        </li>
    </ul>
    <%
        }
    %>
</nav>

<div id="layoutSidenav">
    <div id="layoutSidenav_nav">
        <nav class="sb-sidenav accordion sb-sidenav-setting"
             id="sidenavAccordion">
            <div class="sb-sidenav-menu">
                <div class="nav">
                    <div class="sb-sidenav-menu-heading">Travel with U</div>
                    <a class="nav-link" href="/">
                        <div class="sb-nav-link-icon">
                            <i class="fas fa-tachometer-alt"></i>
                        </div>
                        Home
                    </a>

                    <div class="sb-sidenav-menu-heading">후기 게시판</div>

                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                       data-bs-target="#collapseLayouts" aria-expanded="false"
                       aria-controls="collapseLayouts">
                        <div class="sb-nav-link-icon">
                            <i class="fas fa-columns"></i>
                        </div>
                        국내여행
                        <div class="sb-sidenav-collapse-arrow">
                            <i class="fas fa-angle-down"></i>
                        </div>
                    </a>
                    <div class="collapse" id="collapseLayouts"
                         aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav">
                            <a class="nav-link" href="#">서울</a> <a class="nav-link" href="#">부산</a>
                            <a class="nav-link" href="#">대구</a> <a class="nav-link" href="#">인천</a>
                            <a class="nav-link" href="#">광주</a> <a class="nav-link" href="#">대전</a>
                            <a class="nav-link" href="#">울산</a> <a class="nav-link" href="#">세종</a>
                            <a class="nav-link" href="#">경기</a> <a class="nav-link" href="#">충청</a>
                            <a class="nav-link" href="#">전라</a> <a class="nav-link" href="#">경상</a>
                            <a class="nav-link" href="#">강원</a> <a class="nav-link" href="#">제주</a>
                        </nav>
                    </div>


                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                       data-bs-target="#collapsePages" aria-expanded="false"
                       aria-controls="collapsePages">
                        <div class="sb-nav-link-icon">
                            <i class="fas fa-book-open"></i>
                        </div>
                        해외여행
                        <div class="sb-sidenav-collapse-arrow">
                            <i class="fas fa-angle-down"></i>
                        </div>
                    </a>

                    <div class="collapse" id="collapsePages"
                         aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav accordion"
                             id="sidenavAccordionPages">

                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                               data-bs-target="#pagesCollapseJapen" aria-expanded="false"
                               aria-controls="pagesCollapseJapen"> 일본
                                <div class="sb-sidenav-collapse-arrow">
                                    <i class="fas fa-angle-down"></i>
                                </div>
                            </a>
                            <div class="collapse" id="pagesCollapseJapen"
                                 aria-labelledby="headingOne"
                                 data-bs-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="#">도쿄</a> <a class="nav-link"
                                                                           href="#">오사카</a> <a class="nav-link"
                                                                                               href="#">후쿠오카</a> <a
                                        class="nav-link" href="#">교토</a>
                                </nav>
                            </div>

                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                               data-bs-target="#pagesCollapseVietnam" aria-expanded="false"
                               aria-controls="pagesCollapseVietnam"> 베트남
                                <div class="sb-sidenav-collapse-arrow">
                                    <i class="fas fa-angle-down"></i>
                                </div>
                            </a>
                            <div class="collapse" id="pagesCollapseVietnam"
                                 aria-labelledby="headingOne"
                                 data-bs-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="#">다낭</a> <a class="nav-link"
                                                                           href="#">호치민</a> <a class="nav-link"
                                                                                               href="#">하노이</a> <a
                                        class="nav-link" href="#">나트랑</a>
                                </nav>
                            </div>

                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                               data-bs-target="#pagesCollapseUSA" aria-expanded="false"
                               aria-controls="pagesCollapseUSA"> 미국
                                <div class="sb-sidenav-collapse-arrow">
                                    <i class="fas fa-angle-down"></i>
                                </div>
                            </a>
                            <div class="collapse" id="pagesCollapseUSA"
                                 aria-labelledby="headingOne"
                                 data-bs-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="#">하와이</a> <a class="nav-link"
                                                                            href="#">뉴욕</a> <a class="nav-link"
                                                                                               href="#">로스엔젤레스</a>
                                </nav>
                            </div>

                        </nav>
                    </div>


                    <div class="sb-sidenav-menu-heading">Q&A</div>
                    <a class="nav-link" href="/board/list/QnA.do">
                        <div class="sb-nav-link-icon">
                            <i class="fas fa-chart-area"></i>
                        </div>
                        질문게시판
                    </a>

                    <div class="sb-sidenav-menu-heading">여행 계획하기</div>
                    <a class="nav-link" href="/travel/plan/list.do">
                        <div class="sb-nav-link-icon">
                            <i class="fas fa-chart-area"></i>
                        </div>
                        일정 만들기
                    </a>
                    <a class="nav-link" href="tables.jsp">
                        <div class="sb-nav-link-icon">
                            <i class="fas fa-table"></i>
                        </div>
                        AI 스케줄링
                    </a>
                </div>
            </div>
        </nav>
    </div>
<%-- /div 닫지 않기 --%>