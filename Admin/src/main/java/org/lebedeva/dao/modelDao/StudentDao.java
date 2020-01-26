package org.lebedeva.dao.modelDao;

import lombok.Cleanup;
import org.lebedeva.dao.GenericDao;
import org.lebedeva.model.user.Student;

import javax.servlet.ServletContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao extends GenericDao<Student> {
    private static final String INSERT = "INSERT INTO Admins(login, password, name, phone) VALUES(?, ?, ?, ?)";
    private static final String SELECT = "SELECT adminID, login, password, name, phone FROM Admins";
    private static final String UPDATE = "UPDATE Admins SET login = ?, password = ?, name = ?, phone = ?  WHERE adminID = ?";
    private static final String DELETE = "DELETE FROM Admins WHERE adminID = ? ";

    public StudentDao(ServletContext servletContext) throws SQLException {
        super(servletContext);
    }

    @Override
    public void save(Student data) throws SQLException {
        try {
            startTransaction();
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, data.getLogin());
            preparedStatement.setString(2, data.getPassword());
            preparedStatement.setString(3, data.getName());
            preparedStatement.setString(4, data.getPhone());
            preparedStatement.executeUpdate();
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
            rollback();
        }
    }

    @Override
    public List<Student> findAll() throws SQLException {
        List<Student> students = new ArrayList<>();
        try {
            startTransaction();
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
            @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                students.add(Student.builder()
                        .id(resultSet.getInt("adminID"))
                        .login(resultSet.getString("login"))
                        .password(resultSet.getString("password"))
                        .name(resultSet.getString("name"))
                        .phone(resultSet.getString("phone"))
                        .build());
            }
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
            rollback();
        }
        return students;
    }

    @Override
    public void update(Integer id, Student set) throws SQLException {
        try {
            startTransaction();
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, set.getLogin());
            preparedStatement.setString(2, set.getPassword());
            preparedStatement.setString(3, set.getName());
            preparedStatement.setString(4, set.getPhone());
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
            rollback();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try {
            startTransaction();
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
            rollback();
        }
    }

    public List<String> getRoles(Integer id) throws SQLException {
        return null;
    }


}

