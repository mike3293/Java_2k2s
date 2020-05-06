package connection;

import java.sql.*;
import java.util.ArrayList;

public class NewspaperDao {
    private final ConnectionCreator connectionCreator = new ConnectionCreator();

    public NewspaperDao() throws SQLException {
    }

    public void addNewspaper(Newspaper newspaper) throws SQLException, ClassNotFoundException {
        String query = " INSERT INTO newspaper(newspapernumber, userid) "
                + " VALUES (?, ?)";
        Connection connection = connectionCreator.createConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, newspaper.getNumber());
        statement.setInt(2, newspaper.getUserid());
        statement.executeUpdate();
    }

    public ArrayList<Newspaper> select(int userid) {
        ArrayList<Newspaper> newspapers = new ArrayList<Newspaper>();
        try {
            Connection connection = connectionCreator.createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT idnewspaper, newspapernumber FROM newspaper where userid =" + userid);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String newspapernumber = resultSet.getString("newspapernumber");
                Newspaper product = new Newspaper(id, newspapernumber, userid);
                newspapers.add(product);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return newspapers;
    }

    public Newspaper selectOne(int id) {
        Newspaper newspaper = null;
        try {
            Connection connection = connectionCreator.createConnection();
            String sql = "SELECT idnewspaper, newspapernumber, userid FROM newspaper WHERE idnewspaper=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {

                    int newspaperId = resultSet.getInt(1);
                    String newspapernumber = resultSet.getString(2);
                    int userid = resultSet.getInt(3);
                    newspaper = new Newspaper(newspaperId, newspapernumber, userid);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return newspaper;
    }

    public int update(Newspaper newspaper) throws SQLException {
        Connection connection = connectionCreator.createConnection();
        String sql = "UPDATE newspaper SET newspapernumber = ? WHERE idnewspaper = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newspaper.getNumber());
            preparedStatement.setInt(2, newspaper.getId());
            return preparedStatement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

    public int delete(int id) throws SQLException {
        Connection connection = connectionCreator.createConnection();
        String sql = "DELETE FROM newspaper WHERE idnewspaper = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }
}
