package technobel_shimshaker;

public interface ContactDAO {

    //CREATE
    void insert(Contact contact);

    //Read
    void getOne(String id);
    void getAll();

    // UPDATE
    void update(Contact contact);

    //DELETE
    void delete(String id);


}
