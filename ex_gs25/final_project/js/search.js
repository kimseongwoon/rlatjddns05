

<script type="text/javascript">
//<![CDATA[

var bookObj = {
		formName : "bookmarkForm",
		loginChk : function(){
			var isLogin = "false";
			if (isLogin == "true") {
				bookObj.setFormInformation();
			} else {
				commonScriptController.addCommonLayerBg();
				commonScriptController.showCommonLayerBg();
				commonScriptController.showCommonPopup($("#lypop_my1"), 1000);
			}
		},
		popupClose : function() {
			commonScriptController.closeCommonLayerBg();
			commonScriptController.closeCommonPopup($("#lypop_my1"));
		},
		loginMove : function() {
			location.href = "/gscvs/ko/sign-up/login";
		},
		setFormInformation : function(){

			if($("#bookMarkListBox > li").size() == 8) {
				alert("즐겨찾기 메뉴는 최대 8개까지 등록 가능합니다.");
				return false;
			}

			$( "#" + bookObj.formName ).remove();
			var tFormHTML = "<form name='" + bookObj.formName + "' id='" + bookObj.formName + "'>\n";
			tFormHTML += "<input type='hidden' name='pageId' id='pageId' value='event-goods-Page'/>\n";
			tFormHTML += "<input type='hidden' name='dataType' id='dataType' value='I'/>\n";
			tFormHTML += "</form>\n";
			$("body").append( tFormHTML );
			bookObj.setData();
		},
		setData : function(){
			var tUrl = "/gscvs/ko/gscommon/set-bookmark";

			$.ajax({
				type : "post",
				url : tUrl + "?" + bookObj.getCSRFToken(),
				data : $("form#" + bookObj.formName ).serialize(),
				dataType : "json",
				error : function( request, status, error ){
					console.log( "code:" + request.status+"\n" + "message:" + request.responseText+"\n" + "error:" + error );
				},
				success : function(result){
					var resultCode = JSON.parse(result);

					var bookMarkHtml = "";

					if(resultCode.length == 1) {
						bookMarkHtml = "<p class='menu_tit'>나만의 메뉴</p>";
						bookMarkHtml += "<ul class='menu_lst' id='bookMarkListBox'>";
						bookMarkHtml += "<li id='bookMarkList_0'><div class='menu_cnt'><a href='"+resultCode[0].BookMarkAddress+"'>"+resultCode[0].PageName+"</a></div><div class='menu_del'><a href=\"javascript:bookMenuObj.setFormInformation(\'"+resultCode[0].pk+"\', \'bookMarkList_0\', \'"+resultCode[0].PageID+"\');\">삭제</a></div></li> \n";
						bookMarkHtml += "</ul>";
						bookMarkHtml += "<div class='ctr'><a href='#;' class='prev'>이전 나만의메뉴</a><a href='#;' class='next'>다음 나만의 메뉴</a></div>";						
						$("#bookMarkListBoxTop").html(bookMarkHtml);
					} else {
						for(var i = 0; i < resultCode.length; i++) {
							bookMarkHtml += "<li id='bookMarkList_"+i+"'><div class='menu_cnt'><a href='"+resultCode[i].BookMarkAddress+"'>"+resultCode[i].PageName+"</a></div><div class='menu_del'><a href='javascript:bookMenuObj.setFormInformation(\'"+resultCode[i].pk+"\', \'bookMarkList_"+i+"\', \'"+resultCode[i].PageID+"\');'>삭제</a></div></li> \n";
						}
						$("#bookMarkListBox").html(bookMarkHtml);
						bookMenuObj.setMoveHTML();
					}

					$("#bookMarkBtn").attr("href", "#;").addClass("on");
					bookObj.getData();
					alert("즐겨찾기에 등록되었습니다.");
				}
			});
		},
		getData : function(){
			var tUrl = "/gscvs/ko/gscommon/set-bookmark";
			$("#dataType").val("S");

			$.ajax({
				type : "post",
				url : tUrl + "?" + bookObj.getCSRFToken(),
				data : $("form#" + bookObj.formName ).serialize(),
				dataType : "json",
				error : function( request, status, error ){
					console.log( "code:" + request.status+"\n" + "message:" + request.responseText+"\n" + "error:" + error );
				},
				success : function(result){
					var resultCode = JSON.parse(result);
					
					var bookMarkHtml = "";
					for(var i = 0; i < resultCode.length; i++) {
						bookMarkHtml += "<li id='bookMarkList_"+i+"'><div class='menu_cnt'><a href='"+resultCode[i].BookMarkAddress+"'>"+resultCode[i].PageName+"</a></div><div class='menu_del'><a href=\"javascript:bookMenuObj.setFormInformation(\'"+resultCode[i].pk+"\', \'bookMarkList_"+i+"\', \'"+resultCode[i].PageID+"\');\">삭제</a></div></li> \n";						
					}
					$("#bookMarkListBox").html(bookMarkHtml);
					bookMenuObj.setMoveHTML();
				}
			});
		},
		getCSRFToken : function(){
			return "CSRFToken="+$("[name='CSRFToken']").val();
	 	}
}


