<%--
  Created by IntelliJ IDEA.
  User: 6-126
  Date: 2023/4/30
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>个人信息管理系统--主页面</title>
    <link href="../public/css/bootstrap.min.css" rel="stylesheet"/>
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
<jsp:include page="header.jsp"/>
<div class="flex-container">
    <div class="flex-item">
        <a href="/userInfo/edit">修改个人信息</a>
    </div>
    <div class="flex-item">
        <a href="/userInfo">查看个人信息</a>
    </div>
    <div class="flex-item">
        修改密码
    </div>
</div>
<h1 style="text-align: center; color: red">${msg}</h1>
<form action="/userInfo/handleEditPassword" method="post" onsubmit="return checkForm()">
    <table style="margin: auto">
        <tr>
            <td>用户密码</td>
            <td><input type="password" id="password" name="password" required/></td>
        </tr>
        <tr>
            <td>重复密码</td>
            <td><input type="password" id="repeatPassword" name="repeatPassword" required /></td>
        </tr>

        <tr>
            <td colspan="2" style="text-align: center">
                <input type="submit" value="确实">
                <input type="reset"  value="清除">
            </td>
        </tr>
    </table>
</form>
<script src="../public/js/bootstrap.bundle.min.js"></script>
<script>
    const checkForm = ()=>{
        const password = document.getElementById('password').value;
        const repeatPassword = document.getElementById('repeatPassword').value;
        if (password !== repeatPassword){
            alert('两次密码不一致！');
            return false;
        }
        return true;
    }
</script>
</body>
</html>