<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="ft" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<%@ taglib prefix="sq" uri="jakarta.tags.sql"%>
<%@ taglib prefix="x" uri="jakarta.tags.xml"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
aaa
	<c:choose>
		<c:when test="${null!=name}">
			<h1>Welcome to ${name}</h1>
		</c:when>
		<c:otherwise>
			<form method="POST" action="WelcomeServlet">
				<c:if test="null==name"></c:if>
				<label for="name" title="Enter the name">Name: </label> <input
					type="text" id="txtName" name="name"/><br> <input
					type="submit" value="Submit" /><br>
			</form>
		</c:otherwise>
	</c:choose>
</body>
</html>