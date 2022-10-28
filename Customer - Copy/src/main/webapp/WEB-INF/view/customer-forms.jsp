<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<a style="backgroung-color:green"href="">Customer Relationship Management</a>
<title>Save Customer</title>
</head>

<body>

	<div class="container">

		<h3>Customer Directory</h3>
		<hr>

		<p class="h4 mb-4">Customer </p>

		<form action="/Customer/customer/save" method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${Customer.id}" />

			<div class="form-inline">
				<input type="text" name="name" value="${Customer.name}"
					class="form-control mb-4 col-4" placeholder="Name">



			</div>

			<div class="form-inline">

				<input type="text" name="department" value="${Customer.email}"
					class="form-control mb-4 col-4" placeholder="email">



			</div>

			

			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/Lab_5/students/list">Back to Customer List</a>

	</div>
</body>

</html>










