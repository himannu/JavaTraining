    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<jsp:include page="../header.jsp"></jsp:include>
	<main class = "container-fluid p-4">
		<a href="showNewForm" class="btn btn-primary" role="button" data-bs-toggle="button">Add Teacher</a>
		<br/>
		<h3 align="center" > Teachers for Class Name: "${cls.getClassName()}"</h3>
		<input type="hidden" name="classId" value="${cls.getClassId()}" />

		<table class =" table table-striped table-bordered">
			<thead>
				<tr>
					<th>Teacher Name</th>
					<th>Teacher Email</th>
					<th>Teacher Phone</th>
					<th>Address</th>
					<th>Subject</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${teachers }" var="teacher">
			<tr>
				<td><c:out value="${teacher.getName() }"/></td>
				<td><c:out value="${teacher.getEmailId() }"/></td>
				<td><c:out value="${teacher.getPhoneNumber() }"/></td>
				<td><c:out value="${subject.getName()}"/></td>
				<td>
				<a href="showEditForm?teacherId=<c:out value='${teacher.getId() }' />" class="btn btn-primary" role="button" data-bs-toggle="button">Edit</a>
				<a href="delete?teacherId=<c:out value='${teacher.getId() }'/>" class="btn btn-primary" role="button" data-bs-toggle="button">Delete</a>
			</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		</main>
		<jsp:include page="../footer.jsp"></jsp:include>
