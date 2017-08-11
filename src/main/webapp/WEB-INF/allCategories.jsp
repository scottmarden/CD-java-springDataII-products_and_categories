<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Categories</title>
</head>
<body>
	<div class="header">
		<a href="/">Home</a>
		<h1>All Categories</h1>
	</div>	
	
	
	<div class="content">
		<ul>
		<c:forEach items="${categories}" var="category"> 
			<li><a href="/categories/${category.id}"><c:out value="${category.name}" /></a> ****  <a href="/categories/delete/${category.id}">Delete</a></li>
		</c:forEach>
		</ul>
	
	</div>
</body>
</html>