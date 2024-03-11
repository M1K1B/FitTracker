<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="model.Treninzi"%>
<%@ page import="java.util.Date"%>


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
			<div class="col-12 justify-content-end d-flex mb-3">
				<a class="btn btn-success" href="/FitTracker/treninzi/dodajTrening">Dodaj
					trening</a>
			</div>
			<div class="col-12 row row-cols-4 mx-0">
				<c:forEach items="${ treninzi }" var="k">
					<div class="p-1 col-3">
						<div class="card">
							<div class="card-body">
								<div class="d-flex justify-content-between align-items-center">
									<div>
										<h5 class="card-title">
											${ k.naziv }
										</h5>
										<p class="card-text small">
											<%
											 	Treninzi yourObjectInstance = (Treninzi) pageContext.getAttribute("k");
												String pattern = "d MMMM yyyy.";
												SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
												
												String date = simpleDateFormat.format(yourObjectInstance.getDatum());
											%>
											<%= date %>
										</p>
									</div>
									<a
										href="/FitTracker/treninzi/obrisiTrening?id=${ k.idTreninga }">
										<svg xmlns="http://www.w3.org/2000/svg" width="28" height="28"
											fill="red" class="bi bi-trash" viewBox="0 0 16 16">
									  <path
												d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z" />
									  <path
												d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z" />
									</svg>
									</a>
								</div>
							</div>
							<ul class="list-group list-group-flush">
								<c:forEach items="${ k.uradios }" var="u">
									<li class="list-group-item">${ u.vezbe.naziv }· <span
										class="text-body-secondary">${ u.brSerija }x${ u.brPonavljanja }</span></li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</c:forEach>
				<c:if test="${empty treninzi}">
					<div class="h3 mt-4 col-8 mx-auto text-center" role="alert">Nije nadjen ni jedan trening, dodajte Vaš prvi.</div>
				</c:if>
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