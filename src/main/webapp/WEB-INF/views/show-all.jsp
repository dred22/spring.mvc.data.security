<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="components/head.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ include file="components/side-bar.jsp"%>

<!-- Page Content -->
<div id="page-content-wrapper">

		<div class="container">
		
		
					<c:choose>
					<c:when test="${deleted != 'ok'}">	
			<table class="table table-hover">
				<thead>
					<tr>
						<th><spring:message code="show-all.employee.table.firstName"/></th>
						<th><spring:message code="show-all.employee.table.lastName"/></th>
						<th><spring:message code="show-all.employee.table.salary"/></th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${em}" var="entite">
					<tr>
						<td>${entite.firstName }</td>
						<td>${entite.lastName }</td>
						<td>${entite.salary }</td>
						<td><a href="${pageContext.request.contextPath}/delete?id=${entite.id}" class="btn btn-danger" role="button"><spring:message code="show-all.employee.table.action.delete"/></a></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
				</c:when>
					<c:otherwise>
					<div class="alert alert-success text-center" role="alert"><spring:message code="show-all.employee.message.delete.ok"/></div>
					</c:otherwise>
				</c:choose>		
			
		</div>
	<a href="#menu-toggle" class="btn btn-default" id="menu-toggle">Toggle Menu</a>
	</div>
	<!-- /#page-content-wrapper -->

<%@ include file="components/script-block.jsp"%>
<%@ include file="components/foot.jsp"%>
