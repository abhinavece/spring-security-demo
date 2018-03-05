<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html>

<head>
<title>Company Home Page</title>
</head>

<body>
	<h2>Company Home Page</h2>
	<hr>

	Welcome to the company home page!

	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout" />
	</form:form>

	<hr>
	<p>
		Username:
		<security:authentication property="principal.username" />
	</p>
	<p>
		Password:
		<security:authentication property="principal.authorities" />
	</p>
	<hr>

	<security:authorize access="hasRole('MANAGER')">
		Managers-
		<a href="${pageContext.request.contextPath}/leader">Click Here</a>
		<br>

	</security:authorize>

	<security:authorize access="hasRole('ADMIN')">
		IT System Admin-
		<a href="${pageContext.request.contextPath}/system">Click Here</a>
		<br>
	</security:authorize>


</body>

</html>