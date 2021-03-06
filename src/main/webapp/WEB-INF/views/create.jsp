<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="components/head.jsp"%>

<!-- <div id="wrapper"> -->
	<%@ include file="components/side-bar.jsp"%>


	<!-- Page Content -->
	<div id="page-content-wrapper">
		<div class="container">

			<div class="col-sm-offset-3 col-sm-6">
				<c:choose>
					<c:when test="${empty employee.id}">
						<div class="panel panel-default">

							<div class="panel-heading">Employee</div>
							<div class="panel-body">
								<form:form method="post" modelAttribute="employee">
									<div class="form-group">
										<label for="firstName"><spring:message code="create.employee.firstName"/></label>
										<form:input path="firstName" class="form-control" />
										<!-- <input id="firstName" name="firstName" class="form-control" type="text" /> -->
									</div>
									<div class="form-group">
										<label for="lastName"><spring:message code="create.employee.lastName"/></label>
										<form:input class="form-control" path="lastName" />
									</div>
									<div class="form-group">
										<label for="salary"><spring:message code="create.employee.salary"/></label> <input type="text"
											name="salary" class="form-control" id="salary" />
									</div>
									<button type="submit" class="btn btn-default"><spring:message code="create.employee.salary.submit"/></button>
								</form:form>
								
							</div>

						</div>
					</c:when>
					<c:otherwise>
				<div class="alert alert-success text-center" role="alert">Employee <strong>${employee.firstName}</strong> <spring:message code="create.employee.massage.ok"/> </div>
					</c:otherwise>
				</c:choose>

			</div>


		</div>
		<a href="#menu-toggle" class="btn btn-default" id="menu-toggle">Toggle
			Menu</a>
	</div>
	<!-- /#page-content-wrapper -->

</div>
<!-- /#wrapper -->

<%@ include file="components/script-block.jsp"%>
<%@ include file="components/foot.jsp"%>
