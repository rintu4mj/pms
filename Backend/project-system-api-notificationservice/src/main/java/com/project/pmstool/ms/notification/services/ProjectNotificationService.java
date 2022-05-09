package com.project.pmstool.ms.notification.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.pmstool.ms.notification.dto.ProjectHistoryDTO;



public interface ProjectNotificationService {
	
	List<ProjectHistoryDTO> getNotifications();
	
	void save(ProjectHistoryDTO projectHistoryDTO);

}
