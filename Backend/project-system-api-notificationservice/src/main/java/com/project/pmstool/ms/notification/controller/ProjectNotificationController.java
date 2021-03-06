package com.project.pmstool.ms.notification.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.pmstool.ms.notification.dto.ProjectHistoryDTO;
import com.project.pmstool.ms.notification.services.ProjectNotificationService;

@RestController
@RequestMapping("/notifications")
public class ProjectNotificationController {

	private static final Logger logger = LogManager.getLogger("ProjectNotificationController");

	@Autowired
	private ProjectNotificationService projectNotificationService;

	@PostMapping("/saveProjectHistory")
	public void saveProjectHistory(@RequestBody ProjectHistoryDTO projectHistoryDTO) {

		logger.info("Save the Project History Data to DB");

		try {
			
			projectNotificationService.save(projectHistoryDTO);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@GetMapping("/getProjectHistory")
	public List<ProjectHistoryDTO> getProjectHistoryList() {

		logger.info("Get the Project History Data from DB");

		List<ProjectHistoryDTO> projectHistoryList = null;
		try {

			projectHistoryList = projectNotificationService.getNotifications();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return projectHistoryList;

	}

}
