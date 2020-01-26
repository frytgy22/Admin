package org.lebedeva.servlet;

import org.lebedeva.Check;
import org.lebedeva.dao.modelDao.AdminDao;
import org.lebedeva.dao.modelDao.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/")
public class AuthorizationServlet extends HttpServlet {
    TeacherDao teacherDao;
    AdminDao adminDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/authorization.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            adminDao = new AdminDao(req.getServletContext());
            teacherDao = new TeacherDao(req.getServletContext());

            if (teacherDao != null && adminDao != null) {

                if (Check.checkParameter(req.getParameter("login")) && Check.checkParameter(req.getParameter("password"))) {
                    final String LOGIN = req.getParameter("login");
                    final String PASSWORD = req.getParameter("password");

                    if (adminDao.findAll().stream()
                            .anyMatch(admin -> LOGIN.equals(admin.getLogin()) && PASSWORD.equals(admin.getPassword())
                                    && adminDao.getRoles(admin.getId()).contains("ADMIN")) ||
                            teacherDao.findAll().stream()
                                    .anyMatch(teacher -> LOGIN.equals(teacher.getLogin()) && PASSWORD.equals(teacher.getPassword())
                                            && teacherDao.getRoles(teacher.getId()).contains("ADMIN"))) {
                        resp.sendRedirect(req.getContextPath() + "/main");
                    } else {
                        resp.getWriter().write("no");
                    }
                } else {
                    resp.getWriter().write("Wrong data: empty field");
                }
                //TODO fix message
            } else {
                resp.getWriter().write("404");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
