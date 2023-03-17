package repository;

import entity.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AddressRepo {

    private SessionFactory factory = null;

    public AddressRepo(SessionFactory factory){
        this.factory = factory;
    }

    public Address fetchAddress(int id){
        Session session = factory.openSession();
        Address address = session.get(Address.class,id);
        session.close();

        return address;
    }
}
