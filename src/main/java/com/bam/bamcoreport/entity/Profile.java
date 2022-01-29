package com.bam.bamcoreport.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private boolean isDefault;

    private String name;

    @Column(name = "description",columnDefinition = "TEXT")
    private String description;


    @CreationTimestamp
    private LocalDate creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Users createdBy;

    @UpdateTimestamp
    private LocalDate lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Users lastUpdatedBy;

    public Profile() {
    }


    public Profile(Long id, boolean isDefault, String name, String description, LocalDate creationDate, Users createdBy, LocalDate lastUpdate, Users lastUpdatedBy) {
        this.id = id;
        this.isDefault = isDefault;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Profile(boolean isDefault, String name, String description, LocalDate creationDate, Users createdBy, LocalDate lastUpdate, Users lastUpdatedBy) {
        this.isDefault = isDefault;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Users getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Users createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Users getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Users lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
}
