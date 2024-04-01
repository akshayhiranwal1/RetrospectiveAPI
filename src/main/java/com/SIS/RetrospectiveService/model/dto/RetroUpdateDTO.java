package com.SIS.RetrospectiveService.model.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class RetroUpdateDTO {
    private int Id;
    private String Name;
    private String Summary;
    @NonNull
    private String Participants;

    public RetroUpdateDTO() {

    }
}
