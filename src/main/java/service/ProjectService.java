package service;

import entity.Project;
import org.hibernate.SessionFactory;
import repository.ProjectRepo;

public class ProjectService {

    private ProjectRepo repo = null;

    public ProjectService(SessionFactory factory){
        this.repo = new ProjectRepo(factory);
    }

    public Project fetchProject(int id){
        return this.fetchProject(id);
    }
}
