<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">
		
		<title>Insurance | Insurances type</title>

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

<script>
	function doAction(code) {
		location.href = "${ pageContext.request.contextPath}/productDetail/"+code;
	}
</script>

	</head>


	<body>
		
		<header>
			<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp"></jsp:include>
		</header>

			<main class="main-content">
				<div class="breadcrumbs">
					<div class="container">
						<a href="index.jsp">Home</a>
						<span>보험상품</span>
					</div>
				</div>

				<div class="page">
					<div class="container">
						<h3 class="entry-title">하나생명의 다양한 보험상품을 둘러보세요</h3>
						<p>특수보험, 종합보험, 어린이보험</p>

						<div class="filter-links filterable-nav">
							<select class="mobile-filter">
								<option value="*">Show all</option>
								<option value=".skyscraper">특수보험</option>
								<option value=".shopping-center">종합보험</option>
								<option value=".apartment">어린이보험</option>
							</select>
							<strong>Select Category: </strong>
							<a href="#" class="current wow fadeInRight" data-filter="*">모두보기</a>
							<a href="#" class="wow fadeInRight" data-wow-delay=".2s" data-filter=".skyscraper">특수보험</a>
							<a href="#" class="wow fadeInRight" data-wow-delay=".4s" data-filter=".shopping-center">종합보험</a>
							<a href="#" class="wow fadeInRight" data-wow-delay=".6s" data-filter=".apartment">어린이보험</a>
						</div>

						<div class="filterable-items">
							<div class="insurance-item filterable-item shopping-center">
								<div class="insurance-content">
									<div class="insurance-icon"><i class="icon-sofa"></i></div>
									<h3 class="insurance-title">종합암보험</h3>
									<p>종합암보험입니다.</p>
									<a href="javascript:doAction('A001')" class="button">See details</a>
								</div>
							</div>
						

							<div class="insurance-item filterable-item skyscraper">
								<div class="insurance-content">
									<div class="insurance-icon"><i class="icon-pool"></i></div>
									<h3 class="insurance-title">특수암보험</h3>
									<p>특수암보험입니다.</p>
									<a href="javascript:doAction('A003')" class="button">See details</a>
								</div>
							</div>
							
							<div class="insurance-item filterable-item skyscraper">
								<div class="insurance-content">
									<div class="insurance-icon"><i class="icon-pool"></i></div>
									<h3 class="insurance-title">특수화재보험</h3>
									<p>특수화재보험입니다.</p>
									<a href="javascript:doAction('C002')" class="button">See details</a>
								</div>
							</div>

							<div class="insurance-item filterable-item apartment">
								<div class="insurance-content">
									<div class="insurance-icon"><i class="icon-nurse"></i></div>
									<h3 class="insurance-title">어린이생명보험</h3>
									<p>어린이생명보험입니다.</p>
									<a href="javascript:doAction('D001')" class="button">See details</a>
								</div>
							</div>

							<div class="insurance-item filterable-item shopping-center">
								<div class="insurance-content">
									<div class="insurance-icon"><i class="icon-weigher"></i></div>
									<h3 class="insurance-title">종합상해보험</h3>
									<p>종합상해보험입니다.</p>
									<a href="javascript:doAction('B001')" class="button">See details</a>
								</div>
							</div>

							<div class="insurance-item filterable-item apartment">
								<div class="insurance-content">
									<div class="insurance-icon"><i class="icon-car"></i></div>
									<h3 class="insurance-title">어린이종합보험</h3>
									<p>어린이상해보험입니다.</p>
									<a href="javascript:doAction('D003')" class="button">See details</a>
								</div>
							</div>

							<div class="insurance-item filterable-item skyscraper">
								<div class="insurance-content">
									<div class="insurance-icon"><i class="icon-shirt"></i></div>
									<h3 class="insurance-title">특수상해보험</h3>
									<p>특수상해보험입니다.</p>
									<a href="javascript:doAction('B002')" class="button">See details</a>
								</div>
							</div>
							
							<div class="insurance-item filterable-item shopping-center">
								<div class="insurance-content">
									<div class="insurance-icon"><i class="icon-sofa"></i></div>
									<h3 class="insurance-title">종합화재보험</h3>
									<p>종합화재보험입니다.</p>
									<a href="javascript:doAction('C001')" class="button">See details</a>
								</div>
							</div>
							
							<div class="insurance-item filterable-item apartment">
								<div class="insurance-content">
									<div class="insurance-icon"><i class="icon-car"></i></div>
									<h3 class="insurance-title">어린이암보험</h3>
									<p>어린이암보험입니다.</p>
									<a href="javascript:doAction('D002')" class="button">See details</a>
								</div>
							</div>
							
						</div>

						<div class="pagination">
							<span class="current">1</span>
							<a href="#">2</a>
							<a href="#">3</a>
						</div>
					</div>
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