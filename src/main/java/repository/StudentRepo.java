package repository;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StudentRepo {

    private SessionFactory factory = null;

    public StudentRepo(SessionFactory factory){
        this.factory = factory;
    }

    public void insertStudent(Student student) throws Exception {
        try {
            Session session = factory.openSession();

            Transaction tx = session.beginTransaction();
            session.persist(student);
            tx.commit();
            session.close();
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public void deleteStudent(int sid) throws Exception {
        Session session= factory.openSession();
        try {
            Student student = session.get(Student.class, sid);
            Transaction tx = session.beginTransaction();
            session.remove(student);
            tx.commit();
            session.close();
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }

    }

    public List<Student> fetchAllStudent() throws Exception {
        List<Student> students = new ArrayList<>();
        try{

            Session session = factory.openSession();
             students = session.createQuery("from Student").getResultList();


        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
        return students;
    }

    public Student fetchAStudent(int id) throws Exception {
        try{
            Session session = factory.openSession();
            return session.get(Student.class,id);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }




}
