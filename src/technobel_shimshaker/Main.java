package technobel_shimshaker;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
//        String connectionUrl =
//                "jdbc:sqlserver://COSMOSDESKTOP.Java_Dev_Arlon_2021.windows.net:1433;"
//                        + "database=Java_Dev_Arlon_2021;"
//                        + "user=Shimshaker@COSMOSDESKTOP;"
//                        + "password=;"
//                        + "encrypt=true;"
//                        + "trustServerCertificate=false;"
//                        + "loginTimeout=30;";
//
//        ResultSet resultSet = null;
//
//        try (Connection connection = DriverManager.getConnection(connectionUrl);
//             Statement statement = connection.createStatement();) {
//
//            // Create and execute a SELECT SQL statement.
//            String selectSql = "SELECT TOP 10 Title, FirstName, LastName from dbo.student";
//            resultSet = statement.executeQuery(selectSql);
//
//            // Print results from select statement
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString(2) + " " + resultSet.getString(3));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//        }
        InterfaceConsole ic = new InterfaceConsole();
        ic.start();
    }
}
