package com.frasatodev.ticall.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Entity
@Table(name = "tb_calls")
public class Call {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "title")
    private String title;

    @Column(name = "sector")
    private String sector;

    @Column(name = "description")
    private String description;

    @Column(name = "who_called")
    private String whoCalled;

    @Column(name = "creation_date")
    private String creationDate;

    @Column(name = "call_status")
    private String callStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    public Call() {
    }

    public Call(UUID id, String title, String sector, String description, String whoCalled, String creationDate, String callStatus, User user) {
        this.id = id;
        this.title = title;
        this.sector = sector;
        this.description = description;
        this.whoCalled = whoCalled;
        this.creationDate = creationDate;
        this.callStatus = callStatus;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getWhoCalled() {
        return whoCalled;
    }

    public void setWhoCalled(String whoCalled) {
        this.whoCalled = whoCalled;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getCallStatus() {
        return callStatus;
    }

    public void setCallStatus(String callStatus) {
        this.callStatus = callStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @PrePersist
    public void onCreateSetDate(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.creationDate = now.format(formatter);
    }
}
