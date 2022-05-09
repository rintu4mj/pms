package com.project.pmstool.services;

import java.util.List;

import com.project.pmstool.dto.ProjectDTO;
import com.project.pmstool.dto.ProjectHistoryDTO;

public interface ProjectService {
	ProjectDTO createProject(ProjectDTO project);

	List<ProjectDTO> getAllProjects();

	boolean deleteProject(Long id);

	ProjectDTO getProjectById(Long id);

	ProjectDTO updateProject(Long id, ProjectDTO project);

	Integer getTotalCompletedProjects();

	Integer getTotalInProgressProjects();

	ProjectHistoryDTO saveProjectHistory(ProjectHistoryDTO projectHistoryDTO);

	void updateStage(long projectId, String stage);

	List<ProjectHistoryDTO> getProjectHistoryList();
}
