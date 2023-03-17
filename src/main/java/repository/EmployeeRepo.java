package repository;

import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeRepo {

    private SessionFactory factory = null;

    public EmployeeRepo(SessionFactory factory){
        this.factory= factory;
    }

    public void insertEmployee(Employee employee){
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(employee);
        tx.commit();
        session.close();
    }

    public void deleteEmployee(String email){
        Session session = factory.openSession();
        Employee employee = session.get(Employee.class, email);
        Transaction tx = session.beginTransaction();
        session.remove(employee);
        tx.commit();
        session.close();
    }

    public List<Employee> fetchAllEmployees(){
        Session session = factory.openSession();
        List<Employee> employees = session.createQuery("from Employee").getResultList();
        session.close();
        return employees;
    }
}
