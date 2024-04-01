package com.SIS.RetrospectiveService.repository;

import com.SIS.RetrospectiveService.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepo extends JpaRepository<Feedback, Integer> {
}
