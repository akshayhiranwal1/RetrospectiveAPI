package com.SIS.RetrospectiveService.repository;

import com.SIS.RetrospectiveService.model.Feedback;
import com.SIS.RetrospectiveService.model.dto.FeedCDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepo extends JpaRepository<Feedback, Integer> {
}
