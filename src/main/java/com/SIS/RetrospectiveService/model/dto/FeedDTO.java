package com.SIS.RetrospectiveService.model.dto;

import com.SIS.RetrospectiveService.model.Retrospective;
import lombok.Data;
import lombok.NonNull;

@Data
public class FeedDTO {
    private int Id;
    @NonNull
    private int RetroId;
    @NonNull
    private String Name;
    @NonNull
    private String Body;
    private String TypeOfFeedback;

    public FeedDTO() {

    }
}
