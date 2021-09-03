    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<jsp:include page="../header.jsp"></jsp:include>
	<main class = "container-fluid p-4">
		<a href="showNewForm?classId=<c:out value='${cls.getClassId() }' />" class="btn btn-primary" role="button" data-bs-toggle="button">Add Student</a>
		<br/>
		<h3 align="center" > List of Students in Class "${cls.getClassName()}"</h3>
		<table class =" table table-striped table-bordered">
			<thead>
				<tr>
					<th>Student Name</th>
					<th>Student Email</th>
					<th>Student Phone</th>
					<th>Address</th>
					<th>Modify</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${cls.students }" var="student">
			<tr>
				<td><c:out value="${student.getName() }"/></td>
				<td><c:out value="${student.getEmailId() }"/></td>
				<td><c:out value="${student.getPhoneNumber() }"/></td>
				<td><c:out value="${student.getAddress() }"/></td>
				<td>
				<a href="showEditForm?studentId=<c:out value='${student.getId()}'/>&classId=<c:out value='${cls.getClassId()}'/>" 
				class="btn btn-primary" role="button" data-bs-toggle="button">Edit</a>
				<a href="delete?studentId=<c:out value='${student.getId() }'/>&classId=<c:out value='${cls.getClassId()}'/>" class="btn btn-primary" role="button" data-bs-toggle="button">Delete</a>
			</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		</main>
		<jsp:include page="../footer.jsp"></jsp:include>
