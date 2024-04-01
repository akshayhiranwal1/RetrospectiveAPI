package com.SIS.RetrospectiveService.controller;
import com.SIS.RetrospectiveService.model.dto.FeedCDTO;
import com.SIS.RetrospectiveService.model.dto.FeedDTO;
import com.SIS.RetrospectiveService.services.Feedback.IFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
    private final IFeedService _service;

    @Autowired
    public FeedbackController(IFeedService service) {
        _service = service;
    }

    @PostMapping
    public ResponseEntity<FeedDTO> postFeedback(@RequestBody FeedDTO model)
    {
        return new ResponseEntity<FeedDTO>(_service.save(model), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<FeedDTO> putFeedback(@RequestBody FeedDTO model)
    {
        return new ResponseEntity<FeedDTO>(_service.save(model), HttpStatus.CREATED);
    }

    @PostMapping(value = "/conditional")
    public ResponseEntity<FeedDTO> Conditional (@RequestBody FeedCDTO model)
    {
        return new ResponseEntity<FeedDTO>(_service.conditionalUpdate(model), HttpStatus.ACCEPTED);
    }
}
