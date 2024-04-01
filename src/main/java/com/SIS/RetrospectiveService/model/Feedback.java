package com.SIS.RetrospectiveService.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Transactional
@Data
@Table(name = "feedback")
public class Feedback {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String Name;
    private String Body;
    private String TypeOfFeedback;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="retro_id")
    private Retrospective Retrospective;

    public Feedback() {
    }

    public Feedback(int id, String name, String body, String typeOfFeedback, com.SIS.RetrospectiveService.model.Retrospective retrospective) {
        Id = id;
        Name = name;
        Body = body;
        TypeOfFeedback = typeOfFeedback;
        Retrospective = retrospective;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public String getTypeOfFeedback() {
        return TypeOfFeedback;
    }

    public void setTypeOfFeedback(String typeOfFeedback) {
        TypeOfFeedback = typeOfFeedback;
    }

    public com.SIS.RetrospectiveService.model.Retrospective getRetrospective() {
        return Retrospective;
    }

    public void setRetrospective(com.SIS.RetrospectiveService.model.Retrospective retrospective) {
        Retrospective = retrospective;
    }
}


