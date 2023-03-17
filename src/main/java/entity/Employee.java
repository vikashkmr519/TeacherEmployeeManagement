package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "empname", length = 255)
    private String empname;

    @Column(name = "phone", length = 10)
    private String phone;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="employee_project",
    joinColumns = {@JoinColumn(name = "employee_id")},
    inverseJoinColumns = {@JoinColumn(name="project_id")})
    private List<Project> projects;

    public Employee() {
    }

    public Employee(String email, String empname, String phone) {
        this.email = email;
        this.empname = empname;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "email='" + email + '\'' +
                ", empname='" + empname + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
