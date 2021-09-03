<jsp:include page="../header.jsp"></jsp:include>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div class="mb3   col-md-6">
		<form method = "post" action="./addSubjects" >
		  <div class="form-group">
		  	<input type="hidden" name="classId" value="${cls.getClassId()}" />
				<h3 align="center" > Assign Subjects for Class Name: "${cls.getClassName()}"</h3>
		  </div>
			  <div class="form-group">
			    <label for="subjects">List Of Subjects to be assigned:</label>
			    
				
				<c:forEach items="${subjects }" var="subject"> 
				  <div class="list-group">
				  <label class="list-group-item">
				    <input class="form-check-input me-1" type="checkbox" name="subjs" value="${subject.getId() }"> 
				    <c:out value="${subject.getName()}"></c:out> 
				  </label>
				</div>
				</c:forEach>
				  
			</div>
		  <button type="submit" class="btn btn-default">Submit</button>
		  
		</form>
	</div>
<jsp:include page="../footer.jsp"></jsp:include>