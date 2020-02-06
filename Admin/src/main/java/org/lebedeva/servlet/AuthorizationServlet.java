package org.lebedeva.servlet;

import org.lebedeva.Check;
import org.lebedeva.dao.modelDao.AdminDao;
import org.lebedeva.dao.modelDao.TeacherDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/")
public class AuthorizationServlet extends HttpServlet {
    TeacherDao teacherDao;
    AdminDao adminDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null) {
            resp.sendRedirect(req.getContextPath() + "/main");
        } else {
            req.getRequestDispatcher("/WEB-INF/jsp/authorization.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/authorization.jsp");
        System.out.println(Check.getTegError("Wrong login or password."));
        try {
            adminDao = new AdminDao(req.getServletContext());
            teacherDao = new TeacherDao(req.getServletContext());

            if (teacherDao != null && adminDao != null) {

                if (Check.checkParameter(req.getParameter("login")) && Check.checkParameter(req.getParameter("password"))) {
                    final String LOGIN = req.getParameter("login").trim();
                    final String PASSWORD = req.getParameter("password").trim();

                    //TODO если права админа могут быть у преподавателя и админа, искать в 2-х таблицах??

                    if (adminDao.findAll().stream()
                            .anyMatch(admin -> LOGIN.equals(admin.getLogin()) && PASSWORD.equals(admin.getPassword())
                                    && adminDao.getRoles(admin.getId()).contains("ADMIN")) ||
                            teacherDao.findAll().stream()
                                    .anyMatch(teacher -> LOGIN.equals(teacher.getLogin()) && PASSWORD.equals(teacher.getPassword())
                                            && teacherDao.getRoles(teacher.getId()).contains("ADMIN"))) {

                        HttpSession session = req.getSession();
                        session.setAttribute("user", LOGIN);

                        resp.sendRedirect(req.getContextPath() + "/main");

                    } else {
                        resp.getWriter().write(Check.getTegError("Wrong login or password."));
                    }
                } else {
                    resp.getWriter().write(Check.getTegError("Wrong data: empty field."));
                }
            } else {
                resp.getWriter().write(Check.getTegError("Server error"));
            }
        } catch (SQLException e) {
            resp.getWriter().write(Check.getTegError("Server error"));
            e.printStackTrace();
        }
        dispatcher.include(req, resp);
    }
}
