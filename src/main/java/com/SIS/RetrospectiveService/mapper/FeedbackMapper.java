package com.SIS.RetrospectiveService.mapper;

import com.SIS.RetrospectiveService.model.Feedback;
import com.SIS.RetrospectiveService.model.dto.FeedDTO;
import com.SIS.RetrospectiveService.repository.RetroRepository;
import org.springframework.stereotype.Component;

@Component
public class FeedbackMapper implements IFeedbackMapper {
    private final RetroRepository _retroRepo;
    public FeedbackMapper(RetroRepository retroRepo)
    {
        _retroRepo = retroRepo;
    }

    public FeedDTO FeedEntityToDTO(Feedback entity)
    {
        var result = new FeedDTO();
        result.setId(entity.getId());
        result.setName(entity.getName());
        result.setBody(entity.getBody());
        result.setTypeOfFeedback(entity.getTypeOfFeedback());
        result.setRetroId(entity.getRetrospective().getId());
        return result;
    }

    public Feedback FeedDTOToEntity(FeedDTO model)
    {
        var result = new Feedback();
        result.setId(model.getId());
        result.setName(model.getName());
        result.setBody(model.getBody());
        result.setTypeOfFeedback(model.getTypeOfFeedback());

        var retro = _retroRepo.getReferenceById(model.getRetroId());
        result.setRetrospective(retro);
        return result;
    }
}
