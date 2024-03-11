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
		<div class="col-9 mx-auto">
			<div class="d-flex align-items-center">
				<div>
					<h3 class="h3">${ korisnik.ime }${ korisnik.prezime }</h3>
					<p>${ korisnik.email }</p>
				</div>
				<!-- <div class="flex-grow-1"></div>
				<a class="btn btn-secondary">
					<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-file-earmark-text" viewBox="0 0 16 16">
					  <path d="M5.5 7a.5.5 0 0 0 0 1h5a.5.5 0 0 0 0-1zM5 9.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5m0 2a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1h-2a.5.5 0 0 1-.5-.5"/>
					  <path d="M9.5 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V4.5zm0 1v2A1.5 1.5 0 0 0 11 4.5h2V14a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1z"/>
					</svg>
				</a>
				<a class="btn btn-primary ms-2">Promena lozinke</a> -->
			</div>
			<hr>
			<div class="row">
				<div class="col-3">
					<p>Težina: ${ korisnik.tezina } kg</p>
					<p>Visina: ${ korisnik.visina } cm</p>
					<p>BMI: ${ korisnik.bmi }</p>
					<p>
						Vi ste <span class="text-decoration-underline">${ korisnik.status }</span>.
					</p>
				</div>
				<div class="col-9">

					<table class="table table-bordered">
						<thead>
							<tr>
								<th scope="col">Cilj</th>
								<th scope="col">Kalorije (kcal)</th>
								<th scope="col">Proteini (g)</th>
								<th scope="col">Masti (g)</th>
								<th scope="col">Hidrati (g)</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">Gojenje (+0.5 kg/nedeljno)</th>
								<td>${ korisnik.macros[0][0] }</td>
								<td>${ korisnik.macros[0][1] }</td>
								<td>${ korisnik.macros[0][2] }</td>
								<td>${ korisnik.macros[0][3] }</td>
							</tr>
							<tr>
								<th scope="row">Gojenje (+0.25 kg/nedeljno)</th>
								<td>${ korisnik.macros[1][0] }</td>
								<td>${ korisnik.macros[1][1] }</td>
								<td>${ korisnik.macros[1][2] }</td>
								<td>${ korisnik.macros[1][3] }</td>
							</tr>
							<tr>
								<th scope="row">Održavanje težine</th>
								<td>${ korisnik.macros[2][0] }</td>
								<td>${ korisnik.macros[2][1] }</td>
								<td>${ korisnik.macros[2][2] }</td>
								<td>${ korisnik.macros[2][3] }</td>
							</tr>
							<tr>
								<th scope="row">Mršavljenje (-0.25 kg/nedeljno)</th>
								<td>${ korisnik.macros[3][0] }</td>
								<td>${ korisnik.macros[3][1] }</td>
								<td>${ korisnik.macros[3][2] }</td>
								<td>${ korisnik.macros[3][3] }</td>
							</tr>
							<tr>
								<th scope="row">Mršavljenje (-0.5 kg/nedeljno)</th>
								<td>${ korisnik.macros[4][0] }</td>
								<td>${ korisnik.macros[4][1] }</td>
								<td>${ korisnik.macros[4][2] }</td>
								<td>${ korisnik.macros[4][3] }</td>
							</tr>
						</tbody>
					</table>
				</div>
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
