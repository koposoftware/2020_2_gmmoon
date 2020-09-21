<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js" ></script>
<script>
	window.onload = function() {
		
		document.getElementsByClassName("tablink")[0].click();
	}
		function openCity(evt, cityName) {
		  var i, x, tablinks;
		  x = document.getElementsByClassName("city");
		  for (i = 0; i < x.length; i++) {
		    x[i].style.display = "none";
		  }
		  tablinks = document.getElementsByClassName("tablink");
		  for (i = 0; i < x.length; i++) {
		    tablinks[i].classList.remove("w3-light-grey");
		  }
		  document.getElementById(cityName).style.display = "block";
		  evt.currentTarget.classList.add("w3-light-grey");
		}
		
	$(document).ready(function() {
		
		$('#emailBtn').attr("disabled", "disabled");
		$('input[name="checkTerms"]').on('click', function() {
			//check박스가 2개모두 체크가 안되면 클로즈를 못누름
			
			if($('input[name="checkTerms"]:checked').length < 2){
				$('#checkTermsBtn').attr("disabled", "disabled");
				
			} else {
				$('#checkTermsBtn').removeAttr("disabled");
				$('#emailBtn').removeAttr("disabled");
			}
		})
		
		
		
	})
	
</script>
<style>
.city {display:none}

#div1 {
	margin-top:15px;
	margin-left: 30%;
	margin-bottom: 15px;
}

