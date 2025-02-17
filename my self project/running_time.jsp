<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../static/css/running.css">
	<title>(DOLBY CINEMA) 상영시간표 &lt; 극장 | MEET PLAY SHARE, 메가박스</title>
	<link rel="dolby_cinema.html">
	<script defer src="../static/js/running.js"></script>
</head>
<header id="header">
	<h1 class="ci"><a href="/" title="MEGABOX 메인으로 가기">MEGABOX : Life Theater</a></h1>
	<div class="ie-update">
		<div class="dimd"></div>
		<div class="wrap">
			<p class="tit">
				<img src="../../../static/pc/images/ie/txt-update.png" alt="megabox 홈페이지는 internet explrer10이상에서 최적화된 서비스 이용이 가능합니다. ie9 이하에서는 예매가 정상적으로 진행되지 않을 수 있으니, 브라우저를 업그레이드하시거나 다른 예매수단을 이용해 주세요!">
			</p>

			<div class="box">
				<div class="col">
					<p class="txt">브라우저를 최신 버전으로<br>업그레이드 해보세요!</p>

					<div class="link">
						<a href="https://www.microsoft.com/ko-kr/download/internet-explorer.aspx" title="internet explorer 새 버전 다운로드" target="_blank">
							<img src="../../../static/pc/images/ie/btn-ie.png" alt="internet explorer 새 버전 다운로드">
						</a>
					</div>

					<div class="link">
						<a href="http://www.google.com/chrome?hl=ko" title="chrome 다운로드" target="_blank">
							<img src="../../../static/pc/images/ie/btn-chrome.png" alt="chrome 다운로드">
						</a>
					</div>
				</div>

				<div class="col">
					<p class="txt">megabox 모바일 app을<br>이용해 보세요!</p>

					<div class="link">
						<a href="https://itunes.apple.com/us/app/megabox/id894443858?l=ko&amp;ls=1&amp;mt=8" title="available on the app store" target="_blank">
							<img src="../../../static/pc/images/ie/btn-appstore.png" alt="available on the app store">
						</a>
					</div>

					<div class="link">
						<a href="https://play.google.com/store/apps/details?id=com.megabox.mop&amp;hl=ko" title="available on the google play" target="_blank">
							<img src="../../../static/pc/images/ie/btn-google.png" alt="available on the google play">
						</a>
					</div>
				</div>
			</div>

			<div class="close-chk">
				<input type="checkbox" id="one_month_no_update">
				<label for="one_month_no_update" class="ml05">한 달 동안 이 창을 열지 않음</label>

				<button type="button" class="closeDl button purple x-small ml20">닫기</button>
			</div>
		</div>
	</div>
	<div class="util-area">
        <div class="left-link">
            <a href="/benefit/viplounge" title="VIP LOUNGE">VIP LOUNGE</a>
            <a href="/benefit/membership" title="멤버십">멤버십</a>
            <a href="/support" title="고객센터">고객센터</a>
        </div>

        <div class="right-link">
            <!-- 로그인전 -->
            <div class="before" style="">
                <a href="javaScript:fn_viewLoginPopup('default','pc')" title="로그인">로그인</a>
                <a href="/join" title="회원가입">회원가입</a>
            </div>

            <!-- 로그인후 -->
            <div class="after" style="display:none">
                <a href="/on/oh/ohg/MbLogin/mbLogout.do" class="" title="로그아웃">로그아웃</a>
                <a href="" class="notice" title="알림">알림</a>

                <!-- layer-header-notice -->
				<div class="layer-header-notice">
					<div class="notice-wrap">
						<p class="tit-notice">알림함</p>

						<div class="count">
							<p class="left">전체 <em class="totalCnt">0</em> 건</p>

							<p class="right">* 최근 30일 내역만 노출됩니다.</p>
						</div>

						<!-- scroll -->
						<div class="scroll m-scroll mCustomScrollbar _mCS_1 mCS_no_scrollbar"><div id="mCSB_1" class="mCustomScrollBox mCS-light mCSB_vertical mCSB_inside" style="max-height: none;" tabindex="0"><div id="mCSB_1_container" class="mCSB_container mCS_no_scrollbar_y" style="position:relative; top:0; left:0;" dir="ltr">
							<ul class="list">
								<li class="no-list">
									알림 내역이 없습니다.
								</li>
							</ul>
						</div><div id="mCSB_1_scrollbar_vertical" class="mCSB_scrollTools mCSB_1_scrollbar mCS-light mCSB_scrollTools_vertical"><div class="mCSB_draggerContainer"><div id="mCSB_1_dragger_vertical" class="mCSB_dragger" style="position: absolute; min-height: 30px; display: none; top: 0px;"><div class="mCSB_dragger_bar" style="line-height: 30px;"></div></div><div class="mCSB_draggerRail"></div></div></div></div></div>
						<div class="notice-list-more">
							<button type="button" class="button btn-more-notice-list">더보기 <i class="iconset ico-btn-more-arr"></i></button>
						</div>
						<!--// scroll -->
						<button type="button" class="btn-close-header-notice">알림 닫기</button>
					</div>
					<!--// notice-wrap -->
				<!--// layer-header-notice -->
				</div>

            </div>

            <a href="/booking">빠른예매</a>
        </div>
    </div>
	<div class="link-area">
        <a href="#layer_sitemap" class="header-open-layer btn-layer-sitemap" title="사이트맵">사이트맵</a>
        <a href="#layer_header_search" class="header-open-layer btn-layer-search" title="검색">검색</a>
        <a href="/booking/timetable" class="link-ticket" title="상영시간표">상영시간표</a>
        <a href="#layer_mymega2" class="header-open-layer btn-layer-mymega" title="나의 메가박스">나의 메가박스</a>
    </div>
	<nav id="gnb" class="">
        <ul class="gnb-depth1">
            <li class=""><a href="/movie" class="gnb-txt-movie" title="영화">영화</a>
                <div class="gnb-depth2">
                    <ul>
                        <li><a href="/movie" title="전체영화">전체영화</a></li>



                        
                        <li id="festivalArea" style="display: none;"><a href="/festival" title="영화제">영화제</a></li>

                    </ul>
                </div>
            </li>
            <li class=""><a href="/booking" class="gnb-txt-reserve" title="예매">예매</a>
                <div class="gnb-depth2">
                    <ul>
                        <li><a href="/booking" title="빠른예매">빠른예매</a></li>
                        <li><a href="/booking/timetable" title="상영시간표">상영시간표</a></li>
                        <li><a href="/booking/privatebooking" title="더 부티크 프라이빗 예매">더 부티크 프라이빗 예매</a></li>
                    </ul>
                </div>
            </li>
            <li class=""><a href="/theater/list" class="gnb-txt-theater" title="극장">극장</a>
                <div class="gnb-depth2">
                    <ul>
                        <li><a href="/theater/list" title="전체극장">전체극장</a></li>
                        <li><a href="/specialtheater/list" title="특별관">특별관</a></li>
                    </ul>
                </div>
            </li>
            <li><a href="/event" class="gnb-txt-event" title="이벤트">이벤트</a>
                <div class="gnb-depth2">
                    <ul>
                        <li><a href="/event" title="진행중 이벤트">진행중 이벤트</a></li>
                        <li><a href="/event/end" title="지난 이벤트">지난 이벤트</a></li>
                        <li><a href="/event/winner/list" title="당첨자발표">당첨자발표</a></li>
                    </ul>
                </div>
            </li>
            <li><a href="/store" class="gnb-txt-store" title="스토어">스토어</a></li>
            <li><a href="/benefit/membership" class="gnb-txt-benefit" title="혜택">혜택</a>
                <div class="gnb-depth2">
                    <ul>
                        <li><a href="/benefit/membership" title="메가박스 멤버십">메가박스 멤버십</a></li>
                        <li><a href="/benefit/discount/guide" title="제휴/할인">제휴/할인</a></li>
                    </ul>
                </div>
            </li>
        </ul>
    </nav>
	<!--// gnb -->
	<div id="layer_sitemap" class="header-layer layer-sitemap">
        <!-- wrap -->
        <div class="wrap">
            <a href="" class="link-acc" title="사이트맵 레이어 입니다.">사이트맵 레이어 입니다.</a>

            <p class="tit">SITEMAP</p>

            <div class="list position-1">
                <p class="tit-depth">영화</p>

                <ul class="list-depth">
                    <li><a href="/movie" title="전체영화">전체영화</a></li>

                </ul>
            </div>

            <div class="list position-2">
                <p class="tit-depth">예매</p>

                <ul class="list-depth">
                    <li><a href="/booking" title="빠른예매">빠른예매</a></li>
                    <li><a href="/booking/timetable" title="상영시간표">상영시간표</a></li>
                    <li><a href="/booking/privatebooking" title="더 부티크 프라빗 예매">더 부티크 프라이빗 예매</a></li>
                    <!-- <li><a href="/booking?megaboxLanguage=en" title="English Ticketing">English Ticketing</a></li> -->
                </ul>
            </div>

            <div class="list position-3">
                <p class="tit-depth">극장</p>

                <ul class="list-depth">
                    <li><a href="/theater/list" title="전체극장">전체극장</a></li>
                    <li><a href="/specialtheater/list" title="특별관">특별관</a></li>
                </ul>
            </div>

            <div class="list position-4">
                <p class="tit-depth">이벤트</p>

                <ul class="list-depth">
                    <li><a href="/event" title="진행중 이벤트">진행중 이벤트</a></li>
                    <li><a href="/event/end" title="지난 이벤트">지난 이벤트</a></li>
                    <li><a href="/event/winner/list" title="당첨자발표">당첨자발표</a></li>
                </ul>
            </div>

            <div class="list position-5">
                <p class="tit-depth">스토어</p>

                <ul class="list-depth">
                    <li><a href="/store" title="새로운 상품">새로운 상품</a></li>
                    <li><a href="/store/megaticket" title="메가티켓">메가티켓</a></li>
                    <li><a href="/store/popcorn" title="팝콘/음료/굿즈">팝콘/음료/굿즈</a></li>
                    <li><a href="/store/pointmall" title="포인트몰">포인트몰</a></li>
                </ul>
            </div>
            <div class="list position-6">
                <p class="tit-depth">나의 메가박스</p>
                <ul class="list-depth mymage">
					<li><a href="javascript:movePage('/mypage',						'로그인이 필요한 서비스 입니다. \n로그인하시겠습니까?');" title="나의 메가박스 홈">나의 메가박스 홈</a></li>
					<li><a href="javascript:movePage('/mypage/bookinglist',			'로그인이 필요한 서비스 입니다. \n로그인하시겠습니까?');" title="예매/구매내역">예매/구매내역</a></li>
					<li><a href="javascript:movePage('/mypage/movie-coupon',		'로그인이 필요한 서비스 입니다. \n로그인하시겠습니까?');" title="영화관람권">영화관람권</a></li>
					<li><a href="javascript:movePage('/mypage/store-coupon',		'로그인이 필요한 서비스 입니다. \n로그인하시겠습니까?');" title="스토어교환권">스토어교환권</a></li>
					<li><a href="javascript:movePage('/mypage/discount-coupon',		'로그인이 필요한 서비스 입니다. \n로그인하시겠습니까?');" title="할인/제휴쿠폰">할인/제휴쿠폰</a></li>
					
					<li><a href="javascript:movePage('/mypage/point-list',			'로그인이 필요한 서비스 입니다. \n로그인하시겠습니까?');" title="멤버십포인트">멤버십포인트</a></li>
					<li><a href="javascript:movePage('/mypage/moviestory',			'로그인이 필요한 서비스 입니다. \n로그인하시겠습니까?');" title="나의 무비스토리">나의 무비스토리</a></li>
					<li><a href="javascript:movePage('/mypage/myevent',				'로그인이 필요한 서비스 입니다. \n로그인하시겠습니까?');" title="나의 이벤트 응모내역">나의 이벤트 응모내역</a></li>
					<li><a href="javascript:movePage('/mypage/myinquiry',			'로그인이 필요한 서비스 입니다. \n로그인하시겠습니까?');" title="나의 문의내역">나의 문의내역</a></li>
					<li><a href="#" title="자주쓰는 할인카드">자주쓰는 할인카드</a></li>
					<li><a href="javascript:movePage('/on/oh/ohh/Mypage/mainPage.do?returnURL=info','로그인이 필요한 서비스 입니다.');" title="회원정보">회원정보</a></li>
                </ul>
            </div>

            <div class="list position-7">
                <p class="tit-depth">혜택</p>

                <ul class="list-depth">
                    <li><a href="/benefit/membership" title="멤버십 안내">멤버십 안내</a></li>
                    <li><a href="/benefit/viplounge" title="VIP LOUNGE">VIP LOUNGE</a></li>
                    <li><a href="/benefit/discount/guide" title="제휴/할인">제휴/할인</a></li>
                </ul>
            </div>

            <div class="list position-8">
                <p class="tit-depth">고객센터</p>

                <ul class="list-depth">
                    <li><a href="/support" title="고객센터 홈">고객센터 홈</a></li>
                    <li><a href="/support/faq" title="자주묻는질문">자주묻는질문</a></li>
                    <li><a href="/support/notice" title="공지사항">공지사항</a></li>
                    <li><a href="/support/inquiry" title="1:1문의">1:1문의</a></li>
                    <li><a href="/support/rent" title="단체/대관문의">단체/대관문의</a></li>
                    <li><a href="/support/lost" title="분실물문의">분실물문의</a></li>
                </ul>
            </div>

            <div class="list position-9">
                <p class="tit-depth">회사소개</p>

                <ul class="list-depth">
                    <li><a href="/megaboxinfo" target="_blank" title="메가박스소개">메가박스소개</a></li>
                    <li><a href="/socialcontribution" target="_blank" title="사회공헌">사회공헌</a></li>
                    <li><a href="/advertize" target="_blank" title="홍보자료">홍보자료</a></li>
                    <li><a href="/partner" target="_blank" title="제휴/부대사업문의">제휴/부대사업문의</a></li>
                    <li><a href="/onlinereport" target="_blank" title="온라인제보센터">온라인제보센터</a></li>
                    <li><a href="/ir" target="_blank" title="자료">IR자료</a></li>
                    <li><a href="/recruit" target="_blank" title="인재채용림">인재채용</a></li>
                    <li><a href="https://jebo.joonganggroup.com/main.do" target="_blank" title="윤리경영">윤리경영</a></li>
                </ul>
            </div>

            <div class="list position-10">
                <p class="tit-depth">이용정책</p>

                <ul class="list-depth">
                    <li><a href="/support/terms" title="이용약관">이용약관</a></li>
                    <li><a href="/support/lcinfo" title="위치기반서비스 이용약관">위치기반서비스 이용약관</a></li>
                    <li><a href="/support/privacy" title="개인정보처리방침">개인정보처리방침</a></li>
                    <li><a href="/support/screenrule" title="스크린수배정에관한기준">스크린수배정에관한기준</a></li>
                </ul>
            </div>

            <div class="ir">
                <a href="" class="layer-close" title="레이어닫기">레이어닫기</a>
            </div>
        </div>
        <!--// wrap -->
    </div>
