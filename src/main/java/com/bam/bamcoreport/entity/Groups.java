package com.bam.bamcoreport.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Groups {

    @Id
    @SequenceGenerator(name = "group_seq", sequenceName = "group_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_seq")
    private Long id;

    private String name;

    private String parentPath;

    private String displayName;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    @JoinColumn(name = "createdBy")
    private Users createdBy;

    private LocalDateTime creationDate;

    private LocalDateTime lastUpdate;

    public Groups(){

    }

    public Groups(Long id, String name, String parentPath, String displayName, String description, Users createdBy, LocalDateTime creationDate, LocalDateTime lastUpdate) {
        this.id = id;
        this.name = name;
        this.parentPath = parentPath;
        this.displayName = displayName;
        this.description = description;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdate = lastUpdate;
    }

    public Groups(String name, String parentPath, String displayName, String description, Users createdBy, LocalDateTime creationDate, LocalDateTime lastUpdate) {
        this.name = name;
        this.parentPath = parentPath;
        this.displayName = displayName;
        this.description = description;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdate = lastUpdate;
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

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
