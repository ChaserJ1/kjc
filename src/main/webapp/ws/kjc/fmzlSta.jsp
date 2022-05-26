<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no">
    <title>科技处</title>
    <link rel="stylesheet" href="/webscience/ws/cugb/css/swiper.min.css">
    <link rel="stylesheet" href="/webscience/ws/cugb/css/idangerous.swiper.css">
    <link rel="stylesheet" type="text/css" href="/webscience/ws/cugb/css/hometop.css">
    <link rel="stylesheet" type="text/css" href="/webscience/ws/cugb/css/indexmb1.css">
    <link rel="stylesheet" type="text/css" href="/webscience/ws/cugb/css/list.css">
    <!-- Styles -->
	<style>
		#chartdiv {
		  width: 100%;
		  height: 500px;
		}
	</style>
    <script src="/webscience/ws/cugb/js/jquery-1.12.4.min.js"></script>
    <script src="/webscience/ws/cugb/js/idangerous.swiper.min.js"></script>
    <script src="/webscience/ws/cugb/js/scrollReveal.js" async></script>
    <script src="/webscience/ws/cugb/js/anime.min.js" async></script>
    <script src="/webscience/ws/cugb/js/paging.js"></script>
    <script>
        function loadJS(url, callback) {
            var script = document.createElement('script');
            var fn = callback || function () { };
            script.type = 'text/javascript';

            if (script.readyState) { //IE
                script.onreadystatechange = function () {
                    if (script.readyState == 'loaded' || script.readyState == 'complete') {
                        script.onreadystatechange = null;
                        fn();
                    }
                };

            } else { //其他浏览器
                script.onload = function () {
                    fn();
                };
            }

            script.src = url;
            document.getElementsByTagName('head')[0].appendChild(script);
        }
        function deviceProbing() {
            var reg = /([a-zA-Z]+)?([a-zA-Z]+.*\;\s([a-zA-Z0-9]+)?)/
            var newNav = navigator.appVersion.match(reg);
            if (newNav) {
                var nav = newNav[0];
                var navArr = nav.split(/(\s)|((\s\d\.\d)?\;)/);
                var flag = false;
                for (var i = 0, len = navArr.length; i < len; i++) {
                    if (navArr[i] == 'Android' || navArr[i] == 'iPhone' || navArr[i] == 'iPad' || navArr[i] == 'MeeGo' || navArr[i] == 'NokiaN9' || navArr[i] == 'NOKIA') {
                        flag = true;
                        break;
                    } else {
                        flag = false;
                    }
                }
                return flag;
            }
        }
        function getFontSize() {
            var deviceWidth = document.documentElement.clientWidth;
            document.documentElement.style.fontSize = deviceWidth / 7.5 + 'px';
            window.onresize = function () {
                var deviceWidth = document.documentElement.clientWidth;
                document.documentElement.style.fontSize = deviceWidth / 7.5 + 'px';
            };
        }
        function IEVersion() {
            //取得浏览器的userAgent字符串
            var userAgent = navigator.userAgent;
            //判断是否IE浏览器
            var isIE = userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1;
            if (isIE) {
                var reIE = new RegExp("MSIE (\\d+\\.\\d+);");
                reIE.test(userAgent);
                var fIEVersion = parseFloat(RegExp["$1"]);
                if (fIEVersion < 10) {
                    return true;
                }
            } else {
                return false;
            }
        }
        var page_border_height = '3px';
        if (deviceProbing()) {
            page_border_height = '0.03rem';
            getFontSize();
            document.write('<link rel="stylesheet" type="text/css" href="/webscience/ws/cugb/css/mobile.css">');
            document.write('<link rel="stylesheet" type="text/css" href="/webscience/ws/cugb/css/mobilelist.css">');
            loadJS('./js/mobilepclist.js');
        } else {
            $('html').css('font-size', '');
            document.write('<link rel="stylesheet" type="text/css" href="/webscience/ws/cugb/css/pcmedia.css">');
            if (IEVersion()) {
                // document.write('<link rel="stylesheet" type="text/css" href="/kjc/css/pcIe.css">');
                loadJS('/webscience/ws/cugb/js/pclist.js');
            } else {
                loadJS('/webscience/ws/cugb/js/pclist.js');
            }
        }
    </script>
