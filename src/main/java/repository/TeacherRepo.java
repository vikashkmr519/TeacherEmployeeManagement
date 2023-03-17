package repository;

import entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TeacherRepo {

    private SessionFactory factory = null;

    public TeacherRepo(SessionFactory factory){
        this.factory = factory;
    }

    public void insertTeacher(Teacher teacher){
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(teacher);
        tx.commit();
        session.close();
    }


    public void deleteTeacher(int  id){
        Session session = factory.openSession();
        Teacher teacher = session.get(Teacher.class,id);
        Transaction tx = session.beginTransaction();
        session.remove(teacher);
        tx.commit();
        session.close();
    }

    public void updateTeacher(String firstName, String lastName, String email){
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.createQuery("update Teacher set firstName=:firstName and lastName=:lastName where email=:email")
                .setParameter("firstName",firstName)
                .setParameter("lastName",lastName)
                .setParameter("email",email).executeUpdate();

        tx.commit();
        session.close();
    }

    public Teacher fetchTeacher(int id){
        Session session = factory.openSession();
        Teacher teacher = session.get(Teacher.class,id);
        session.close();
        return teacher;
    }


}
