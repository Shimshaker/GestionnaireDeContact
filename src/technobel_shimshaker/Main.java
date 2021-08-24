package technobel_shimshaker;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

            ContactDAO cd = new ContactDAOImpl();

            cd.getAll();

//        InterfaceConsole ic = new InterfaceConsole();
//        ic.start();
    }

}
