    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<jsp:include page="../header.jsp"></jsp:include>
	<main class = "container-fluid p-4">
		<a href="showNewForm" class="btn btn-primary" role="button" data-bs-toggle="button">Add Subject</a>
		<br/>
		<h3 align="center" > List of Subjects</h3>
		<table class =" table table-striped table-bordered">
			<thead>
				<tr>
					<th>Subject Name</th>
					<th>Subject Type</th>
					<th>Modify</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${subjects }" var="subject">
			<tr>
				<td><c:out value="${subject.getName() }"/></td>
				<td><c:out value="${subject.getSubjectType() }"/></td>
				
				<td>
				<a href="showEditForm?subjectId=<c:out value='${subject.getId() }' />" class="btn btn-primary" role="button" data-bs-toggle="button">Edit</a>
				<a href="delete?subjectId=<c:out value='${subject.getId()}'/>" class="btn btn-primary" role="button" data-bs-toggle="button">Delete</a>
			</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		</main>
		<jsp:include page="../footer.jsp"></jsp:include>
