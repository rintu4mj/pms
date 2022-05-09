package com.project.pmstool.ms.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.pmstool.ms.notification.model.ProjectHistory;

@Repository
public interface ProjectNotificationRepository extends JpaRepository<ProjectHistory, Long> {
}
