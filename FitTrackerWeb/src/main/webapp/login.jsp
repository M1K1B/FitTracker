<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS - Include the CSS file or use a CDN link -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">

</head>
<body>
	<%@include file="header.jsp"%>

	<div class="container mt-5">
		<form class="row g-3 col-4 mx-auto" method="post" action="<c:url value='/login' />">
			<div class="col-12">
				<label for="inputAddress" class="form-label">Email</label>
				<input type="text" class="form-control" id="inputAddress"
					name="username" />
			</div>
			<div class="col-12">
				<label for="inputAddress" class="form-label">Lozinka</label>
				<input type="password" class="form-control" id="inputAddress"
					name="password" />
			</div>
			<div class="col-12">
				<a href="/FitTracker/register" >Napravi novi pofil</a>
				<button type="submit" class="btn btn-primary">Prijava</button>
			</div>
		</form>
		<c:if test="${not empty message}">
			<div class="alert alert-primary mt-4 col-8 mx-auto" role="alert">${message}</div>
		</c:if>
	</div>
	

	<!-- Your Content Goes Here -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>
 