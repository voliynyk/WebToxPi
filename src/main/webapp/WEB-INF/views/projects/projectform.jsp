<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<div class="container">

	<c:choose>
		<c:when test="${projectForm['new']}">
			<h1>Add Project</h1>
		</c:when>
		<c:otherwise>
			<h1>Update Project</h1>
		</c:otherwise>
	</c:choose>
	<br />

	<spring:url value="/projects" var="projectActionUrl" />

	<form:form class="form-horizontal" method="post" modelAttribute="projectForm" action="${projectActionUrl}">

		<form:hidden path="id" />

		<spring:bind path="code">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Code</label>
				<div class="col-sm-10">
					<form:input path="code" type="text" class="form-control " id="firstName" placeholder="Project Code" />
					<form:errors path="code" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="name">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Project Name</label>
				<div class="col-sm-10">
					<form:input path="name" type="text" class="form-control " id="firstName" placeholder="Project Name" />
					<form:errors path="name" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="access">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Access Level</label>
				<div class="col-sm-5">
					<form:select path="access" class="form-control">
						<form:option value="NONE" label="--- Select ---" />
						<form:options items="${accessList}" />
					</form:select>
					<form:errors path="access" class="control-label" />
				</div>
				<div class="col-sm-5"></div>
			</div>
		</spring:bind>
		
		<spring:bind path="projecttype">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Project Type</label>
				<div class="col-sm-5">
					<form:select path="projecttype" class="form-control">
						<form:option value="NONE" label="--- Select ---" />
						<form:options items="${projectTypeList}" />
					</form:select>
					<form:errors path="projecttype" class="control-label" />
				</div>
				<div class="col-sm-5"></div>
			</div>
		</spring:bind>
		
		<spring:bind path="notes">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Project Description</label>
				<div class="col-sm-10">
					<form:textarea path="notes" rows="5" class="form-control" id="state" placeholder="Description" />
					<form:errors path="notes" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${projectForm['new']}">
						<button type="submit" class="btn-lg btn-primary pull-right">Add</button>
					</c:when>
					<c:otherwise>
						<button type="submit" class="btn-lg btn-primary pull-right">Update</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>

</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>