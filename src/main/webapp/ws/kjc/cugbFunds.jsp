<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no">
    <title>科技处</title>
    <link rel="stylesheet" href="/kjcManager/ws/cugb/css/swiper.min.css">
    <link rel="stylesheet" href="/kjcManager/ws/cugb/css/idangerous.swiper.css">
    <link rel="stylesheet" type="text/css" href="/kjcManager/ws/cugb/css/hometop.css">
    <link rel="stylesheet" type="text/css" href="/kjcManager/ws/cugb/css/indexmb1.css">
    <link rel="stylesheet" type="text/css" href="/kjcManager/ws/cugb/css/list.css">
    <!-- 引入样式 -->
    <link rel="stylesheet" type="text/css" href="/kjcManager/ws/cugb/lib-master/theme-chalk/index.css" />
    <script src="/kjcManager/ws/cugb/js/jquery-3.1.0.min.js"></script>
    <script src="/kjcManager/ws/cugb/js/idangerous.swiper.min.js"></script>
    <script src="/kjcManager/ws/cugb/js/scrollReveal.js" async></script>
    <script src="/kjcManager/ws/cugb/js/anime.min.js" async></script>
    <script src="/kjcManager/ws/cugb/js/paging.js"></script>
    <!-- 引入amchart核心文件 -->
    <script src="/kjcManager/ws/cugb/js/core.js"></script>
    <script src="/kjcManager/ws/cugb/js/charts.js"></script>
    <script src="/kjcManager/ws/cugb/js/themes/animated.js"></script>
    <script src="/kjcManager/ws/cugb/js/themes/material.js"></script>
    <script src="/kjcManager/ws/cugb/js/themes/dataviz.js"></script>
    <script src="/kjcManager/ws/cugb/js/themes/amchartsdark.js"></script>
    <script src="/kjcManager/ws/cugb/js/themes/dark.js"></script>
    <script src="/kjcManager/ws/cugb/js/themes/frozen.js"></script>
    <script src="/kjcManager/ws/cugb/js/themes/kelly.js"></script>
    <script src="/kjcManager/ws/cugb/js/themes/moonrisekingdom.js"></script>
    <script src="/kjcManager/ws/cugb/js/themes/patterns.js"></script>
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
            document.write('<link rel="stylesheet" type="text/css" href="/kjcManager/ws/cugb/css/mobile.css">');
            document.write('<link rel="stylesheet" type="text/css" href="/kjcManager/ws/cugb/css/mobilelist.css">');
            loadJS('/kjcManager/ws/cugb/js/mobilepclist.js');
        } else {
            $('html').css('font-size', '');
            document.write('<link rel="stylesheet" type="text/css" href="/kjcManager/ws/cugb/css/pcmedia.css">');
            if (IEVersion()) {
                // document.write('<link rel="stylesheet" type="text/css" href="/kjc/css/pcIe.css">');
                loadJS('/kjcManager/ws/cugb/js/pclist.js');
            } else {
                loadJS('/kjcManager/ws/cugb/js/pclist.js');
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
            	<div id="app">
                    <div class="btn-wrap" style="text-align: center;margin-top: 10px;">
                        <el-button @click="showCase1" type="primary" size="mini">总体情况</el-button>
                        <el-button @click="showCase2" type="primary" size="mini">院系对比</el-button>
                        <el-button @click="showCase3" type="primary" size="mini">“973”项目</el-button>
                    </div>
                </div>
            </div>
            <div class="detail_content_box">
                <!--  BEGIN MAIN CONTAINER  -->
			    <div class="main-container" id="container">
			        <!--  BEGIN CONTENT PART  -->
			        <div id="content" class="main-content">
			            <div class="layout-px-spacing">
			                <div class="row layout-top-spacing" id="cancel-row">
								<div class="col-xl-12 col-lg-12 col-sm-12  layout-spacing">
									 <div class="widget widget-one_hybrid widget-engagement" style="float:center;width:1000px;height:720px;">
					                       	<div id="chartdiv" style="width: 72%; height: 720px; margin: 20px auto;">
					                       		<input type="hidden" id="ws_a_cugb_k" value="${ws_a_cugb_k}">
					                       		<input type="hidden" id="ws_a_cugb_NDZ_v" value="${ws_a_cugb_NDZ_v}">
			                            		<input type="hidden" id="ws_a_cugb_NDZ_project" value="年份">
			                            		<input type="hidden" id="ws_a_cugb_NDZ_unit" value="${ws_a_cugb_NDZ_project}${ws_a_cugb_NDZ_unit}">
			                            	</div>
				                     </div>
				                     <div class="widget widget-one_hybrid widget-engagement" style="float:center;width:1000px;height:720px;">
					                       	<div id="chartdiv_A" style="width: 72%; height: 720px; margin: 20px auto;">
					                       		<input type="hidden" id="ws_a_cugb_ZRK_v" value="${ws_a_cugb_ZRK_v}">
			                            		<input type="hidden" id="ws_a_cugb_ZRK_project" value="年份">
			                            		<input type="hidden" id="ws_a_cugb_ZRK_unit" value="${ws_a_cugb_ZRK_project}${ws_a_cugb_ZRK_unit}">
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
        <div class="home_bottom" style="margin-top:-60px;">
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
    <script src="/kjcManager/ws/assets/js/libs/jquery-3.1.1.min.js"></script>
	<!-- Resources -->
	<script src="/kjcManager/ws/cugb/js/core.js"></script>
	<script src="/kjcManager/ws/cugb/js/charts.js"></script>
	<script src="/kjcManager/ws/cugb/js/animated.js"></script>
	<!-- Chart code -->
    <script src="/kjcManager/ws/cugb/js/amcharts-cugbFunds.js"></script>
</body>
<script src="/kjcManager/ws/cugb/js/echarts.js"></script>
<!-- import Vue before Element -->
<script src="/kjcManager/ws/cugb/js/vue.js"></script>
<!-- import JavaScript -->
<script src="/kjcManager/ws/cugb/lib-master/index.js" type="text/javascript" charset="utf-8"></script>
<script>
    new Vue({
        el: '#app',
        data: function () {
            return { visible: false }
        },
        methods: {
            // 总体情况
            showCase1() {
                window.location.href = '/kjcManager/cugbFunds.do';
            },
            // 院系对比
            showCase2() {
                window.location.href = '/kjcManager/kyxm/yxdb.do';
            },
            // ‘973’项目
            showCase3() {
                window.location.href = '/kjcManager/kyxm/nstProject.do';
            },
        }
    });
</script>
</html>