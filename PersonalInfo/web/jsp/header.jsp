<%--
  Created by IntelliJ IDEA.
  User: 6-126
  Date: 2023/4/29
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/userInfo">个人信息管理</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/friend">通讯录管理</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/date">日程安排管理</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/file">个人文件管理</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logout">退出主页面</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled">欢迎，${sessionScope.user.name}登录系统</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
