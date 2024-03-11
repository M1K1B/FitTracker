<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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

<style>
.card {
	text-decoration: none;
}

.card:hover {
	background-color: #fafafa;
	cursor: pointer;
}
</style>
</head>
<body>
	<%@include file="header.jsp"%>

	<div class="container mt-5">
		<div class="row">
			<div class="col-3">
				<a class="btn btn-success col-12"
					href="/FitTracker/vezbe/dodajVezbu">Dodaj vežbu</a>
				<hr>
				<form class="mt-2" method="get">
					<div class="input-group mb-3">
						<input type="text" class="form-control border-end-0"
							aria-label="Search" placeholder="Pretraga" name="searchQuery">
						<span class="input-group-text bg-white border-start-0"> <svg
								xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
	  							<path
									d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0" />
							</svg>
						</span>
					</div>
					<select class="form-select mb-3" name="misicId"
						aria-label="Default select example">
						<option value="-1">Mišić</option>
						<c:forEach items="${ misici }" var="k">
							<option value="${k.idMisica}">${k.naziv}</option>
						</c:forEach>
					</select>
					<div class="mb-3 form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1"
							name="samoOmiljeni"> <label class="form-check-label"
							for="exampleCheck1">Samo omiljene</label>
					</div>
					<button type="submit" class="btn btn-primary col-12">Filtriraj</button>
				</form>
				<a href="/FitTracker/vezbe/sveVezbe"
					class="btn btn-danger col-12 mt-2">Poništi filtere</a>
			</div>
			<div class="col-9">
				<c:forEach items="${ vezbe }" var="k">
					<div class="card mb-3">
						<div class="row g-0">
							<div class="col-md-3">
								<img src="${ k.slika }" class="img-fluid rounded-start"
									alt="${ k.naziv }">
							</div>
							<div class="col-md-8">
								<div class="card-body">
									<h5 class="card-title">${ k.naziv }</h5>
									<p class="card-text">${ k.opis }</p>
									<p class="card-text">
										<small class="text-body-secondary">${ k.pogadjas[0].misici.naziv }
											· Ocena: ${ k.ocena }</small>
									</p>
								</div>
							</div>
							<div class="col-md-1 d-flex align-items-stretch">
								<div
									class="card-body d-flex align-items-center justify-content-end">
									<c:set var="contains" value="false" /> <c:forEach
											var="item" items="${ omiljene }">
											<c:if test="${item eq k}">
												<c:set var="contains" value="true" />
											</c:if>
										</c:forEach>
										<c:if test="${ not contains }">
											<a href="/FitTracker/vezbe/dodajOmiljenu?id=${ k.idVezbe }">
										 <svg xmlns="http://www.w3.org/2000/svg" width="28"
												height="28" fill="#0d6efd" class="bi bi-star"
												viewBox="0 0 16 16">
	  											<path
													d="M2.866 14.85c-.078.444.36.791.746.593l4.39-2.256 4.389 2.256c.386.198.824-.149.746-.592l-.83-4.73 3.522-3.356c.33-.314.16-.888-.282-.95l-4.898-.696L8.465.792a.513.513 0 0 0-.927 0L5.354 5.12l-4.898.696c-.441.062-.612.636-.283.95l3.523 3.356-.83 4.73zm4.905-2.767-3.686 1.894.694-3.957a.56.56 0 0 0-.163-.505L1.71 6.745l4.052-.576a.53.53 0 0 0 .393-.288L8 2.223l1.847 3.658a.53.53 0 0 0 .393.288l4.052.575-2.906 2.77a.56.56 0 0 0-.163.506l.694 3.957-3.686-1.894a.5.5 0 0 0-.461 0z" />
											</svg>
									</a>
											
										</c:if> <c:if test="${ contains }">
										<a href="/FitTracker/vezbe/ukloniOmiljenu?id=${ k.idVezbe }">
											<svg xmlns="http://www.w3.org/2000/svg" width="28"
												height="28" fill="#0d6efd" class="bi bi-star-fill"
												viewBox="0 0 16 16">
  <path
													d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z" />
</svg></a>
										</c:if>
									
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

	<!-- Your Content Goes Here -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>