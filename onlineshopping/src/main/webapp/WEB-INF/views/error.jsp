<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">


<script>
	window.menu = '${title}';
	window.contextRoot='${contextRoot}'
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap readable theme -->

<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">
<title>Online Shopping - ${title}</title>
</head>

<body>
	<div class="wrapper">

		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${contextRoot}/home">Home</a>
		</div>
		
		</div>
		
		
		</nav>

		<div class="content">
			<div class="container">
				<div class="row">
				
					<div class="col-xs-12">
						<div class="jombotron">
						<h1>${errorTitle}</h1>
						<hr/>
						<blockquote style="word-wrap:break-word">
							${errorDescription}
						</blockquote>
						</div>
					</div>
				</div>
			</div>
			<!-- /.container -->
		</div>

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		
	</div>
 
</body>

</html>
