    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<jsp:include page="../header.jsp"></jsp:include>
	<main class = "container-fluid p-4">
		<a href="showNewForm" class="btn btn-primary" role="button" data-bs-toggle="button">Add Teacher</a>
		<br/>
		<form>
		<h3 align="center" > List of Teachers</h3>

		<table class =" table table-striped table-bordered">
			<thead>
				<tr>
					<th></th>
					<th colspan="3">Name</th>
					<th colspan="3">Email</th>
					<th colspan="3">Phone</th>
					<th colspan="3">Address</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${teachers }" var="teacher">
			<tr>
				<td><input type="radio" name="teacherId" value="${teacher.getId() }" checked="checked"></td>
				<td colspan="3"><c:out value="${teacher.getName() }"/></td>
				<td colspan="3"><c:out value="${teacher.getEmailId() }"/></td>
				<td colspan="3"><c:out value="${teacher.getPhoneNumber() }"/></td>
				<td colspan="3"><c:out value="${teacher.getAddress()}"/></td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		<input type="submit"  class = "btn btn-primary" formaction="showEditForm" value="Edit">
		<input type="submit" class = "btn btn-primary" formaction="delete" value="Delete">
		<input type="submit" class = "btn btn-primary" formaction="showAssignTeacherForm" value="Assign to a Class">
		</form>
		</main>
		<jsp:include page="../footer.jsp"></jsp:include>
