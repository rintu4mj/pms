package com.project.pmstool.ms.notification.services;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pmstool.ms.notification.dto.ProjectHistoryDTO;
import com.project.pmstool.ms.notification.model.ProjectHistory;
import com.project.pmstool.ms.notification.repository.ProjectNotificationRepository;

@Service
public class ProjectNotificationServiceImpl implements ProjectNotificationService {

	@Autowired
	private ProjectNotificationRepository projectNotificationRepository;

	@Override
	public List<ProjectHistoryDTO> getNotifications() {

		

		List<ProjectHistory> projectHistoryListSource = projectNotificationRepository.findAll();
		List<ProjectHistoryDTO> projectHistoryList = new ArrayList<ProjectHistoryDTO>();

		for (ProjectHistory data : projectHistoryListSource) {
			ProjectHistoryDTO target = new ProjectHistoryDTO();
			BeanUtils.copyProperties(data, target);
			projectHistoryList.add(target);
		}
		
		System.out.println("#############" + projectHistoryListSource);
		System.out.println("$$$$$$$$$$$$$" + projectHistoryList);

		return projectHistoryList;
	}

	@Override
	public void save(ProjectHistoryDTO projectHistoryDTO) {

		ProjectHistory projectHistory = new ProjectHistory();
		BeanUtils.copyProperties(projectHistoryDTO, projectHistory);

		System.out.println("Saving Project History" + projectHistoryDTO);

		System.out.println("Saving Project History" + projectHistory);

		projectNotificationRepository.save(projectHistory);

	}

}
