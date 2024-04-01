package com.SIS.RetrospectiveService.services.Retrospective;

import com.SIS.RetrospectiveService.model.Retrospective;
import com.SIS.RetrospectiveService.model.dto.RetroDTO;
import com.SIS.RetrospectiveService.model.dto.RetroInputDTO;
import com.SIS.RetrospectiveService.model.dto.RetroSearch;
import com.SIS.RetrospectiveService.model.dto.RetroUpdateDTO;
import java.util.List;

public interface IRetroService {
    public List<RetroDTO> getAll();
    public Retrospective saveRetro(RetroInputDTO model);
    public Retrospective putRetro(RetroUpdateDTO model);
    public List<RetroDTO> getAllByPaging(int pageNo, int size);
    public List<RetroDTO> searchByDatePaging(RetroSearch model);
}
