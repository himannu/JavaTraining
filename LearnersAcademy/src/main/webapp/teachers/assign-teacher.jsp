<jsp:include page="../header.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<title>Assign Teacher to Class</title>
</head>
<body>
	
	<form method = "post" action="./assignTeacher" >

		<div class = "container col-md-6">
	  	<input type="hidden" name="teacherId" value="${teacher.getId()}" />
		<h3 align="center" > Teacher: "${teacher.getName()}"</h3>
		
		<div class="form-group">
		  <label for="classSelected">Class :</label>
		  <select class="form-control" id="classId" name="classId">
			<c:forEach items="${classes}" var="cls">		
		    <option value="${cls.getClassId()}" > ${cls.getClassName()} </option>
		  </c:forEach>
		  </select>
		</div>

		<div class="form-group">
		  <label for="classSelected">Subject :</label>
		  <select class="form-control" id="subjectId" name="subjectId">
			<c:forEach items="${subjects}" var="subject">		
		    <option value="${subject.getId()}" > ${subject.getName()} </option>
		  </c:forEach>
		  </select>
		</div>
	  
	  <button type="submit" class="btn btn-default">Assign Teacher</button>
	</div>
	</form>

<jsp:include page="../footer.jsp"></jsp:include>