<%--
  Created by IntelliJ IDEA.
  User: 6-126
  Date: 2023/5/3
  Time: 01:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <a href="/file/add">上传文件</a>
    </div>
    <div class="flex-item">
        <a href="/file">文件列表</a>
    </div>
    <div class="flex-item">
        <a href="/file/download">下载文件</a>
    </div>
    <div class="flex-item">
        删除文件
    </div>
</div>
<h1 style="color: red; text-align: center">${msg}</h1>
<form method="get" action="/file/handleDelete">
    <table style="margin: auto">
        <tr>
            <td>删除文件：</td>
            <td>
                <input type="text" name="title" required />
            </td>
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