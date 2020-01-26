<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="org.lebedeva.dao.modelDao.TeacherDao" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="org.lebedeva.model.user.Teacher" %>
<%@ page import="java.util.List" %>
<%@ page import="org.lebedeva.model.Group" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../template/head.jsp" %>

<script src="<%=request.getContextPath()%>../static/js/main.js"></script>

<table id="table" class="mui-table mui-table--bordered padding top">
    <thead>
    <tr>
        <th class="hidden"></th>
        <th>ФИО</th>
        <th>Контакты</th>
        <th>Группы</th>
        <th>Роль</th>
        <th></th>
    </tr>
    </thead>
    <tbody>

    <% try {
        TeacherDao teacherDao = new TeacherDao(request.getServletContext());

        List<Teacher> teachers = teacherDao.findAll();
        if (teachers != null) {
            for (Teacher teacher : teachers) {
                List<Group> groups = teacherDao.getGroups(teacher.getId());
                List<String> roles = teacherDao.getRoles(teacher.getId());%>

    <tr>
        <td class="hidden"><%=teacher.getId()%>
        </td>
        <td><%=teacher.getName()%>
        </td>
        <td><%=teacher.getPhone()%>
        </td>
        <td>
            <div class="mui-dropdown">
                <button class="mui-btn mui-btn--primary" data-mui-toggle="dropdown">
                    Все группы
                    <span class="mui-caret"></span>
                </button>
                <ul class="mui-dropdown__menu">
                    <%
                        if (groups != null) {
                            for (Group group : groups) {
                    %>
                    <li><a href="#"><%=group.getName()%>
                    </a></li>

                    <%
                            }
                        }
                    %>
                </ul>
            </div>
        </td>
        <td>
            <%=roles.toString()%>
        </td>
        <td>
            <button name="edit" class="mui-btn mui-btn--small mui-btn--primary">редактировать</button>
            <button name="delete" class="mui-btn mui-btn--small mui-btn--danger">удалить</button>
        </td>
    </tr>

    <%
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    %>

    </tbody>
</table>

<form class="mui-form padding" id="edit" action="<%=request.getContextPath()%>/edit_teacher" method="post">
    <legend id="info"></legend>
    <input type="hidden" name="id">
    <%@include file="../template/form.jsp" %>
    <button type="button" class="mui-btn mui-btn--flat mui-btn--danger"
            onclick="location.href='<%=request.getContextPath()%>/index'">cancel
    </button>
</form>

<form id="delete" action="<%=request.getContextPath()%>/delete_teacher" method="post">
    <input type="hidden" name="id">
</form>

<%@include file="../template/footer.jsp" %>
