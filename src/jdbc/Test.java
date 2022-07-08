package jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        // 1.获取数据源建立连接
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8&setSSL=false");
        dataSource.setUser("root");
        dataSource.setPassword("g641517196");
        Connection connection = dataSource.getConnection();
        // 2.获取Statement对象
        String select = "select id,name from stu where id <= ?";
        PreparedStatement statement = connection.prepareStatement(select);
        statement.setString(1, "5");
        // 3.执行SQL语句
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("id：" + id + "，name：" + name);
        }
        // 4.关闭资源
        resultSet.close();
        connection.close();
    }
}
