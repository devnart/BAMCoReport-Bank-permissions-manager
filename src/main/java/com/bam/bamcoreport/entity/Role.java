package com.bam.bamcoreport.entity;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String displayName;

    @Column(name = "description",columnDefinition="TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Users createdBy;

    @CreationTimestamp
    private LocalDate creationDate;

    @UpdateTimestamp
    private LocalDate lastUpdate;

    public Role() {
    }

    public Role(Long id, String name, String displayName, String description, Users createdBy, LocalDate creationDate, LocalDate lastUpdate) {
        this.id = id;
        this.name = name;
        this.displayName = displayName;
        this.description = description;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdate = lastUpdate;
    }

    public Role(String name, String displayName, String description, Users createdBy, LocalDate creationDate, LocalDate lastUpdate) {
        this.name = name;
        this.displayName = displayName;
        this.description = description;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdate = lastUpdate;
    }

    public Role(String name, String displayName, String description, Users createdBy) {
        this.name = name;
        this.displayName = displayName;
        this.description = description;
        this.createdBy = createdBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Users getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Users createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
