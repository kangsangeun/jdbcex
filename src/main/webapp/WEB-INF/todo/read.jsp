<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Read</title>
</head>
<body>
<div>
    <input type="text" name="tno" value="${dto.tno}" readonly>
</div>
<div>
    <input type="text" name="title" value="${dto.title}" readonly>
</div>
<div>
    <input type="date" name="dueDate" value="${dto.dueDate}">
</div>
<div>
    <input type="checkbox" name="finished" ${dto.finished ? "checked": ""} readonly >
</div>
<div>
    <a href="/jdbcex/todo/modify?tno=${dto.tno}">이대로 수정하기</a><br>
    <a href="/jdbcex/todo/list">전체 List로 돌아가기</a>
</div>
</body>
</html>
