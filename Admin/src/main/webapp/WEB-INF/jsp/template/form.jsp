<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="mui-textfield">
    <input id="nameF" autofocus required name="name" maxlength="100"><label>Full name</label>
</div>
<div class="mui-textfield">
    <input id="phoneF" autofocus name="phone" maxlength="20"><label>Phone</label>
</div>

<div class="mui-dropdown">
    <button class="mui-btn mui-btn--primary" data-mui-toggle="dropdown">
        Все группы
        <span class="mui-caret"></span>
    </button>
    <ul class="mui-dropdown__menu">
        <li><a href="#"></a></li>
    </ul>
</div>

<div class="mui-checkbox">Roles:
    <label>
        <input name="admin" type="checkbox" value="admin" checked>
        Admin
    </label>
    <label>
        <input name="user" type="checkbox" value="user">
        User
    </label>
</div>
<%--TODO save role in db--%>

<div class="center">
    <button id="button" type="submit" class="mui-btn mui-btn--raised">Submit</button>
</div>

