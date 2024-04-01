package com.SIS.RetrospectiveService.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;
import java.util.List;

@Entity
@Transactional
@Data
@Table(name = "retrospective")
public class Retrospective {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String Name;
    private String Summary;
    private String Participants;
    @NonNull
    @Column(name = "Date")
    private Date Date;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "retro_id", referencedColumnName = "id")
    private List<Feedback> Feedback;

    public Retrospective() {
    }

    public Retrospective(int id, String name, String summary, String participants, java.util.@NonNull Date date, List<com.SIS.RetrospectiveService.model.Feedback> feedback) {
        Id = id;
        Name = name;
        Summary = summary;
        Participants = participants;
        Date = date;
        Feedback = feedback;
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

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public String getParticipants() {
        return Participants;
    }

    public void setParticipants(String participants) {
        Participants = participants;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public List<com.SIS.RetrospectiveService.model.Feedback> getFeedback() {
        return Feedback;
    }

    public void setFeedback(List<com.SIS.RetrospectiveService.model.Feedback> feedback) {
        Feedback = feedback;
    }
}
