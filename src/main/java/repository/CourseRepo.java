package repository;

import entity.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CourseRepo {

    private SessionFactory factory = null;

    public CourseRepo(SessionFactory factory){
        this.factory = factory;
    }

    public void deleteCourse(int id){
        Session session = factory.openSession();
        Course course = session.get(Course.class,id);
        Transaction tx = session.beginTransaction();
        session.remove(course);
        tx.commit();
        session.close();
    }
}
