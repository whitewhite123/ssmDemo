<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/6/4
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新</title>
</head>
<body>
    <form action="/update" method="post">
        <input type="hidden" name="id" value="${user.id}">
        姓名：<input name="name" type="text" value="${user.name}"><br>
        年龄：<input name="age" type="text" value="${user.age}"><br>
        <input type="submit" value="提交">
    </form>

</body>
</html>
