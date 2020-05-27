package connection;

import org.apache.log4j.Logger;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConnectionCreator {

    private String url;
    private String user;
    private String password;
    private static final Logger log = Logger.getLogger(ConnectionCreator.class);

    public ConnectionCreator() {
        url = "jdbc:mysql://localhost:3306/java?useUnicode=true&serverTimezone=UTC&useSSL=false";
        user = "root";
        password = "root";
    }

    public Connection createConnection() throws SQLException {
        Properties prop = new Properties();
        prop.put("user", user);
        prop.put("password", password);
       System.out.println("trying");
        log.info("Trying to connect");
        Connection con = DriverManager.getConnection(url, prop);
        System.out.println("connected");
        log.info("Connected to db");
        return con;
    }
}