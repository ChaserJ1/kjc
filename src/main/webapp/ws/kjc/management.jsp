<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no">
    <title><%=request.getAttribute("title")%></title>
    <link rel="icon" type="image/x-icon" href="/webscience/ws/assets/img/favicon.ico"/>
    <link href="/webscience/ws/assets/css/loader.css" rel="stylesheet" type="text/css" />
    <script src="/webscience/ws/assets/js/loader.js"></script>

    <!-- BEGIN GLOBAL MANDATORY STYLES -->
    <link href="https://fonts.googleapis.com/css?family=Quicksand:400,500,600,700&display=swap" rel="stylesheet">
    <link href="/webscience/ws/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="/webscience/ws/assets/css/main.css" rel="stylesheet" type="text/css" />
    <link href="/webscience/ws/plugins/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" type="text/css" />
    <link href="/webscience/ws/assets/css/structure.css" rel="stylesheet" type="text/css" />
    <link href="/webscience/ws/plugins/highlight/styles/monokai-sublime.css" rel="stylesheet" type="text/css" />
    <!-- END GLOBAL MANDATORY STYLES -->

    <!-- BEGIN PAGE LEVEL PLUGINS/CUSTOM STYLES -->
    <link href="/webscience/ws/assets/css/scrollspyNav.css" rel="stylesheet" type="text/css" />
    <link href="/webscience/ws/plugins/apex/apexcharts.css" rel="stylesheet" type="text/css">
    <link href="/webscience/ws/assets/css/dashboard/dash_2.css" rel="stylesheet" type="text/css" />
    <link href="/webscience/ws/assets/css/components/custom-modal.css" rel="stylesheet" type="text/css" />
    <!-- END PAGE LEVEL PLUGINS/CUSTOM STYLES -->
	<link rel="stylesheet" type="text/css" href="/webscience/ws/assets/css/button.css" />
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Ma+Shan+Zheng&display=swap" rel="stylesheet">
	<style>
		.panel-head{
			font-size: 1rem; color: rgba(255,255,255,.7); line-height: 2rem; text-align: center;
			background: linear-gradient(rgb(0,20,30), rgb(0,40,70));
			border: 2px solid rgba(0,90,120,.3);
		}	
		.dropdown-toggle{white-space: normal;}
        .topbar-nav.header nav#topbar ul.menu-categories li.menu {padding: 2px 0 2px 0;}
		#warningcol {
		    border: 1px solid #ccc;
		    border-collapse: collapse;
		    border-spacing: 0;
		    font-size: 12px;
		}

	</style>
</head>
<body class="alt-menu sidebar-noneoverflow" style="overflow:auto">
	
    <!-- BEGIN LOADER -->
    <div id="load_screen"> <div class="loader"> <div class="loader-content">
        <div class="spinner-grow align-self-center"></div>
    </div></div></div>
    <!--  END LOADER -->	


    <!--  BEGIN MAIN CONTAINER  -->
    <div class="main-container" id="container">

        <div class="overlay"></div>
        <div class="search-overlay"></div>

        <!--  BEGIN TOPBAR  -->
        <div class="header-page"></div>
        <!--  END TOPBAR  -->
        
        <!--  BEGIN CONTENT PART  -->
        <div id="content" class="main-content">
            <div class="layout-px-spacing">           
                <div class="row layout-top-spacing" id="cancel-row">
                    <div class="col-xl-12 col-lg-12 col-sm-12  layout-spacing">
                        <div class="widget-content widget-content-area br-6" style="background: rgba(14,23,38,0.7);">
                            <div class="table-responsive mb-4 mt-4">
								<div style="font-size:22px;text-align:center">
									<c:forEach items="${filesList}" var="list">
										<a target="_blank" href="${list.path}">${list.type}-${list.name}-${list.addTime}</a><br>
									</c:forEach>
								</div>
							</div>
    					 </div>
                    </div>
                </div>
            </div>
		</div>
        <!--  END CONTENT PART  -->
    </div>
    <!-- END MAIN CONTAINER -->
	
    <!-- BEGIN GLOBAL MANDATORY SCRIPTS -->
    <script src="/webscience/ws/assets/js/libs/jquery-3.1.1.min.js"></script>
    <script src="/webscience/ws/bootstrap/js/popper.min.js"></script>
    <script src="/webscience/ws/bootstrap/js/bootstrap.min.js"></script>
    <script src="/webscience/ws/plugins/perfect-scrollbar/perfect-scrollbar.min.js"></script>
    <script src="/webscience/ws/assets/js/app.js"></script>        
    <script src="/webscience/ws/assets/js/custom.js"></script>
    <!-- END GLOBAL MANDATORY SCRIPTS -->
</body>
</html>