<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%@ page import="java.util.List, fr.treeptik.java.models.Employee"%>


<body>



	<c:forEach items="${em}" var="entite">
		<p>
			<%-- <c:forEach items="${entite}" var="item">
				<spam> ${item }</spam>
			</c:forEach> --%>
			<c:forEach var="field" items="${entite['class'].declaredFields}">
				<c:catch>
					<li><span>${field.name} </span>  ${entite[field.name]} ${ empty entite[field.name] ? 'null':'' }</li>
				</c:catch>
			</c:forEach>
		</p>
	</c:forEach>
</body>
</html>