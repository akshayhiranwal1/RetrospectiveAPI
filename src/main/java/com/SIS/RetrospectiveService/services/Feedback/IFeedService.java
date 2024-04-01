package com.SIS.RetrospectiveService.services.Feedback;

import com.SIS.RetrospectiveService.model.Feedback;
import com.SIS.RetrospectiveService.model.dto.FeedCDTO;
import com.SIS.RetrospectiveService.model.dto.FeedDTO;

public interface IFeedService {
    public FeedDTO save(FeedDTO entity);
    public FeedDTO conditionalUpdate(FeedCDTO model);
    public Feedback getById(int id);
}
