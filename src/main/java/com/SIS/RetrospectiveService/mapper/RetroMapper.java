package com.SIS.RetrospectiveService.mapper;

import com.SIS.RetrospectiveService.model.Feedback;
import com.SIS.RetrospectiveService.model.Retrospective;
import com.SIS.RetrospectiveService.model.dto.RetroDTO;
import com.SIS.RetrospectiveService.model.dto.RetroInputDTO;
import com.SIS.RetrospectiveService.model.dto.RetroUpdateDTO;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RetroMapper implements IRetroMapper {

    public RetroDTO RetroEntityToDTO(Retrospective entity)
    {
        var result = new RetroDTO();
        result.setId(entity.getId());
        result.setName(entity.getName());
        result.setSummary(entity.getSummary());
        result.setDate(entity.getDate());
        result.setParticipants(entity.getParticipants());
        result.setFeedback(entity.getFeedback().stream().map(i-> new Feedback(i.getId(), i.getName(), i.getBody(),i.getTypeOfFeedback(),null)).collect(Collectors.toList()));
        return result;
    }


    public Retrospective RetroDTOToEntity(RetroDTO model)
    {
        var result = new Retrospective();
        result.setId(model.getId());
        result.setName(model.getName());
        result.setSummary(model.getSummary());
        result.setDate(model.getDate());
        result.setParticipants(model.getParticipants());
        result.setFeedback(model.getFeedback());
        return result;
    }

    public Retrospective RetroInputDTOToEntity(RetroInputDTO model)
    {
        var result = new Retrospective();
        result.setName(model.getName());
        result.setSummary(model.getSummary());
        result.setDate(Date.valueOf(LocalDate.now()));
        result.setParticipants(model.getParticipants());
        return result;
    }

    public RetroInputDTO RetroInputEntityToDTO(Retrospective entity)
    {
        var result = new RetroInputDTO();
        result.setName(entity.getName());
        result.setSummary(entity.getSummary());
        result.setParticipants(entity.getParticipants());
        return result;
    }

    public Retrospective RetroUpdateDTOToEntity(RetroUpdateDTO model)
    {
        var result = new Retrospective();
        result.setId(model.getId());
        result.setName(model.getName());
        result.setSummary(model.getSummary());
        result.setDate(Date.valueOf(LocalDate.now()));
        result.setParticipants(model.getParticipants());
        return result;
    }

    public RetroUpdateDTO RetroUpdateEntityToDTO(Retrospective entity)
    {
        var result = new RetroUpdateDTO();
        result.setId(entity.getId());
        result.setName(entity.getName());
        result.setSummary(entity.getSummary());
        result.setParticipants(entity.getParticipants());
        return result;
    }

    public List<RetroDTO> RetroEntityToDTO(List<Retrospective> entities)
    {
        return entities.stream().map(i-> RetroEntityToDTO(i)).collect(Collectors.toList());
    }

    public List<RetroInputDTO> RetroInputEntitiesToDTO(List<Retrospective> entities)
    {
        return entities.stream().map(i-> RetroInputEntityToDTO(i)).collect(Collectors.toList());
    }
}
