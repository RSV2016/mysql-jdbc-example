import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("world");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://127.0.0.1");

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                "SELECT * " +
                    "FROM world.city " +
                    "WHERE Population > 5000000"
        );

        while(resultSet.next()) {
            String name = resultSet.getString("name");
            String countryCode = resultSet.getString("CountryCode");
            System.out.println(String.format("%-30s [%s]", name, countryCode));
        }


    }
}
