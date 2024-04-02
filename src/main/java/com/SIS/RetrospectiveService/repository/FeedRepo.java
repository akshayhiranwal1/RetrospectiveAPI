package com.SIS.RetrospectiveService.repository;

import com.SIS.RetrospectiveService.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedRepo extends JpaRepository<Feedback, Integer> {
}
