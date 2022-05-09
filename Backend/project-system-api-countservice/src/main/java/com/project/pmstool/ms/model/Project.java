package com.project.pmstool.ms.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long projectId;
    private String sector;
    private String account;
    private String projectName;
    private String projectTitle;
    private String projectDescription;
    private int stageId;
}
