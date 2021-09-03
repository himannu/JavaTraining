<jsp:include page="../header.jsp"></jsp:include>
	<div class="mb3   col-md-6">
		<h3>Edit Teacher Details</h3>
		<form method = "post" action="./update" >
		<input type="hidden" name="teacherId" value="${teacher.getId()}" />
		
	  <div class="form-group col-md-12">
	    <label for="name">Teacher Name:</label>
	    <input type="text" class="form-control" name = "name" id="name" value="${teacher.getName() }">
	  </div>
	  <div class="form-group col-md-6">
	    <label for="line1">Line 1:</label>
	    <input type="text" class="form-control" name = "line1" id="line1" value="${teacher.getAddress().getLine1() }">
	  </div>
	  	  <div class="form-group col-md-6">
	    <label for="line2">Line 2:</label>
	    <input type="text" class="form-control" name = "line2" id="line2" value="${teacher.getAddress().getLine2() }">
	  </div>
	  	  <div class="form-group col-md-6">
	    <label for="city">City:</label>
	    <input type="text" class="form-control" name = "city" id="city" value="${teacher.getAddress().getCity() }">
	  </div>
	  <div class="form-group col-md-4">
	    <label for="state">State:</label>
	    <input type="text" class="form-control" name = "state" id="state" value="${teacher.getAddress().getState() }">
	  </div>
	  <div class="form-group col-md-2">
	    <label for="pincode">Pin Code:</label>
	    <input type="text" class="form-control" name = "pincode" id="pincode" value="${teacher.getAddress().getPincode() }">
	  </div>
	  
	  <div class="form-group col-md-6">
	    <label for="emailId">Email Id:</label>
	    <input type="text" class="form-control" name = "emailId" id="emailId" value="${teacher.getEmailId() }">
	  </div>
  	  <div class="form-group col-md-6">
	    <label for="phoneNumber">Phone Number:</label>
	    <input type="text" class="form-control" name = "phoneNumber" id="phoneNumber" value="${teacher.getPhoneNumber() }">
	  </div>
	  <button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
<jsp:include page="../footer.jsp"></jsp:include>