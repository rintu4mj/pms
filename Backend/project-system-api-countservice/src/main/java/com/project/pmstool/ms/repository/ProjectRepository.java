package com.project.pmstool.ms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.pmstool.ms.model.Project;



@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
