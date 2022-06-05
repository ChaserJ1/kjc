<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
        content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>十佳论文</title>
    <%pageContext.setAttribute("PATH", request.getContextPath());%>
    <link rel="stylesheet" href="/kjcManager/ws/cugb/css/swiper.min.css">
    <link rel="stylesheet" href="/kjcManager/ws/cugb/css/idangerous.swiper.css">
    <link rel="stylesheet" type="text/css" href="/kjcManager/ws/cugb/css/hometop.css">
    <link rel="stylesheet" type="text/css" href="/kjcManager/ws/cugb/css/indexmb1.css">
    <link rel="stylesheet" type="text/css" href="/kjcManager/ws/cugb/css/list.css">
    <!-- 引入样式 -->
    <link rel="stylesheet" type="text/css" href="/kjcManager/ws/cugb/lib-master/theme-chalk/index.css" />
    <script src="/kjcManager/ws/cugb/js/jquery-1.12.4.min.js"></script>
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
            <div class="container">
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
                <div class="list_title">学术论文</div>
                <div class="list_back"><a href="javascript:void(0)" onclick="history.go(-1);">
                        <img src="https://bm.cugb.edu.cn/kjc/images/list/jiantou_icon.png" />
                        <label>返回</label>
                    </a>
                </div>
            </div>
        </div>
        <!-- 内容详情区 -->
        <div id="app">
            <div class="detail_box" id='list_detail_box'>

                <div class="detail_title_box">
                    <div style="text-align: center;padding-top: 10px;">
                        <a href="${PATH}/xslw/sjlw.do">[全部]</a>
                        <a @click="changeYear(item.id)" style="margin-right: 2px;" v-for="(item) in yearArr"
                            :key="item.id" href="javascript:;">[{{item.year}}]
                        </a>
                    </div>
                    <div class="detail_title" v-if="year=='' || year==0" style="padding-top: 20px;">·中国地质大学（北京）
                        {{valueBegin}}~{{valueEnd}} 年度十佳论文</div>
                    <div class="detail_title" v-else style="padding-top: 20px;">·中国地质大学（北京） {{year}} 年度十佳论文</div>
                    <div class="m_detail_info">
                        <div>
                            <label>[信息网络中心]魏玮</label>
                            <label>06月17日</label>
                        </div>
                        <div>
                        </div>
                    </div>
                    <div class="btn-wrap" style="text-align: center;margin-top: 10px;">
                        <el-button @click="showCase1" type="primary" size="mini">总体情况</el-button>
                        <el-button @click="showCase2" type="primary" size="mini">院系对比</el-button>
                        <el-button @click="showCase3" type="primary" size="mini">十佳论文</el-button>
                    </div>
                </div>
                <!-- 内容详情区 -->
                <div class="detail_content_box" style="padding-left:0;padding-top:0;padding-bottom:0">
                    <div class="detail_content_box" style="padding-left:0;padding-top:0;padding-bottom:0">
                        <table id="demo" lay-filter="test" style="padding-left:0;padding-top:0;padding-bottom:0"></table>
                    </div>
                </div>

            </div>
        </div>

        <!-- 底部 PC -->
        <div class="home_bottom">
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
<style>
    .charts {
        height: 30px;
        width: 30%;
        background: #dd562e;
    }
</style>
<script src="${PATH}/ws/cugb/js/echarts.js"></script>
<script src="${PATH}/ws/cugb/lib-master/index.js" type="text/javascript" charset="utf-8"></script>
    <script src="${PATH}/ws/assets/js/libs/jquery-3.1.1.min.js"></script>
    <script src="${PATH}/ws/cugb/layui/layui.js"></script>
    <script>
        layui.use('table', function () {
            var table = layui.table;
            table.render({
                elem: '#demo'
                , height: 620
                , width: 1200
                // , url: '/demo/table/user/' //数据接口
                , page: true //开启分页
                // , cellMinWidth: 80
                , limit: 10
                , skin: 'line' //行边框风格
                , even: true //开启隔行背景
                , size: 'lg' //小尺寸的表格
                , cols: [[ //表头
                    { field: 'id', title: '序号', width: 70, align: 'center', style: 'font-size:medium' }
                    , { field: 'corresAuthor', title: '通讯作者', width: 360, align: 'left', style: 'font-size:medium' }
                    , { field: 'firstAuthor', title: '第一作者', width: 90, align: 'left', style: 'font-size:medium' }
                    , { field: 'paperTitle', title: '论文标题', width: 90, align: 'left', style: 'font-size:medium' }
                    , { field: 'paperYear', title: '发表年份', width: 250, align: 'left', style: 'font-size:medium' }
                ]]
                , data: ${awardJson}
                , done: function (res, curr, count) {
                    $('th').css({ 'font-weight': 'bold', 'color': '#000','font-size': 'medium'});
                }
            });
        });
    </script>
</body>
</html>