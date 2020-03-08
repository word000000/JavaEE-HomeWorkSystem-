package code.jdbc;

import java.sql.*;

/**
 * @Author:GQM
 * @Date:created in 8:28 2020/3/5
 * @Description: 手动关闭sql链接
 * @Modifyed_By:
 */
public class Test_jdbc_v2 {
    public static String getMysql() throws SQLException {
        String url="jdbc:mysql://127.0.0.1:3306/fuwuwaibao?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";

        String drivername = "com.mysql.cj.jdbc.Driver";

        String sqlString = "select * from name ";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int n = 500;
        while (n-->=0) {
            try {
                //加载驱动
                Class.forName(drivername);
                //创建连接
                connection = DriverManager.getConnection(url, "root", "0016");
                //通过连接获取statement
                statement = connection.createStatement();
                //statement （增、删、改、查）
                resultSet = statement.executeQuery(sqlString);
                //获取执行结果
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1));
                }


            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            } finally {
                if (null != resultSet) {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (null != statement) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (null != connection) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {

        try {
            getMysql();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
