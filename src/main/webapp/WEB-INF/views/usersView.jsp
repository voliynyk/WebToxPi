<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="col-sm-offset-1 col-sm-10">

	<legend>
		<spring:message code="table.user.title" />
	</legend>

	<div>
		<table id="dataTable" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th><spring:message code="table.user.id" /></th>
					<th><spring:message code="table.user.firstName" /></th>
					<th><spring:message code="table.user.lastName" /></th>
					<th><spring:message code="table.user.email" /></th>
				</tr>
			<thead>
			<tbody>
				<c:forEach var="u" items="${usersModel}">
					<tr>
						<td>${u.id}</td>
						<td>${u.firstName}</td>
						<td>${u.lastName}</td>
						<td>${u.email}</td>
					<tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>