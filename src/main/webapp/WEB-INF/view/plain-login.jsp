<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Custom Login Page</title>
<style>
	.failed {
		color: red;
	}
</style>
</head>
<body>

<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">

	<c:if test="${param.error != null}" >
		<p class="failed"><i>Your username/password is incorrect.</i></p>
	</c:if>

	<p>
		User Name: <input type="text" name="username" />
	</p>
	<p>
		Password: <input type="text" name="password" />
	</p>
	<input type="submit" value="Login" />

</form:form>

</body>
</html>