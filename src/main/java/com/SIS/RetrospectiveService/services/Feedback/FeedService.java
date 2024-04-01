package com.SIS.RetrospectiveService.services.Feedback;
import com.SIS.RetrospectiveService.mapper.IFeedbackMapper;
import com.SIS.RetrospectiveService.model.Feedback;
import com.SIS.RetrospectiveService.model.dto.FeedCDTO;
import com.SIS.RetrospectiveService.model.dto.FeedDTO;
import com.SIS.RetrospectiveService.repository.FeedRepo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class FeedService implements IFeedService {
    private final FeedRepo _repo;
    private final IFeedbackMapper _mapper;

    public FeedService(FeedRepo repo, IFeedbackMapper mapper) {
        _repo = repo;
        _mapper = mapper;
    }

    @Override
    public FeedDTO save(FeedDTO entity) {
        var data = _mapper.FeedDTOToEntity(entity);
        return _mapper.FeedEntityToDTO( _repo.save(data));
    }

    @Override
    public FeedDTO conditionalUpdate(FeedCDTO model) {
        var feedback = _repo.getReferenceById(model.getId());
        feedback.setBody(model.getBody());
        feedback.setName(model.getName());
        _repo.save(feedback);

        return _mapper.FeedEntityToDTO(feedback);
    }

    @Override
    public Feedback getById(int id) {
        return _repo.getReferenceById(id);
    }
}
