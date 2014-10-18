<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
 <title>Клиент</title>
</head>
<body>
<h4> Добро пожаловать! </h4>


Тут будет просмотр/редактор клиента.<br>
<br>
ID - ${client.clientId}
<br>
Имя - ${client.name}.
<br>
Дата рождения - ${client.birthdate}.
<br>
Пол - ${client.sex}.
<br>
Адрес - ${client.address}.

<table border="1">
  <tr><th>ID</th><th>марка</th><th>модель</th></tr>
	<c:forEach var="listValue" items="${autos}">
	  <tr><td>${listValue.getAutoId()}</td><td>${listValue.getMarkName()}</td><td>${listValue.getModelName()}</td></tr>
	</c:forEach>  
  
</table>
 
 
</body>
</html>