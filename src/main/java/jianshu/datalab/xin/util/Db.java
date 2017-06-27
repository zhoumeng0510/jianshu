package jianshu.datalab.xin.util;

import java.sql.*;

/**
 * Created by zhoumeng on
 * 2017.6.27.
 * 下午 04:15.
 */
public class Db {
    private static final String URL = "jdbc:mysql:///?user=root&password=system";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(URL);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void close(ResultSet resultSet, PreparedStatement preparedStatement,Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
