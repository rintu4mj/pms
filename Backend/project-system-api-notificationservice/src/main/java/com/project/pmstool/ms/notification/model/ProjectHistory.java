package com.project.pmstool.ms.notification.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "project_history")
public class ProjectHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
