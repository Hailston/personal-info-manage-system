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
        <a href="/friend/add">增加联系人</a>
    </div>
    <div class="flex-item">
        <a href="/friend">查看通信录</a>
    </div>
    <div class="flex-item">
        修改联系人
    </div>
    <div class="flex-item">
        <a href="/friend/delete">删除联系人</a>
    </div>
</div>
<h1 style="color: red; text-align: center">${msg}</h1>
    <form method="get" action="/friend/edit">
        <table style="margin: auto">
            <tr>
                <td style="text-align: center">
                    <br /><br />
                    请输入要修改人的姓名 <br />
                    姓名 <input type="text" name="name" required />
                    <br /><br />
                </td>
            </tr>
            <tr>
                <td style="text-align: center">
                    <input type="submit" value="确定">
                    <input type="reset" value="清除">
                </td>
            </tr>
        </table>
    </form>


<script src="../public/js/bootstrap.bundle.min.js"></script>
</body>
</html>
