package com.SIS.RetrospectiveService.mapper;

import com.SIS.RetrospectiveService.model.Retrospective;
import com.SIS.RetrospectiveService.model.dto.RetroDTO;
import com.SIS.RetrospectiveService.model.dto.RetroInputDTO;
import com.SIS.RetrospectiveService.model.dto.RetroUpdateDTO;

import java.util.List;

public interface IRetroMapper
{
    public RetroDTO RetroEntityToDTO(Retrospective entity);
    public Retrospective RetroDTOToEntity(RetroDTO model);
    public List<RetroDTO> RetroEntityToDTO(List<Retrospective> entities);
    public Retrospective RetroInputDTOToEntity(RetroInputDTO model);
    public RetroInputDTO RetroInputEntityToDTO(Retrospective entity);
    public RetroUpdateDTO RetroUpdateEntityToDTO(Retrospective entity);
    public Retrospective RetroUpdateDTOToEntity(RetroUpdateDTO model);
    public List<RetroInputDTO> RetroInputEntitiesToDTO(List<Retrospective> entities);
}
