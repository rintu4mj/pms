package com.project.pmstool.ms.notification.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectHistoryDTO {
	
	private long id;
	private long projectId;
	private String projectName;
	private Date startDate;
	private Date endDate;
	private String stage;
	private String comment;
	private String updatedBy;
	private String updatedOn;
	
}
