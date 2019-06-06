<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/6/6
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查看</title>
</head>
<body>
    <a href="pages/add.jsp">添加信息</a>
    <table border="1" cellpadding="0" cellspacing="0">
        <tr>
            <td>id</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${users}" var="i">
            <tr>
                <td>${i.id}</td>
                <td>${i.name}</td>
                <td>${i.age}</td>
                <td>
                    <a href="/delete?id=${i.id}">删除</a>
                    <a href="/update?id=${i.id}">更新</a>
                </td>
            </tr>
        </c:forEach>


    </table>

</body>
</html>
