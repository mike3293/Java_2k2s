package com.company;
import java.sql.*;


public class Main {
    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        String url = "jdbc:sqlserver://DESKTOP-8NQEQ1G;databaseName=G_MyBase";
        String login = "java";
        String pass = "java";
        System.out.println("Trying to connect");
        Connection con = DriverManager.getConnection(url,login,pass);
        con.setAutoCommit(false);
        System.out.println("Connected");

        String query1 = "select * " +
                        "from Deliveries " +
                        "where delivery_id = '6F9619FF-8B86-D011-B42D-00CF4FC164F1'";

        String query2 = "select delivery_id " +
                "from Deliveries " +
                "where amount=4 and sell_price <= 30";

        String query3 = "select delivery_id " +
                "from Deliveries " +
                "where product='exams'";

        String query4 = "select d.delivery_id " +
                "from Deliveries d " +
                "where d.product!=? and cast(d.date as date) = cast(getdate() as date)";


        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(query1);
        System.out.println("Query 1");
        while(rs.next())
        {

            String inf = rs.getString("customer") + " | ";
            inf += rs.getString("product") + " | ";
            inf += rs.getString("amount") + " | ";
            inf += rs.getString("sell_price") + " | ";
            inf += rs.getString("date");
            System.out.println("\t"+inf);
        }
        rs = statement.executeQuery(query2);
        System.out.println("Query 2");
        while(rs.next())
        {
            String inf = rs.getString("delivery_id");
            System.out.println("\t"+inf);
        }
        rs = statement.executeQuery(query3);
        System.out.println("Query 3");
        while(rs.next())
        {
            String inf = rs.getString("delivery_id");
            System.out.println("\t"+inf);
        }
        PreparedStatement preparedStatement = con.prepareStatement(query4);
        preparedStatement.setString(1,"knowledge");
        rs = preparedStatement.executeQuery();
        System.out.println("Query 4");
        while(rs.next())
        {
            String inf = rs.getString("delivery_id");
            System.out.println("\t"+inf);
        }

        try{
            con.commit();
            String query5 = "select product " +
                    "from Deliveries d " +
                    "where cast(d.date as date) = cast(getdate() as date)";
            rs = statement.executeQuery(query5);
            rs.next();
            String product = rs.getString("product");

            String query6 = "insert into Deliveries " +
                    "values (?,'BSU',?,1, 10, getdate(), 'fast')";
            preparedStatement = con.prepareStatement(query6);
            System.out.println(String.valueOf(java.util.UUID.randomUUID()));

            preparedStatement.setString(1, String.valueOf(java.util.UUID.randomUUID()));
            preparedStatement.setString(2,product);

            System.out.println("Query 5");
            int num = preparedStatement.executeUpdate();
            System.out.println(num);
            con.commit();
        } catch (SQLException e){
            con.rollback();
            System.out.println("Rollback");
        }
        try{
            String query = "DELETE from Deliveries Where product = 'exams' and amount = 1";
            preparedStatement = con.prepareStatement(query);

            System.out.println("Query 6");
            int num = preparedStatement.executeUpdate();
            System.out.println(num);
            con.commit();
        } catch (SQLException e){
            con.rollback();
            System.out.println("Rollback");
        }

        rs.close();
        statement.close();
        preparedStatement.close();
        con.close();
    }
}
