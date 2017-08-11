<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Products</title>
</head>
<body>
	<div class="header">
		<a href="/">Home</a>
		<h1>All Products</h1>
	</div>	
	
	
	<div class="content">
		<ul>
		<c:forEach items="${products}" var="product"> 
			<li><a href="/products/${product.id}"><c:out value="${product.name}" /></a> ****  <a href="/products/delete/${product.id}">Delete</a></li>
		</c:forEach>
		</ul>
	
	</div>
</body>
</html>