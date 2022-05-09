package com.project.pmstool.ms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
	
    private long projectId;
    private String sector;
    private String account;
    private String projectName;
    private String projectTitle;
    private String projectDescription;
    private int stageId;
    
}
