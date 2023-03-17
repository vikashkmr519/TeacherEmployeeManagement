package service;

import entity.Teacher;
import org.hibernate.SessionFactory;
import repository.TeacherRepo;

public class TeacherService {

    private SessionFactory factory = null;
    private TeacherRepo repo = null;

    public TeacherService(SessionFactory factory){
        this.factory = factory;
        repo=  new TeacherRepo(this.factory);
    }

    public void insertTeacher(Teacher teacher){
        this.repo.insertTeacher(teacher);
    }

    public void deleteTeacher(int id){
        this.repo.deleteTeacher(id);
    }

    public void updateTeacher(String firstName, String lastName, String email){
        this.repo.updateTeacher(firstName,lastName,email);
    }

    public Teacher fetchTeacher(int id){
        return this.repo.fetchTeacher(id);
    }
}
