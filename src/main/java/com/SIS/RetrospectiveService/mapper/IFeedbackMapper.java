package com.SIS.RetrospectiveService.mapper;

import com.SIS.RetrospectiveService.model.Feedback;
import com.SIS.RetrospectiveService.model.dto.FeedCDTO;
import com.SIS.RetrospectiveService.model.dto.FeedDTO;

public interface IFeedbackMapper {
    public Feedback FeedDTOToEntity(FeedDTO model);
    public FeedDTO FeedEntityToDTO(Feedback entity);
}
