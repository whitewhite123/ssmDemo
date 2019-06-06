<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/6/6
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="/update">
        <input name="id" type="hidden" value="${user.id}">
        <input name="name" type="text" value="${user.name}" placeholder="输入名字"><br>
        <input name="age" type="text"  value="${user.age}" placeholder="输入年龄"><br>
        <input type="submit" value="提交">
    </form>

</body>
</html>
