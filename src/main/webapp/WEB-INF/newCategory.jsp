<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Category</title>
</head>
<body>
	<div class="header">
		<a href="/">Home</a>
		<h1>Add Category</h1>
	</div>
	<div class="content">
		<form:form action="/categories/new" modelAttribute="category" method="POST">
			<form:label path="name">Name: 
			<form:errors path="name" />
			<form:input path="name" /></form:label>
			
			<input type="submit" value="Add Category" />
		</form:form>
		
	</div>
</body>
</html>