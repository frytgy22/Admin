<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../template/head.jsp" %>

<form class="mui-form padding top" action="<%=request.getContextPath()%>/add_teacher" method="post">
    <legend class="center">Add teacher</legend>
    <div class="mui-textfield">
        <input type="email" autofocus required name="login" maxlength="20"><label>Login</label>
    </div>
    <div class="mui-textfield">
        <input required type="password" name="password" maxlength="20"><label>Password</label>
    </div>
    <div class="mui-textfield">
        <input autofocus required name="name" maxlength="100"><label>Full name</label>
    </div>
    <div class="mui-textfield">
        <input autofocus name="phone" maxlength="20"><label>Phone</label>
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

    <div id="content-wrapper" class="mui--text-center">
        <button id="button" type="submit" class="mui-btn mui-btn--raised">Submit</button>
    </div>
    <%--            TODO fix button move--%>
</form>
</div>
</div>

<%@include file="../template/footer.jsp" %>