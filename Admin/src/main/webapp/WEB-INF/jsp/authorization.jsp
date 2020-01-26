<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="//cdn.muicss.com/mui-0.10.0/css/mui.min.css" rel="stylesheet" type="text/css"/>
    <script src="//cdn.muicss.com/mui-0.10.0/js/mui.min.js"></script>
    <link href="<%=request.getContextPath()%>/static/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<header class="mui-appbar mui--z1">
    <!-- Appbar HTML goes here -->
    <div class="mui-container">
        <table>
            <tr class="mui--appbar-height">
                <td class="mui--text-title">Admin</td>
                <td class="mui--text-right">
                    <ul class="mui-list--inline mui--text-body2">
                        <li><a href="<%=request.getContextPath()%>/">Home</a></li>
                    </ul>
                </td>
            </tr>
        </table>
    </div>
</header>

<form class="mui-form padding top" action="<%=request.getContextPath()%>/" method="post">
    <legend class="mui--text-center">Login</legend>
    <div class="mui-textfield">
        <input autofocus required name="login" maxlength="20"><label>Login</label>
    </div>
    <%--    TODO fix type="email"--%>
    <div class="mui-textfield">
        <input required type="password" name="password" maxlength="20"><label>Password</label>
    </div>
    <div id="content-wrapper" class="mui--text-center">
        <button id="button" type="submit" class="mui-btn mui-btn--raised">Submit</button>
    </div>
</form>

<footer>
    <div class="mui-container mui--text-center">
        Made with ♥ by <a href="https://www.muicss.com">MUICSS</a>
    </div>
</footer>

</body>
</html>
