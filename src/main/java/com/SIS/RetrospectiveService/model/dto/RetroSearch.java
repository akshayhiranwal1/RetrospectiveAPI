package com.SIS.RetrospectiveService.model.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class RetroSearch {
    @NonNull
    private java.util.Date Date;
    private int PageNo;
    private int Size;

    public RetroSearch() {
    }
}
