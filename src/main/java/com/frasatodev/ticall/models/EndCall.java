package com.frasatodev.ticall.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tb_end_calls")
public class EndCall {

    @Id
    @GeneratedValue
    @Column(name = "end_call_id")
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

    @Column(name = "end_date")
    private String endDate;

    public EndCall() {
    }

    public EndCall(UUID id, String title, String sector, String city, String description, String whoCalled, String creationDate, String endDate) {
        this.id = id;
        this.title = title;
        this.sector = sector;
        this.description = description;
        this.whoCalled = whoCalled;
        this.creationDate = creationDate;
        this.endDate = endDate;
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

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @PrePersist
    public void EndDate(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.endDate = now.format(formatter);
    }
}
