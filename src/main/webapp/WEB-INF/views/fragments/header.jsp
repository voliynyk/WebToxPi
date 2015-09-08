<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<title>Web ToxPi</title>

<spring:url value="/resources/css/hello.css" var="coreCss" />
<spring:url value="/resources/external/bootstrap/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<spring:url value="/" var="urlHome" />
<spring:url value="/users/add" var="urlAddUser" />
<spring:url value="/projects/add" var="urlAddProject" />
<spring:url value="/analysis/${projectId}" var="urlDisplayAnalysis" />

<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">Home</a>
		</div>
		<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${urlAddUser}">Import</a></li>
				<li class="active"><a href="${urlAddProject}">Export</a></li>
				<li class="active"><a href="${urlDisplayAnalysis}">Analysis</a></li>
				<li class="active"><a href="${urlAddProject}">My Page</a></li>			
				<li class="not-active"><a href="#" id="proj">         selected project: ${projectId}	</a></li>	
			</ul>
		</div>
	</div>
</nav>