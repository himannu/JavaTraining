    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<jsp:include page="../header.jsp"></jsp:include>
	<main class = "container-fluid p-4">
		<a href="showNewForm" class="btn btn-primary" role="button" data-bs-toggle="button">Add Class</a>
		<br/>
		<h3 align="center" > List of Classes</h3>

	<form action="" method="post">
		<table class =" table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th colspan="1">Select</th>
					<th colspan="3">Class Name</th>
					<th colspan="8">Class Description</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${classes }" var="cls">
			<tr>
				<td colspan="1"><input type="radio" name="classId" value="${cls.getClassId() }" checked="checked"></td>
				<td colspan="3"><c:out value="${cls.getClassName() }"/></td>
				<td colspan="8"><c:out value="${cls.getClassDescription() }"/></td>
			</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		<input type="submit"  class = "btn btn-primary" formaction="showEditForm" value="Edit">
		<input type="submit" class = "btn btn-primary" formaction="delete" value="Delete">
		<input type="submit" class = "btn btn-primary" formaction="/<%=application.getInitParameter("applicationName")%>/students/listStudents" value="List Students">
		<input type="submit" class = "btn btn-primary" formaction="/<%=application.getInitParameter("applicationName")%>/classes/listSubjects" value="Assign Subjects">
		<input type="submit" class = "btn btn-primary" formaction="showReport" value="Show Report">
	</form>
</main>
<jsp:include page="../footer.jsp"></jsp:include>
