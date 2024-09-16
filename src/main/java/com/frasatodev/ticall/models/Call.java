package com.frasatodev.ticall.models;

import jakarta.persistence.*;

import java.time.Instant;
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

    @Column(name = "who_called")
    private String whoCalled;

    @Column(name = "any_desk_number")
    private Integer anyDeskNumber;

    @Column(name = "creation_date")
    private Instant creationDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Call() {
    }

    public Call(UUID id, String title, String sector, String whoCalled, Integer anyDeskNumber, Instant creationDate, User user) {
        this.id = id;
        this.title = title;
        this.sector = sector;
        this.whoCalled = whoCalled;
        this.anyDeskNumber = anyDeskNumber;
        this.creationDate = creationDate;
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

    public Integer getAnyDeskNumber() {
        return anyDeskNumber;
    }

    public void setAnyDeskNumber(Integer anyDeskNumber) {
        this.anyDeskNumber = anyDeskNumber;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
