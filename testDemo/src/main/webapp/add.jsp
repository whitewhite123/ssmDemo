<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/6/7
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>添加</title>
</head>
<body>

    <%--@elvariable id="users" type="java"--%>
    <form:form action="/add" method="post" modelAttribute="users">
        <form:input path="name" placeholder="名称..."/><br>
        <form:input path="age" placeholder="年龄..."/><br>
        <button type="submit">提交 </button>
    </form:form>

</body>
</html>
