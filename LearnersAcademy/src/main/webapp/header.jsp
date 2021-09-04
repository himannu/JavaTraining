    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="Errorhandler.jsp" %>
    
	<!DOCTYPE html>
	<html>
		<head>
		<meta charset="utf-8">
		 <meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
		
		<title>Learners Academy</title>
	</head>
	<body>

			
		<nav class="navbar navbar-default navbar-light navbar-expand-sm" style="background-color: #e3f2fd;">
			<h5>Learners Academy-Online School Management System</h5>
			
		      <ul class="nav navbar-nav navbar-center">
		      	<li><a class = "navbarbrand" href="/<%=application.getInitParameter("applicationName")%>/index.jsp"><span class="glyphicon glyphicon-home">HOME</span></a></li>
		        <li><a href="/<%=application.getInitParameter("applicationName")%>/classes/listClasses"><span class="glyphicon glyphicon-tasks">CLASSES</span></a></li>
		        <li><a href="/<%=application.getInitParameter("applicationName")%>/subjects/listSubjects"><span class="glyphicon glyphicon-book">SUBJECTS</span></a></li>
		        <li><a href="/<%=application.getInitParameter("applicationName")%>/teachers/listTeachers"><span class="glyphicon glyphicon-user"></span>TEACHERS</a></li>
		      </ul>
		</nav>