package com.SIS.RetrospectiveService.model.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class FeedCDTO {
    @NonNull
    private int Id;
    private String Body;
    private String Name;

    public FeedCDTO() {
    }
}
