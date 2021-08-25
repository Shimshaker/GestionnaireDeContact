package technobel_shimshaker;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class InterfaceConsole {

    protected static String username = "Shimshaker";
    protected static String password = "Shake316497sql";
    private static String dbURL = "jdbc:sqlserver://COSMOSDESKTOP\\mssqlserver";
    public static Connection conn;

    static {
        try {
            conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                System.out.println("Connected");
            }
        } catch (SQLException throwables) {
            System.out.println("Connection Fail");
            throwables.printStackTrace();
        }
    }
    private final Scanner sc = new Scanner(System.in);
    private final Timer waitTime = new Timer();
    private final  Map<String, Contact> contactId = new HashMap<>();
    private Object Contact;
    boolean quit;

    public void start(){
        ContactDAO dao = new ContactDAOImpl();

        do {
            System.out.println("Bienvenue dans votre gestionnaire de contact");
            System.out.println("Içi vous pouvez effectuez divers taches sur vos contact");
            System.out.println("1 - Ajouter un contact dans votre gestionnaire");
            System.out.println("2 - Modifiez un contact dans votres gestionnaire");
            System.out.println("3 - Effectuez une recherche au travers votre gestionnaire");
            System.out.println("4 - Créer une liste de vos contact");
            System.out.println("5 - Créer une liste spécifique de vos contacts");
            System.out.println("6 - Supprimez un contact de votre gestionnaire");
            System.out.println("7 - Quitter");
            char choice = sc.nextLine().charAt(0);

            switch (choice){
                case '1':

                    try {

                        System.out.println("Veuillez entrer le nom du contact à ajoutez : ");
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
                        Integer contactNumero = Integer.parseInt(sc.nextLine());
                        System.out.println("Veuillez entrez le numéro de boite (Si il existe ...!) : ");
                        Integer contactNumeroBoite = Integer.parseInt(sc.nextLine());
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

                    }catch (Exception e){
                        System.out.println(new StringBuilder().append("Apparement il y a eu une erreur veuillez recommence et l'exception est : ").append(e.fillInStackTrace()));
                    }

                    break;
                case '2':
                    System.out.println("Quels contact voulez-vous modifiez qui à travers votre gestionnaire :");
                    System.out.println("Par quels références voulez-vous effectuez votre recherche ?");
                    System.out.println("1 - Son nom :");
                    System.out.println("2 - Son prénom :");
                    System.out.println("3 - Son adresse :");
                    System.out.println("4 - Sa date de naissance :");
                    System.out.println("5 - Son Identifiant :");
                    char choice2 = sc.nextLine().charAt(0);
                    switch (choice2){
                        case '1':
                            System.out.println("Veuillez entrez son nom :");
                            String contactName = sc.nextLine();
                            dao.getOneByName(contactName);

                            System.out.println("");
                            System.out.println("Votre contact existe t'il dans la liste ?");
                            System.out.println("1 - Oui");
                            System.out.println("2 - Nom");
                            char rep = sc.nextLine().charAt(0);

                            if (rep == '1'){
                                System.out.println("Veuillez entrez l'id exact de votre contact ");
                                String idContact = sc.nextLine();
                                System.out.println("Est-ce bien juste ? ");
                                System.out.println("Vous voulez modifier ce contact ?... ");
                                dao.getOne(idContact);
                                System.out.println("1 - Oui ");
                                System.out.println("2 - Nom ");
                                char repfinal = sc.nextLine().charAt(0);
                                if (repfinal == '1'){
                                    try {

                                        System.out.println("Veuillez entrer le nom du contact à ajoutez : ");
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
                                        Integer contactNumeroUpdate = Integer.parseInt(sc.nextLine());
                                        System.out.println("Veuillez entrez le numéro de boite (Si il existe ...!) : ");
                                        Integer contactNumeroBoiteUpdate = Integer.parseInt(sc.nextLine());
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
                                    }catch (Exception e){
                                        System.out.println(new StringBuilder().append("Apparement il y a eu une erreur veuillez recommence et l'exception est : ").append(e.fillInStackTrace()));
                                    }

                                }else if(repfinal == '2'){
                                    System.out.println("Pas d'opération sur le contact");
                                }
                            }else if (rep == '2'){
                            System.out.println("Pas d'opération sur le contact..");
                            }
                            break;
                        case '2':
                            System.out.println("Veuillez entrez son prenom :");
                            String contactPrenom = sc.nextLine();
                            dao.getOneByFirstName(contactPrenom);

                            System.out.println("");
                            System.out.println("Votre contact existe t'il dans la liste ?");
                            System.out.println("1 - Oui");
                            System.out.println("2 - Nom");
                            char rep2 = sc.nextLine().charAt(0);

                            if (rep2 == '1'){
                                System.out.println("Veuillez entrez l'id exact de votre contact ");
                                String idContact = sc.nextLine();
                                System.out.println("Est-ce bien juste ? ");
                                System.out.println("Vous voulez modifier ce contact ?... ");
                                dao.getOne(idContact);
                                System.out.println("1 - Oui ");
                                System.out.println("2 - Nom ");
                                char repfinal2 = sc.nextLine().charAt(0);
                                if (repfinal2 == '1'){
                                    try {

                                        System.out.println("Veuillez entrer le nom du contact à ajoutez : ");
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
                                        Integer contactNumeroUpdate = Integer.parseInt(sc.nextLine());
                                        System.out.println("Veuillez entrez le numéro de boite (Si il existe ...!) : ");
                                        Integer contactNumeroBoiteUpdate = Integer.parseInt(sc.nextLine());
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
                                    }catch (Exception e){
                                        System.out.println(new StringBuilder().append("Apparement il y a eu une erreur veuillez recommence et l'exception est : ").append(e.fillInStackTrace()));
                                    }
                                }else if(repfinal2 == '2'){
                                    System.out.println("Pas d'opération sur le contact");
                                }
                            }else if (rep2 == '2'){
                                System.out.println("Pas d'opération sur le contact..");
                            }
                            break;
                        case '3':
                            System.out.println("Veuillez entrez son adresse :");
                            String contactAdresse = sc.nextLine();
                            dao.getOneByAdress(contactAdresse);

                            System.out.println("");
                            System.out.println("Votre contact existe t'il dans la liste ?");
                            System.out.println("1 - Oui");
                            System.out.println("2 - Nom");
                            char rep3 = sc.nextLine().charAt(0);

                            if (rep3 == '1'){
                                System.out.println("Veuillez entrez l'id exact de votre contact ");
                                String idContact = sc.nextLine();
                                System.out.println("Est-ce bien juste ? ");
                                System.out.println("Vous voulez modifier ce contact ?... ");
                                dao.getOne(idContact);
                                System.out.println("1 - Oui ");
                                System.out.println("2 - Nom ");
                                char repfinal3 = sc.nextLine().charAt(0);
                                if (repfinal3 == '1'){
                                    try {
                                        System.out.println("Veuillez entrer le nom du contact à ajoutez : ");
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
                                        Integer contactNumeroUpdate = Integer.parseInt(sc.nextLine());
                                        System.out.println("Veuillez entrez le numéro de boite (Si il existe ...!) : ");
                                        Integer contactNumeroBoiteUpdate = Integer.parseInt(sc.nextLine());
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
                                    }catch (Exception e){
                                        System.out.println(new StringBuilder().append("Apparement il y a eu une erreur veuillez recommence et l'exception est : ").append(e.fillInStackTrace()));
                                    }
                                }else if(repfinal3 == '2'){
                                    System.out.println("Pas d'opération sur le contact");
                                }
                            }else if (rep3 == '2'){
                                System.out.println("Pas d'opération sur le contact..");
                            }
                            break;
                        case '4':
                            System.out.println("Veuillez entre la date de Naissance de votre contact");
                            String contactDateDeNaissance = sc.nextLine();
                            dao.getOneByBirthDate(contactDateDeNaissance);

                            System.out.println("");
                            System.out.println("Votre contact existe t'il dans la liste ?");
                            System.out.println("1 - Oui");
                            System.out.println("2 - Nom");
                            char rep4 = sc.nextLine().charAt(0);

                            if (rep4 == '1'){
                                System.out.println("Veuillez entrez l'id exact de votre contact ");
                                String idContact = sc.nextLine();
                                System.out.println("Est-ce bien juste ? ");
                                System.out.println("Vous voulez modifier ce contact ?... ");
                                dao.getOne(idContact);
                                System.out.println("1 - Oui ");
                                System.out.println("2 - Nom ");
                                char repfinal4 = sc.nextLine().charAt(0);
                                if (repfinal4 == '1'){
                                    try {
                                        System.out.println("Veuillez entrer le nom du contact à ajoutez : ");
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
                                        Integer contactNumeroUpdate = Integer.parseInt(sc.nextLine());
                                        System.out.println("Veuillez entrez le numéro de boite (Si il existe ...!) : ");
                                        Integer contactNumeroBoiteUpdate = Integer.parseInt(sc.nextLine());
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
                                    }catch (Exception e){
                                        System.out.println(new StringBuilder().append("Apparement il y a eu une erreur veuillez recommence et l'exception est : ").append(e.fillInStackTrace()));
                                    }
                                }else if(repfinal4 == '2'){
                                    System.out.println("Pas d'opération sur le contact");
                                }
                            }else if (rep4 == '2'){
                                System.out.println("Pas d'opération sur le contact..");
                            }
                            break;
                        case '5':
                            System.out.println("Veuillez entrez l'id de votre contact");
                            String contactId = sc.nextLine();
                            dao.getOne(contactId);

                            System.out.println("");
                            System.out.println("Votre contact existe t'il dans la liste ?");
                            System.out.println("1 - Oui");
                            System.out.println("2 - Nom");
                            char rep5 = sc.nextLine().charAt(0);

                            if (rep5 == '1'){
                                System.out.println("Veuillez entrez l'id exact de votre contact ");
                                String idContact = sc.nextLine();
                                System.out.println("Est-ce bien juste ? ");
                                System.out.println("Vous voulez effacer ce contact ?... ");
                                dao.getOne(idContact);
                                System.out.println("1 - Oui ");
                                System.out.println("2 - Nom ");
                                char repfinal5 = sc.nextLine().charAt(0);
                                if (repfinal5 == '1'){
                                    try {
                                        System.out.println("Veuillez entrer le nom du contact à ajoutez : ");
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
                                        Integer contactNumeroUpdate = Integer.parseInt(sc.nextLine());
                                        System.out.println("Veuillez entrez le numéro de boite (Si il existe ...!) : ");
                                        Integer contactNumeroBoiteUpdate = Integer.parseInt(sc.nextLine());
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
                                    }catch (Exception e){
                                        System.out.println(new StringBuilder().append("Apparement il y a eu une erreur veuillez recommence et l'exception est : ").append(e.fillInStackTrace()));
                                    }
                                }else if(repfinal5 == '2'){
                                    System.out.println("Pas d'opération sur le contact");
                                }
                            }else if (rep5 == '2'){
                                System.out.println("Pas d'opération sur le contact..");
                            }
                            break;
                        default:
                            System.out.println("Votre entrez ne correspond à aucunes des propositions");

                    }
                    break;
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
                        case '1':
                            System.out.println("Veuillez entrez son nom :");
                            String contactName = sc.nextLine();
                            System.out.println("Voiçi la liste des contact en rapport avec ce nom :");
                            dao.getOneByName(contactName);
                            break;
                        case '2':
                            System.out.println("Veuillez entrez son prenom :");
                            String contactPrenom = sc.nextLine();
                            System.out.println("Voiçi la liste des contact en rapport avec ce prénom :");
                            dao.getOneByFirstName(contactPrenom);
                            break;
                        case '3':
                            System.out.println("Veuillez entrez son adresse :");
                            String contactAdresse = sc.nextLine();
                            System.out.println("Voiçi la liste des contact en rapport avec cette adresse:");
                            dao.getOneByAdress(contactAdresse);
                            break;
                        case '4':
                            System.out.println("Veuillez entre la date de Naissance de votre contact");
                            String contactDateDeNaissance = sc.nextLine();
                            System.out.println("Voiçi la liste des contact en rapport avec ces date de naissances:");
                            dao.getOneByBirthDate(contactDateDeNaissance);
                            break;
                        case '5':
                            System.out.println("Veuillez entrez l'id de votre contact");
                            String contactId = sc.nextLine();
                            System.out.println("Voiçi le contact en rapport avec l'Id  :");
                            dao.getOne(contactId);
                            break;
                        default:
                    }


                    break;
                case '4':
                    System.out.println("Voiçi une liste de l'ensemble de vos contacts");
                    dao.getAll();
                    break;
                case '5':

                    break;
                case '6':
                    System.out.println("Quels contact voulez-vous supprimez à travers votre gestionnaire :");
                    System.out.println("Par quels références voulez-vous effectuez votre recherche ?");
                    System.out.println("1 - Son nom :");
                    System.out.println("2 - Son prénom :");
                    System.out.println("3 - Son adresse :");
                    System.out.println("4 - Sa date de naissance :");
                    System.out.println("5 - Son Identifiant :");
                    char choice6 = sc.nextLine().charAt(0);
                    switch (choice6){
                        case '1':
                            System.out.println("Veuillez entrez son nom :");
                            String contactName = sc.nextLine();
                            dao.getOneByName(contactName);

                            System.out.println("");
                            System.out.println("Votre contact existe t'il dans la liste ?");
                            System.out.println("1 - Oui");
                            System.out.println("2 - Nom");
                            char rep = sc.nextLine().charAt(0);

                            if (rep == '1'){
                                System.out.println("Veuillez entrez l'id exact de votre contact ");
                                String idContact = sc.nextLine();
                                System.out.println("Est-ce bien juste ? ");
                                System.out.println("Vous voulez effacer ce contact ?... ");
                                dao.getOne(idContact);
                                System.out.println("1 - Oui ");
                                System.out.println("2 - Nom ");
                                char repfinal = sc.nextLine().charAt(0);
                                if (repfinal == '1'){
                                    dao.delete(idContact);
                                    System.out.println("Votre contact est bien effacer ...");
                                }else if(repfinal == '2'){
                                    System.out.println("Pas d'opération sur le contact");
                                }
                            }else if (rep == '2'){
                                System.out.println("Pas d'opération sur le contact..");
                            }
                            break;
                        case '2':
                            System.out.println("Veuillez entrez son prenom :");
                            String contactPrenom = sc.nextLine();
                            dao.getOneByFirstName(contactPrenom);

                            System.out.println("");
                            System.out.println("Votre contact existe t'il dans la liste ?");
                            System.out.println("1 - Oui");
                            System.out.println("2 - Nom");
                            char rep2 = sc.nextLine().charAt(0);

                            if (rep2 == '1'){
                                System.out.println("Veuillez entrez l'id exact de votre contact ");
                                String idContact = sc.nextLine();
                                System.out.println("Est-ce bien juste ? ");
                                System.out.println("Vous voulez effacer ce contact ?... ");
                                dao.getOne(idContact);
                                System.out.println("1 - Oui ");
                                System.out.println("2 - Nom ");
                                char repfinal2 = sc.nextLine().charAt(0);
                                if (repfinal2 == '1'){
                                    dao.delete(idContact);
                                }else if(repfinal2 == '2'){
                                    System.out.println("Pas d'opération sur le contact");
                                }
                            }else if (rep2 == '2'){
                                System.out.println("Pas d'opération sur le contact..");
                            }
                            break;
                        case '3':
                            System.out.println("Veuillez entrez son adresse :");
                            String contactAdresse = sc.nextLine();
                            dao.getOneByAdress(contactAdresse);

                            System.out.println("");
                            System.out.println("Votre contact existe t'il dans la liste ?");
                            System.out.println("1 - Oui");
                            System.out.println("2 - Nom");
                            char rep3 = sc.nextLine().charAt(0);

                            if (rep3 == '1'){
                                System.out.println("Veuillez entrez l'id exact de votre contact ");
                                String idContact = sc.nextLine();
                                System.out.println("Est-ce bien juste ? ");
                                System.out.println("Vous voulez effacer ce contact ?... ");
                                dao.getOne(idContact);
                                System.out.println("1 - Oui ");
                                System.out.println("2 - Nom ");
                                char repfinal3 = sc.nextLine().charAt(0);
                                if (repfinal3 == '1'){
                                    dao.delete(idContact);
                                }else if(repfinal3 == '2'){
                                    System.out.println("Pas d'opération sur le contact");
                                }
                            }else if (rep3 == '2'){
                                System.out.println("Pas d'opération sur le contact..");
                            }
                            break;
                        case '4':
                            System.out.println("Veuillez entre la date de Naissance de votre contact");
                            String contactDateDeNaissance = sc.nextLine();
                            dao.getOneByBirthDate(contactDateDeNaissance);

                            System.out.println("");
                            System.out.println("Votre contact existe t'il dans la liste ?");
                            System.out.println("1 - Oui");
                            System.out.println("2 - Nom");
                            char rep4 = sc.nextLine().charAt(0);

                            if (rep4 == '1'){
                                System.out.println("Veuillez entrez l'id exact de votre contact ");
                                String idContact = sc.nextLine();
                                System.out.println("Est-ce bien juste ? ");
                                System.out.println("Vous voulez effacer ce contact ?... ");
                                dao.getOne(idContact);
                                System.out.println("1 - Oui ");
                                System.out.println("2 - Nom ");
                                char repfinal4 = sc.nextLine().charAt(0);
                                if (repfinal4 == '1'){
                                    dao.delete(idContact);
                                }else if(repfinal4 == '2'){
                                    System.out.println("Pas d'opération sur le contact");
                                }
                            }else if (rep4 == '2'){
                                System.out.println("Pas d'opération sur le contact..");
                            }
                            break;
                        case '5':
                            System.out.println("Veuillez entrez l'id de votre contact");
                            String contactId = sc.nextLine();
                            dao.getOne(contactId);

                            System.out.println("");
                            System.out.println("Votre contact existe t'il dans la liste ?");
                            System.out.println("1 - Oui");
                            System.out.println("2 - Nom");
                            char rep5 = sc.nextLine().charAt(0);

                            if (rep5 == '1'){
                                System.out.println("Veuillez entrez l'id exact de votre contact ");
                                String idContact = sc.nextLine();
                                System.out.println("Est-ce bien juste ? ");
                                System.out.println("Vous voulez effacer ce contact ?... ");
                                dao.getOne(idContact);
                                System.out.println("1 - Oui ");
                                System.out.println("2 - Nom ");
                                char repfinal5 = sc.nextLine().charAt(0);
                                if (repfinal5 == '1'){
                                    dao.delete(idContact);
                                }else if(repfinal5 == '2'){
                                    System.out.println("Pas d'opération sur le contact");
                                }
                            }else if (rep5 == '2'){
                                System.out.println("Pas d'opération sur le contact..");
                            }
                            break;
                        default:
                            System.out.println("Votre entrez ne correspond à aucunes des propositions");

                    }

                    break;
                case '7':
                    System.out.println("Merçi et au revoir...!");
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

    private static void readSelect(String contactID) {
        try {
            String sql = "SELECT * FROM dbo.contact WHERE id = ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, contactID);

            ResultSet result = statement.executeQuery();

            int count = 0;

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
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }


    }

}
