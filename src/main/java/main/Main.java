package main;

import entity.*;
import hibernateConfig.Config;
import org.hibernate.SessionFactory;
import repository.EmployeeRepo;
import repository.TeacherRepo;
import service.AddressService;
import service.CourseService;
import service.StudentService;
import service.TeacherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static SessionFactory factory = Config.getSessionFactory();
    public static void main(String[] args) {

        /**
         * INTERFACE HAS NOT BEEN CREATED
         *
         * All the methods for the required questions has been added in the repo classes
         * and these are working. You can check Entity classes for proper mapping.
         */


    }




    public static void student(Scanner sc){

    }

    public static void deleteCourse(){
        CourseService service = new CourseService(factory);
        service.deleteCourse(1);
    }
    public static void insertTeacher(){
        TeacherService service = new TeacherService(factory);

        Teacher teacher = new Teacher();
        teacher.setEmail("abc@gmail.com");
        teacher.setFirstName("abc");
        teacher.setLastName("def");
        service.insertTeacher(teacher);

    }

    public static  void insertStudent(StudentService service, Scanner sc){
        Student student = new Student();
        System.out.println("Enter name ");
        student.setName(sc.nextLine());

        System.out.println("Enter Technoogy user");
        student.setTechnology(sc.nextLine());
        Address address = new Address();
        System.out.println("Enter city");
        address.setCity(sc.nextLine());
        System.out.println("Enter Country");
        address.setCountry(sc.nextLine());
        student.setAddress(address);
        List<Course> courseList = new ArrayList<>();
        Course course = new Course();
        System.out.println("Enter course name");
        course.setCourseName(sc.nextLine());
        course.setStudent(student);
        courseList.add(course);
        student.setCourseList(courseList);
        service.insertStudent(student);
    }

    public static void deleteStudent(StudentService service, Scanner sc){
        System.out.println("Enter id of Student");
        service.deleteStudent(sc.nextInt());
        sc.nextLine();
    }

    public static void fetchStudentViaAddress(){
        AddressService service = new AddressService(factory);
        int sid = service.fetchStudentViaAddress(2).getSid();
        System.out.println(sid);
    }
}
