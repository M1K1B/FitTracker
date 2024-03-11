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
		<form:form class="row g-3 col-4 mx-auto" method="post" action="/FitTracker/sacuvajNalog"
			modelAttribute="korisnikDTO">
			<div class="col-6">
				<label for="inputAddress" class="form-label">Ime</label>
				<form:input type="text" class="form-control" id="inputAddress"
					path="ime" />
			</div>
			<div class="col-6">
				<label for="inputState" class="form-label">Prezime</label>
				<form:input type="text" class="form-control" id="inputAddress"
					path="prezime" />
			</div>
			<div class="col-12">
				<label for="inputState" class="form-label">Email</label>
				<form:input type="text" class="form-control" id="inputAddress"
					path="email" />
			</div>
			<div class="col-12">
				<label for="inputState" class="form-label">Lozinka</label>
				<form:input type="password" class="form-control" id="inputAddress"
					path="lozinka" />
			</div>
			<div class="col-6">
				<label for="inputState" class="form-label">Visina</label>
				<form:input type="number" class="form-control" id="inputAddress"
					path="visina" />
			</div>
			<div class="col-6">
				<label for="inputState" class="form-label">Težina</label>
				<form:input type="text" class="form-control" id="inputAddress"
					path="tezina" />
			</div>
			<div class="col-12">
				<label for="inputState" class="form-label">Datum rodjenja</label>
				<form:input type="date" class="form-control" id="inputAddress"
					path="datumRodjenja" />
			</div>
			
			<div class="col-12">
				<a href="/FitTracker/login">Prijavi se</a>
				<button type="submit" class="btn btn-primary">Napravi nalog</button>
			</div>
		</form:form>
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
