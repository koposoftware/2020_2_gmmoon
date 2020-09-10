<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">
		
		<title>하나생명4U</title>

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
		
		<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp"></jsp:include>
		</header>

			<div class="hero hero-slider">
				<ul class="slides">
					<li data-bg-image="images/hanaMain01.png" >
						<div class="container">
							<div class="slide-content" style="border:1px solid black;">
								<h2 class="slide-title">어서오세요 <strong>HANA 4U</strong></h2>
								<p>장기계약이 강점인 하나생명과 함께 
									신속하고 안정적인 선진 종합 금융 서비스를 시작하세요!</p>
								<a href="${pageContext.request.contextPath }/signUp" class="button">회원가입</a>
							</div>
						</div>
					</li>
					<li data-bg-image="images/hanaMain02.png">
						<div class="container">
							<div class="slide-content" style="border:1px solid black;">
									<h2 class="slide-title">어서오세요 <strong>HANA 4U</strong></h2>
									<p>장기계약이 강점인 하나생명과 함께 
										신속하고 안정적인 선진 종합 금융 서비스를 시작하세요!</p>
								<a href="${pageContext.request.contextPath }/signUp" class="button">회원가입</a>
							</div>
						</div>
					</li>
					<li data-bg-image="images/hanaMain06.png">
						<div class="container">
							<div class="slide-content" style="border:1px solid black;">
									<h2 class="slide-title">어서오세요 <strong>HANA 4U</strong></h2>
									<p>장기계약이 강점인 하나생명과 함께 
										신속하고 안정적인 선진 종합 금융 서비스를 시작하세요!</p>
								<a href="${pageContext.request.contextPath }/signUp" class="button">회원가입</a>
							</div>
						</div>
					</li>
				</ul>
			</div> <!-- .hero-slider -->

			<main class="main-content">
				<div class="fullwidth-block greet-section">
					<div class="container">
						<h2 class="section-title">하나생명을 소개합니다</h2>
						<small class="section-subtitle">함께성장하며 행복을 나누는 금융, 신뢰받고 앞서가는 든든한 보험회사</small>

						<div class="row">
							<div class="col-md-3">
								<div class="feature">
									<i class="icon-phone-24"></i>
									<h3 class="feature-title">24시간 제공되는 서비스</h3>
									<p>언제나 이용 가능한 서비스를 만끽하세요!여러분이 필요료 할 때 옆에 있는 HANA 4U</p>
								</div>
							</div>
							<div class="col-md-3">
								<div class="feature">
									<i class="icon-hotel"></i>
									<h3 class="feature-title">하나네트워크</h3>
									<p>하나금융그룹사 소속으로 다양한 정보를 이용하여 가치를 창출</p>
								</div>
							</div>
							<div class="col-md-3">
								<div class="feature">
									<i class="icon-luggage"></i>
									<h3 class="feature-title">노후대비 </h3>
									<p>노후대비를 위한 적절한 상품이 있는 하나생명을 이용해보세요</p>
								</div>
							</div>
							<div class="col-md-3">
								<div class="feature">
									<i class="icon-credit-card-hand"></i>
									<h3 class="feature-title">간편한 결제과정</h3>
									<p>결제부터 안내까지 간단한 과정을 느껴보세요</p>
								</div>
							</div>
						</div> <!-- .row -->

						<div class="text-center">
							<p>하나생명을 더 알고싶다면? <a href="about.jsp">더 알아보기</a></p>
						</div>
					</div> <!-- .container -->
				</div> <!-- .fullwidth-block -->

				<div class="fullwidth-block" data-bg-color="#0f75bd">
					<div class="container">
						<div class="testimonial-slider">
							<ul class="slides">
								<li>
									<blockquote>"모두의 기쁨, 그 하나를 위하여" <br>하나생명은 항상 손님의 인생 여정을 함께하는 동반자가 되겠습니다.<cite>-대표이사 사장 김인석-</cite></blockquote>
								</li>
								<li>
									<blockquote>"고객의 기쁨은 나의 기쁨" <br>항상 최선을 다해서 더 나은 서비스를 제공하겠습니다.<cite>-우수사원 문건모-</cite></blockquote>
								</li>
								<li>
									<blockquote>"글씨가 크고 간편하니 훨씬 사용하기 편해졌어요. <br>덕분에 보험도 잘 알아보고 좋은 상품을 들었습니다."<cite>-OOO 고객님-</cite></blockquote>
									<!-- 후기같은 것을 제일 많이 올린 고객이름을 삽입??(기능 구현 예정) -->
								</li>
							</ul>
						</div>
					</div> <!-- .container -->
				</div> <!-- .fullwidth-block -->

				<div class="fullwidth-block">
					<div class="container">
						<h2 class="section-title">하나금융네트워크</h2>

						<div class="partners">
							<a href="https://www.kebhana.com/"><img src="/hanalife/images/hanaBanklogo.jpg" ></a>
							<a href="https://www.hanacard.co.kr/index2.jsp"><img src="/hanalife/images/hanaCardlogo.jpg"></a>
							<a href="https://www.educar.co.kr/"><img src="/hanalife/images/hanaLifeinsurancelogo.jpg"></a>
							<a href="https://www.hanaw.com/main/main/index.cmd"><img src="/hanalife/images/hanaInvestmentlogo.jpg"></a>
							<a href="https://www.hanati.co.kr/kor/main.jsp"><img src="/hanalife/images/hanaTilogo.jpg"></a>
							<a href="https://www.hanacapital.co.kr/index.hnc"><img src="/hanalife/images/hanaCapitallogo.jpg"></a>
						</div> <!-- .partners -->
					</div> <!-- .container -->
				</div> <!-- .fullwidth-block -->

				<div class="fullwidth-block">
					<div class="map"></div>
				</div>
			</main>

			<div class="site-footer">
				<div class="widget-area">
					<div class="container">
						<div class="row">
							<div class="col-xs-12 col-sm-4 col-md-2">
								<div class="widget">
									<h3 class="widget-title">회사소개</h3>
									<address> 하나생명. 서울특별시 중구 을지로66
									</address>
									<a href="#">Tel: 080-3488-7000</a>
									<a href="mailto:info@company.com">hanalife@hl.co.kr</a>
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
							<a href="index.jsp">Home</a>
							<a href="about.jsp">하나생명소개</a>
							<a href="insurance.jsp">보험상품</a>
							<a href="resource.jsp">보험추천</a>
							<a href="contact.jsp">찾아오시는길</a>
						</nav>

						<div class="colophon">Copyright 2020 Moongeonmo. Designed by Themezy. All rights reserved.</div>
					</div>
				</div>
			</div>
		

		<script src="js/jquery-1.11.1.min.js"></script>
		<script src="http://maps.google.com/maps/api/js?sensor=false&amp;language=en"></script>
		<script src="js/plugins.js"></script>
		<script src="js/app.js"></script>
		
	</body>

</html>