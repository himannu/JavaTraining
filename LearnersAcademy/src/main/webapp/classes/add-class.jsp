<jsp:include page="../header.jsp"></jsp:include>
<title>Add New Class</title>
</head>
<body>
	<div class = "container col-md-6">
	<form method = "post" action="./add" >
	  <div class="form-group">
	    <label for="className">Class Name:</label>
	    <input type="text" class="form-control" name = "className" id="className">
	  </div>
	  <div class="form-group">
	    <label for="classDesc">Class Description:</label>
	    <input type="text" class="form-control" name = "classDesc" id="classDesc">
	  </div>
	    <div class="form-group">
	  <button type="submit" class="btn btn-default">Submit</button>
	  </div>
	</form>
	</div>
<jsp:include page="../footer.jsp"></jsp:include>