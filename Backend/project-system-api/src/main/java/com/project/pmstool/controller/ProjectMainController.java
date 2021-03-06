package com.project.pmstool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.pmstool.dto.ProjectDTO;
import com.project.pmstool.dto.ProjectHistoryDTO;
import com.project.pmstool.services.ProjectService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/projects")
public class ProjectMainController {

	private static final Logger logger = LogManager.getLogger("ProjectRestController");

	@Autowired
	private ProjectService projectService;

	@PostMapping("/")
	public ProjectDTO createProject(@RequestBody ProjectDTO project) {
		return projectService.createProject(project);
	}

	@GetMapping("/")
	public List<ProjectDTO> getAllProjects() {

		logger.info("Getting details of all the Projects..");

		System.out.println(projectService.getAllProjects());
		return projectService.getAllProjects();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteProject(@PathVariable Long id) {
		boolean deleted = false;
		deleted = projectService.deleteProject(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", deleted);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProjectDTO> getProjectById(@PathVariable Long id) {
		ProjectDTO Project = null;
		Project = projectService.getProjectById(id);
		return ResponseEntity.ok(Project);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProjectDTO> updateProject(@PathVariable Long id, @RequestBody ProjectDTO project) {
		project = projectService.updateProject(id, project);
		return ResponseEntity.ok(project);
	}

	@GetMapping("/totalCompleted")
	public Integer getAllCompletedProjects() {

		return projectService.getTotalCompletedProjects();
	}

	@GetMapping("/totalInProgress")
	public Integer getAllInProgressProjects() {

		return projectService.getTotalInProgressProjects();
	}

	@PostMapping("/saveProjectHistory")
	public ProjectHistoryDTO saveProjectHistory(@RequestBody ProjectHistoryDTO projectHistoryDTO) {

		projectService.updateStage(projectHistoryDTO.getProjectId(), projectHistoryDTO.getStage());

		return projectService.saveProjectHistory(projectHistoryDTO);
	}

	@GetMapping("/getProjectHistory")
	public List<ProjectHistoryDTO> getProjectHistory() {

		logger.info("Getting details of all the Projects Hitsory..");
		List<ProjectHistoryDTO> projectHistoryList = null;

		try {

			projectHistoryList = projectService.getProjectHistoryList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return projectHistoryList;
	}

}
