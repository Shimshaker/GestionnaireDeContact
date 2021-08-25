package technobel_shimshaker;

public interface ContactDAO {

    //CREATE
    void insert(Contact contact);

    //Read
    void getOne(String id);
    void getOneByName(String contactNom);
    void getOneByFirstName(String contactPrenom);
    void getOneByAdress(String contactAdresse);
    void getOneByBirthDate(String contactDateDeNaissance);
    void getAll();

    // UPDATE
    void update(Contact contact, String idContact);

    //DELETE
    void delete(String id);


}