</header>
<body>
<div>
	<div class="section inner-wrap" style="display: none;">
	<!-- 20241018 리뉴얼 버전 특별관 -->
	<div class="theaterSpecialsub">

		<div class="headLIneTitleArea">
			<h3 class="logoImg"><img src="https://img.megabox.co.kr/static/pc/images/2024Re/theater/dolbycinema/titlelogo.png" alt=""></h3>
			<h4>완벽한 영화 관람을 완성하는 하이엔드 시네마</h4>
			<h5>극강의 선명함과 더 압도적인 사운드로 현존 최고의 영화 관람 경험을 선사합니다.<br>돌비시네마는 어디에서나 동일한 퀄리티를 느낄 수 있도록 모든 상영관에 돌비의 엄격한 기준을 적용합니다.</h5>
		</div>

		<div class="sectionArea">
			<section>
				<article>
					<div class="img"><img src="https://img.megabox.co.kr/static/pc/images/2024Re/theater/dolbycinema/img01.png" alt=""></div>
					<dl>
						<dt>돌비 비전</dt>
						<dd>모든 디테일을 한눈에 제공하는 Dolby Vision은 본연의 색 그대로 풍부하고<br>사실적인 색감을 구현하여 영화의 리얼리티를 극대화 합니다.</dd>
					</dl>
				</article>
				<article>
					<div class="img"><img src="https://img.megabox.co.kr/static/pc/images/2024Re/theater/dolbycinema/img02.png" alt=""></div>
					<dl>
						<dt>돌비 애트모스</dt>
						<dd>Dolby Atmos의 온 몸을 감싸는 듯한 공간감 넘치는 사운드는<br>마치 영화 속에 있는 듯한 몰입감 넘치는 사운드 경험을 선사합니다.</dd>
					</dl>
				</article>
				<article>
					<div class="img"><img src="https://img.megabox.co.kr/static/pc/images/2024Re/theater/dolbycinema/img03.png" alt=""></div>
					<dl>
						<dt>리얼블랙</dt>
						<dd>극명한 명암대비로 밝은 장면은 40배 더 밝게, 어두운 장면은 10배 더 어둡게<br>블랙의 디테일을 표현함으로써 어떤 어둠과 빛도 더 선명하게 표현합니다.</dd>
					</dl>
				</article>
				<div class="addText01">여러분의 영화 경험은 돌비 시네마로 새로워집니다.<br>지금 경험할 수 있는 최고의 영화관</div>
			</section>
		</div>
	</div>
	<!--//20241018 리뉴얼 버전 특별관 end -->
