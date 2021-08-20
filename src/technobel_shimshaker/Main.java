package technobel_shimshaker;

import java.sql.*;

public class Main {
    static String dbURL = "jdbc:mysql://localhost/java_arlon_2021?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static String username = "Shimshaker";
    static String password = "-vK$3Apytqq4dYKt";
    public static void main(String[] args) {
//        String connectionUrl =
//                "jdbc:mysql://localhost/java_arlon_2021?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//
//        ResultSet resultSet = null;
//
//        try (Connection connection = DriverManager.getConnection(connectionUrl, "Shimshaker", "-vK$3Apytqq4dYKt");
//             Statement statement = connection.createStatement();) {
//
//            // Create and execute a SELECT SQL statement.
//            String selectSql = "SELECT nomcontact, prenomcontact from contact LIMIT 10";
//            resultSet = statement.executeQuery(selectSql);
//
//            // Print results from select statement
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//        }
//        readData();
        insertData("Carl","Prune");
//        InterfaceConsole ic = new InterfaceConsole();
//        ic.start();
    }

    private static void readData() {
        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(dbURL, username, password);
             Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT nomcontact, prenomcontact from contact LIMIT 10";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    private static void insertData(String nom, String prenom){

        try(Connection connection = DriverManager.getConnection(dbURL, username, password)) {
            String sql = "INSERT INTO contact (idcontact, nomcontact, prenomcontact) VALUES (?,?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, 7);
            statement.setString(2, nom);
            statement.setString(3, prenom);

            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) {
                System.out.println("Votre nouveau contact à été insérer");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
