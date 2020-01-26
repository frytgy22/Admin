package org.lebedeva.dao.modelDao;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.lebedeva.dao.GenericDao;
import org.lebedeva.model.user.Admin;

import javax.servlet.ServletContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao extends GenericDao<Admin> {

    private static final String INSERT = "INSERT INTO Admins(login, password, name, phone) VALUES(?, ?, ?, ?)";
    private static final String SELECT = "SELECT adminID, login, password, name, phone FROM Admins";
    private static final String UPDATE = "UPDATE Admins SET login = ?, password = ?, name = ?, phone = ? WHERE adminID = ?";
    private static final String DELETE = "DELETE FROM Admins WHERE adminID = ? ";
    private static final String GET_ROLES ="SELECT role FROM Roles " +
            "INNER JOIN RolesAdmins ON RolesAdmins.roleID = Roles.roleID " +
            "INNER JOIN Admins ON RolesAdmins.adminID = Admins.adminID WHERE Admins.adminID = ?";

    public AdminDao(ServletContext servletContext) throws SQLException {
        super(servletContext);
    }

    @Override
    public void save(Admin data) throws SQLException {
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
    public List<Admin> findAll() throws SQLException {
        List<Admin> admins = new ArrayList<>();
        try {
            startTransaction();
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
            @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                admins.add(Admin.builder()
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
        return admins;
    }

    @Override
    public void update(Integer id, Admin set) throws SQLException {
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
}
