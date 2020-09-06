<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">
		
		<title>Insurance | About Us</title>

		<!-- Loading third party fonts -->
		<link href="http://fonts.googleapis.com/css?family=Roboto+Condensed:300,400,700|" rel="stylesheet" type="text/css">
		<link href="fonts/font-awesome.min.css" rel="stylesheet" type="text/css">
		<link href="fonts/lineo-icon/style.css" rel="stylesheet" type="text/css">

		<!-- Loading main css file -->
		<link rel="stylesheet" href="style.css">
		
		<!--[if lt IE 9]>
		<script src="js/ie-support/html5.js"></script>
		<script src="js/ie-support/respond.js"></script>
		<![endif]-->

	</head>


	<body>
		
		<header class="site-header">
				<div class="top-header">
					<div class="container">
						<a href="${ pageContext.request.contextPath }" id="branding">
							<img src="images/hanaicon.png" alt="Company Name" class="logo">
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
							<a href="#" class="phone"><img src="images/icon-phone.png" class="icon">02-3709-7394</a>
					
							<form action="#" class="search-form">
								<input type="text" placeholder="검색">
								<button type="submit"><img src="images/icon-search.png" alt=""></button>
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
										<li class="menu-item"><a href="${ pageContext.request.contextPath }/performanceManagementService">성과관리</a></li>
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
										<li class="menu-item"><a href="${ pageContext.request.contextPath }/insurance.jsp">찾아오시는길</a></li>
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


			<main class="main-content">
				<div class="breadcrumbs">
					<div class="container">
						<a href="index.jsp">Home</a>
						<span>하나생명소개</span>
					</div>
				</div>

				<div class="page">
					<div class="fullwidth-block">
						<div class="container">
							<h1 class="entry-title">왜 <strong>하나생명</strong>인가?</h1>
							<p>하나생명은 방카슈랑스 보험 청약 업무 지원을 위한 '모바일 신계약 서류보완 프로세스'를 도입했습니다. '모바일 신계약 서류보완 프로세스'는 고객이 카카오 인증 등을 거쳐 은행을 방문하지 않고도 직접 서류 보완을 처리할 수 있는 서비스다. 앞서 지난 2월에는 인슈어테크(보험+기술) 기업 보맵과 디지털 플랫폼 혁신을 위한 양해각서(MOU)를 체결하기도 했다. 
							양 사는 디지털 전용 보험상품과 보맵의 제휴 사업자를 위한 플랫폼 전용 보험상품 등을 선보인다는 계획.</p>
							
							<div class="features">
								<div class="feature-numbered">
									<div class="num">1</div>
									<h2 class="feature-title">Proin tempus</h2>
									<p> Proin tempus velit dui eu lobortis justo laoreet nec phasellus luctus elit neque eu aliquam velit dignissim donec porttitor.</p>
								</div>
								<div class="feature-numbered">
									<div class="num">2</div>
									<h2 class="feature-title">Proin tempus</h2>
									<p> Proin tempus velit dui eu lobortis justo laoreet nec phasellus luctus elit neque eu aliquam velit dignissim donec porttitor.</p>
								</div>
								<div class="feature-numbered">
									<div class="num">3</div>
									<h2 class="feature-title">Proin tempus</h2>
									<p> Proin tempus velit dui eu lobortis justo laoreet nec phasellus luctus elit neque eu aliquam velit dignissim donec porttitor.</p>
								</div>
								<div class="feature-numbered">
									<div class="num">4</div>
									<h2 class="feature-title">Proin tempus</h2>
									<p> Proin tempus velit dui eu lobortis justo laoreet nec phasellus luctus elit neque eu aliquam velit dignissim donec porttitor.</p>
								</div>
							</div>
						</div> <!-- .container -->
					</div> <!-- .fullwidth-block -->

					<div class="fullwidth-block" data-bg-color="#f1f1f1">
						<div class="container">
							<h2 class="section-title">The history</h2>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut vitae leo ornare, fermentum libero eu, pharetra ante. Nunc consectetur pharetra tincidunt. Maecenas eget mattis ipsum. Quisque libero nisi, maximus id mauris non, imperdiet lacinia purus. Quisque a scelerisque quam, a finibus lectus.</p> 

							<p>Duis luctus a magna luctus elementum. Integer scelerisque, turpis eu placerat elementum, libero risus sodales lacus, ac vulputate quam dui eget risus. Cras vel luctus urna. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Interdum et malesuada fames ac ante ipsum primis in faucibus. Phasellus luctus varius massa, ac faucibus sem posuere sit amet. Nunc nec fermentum mi. Etiam ultricies sit amet turpis vitae iaculis. Sed eget sem turpis. Morbi sodales nisi sem, pretium volutpat lectus ornare quis. Aenean vel ante enim.</p>

							<p>Nam posuere purus vitae est sollicitudin placerat. Praesent posuere porta dignissim. Phasellus viverra, urna a convallis tincidunt, ante mi tempor turpis, nec tempor mauris ligula ut sapien. Etiam euismod mi eu ante mollis commodo. Suspendisse porta nisi vitae dui hendrerit, eget ornare orci semper. Phasellus pharetra, erat sit amet rutrum porttitor, est eros consectetur elit, molestie consequat erat tellus in dui. Vestibulum a vehicula sem. Nullam commodo quis purus in volutpat. Integer semper lacus a lorem efficitur auctor. Curabitur tincidunt, ligula non ultrices eleifend, felis leo ultrices quam, vitae congue risus dui a justo. Phasellus dapibus justo lacus, eget scelerisque libero iaculis sed. Maecenas ullamcorper sit amet dui nec efficitur.</p>
						</div> <!-- .container -->
					</div> <!-- .fullwidth-block -->

					<div class="fullwidth-block">
						<div class="container">
							<h2 class="section-title">Our Team</h2>

							<div class="row">
								<div class="col-xs-12 col-sm-6 col-md-3">
									<div class="team">
										<figure class="team-image"><img src="dummy/team-1.jpg" alt=""></figure>
										<h2 class="team-name">Jessica Brown</h2>
										<small class="team-title">CEO</small>
										<div class="social-links">
											<a href="#"><i class="fa fa-facebook"></i></a>
											<a href="#"><i class="fa fa-twitter"></i></a>
											<a href="#"><i class="fa fa-google-plus"></i></a>
											<a href="#"><i class="fa fa-pinterest"></i></a>
										</div>
									</div> <!-- .team -->
								</div> <!-- .col-md-3 -->
								<div class="col-xs-12 col-sm-6 col-md-3">
									<div class="team">
										<figure class="team-image"><img src="dummy/team-2.jpg" alt=""></figure>
										<h2 class="team-name">Jeremy Stuart</h2>
										<small class="team-title">Managing Director</small>
										<div class="social-links">
											<a href="#"><i class="fa fa-facebook"></i></a>
											<a href="#"><i class="fa fa-twitter"></i></a>
											<a href="#"><i class="fa fa-google-plus"></i></a>
											<a href="#"><i class="fa fa-pinterest"></i></a>
										</div>
									</div> <!-- .team -->
								</div> <!-- .col-md-3 -->
								<div class="col-xs-12 col-sm-6 col-md-3">
									<div class="team">
										<figure class="team-image"><img src="dummy/team-3.jpg" alt=""></figure>
										<h2 class="team-name">Sarah Johnson</h2>
										<small class="team-title">Public Relation</small>
										<div class="social-links">
											<a href="#"><i class="fa fa-facebook"></i></a>
											<a href="#"><i class="fa fa-twitter"></i></a>
											<a href="#"><i class="fa fa-google-plus"></i></a>
											<a href="#"><i class="fa fa-pinterest"></i></a>
										</div>
									</div> <!-- .team -->
								</div> <!-- .col-md-3 -->
								<div class="col-xs-12 col-sm-6 col-md-3">
									<div class="team">
										<figure class="team-image"><img src="dummy/team-4.jpg" alt=""></figure>
										<h2 class="team-name">Paul ferguson</h2>
										<small class="team-title">Consultant</small>
										<div class="social-links">
											<a href="#"><i class="fa fa-facebook"></i></a>
											<a href="#"><i class="fa fa-twitter"></i></a>
											<a href="#"><i class="fa fa-google-plus"></i></a>
											<a href="#"><i class="fa fa-pinterest"></i></a>
										</div>
									</div> <!-- .team -->
								</div> <!-- .col-md-3 -->
							</div> <!-- .row -->
						</div> <!-- .container -->
					</div> <!-- .fullwidth-block -->
				</div> <!-- .page -->
			</main>

			<div class="site-footer">
				<div class="widget-area">
					<div class="container">
						<div class="row">
							<div class="col-xs-12 col-sm-4 col-md-2">
								<div class="widget">
									<h3 class="widget-title">Contact</h3>
									<address> Company Name INC. 523 Burt Street, Omaha
									</address>
									<a href="#">Phone: +1 823 424 9134</a>
									<a href="mailto:info@company.com">info@company.com</a>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4 col-md-2">
								<div class="widget">
									<h3 class="widget-title">Company</h3>
									<ul class="no-bullet">
										<li><a href="#">About us</a></li>
										<li><a href="#">Infoline</a></li>
										<li><a href="#">Team</a></li>
										<li><a href="#">Join us</a></li>
										<li><a href="#">Cooperation</a></li>
									</ul>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4 col-md-2">
								<div class="widget">
									<h3 class="widget-title">Products</h3>
									<ul class="no-bullet">
										<li><a href="#">Life insurance</a></li>
										<li><a href="#">Home insurance</a></li>
										<li><a href="#">Car insurance</a></li>
										<li><a href="#">Business insurance</a></li>
										<li><a href="#">Investment insurance</a></li>
									</ul>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4 col-md-2">
								<div class="widget">
									<h3 class="widget-title">Our Solutions</h3>
									<ul class="no-bullet">
										<li><a href="#">Presentation</a></li>
										<li><a href="#">Testimonials</a></li>
										<li><a href="#">Examples</a></li>
										<li><a href="#">Our experts</a></li>
										<li><a href="#">Resources</a></li>
									</ul>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4 col-md-2">
								<div class="widget">
									<h3 class="widget-title">Press Room</h3>
									<ul class="no-bullet">
									<li><a href="#">Advertisement</a></li>
									<li><a href="#">Interviews</a></li>
									<li><a href="#">Hot news</a></li>
									<li><a href="#">Photos</a></li>
									<li><a href="#">Marketing</a></li>
									</ul>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4 col-md-2">
								<div class="widget">
									<h3 class="widget-title">Resources</h3>
									<ul class="no-bullet">
										<li><a href="#">Sed imperdiet magna</a></li>
										<li><a href="#">Pellentesque molestie</a></li>
										<li><a href="#">Nulla luctus cursus</a></li>
										<li><a href="#">Ligula vel lacinia</a></li>
										<li><a href="#">Mauris scelerisque</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="bottom-footer">
					<div class="container">
						<nav class="footer-navigation">
							<a href="#">Home</a>
							<a href="#">About us</a>
							<a href="#">Insurance plans</a>
							<a href="#">Resources</a>
							<a href="#">Contact</a>
						</nav>

						<div class="colophon">Copyright 2014 Company name. Designed by Themezy. All rights reserved.</div>
					</div>
				</div>
			</div>
		</div>

		<script src="js/jquery-1.11.1.min.js"></script>
		<script src="js/plugins.js"></script>
		<script src="js/app.js"></script>
		
	</body>

</html>