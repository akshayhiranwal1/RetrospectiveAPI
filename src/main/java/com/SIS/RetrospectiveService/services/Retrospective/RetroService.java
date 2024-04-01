package com.SIS.RetrospectiveService.services.Retrospective;

import com.SIS.RetrospectiveService.controller.FeedbackController;
import com.SIS.RetrospectiveService.mapper.RetroMapper;
import com.SIS.RetrospectiveService.model.Retrospective;
import com.SIS.RetrospectiveService.model.dto.RetroDTO;
import com.SIS.RetrospectiveService.model.dto.RetroInputDTO;
import com.SIS.RetrospectiveService.model.dto.RetroSearch;
import com.SIS.RetrospectiveService.model.dto.RetroUpdateDTO;
import com.SIS.RetrospectiveService.repository.RetroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RetroService implements IRetroService {
    private final Logger logger;
    private final RetroRepository _repo;
    private final RetroMapper _mapper;

    public RetroService(RetroRepository repo, RetroMapper mapper) {
        _repo = repo;
        _mapper = mapper;
        logger = LoggerFactory.getLogger(FeedbackController.class);
    }

    @Override
    public List<RetroDTO> getAll() {
        return _mapper.RetroEntityToDTO(_repo.findAll());
    }

    @Override
    public Retrospective saveRetro(RetroInputDTO model) {
        return _repo.save(_mapper.RetroInputDTOToEntity(model));
    }

    @Override
    public Retrospective putRetro(RetroUpdateDTO model) {
        return _repo.save(_mapper.RetroUpdateDTOToEntity(model));
    }

    @Override
    public List<RetroDTO> getAllByPaging(int pageNo, int size) {
        Pageable paging =
                PageRequest.of(pageNo, size, Sort.by("Id"));
        return _mapper.RetroEntityToDTO(_repo.findAll(paging).getContent());
    }

    @Override
    public List<RetroDTO> searchByDatePaging(RetroSearch model) {
        Pageable paging = PageRequest.of(model.getPageNo(), model.getSize(), Sort.by("Id"));

//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withMatcher("date", exact());
//
//        Example<Retrospective> example = Example.of(retro, matcher);
//
//        var result= _mapper.RetroEntityToDTO(_repo.findAll(example, paging).getContent());
//System.out.println(convertDateToString(model.getDate()));

//        var result = _repo.findAllByDate(model.getDate(), paging).getContent();
//        System.out.println(result);
//        return _mapper.RetroEntityToDTO(result);

        return _mapper.RetroEntityToDTO(_repo.findAll().stream()
                .filter(i-> convertDateToString(i.getDate()).equals(convertDateToString(model.getDate())))
                .collect(Collectors.toList()));

    }

    private String convertDateToString(Date dt) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String dateToString = df.format(dt);
        return dateToString;
    }
}
