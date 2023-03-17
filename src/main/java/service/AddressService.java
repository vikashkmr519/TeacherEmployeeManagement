package service;

import entity.Student;
import org.hibernate.SessionFactory;
import repository.AddressRepo;

public class AddressService {

    private AddressRepo repo = null;

    public AddressService(SessionFactory factory){
        repo = new AddressRepo(factory);
    }

    public Student fetchStudentViaAddress(int id){
        return this.repo.fetchAddress(id).getStudent();
    }
}
