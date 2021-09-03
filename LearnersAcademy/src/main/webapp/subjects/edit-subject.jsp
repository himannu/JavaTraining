<jsp:include page="../header.jsp"></jsp:include>
	<div class="mb3">
		<h2>Edit Class</h2>
		<form method = "post" action="./update" >
		  <div class="form-group">
		  	<input type="hidden" name="subjectId" value="${subject.getId()}" />
		    <label for="subjectName">Subject Name:</label>
		    <input type="text" class="form-control" name = "subjectName" id="subjectName" value="${subject.getName() }"   >
		  </div>
		  <div class="form-group">
		    <label for="subjectType">Subject Type:</label>
		    <input type="text" class="form-control" name = "subjectType" id="subjectType" value = "${subject.getSubjectType() }" >
		  </div>
		  <button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
<jsp:include page="../footer.jsp"></jsp:include>