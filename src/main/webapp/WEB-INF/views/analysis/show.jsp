<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

        
        
<spring:url value="/resources/css/analysis.css" var="analysisCss" />
<spring:url value="/resources/js/analysis.js" var="analysisJs" />
<script src="${analysisJs}"></script>
<link href="${analysisCss}" rel="stylesheet" />
<div class="container">

	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>

	<h1>Analysis:</h1>
	<br />

	<div class="row">
		<label class="col-sm-2">ID</label>
		<div class="col-sm-10">the result: ${analysis.results}</div>
	</div>

</div>
<h1>THIS IS A TEST GRID:</h1>
<div id="gridContainer"></div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>