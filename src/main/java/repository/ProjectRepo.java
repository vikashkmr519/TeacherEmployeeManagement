package repository;

import entity.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProjectRepo {

    private SessionFactory factory = null;

    public ProjectRepo(SessionFactory factory){
        this.factory = factory;
    }

    public Project fetchProject(int pid){
        Session session = factory.openSession();
        Project project = session.get(Project.class,pid);

        session.close();
        return project;
    }

}
