package com.project.pmstool.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectHistoryListDTO {

	private List<ProjectHistoryDTO> projectHistoryDTOs;

	// standard constructor and getter/setter

}
