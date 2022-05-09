package com.project.pmstool.ms.services;

import java.util.List;

import com.project.pmstool.ms.dto.ProjectDTO;



public interface ProjectDataService {
    ProjectDTO createProject(ProjectDTO Project);

    List<ProjectDTO> getAllProjects();

    boolean deleteProject(Long id);

    ProjectDTO getProjectById(Long id);

    ProjectDTO updateProject(Long id, ProjectDTO Project);
    
    Integer getTotalCompletedProjects();
    
    Integer getTotalInProgressProjects();
    
    
}
