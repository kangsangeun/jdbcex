<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023-11-10
  Time: 오후 12:40
  To change this template use File | Settings | File Templates.
--%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo List</title>
</head>
<body>
<h1>Todo List</h1>
<ul>
    <c:forEach items="${dtoList}" var="dto">
        <li>
            <span><a href="/jdbcex/todo/read?tno=${dto.tno}">${dto.tno}</a></span>
            <span>${dto.title}</span>
            <span>${dto.dueDate}</span>
            <span>${dto.finished? "DONE": "NOT YET"}</span>
        </li>
    </c:forEach>
</ul>

</body>
</html>
