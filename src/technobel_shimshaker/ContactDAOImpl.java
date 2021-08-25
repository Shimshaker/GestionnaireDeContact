package technobel_shimshaker;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;

import static java.time.LocalDate.parse;

public class ContactDAOImpl implements ContactDAO {

    @Override
    public void insert(Contact contact) {
        try{
            String sql = "INSERT INTO contact (id, nom, prenom, nickname, birthdate, nationalite, adresse, numeros, boite, codepostal, pays, telephone, smartphone, email, remarque) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = InterfaceConsole.conn.prepareStatement(sql);
            statement.setString(1, contact.getId());
            statement.setString(2, contact.getNom());
            statement.setString(3, contact.getPrenom());
            statement.setString(4, contact.getNickname());
            statement.setDate(5, Date.valueOf(contact.getDate_de_Naissance()));
            statement.setString(6, contact.getNationalite());
            statement.setString(7, contact.getAdresse());
            statement.setInt(8, contact.getNumero());
            statement.setInt(9,contact.getBoite());
            statement.setString(10, contact.getCodepostal());
            statement.setString(11, contact.getPays());
            statement.setString(12, contact.getTel());
            statement.setString(13, contact.getSmartphone());
            statement.setString(14, contact.getEmail());
            statement.setString(15, contact.getRemarque());

            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) {
                System.out.println("Votre nouveau contact à bien été insérer");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void getOne(String contactId) {
        try {
            String sql = "SELECT * FROM dbo.contact WHERE id = ?";

            PreparedStatement statement = InterfaceConsole.conn.prepareStatement(sql);
            statement.setString(1, contactId);

            ResultSet result = statement.executeQuery();

            int count = 0;

            if(result.next()) {
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
                System.out.println("Et voiçi les contacts correspondant a votre recherche : ");
                System.out.println(String.format(output, ++count, id, nom, prenom, nickname, birthdate, nationalite, adresse, numeros, boite, codepostal, pays, telephone, smartphone, email, remarque));

            }else {
                System.out.println("Votre contact n'existe pas dans votre base de données...!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public void getOneByName(String contactNom) {
        try {
            String sql = "SELECT * FROM dbo.contact WHERE nom = ?";

            PreparedStatement statement = InterfaceConsole.conn.prepareStatement(sql);
            statement.setString(1, contactNom);

            ResultSet result = statement.executeQuery();

            int count = 0;

            System.out.println("Et voiçi les contacts : ");
            while(result.next()) {
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

            if (count == 0){
                System.out.println("");
                System.out.println("Votre contact n'existe pas dans votre base de données...!");
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void getOneByFirstName(String contactPrenom) {
        try {
            String sql = "SELECT * FROM dbo.contact WHERE prenom = ?";

            PreparedStatement statement = InterfaceConsole.conn.prepareStatement(sql);
            statement.setString(1, contactPrenom);

            ResultSet result = statement.executeQuery();

            int count = 0;

            while(result.next()) {
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
                System.out.println("Et voiçi les contacts correspondant a votre recherche : ");
                System.out.println(String.format(output, ++count, id, nom, prenom, nickname, birthdate, nationalite, adresse, numeros, boite, codepostal, pays, telephone, smartphone, email, remarque));


            }
            if (count == 0){
                System.out.println("");
                System.out.println("Votre contact n'existe pas dans votre base de données...!");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void getOneByAdress(String contactAdresse) {
        try {
            String sql = "SELECT * FROM dbo.contact WHERE adresse = ?";

            PreparedStatement statement = InterfaceConsole.conn.prepareStatement(sql);
            statement.setString(1, contactAdresse);

            ResultSet result = statement.executeQuery();

            int count = 0;
            System.out.println("Et voiçi les contacts correspondant a votre recherche : ");
            while(result.next()) {
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

            if (count == 0){
                System.out.println("");
                System.out.println("Votre contact n'existe pas dans votre base de données...!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void getOneByBirthDate(String contactDateDeNaissance) {
        try {
            String sql = "SELECT * FROM dbo.contact WHERE birthdate = ?";

            LocalDate contactDateDeNai = parse(contactDateDeNaissance, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            PreparedStatement statement = InterfaceConsole.conn.prepareStatement(sql);
            statement.setDate(1, Date.valueOf(contactDateDeNai));

            ResultSet result = statement.executeQuery();

            int count = 0;
            System.out.println("Et voiçi les contacts correspondant a votre recherche : ");
            while (result.next()) {
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
            if (count == 0){
                System.out.println("");
                System.out.println("Votre contact n'existe pas dans votre base de données...!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
    public void update(Contact contact, String contactId) {
        try{
            String sql = "UPDATE dbo.contact SET id=?, nom=?, prenom=?, nickname=?, birthdate=?, nationalite=?, adresse=?, numeros=?, boite=?, codepostal=?, pays=?, telephone=?, smartphone=?, email=?, remarque=? WHERE id=?";
            PreparedStatement statement = InterfaceConsole.conn.prepareStatement(sql);
            statement.setString(1, contact.getId());
            statement.setString(2, contact.getNom());
            statement.setString(3, contact.getPrenom());
            statement.setString(4, contact.getNickname());
            statement.setDate(5, Date.valueOf(contact.getDate_de_Naissance()));
            statement.setString(6, contact.getNationalite());
            statement.setString(7, contact.getAdresse());
            statement.setInt(8, contact.getNumero());
            statement.setInt(9,contact.getBoite());
            statement.setString(10, contact.getCodepostal());
            statement.setString(11, contact.getPays());
            statement.setString(12, contact.getTel());
            statement.setString(13, contact.getSmartphone());
            statement.setString(14, contact.getEmail());
            statement.setString(15, contact.getRemarque());
            statement.setString(16, contactId);

            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) {
                System.out.println("Votre contact à été mise à jour");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void delete(String id) {
        try {
            String sql = "DELETE FROM dbo.contact WHERE id = ?";
            PreparedStatement statement = InterfaceConsole.conn.prepareStatement(sql);
            statement.setString(1, id);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0){
                System.out.println("Votre contact est éffacer..!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
