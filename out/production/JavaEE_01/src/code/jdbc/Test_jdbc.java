package code.jdbc;

import java.sql.*;

/**
 * @Author:GQM
 * @Date:created in 0:13 2020/2/28
 * @Description:
 * @Modifyed_By:
 */
public class Test_jdbc {
    public static String getMysql(){
        String url="jdbc:mysql://127.0.0.1:3306/fuwuwaibao?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";

        String drivername = "com.mysql.cj.jdbc.Driver";

        String sqlString = "select * from name ";


        try{
            //加载驱动
            Class.forName(drivername);//可以省略
            //创建连接
            Connection connection =  DriverManager.getConnection(url,"root","0016");
            //通过连接获取statement
            Statement statement = connection.createStatement();
            //statement （增、删、改、查）
            ResultSet resultSet = statement.executeQuery(sqlString);
            //获取执行结果
            while(resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {

        getMysql();
    }
}
