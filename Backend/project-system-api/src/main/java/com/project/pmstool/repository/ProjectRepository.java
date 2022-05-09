package com.project.pmstool.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.pmstool.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
