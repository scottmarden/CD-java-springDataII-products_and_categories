<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Category Detail</title>
</head>
<body>
	<div class="header">
		<a href="/">Home</a>
		<h1><c:out value="${category.name}"/></h1>
	</div>
	
	<div class="content">
		<h4><c:out value="${Category.name}" /></h4>
		<h4>Products</h4>
		<ul>
			<c:forEach items="${category.products}" var="product">
				<li><c:out value="${product.name}"/></li>
			</c:forEach>
		</ul>
	</div>
	<div class="subContent">
		<form:form action="/categories/${category.id}/add_product" modelAttribute="newProduct" method="POST">
			<form:label path="id">Add Product: 
			<form:errors path="id"/>
			<form:select path="id">
				<c:forEach items="${availProducts}" var="availProduct">
						<form:option value="${availProduct.id}" label="${availProduct.name}"/>
				</c:forEach>
			</form:select></form:label>
			
			<input type="submit" value="Add" />
		</form:form>
	</div>
</body>
</html>