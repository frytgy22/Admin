<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="static/images/icon/5.png" type="image/png">
    <link href="//cdn.muicss.com/mui-latest/css/mui.min.css" rel="stylesheet" type="text/css"/>
    <link href="static/css/home.css" rel="stylesheet" type="text/css"/>
    <script src="//cdn.muicss.com/mui-latest/js/mui.min.js"></script>
    <script src="//code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="static/js/script.js"></script>
    <title>Admin</title>
</head>
<body>
<div id="sidedrawer" class="mui--no-user-select">
    <div id="sidedrawer-brand" class="mui--appbar-line-height">
        <h5 class="mui--text-title h5">${sessionScope.user}</h5>
    </div>
    <div class="mui-divider"></div>
    <ul>
        <li>
            <strong>Преподаватели</strong>
            <ul>
                <li><a href="${pageContext.request.contextPath}/teachers">Все преподаватели</a></li>
                <li><a href="${pageContext.request.contextPath}/add_teacher">Добавить преподавателя</a></li>
            </ul>
        </li>
        <li>
            <strong>Группы</strong>
            <ul>
                <li><a href="<%=request.getContextPath()%>/groups">Все группы</a></li>
                <li><a href="#">Добавить группу</a></li>
                <li><a href="#">Добавить студента</a></li>
                <li><a href="#">Добавить предмет</a></li>
            </ul>
        </li>
        <li>
            <strong>Администраторы?</strong>
            <ul>
                <li><a href="#">Все?</a></li>
                <li><a href="#">Добавить?</a></li>
            </ul>
        </li>
    </ul>
</div>
<header id="header">
    <div  class="mui-appbar mui--appbar-line-height head">
        <div  class="mui-container-fluid">
            <a class="sidedrawer-toggle mui--visible-xs-inline-block mui--visible-sm-inline-block js-show-sidedrawer">☰</a>
            <a class="sidedrawer-toggle mui--hidden-xs mui--hidden-sm js-hide-sidedrawer">☰</a>
            <span class="mui--text-title mui--visible-xs-inline-block mui--visible-sm-inline-block">Brand.io</span>
            <button class="mui-btn mui-btn--raised mui--pull-right"
                    onclick="window.location.href='${pageContext.request.contextPath}/logout'">Выход</button>
        </div>
    </div>


</header>
<div id="content-wrapper">
    <div class="mui--appbar-height"></div>
    <div class="mui-container-fluid">
        <br>

<%--    TODO can I do this?
</div> on different page--%>