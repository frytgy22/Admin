package org.lebedeva.servlet.teacher;

import org.lebedeva.Check;
import org.lebedeva.dao.modelDao.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/delete_teacher")
public class DeleteTeacherServlet extends HttpServlet {
    TeacherDao teacherDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/teacher/teachers.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            teacherDao = new TeacherDao(req.getServletContext());
            if (Check.checkParameter(req.getParameter("id"))) {

                Integer id = Integer.valueOf(req.getParameter("id").trim());
                teacherDao.delete(id);
                resp.sendRedirect(req.getContextPath()+"/teachers");
            }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
            resp.getWriter().write("Wrong data.");
        }
    }
}
