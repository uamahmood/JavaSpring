<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- To use form binding -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>New License</title>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-8 p-3">
				<div class="row justify-content-center border-bottom pb-2">
					<h2 class="text-center">New License</h2>
				</div>
				<div class="row justify-content-center">
					<div class="col-6 p-2">
						<form:form action="/licenses/new" method="post"
							modelAttribute="license">
							<div class="row justify-content-start">
								<div class="col-6">
									<form:label path="person">Person:</form:label>
								</div>
								<div class="col-6">
									<form:select path="person">
										<c:forEach items="${persons}" var="person">
											<form:option value="${person}"
												label="${person.getFirstName()} ${person.getLastName()}" />
										</c:forEach>
									</form:select>
								</div>
								<div class="col-12">
									<p class="text-danger">
										<form:errors path="person" />
									</p>
								</div>
							</div>
							<div class="row justify-content-start">
								<div class="col-6">
									<form:label path="state">State:</form:label>
								</div>
								<div class="col-6">
									<form:input path="state" />
								</div>
								<div class="col-12">
									<p class="text-danger">
										<form:errors path="state" />
									</p>
								</div>
							</div>
							<div class="row justify-content-start">
								<div class="col-6">
									<form:label path="expirationDate">Expiration Date:</form:label>
								</div>
								<div class="col-6">
									<form:input path="expirationDate" type="date" />
								</div>
								<div class="col-12">
									<p class="text-danger">
										<form:errors path="expirationDate" />
									</p>
								</div>
							</div>
							<div class="row justify-content-center">
								<div class="col-2">
									<input type="submit" value="Submit" class="btn btn-success" />
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>