package org.lebedeva.servlet.teacher;

import org.lebedeva.Check;
import org.lebedeva.dao.modelDao.TeacherDao;
import org.lebedeva.model.user.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/add_teacher")
public class AddTeacherServlet extends HttpServlet {
    TeacherDao teacherDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/teacher/add_teacher.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            teacherDao = new TeacherDao(req.getServletContext());

            if (teacherDao != null && Check.checkParameter(req.getParameter("login")) && Check.checkParameter("password")
                    && Check.checkParameter("name")) {
                final String LOGIN = req.getParameter("login").trim();
                final String PASSWORD = req.getParameter("password").trim();
                final String NAME = req.getParameter("name").trim();
                final String PHONE = Check.checkParameter(req.getParameter("phone")) ? req.getParameter("phone").trim() : "";

                Teacher teacher = Teacher.builder()
                        .login(LOGIN)
                        .password(PASSWORD)
                        .name(NAME)
                        .phone(PHONE).build();

                teacherDao.save(teacher);
                resp.sendRedirect(req.getContextPath() + "/add_teacher");
            } else {
                resp.getWriter().write("Wrong data");//TODO fix message
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
