package com.SIS.RetrospectiveService.controller;
import com.SIS.RetrospectiveService.model.Retrospective;
import com.SIS.RetrospectiveService.model.dto.RetroDTO;
import com.SIS.RetrospectiveService.model.dto.RetroInputDTO;
import com.SIS.RetrospectiveService.model.dto.RetroSearch;
import com.SIS.RetrospectiveService.model.dto.RetroUpdateDTO;
import com.SIS.RetrospectiveService.services.Retrospective.IRetroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/retrospective")
public class RetrospectiveController {
    
    private final IRetroService _service;

    @Autowired
    public RetrospectiveController(IRetroService service) {
        _service = service;
    }

    @GetMapping
    public ResponseEntity<List<RetroDTO>> getRetro()
    {
        return new ResponseEntity<>(_service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{pageNo}/{size}")
    public ResponseEntity<List<RetroDTO>> getAllByPaging(@PathVariable int pageNo, @PathVariable int size)
    {
        return new ResponseEntity<>(_service.getAllByPaging(pageNo, size), HttpStatus.OK);
    }

    @PostMapping("/searchByDatePaging")
    public ResponseEntity<List<RetroDTO>> searchByDatePaging(@RequestBody RetroSearch model)
    {
        System.out.println(model.getDate());
        return new ResponseEntity<>(_service.searchByDatePaging(model), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Retrospective> saveRetro(@RequestBody RetroInputDTO model)
    {
        return new ResponseEntity<>(_service.saveRetro(model), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Retrospective> putRetro(@RequestBody RetroUpdateDTO model)
    {
        return new ResponseEntity<>(_service.putRetro(model), HttpStatus.OK);
    }
}