var naviListController = function(){
	this._FONT_SIZE = -1;
	this._NAVI_INFO = [];
	this._MOTION_TIME = 0.4;
	this._UL_STR = ".lctwrap ul.lct > li .lct_ly";
	this._LI_STR = ".lctwrap ul.lct > li";
	this._OPEN_MENU = -1;
	this._MENU_TAB_WIDTH = 80;
	this.init = function(){
		var tThis = this;
		var arrAfterWidth = [];
		var beforeWidth = 0;
		this._FONT_SIZE = parseInt( $( this._UL_STR + " ul li a" ).css( "font-size" ) );
		$( ".lctwrap ul.lct > li > .menuArea" ).each(function() {
			$(this).data("areaWidth", parseInt($(this).parent().find("div.lct_ly").css("width")));
			$(this).on("click", function() {
					tThis.bindExplosureMenu($(this));
			});
		});
	};
	this.bindExplosureMenu = function($clickMenu) {
		if("none" == $clickMenu.parent().find("div.lct_ly").css("display")) {
			this.showMenu($clickMenu);
		} else {
			this.hideMenu($clickMenu);
			this._OPEN_MENU = -1;
		}
	};
	this.showMenu = function($clickMenu) {
		var tThis = this;
		if(this._OPEN_MENU != -1 && this._OPEN_MENU != $clickMenu) {
			tThis.hideMenu(this._OPEN_MENU);
		}
		this._OPEN_MENU = $clickMenu;
		var $clickMenuParent = $clickMenu.parent();
		$clickMenuParent.css("background" , "none").css("padding-left", "20px");
		$clickMenuParent.find("div.lct_ly").show();
		if($clickMenuParent.next()) {
			$clickMenuParent.next().addClass("selecr_r");
		}

		var tIcon = this.getIcon( $clickMenu );
		var gabWidth = 0;
		var areaWidth = $clickMenu.data("areaWidth");

		TweenMax.set( tIcon, { x:0 } );
		TweenMax.to( tIcon, 0.2, { x:gabWidth } );

		TweenMax.set( $clickMenuParent.find("div.lct_ly").find( " ul li a" ), { fontSize:parseInt( this._FONT_SIZE / 3 ) + "px" } );
		TweenMax.to( $clickMenuParent.find("div.lct_ly").find( " ul li a" ), this._MOTION_TIME, { fontSize:( this._FONT_SIZE ) + "px", ease:Power4.easeOut } );

		TweenMax.set( $clickMenuParent.find("div.lct_ly"), { alpha:0, width:areaWidth } ) ;
		TweenMax.to( $clickMenuParent.find("div.lct_ly"), this._MOTION_TIME, { alpha:1, width:areaWidth+this._MENU_TAB_WIDTH, ease:Power4.easeOut, onComplete:this.showComplete, onCompleteParams:[ $clickMenu ]  } );
	};
	this.hideMenu = function($clickMenu) {
		var $clickMenuParent = $clickMenu.parent();
		if($clickMenuParent.next()) {
			$clickMenuParent.next().removeClass("selecr_r");
		}
		$clickMenuParent.css("background" , "").css("padding-left", "20px");
		$clickMenuParent.find("div.lct_ly").show();

		var tIcon = this.getIcon( $clickMenu );
		var gabWidth = 0;
		var areaWidth = $clickMenu.data("areaWidth");

		TweenMax.set( tIcon, { x:gabWidth } );
		TweenMax.to( tIcon, 0.2, { x:0 } );

		TweenMax.set( $clickMenuParent.find("div.lct_ly").find( " ul li a" ), { fontSize:"0" } );
		TweenMax.set( $clickMenuParent.find("div.lct_ly"), { alpha:1, width:areaWidth+this._MENU_TAB_WIDTH } );
		TweenMax.to( $clickMenuParent.find("div.lct_ly"), this._MOTION_TIME, { alpha:0, width:0, ease:Power4.easeOut, onComplete:this.hideComplete, onCompleteParams:[ $clickMenu ] });
	};
	this.getIcon = function($clickMenu) {
		var rObj;
		if($clickMenu.parent().next()) {
			rObj = $clickMenu.find(".lct_op");
		} else {
			rObj = $clickMenu.find(".lct_lst");
		}
		return rObj;
	}
	this.showComplete = function( $clickMenu ){
	};
	this.hideComplete = function( $clickMenu ){
		$clickMenu.parent().find("div.lct_ly").hide();
	};
}

