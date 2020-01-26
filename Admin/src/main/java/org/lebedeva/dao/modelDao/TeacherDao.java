package org.lebedeva.dao.modelDao;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.lebedeva.dao.GenericDao;
import org.lebedeva.model.Group;
import org.lebedeva.model.user.Teacher;

import javax.servlet.ServletContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao extends GenericDao<Teacher> {

    private static final String INSERT = "INSERT INTO Teachers(login, password, name, phone) VALUES(?, ?, ?, ?)";
    private static final String SELECT = "SELECT teacherID, login, password, name, phone FROM Teachers";
    private static final String UPDATE = "UPDATE Teachers SET login = ?, password = ?, name = ?, phone = ?  WHERE teacherID = ?";
    private static final String DELETE = "DELETE FROM Teachers WHERE teacherID = ?";
    //private static final String FIND_BY_ID = "SELECT login, password, name, phone FROM Teachers WHERE teacherID = ? ";
//    private static final String FIND_BY_LOGIN_AND_PASSWORD = "SELECT teacherID, name, phone FROM Teachers " +
//            "WHERE login = ? AND password = ?";
    private static final String GET_ROLES = "SELECT role FROM Roles " +
            "INNER JOIN RolesTeachers ON RolesTeachers.roleID = Roles.roleID " +
            "INNER JOIN Teachers ON RolesTeachers.teacherID = Teachers.teacherID WHERE Teachers.teacherID = ?";
private  static  final  String GET_GROUPS="SELECT Groups.name FROM Groups " +
        "INNER JOIN GroupsTeachers ON GroupsTeachers.groupID = Groups.groupID " +
        "INNER JOIN Teachers ON Teachers.teacherID = GroupsTeachers.teacherID WHERE Teachers.teacherID = ?";

    public TeacherDao(ServletContext servletContext) throws SQLException {
        super(servletContext);
    }

    @Override
    public void save(Teacher data) throws SQLException {
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
    public List<Teacher> findAll() throws SQLException {
        List<Teacher> teachers = new ArrayList<>();
        try {
            startTransaction();
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
            @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                teachers.add(Teacher.builder()
                        .id(resultSet.getInt("teacherID"))
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
        return teachers;
    }

    @Override
    public void update(Integer id, Teacher set) throws SQLException {
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

//    @Override
//    public Teacher findById(Integer id) throws SQLException {
//        Teacher teacher = null;
//
//        try {
//            startTransaction();
//            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
//            preparedStatement.setInt(1, id);
//            @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                teacher = Teacher.builder()
//                        .id(id)
//                        .login(resultSet.getString("login"))
//                        .password(resultSet.getString("password"))
//                        .name(resultSet.getString("name"))
//                        .phone(resultSet.getString("phone"))
//                        .build();
//            }
//            commit();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            rollback();
//        }
//        return teacher;
//    }


    @SneakyThrows
    public List<String> getRoles(Integer id)  {
        List<String> roles = new ArrayList<>();
        try {
            startTransaction();
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(GET_ROLES);
            preparedStatement.setInt(1, id);
            @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                roles.add(resultSet.getString("role"));
            }
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
            rollback();
        }
        return roles;
    }

    public List<Group> getGroups(Integer id) throws SQLException {
        List<Group> groups = new ArrayList<>();
        try {
            startTransaction();
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(GET_GROUPS);
            preparedStatement.setInt(1, id);
            @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                groups.add(Group.builder()
                        .name(resultSet.getString("name"))
                        .build());
            }
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
            rollback();
        }
        return groups;
    }


//    public Teacher findByLoginAndPassword(String login, String password) throws SQLException {
//        Teacher teacher = null;
//        try {
//            startTransaction();
//            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_LOGIN_AND_PASSWORD);
//            preparedStatement.setString(1, login);
//            preparedStatement.setString(2, password);
//            @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                teacher = Teacher.builder()
//                        .id(resultSet.getInt("teacherID"))
//                        .login(login)
//                        .password(password)
//                        .name(resultSet.getString("name"))
//                        .phone(resultSet.getString("phone"))
//                        .build();
//            }
//            commit();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            rollback();
//        }
//        return teacher;
   // }
}
