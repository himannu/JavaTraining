<jsp:include page="../header.jsp"></jsp:include>
<title>Edit Student Details</title>
</head>
<body>
	<div class = "container">
	<form class="row g-3 col-md-10 " method = "post" action="./add" >
		<input type="hidden" name="classId" value="${cls.getClassId()}" />
		<input type="hidden" name="studentId" value="${student.getId()}" />
		
	  <div class="form-group col-md-12 ">
		    <strong>Class Name:</strong><label >"${cls.getClassName()}"</label>
		</div>
	  <div class="form-group col-md-12">
	    <label for="name">Student Name:</label>
	    <input type="text" class="form-control" name = "name" id="name" value="${student.getName() }">
	  </div>
	  <div class="form-group col-md-6">
	    <label for="line1">Line 1:</label>
	    <input type="text" class="form-control" name = "line1" id="line1" value="${student.getAddress().getLine1() }">
	  </div>
	  	  <div class="form-group col-md-6">
	    <label for="line2">Line 2:</label>
	    <input type="text" class="form-control" name = "line2" id="line2" value="${student.getAddress().getLine2() }">
	  </div>
	  	  <div class="form-group col-md-6">
	    <label for="city">City:</label>
	    <input type="text" class="form-control" name = "city" id="city" value="${student.getAddress().getCity() }">
	  </div>
	  <div class="form-group col-md-4">
	    <label for="state">State:</label>
	    <input type="text" class="form-control" name = "state" id="state" value="${student.getAddress().getState() }">
	  </div>
	  <div class="form-group col-md-2">
	    <label for="pincode">Pin Code:</label>
	    <input type="text" class="form-control" name = "pincode" id="pincode" value="${student.getAddress().getPincode() }">
	  </div>
	  
	  <div class="form-group col-md-6">
	    <label for="emailId">Email Id:</label>
	    <input type="text" class="form-control" name = "emailId" id="emailId" value="${student.getEmailId() }">
	  </div>
  	  <div class="form-group col-md-6">
	    <label for="phoneNumber">Phone Number:</label>
	    <input type="text" class="form-control" name = "phoneNumber" id="phoneNumber" value="${student.getPhoneNumber() }">
	  </div>
	  <button type="submit" class="btn btn-default">Submit</button>

	</form>
	</div>
<jsp:include page="../footer.jsp"></jsp:include>