var naviMenu = new naviListController();

$(document).ready(function(){

	naviMenu.init();



});

//]]>
</script>

<script type="text/javascript">
      //<![CDATA[
      var MAIN_POPUP_COUNT = 0;
      //Validation Message 관리
      $.globalMsg = {
         //입점상담 신규업체 등록
         newRegComNo : "사업자등록번호가 입력이 되지 않았거나 잘못 입력되었습니다.",
         newRegComNm : "회사명이 입력이 되지 않았거나 잘못 입력되었습니다.",
         newRegComGubun : "사업자구분이 입력이 되지 않았거나 잘못 입력되었습니다.",
         newRegBizNo : "법인번호가 입력이 되지 않았거나 잘못 입력되었습니다.",
         newRegBizOwner : "대표자가 입력이 되지 않았거나 잘못 입력되었습니다.",
         newRegBizType : "업태 입력이 되지 않았거나 잘못 입력되었습니다.",
         newRegBizSub : "업종이 입력이 되지 않았거나 잘못 입력되었습니다.",
         newRegPostNo : "우편번호가 입력이 되지 않았거나 잘못 입력되었습니다.",
         newRegEmpNm : "신청인이 입력이 되지 않았거나 잘못 입력되었습니다.",
         newRegEmpBirthYear : "신청인의 생년월일의 연도가 입력이 되지 않았거나 잘못 입력되었습니다.",
         newRegEmpBirthMon : "신청인의 생년월일의 월이 입력이 되지 않았거나 잘못 입력되었습니다.",
         newRegEmpBirthDate : "신청인의 생년월일의 일이 입력이 되지 않았거나 잘못 입력되었습니다.",
         newRegEmpGender : "성별이 입력이 되지 않았거나 잘못 입력되었습니다.",
         newRegEmpEmail : "이메일이 입력이 되지 않았거나 잘못 입력되었습니다.",
         newRegEmpId : "아이디가 입력이 되지 않았거나 잘못 입력되었습니다.",
         newRegEmpPw : "비밀번호가 입력이 되지 않았거나 잘못 입력되었습니다.",
         newRegEmpPwNotEq : "비밀번호가 일치하지 않습니다.",
         newRegEmpPhoneNo : "전화번호가 입력이 되지 않았거나 잘못 입력되었습니다.",
         newRegEmpHpNo : "휴대폰이 입력이 되지 않았거나 잘못 입력되었습니다."
      };
      
      function setPopupPosition(popupObj) {
         try{
            var height = (popupObj.popupPositionWidth / 2) + 70;
            var width  = (popupObj.popupPositionHeight / 2) + 50;
            
            if(popupObj.popupPosition.code == "TOPLEFT"){
               $("#popManage"+popupObj.pk).css("top",height+"px");
               $("#popManage"+popupObj.pk).css("left",width+"px");
            }else if(popupObj.popupPosition.code == "TOPMIDDLE"){
               $("#popManage"+popupObj.pk).css("top",height+"px");
            }else if(popupObj.popupPosition.code == "TOPRIGHT"){
               $("#popManage"+popupObj.pk).css("top",height+"px");
               $("#popManage"+popupObj.pk).css("left","");
               $("#popManage"+popupObj.pk).css("right",width+"px");
            }else if(popupObj.popupPosition.code == "MIDLEFT"){
               $("#popManage"+popupObj.pk).css("left",width+"px");
            }else if(popupObj.popupPosition.code == "MIDRIGHT"){
               $("#popManage"+popupObj.pk).css("left","");
               $("#popManage"+popupObj.pk).css("right",width+"px");
            }else if(popupObj.popupPosition.code == "BOTTOMLEFT"){
               $("#popManage"+popupObj.pk).css("top","");
               $("#popManage"+popupObj.pk).css("bottom",height+"px");
               $("#popManage"+popupObj.pk).css("left",width+"px");
            }else if(popupObj.popupPosition.code == "BOTTOMMIDDLE"){
               $("#popManage"+popupObj.pk).css("top","");
               $("#popManage"+popupObj.pk).css("bottom",height+"px");
            }else if(popupObj.popupPosition.code == "BOTTOMRIGHT"){
               $("#popManage"+popupObj.pk).css("top","");
               $("#popManage"+popupObj.pk).css("bottom",height+"px");
               $("#popManage"+popupObj.pk).css("left","");
               $("#popManage"+popupObj.pk).css("right",width+"px");
            }else if(popupObj.popupPosition.code == "MANUAL"){
               $("#popManage"+popupObj.pk).css("top",popupObj.manuallyTopPosition);
               $("#popManage"+popupObj.pk).css("left",popupObj.manuallyLeftPosition);
            }
         }catch(e){}
      }
      
      function popupTermCkecked(pk) {
         var term = "";
      
         if($("#popManage" + pk ).attr("term") == "ONE"){
            term = 1;
         }else if($("#popManage" + pk).attr("term") == "SEVEN"){
            term = 7;
         }
      
         $.makeExpierCookie( "gsCommonPopup" + pk + "_pop", "done" , term);
          
          $('#popManage' + pk).fadeOut();
      }
      
      function inputFormNxtBtn(){
         
      }
      
      function webIdCheck(){
         var inputID = $("#us_id").val();
         if(inputID == '' || inputID.length < 4 || inputID.length > 12){
            alert("올바른 아이디를 입력해주세요.");
            return;
         }
         var url = baseContext +"/gsapi/sign-up/customerInfoWebIdCheck?" + getCSRFToken();
         var params = { "reqSubCoCode" : "7100", "webId" : $("#us_id").val() };
         $.ajax({
            crossOrigin : true,
              url: url,
              cache : false,
              type: "POST",
              data : JSON.stringify(params),
              dataType: "json",
              contentType : "application/json",
              success: function (response) {
                 if (response.resultCode == "00000" || response.resultCode == "R7000"){        		
                    alert("사용가능한 아이디 입니다.");
                    idOk = true;
                    $("#us_pw").focus();
                 // 중복
                 }else if (response.resultCode == "60003"){
                    alert("로그인 아이디 중복이 발생하였습니다.\n아이디를 다시 선택해 주시기 바랍니다.");
                    $("#us_id").val("");
                    $("#us_id").text("");
                    $("#us_id").focus();
                    idOk = false;
                 }
              },
              error: function(jqXHR, textStatus, errorThrown) {
              // alert(errorThrown + " (" +textStatus +")" );
                 alert("일시적인 장애가 발생하였습니다. 잠시후 다시 시도하여 주세요");
              }
         });		
      }
      
      function getPopupHtml(popupObj) {
         var term = ""; //그만보기 설정
         var popStyle = "";
         var popWrapStyle = "";
         var popHtml = "";
      
            
         try{
            if(popupObj.stopPopup.code == "ONE"){
               term = "하루동안 열지 않음";
            }else if(popupObj.stopPopup.code == "SEVEN"){
               term = "일주일간 열지 않음";
            }
         }catch(e){}
      
         //팝업 높이
         if(popupObj.popupPositionHeight != "" && popupObj.popupPositionHeight != null){
            popStyle = "style='height:"+popupObj.popupPositionHeight+"px'";
         }
         //팝업 넓이
         if(popupObj.popupPositionWidth != "" && popupObj.popupPositionWidth != null){
            if(popupObj.popupPositionHeight != "" && popupObj.popupPositionHeight != null){
               popStyle = "style='height:"+popupObj.popupPositionHeight+"px;width:"+popupObj.popupPositionWidth+"px'";
            }else{
               popStyle = "style='width:"+popupObj.popupPositionWidth+"px'";
            }
            popWrapStyle = "style='width:"+popupObj.popupPositionWidth+"px'";
         }
      
         try{
            popHtml += "<div class='' id='popManage" + popupObj.pk + "' term='"+popupObj.stopPopup.code+"' >";
         }catch(e){
            popHtml += "<div class='' id='popManage" + popupObj.pk + "' term='NONE' >";
         }
         
         popHtml += "	<div class='popwrap lypop_my2 pop-inner-layer admin_popup' id='gsCommonPopup" + popupObj.pk + "' "+popWrapStyle+">";
      // 	try{
      // 		popHtml += "		<div class='pop_tltwrap' term='"+popupObj.stopPopup.code+"'>";
      // 	}catch(e){
      // 		popHtml += "		<div class='pop_tltwrap' term='NONE'>";
      // 	}
      // 	popHtml += "			<h4 class='pop_tlt1'>"+popupObj.popupTitle+"</h4>";
      // 	popHtml += "		</div>";
         popHtml += "		<div "+popStyle+">";
         popHtml += "			<div class='all_wrap'>";
         popHtml += popupObj.popupTemplateText;
         popHtml += "			</div>";
         try{
            if(popupObj.stopPopup.code != "NONE" && popupObj.stopPopup.code != "NEVER"){
               popHtml += "		<div class='ie_close_box' style='bottom: 0px'>";
               popHtml += "			<input type='checkbox' id='popupTermCkecked" + popupObj.pk + "' class='pop_term' value='" + popupObj.pk + "' onclick='popupTermCkecked(" + popupObj.pk + ")'><label for='popupTermCkecked" + popupObj.pk + "'>"+term+"</label>";
               popHtml += "		</div>";
            }
         }catch(e){}
         popHtml += "		</div>";
         popHtml += "		<div class='pop_cls'>";
         popHtml += "			<a href='#'>닫기</a>";
         popHtml += "		</div>";
         popHtml += "	</div>";
         popHtml += "</div>";
         
         return popHtml;
      }
      
      
      $(function(){
         $(document).on("keyup", "input:text[numberOnly]", function() {
            $(this).val($(this).val().replace(/[^0-9]/g,''));
            $(this).blur(function(){
               $(this).val($(this).val().replace(/[^0-9]/g,''));
            });
         });
         
         /* 팝업 관리 
          * AUTH : CMB
          */
      
         var url = "/gscvs/ko/common/popup-list";
         var ajaxType="GET";
         var isExceptionUrl = false;	
         
         try
         {
            var checkUrl = location.href.toUpperCase().replace("HTTP://", "").replace("HTTPS://", "").replace("#", "");
            
            //회원가입 및 마이페이지 메인 화면에서 Layer 팝업이 호출되게 수정함, 팝카드 제외 
            //SSL =  POST, CSRFToken
             if ( checkUrl.indexOf("/POPCARD/KO/")==-1 && ( checkUrl.indexOf("/SIGN-UP/CERTIFICATION") > 0 || checkUrl.indexOf("/MY-PAGE") > 0 || checkUrl.indexOf("/CORPORATION/PARTNERSHIP/") > 0 || checkUrl.indexOf("/SIGN-UP/JOIN-MAIN") > 0 
                   || checkUrl.indexOf("/COMMUNITY-SERVICE/APPLY-TO-VOLUNTEER") > 0 ) )
             {
                 isExceptionUrl=true;
                 ajaxType="POST";
                 url=url+"?"+getCSRFToken();
             }
         }
         catch(e)
         {
              return null;
         }	   
         
         // SSL화면에서는 사용 안함
         if("http" == "http" || isExceptionUrl){
            $.ajax({
                 url: url,
                 cache : false,
                 type: ajaxType,
                 dataType: "json",
               contentType : "application/json",
                success: function (data) {
                   
                  try
                  {
                      var json = $.parseJSON(data);
                      
                      var thisUrl = window.location.href;
                      
                      if (thisUrl.includes("/main?")) {	//main으로 접속한 경우 main 이후의 파라미터 삭제
                         thisUrl = thisUrl.split("?")[0];
                      }
         
                      for(var i=0; i<json.results.length;i++){
                        //위치 상세설정 : 적용페이지 URL
                        //url 다중 처리 : BOS 처리가 안되서 임시로 # 으로 url 구분 하기로 함 //
                        var targetUrl = "";
                        
                        if(json.results[i].visibleSiteUrl!=null){
                           
                           var arrUrl = json.results[i].visibleSiteUrl.split("#"); 
                           for(var k =0; k<arrUrl.length; k++){ 
                              targetUrl = arrUrl[k].replace(/(\s*)/g,""); 
                              if(thisUrl == targetUrl){						
                                 if(json.results[i].exposure){
                                    var popHtml = "";
                                    popHtml = getPopupHtml(json.results[i]);
            
                                    $("body").prepend(popHtml);
                                    
                                    var cookiedata = document.cookie;
            
                                     if ( cookiedata.indexOf("gsCommonPopup"+json.results[i].pk+"_pop=done") < 0 ){
                                        Clayer_open('gsCommonPopup'+json.results[i].pk, json.results[i].pk, json.results[i].popupPosition.code);
                                       //팝업위치
                                       setPopupPosition(json.results[i]);
                                       MAIN_POPUP_COUNT++;
                                     }
                                 }
                              }
                           } 
                         }
                     }
                  }
                  catch(e)
                  {
                     return null;
                  }
                 },
                 error: function(jqXHR, textStatus, errorThrown) {
                      
                 }
            });
         }
            
      
         
         function Clayer_open(el, pk, position){
            var temp = $('#' + el);
            //var bg = temp.prev().hasClass('bg');	//dimmed 레이어를 감지하기 위한 boolean 변수
      
            $('#popManage' + pk).css("z-index", 9999);
            $('#popManage' + pk).css("position","fixed");
            $('#popManage' + pk).css("top","50%");
            $('#popManage' + pk).css("left","50%");
            $('#popManage' + pk).fadeIn();
            temp.fadeIn();
            var margin_top_calibration = 0;
         
            if(position == "TOPLEFT" || position == "TOPMIDDLE" || position == "TOPRIGHT"){
                margin_top_calibration = -70; 
            } else if ( position == "BOTTOMLEFT" || position == "BOTTOMMIDDLE" || position == "BOTTOMRIGHT") {
               margin_top_calibration = +30;
            }
            
            // 화면의 중앙에 레이어를 띄운다.
            if (temp.height() < $(document).height() ) temp.css('margin-top', '-'+(temp.height()/2+margin_top_calibration)+'px');
            else temp.css('top', '0px');
            if (temp.width() < $(document).width() ) temp.css('margin-left', '-'+temp.width()/2+'px');
            else temp.css('left', '0px');
            
            temp.find('.pop_cls').click(function(e){
                  $('#popManage' + pk).fadeOut();
               temp.fadeOut();
               e.preventDefault();
            });
         }
      });
      
      /**
       * 쿠키 생성
       * @param name 쿠키명
       * @param value 쿠키 값
       * @param expiredays 쿠키 기간
       */
      $.makeExpierCookie=function( name, value, expiredays ){
        var todayDate = new Date();
        todayDate.setDate( todayDate.getDate() + expiredays );
        document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";"
      }
      
      /**
       * 쿠키 삭제
       * @param cookieName 삭제할 쿠키명
       */
      $.deleteCookie = function( cookieName ){
        var expireDate = new Date();
        //어제 날짜를 쿠키 소멸 날짜로 설정한다.
        expireDate.setDate( expireDate.getDate() - 1 );
        document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString() + "; path=/";
      }
      
      /**
       * 쿠키값 추출
       * @param cookieName 쿠키명
       */
      $.getCookie = function( cookieName ){
         var search = cookieName + "=";
         var cookie = document.cookie;
         
         // 현재 쿠키가 존재할 경우
         if( cookie.length > 0 ){
            // 해당 쿠키명이 존재하는지 검색한 후 존재하면 위치를 리턴.
            startIndex = cookie.indexOf( cookieName );
            
            // 만약 존재한다면
            if( startIndex != -1 ){
               // 값을 얻어내기 위해 시작 인덱스 조절
               startIndex += cookieName.length;
               
               // 값을 얻어내기 위해 종료 인덱스 추출
               endIndex = cookie.indexOf( ";", startIndex );
               
               // 만약 종료 인덱스를 못찾게 되면 쿠키 전체길이로 설정
               if( endIndex == -1) endIndex = cookie.length;
               
               // 쿠키값을 추출하여 리턴
               return unescape( cookie.substring( startIndex + 1, endIndex ) );
            }else{
               // 쿠키 내에 해당 쿠키가 존재하지 않을 경우
               return false;
            }
         }else{
            // 쿠키 자체가 없을 경우
            return false;
         }
      }
      
      $.formValidation = function(formNm){
         var validYN = true;		//유효성 통과여부
         var labelText = "";		//label의 텍스트 가져오기
         var alertMsg = "";		//얼럿 메세지 세팅
      
         //텍스트 박스 일 경우
         $.each($("#" + formNm).find("input:text"), function(){
            labelText = $("label[for=" + $(this).attr("id") + "]").text();
      
            if(labelText.indexOf("*") > 0){
               labelText = labelText.replace("*","").replace(" ","");
            }
      
            if($(this).attr("validation")){
               if("" == labelText){
                  alertMsg = $("#" + $(this).attr("id")).attr("title") + "이(가) 입력이 되지 않았거나 잘못 입력되었습니다.";
               } else {
                  alertMsg = labelText + "이(가) 입력이 되지 않았거나 잘못 입력되었습니다.";
               }
      
               //Validation Check
               if("" == $("#" + $(this).attr("id")).val()){
                  $("#" + $(this).attr("id")).parent().append("<div class='alertToolTip' onClick='$.tooltipHide();'>" + alertMsg + "</div>");
                  validYN = false;
                  $("#" + $(this).attr("id")).focus();
                  return false;
               } else {
                  $(".alertToolTip").remove();
                  validYN = true;
               }
            }
         });
      
         //셀렉트 박스 일 경우
         $.each($("#" + formNm).find("select.valid"), function(){
            if(validYN){
               if("" == $("#" + $(this).attr("id")).val()){
                  alertMsg = $("#" + $(this).attr("id")).attr("title") + "을(를) 선택해주세요";
                  $("#" + $(this).attr("id")).parent().append("<div class='alertToolTip' onClick='$.tooltipHide();'>" + alertMsg + "</div>");
                  validYN = false;
                  return false;
               } else {
                  $(".alertToolTip").remove();
                  validYN = true;
               }
            }
         });
      
         return validYN;
      };
      
      //툴팁 삭제
      $.tooltipHide = function(){
         $(".alertToolTip").remove();
      };
      //]]>
      </script>

      <script type="text/javascript">
      //<![CDATA[

      //상품 검색 조회
      var GoodsPageController = function(index){
      this.getList = function(){		
      var tURL = "/gscvs/ko/products/event-goods-search";
      var tFormHTML = "";		
      tFormHTML += "<input type=\"hidden\" name=\"pageNum\" id=\"pageNum\" value=\"" + this._BOARD_INFO.pageNum + "\"/>";
      tFormHTML += "<input type=\"hidden\" name=\"pageSize\" id=\"pageSize\" value=\"" + this._BOARD_INFO.listCnt + "\"/>";
      tFormHTML += "<input type=\"hidden\" name=\"searchType\" id=\"searchType\" value=\"" + this._BOARD_INFO.searchType + "\"/>";
      tFormHTML += "<input type=\"hidden\" name=\"searchWord\" id=\"searchWord\" value=\"" + this._BOARD_INFO.searchWord + "\"/>";
      var parameterListValue = "ONE_TO_ONE";
      if($("#parameterList").length!=0){
         parameterListValue = $("#parameterList").val();
      }
      tFormHTML += "<input type=\"hidden\" name=\"parameterList\" id=\"parameterList\" value=\"" + parameterListValue + "\"/>";


      this.setFormInformation( tFormHTML );		
      this.getData( tURL, this.setResourceList, this ); 
      };
      this.setResourceList = function( result, tThis ){ /////// modify


      var tData = result;
      tThis._RESOURCE = tData.results;
      tThis._BOARD_INFO.totalCnt = tData.pagination.totalNumberOfResults;
      //tThis._BOARD_INFO.listCnt = tData.pagination.numberOfPages;

      tThis.setListHTML();
      };
      this.setListHTML = function(){
            
      var tInfo = this._BOARD_INFO;
      var tResource = this._RESOURCE;
      var tHTML = "";
      var beginIdx = this.getBeginIndex();

      var param = $("#parameterList").val();

      for( var i=0; i<tResource.length; i++ ){
      /* 			console.log(tResource[i])	 */
         var data = tResource[i];
         
         tHTML = tHTML.concat("<li>");
         tHTML = tHTML.concat("<div class='prod_box'>")
         tHTML = tHTML.concat("<p class='img'>")
         if(data.attFileNm.indexOf('null')==-1){
            tHTML = tHTML.concat("<img src='"+data.attFileNm +"' alt='"+data.goodsNm+"' />")	
         }
         tHTML = tHTML.concat("</p>")
         tHTML = tHTML.concat("<p class='tit'>")
         tHTML = tHTML.concat(data.goodsNm)
         tHTML = tHTML.concat("</p>")
         tHTML = tHTML.concat("<p class='price'>")
         tHTML = tHTML.concat("<span class='cost'>")
         tHTML = tHTML.concat(numberWithCommas(data.price))
         tHTML = tHTML.concat("<span>원</span></span>")
         tHTML = tHTML.concat("</p>")
         tHTML = tHTML.concat("<div class='flag_box "+data.eventTypeSp.code+"'>")
         tHTML = tHTML.concat("<p class='flg01'><span>1+1</span></p>")
         tHTML = tHTML.concat("</div>")
         
         if(data.eventTypeSp.code == "GIFT"){
            
            tHTML = tHTML.concat("<div class='dum_box'>")
            tHTML = tHTML.concat("<div class='arr_lt'></div>")
            tHTML = tHTML.concat("<div class='dum_prd'>")
            tHTML = tHTML.concat("<p class='tit'>덤증정 상품</p>")
            if(data.giftAttFileNm != undefined){
               tHTML = tHTML.concat("<p class='img'><img src='"+data.giftAttFileNm+"' alt='"+data.giftGoodsNm+"' /></p>")
            }
            tHTML = tHTML.concat("</div>")
            tHTML = tHTML.concat("<div class='dum_txt'>")
            tHTML = tHTML.concat("<p class='name'>")
            if(data.giftGoodsNm != undefined){
               tHTML = tHTML.concat("<br/>")
               tHTML = tHTML.concat(data.giftGoodsNm)
            }
            tHTML = tHTML.concat("</p>")
            tHTML = tHTML.concat("<p class='price'>")
            if(data.giftPrice != undefined){
               tHTML = tHTML.concat("<span class='cost'>")
               tHTML = tHTML.concat(numberWithCommas(data.giftPrice))
               tHTML = tHTML.concat("<span>원</span></span>")
            }
            tHTML = tHTML.concat("</p>")
            tHTML = tHTML.concat("</div>")
            tHTML = tHTML.concat("</div>")
            tHTML = tHTML.concat("</div>")
            tHTML = tHTML.concat("</li>")
            
            
         }
         
         /*
         덤증정상품일 경우 : if : data.eventTypeSp == GIFT 일 경우에 마우스가 오버랩될 경우, 아래 3가지를 화면에 보인다.	    	
            상품이미지 : data.giftAttFileNm 
            상품명 : data.giftGoodsNm 
            상품가격 : data.giftPrice 
         */
         
         $(".tblwrap .prod_list").append(tHTML);

         var data_code = data.eventTypeSp.code;
         
      } 

      

      if(tHTML==""){
         tHTML += "<li><p> 검색된 상품이 없습니다. </p></li>"
      }

      $( tInfo.container + " ul" ).html( tHTML );
      this.setPagingHTML();
      $(".dum_box").hide();

      $("div.prod_box").each(function(){
         var $dum = $(this).find('.dum_box');
         
         if($dum.length!=0){
            
            $(this).mouseover(function(){
               $dum.show()
            });
            
            $(this).mouseout(function(){1
               $dum.hide()
            })
         }
         
         /* if($dum!=null){
            console.log(this)	
         } */
         
      })
      /* $(".tblwrap .prod_list li .prod_box") */

      //배너 아이콘
      $(".ONE_TO_ONE span").text("1+1");		

      $(".TWO_TO_ONE span").text("2+1");	
      $(".TWO_TO_ONE .flg01").css("background",'url("/_ui/desktop/common/images/gscvs/products/flag_bg.png") -65px 0px no-repeat');

      $(".GIFT span").text("덤증정");
      $(".GIFT span").css("font-size","small");
      $(".GIFT .flg01").css("background",'url("/_ui/desktop/common/images/gscvs/products/flag_bg.png")0 -55px no-repeat');
            
      var pordlist = $('.prod_list > li').length;
      $('.prod_list > li').each(function(pordlist){
         if((pordlist%4) == 0){
            $('.prod_list > li:nth-child('+(pordlist+4)+')').addClass('mr0');
         }
      });

      };	
      }

      GoodsPageController.prototype = new boardManagerController();
      var goodsPageController = new GoodsPageController();

      var eventTabController = new tabClickController();  //  임의 변수에 생성자 할당	

      //]]>
      </script>

<script type="text/javascript">
//<![CDATA[


$(document).ready(function(){
   var gscvsGNB = new GNBController;
   gscvsGNB.init( ".gnbw .gnb", ".gnb ul li h2 a", ".gnb ul.mlb_action", ".gnb_bg");
});

//]]>
</script>

   <script type="text/javascript">
   var _TRK_LID="22400";var _L_TD="ssl.logger.co.kr";var _TRK_CDMN="";</script>

<script type="text/javascript">var _CDN_DOMAIN = location.protocol == "https:" ? "https://fs.bizspring.net" : "http://fs.bizspring.net";
		(function(b,s){var f=b.getElementsByTagName(s)[0],j=b.createElement(s);j.async=true;j.src='//fs.bizspring.net/fs4/bstrk.1m.js';f.parentNode.insertBefore(j,f);})(document,'script');</script>

<script type="text/javascript">
//<![CDATA[

$(document).ready(function(){
   var otherFamilySite = new footerFamilySiteManager();
   otherFamilySite.setResource( ".ret_link .family", ".ULWrap1st" );
   otherFamilySite.setResource( ".ret_link .brand", ".ULWrap2nd" );
   otherFamilySite.init();
});

//]]>
</script>

