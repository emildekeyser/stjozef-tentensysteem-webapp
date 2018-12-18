package ucll.project.db;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.List;
import java.util.Properties;

public abstract class SQLDatabase<T extends DatabaseEntity<K>,K> implements IDatabase<T,K>{

    private Class<T> tableClass;
    private Class<K> primaryKeyClass;
    private Properties properties;
    private String tableName;
    private String primaryKeyName;
    String url;

    Connection connection;

    public SQLDatabase(Properties properties, Class<T> tableClass, Class<K> primaryKeyClass, String tableName) throws SQLException {
        this.tableClass = tableClass;
        this.primaryKeyClass = primaryKeyClass;
        this.tableName = tableName;

        this.properties = properties;
        this.url = properties.getProperty("url");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        connection = DriverManager.getConnection(url, properties);
    }

    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean contains(K primaryKey) {
        try {
            String sql = "SELECT COUNT(1) FROM " + tableName + " WHERE " + primaryKeyName + "=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, primaryKey);
            ResultSet result = statement.executeQuery();
            result.next();
            return result.getInt(1)==1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public T get(K primaryKey) {
        try {
            QueryRunner run = new QueryRunner();
            ResultSetHandler<T> h = new BeanHandler<T>(tableClass);
            return run.query(connection,"SELECT * FROM Person WHERE name=?", h, primaryKey);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<T> getAll() {
        try {
            QueryRunner run = new QueryRunner();
            ResultSetHandler<List<T>> h = new BeanListHandler<T>(tableClass);
            return run.query("SELECT * FROM " + tableName, h);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void delete(K primaryKey) {
        try {
            String sql = "DELETE FROM " + tableName + " WHERE " + primaryKeyName + "=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, primaryKey);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getCount() {
        try {
            String sql = "SELECT COUNT(*) FROM " + tableName;
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            result.next();
            return result.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
