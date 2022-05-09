package com.project.pmstool.ms.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.pmstool.ms.dto.ProjectDTO;
import com.project.pmstool.ms.model.Project;
import com.project.pmstool.ms.repository.ProjectRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectDataServiceImpl implements ProjectDataService {

	@Autowired
	private ProjectRepository projectRepository;



	@Override
	public ProjectDTO createProject(ProjectDTO project) {
		Project projectEntity = new Project();

		BeanUtils.copyProperties(project, projectEntity);
		projectRepository.save(projectEntity);
		return project;
	}

	@Override
	public List<ProjectDTO> getAllProjects() {
		List<Project> ProjectEntities = projectRepository.findAll();

		List<ProjectDTO> Projects = ProjectEntities.stream()
				.map(project -> new ProjectDTO(project.getProjectId(), project.getSector(), project.getAccount(),
						project.getProjectName(), project.getProjectTitle(), project.getProjectDescription(),
						project.getStageId()))
				.collect(Collectors.toList());
		return Projects;
	}

	@Override
	public boolean deleteProject(Long id) {
		Project project = projectRepository.findById(id).get();
		projectRepository.delete(project);
		return true;
	}

	@Override
	public ProjectDTO getProjectById(Long id) {
		Project ProjectEntity = projectRepository.findById(id).get();
		ProjectDTO project = new ProjectDTO();
		BeanUtils.copyProperties(ProjectEntity, project);
		return project;
	}

	@Override
	public ProjectDTO updateProject(Long id, ProjectDTO project) {
		Project projectEntity = null;
		try {
			projectEntity = projectRepository.findById(id).get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		projectEntity.setAccount(project.getAccount());
		projectEntity.setSector(project.getSector());
		projectEntity.setProjectName(project.getProjectName());
		projectEntity.setProjectTitle(project.getProjectTitle());
		projectEntity.setProjectDescription(project.getProjectDescription());

		projectRepository.save(projectEntity);
		return project;
	}

	@Override
	public Integer getTotalCompletedProjects() {
		
		return (int) getAllProjects().stream().filter(s -> s.getStageId()==6).count();
	}

	@Override
	public Integer getTotalInProgressProjects() {
		
		return (int) getAllProjects().stream().filter(s -> s.getStageId()<6).count();
	}
}
