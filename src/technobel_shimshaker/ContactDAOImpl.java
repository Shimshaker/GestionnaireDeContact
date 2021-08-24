package technobel_shimshaker;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ContactDAOImpl implements ContactDAO {

    @Override
    public void insert(Contact contact) {

    }

    @Override
    public Contact getOne(String id) {
        return null;
    }

    @Override
    public void getAll() {
        try {
            Statement statement = InterfaceConsole.conn.createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM dbo.contact");

            int count = 0;

            while (result.next()){
                String id = result.getString(2);
                String nom = result.getString(3);
                String prenom = result.getString(4);
                String nickname = result.getString(5);
                Date birthdate = result.getDate(6);
                String nationalite = result.getString(7);
                String adresse = result.getString(8);
                Integer numeros = result.getInt(9);
                Integer boite = result.getInt(10);
                String codepostal = result.getString(11);
                String pays = result.getString(12);
                String telephone = result.getString(13);
                String smartphone = result.getString(14);
                String email = result.getString(15);
                String remarque = result.getString(16);

                String output = "dbo.contact #%d: Contact id: %s - Nom: %s - Prénom: %s - Nickname: %s - Date de Naissance: %s - Nationalité: %s - Adresse: %s - Numero: %s - N° de Boîte: %s - Code Postal: %s - Pays: %s - Tel Fixe: %s - Tel Mobile: %s - Email: %s - Remarque: %s";
                System.out.println(String.format(output, ++count, id, nom, prenom, nickname, birthdate, nationalite, adresse, numeros, boite, codepostal, pays, telephone, smartphone, email, remarque));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Contact contact) {

    }

    @Override
    public void delete(String id) {

    }
}
