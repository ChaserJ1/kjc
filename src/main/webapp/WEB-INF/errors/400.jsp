<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
	<%pageContext.setAttribute("PATH", request.getContextPath());%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>400</title>
 	<link rel="stylesheet" href="${PATH}/ws/cugb/jquery404/css/404.css" />
	<script type="text/javascript" src="${PATH}/ws/cugb/js/jquery-3.6.0.min.js" ></script>
</head>
<body>
		<div class="code">
			<p>ERROR 400</p>
		</div>
		<div class="road">
			<div class="shadow">
				<div class="shelt">
					<div class="head">
						<div class="eyes">
							<div class="lefteye">
								<div class="eyeball"></div>
								<div class="eyebrow"></div>
							</div>
							<div class="righteye">
								<div class="eyeball"></div>
								<div class="eyebrow"></div>
							</div>
						</div>
					</div>
				</div>
				<div class="hat"></div>
				<div class="bubble">
					<a href="javascript:history.go(-1)">Go back Page?</a>
				</div>
			</div>
			<p>PAGE NOT FOUND</p>
		</div>
		<script type="text/javascript" src="${PATH}/ws/cugb/jquery404/js/404.js" ></script>
	</body>
</html>