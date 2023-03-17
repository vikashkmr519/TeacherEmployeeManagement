package service;

import org.hibernate.SessionFactory;
import repository.CourseRepo;

public class CourseService {

    private CourseRepo repo = null;

    public CourseService(SessionFactory factory){
        repo = new CourseRepo(factory);
    }

    public  void deleteCourse(int id){
        this.repo.deleteCourse(id);
    }
}
