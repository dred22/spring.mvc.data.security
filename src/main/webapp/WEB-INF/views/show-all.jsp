<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="components/head.jsp"%>


	<%@ include file="components/side-bar.jsp"%>


	<!-- Page Content -->
	
	<div id="page-content-wrapper">
		<div class="container">
		
		
					<c:choose>
					<c:when test="${deleted != 'ok'}">	
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Firstname</th>
						<th>Lastname</th>
						<th>Salary</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${em}" var="entite">
					<tr>
						<td>${entite.firstName }</td>
						<td>${entite.lastName }</td>
						<td>${entite.salary }</td>
						<td><a href="${pageContext.request.contextPath}/delete?id=${entite.id}" class="btn btn-danger" role="button">Delete</a></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
				</c:when>
					<c:otherwise>
					<div class="alert alert-success text-center" role="alert">Entity was successful deleted </div>
					</c:otherwise>
				</c:choose>		
			
		</div><a href="#menu-toggle" class="btn btn-default" id="menu-toggle">Toggle Menu</a>
	</div>
	<!-- /#page-content-wrapper -->

</div>
<!-- /#wrapper -->

<%@ include file="components/script-block.jsp"%>
<%@ include file="components/foot.jsp"%>
