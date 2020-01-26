package org.lebedeva.servlet;

import org.lebedeva.dao.modelDao.TeacherDao;
import org.lebedeva.model.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/groups")
public class GroupsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            TeacherDao teacherDao=new TeacherDao(req.getServletContext());
            List<Group>list=teacherDao.getGroups(1);
            resp.getWriter().write(list.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
