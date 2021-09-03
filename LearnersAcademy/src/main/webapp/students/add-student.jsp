<jsp:include page="../header.jsp"></jsp:include>
<title>Add Student Details</title>
</head>
<body>
	<div class = "container">
	<form class="row g-3 col-md-10 " method = "post" action="./add" >
		<input type="hidden" name="classId" value="${cls.getClassId()}" />
	  <div class="form-group col-md-12 ">
		    <strong>Class Name:</strong><label >"${cls.getClassName()}"</label>
		</div>
	  <div class="form-group col-md-12">
	    <label for="name">Student Name:</label>
	    <input type="text" class="form-control" name = "name" id="name">
	  </div>
	  <div class="form-group col-md-6">
	    <label for="line1">Line 1:</label>
	    <input type="text" class="form-control" name = "line1" id="line1">
	  </div>
	  	  <div class="form-group col-md-6">
	    <label for="line2">Line 2:</label>
	    <input type="text" class="form-control" name = "line2" id="line2">
	  </div>
	  	  <div class="form-group col-md-6">
	    <label for="city">City:</label>
	    <input type="text" class="form-control" name = "city" id="city">
	  </div>
	  <div class="form-group col-md-4">
	    <label for="state">State:</label>
	    <input type="text" class="form-control" name = "state" id="state">
	  </div>
	  <div class="form-group col-md-2">
	    <label for="pincode">Pin Code:</label>
	    <input type="text" class="form-control" name = "pincode" id="pincode">
	  </div>
	  
	  <div class="form-group col-md-6">
	    <label for="emailId">Email Id:</label>
	    <input type="text" class="form-control" name = "emailId" id="emailId">
	  </div>
  	  <div class="form-group col-md-6">
	    <label for="phoneNumber">Phone Number:</label>
	    <input type="text" class="form-control" name = "phoneNumber" id="phoneNumber">
	  </div>
	  <button type="submit" class="btn btn-default">Submit</button>

	</form>
	</div>
<jsp:include page="../footer.jsp"></jsp:include>