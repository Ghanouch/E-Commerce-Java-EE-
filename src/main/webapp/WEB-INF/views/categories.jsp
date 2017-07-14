<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TEST</title>
</head>
<body>
	<div id="form">
		<f:form modelAttribute="categorie" action="saveCat" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>NOM CATEGORIE</td>
					<td><f:input path="nomCategorie"/></td>
					<td><f:errors path="nomCategorie" cssClass="errors"></f:errors></td>
				</tr>
				<tr>
					<td>DESCRPTION CAT</td>
					<td><f:textarea path="description"/></td>
					<td><f:errors path="description" cssClass="errors"></f:errors></td>
				</tr>
				<tr>
					<td>PHOTO CAT</td>
					<td><input type="file" name="file" /></td>
					<td></td>
				</tr>
				<tr>
					<td><input type="submit" value="Valider" /></td>
				</tr>
			</table>
		</f:form>
	</div>
	
	<div id="table">
	<table>
		<tr>
			<th>ID</th><th>NOM CAT</th><th>DESCRIPTION</th><th>PHOTO</th>
		</tr>
			<c:forEach items="${categories}" var="categorie"> 
				<tr>
				 <td>${categorie.idCategorie}</td>
				 <td>${categorie.nomCategorie}</td>
				 <td>${categorie.description}</td>
				 <td></td>
				</tr>
		</c:forEach>
	</table>
	
	</div>
</body>
</html>