package technobel_shimshaker;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class InterfaceConsole {


    private final Scanner sc = new Scanner(System.in);
    private final Timer waitTime = new Timer();
    private final  Map<Integer, Contact> contactId = new HashMap<>();
    public static final List<Contact> contactList = new ArrayList<>();
    private Object Contact;
    boolean quit;

    public void start(){

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

                        //String newcontact = UUID.randomUUID().toString();

                        int newIdMap = contactId.size() + 1;

                        contactId.put(newIdMap, new Contact(newIdMap, contactName, contactPrenom, contactNickName, contactDateDeNaissance, contactNationalite, contactAdresse, contactNumero, contactNumeroBoite, contactCodePostal, contactPays, contactTelFixe, contactSmartPhone, contactEmail, contactRemarque));

                    }catch (Exception e){
                        System.out.println(new StringBuilder().append("Apparement il y a eu une erreur veuillez recommence et l'exception est : ").append(e.fillInStackTrace()));
                    }

                    break;
                case '2':
                    System.out.println("Quels contact voulez-vous modifiez qui à travers votre gestionnaire :");
                    System.out.println("Veuillez entrez son nom :");
                    String contactName = sc.nextLine();
                    System.out.println("Veuillez entrez son prenom :");
                    String contactPrenom = sc.nextLine();
                    System.out.println("Veuillez entrez son adresse :");
                    String contactAdresse = sc.nextLine();
                    System.out.println("Veuillez entrez son numero de maison :");
                    Integer contactNumero = Integer.parseInt(sc.nextLine());
                    System.out.println("Veuillez entrez son numero de boite aux lettres :");
                    Integer contactNumeroBoite = Integer.parseInt(sc.nextLine());
                    System.out.println("Veuillez entrez le code postal : ");
                    String contactCodePostal = sc.nextLine();

                    try{
                        contactList.stream()
                                .filter(e -> {
                                    return e.getCodepostal().matches(contactCodePostal) && e.getNom().matches(contactName) && e.getPrenom().matches(contactPrenom)
                                            && e.getAdresse().matches(contactAdresse) && contactNumero.equals(e.getNumero()) && contactNumeroBoite.equals(e.getBoite());
                                })
                                .map(e -> e.toString())
                                .forEach(System.out::println);

                       if (contactId.values().equals(contactId)){
                           System.out.println("It's ok..");
                       }


                        TimeUnit.SECONDS.sleep(5);
                    }catch (Exception e){
                        System.out.println("Nous n'avons pas trouvé cette référence dans le gestionnaire" + e.getLocalizedMessage());

                    }
                    System.out.println("Est-ce bien le contact à modifier ? :");
                    System.out.println("1 - oui ");
                    System.out.println("2 - non");

                    Integer reponse = Integer.parseInt(sc.nextLine());

                    if (reponse == 1){

                    }


                    break;
                case '3':

                    break;
                case '4':
                    contactList.stream()
                            .map(e -> e.toString())
                            .forEach(System.out::println);

                    break;
                case '5':

                    break;
                case '6':

                    break;
                case '7':
                    System.out.println("Merçi et au revoir...!");
                    quit = true;
                    break;

                default:
                    System.out.println("Ce choix ne correspond à aucunes des proposition");
                    System.out.println("Veuillez re-commencer...");
            }
        }while (!quit);



    }
}
