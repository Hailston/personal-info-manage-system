<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 6-126
  Date: 2023/4/28
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息管理系统--注册页面</title>
    <style>
        body {
            height: 100vh;
            background-color: #cccfff;
        }
        td {
            border: 1px solid white;
        }
        table {
            width: 385px;
            margin: auto;
            background-color: #aaabbb;
        }
    </style>
</head>
<body>
<h1 style="text-align: center; color: red">请填写以下注册信息</h1>
<form method="post" action="/handleRegister" onsubmit="return checkForm()">
    <table>
        <tr>
            <td>登录名字</td>
            <td><input type="text" id="username" name="username" required></td>
        </tr>
        <tr>
            <td>用户密码</td>
            <td><input type="password" id="password" name="password" required></td>
        </tr>
        <tr>
            <td>重复密码</td>
            <td><input type="password" class="form-control" id="repeatPassword" required></td>
        </tr>
        <tr>
            <td>用户名字</td>
            <td><input type="text" id="name" name="name" required></td>
        </tr>
        <tr>
            <td>用户性别</td>
            <td>
                <input class="form-check-input" type="radio" id="inlineCheckbox1" name="sex" value="男" checked>
                <label class="form-check-label" for="inlineCheckbox1">男</label>
                &nbsp;&nbsp;
                <input class="form-check-input" type="radio" id="inlineCheckbox2" name="sex" value="女">
                <label class="form-check-label" for="inlineCheckbox2">女</label>
            </td>
        </tr>
        <tr>
            <td>出生年月</td>
            <td><input type="date" id="birth" name="birth" required></td>
        </tr>
        <tr>
            <td>用户名族</td>
            <td>
                <input class="form-check-input" type="radio" id="inlineCheckbox3" name="nation" value="汉族" checked>
                <label class="form-check-label" for="inlineCheckbox3">汉族</label>
                &nbsp;&nbsp;
                <input class="form-check-input" type="radio" id="inlineCheckbox4" name="nation" value="回族">
                <label class="form-check-label" for="inlineCheckbox4">回族</label>
                &nbsp;&nbsp;
                <input class="form-check-input" type="radio" id="inlineCheckbox5" name="nation" value="壮族">
                <label class="form-check-label" for="inlineCheckbox5">回族</label>
                &nbsp;&nbsp;
                <input class="form-check-input" type="radio" id="inlineCheckbox6" name="nation" value="其它">
                <label class="form-check-label" for="inlineCheckbox6">其它</label>
            </td>
        </tr>
        <tr>
            <td>用户学历</td>
            <td>
                <select id="edu" name="edu" class="form-control">
                    <option selected value="博士">博士</option>
                    <option value="硕士">硕士</option>
                    <option value="本科">本科</option>
                    <option value="专科">专科</option>
                    <option value="高中">高中</option>
                    <option value="初中">初中</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>用户职称</td>
            <td>
                <select id="work" name="work" class="form-control">
                    <option selected value="软件开发工程师">软件开发工程师</option>
                    <option value="前端开发工程师">前端开发工程师</option>
                    <option value="后端开发工程师">后端开发工程师</option>
                    <option value="全栈开发工程师">全栈开发工程师</option>
                    <option value="码农">码农</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>用户电话</td>
            <td>
                <input type="text" id="phone" name="phone" pattern="1[3-9]\d{9}" required>
            </td>
        </tr>
        <tr>
            <td>家庭住址</td>
            <td>
                <select id="place" name="place" class="form-control">
                    <c:forEach items="${provinces}" var="item">
                        <option value="${item}">${item}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>邮箱地址</td>
            <td>
                <input type="email"  id="email" name="email" required>
            </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center">
                <input type="submit" value="确实">
                <input type="reset" value="清除">
            </td>
        </tr>
    </table>

</form>
<script>
    let dateNow = new Date();
    let yearNow = dateNow.getFullYear();
    let monthNow = dateNow.getMonth() + 1;
    let dayNow = dateNow.getDate();
    let maxDate = yearNow + '-' + (monthNow).toString().padStart(2, '0') + '-' + dayNow.toString().padStart(2, '0');
    let inp = document.querySelector('#birth');
    inp.setAttribute('max', maxDate);
    const checkForm = ()=>{
        const password = document.getElementById('password');
        const repeatPassword = document.getElementById('repeatPassword');
        if (password.value !== repeatPassword.value){
            alert('两次密码不一致！');
            return false;
        }
        return true;
    }
</script>
</body>
</html>
