package connection;

import java.sql.*;

public class UserDao {

    private final ConnectionCreator connectionCreator = new ConnectionCreator();

    public UserDao() throws SQLException {
    }

    public boolean isExists(String login) throws SQLException, ClassNotFoundException {
        Connection connection = connectionCreator.createConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT login FROM users WHERE login='" + login + "'");
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return true;
        } else {
            return false;
        }
    }

    public void addUser(String login, String password,String name) throws SQLException, ClassNotFoundException {
        String query = " INSERT INTO users(login, password,last_login,name, role) "
                + " VALUES (?, ?, ?,?, 1)";
        Connection connection = connectionCreator.createConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,login);
        statement.setString(2,password);
        statement.setString(4,name);
        java.util.Date date = new java.util.Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        statement.setTimestamp(3,timestamp);
        statement.executeUpdate();
    }

    public void setLastLogin(String login) throws SQLException, ClassNotFoundException {
        Connection connection = connectionCreator.createConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE users SET last_login = ? WHERE login = ?" );
        java.util.Date date = new java.util.Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        statement.setTimestamp(1,timestamp);
        statement.setString(2, login);
        statement.executeUpdate();
    }

    public String getNameUser(String login) throws SQLException, ClassNotFoundException {
        Connection connection = connectionCreator.createConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT name FROM users WHERE login='" + login + "'");
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
           return resultSet.getString(1);
        } else {
            throw new SQLException();
        }
    }
    public int getUserId(String login) throws SQLException, ClassNotFoundException {
        Connection connection = connectionCreator.createConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT id FROM users WHERE login='" + login + "'");
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        } else {
            throw new SQLException();
        }
    }

    public boolean checkFor(String login, String password) throws SQLException, ClassNotFoundException {
        Connection connection = connectionCreator.createConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT password FROM users WHERE login='" + login + "'");
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String retrievedPassword = resultSet.getString(1);
            if (retrievedPassword.equals(password)) {
                statement = connection.prepareStatement("UPDATE users SET login_number = login_number+1 WHERE login='" + login + "'");
                statement.executeUpdate();
                return true;
            }
        }
        return false;
    }

    public Timestamp getLoginTimestamp(String login) throws SQLException, ClassNotFoundException {
        Connection connection = connectionCreator.createConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT last_login FROM users WHERE login='" + login + "'");
        ResultSet resultSet = statement.executeQuery();
        Timestamp result;
        if (resultSet.next()) {
            result = resultSet.getTimestamp(1);
        } else {
            throw new SQLException();
        }
        return result;
    }

    public int getLoginNumber(String login) throws SQLException, ClassNotFoundException {
        Connection connection = connectionCreator.createConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT login_number FROM users WHERE login='" + login + "'");
        ResultSet resultSet = statement.executeQuery();
        int result;
        if (resultSet.next()) {
            result = resultSet.getInt(1);
        } else {
            throw new SQLException();
        }
        return result;
    }
    public int getRoleNumber(String login) throws SQLException, ClassNotFoundException {
        Connection connection = connectionCreator.createConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT role FROM users WHERE login='" + login + "'");
        ResultSet resultSet = statement.executeQuery();
        int result;
        if (resultSet.next()) {
            result = resultSet.getInt(1);
        } else {
            throw new SQLException();
        }
        return result;
    }

}
