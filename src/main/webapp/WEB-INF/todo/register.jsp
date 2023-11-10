<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/jdbcex/todo/register" method="post">
    <div>
        <input type="text" name="title" size="30" placeholder="나의 Todo List 제목을 입력하세요">
    </div>
    <div>
        <input type="date" name="dueDate">
    </div>
    <div>
        <p></p>
        <p></p>
        <button type="reset">재설정</button>
        <button type="submit">Todo List 등록하기</button>
    </div>
</form>
</body>
</html>
