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
            width: 700px;
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
            <a href="/friend/add">增加联系人</a>
        </div>
        <div class="flex-item">
            查看通信录
        </div>
        <div class="flex-item">
            <a href="/friend/edit">修改联系人</a>
        </div>
        <div class="flex-item">
            <a href="/friend/delete">删除联系人</a>
        </div>
    </div>
    <table style="margin: auto">
        <tr>
            <th>用户姓名</th>
            <th>用户电话</th>
            <th>邮箱地址</th>
            <th>工作单位</th>
            <th>家庭住址</th>
            <th>用户QQ</th>
        </tr>
        <c:forEach items="${pageInfo.list}" var="item">
            <tr>
                <td>${item.name}</td>
                <td>${item.phone}</td>
                <td>${item.email}</td>
                <td>${item.workplace}</td>
                <td>${item.place}</td>
                <td>${item.QQ}</td>
            </tr>
        </c:forEach>
    </table>
    <div class="page-footer">
        <c:if test="${pageInfo.hasPreviousPage}">
            <a href="/friend?pageNum=${pageInfo.prePage}">上一页</a>
        </c:if>
        <c:forEach items="${pageInfo.navigatepageNums}" var="item">
<%--            <c:if test="${item == pageInfo.pageNum}">--%>
<%--                --%>
<%--            </c:if>--%>
            <a href="/friend?pageNum=${item}">${item}</a>
        </c:forEach>
        <c:if test="${pageInfo.hasNextPage}">
            <a href="/friend?pageNum=${pageInfo.nextPage}">下一页</a>
        </c:if>
    </div>
<script src="../public/js/bootstrap.bundle.min.js"></script>
</body>
</html>
