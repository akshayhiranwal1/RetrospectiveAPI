package com.SIS.RetrospectiveService.model.dto;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class RetroDTO {
    private int Id;
    private String Name;
    private String Summary;
    @NonNull
    private String Participants;
    @NonNull
    private java.util.Date Date;
    private List<com.SIS.RetrospectiveService.model.Feedback> Feedback;

    public RetroDTO() {

    }
}
