<%--
  Created by IntelliJ IDEA.
  User: 6-126
  Date: 2023/4/28
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>个人信息管理系统--登录页面</title>
    <style>
        body {
            height: 100vh;
            background-color: #99aadd;
        }
        td {
            border: 1px solid white;
        }
        table {
            width: 350px;
            margin: auto;
            background-color: #95bdff;
        }
    </style>
</head>
<body class="text-center">

    <h1 style="text-align: center">个人信息管理系统</h1>
    <h1 style="color: red; text-align: center">${msg}</h1>
    <form method="post" action="/handleLogin">
        <table>
            <tr>
                <td>
                    <div style="text-align: center">
                        <br />
                        <label for="floatingInput">输入用户姓名：</label>
                        <input type="text" class="form-control" id="floatingInput" name="username" required>
                        <br />
                    </div>
                    <div style="text-align: center">
                        <br />
                        <label for="floatingPassword">输入用户密码：</label>
                        <input type="password" class="form-control" id="floatingPassword" name="password" required>
                        <br />
                        <br />
                    </div>
                </td>
            </tr>
            <tr>
                <td style="text-align: center">
                    <input type="submit" value="登录">
                    <input type="reset" value="清除">
                </td>
            </tr>
            <tr>
                <td style="text-align: center"><a href="/register">注册</a></td>
            </tr>
        </table>
    </form>


</body>
</html>
