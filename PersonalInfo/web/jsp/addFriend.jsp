<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 6-126
  Date: 2023/4/30
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息管理系统--主页面</title>
    <link href="../public/css/bootstrap.min.css" rel="stylesheet" />
    <style>
        body {
            height: 100vh;
            background-color: #cccfff;
        }
        td {
            border: 1px solid white;
        }
        table {
            width: 350px;
            /*background-color: rgb(149, 189, 255);*/
        }
        .flex-container {
            border-top: 2px solid #aeaba1;
            border-bottom: 2px solid #aeaba1;
            display: flex;
            justify-content: space-around;
            width: 700px;
            margin: 20px auto;
        }
    </style>
</head>

<body>
<jsp:include page="header.jsp" />
<div class="flex-container">
    <div class="flex-item">
        增加联系人
    </div>
    <div class="flex-item">
        <a href="/friend">查看通信录</a>
    </div>
    <div class="flex-item">
        <a href="/friend/edit">修改联系人</a>
    </div>
    <div class="flex-item">
        <a href="/friend/delete">删除联系人</a>
    </div>
</div>
<h1 style="color: red; text-align: center">${msg}</h1>
<form method="post" action="/friend/handleAdd">
    <table style="margin: auto">
        <tr>
            <td>用户姓名</td>
            <td><input name="name" type="text" required /></td>
        </tr>
        <tr>
            <td>用户电话</td>
            <td><input name="phone" type="text" pattern="1[3-9]\d{9}" required /></td>
        </tr>
        <tr>
            <td>邮箱地址</td>
            <td><input name="email" type="email" required /></td>
        </tr>
        <tr>
            <td>工作单位</td>
            <td><input name="workplace" type="text" required /></td>
        </tr>
        <tr>
            <td>家庭住址</td>
            <td>
                <select name="place">
                    <c:forEach items="${provinces}" var="item">
                        <option value="${item}">${item}</option>
                    </c:forEach>
                </select>
                省（直辖市）
            </td>
        </tr>
        <tr>
            <td>用户QQ</td>
            <td><input name="QQ" type="text" required /></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center">
                <input type="submit" value="确定">
                <input type="reset" value="清除">
            </td>
        </tr>
    </table>
</form>
<script src="../public/js/bootstrap.bundle.min.js"></script>
</body>
</html>
