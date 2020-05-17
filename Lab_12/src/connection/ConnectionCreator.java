package connection;

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

    public ConnectionCreator() {
        ResourceBundle resource = ResourceBundle.getBundle("db");
        url = resource.getString("db.url");
        user = resource.getString("db.user");
        password = resource.getString("db.password");

    }

    public Connection createConnection() throws SQLException {
        Properties prop = new Properties();
        prop.put("user", user);
        prop.put("password", password);
       System.out.println("trying");
        Connection con = DriverManager.getConnection(url, prop);
        System.out.println("connected");
return con;
    }
}