strong {
	color: blue;
}
</style>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	
	<section>
	
		<div align="center" style="border:1px solid black; height: 400px; width: 600px;" id="div1">
			<hr>
			<div class="w3-container w3-green">
			<h3>이메일 인증 (이용약관 동의 후 실행가능)</h3>
			</div>
			<hr> 
		 	<form action="${ pageContext.request.contextPath }/authContract/${ code }" method="post" class="w3-container">
		 		<p>
				  <label>Email</label>
				  <input class="w3-input" type="email" name="e_mail" placeholder="  이메일주소를 입력하세요. "></p>
		 		<br>
		 		<button type="submit" name="submit" class="w3-button w3-green" id="emailBtn">이메일 인증받기 (이메일 보내기)</button>
		 		
		 	</form>
		</div>
	</section>
	
	
	
	
	<!-- 모달 창! -->
		<div class="w3-container">
			<div class="w3-center">
				<button onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-black " >이용약관</button>
			</div>
		<div id="id01" class="w3-modal">
		 <div class="w3-modal-content w3-card-4 w3-animate-zoom">
		  <header class="w3-container w3-blue"> 
		   <span onclick="document.getElementById('id01').style.display='none'" 
		   class="w3-button w3-blue w3-xlarge w3-display-topright">&times;</span>
		   <h2>필수동의사항</h2>
		  </header>
		
		  <div class="w3-bar w3-border-bottom">
		   <button class="tablink w3-bar-item w3-button" onclick="openCity(event, 'London')">이용약관</button>
		   <button class="tablink w3-bar-item w3-button" onclick="openCity(event, 'Paris')">유의사항</button>
		  </div>
		
		  <div id="London" class="w3-container city" style="overflow:scroll; width:900px; height:900px;">
		   <h1>이용약관</h1>
				<dl>
						<dt>제 1조 (목적)</dt>
						<dd>이 약관은 하나생명보험주식회사(이하 &quot;회사&quot;라 합니다.)가 인터넷 상에서 제공하는 모든 서비스를 이용함에 있어 필요한 제반 사항을 규정함을 목적으로 합니다.</dd>
						<dt>제 2조 (정의)</dt>
						<dd>
							<ul>
								<li>① 웹사이트란 하나생명보험주식회사가 컴퓨터 등 정보통신설비를 이용하여 재화 또는 용역을 이용자에게 제공하고 거래할 수 있도록 설정한 가상의 영업장을 말하며, 아울러 웹사이트를 운영하는 사업자의 의미로도 사용합니다.</li>
								<li>②&#145;이용자&#146;란 회사 웹사이트에 접속하여 이 약관에 따라 회사 웹사이트에서 제공하는 서비스를 받는 당사 고객 또는 비고객을 말합니다.</li>
								<li>③&#145;고객&#146;이라 함은 하나생명에 가입한 상품이 있는 계약자로 회사 웹사이트의 정보를 지속적으로 제공받으며, 회사 웹사이트가 제공하는 서비스를 계속적으로 이용할 수 있는 자를 말합니다.</li>
								<li>④&#145;비고객&#146;이란 함은 하나생명에 가입한 상품이 없는 자로 회사 웹사이트에서 제공하는 서비스를 이용하는 자를 말합니다.</li>
							</ul>
						</dd>
						<dt>제 3조 (약관의 명시와 개정)</dt>
						<dd>
							<ul>
								<li>① 회사는 이 약관의 내용과 상호, 영업소 소재지, 대표자의 성명, 사업자등록번호, 연락처(전화, 팩스, 전자우편 주소 등) 등을 이용자가 알 수 있도록 회사 웹사이트의 초기 서비스화면(전면)에 게시합니다.</li>
								<li>② 회사는 약관의 규제 등에 관한 법률, 전자거래기본법, 전자 서명법, 정보통신망 이용촉진 등에 관한 법률, 방문판매 등에 관한 법률, 소비자보호법 등 관련법을 위배하지 않는 범위에서 이 약관을 개정할 수 있습니다.</li>
								<li>회사가 약관을 개정할 경우에는 적용일자 및 개정사유를 명시하여 현행약관과 함께 회사 웹사이트의 초기화면에 그 적용일자 7일 이전부터 적용일자 전일까지(약관 변경이 고객에게 불리한 경우 변경일 후 30일 이상) 공지합니다.</li>
								<li>④ 회사가 약관을 개정할 경우에는 그 개정약관은 그 적용일자 이후에 체결되는 계약에만 적용되고 그 이전에 이미 체결된 계약에 대해서는 개정전의 약관조항이 그대로 적용됩니다. 다만 회사가 &quot;이용자가 개정약관 공지 기간 내에 변경 약관에 대한 적용거절 여부를 표명하지 아니하는 때에는 변경약관의 적용을 받는 것으로 본다&quot;는 취지의 통지를 하였음에도 이용고객이 거절 여부를 표명하지 아니한 경우 또는 부득이한 사유로 그러한 통지를 할 수 없는 경우에는 개정 전에 체결된 계약에도 개정약관이 적용됩니다.</li>
								<li>⑤ 이 약관에서 정하지 아니한 사항과 이 약관의 해석에 관하여는 정부가 제정한 전자거래소비자보호지침 및 관계법령 또는 상관례에 따릅니다.</li>
							</ul>
						</dd>
						<dt>제 4조 (서비스의 제공 및 변경)</dt>
						<dd>
							<ul>
								<li>① 회사 웹사이트에서 이용자에게 다음과 같은 서비스를 제공합니다. 다만, 비고객에게는 서비스 중 일부만을 제공할 수 있습니다.
									<ul>
										<li>- 1. 하나생명보험의 소개 및 안내</li>
										<li>- 2. 보험상품의 설명. 보험료 산출, 가상설계, 안내(e-mail발송 등), 가입.환매신청</li>
										<li>- 3. 이용자(보험계약자 또는 대출계약자에 한함)의 각종 보험계약, 대출관련 각종 정보 및 입출금</li>
										<li>- 4. 기타 회사가 정하는 업무</li>
									</ul>
								</li>
								<li>② 회사는 필요한 경우 언제든지 제1항에서 정한 서비스의 내용을 변경할 수 있으며, 이로 인하여 발행하는 문제에 대해서는 어떠한 책임도 부담하지 않습니다.</li>
							</ul>
						</dd>
						<dt>제 5조 (서비스의 중단)</dt>
						<dd>
							<ul>
								<li>① 회사 웹사이트는 컴퓨터 등 정보통신설비의 보수점검교체 및 고장, 통신의 두절 등의 사유가 발생한 경우에는 서비스의 제공을 일시적으로 중단할 수 있습니다.</li>
								<li>② 제1항에 의한 서비스 중단의 경우에는 회사는 제8조에 정한 방법으로 이용자에게 통지함을 원칙으로 합니다.</li>
								<li>③ 회사는 제1항의 사유로 서비스의 제공이 일시적으로 중단됨으로 인하여 이용자에게 발생하는 문제에 대해서는 어떠한 책임도 부담하지 않습니다.</li>
							</ul>
						</dd>						
						<dt>제 6조 (고객에 대한 통지)</dt>
						<dd>
							<ul>
								<li>① 회사가 회원에 대한 통지를 하는 경우, 회원이 회사 웹사이트에 제출한 전자우편 주소로 할 수 있습니다.</li>
								<li>② 회사는 불특정다수 회원에 대한 통지의 경우 1주일이상 회사 웹사이트 게시판에 게시함으로써 개별 통지에 갈음할 수 있습니다. </li>
							</ul>
						</dd>
						<dt>제 7조 (개인정보보호)</dt>
						<dd>
							<ul>
								<li>① 회사는 이용자의 정보수집 시 원활한 서비스 제공을 위해 필요한 최소한의 정보를 수집합니다.</li>
								<li>② 회사는 이용자의 개인식별이 가능한 개인정보를 수집하는 때에는 반드시 당해 이용자의 동의를 받습니다.</li>
								<li>③ 이용자는 언제든지 본인의 개인정보 열람 및 수정/삭제를 요청할 수 있으며, 홈페이지는 이에 대해 지체 없이 필요한 조치를 취할 의무를 가집니다.</li>
								<li>④ 기타 개인정보관련 사항은 &quot;하나생명보험 홈페이지 이용자에 대한 개인정보 취급방침&quot;에 의거합니다. </li>
							</ul>
						</dd>
						<dt>제 8조 (회사의 의무)</dt>
						<dd>
							<ul>
								<li>① 회사는 법령과 이 약관이 금지하거나 공서양속에 반하는 행위를 하지 않으며 이 약관이 정하는 서비스를 안정적으로 제공하기 위해 최선을 다 합니다.</li>
								<li>② 회사는 이용자가 안전하게 인터넷 서비스를 이용할 수 있도록 이용자의 개인정보(신용정보 포함)보호를 위한 보안 시스템을 갖추어야 합니다.</li>
								<li>③ 회사가 상품이나 용역에 대하여 「표시.광고의공정화에관한법률」 제3조 소정의 부당한 표시.광고행위를 함으로써 이용자가 손해를 입은 때에는 이를 배상할 책임을 집니다.</li>
								<li>④ 회사 웹사이트는 이용자가 원하지 않는 영리목적의 광고성 전자우편을 발송하지 않습니다. </li>
							</ul>
						</dd>
						<dt>제 9조 (이용자 정보 및 비밀번호에 대한 의무)</dt>
						<dd>
							<ul>
								<li>① 회사 웹사이트에서 사용하는 비밀번호에 대한 관리책임은 이용자에게 있으며, 비밀번호의 분실로 인한 모든 문제에 대해서는 이용자가 책임을 부담합니다.</li>
								<li>② 이용자는 자신의 정보(이름, 생년월일) 및 비밀번호를 제3자에게 이용하게 해서는 안됩니다.</li>
								<li>③ 이용자가 자신의 정보(이름, 생년월일), 비밀번호를 도난 당하거나 제3자가 사용하고 있음을 인지한 경우에는 바로 회사에 통보하고 회사의 안내가 있는 경우에는 그에 따라야 합니다.</li>
								<li>④ 비밀번호를 분실한 경우 고객센터를 통해 접수한 내용을 다시 확인 할 수 있습니다.</li>
							</ul>
						</dd>
						<dt>제 10조 (이용자의 의무)</dt>
						<dd>이용자는 다음 행위를 하여서는 안됩니다.
							<ul>
								<li>- 1. 신청 또는 변경시 허위내용의 등록</li>
								<li>- 2. 회사 웹사이트에 게시된 정보의 변경</li>
								<li>- 3. 회사 웹사이트가 정한 정보 이외의 정보(컴퓨터프로그램 등)의 송신 또는 게시</li>
								<li>- 4. 회사 기타 제3자의 저작권 등 지적재산권에 대한 침해</li>
								<li>- 5. 회사 기타 제3자의 명예를 손상시키거나 업무를 방해하는 행위</li>
								<li>- 6. 외설 또는 폭력적인 메시지.화상.음성 기타 공서양속에 반하는 정보를 회사 웹사이트에 공개 또는 게시하는 행위</li>
								<li>- 7. 다른 이용자의 개인정보를 수집 또는 저장하는 행위 </li>
							</ul>
						</dd>
						<dt>제 11조 (저작권의 귀속 및 이용제한)</dt>
						<dd>
							<ul>
								<li>① 회사가 작성한 저작물에 대한 저작권 및 기타 지적재산권은 회사에 귀속합니다.</li>
								<li>② 이용자는 회사 웹사이트을 이용함으로써 얻은 정보를 회사의 사전 승낙없이 복제, 송신, 출판, 배포, 방송 기타 방법에 의하여 영리목적으로 이용하거나 제3자에게 이용하게 하여서는 안됩니다. </li>
							</ul>
						</dd> 
						<dt>제 12조 (분쟁조정)</dt>
						<dd>
							이용자가 회사의 전자거래의 처리에 관하여 이의가 있을 때에는 회사의 분쟁처리기구에 그 해결을 요구하거나 금융감독원의 금융분쟁조정위원회, 한국소비자보호원의 소비자분쟁조정위원회 등을 통하여 분쟁조정을 신청할 수 있습니다.
						</dd>
						<dt>제 13조 (준거법)</dt>
						<dd>이 약관에서 정하지 아니한 사항은 대한민국법령을 적용합니다.</dd>
					</dl>
					<p class="mt50">부 칙 [2008.04.01]<br />제1조(시행일) 본 약관은 2008년 4월 1일부터 적용하고, 종전의 약관은 본 약관으로 대체합니다.</p>
					<p class="mt15">부 칙 [2013.06.14]<br />제1조(시행일) 본 약관은 2013년 6월 21일부터 적용하고, 종전의 약관은 본 약관으로 대체합니다.</p>
					<strong>상기 약관을 동의합니다</strong>&nbsp;&nbsp;<input type="checkbox" name="checkTerms">		   
		  </div>
		
		  <div id="Paris" class="w3-container city" style="overflow:scroll; width:900px; height:900px;">
		   <h1>유의사항</h1>
		   <div class="Protection_area">
		   	<dl class="rule">
						<dt>01. 금융회사에서 제공하는 보안프로그램을 반드시 설치하기</dt>
						<dd>전자금융거래를 위해 금융회사의 홈페이지에 접속하면 해당 금융회사에서 제공하는 보안프로그램이 자동적으로 설치됩니다. 이 때, 임의로 설치를 중단하거나 설치된 보안프로그램의 실행을 중지시키지 않아야 합니다. 또한 자동적으로 설치가 되지 않을 경우에는 설치 안내에 따라 수동으로 보안프로그램을 꼭 설치한 후에 전자금융거래를 해야 합니다. 이는 금융거래 내용을 타인에게 노출되지 않도록 하기 위함입니다.</dd>
						<dt>02. 전자금융에 필요한 정보는 수첩, 지갑 등 타인에게 쉽게 노출될 수 있는 매체에 기록하지 않고,<br />타인에게(금융회사 직원을 포함) 알려 주지 않기</dt>
						<dd>전자금융거래를 위해 금융회사의 홈페이지에 접속하면 해당 금융회사에서 제공하는 보안프로그램이 자동적으로 설치됩니다. 이 때, 임의로 설치를 중단하거나 설치된 보안프로그램의 실행을 중지시키지 않아야 합니다. 또한 자동적으로 설치가 되지 않을 경우에는 설치 안내에 따라 수동으로 보안프로그램을 꼭 설치한 후에 전자금융거래를 해야 합니다. 이는 금융거래 내용을 타인에게 노출되지 않도록 하기 위함입니다.</dd>
						<dt>03. 금융 계좌, 공인인증서 등의 각종 비밀번호는 서로 다르게 설정하고 주기적으로 변경하기 </dt>
						<dd>비밀번호는 본인확인을 위한 수단이므로 생일, 전화번호 등과 같이 타인이 알기 쉬운 번호를 사용해서는 안 됩니다. 또한 가능한 범위에서 비밀번호 자릿수를 최대한 늘리고, 영문자도 혼합 사용하며, 각각 다른 번호를 주기적으로 변경하여 타인이 비밀번호를 예상하지 못하도록 해야 합니다.</dd>
						<dt>04. 금융거래 사이트는 주소창에 직접 입력하거나 즐겨찾기로 사용하기</dt>
						<dd>스팸메일 본문이나 게시판, 대출사이트 등에 링크되어 있는 URL을 그대로 클릭할 경우 개인정보나 금융정보를 빼내가려는 해당 기관의 사칭사이트로 연결될 수 있기 때문에 금융거래 사이트는 주소창에 올바른 주소를 직접 입력하거나 즐겨찾기에 추가하여 사용해야 합니다.</dd>
						<dt>05. 전자금융거래 이용내역을 본인에게 즉시 알려주는 휴대폰 서비스 등을 적극 이용하기</dt>
						<dd>금융회사에서는 신용카드 사용내역, 계좌 이체내역 등 전자금융거래 이용내역을 실시간으로 휴대폰 SMS나 메일을 통해 알려주는 서비스를 제공하고 있으니, 이를 적극적으로 활용하시어 타인이 무단으로 전자금융거래를 이용하였을 경우 곧바로 이를 신고하여 피해를 예방할 수 있도록 해야 합니다.</dd>
						<dt>06. 공인인증서는 USB, 스마트카드 등 이동식 저장장치에 보관하기</dt>
						<dd>공인인증서는 신원확인 및 거래사실 증명 등을 위해 사용되는 중요한 거래 수단이므로, 해킹위험을 예방하고 공인증서를 보다 안전하게 이용하시기 위해서는 하드디스크에 저장하여 사용하는 것보다는 이동식 저장장치를 활용하시는 것이 좋습니다. 또한 이동식 저장장치를 이용하면 어느 PC에서든 공인인증서를 편리하게 이용하실 수 있습니다. 단, 이동식 저장장치를 분실하지 않도록 유의해야 합니다.</dd>
						<dt>07. PC방 등 공용 장소에서는 인터넷 금융거래를 자제하기</dt>
						<dd>여러 사람이 사용하는 공용 PC는 바이러스나 트로이목마 등 악성코드가 설치되기 쉬워 해킹 당하기 쉽습니다. 또한 공용 PC에서 공인인증서를 다운받아 전자거래를 이용할 경우 개인정보나 비밀번호 등 금융거래 정보의 노출 위험이 있습니다. 따라서, 공용장소에서는 가급적 전자금융 거래 이용을 하지 않는 것이 좋습니다.</dd>
						<dt>08. 바이러스백신, 스파이웨어 제거프로그램을 이용하고 최신 윈도우보안패치를 적용하기</dt>
						<dd>백신프로그램과 스파이웨어 제거프로그램은 PC의 보안을 위해 꼭 설치하며, 컴퓨터가 시작되면 자동 실행 및 자동 업데이트 되도록 설정합니다. 또한 윈도우즈 취약점을 이용한 해킹이나 웜바이러스를 막기 위해 윈도우 보안패치를 설치하고, 최신 업데이트를 유지하기 위해 자동 업데이트 기능을 이용하도록 합니다.</dd>
						<dt>09. 의심되는 이메일이나 게시판의 글은 열어보지 말고, 첨부파일은 열람 또는 저장하기 전에 백신으로 검사하기</dt>
						<dd>출처가 불분명하고 본문 내용이 본인과 직접적인 관련이 없는 경우 메일이나 게시물은 삭제하거나 무시하고, 꼭 필요한 경우에는 실행하거나 저장하기 전에 반드시 백신으로 점검하여 바이러스나 악성코드에 감염되지 않았는지 여부를 확인하여야 합니다.</dd>
						<dt class="or">10. 선수금 입금 요구, 상식수준 이상의 대출 조건을 제시하는 경우 해당 금융회사에 동 대출 취급여부를 직접 확인하기</dt>
						<dd>최근 인터넷 포털 사이트 등에 신용에 관계없이 즉시 대출을 해준다는 등 상식수준 이상의 대출 조건을 제시하는 광고를 게재한 후 이를 통해 급전이 필요한 사람에게 접근하여 은행직원을 사칭, 거래실적이 필요하다면서 돈을 입금토록 하는 등 선수금 입금을 요구하는 사기 금융하고가 발생하고 있으므로 이에 유의해야 합니다.</dd>
					</dl>
						<strong>상기 약관을 동의합니다</strong>&nbsp;&nbsp;<input type="checkbox" name="checkTerms">	
		   	</div>
		  </div>
		
		
		  <div class="w3-container w3-light-grey w3-padding">
		   <button class="w3-button w3-right w3-white w3-border" 
		   onclick="document.getElementById('id01').style.display='none'" id="checkTermsBtn" >Close</button>
		  </div>
		 </div>
		</div>
		
		</div>
	
	
	<footer>
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>	
	</footer>
</body>
</html>