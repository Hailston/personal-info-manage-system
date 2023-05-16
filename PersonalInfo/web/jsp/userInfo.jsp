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
            width: 500px;
            background-color: rgb(149, 189, 255);
        }
        .flex-container {
            border-top: 2px solid #aeaba1;
            border-bottom: 2px solid #aeaba1;
            display: flex;
            justify-content: space-around;
            width: 500px;
            margin: 20px auto;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp" />
    <div class="flex-container">
        <div class="flex-item">
            <a href="/userInfo/edit">修改个人信息</a>
        </div>
        <div class="flex-item">
            查看个人信息
        </div>
        <div class="flex-item">
            <a href="/userInfo/editPassword">修改密码</a>
        </div>
    </div>
    <table style="margin: auto">
        <tr>
            <td>用户姓名</td>
            <td>${sessionScope.user.name}</td>
        </tr>
        <tr>
            <td>用户性别</td>
            <td>${sessionScope.user.sex}</td>
        </tr>
        <tr>
            <td>出生日期</td>
            <td>${sessionScope.user.birth}</td>
        </tr>
        <tr>
            <td>用户民族</td>
            <td>${sessionScope.user.nation}</td>
        </tr>
        <tr>
            <td>用户学历</td>
            <td>${sessionScope.user.edu}</td>
        </tr>
        <tr>
            <td>用户职称</td>
            <td>${sessionScope.user.work}</td>
        </tr>
        <tr>
            <td>用户电话</td>
            <td>${sessionScope.user.phone}</td>
        </tr>
        <tr>
            <td>家庭住址</td>
            <td>${sessionScope.user.place}</td>
        </tr>
        <tr>
            <td>邮箱地址</td>
            <td>${sessionScope.user.email}</td>
        </tr>
    </table>
<script src="../public/js/bootstrap.bundle.min.js"></script>
</body>
</html>
