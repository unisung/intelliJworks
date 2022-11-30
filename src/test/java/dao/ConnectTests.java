package dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectTests {

    @Test
    public void testConnection() throws Exception{
        Class.forName("org.mariadb.jdbc.Driver");

        String url="jdbc:mariadb://localhost:3306/webdb";
        String user="webuser";
        String passwd="webuser";
        Connection connection = DriverManager.getConnection(url,user,passwd);

        Assertions.assertNotNull(connection);

        connection.close();

    }
}
