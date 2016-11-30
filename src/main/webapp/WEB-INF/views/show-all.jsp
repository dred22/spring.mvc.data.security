<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="components/head.jsp"%>


	<%@ include file="components/side-bar.jsp"%>


	<!-- Page Content -->
	<div id="page-content-wrapper">
		<div class="container">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Firstname</th>
						<th>Lastname</th>
						<th>Salary</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${em}" var="entite">
					<tr>
						<td>${entite.firstName }</td>
						<td>${entite.lastName }</td>
						<td>${entite.salary }</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
		</div><a href="#menu-toggle" class="btn btn-default" id="menu-toggle">Toggle Menu</a>
	</div>
	<!-- /#page-content-wrapper -->

</div>
<!-- /#wrapper -->

<%@ include file="components/script-block.jsp"%>
<%@ include file="components/foot.jsp"%>