</div>
<!-- section -->
<div class="sectionPlayTime" style>
  <!-- bg-wrap -->
  <div class="bg-wrap">
    <div class="inner-wrap">
      <div class="tab-sorting mb30">
        <button type="button" title="남양주현대아울렛 스페이스원 상영시간표 보기" data-cd="0019" class="on"> 
           남양주현대아울렛 스페이스원
        </button>
        <button type="button" title="대구신세계(동대구) 상영시간표 보기" data-cd="7011"> 
           대구신세계(동대구)
        </button> 
        <button type="button" title="대전신세계 아트앤사이언스 상영시간표 보기" data-cd="0028"> 
           대전신세계 아트앤사이언스
        </button>
        <button type="button" title="송도 상영시간표 보기" data-cd="4062"> 
           송도
        </button>
        <button type="button" title="수원Ak플라자 상영시간표 보기" data-cd="0052"> 
           수원Ak플라자
        </button>
        <button type="button" title="안성스타필드 상영시간표 보기" data-cd="0020"> 
           안성스타필드
        </button>
        <button type="button" title="코엑스 상영시간표 보기" data-cd="1351"> 
           코엑스
        </button>
        <button type="button" title="하남스타필드 상영시간표 보기" data-cd="4651">하남스타필드</button>
      </div>
      <div class="box-slash">
        <p class="tit-pr font-28">
          DOLBY CINEMA 
        <span class="brchNm">남양주현대아울렛 스페이스원</span>
      </p>
      <p class="txt">
        <span class="addr1">경기도 남양주시 다산순환로 50, (다산동) 현대프리미엄아울렛 스페이스원 3층</span>
      </p>
      <div class="box-slash-btn">
        <a href="#" class="font-green moveBrch" title="약도/주차안내 페이지로 이동">약도/주자안내</a>  
      </div>
    </div>
    <h2 class="tit small mt70" style="display:none">무대인사</h2> 
    <div class="reserve movie-greeting" style="display:none"></div>
    <h2 class="tit small mt70">상영시간표</h2>
    <div class="time-schedule mb30">
      <div class="wrap">
        <button type="button" title="이전 날짜 보기" class="btn-pre" disabled="true">
          <i class="iconset ico-cld-pre"></i>
          <em>이전</em>
        </button>
        <div class="date-list">
          <div class="year-area">
            <div class="year" style="left: 30px; z-index: 1; opacity: 1;">2024.08</div>
            <div class="year" style="left: 450px; z-index: 1; opacity: 0;"></div>
          </div>
          <div class="date-area"> 
            <div class="wrap" style="position: relative; width: 2100px; border: none; left: -70px;">
              <button class="disabled" type="button" date-data="2024.08.13" month="7" tabindex="-1">
                <span class"ir">2024년 8월</span>
                <em style="pointer-events:none;">
                   13
                  <span style="pointer-events:none;" class="ir">일</span>
                </em>
                <span class="day-kr" style="pointer-events:none;display:inline-block">화</span>
                <span class="day-en" style="pointer-events:none;display:none">Tue</span>
              </button>
              <button class="on" type="button" date-data="2024.08.14" month="7">
                <span class="ir">2024년 8월</span>
                <em style="pointer-events:none;">
                   14
		          <span style="pointer-events:none;" class="ir">일</span>
		        </em>
				<span class="day-kr" style="pointer-events:none;display:inline-block">오늘</span>
				<span class="day-en" style="pointer-events:none;display:none">Wed</span>
			  </button>
		      <button class type="button" date-data="2024.08.15" month="7">
		        <span class="ir">2024년 8월</span>
		        <em style="pointer-events:none;">
		           15
		          <span style="pointer-events:none;" class="ir">일</span>
		        </em>
		        <span class="day-kr" style="pointer-events:none;display:inline-block">내일</span>
		        <span class="day-en" style="pointer-events:none;display:none">Thu</span>
		      </button>
			  <button class type="button" date-data="2024.08.16" month="7">
			    <span class="ir">2024년 8월</span>
			    <em style="pointer-events:none;">
			       16
			      <span style="pointer-events:none;" class="ir">일</span>
			    </em>
			    <span class="day-kr" style="pointer-events:none;display:inline-block">금</span> 
			    <span class="day-en" style="pointer-events:none;display:none">Fri</span>
			  </button>
			  <button class="disabled sat" type="button" date-data="2024.08.17" month="7">
			    <span class="ir">2024년 8월</span>
                <em style="pointer-events:none;">
                   17   
                  <span style="pointer-events:none;" class="ir">일</span>
                </em>
                <span class="day-kr" style="pointer-events:none;display:inline-block">토</span>    
                <span class="day-en" style="pointer-events:none;display:none">Sat</span>
              </button>
              <button class="disabled hoil" type="button" date-data="2024.08.18" month="7">
                <span class="ir">2024년 8월</span> 
			    <em style="pointer-events:none;">
				    18 
				   <span style="pointer-events:none;" class="ir">일</span>
				 </em>
				 <span class="day-kr" style="pointer-events:none;display:inline-block">일</span>                        
			 	 <span class="day-en" style="pointer-events:none;display:none">Sun</span>
			   </button>
			   <button class="disabled" type="button" date-data="2024.08.19" month="7">
				 <span class="ir">2024년 8월</span>
				 <em style="pointer-events:none;">
				    19   
				   <span style="pointer-events:none;" class="ir">일</span>
				 </em>
				 <span class="day-kr" style="pointer-events:none;display:inline-block">월</span>    
				 <span class="day-en" style="pointer-events:none;display:none">Mon</span>
			   </button>
			   <button class="disabled" type="button" date-data="2024.08.20" month="7">
				 <span class="ir">2024년 8월</span>
				 <em style="pointer-events:none;">
				    20   
				   <span style="pointer-events:none;" class="ir">일</span>
				 </em>
				 <span class="day-kr" style="pointer-events:none;display:inline-block">화</span>    
				 <span class="day-en" style="pointer-events:none;display:none">Tue</span>
			   </button>
			   <button class="disabled" type="button" date-data="2024.08.21" month="7">
			     <span class="ir">2024년 8월</span>
				 <em style="pointer-events:none;">
					21   
				   <span style="pointer-events:none;" class="ir">일</span>
				 </em>
				 <span class="day-kr" style="pointer-events:none;display:inline-block">수</span>    
				 <span class="day-en" style="pointer-events:none;display:none">Wed</span>
			   </button>
			   <button class="disabled" type="button" date-data="2024.08.22" month="7">
			    <span class="ir">2024년 8월</span>
				<em style="pointer-events:none;">
				   22  
				  <span style="pointer-events:none;" class="ir">일</span>
				</em>
				<span class="day-kr" style="pointer-events:none;display:inline-block">목</span>    
				<span class="day-en" style="pointer-events:none;display:none">Thu</span>
			  </button> 
			  <button class="disabled" type="button" date-data="2024.08.23" month="7">
			    <span class="ir">2024년 8월</span>
				<em style="pointer-events:none;">
				   23   
				  <span style="pointer-events:none;" class="ir">일</span>
					 </em>
					   <span class="day-kr" style="pointer-events:none;display:inline-block">금</span>    
					    <span class="day-en" style="pointer-events:none;display:none">Fri</span>
					   </button> 
					   <button class="disabled sat" type="button" date-data="2024.08.24" month="7">
					   <span class="ir">2024년 8월</span>
					   <em style="pointer-events:none;">
					     24   
					    <span style="pointer-events:none;" class="ir">일</span>
					 </em>
					   <span class="day-kr" style="pointer-events:none;display:inline-block">토</span>    
					    <span class="day-en" style="pointer-events:none;display:none">Sat</span>
					   </button> 
					    <button class="disabled holi" type="button" date-data="2024.08.25" month="7">
					   <span class="ir">2024년 8월</span>
					   <em style="pointer-events:none;">
					     25   
					    <span style="pointer-events:none;" class="ir">일</span>
					 </em>
					   <span class="day-kr" style="pointer-events:none;display:inline-block">일</span>    
					    <span class="day-en" style="pointer-events:none;display:none">Sun</span>
					   </button>
					    <button class="disabled" type="button" date-data="2024.08.26" month="7">
					   <span class="ir">2024년 8월</span>
					   <em style="pointer-events:none;">
					     26   
					    <span style="pointer-events:none;" class="ir">일</span>
					 </em>
					   <span class="day-kr" style="pointer-events:none;display:inline-block">월</span>    
					    <span class="day-en" style="pointer-events:none;display:none">Mon</span>
					   </button> 
					    <button class="disabled" type="button" date-data="2024.08.27" month="7">
					   <span class="ir">2024년 8월</span>
					   <em style="pointer-events:none;">
					     27   
					    <span style="pointer-events:none;" class="ir">일</span>
					 </em>
					   <span class="day-kr" style="pointer-events:none;display:inline-block">화</span>    
					    <span class="day-en" style="pointer-events:none;display:none">Tue</span>
					   </button> 
					    <button class="disabled" type="button" date-data="2024.08.28" month="7" tabindex="-1">
					   <span class="ir">2024년 8월</span>
					   <em style="pointer-events:none;">
					     28   
					    <span style="pointer-events:none;" class="ir">일</span>
					 </em>
					   <span class="day-kr" style="pointer-events:none;display:inline-block">수</span>    
					    <span class="day-en" style="pointer-events:none;display:none">Wed</span>
					   </button>          
					    </div>
					  </div> 
					</div>
					<button type="button" title="다음 날짜 보기" class="btn-next" disabled="true">
					 <i class="bg-line"></i>
					 <em>다음</em>
					 </button>
					<div class="bg-line">
					  <input type="hidden" name="datePicker" id="dp1723785640789" class="hasDatepicker" value="2024.08.14">
					<button type="hidden" class="btn-calendar-large" title="달력보기"> 달력보기</button>
				  </div> 
				</div>
			   </div>
			   <div class="movie-option mb20">
				 <div class="option">
			       <ul>
					 <li>
					   <i class="iconset ico-stage" title="무대인사"></i>
					    무대인사
					 </li>
					 <li>
					   <i class="iconset ico-user" title="회원시사"></i>
					    회원시사
					 </li>
					 <li>
					   <i class="iconset ico-open" title="오픈시사"></i>
					    오픈시사
					 </li>
					 <li>
					   <i class="iconset ico-goods" title="굿즈패키지"></i>
					    굿즈패키지
					  </li>
					  <li>
				        <i class="iconset ico-goods" title="싱어롱"></i>
					     싱어롱
					  </li>
					  <li> 
					    <i class="iconset ico-goods" title="GV"></i>
                         GV
                      </li>
                      <li>
                        <i class="iconset ico-brunch" title="브런치"></i>
                         브런치
                      </li>
                      <li>
                        <i class="iconset ico-brunch" title="심야"></i>
                         심야
                      </li>   
                     </ul>
                    </div>
                    <div class="rateing-lavel">
                      <a href class title="관람등급안내"></a>
                       관람등급안내
                     </a>
                   </div>
                 </div>
                 <div class="reserve theater-list-box"
</body>
</html>