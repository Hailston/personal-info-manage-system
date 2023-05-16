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
        <a href="/date/add">增加日程</a>
    </div>
    <div class="flex-item">
        查看日程
    </div>
    <div class="flex-item">
        <a href="/date/edit">修改日程</a>
    </div>
    <div class="flex-item">
        <a href="/date/delete">删除日程</a>
    </div>
</div>
<table style="margin: auto">
    <tr>
        <th>日程时间</th>
        <th>日程内容</th>
    </tr>
    <c:forEach items="${pageInfo.list}" var="item">
        <tr>
            <td>${item.date}</td>
            <td>${item.thing}</td>
        </tr>
    </c:forEach>
</table>
<div class="page-footer">
    <c:if test="${pageInfo.hasPreviousPage}">
        <a href="/date?pageNum=${pageInfo.prePage}">上一页</a>
    </c:if>
    <c:forEach items="${pageInfo.navigatepageNums}" var="item">

        <a href="/date?pageNum=${item}" <c:if test="${item == pageInfo.pageNum}">style="pointer-events:none"</c:if> >${item}</a>
    </c:forEach>
    <c:if test="${pageInfo.hasNextPage}">
        <a href="/date?pageNum=${pageInfo.nextPage}">下一页</a>
    </c:if>
</div>
<script src="../public/js/bootstrap.bundle.min.js"></script>
</body>
</html>