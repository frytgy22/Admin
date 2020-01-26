<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/static/images/icon/5.png" type="image/png">
    <link href="//cdn.muicss.com/mui-latest/css/mui.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/static/css/home.css" rel="stylesheet" type="text/css" />
    <script src="//cdn.muicss.com/mui-latest/js/mui.min.js"></script>
    <script src="//code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="<%=request.getContextPath()%>/static/js/script.js"></script>
    <title>Admin</title>
</head>
<body>
<div id="sidedrawer" class="mui--no-user-select">
    <div id="sidedrawer-brand" class="mui--appbar-line-height">
        <span class="mui--text-title">Admin</span>
    </div>
    <div class="mui-divider"></div>
    <ul>
        <li>
            <strong>Преподаватели</strong>
            <ul>
                <li><a href="<%=request.getContextPath()%>/teachers">Все преподаватели</a></li>
                <li><a href="#">Добавить преподавателя</a></li>
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
    <div class="mui-appbar mui--appbar-line-height">
        <div class="mui-container-fluid">
            <a class="sidedrawer-toggle mui--visible-xs-inline-block mui--visible-sm-inline-block js-show-sidedrawer">☰</a>
            <a class="sidedrawer-toggle mui--hidden-xs mui--hidden-sm js-hide-sidedrawer">☰</a>
            <span class="mui--text-title mui--visible-xs-inline-block mui--visible-sm-inline-block">Brand.io</span>
        </div>
    </div>
</header>
<div id="content-wrapper">
    <div class="mui--appbar-height"></div>
    <div class="mui-container-fluid">
        <br>
        <h1>Brand.io</h1>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris sollicitudin volutpat molestie. Nullam id tempor nulla. Aenean sit amet urna et elit pharetra consequat. Aliquam fringilla tortor vitae lectus tempor, tempor bibendum nunc elementum. Etiam ultrices tristique diam, vitae sodales metus bibendum id. Suspendisse blandit ligula eu fringilla pretium. Mauris dictum gravida tortor eu lacinia. Donec purus purus, ornare sit amet consectetur sed, dictum sit amet ex. Vivamus sit amet imperdiet tellus. Quisque ultrices risus a massa laoreet, vitae tempus sem congue. Maecenas nec eros ut lectus vehicula rutrum. Donec consequat tincidunt arcu non faucibus. Duis elementum, ante venenatis lacinia cursus, turpis massa congue magna, sed dapibus felis nibh sed tellus. Nam consectetur non nibh vitae sodales. Pellentesque malesuada dolor nec mi volutpat, eget vehicula eros ultrices.</p>
        <p>Aenean vehicula tortor a tellus porttitor, id elementum est tincidunt. Etiam varius odio tortor. Praesent vel pulvinar sapien. Praesent ac sodales sem. Phasellus id ultrices massa. Sed id erat sit amet magna accumsan vulputate eu at quam. Etiam feugiat semper imperdiet. Sed a sem vitae massa condimentum vestibulum. In vehicula, quam vel aliquet aliquam, enim elit placerat libero, at pretium nisi lorem in ex. Vestibulum lorem augue, semper a efficitur in, dictum vitae libero. Donec velit est, sollicitudin a volutpat quis, iaculis sit amet metus. Nulla at ante nec dolor euismod mattis cursus eu nisl.</p>
        <p>Quisque interdum facilisis consectetur. Nam eu purus purus. Curabitur in ligula quam. Nam euismod ligula eu tellus pellentesque laoreet. Aliquam erat volutpat. Curabitur eu bibendum velit. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nunc efficitur lorem sit amet quam porta pharetra. Cras ultricies pellentesque eros sit amet semper.</p>
    </div>
</div>
<footer id="footer">
    <div class="mui-container-fluid">
        <br>
        Made with ♥ by <a href="https://www.muicss.com">MUI</a>
    </div>
</footer>
</body>
</html>