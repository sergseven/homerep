<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
 <title>Список клиентов</title>
</head>
<body>
<h4> Добро пожаловать! </h4>


Тут будет просмотр всех клиентов.<br>
<br>


<table border="1">
  <tr><th>ID</th><th>имя</th><th>ДР</th><th>Пол</th><th>Телефон</th><th>Адрес</th><th>Машин</th></tr>
	<c:forEach var="listValue" items="${clients}">
	  <tr>
	    <td>${listValue.getClientId()}</td>
	    <td>${listValue.getName()}</td>
	    <td>${listValue.getBirthdate()}</td>
	    <td>${listValue.getSex()}</td>
	    <td>${listValue.getPhone()}</td>
	    <td>${listValue.getAddress()}</td>
	    <td>${listValue.getAutos().size()}</td>
	  </tr>
	</c:forEach>  
  
</table>

 
</body>
</html>