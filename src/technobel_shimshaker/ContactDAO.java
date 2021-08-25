package technobel_shimshaker;
// Interface DataBase Access Objet
public interface ContactDAO {

    //CREATE Fonction de création de contact
    void insert(Contact contact);

    //Read Fonction de lecture sur les contacts
    void getOne(String id);
    void getOneByName(String contactNom);
    void getOneByFirstName(String contactPrenom);
    void getOneByAdress(String contactAdresse);
    void getOneByBirthDate(String contactDateDeNaissance);
    void getAll();

    // UPDATE Fonction de mise à jour sur les contacts
    void update(Contact contact, String idContact);

    //DELETE Fonction de suppréssion sur les contacts
    void delete(String id);


}
