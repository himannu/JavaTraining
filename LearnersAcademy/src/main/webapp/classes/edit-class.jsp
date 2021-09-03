<jsp:include page="../header.jsp"></jsp:include>
	<div class="mb3   col-md-6">
		<h3>Edit Class</h3>
		<form method = "post" action="./update" >
		  <div class="form-group">
		  	<input type="hidden" name="classId" value="${cls.getClassId()}" />
		    <label for="className">Class Name:</label>
		    <input type="text" class="form-control" name = "className" id="className" value="${cls.getClassName() }"   >
		  </div>
		  <div class="form-group">
		    <label for="classDesc">Class Description:</label>
		    <input type="text" class="form-control" name = "classDesc" id="classDesc" value = "${cls.getClassDescription() }" >
		  </div>
		  <button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
<jsp:include page="../footer.jsp"></jsp:include>