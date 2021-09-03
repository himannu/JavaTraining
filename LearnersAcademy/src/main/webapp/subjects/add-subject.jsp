<jsp:include page="../header.jsp"></jsp:include>
<title>Add New Subject</title>
</head>
<body>
	<div class = "container col-3">
	<form method = "post" action="./add" >
	  <div class="form-group col-3">
	    <label for="subjectName">Subject Name:</label>
	    <input type="text" class="form-control" name = "subjectName" id="subjectName">
	  </div>
	  <div class="form-group col-3">
	    <label for="subjectType">Subject Type:</label>
	    <input type="text" class="form-control" name = "subjectType" id="subjectType">
	  </div>
	  <button type="submit" class="btn btn-default">Submit</button>
	</form>
	</div>
<jsp:include page="../footer.jsp"></jsp:include>