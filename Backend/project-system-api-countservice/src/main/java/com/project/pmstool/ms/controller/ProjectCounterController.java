package com.project.pmstool.ms.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.pmstool.ms.services.ProjectDataService;

@RestController
@RequestMapping("/counts/")
public class ProjectCounterController {

	private static final Logger logger = LogManager.getLogger("ProjectCounterController");

	private final ProjectDataService projectService;

	public ProjectCounterController(ProjectDataService projectService) {
		this.projectService = projectService;
	}

	@GetMapping("/totalCompleted")
	public Integer getAllCompletedProjects() {

		logger.info("Get total no of completed projects");
		try {
			return projectService.getTotalCompletedProjects();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@GetMapping("/totalInProgress")
	public Integer getAllInProgressProjects() {

		logger.info("Get total no of ongoing projects");
		try {
			return projectService.getTotalInProgressProjects();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
