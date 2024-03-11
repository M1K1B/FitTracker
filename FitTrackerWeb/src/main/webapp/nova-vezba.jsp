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
		<form:form class="row g-3 col-8 mx-auto" method="post"
			enctype="multipart/form-data" action="/FitTracker/vezbe/sacuvajVezbu"
			modelAttribute="vezbaDTO">
			<div class="col-6">
				<label for="inputAddress" class="form-label">Naziv vežbe</label>
				<form:input type="text" class="form-control" id="inputAddress"
					path="naziv" />
			</div>
			<div class="col-6">
				<label for="inputState" class="form-label">Pogadja mišić</label>
				<form:select id="inputState" class="form-select" path="misicId">
					<option value="-1">Mišić</option>
					<c:forEach items="${ misici }" var="k">
						<option value="${k.idMisica}">${k.naziv}</option>
					</c:forEach>
				</form:select>
			</div>
			<div class="col-12">
				<label for="formFile" class="form-label">Slika vežbe</label>
				<form:input class="form-control" type="file" id="formFile"
					path="slika" />
			</div>
			<div class="col-12">
				<label for="exampleFormControlTextarea1" class="form-label">Opis
					vežbe</label>
				<form:textarea class="form-control" path="opis" id="exampleFormControlTextarea1"
					rows="5"></form:textarea>
			</div>
			<div class="col-12">
				<a href="/FitTracker/vezbe/sveVezbe" class="btn btn-danger">Odustani</a>
				<button type="submit" class="btn btn-primary">Sačuvaj vežbu</button>
			</div>
		</form:form>
		<c:if test="${not empty message}">
		<div class="alert alert-primary mt-4 col-8 mx-auto" role="alert">${message}</div>
		</c:if>
		<c:if test="${!empty errors}">
	        <c:forEach items="${errors}" var="error">
	            <div class="alert alert-danger mt-4 col-8 mx-auto" role="alert">${error.defaultMessage}</div>
	        </c:forEach>
		</c:if>
	</div>
	

	<!-- Your Content Goes Here -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>