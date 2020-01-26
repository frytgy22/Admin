<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/head.jsp" %>

<form class="mui-form padding" action="<%=request.getContextPath()%>/"  method="post">
    <legend class="center">Login</legend>
    <div class="mui-textfield">
        <input   autofocus required name="login" maxlength="20"><label>Login</label>
    </div>
<%--    TODO fix type="email"--%>
    <div class="mui-textfield">
        <input required type="password" name="password" maxlength="20"><label>Password</label>
    </div>
    <div id="content-wrapper" class="mui--text-center">
    <button id="button" type="submit" class="mui-btn mui-btn--raised">Submit</button>
    </div>
</form>

<%@include file="template/footer.jsp" %>