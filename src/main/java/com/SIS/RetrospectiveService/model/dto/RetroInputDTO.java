package com.SIS.RetrospectiveService.model.dto;

import com.SIS.RetrospectiveService.model.Feedback;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class RetroInputDTO {
    private String Name;
    private String Summary;
    @NonNull
    private String Participants;

    public RetroInputDTO() {

    }
}


