package com.project.pmstool.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.pmstool.dto.ProjectDTO;
import com.project.pmstool.dto.ProjectHistoryDTO;
import com.project.pmstool.dto.ProjectHistoryListDTO;
import com.project.pmstool.model.Project;
import com.project.pmstool.repository.ProjectRepository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	public RestTemplate restTemplate;

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
	public void updateStage(long id, String Stage) {
		Project projectEntity = null;

		HashMap<String, Integer> stageMap = new HashMap<>();

		// Adding elements to the Map
		// using standard add() method
		stageMap.put("Analysis", 1);
		stageMap.put("Assessment", 2);
		stageMap.put("Development", 3);
		stageMap.put("Testing", 4);
		stageMap.put("Build", 5);
		stageMap.put("Production", 6);

		try {
			projectEntity = projectRepository.findById(id).get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		projectEntity.setStageId(stageMap.get(Stage));

		projectRepository.save(projectEntity);

	}

	@Override
	public Integer getTotalCompletedProjects() {
		// TODO Auto-generated method stub
		return restTemplate.getForObject("http://COUNT-SERVICE/counts/totalCompleted", int.class);
	}

	@Override
	public Integer getTotalInProgressProjects() {
		// TODO Auto-generated method stub
		return restTemplate.getForObject("http://COUNT-SERVICE/counts/totalInProgress", int.class);
	}

	@Override
	public ProjectHistoryDTO saveProjectHistory(ProjectHistoryDTO projectHistoryDTO) {

		restTemplate.postForObject("http://NOTIFICATION-SERVICE/notifications/saveProjectHistory", projectHistoryDTO,
				ProjectHistoryDTO.class);

		return projectHistoryDTO;

	}

	@Override
	public List<ProjectHistoryDTO> getProjectHistoryList() {

		List<ProjectHistoryDTO> projectHistoryList = null;
		try {
			ResponseEntity<ProjectHistoryDTO[]> response = restTemplate
					.getForEntity("http://NOTIFICATION-SERVICE/notifications/getProjectHistory", ProjectHistoryDTO[].class);
			ProjectHistoryDTO[] employees = response.getBody();

			projectHistoryList = Arrays.asList(employees);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return projectHistoryList;

	}

}
