package org.lebedeva.dao;

import org.lebedeva.configuration.DbConfiguration;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;

public abstract class GenericDao<T> {
    protected Connection connection;

    public GenericDao(ServletContext servletContext) throws SQLException {
        DbConfiguration db = (DbConfiguration) servletContext.getAttribute("dbConfig");
        connection = db.getConnection();
        DatabaseMetaData data = connection.getMetaData();

        if (data.supportsTransactionIsolationLevel(Connection.TRANSACTION_REPEATABLE_READ)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        }
    }

    protected void startTransaction() throws SQLException {
        connection.setAutoCommit(false);
    }

    protected void commit() throws SQLException {
        connection.commit();
        connection.setAutoCommit(true);
    }

    protected void rollback() throws SQLException {
        connection.rollback();
        connection.setAutoCommit(true);
    }

    public abstract void save(T data) throws SQLException;

    public abstract List<T> findAll() throws SQLException;

    public abstract void update(Integer id, T set) throws SQLException;

    public abstract void delete(Integer id) throws SQLException;
}
