<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">
		
		<title>Insurance</title>

		<!-- Loading third party fonts -->
		<link href="http://fonts.googleapis.com/css?family=Roboto+Condensed:300,400,700|" rel="stylesheet" type="text/css">
		<link href="/hanalife/fonts/font-awesome.min.css" rel="stylesheet" type="text/css">
		<link href="/hanalife/fonts/lineo-icon/style.css" rel="stylesheet" type="text/css">
		
		<!-- Loading main css file -->
		<link rel="stylesheet" href="/hanalife/style.css">
		
		<!-- w3css 사용 -->
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<!--[if lt IE 9]>
		<script src="js/ie-support/html5.js"></script>
		<script src="js/ie-support/respond.js"></script>
		<![endif]-->

	</head>
	<header class="site-header">
				<div class="top-header">
					<div class="container">
						<a href="${ pageContext.request.contextPath }" id="branding">
							<img src="/hanalife/images/hanaicon.png" alt="Company Name" class="logo">
							<div class="logo-text">
								<h1 class="site-title">HANA 4U</h1>
								<h2 class="description">당신을 위한 단 하나의 선택</h2>
								<c:choose>
									<c:when test="${ not empty loginVO }">
										<h3 class="description">${ loginVO.name }님 환영합니다</h3>
									</c:when>
									<c:when test="${ not empty employee }">
										<h3 class="description">${ employee.name }&nbsp;&nbsp;${ employee.rank}님 환영합니다</h3>
									</c:when>
								</c:choose>
							</div>
						</a> <!-- #branding -->
					
						<div class="right-section pull-right">
							<a href="#" class="phone"><img src="/hanalife/images/icon-phone.png" class="icon">02-3709-7394</a>
					
							<form action="#" class="search-form">
								<input type="text" placeholder="검색">
								<button type="submit"><img src="/hanalife/images/icon-search.png" alt=""></button>
							</form>
						</div>
					</div> <!-- .container -->
				</div> <!-- .top-header -->

				
				<div class="bottom-header">
					<div class="container">
						<div class="main-navigation">
							<button type="button" class="menu-toggle"><i class="fa fa-bars"></i></button>
							<ul class="menu">
							<c:choose>
								<c:when test="${ empty loginVO and empty employee }">
									<li class="menu-item"><a href="${ pageContext.request.contextPath }/login">로그인</a></li>
								</c:when>
								<c:otherwise>
									<c:if test="${ not empty loginVO }">
										<li class="menu-item"><a href="${ pageContext.request.contextPath }/logout">로그아웃</a></li>
									</c:if>
									<c:if test="${ not empty employee }">
										<li class="menu-item"><a href="${ pageContext.request.contextPath }/employeelogout">로그아웃</a></li>
									</c:if>
								</c:otherwise>
							</c:choose>
								<c:if test="${ empty loginVO and empty employee }">
									<li class="menu-item"><a href="${ pageContext.request.contextPath }/about">하나생명소개</a></li>
								</c:if>
								<c:if test="${ not empty loginVO }">
									<li class="menu-item"><a href="${ pageContext.request.contextPath }/customerInfoCompany">하나생명소개</a></li>
								</c:if>
								<c:if test="${ not empty employee }">
									<li class="menu-item"><a href="${ pageContext.request.contextPath }/employeeInfoCompany">하나생명소개</a></li>
								</c:if>
								<c:choose>
									<c:when test="${ not empty employee }">
										<c:if test="${ employee.rank eq '사원'}">
											<li class="menu-item"><a href="${ pageContext.request.contextPath }/performanceManagementService">성과관리</a></li>
										</c:if>
										<c:if test="${ employee.rank eq '대리'}">
											<li class="menu-item"><a href="${ pageContext.request.contextPath }/performanceManagementService">성과관리</a></li>
										</c:if>
										<c:if test="${ employee.rank eq '과장'}">
											<li class="menu-item"><a href="${ pageContext.request.contextPath }/manageEmployeeOfPerformance">성과관리</a></li>										
										</c:if>
										<c:if test="${ employee.rank eq '차장'}">
											<li class="menu-item"><a href="${ pageContext.request.contextPath }/manageEmployeeOfPerformance">성과관리</a></li>										
										</c:if>
										<c:if test="${ employee.rank eq '부장'}">
											<li class="menu-item"><a href="${ pageContext.request.contextPath }/manageEmployeeOfPerformance">성과관리</a></li>										
										</c:if>
									</c:when>
									<c:otherwise>
										<li class="menu-item"><a href="${ pageContext.request.contextPath }/insurance">보험상품</a></li>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${ not empty employee }">
										<li class="menu-item"><a href="${ pageContext.request.contextPath }/insuranceContractService">보험계약서비스관리</a></li>
									</c:when>
									<c:otherwise>
										<li class="menu-item"><a href="${ pageContext.request.contextPath }/resource">보험추천</a></li>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${ not empty employee }">
										<li class="menu-item"><a href="${ pageContext.request.contextPath }/consultingService">상담서비스관리</a></li>
										<c:if test="${ employee.rank eq '과장'}">
											<li class="menu-item"><a href="${ pageContext.request.contextPath }/manageEmployee">사원관리</a></li>										
										</c:if>
										<c:if test="${ employee.rank eq '차장'}">
											<li class="menu-item"><a href="${ pageContext.request.contextPath }/manageEmployee">사원관리</a></li>										
										</c:if>
										<c:if test="${ employee.rank eq '부장'}">
											<li class="menu-item"><a href="${ pageContext.request.contextPath }/manageEmployee">사원관리</a></li>										
										</c:if>
									</c:when>
									<c:otherwise>
										<li class="menu-item"><a href="${ pageContext.request.contextPath }/insurance">찾아오시는길</a></li>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${ not empty loginVO }">
										<li class="menu-item"><a href="${ pageContext.request.contextPath }/myPage">My Page</a></li>																		
									</c:when>
									<c:when test="${ not empty employee }">
										<li class="menu-item"><a href="${ pageContext.request.contextPath }/myEmployeePage">My Page</a></li>																		
									</c:when>
								</c:choose>
							</ul> <!-- .menu -->
						</div> <!-- .main-navigation -->
						
						<div class="social-links">
							<a href="https://www.facebook.com/ehanalife/"><i class="fa fa-facebook"></i></a>
							<a href="https://twitter.com/?lang=ko"><i class="fa fa-twitter"></i></a>
							<a href="https://sites.google.com/a/smartbns.com/googleapps/pd/pd04"><i class="fa fa-google-plus"></i></a>
							<a href="https://www.pinterest.co.kr/"><i class="fa fa-pinterest"></i></a>
						</div>
						
						<div class="mobile-navigation"></div>
					</div>
				</div>
				
			</header> <!-- .site-header -->
	