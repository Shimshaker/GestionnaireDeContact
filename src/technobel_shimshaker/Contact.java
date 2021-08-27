package technobel_shimshaker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.LocalDate.*;

// Définitions de mes contacts
public class Contact {

    private String id;
    private String nom;
    private String prenom;
    private String nickname;
    private LocalDate date_de_Naissance;
    private String nationalite;
    private String adresse;
    private String numero;
    private String boite;
    private String codepostal;
    private String pays;
    private String tel;
    private String smartphone;
    private String email;
    private String remarque;

    // Initialisatiion des function DAO
    ContactDAO dao = new ContactDAOImpl();

    // Constructeurs des objets contacts
    public Contact(String id, String nom, String prenom, String nickname, String date_de_Naissance,  String nationalite, String adresse, String numero, String boite, String codepostal, String pays, String tel, String smartphone, String email, String remarque) {
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

    }

    // Getters and Setters
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

    //Parsing de la date de string à Date
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBoite() {
        return boite;
    }

    public void setBoite(String boite) {
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

    // Function de creation chaine pour les contacts
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