</head>
<body>
	 <!-- header logo -->
    <div class="home_headerbox">
        <div class="home_nav" id='homehead'>
            <a href="https://cms.cugb.edu.cn/kjc/">
                <div class="hn_logo"><img src='https://bm.cugb.edu.cn/kjc/images/kjc.png' /></div>
            </a>
        </div>
    </div>
    
    <div class="home_pagemainbox">
        <!-- 轮播背景图区域 -->
        <div class="home_banner home_listbanner">
            <div class="container" style="height:355px;">
                <div class="timeline">
                    <div class="swiper-container">
                        <div class="swiper-wrapper">
                            <div class="swiper-slide"
                                style="background: url('https://bm.cugb.edu.cn/kjc/images/01.png') no-repeat top center/100% auto;">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="list_banner_botbox">
                <div class="list_title">${type}</div>
            </div>
        </div>
        <!-- 内容详情区 -->
        <div class="detail_box" id='list_detail_box' style="padding-top:120px">
            <div class="detail_title_box">
                <div class="detail_title">${title}</div>
                <!-- pc端 -->
                <div class="detail_info"><label>发布时间：${addTime}</label></div>
                <!-- 移动端-->
                <div class="m_detail_info"><label>发布时间：${addTime}</label></div>
            </div>
            <div class="detail_content_box">
                <!--  BEGIN MAIN CONTAINER  -->
			    <div class="main-container" id="container">
			        <!--  BEGIN CONTENT PART  -->
			        <div id="content" class="main-content">
			            <div class="layout-px-spacing">
			                <div class="row layout-top-spacing" id="cancel-row">
								<div class="col-xl-12 col-lg-12 col-sm-12  layout-spacing">                     		
									 <div class="widget widget-one_hybrid widget-engagement" style="float:center;width:1000px;height:450px;">
					                       	<div id="chartdiv" style="width: 82%; height: 450px; margin: 20px auto;">
					                       		<input type="hidden" id="ws_a_cugb_k" value="${ws_a_cugb_k}">
					                       		<input type="hidden" id="ws_a_cugb_ZLS_v" value="${ws_a_cugb_ZLS_v}">
			                            		<input type="hidden" id="ws_a_cugb_ZLS_project" value="${ws_a_cugb_ZLS_project}">
			                            		<input type="hidden" id="ws_a_cugb_ZLS_unit" value="${ws_a_cugb_ZLS_unit}">
			                            	</div>
				                     </div>
				                     <div class="widget widget-one_hybrid widget-engagement" style="float:center;width:1000px;height:450px;">
					                       	<div id="chartdiv_A" style="width: 82%; height: 450px; margin: 20px auto;">
					                       		<input type="hidden" id="ws_a_cugb_FMZ_v" value="${ws_a_cugb_FMZ_v}">
			                            		<input type="hidden" id="ws_a_cugb_FMZ_project" value="${ws_a_cugb_FMZ_project}">
			                            		<input type="hidden" id="ws_a_cugb_FMZ_unit" value="${ws_a_cugb_FMZ_unit}">
					                       	</div>
				                     </div>
			                 	</div>
			           	 	</div>
			        	</div>
			    	</div>
			        <!--  END CONTENT PART  -->
			    </div>
			    <!-- END MAIN CONTAINER -->
            </div>
        </div>

        <!-- 底部 PC -->
        <div class="home_bottom" style="margin-top:-40px;">
            <div class="home_bot_box">
                <div class="home_bot_link home_bot_banquan">
                    <div class="home_bot_linktitle">版权信息</div>
                    <ul class="home_bot_banquanbox">
                        <li>版权所有:中国地质大学(北京)</li>
                        <li>地址:北京市海淀区学院路29号</li>
                        <li>邮编:100083</li>
                        <li>文保网安备案:1101080023</li>
                        <li>技术支持:信息网络中心</li>
                    </ul>
                </div>

                <div class="home_bot_link home_bot_gongzhong">
                    <div class="home_bot_gongzhong_text">
                        <div class="home_bot_linktitle">公众号 </div>
                        <ul class="home_bot_linkbox">
                            <li>扫码关注公众号</li>
                            <li>浏览最新文章信息</li>
                        </ul>
                    </div>
                    <div class="home_bot_gongzhong_img">

                        <img src="https://bm.cugb.edu.cn/kjc/upload/resources/image/2021/06/17/130830.png" />

                    </div>
                </div>

                <div class="home_bot_link m_home_bot_banquanlianxi">
                    <div class="home_bot_linktitle">联系我们</div>
                    <ul class="home_bot_banquanbox">
                        <li>地址:北京市海淀区学院路29号</li>
                        <li>邮编:100083</li>
                        <li>技术支持:信息网络中心</li>
                    </ul>
                    <div class="home_bot_gongzhong_img">

                        <img src="https://bm.cugb.edu.cn/kjc/upload/resources/image/2021/06/17/130830.png" />

                    </div>
                </div>
                <div class="home_bot_link m_home_bot_banquanotherbox">
                    <ul class="m_home_bot_banquanother">
                        <li>© 版权所有:中国地质大学(北京)</li>
                        <li>文保网安备案:1101080023</li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- 底部结束 -->
    </div>
	<!-- BEGIN GLOBAL MANDATORY SCRIPTS -->
    <script src="/webscience/ws/assets/js/libs/jquery-3.1.1.min.js"></script>
	<!-- Resources -->
	<script src="/webscience/ws/plugins/amcharts/core.js"></script>
	<script src="/webscience/ws/plugins/amcharts/charts.js"></script>
	<script src="/webscience/ws/plugins/amcharts/animated.js"></script>
	<!-- Chart code -->
    <script src="/webscience/ws/plugins/amcharts/amcharts-fmzlSta.js"></script>
</body>
</html>