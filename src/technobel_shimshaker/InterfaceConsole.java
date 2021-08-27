package technobel_shimshaker;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.time.LocalDate.parse;

// Création de l'interface
public class InterfaceConsole {
    // Déclaration des variables
    protected static final String username = "";
    protected static final String password = "";
    private static final String dbURL = "";
    // Connecteur et gestion sql...
    public static Connection conn;

    static {
        try {
            conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                System.out.println("Connected on DataBase Contact");
            }
        } catch (SQLException throwables) {
            System.out.println("Connection Fail");
            throwables.printStackTrace();
        }
    }
    // Initialisation du scanner...
    private final Scanner sc = new Scanner(System.in);
    private final Timer waitTime = new Timer();
    private final  Map<String, Contact> contactId = new HashMap<>();
    private Object Contact;
    boolean quit;

    // Point de démmarrage...
    public void start(){
        // Initialisation du Database Access Object
        ContactDAO dao = new ContactDAOImpl();

        // Boucle du menu...
        do {
            System.out.println();
            System.out.println("Bienvenue dans votre gestionnaire de contact");
            System.out.println("Içi vous pouvez effectuez divers tâches sur vos contact");
            System.out.println("1 - Ajouter un contact dans votre gestionnaire");
            System.out.println("2 - Modifiez un contact dans votres gestionnaire");
            System.out.println("3 - Effectuez une recherche au travers votre gestionnaire");
            System.out.println("4 - Créer une liste de vos contact");
            //System.out.println("5 - Créer une liste spécifique de vos contacts");
            System.out.println("6 - Supprimez un contact de votre gestionnaire");
            System.out.println("7 - Quitter");
            char choice = sc.nextLine().charAt(0);

            // Choix des menus...
            switch (choice){
                case '1':
                    // Création d'une insertion d'Objet contact pour la base de données...
                    try {
                        System.out.println("Veuillez entrez le nom du contact à ajoutez : ");
                        String contactName = sc.nextLine();
                        System.out.println("Veuillez entrez le prénom : ");
                        String contactPrenom = sc.nextLine();
                        System.out.println("Veuillez entrez le nickname (Si vous en avez un ... !) : ");
                        String contactNickName = sc.nextLine();
                        System.out.println("Veuillez entrez votre date de naissance (Au format jour/mois/année :");
                        String contactDateDeNaissance = sc.nextLine();
                        System.out.println("Veuillez entrez la nationalité :");
                        String contactNationalite = sc.nextLine();
                        System.out.println("Veuillez entrez l'adresse : ");
                        String contactAdresse = sc.nextLine();
                        System.out.println("Veuillez entrez le numéros de maison ou block : ");
                        String contactNumero = sc.nextLine();
                        System.out.println("Veuillez entrez le numéro de boite (Si il existe ...!) : ");
                        String contactNumeroBoite = sc.nextLine();
                        System.out.println("Veuillez entrez le code postal : ");
                        String contactCodePostal = sc.nextLine();
                        System.out.println("Veuillez entrez le pays : ");
                        String contactPays = sc.nextLine();
                        System.out.println("Veuillez entrez le numéros de Téléphone fixe : ");
                        String contactTelFixe = sc.nextLine();
                        System.out.println("Veuillez entrez le numéros smartphone : ");
                        String contactSmartPhone = sc.nextLine();
                        System.out.println("Veuillez entrez votre adresse mail : ");
                        String contactEmail = sc.nextLine();
                        System.out.println("Veuillez entrez les remarques éventuel à indiquez");
                        String contactRemarque = sc.nextLine();

                        String newcontact = UUID.randomUUID().toString();
                        Contact contact = new Contact(newcontact, contactName, contactPrenom, contactNickName, contactDateDeNaissance, contactNationalite, contactAdresse, contactNumero, contactNumeroBoite, contactCodePostal, contactPays, contactTelFixe, contactSmartPhone, contactEmail, contactRemarque);
                        contactId.put(newcontact, contact);
                        dao.insert(contact);

                    }catch (Exception throwables){
                        System.out.println("Apparement il y a eu une erreur veuillez recommence et l'exception est : " + throwables.fillInStackTrace());
                    }

                    break;
                    // Modification de contact à travers la base de données...
                case '2':
                    System.out.println("Quels contact voulez-vous modifiez qui à travers votre gestionnaire :");
                    System.out.println("Par quels références voulez-vous effectuez votre recherche ?");
                    System.out.println("1 - Son nom :");
                    System.out.println("2 - Son prénom :");
                    System.out.println("3 - Son adresse :");
                    System.out.println("4 - Sa date de naissance :");
                    System.out.println("5 - Son Identifiant :");
                    char choice2 = sc.nextLine().charAt(0);
                    switch (choice2) {
                        // En fonction de son nom...
                        case '1' -> {
                            System.out.println("Veuillez entrez son nom :");
                            String contactName = sc.nextLine();
                            dao.getOneByName(contactName);
                            System.out.println();
                            System.out.println("Votre contact existe t'il dans la liste ?");
                            System.out.println("1 - Oui");
                            System.out.println("2 - Nom");
                            char rep = sc.nextLine().charAt(0);
                            if (rep == '1') {
                                System.out.println("Veuillez entrez l'id exact de votre contact ");
                                String idContact = sc.nextLine();
                                System.out.println("Est-ce bien juste ? ");
                                System.out.println("Vous voulez modifier ce contact ?... ");
                                dao.getOne(idContact);
                                System.out.println("1 - Oui ");
                                System.out.println("2 - Nom ");
                                char repfinal = sc.nextLine().charAt(0);
                                if (repfinal == '1') {
                                    try {

                                        System.out.println("Veuillez entrez le nom du contact à ajoutez : ");
                                        System.out.println(contactId.get(idContact).getNom());
                                        String contactNameUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le prénom : ");
                                        System.out.println(contactId.get(idContact).getPrenom());
                                        String contactPrenomUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le nickname (Si vous en avez un ... !) : ");
                                        System.out.println(contactId.get(idContact).getNickname());
                                        String contactNickNameUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez votre date de naissance (Au format jour/mois/année :");
                                        System.out.println(contactId.get(idContact).getDate_de_Naissance());
                                        String contactDateDeNaissanceUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez la nationalité :");
                                        System.out.println(contactId.get(idContact).getNationalite());
                                        String contactNationaliteUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez l'adresse : ");
                                        System.out.println(contactId.get(idContact).getAdresse());
                                        String contactAdresseUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le numéros de maison ou block : ");
                                        System.out.println(contactId.get(idContact).getNumero());
                                        String contactNumeroUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le numéro de boite (Si il existe ...!) : ");
                                        System.out.println(contactId.get(idContact).getBoite());
                                        String contactNumeroBoiteUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le code postal : ");
                                        System.out.println(contactId.get(idContact).getCodepostal());
                                        String contactCodePostalUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le pays : ");
                                        System.out.println(contactId.get(idContact).getPays());
                                        String contactPaysUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le numéros de Téléphone fixe : ");
                                        System.out.println(contactId.get(idContact).getTel());
                                        String contactTelFixeUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le numéros smartphone : ");
                                        System.out.println(contactId.get(idContact).getSmartphone());
                                        String contactSmartPhoneUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez votre adresse mail : ");
                                        System.out.println(contactId.get(idContact).getEmail());
                                        String contactEmailUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez les remarques éventuel à indiquez");
                                        System.out.println(contactId.get(idContact).getRemarque());
                                        String contactRemarqueUpdate = sc.nextLine();

                                        Contact contactUpdate = new Contact(idContact, contactNameUpdate, contactPrenomUpdate, contactNickNameUpdate, contactDateDeNaissanceUpdate, contactNationaliteUpdate, contactAdresseUpdate, contactNumeroUpdate, contactNumeroBoiteUpdate, contactCodePostalUpdate, contactPaysUpdate, contactTelFixeUpdate, contactSmartPhoneUpdate, contactEmailUpdate, contactRemarqueUpdate);
                                        dao.update(contactUpdate, idContact);
                                    } catch (Exception throwables) {
                                        System.out.println("Apparement il y a eu une erreur veuillez recommence et l'exception est : " + throwables.fillInStackTrace());
                                    }

                                } else if (repfinal == '2') {
                                    System.out.println("Pas d'opération sur le contact");
                                }
                            } else if (rep == '2') {
                                System.out.println("Pas d'opération sur le contact..");
                            }
                        }
                        //En fonction de son prénom...
                        case '2' -> {
                            System.out.println("Veuillez entrez son prenom :");
                            String contactPrenom = sc.nextLine();
                            dao.getOneByFirstName(contactPrenom);
                            System.out.println();
                            System.out.println("Votre contact existe t'il dans la liste ?");
                            System.out.println("1 - Oui");
                            System.out.println("2 - Nom");
                            char rep2 = sc.nextLine().charAt(0);
                            if (rep2 == '1') {
                                System.out.println("Veuillez entrez l'id exact de votre contact ");
                                String idContact = sc.nextLine();
                                System.out.println("Est-ce bien juste ? ");
                                System.out.println("Vous voulez modifier ce contact ?... ");
                                dao.getOne(idContact);
                                System.out.println("1 - Oui ");
                                System.out.println("2 - Nom ");
                                char repfinal2 = sc.nextLine().charAt(0);
                                if (repfinal2 == '1') {
                                    try {

                                        System.out.println("Veuillez entrez le nom du contact à ajoutez : ");
                                        String contactNameUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le prénom : ");
                                        String contactPrenomUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le nickname (Si vous en avez un ... !) : ");
                                        String contactNickNameUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez votre date de naissance (Au format jour/mois/année :");
                                        String contactDateDeNaissanceUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez la nationalité :");
                                        String contactNationaliteUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez l'adresse : ");
                                        String contactAdresseUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le numéros de maison ou block : ");
                                        String contactNumeroUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le numéro de boite (Si il existe ...!) : ");
                                        String contactNumeroBoiteUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le code postal : ");
                                        String contactCodePostalUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le pays : ");
                                        String contactPaysUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le numéros de Téléphone fixe : ");
                                        String contactTelFixeUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le numéros smartphone : ");
                                        String contactSmartPhoneUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez votre adresse mail : ");
                                        String contactEmailUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez les remarques éventuel à indiquez");
                                        String contactRemarqueUpdate = sc.nextLine();

                                        Contact contactUpdate = new Contact(idContact, contactNameUpdate, contactPrenomUpdate, contactNickNameUpdate, contactDateDeNaissanceUpdate, contactNationaliteUpdate, contactAdresseUpdate, contactNumeroUpdate, contactNumeroBoiteUpdate, contactCodePostalUpdate, contactPaysUpdate, contactTelFixeUpdate, contactSmartPhoneUpdate, contactEmailUpdate, contactRemarqueUpdate);
                                        dao.update(contactUpdate, idContact);
                                    } catch (Exception throwables) {
                                        System.out.println("Apparement il y a eu une erreur veuillez recommence et l'exception est : " + throwables.fillInStackTrace());
                                    }
                                } else if (repfinal2 == '2') {
                                    System.out.println("Pas d'opération sur le contact");
                                }
                            } else if (rep2 == '2') {
                                System.out.println("Pas d'opération sur le contact..");
                            }
                        }
                        // En fonction de son adresse...
                        case '3' -> {
                            System.out.println("Veuillez entrez son adresse :");
                            String contactAdresse = sc.nextLine();
                            dao.getOneByAdress(contactAdresse);
                            System.out.println();
                            System.out.println("Votre contact existe t'il dans la liste ?");
                            System.out.println("1 - Oui");
                            System.out.println("2 - Nom");
                            char rep3 = sc.nextLine().charAt(0);
                            if (rep3 == '1') {
                                System.out.println("Veuillez entrez l'id exact de votre contact ");
                                String idContact = sc.nextLine();
                                System.out.println("Est-ce bien juste ? ");
                                System.out.println("Vous voulez modifier ce contact ?... ");
                                dao.getOne(idContact);
                                System.out.println("1 - Oui ");
                                System.out.println("2 - Nom ");
                                char repfinal3 = sc.nextLine().charAt(0);
                                if (repfinal3 == '1') {
                                    try {
                                        System.out.println("Veuillez entrez le nom du contact à ajoutez : ");
                                        String contactNameUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le prénom : ");
                                        String contactPrenomUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le nickname (Si vous en avez un ... !) : ");
                                        String contactNickNameUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez votre date de naissance (Au format jour/mois/année :");
                                        String contactDateDeNaissanceUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez la nationalité :");
                                        String contactNationaliteUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez l'adresse : ");
                                        String contactAdresseUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le numéros de maison ou block : ");
                                        String contactNumeroUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le numéro de boite (Si il existe ...!) : ");
                                        String contactNumeroBoiteUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le code postal : ");
                                        String contactCodePostalUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le pays : ");
                                        String contactPaysUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le numéros de Téléphone fixe : ");
                                        String contactTelFixeUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le numéros smartphone : ");
                                        String contactSmartPhoneUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez votre adresse mail : ");
                                        String contactEmailUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez les remarques éventuel à indiquez");
                                        String contactRemarqueUpdate = sc.nextLine();

                                        Contact contactUpdate = new Contact(idContact, contactNameUpdate, contactPrenomUpdate, contactNickNameUpdate, contactDateDeNaissanceUpdate, contactNationaliteUpdate, contactAdresseUpdate, contactNumeroUpdate, contactNumeroBoiteUpdate, contactCodePostalUpdate, contactPaysUpdate, contactTelFixeUpdate, contactSmartPhoneUpdate, contactEmailUpdate, contactRemarqueUpdate);
                                        dao.update(contactUpdate, idContact);
                                    } catch (Exception throwables) {
                                        System.out.println("Apparement il y a eu une erreur veuillez recommence et l'exception est : " + throwables.fillInStackTrace());
                                    }
                                } else if (repfinal3 == '2') {
                                    System.out.println("Pas d'opération sur le contact");
                                }
                            } else if (rep3 == '2') {
                                System.out.println("Pas d'opération sur le contact..");
                            }
                        }
                        // En fonction de sa date de naissance...
                        case '4' -> {
                            System.out.println("Veuillez entre la date de Naissance de votre contact");
                            String contactDateDeNaissance = sc.nextLine();
                            dao.getOneByBirthDate(contactDateDeNaissance);
                            System.out.println();
                            System.out.println("Votre contact existe t'il dans la liste ?");
                            System.out.println("1 - Oui");
                            System.out.println("2 - Nom");
                            char rep4 = sc.nextLine().charAt(0);
                            if (rep4 == '1') {
                                System.out.println("Veuillez entrez l'id exact de votre contact ");
                                String idContact = sc.nextLine();
                                System.out.println("Est-ce bien juste ? ");
                                System.out.println("Vous voulez modifier ce contact ?... ");
                                dao.getOne(idContact);
                                System.out.println("1 - Oui ");
                                System.out.println("2 - Nom ");
                                char repfinal4 = sc.nextLine().charAt(0);
                                if (repfinal4 == '1') {
                                    try {
                                        System.out.println("Veuillez entrez le nom du contact à ajoutez : ");
                                        String contactNameUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le prénom : ");
                                        String contactPrenomUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le nickname (Si vous en avez un ... !) : ");
                                        String contactNickNameUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez votre date de naissance (Au format jour/mois/année :");
                                        String contactDateDeNaissanceUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez la nationalité :");
                                        String contactNationaliteUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez l'adresse : ");
                                        String contactAdresseUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le numéros de maison ou block : ");
                                        String contactNumeroUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le numéro de boite (Si il existe ...!) : ");
                                        String contactNumeroBoiteUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le code postal : ");
                                        String contactCodePostalUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le pays : ");
                                        String contactPaysUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le numéros de Téléphone fixe : ");
                                        String contactTelFixeUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le numéros smartphone : ");
                                        String contactSmartPhoneUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez votre adresse mail : ");
                                        String contactEmailUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez les remarques éventuel à indiquez");
                                        String contactRemarqueUpdate = sc.nextLine();

                                        Contact contactUpdate = new Contact(idContact, contactNameUpdate, contactPrenomUpdate, contactNickNameUpdate, contactDateDeNaissanceUpdate, contactNationaliteUpdate, contactAdresseUpdate, contactNumeroUpdate, contactNumeroBoiteUpdate, contactCodePostalUpdate, contactPaysUpdate, contactTelFixeUpdate, contactSmartPhoneUpdate, contactEmailUpdate, contactRemarqueUpdate);
                                        dao.update(contactUpdate, idContact);
                                    } catch (Exception throwables) {
                                        System.out.println("Apparement il y a eu une erreur veuillez recommence et l'exception est : " + throwables.fillInStackTrace());
                                    }
                                } else if (repfinal4 == '2') {
                                    System.out.println("Pas d'opération sur le contact");
                                }
                            } else if (rep4 == '2') {
                                System.out.println("Pas d'opération sur le contact..");
                            }
                        }
                        // En fonction de son Id...
                        case '5' -> {
                            System.out.println("Veuillez entrez l'id de votre contact");
                            String contactId = sc.nextLine();
                            dao.getOne(contactId);
                            System.out.println();
                            System.out.println("Votre contact existe t'il dans la liste ?");
                            System.out.println("1 - Oui");
                            System.out.println("2 - Nom");
                            char rep5 = sc.nextLine().charAt(0);
                            if (rep5 == '1') {
                                System.out.println("Veuillez entrez l'id exact de votre contact ");
                                String idContact = sc.nextLine();
                                System.out.println("Est-ce bien juste ? ");
                                System.out.println("Vous voulez éffacer ce contact ?... ");
                                dao.getOne(idContact);
                                System.out.println("1 - Oui ");
                                System.out.println("2 - Nom ");
                                char repfinal5 = sc.nextLine().charAt(0);
                                if (repfinal5 == '1') {
                                    try {
                                        System.out.println("Veuillez entrez le nom du contact à ajoutez : ");
                                        String contactNameUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le prénom : ");
                                        String contactPrenomUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le nickname (Si vous en avez un ... !) : ");
                                        String contactNickNameUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez votre date de naissance (Au format jour/mois/année :");
                                        String contactDateDeNaissanceUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez la nationalité :");
                                        String contactNationaliteUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez l'adresse : ");
                                        String contactAdresseUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le numéros de maison ou block : ");
                                        String contactNumeroUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le numéro de boite (Si il existe ...!) : ");
                                        String contactNumeroBoiteUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le code postal : ");
                                        String contactCodePostalUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le pays : ");
                                        String contactPaysUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le numéros de Téléphone fixe : ");
                                        String contactTelFixeUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez le numéros smartphone : ");
                                        String contactSmartPhoneUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez votre adresse mail : ");
                                        String contactEmailUpdate = sc.nextLine();
                                        System.out.println("Veuillez entrez les remarques éventuel à indiquez");
                                        String contactRemarqueUpdate = sc.nextLine();

                                        Contact contactUpdate = new Contact(idContact, contactNameUpdate, contactPrenomUpdate, contactNickNameUpdate, contactDateDeNaissanceUpdate, contactNationaliteUpdate, contactAdresseUpdate, contactNumeroUpdate, contactNumeroBoiteUpdate, contactCodePostalUpdate, contactPaysUpdate, contactTelFixeUpdate, contactSmartPhoneUpdate, contactEmailUpdate, contactRemarqueUpdate);
                                        dao.update(contactUpdate, idContact);
                                    } catch (Exception throwables) {
                                        System.out.println("Apparement il y a eu une erreur veuillez recommence et l'exception est : " + throwables.fillInStackTrace());
                                    }
                                } else if (repfinal5 == '2') {
                                    System.out.println("Pas d'opération sur le contact");
                                }
                            } else if (rep5 == '2') {
                                System.out.println("Pas d'opération sur le contact..");
                            }
                        }
                        default -> System.out.println("Votre entrez ne correspond à aucunes des propositions");
                    }
                    break;
                // Effectuez une recherche à travers les contacts...
                case '3':
                    System.out.println("Veuillez entrez les informations du contact à rechercher");
                    System.out.println("Par quels références voulez-vous effectuez votre recherche ?");
                    System.out.println("1 - Son nom :");
                    System.out.println("2 - Son prénom :");
                    System.out.println("3 - Son adresse :");
                    System.out.println("4 - Sa date de naissance :");
                    System.out.println("5 - Son Identifiant :");
                    char choice3 = sc.nextLine().charAt(0);

                    switch (choice3){
                        // En fonction de son nom...
                        case '1':
                            System.out.println("Veuillez entrez son nom :");
                            String contactName = sc.nextLine();
                            System.out.println("Voiçi la liste des contact en rapport avec ce nom :");
                            dao.getOneByName(contactName);
                            break;
                        // En fonction de son prénom...
                        case '2':
                            System.out.println("Veuillez entrez son prenom :");
                            String contactPrenom = sc.nextLine();
                            System.out.println("Voiçi la liste des contact en rapport avec ce prénom :");
                            dao.getOneByFirstName(contactPrenom);
                            break;
                        // En fonction de son adresse...
                        case '3':
                            System.out.println("Veuillez entrez son adresse :");
                            String contactAdresse = sc.nextLine();
                            System.out.println("Voiçi la liste des contact en rapport avec cette adresse:");
                            dao.getOneByAdress(contactAdresse);
                            break;
                        // En fonction de sa date de naissance...
                        case '4':
                            System.out.println("Veuillez entre la date de Naissance de votre contact");
                            String contactDateDeNaissance = sc.nextLine();
                            System.out.println("Voiçi la liste des contact en rapport avec ces date de naissances:");
                            dao.getOneByBirthDate(contactDateDeNaissance);
                            break;
                        // En fonction de son Id...
                        case '5':
                            System.out.println("Veuillez entrez l'id de votre contact");
                            String contactId = sc.nextLine();
                            System.out.println("Voiçi le contact en rapport avec l'Id  :");
                            dao.getOne(contactId);
                            break;
                        default:
                    }


                    break;
                // Création d'une liste des contacts...
                case '4':
                    System.out.println("Voiçi une liste de l'ensemble de vos contacts");
                    dao.getAll();
                    break;
                case '5':
//                    System.out.println("Veuillez entrez l'ID");
//                    String idContact5 = sc.nextLine();
//                    System.out.println(contactId.get(idContact5).getNom());
                    break;
                // Suppréssion de contact dans la base de données...
                case '6':
                    System.out.println("Quels contact voulez-vous supprimez à travers votre gestionnaire :");
                    System.out.println("Par quels références voulez-vous effectuez votre recherche ?");
                    System.out.println("1 - Son nom :");
                    System.out.println("2 - Son prénom :");
                    System.out.println("3 - Son adresse :");
                    System.out.println("4 - Sa date de naissance :");
                    System.out.println("5 - Son Identifiant :");
                    char choice6 = sc.nextLine().charAt(0);
                    switch (choice6) {
                        // En fonction de son nom...
                        case '1' -> {
                            System.out.println("Veuillez entrez son nom :");
                            String contactName = sc.nextLine();
                            dao.getOneByName(contactName);
                            System.out.println();
                            System.out.println("Votre contact existe t'il dans la liste ?");
                            System.out.println("1 - Oui");
                            System.out.println("2 - Nom");
                            char rep = sc.nextLine().charAt(0);
                            if (rep == '1') {
                                System.out.println("Veuillez entrez l'id exact de votre contact ");
                                String idContact = sc.nextLine();
                                System.out.println("Est-ce bien juste ? ");
                                System.out.println("Vous voulez éffacer ce contact ?... ");
                                dao.getOne(idContact);
                                System.out.println("1 - Oui ");
                                System.out.println("2 - Nom ");
                                char repfinal = sc.nextLine().charAt(0);
                                if (repfinal == '1') {
                                    dao.delete(idContact);
                                    System.out.println("Votre contact est bien éffacer ...");
                                } else if (repfinal == '2') {
                                    System.out.println("Pas d'opération sur le contact");
                                }
                            } else if (rep == '2') {
                                System.out.println("Pas d'opération sur le contact..");
                            }
                        }
                        // En fonction de son prénom
                        case '2' -> {
                            System.out.println("Veuillez entrez son prenom :");
                            String contactPrenom = sc.nextLine();
                            dao.getOneByFirstName(contactPrenom);
                            System.out.println();
                            System.out.println("Votre contact existe t'il dans la liste ?");
                            System.out.println("1 - Oui");
                            System.out.println("2 - Nom");
                            char rep2 = sc.nextLine().charAt(0);
                            if (rep2 == '1') {
                                System.out.println("Veuillez entrez l'id exact de votre contact ");
                                String idContact = sc.nextLine();
                                System.out.println("Est-ce bien juste ? ");
                                System.out.println("Vous voulez éffacer ce contact ?... ");
                                dao.getOne(idContact);
                                System.out.println("1 - Oui ");
                                System.out.println("2 - Nom ");
                                char repfinal2 = sc.nextLine().charAt(0);
                                if (repfinal2 == '1') {
                                    dao.delete(idContact);
                                } else if (repfinal2 == '2') {
                                    System.out.println("Pas d'opération sur le contact");
                                }
                            } else if (rep2 == '2') {
                                System.out.println("Pas d'opération sur le contact..");
                            }
                        }
                        // En fonction de son adresse...
                        case '3' -> {
                            System.out.println("Veuillez entrez son adresse :");
                            String contactAdresse = sc.nextLine();
                            dao.getOneByAdress(contactAdresse);
                            System.out.println();
                            System.out.println("Votre contact existe t'il dans la liste ?");
                            System.out.println("1 - Oui");
                            System.out.println("2 - Nom");
                            char rep3 = sc.nextLine().charAt(0);
                            if (rep3 == '1') {
                                System.out.println("Veuillez entrez l'id exact de votre contact ");
                                String idContact = sc.nextLine();
                                System.out.println("Est-ce bien juste ? ");
                                System.out.println("Vous voulez éffacer ce contact ?... ");
                                dao.getOne(idContact);
                                System.out.println("1 - Oui ");
                                System.out.println("2 - Nom ");
                                char repfinal3 = sc.nextLine().charAt(0);
                                if (repfinal3 == '1') {
                                    dao.delete(idContact);
                                } else if (repfinal3 == '2') {
                                    System.out.println("Pas d'opération sur le contact");
                                }
                            } else if (rep3 == '2') {
                                System.out.println("Pas d'opération sur le contact..");
                            }
                        }
                        // En fonction de sa date de naissance...
                        case '4' -> {
                            System.out.println("Veuillez entre la date de Naissance de votre contact");
                            String contactDateDeNaissance = sc.nextLine();
                            dao.getOneByBirthDate(contactDateDeNaissance);
                            System.out.println();
                            System.out.println("Votre contact existe t'il dans la liste ?");
                            System.out.println("1 - Oui");
                            System.out.println("2 - Nom");
                            char rep4 = sc.nextLine().charAt(0);
                            if (rep4 == '1') {
                                System.out.println("Veuillez entrez l'id exact de votre contact ");
                                String idContact = sc.nextLine();
                                System.out.println("Est-ce bien juste ? ");
                                System.out.println("Vous voulez éffacer ce contact ?... ");
                                dao.getOne(idContact);
                                System.out.println("1 - Oui ");
                                System.out.println("2 - Nom ");
                                char repfinal4 = sc.nextLine().charAt(0);
                                if (repfinal4 == '1') {
                                    dao.delete(idContact);
                                } else if (repfinal4 == '2') {
                                    System.out.println("Pas d'opération sur le contact");
                                }
                            } else if (rep4 == '2') {
                                System.out.println("Pas d'opération sur le contact..");
                            }
                        }
                        // En fonction de l'id du contact...
                        case '5' -> {
                            System.out.println("Veuillez entrez l'id de votre contact");
                            String contactId = sc.nextLine();
                            dao.getOne(contactId);
                            System.out.println();
                            System.out.println("Votre contact existe t'il dans la liste ?");
                            System.out.println("1 - Oui");
                            System.out.println("2 - Nom");
                            char rep5 = sc.nextLine().charAt(0);
                            if (rep5 == '1') {
                                System.out.println("Veuillez entrez l'id exact de votre contact ");
                                String idContact = sc.nextLine();
                                System.out.println("Est-ce bien juste ? ");
                                System.out.println("Vous voulez éffacer ce contact ?... ");
                                dao.getOne(idContact);
                                System.out.println("1 - Oui ");
                                System.out.println("2 - Nom ");
                                char repfinal5 = sc.nextLine().charAt(0);
                                if (repfinal5 == '1') {
                                    dao.delete(idContact);
                                } else if (repfinal5 == '2') {
                                    System.out.println("Pas d'opération sur le contact");
                                }
                            } else if (rep5 == '2') {
                                System.out.println("Pas d'opération sur le contact..");
                            }
                        }
                        default -> System.out.println("Votre entrée ne corresponds à aucunes des propositions");
                    }

                    break;
                // Sortie et cloture de sql
                case '7':
                    System.out.println("Merçi et au revoir...!");
                    // Fermeture de la connexion sql...
                    try {
                        conn.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    quit = true;
                    break;

                default:
                    System.out.println("Ce choix ne correspond à aucunes des proposition");
                    System.out.println("Veuillez re-commencer...");
            }
        }while (!quit);

    }

}
