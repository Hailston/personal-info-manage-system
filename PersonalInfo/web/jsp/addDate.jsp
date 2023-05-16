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
        }
        .flex-container {
            border-top: 2px solid #aeaba1;
            border-bottom: 2px solid #aeaba1;
            display: flex;
            justify-content: space-around;
            width: 700px;
            margin: 20px auto;
        }
        .page-footer {
            text-align: center;
        }
    </style>
</head>

<body>
<jsp:include page="header.jsp" />
<div class="flex-container">
    <div class="flex-item">
        增加日程
    </div>
    <div class="flex-item">
        <a href="/date">查看日程</a>
    </div>
    <div class="flex-item">
        <a href="/date/edit">修改日程</a>
    </div>
    <div class="flex-item">
        <a href="/date/delete">删除日程</a>
    </div>
</div>
<h1 style="color: red; text-align: center">${msg}</h1>
<form method="post" action="/date/handleAdd">
    <table style="margin: auto">
        <tr>
            <td>日程时间</td>
            <td><input type="date" name="date" required/></td>
        </tr>
        <tr>
            <td>日程内容</td>
            <td><input type="text" name="thing" required/></td>
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
<script>
    let dateNow = new Date();
    let yearNow = dateNow.getFullYear();
    let monthNow = dateNow.getMonth() + 1;
    let dayNow = dateNow.getDate();
    let maxDate = yearNow + '-' + (monthNow).toString().padStart(2, '0') + '-' + dayNow.toString().padStart(2, '0');
    let inp = document.querySelector('input[type="date"]');
    inp.setAttribute('min', maxDate);
</script>
</body>
</html>