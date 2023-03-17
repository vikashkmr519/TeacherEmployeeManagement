package service;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.StudentRepo;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private StudentRepo repo = null;

    public StudentService(SessionFactory factory){
        repo = new StudentRepo(factory);
    }

    public void insertStudent(Student student){
        try{
            this.repo.insertStudent(student);
            System.out.println("Successfully Added Student");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    public void deleteStudent(int sid){
      try {
          this.repo.deleteStudent(sid);
          System.out.println("Successfully Deleted Student");
      }catch (Exception ex){
          System.out.println(ex.getMessage());
      }
    }

    public List<Student> fetchAllStudents(){
        List<Student> students = new ArrayList<>();
        try{
           students = repo.fetchAllStudent();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return students;
    }

    public void fetchStudent(int id){
        try{
            System.out.println(repo.fetchAStudent(id));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
