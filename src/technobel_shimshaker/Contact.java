package technobel_shimshaker;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.LocalDate.*;
import java.util.UUID;

public class Contact {

    private String id;
    private String nom;
    private String prenom;
    private String nickname;
    private LocalDate date_de_Naissance;
    private String nationalite;
    private String adresse;
    private int numero;
    private int boite;
    private String codepostal;
    private String pays;
    private String tel;
    private String smartphone;
    private String email;
    private String remarque;

    public Contact(String id, String nom, String prenom, String nickname, String date_de_Naissance,  String nationalite, String adresse, int numero, int boite, String codepostal, String pays, String tel, String smartphone, String email, String remarque) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.nickname = nickname;
        this.date_de_Naissance = parse(date_de_Naissance, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.nationalite = nationalite;
        this.adresse = adresse;
        this.numero = numero;
        this.boite = boite;
        this.codepostal = codepostal;
        this.pays = pays;
        this.tel = tel;
        this.smartphone = smartphone;
        this.email = email;
        this.remarque = remarque;
        InterfaceConsole.contactList.add(this);
        createRows();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LocalDate getDate_de_Naissance() {
        return date_de_Naissance;
    }

    public void setDate_de_Naissance(String date_de_Naissance) {
        this.date_de_Naissance = parse(date_de_Naissance, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getBoite() {
        return boite;
    }

    public void setBoite(int boite) {
        this.boite = boite;
    }

    public String getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(String codepostal) {
        this.codepostal = codepostal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSmartphone() {
        return smartphone;
    }

    public void setSmartphone(String smartphone) {
        this.smartphone = smartphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public void createRows(){

        try{
            String sql = "INSERT INTO contact (id, nom, prenom, nickname, birthdate, nationalite, adresse, numeros, boite, codepostal, pays, telephone, smartphone, email, remarque) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = InterfaceConsole.conn.prepareStatement(sql);
            statement.setString(1, id);
            statement.setString(2, nom);
            statement.setString(3, prenom);
            statement.setString(4, nickname);
            statement.setDate(5, Date.valueOf(date_de_Naissance));
            statement.setString(6,nationalite);
            statement.setString(7, adresse);
            statement.setInt(8, numero);
            statement.setInt(9,boite);
            statement.setString(10, codepostal);
            statement.setString(11, pays);
            statement.setString(12, tel);
            statement.setString(13, smartphone);
            statement.setString(14,email);
            statement.setString(15, remarque);

            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) {
                System.out.println("Votre nouveau contact à été insérer");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public String toString() {
        DateTimeFormatter formDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        final StringBuilder sb = new StringBuilder("Contact{");
        sb.append("id='").append(id).append('\'');
        sb.append(", nom = '").append(nom).append('\'');
        sb.append(", prenom = '").append(prenom).append('\'');
        sb.append(", nickname = '").append(nickname).append('\'');
        sb.append(", date_de_Naissance = ").append(date_de_Naissance.format(formDate));
        sb.append(", nationalite = '").append(nationalite).append('\'');
        sb.append(", adresse = '").append(adresse).append('\'');
        sb.append(", numero = ").append(numero);
        sb.append(", boite = ").append(boite);
        sb.append(", codepostal = '").append(codepostal).append('\'');
        sb.append(", pays = '").append(pays).append('\'');
        sb.append(", tel = '").append(tel).append('\'');
        sb.append(", smartphone = '").append(smartphone).append('\'');
        sb.append(", email = '").append(email).append('\'');
        sb.append(", remarque = '").append(remarque).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
