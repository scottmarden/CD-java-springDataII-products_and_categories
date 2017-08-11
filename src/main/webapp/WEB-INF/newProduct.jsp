<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Product</title>
</head>
<body>
	<div class="header">
		<a href="/">Home</a>
		<h1>Add a Product</h1>
	</div>
	
	<div class="content">
		<form:form action="/products/new" modelAttribute="product" method="POST">
			<form:label path="name">Name: 
			<form:errors path="name" />
			<form:input path="name" /></form:label>
			
			<form:label path="description">Description: 
			<form:errors path="description" />
			<form:input path="description" /></form:label>
			
			<form:label path="price">Price: 
			<form:errors path="price" />
			<form:input type="step" path="price" /></form:label>
			
			<input type="submit" value="Add Product" />
		</form:form>
	
	</div>
	
	
</body>
</html>