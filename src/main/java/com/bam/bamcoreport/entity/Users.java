package com.bam.bamcoreport.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Users implements Serializable {
    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private Long id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String title;

    private String jobTitle;

    @OneToMany(mappedBy = "user")
    Set<UserMembership> user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "managerUserId")
    private Users managerUserId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "createdBy")
    private Users createdBy;

    @CreationTimestamp
    private LocalDate createdDate;

    @UpdateTimestamp
    private LocalDate lastUpdate;

    @Transient
    private Long iconId;

    public Users() {

    }

    public Users(String username, String password, String firstName, String lastName, String title, String jobTitle, Users managerUserId, Users createdBy, LocalDate createdDate, LocalDate lastUpdate) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.jobTitle = jobTitle;
        this.managerUserId = managerUserId;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastUpdate = lastUpdate;
    }

    public Users(Long id, String username, String password, String firstName, String lastName, String title, String jobTitle, Users managerUserId, Users createdBy, LocalDate createdDate, LocalDate lastUpdate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.jobTitle = jobTitle;
        this.managerUserId = managerUserId;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastUpdate = lastUpdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
//
//    public List<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(List<Role> roles) {
//        this.roles = roles;
//    }
//
//    public List<Groups> getGroups() {
//        return groups;
//    }
//
//    public void setGroups(List<Groups> groups) {
//        this.groups = groups;
//    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Users getManagerUserId() {
        return managerUserId;
    }

    public void setManagerUserId(Users managerUserId) {
        this.managerUserId = managerUserId;
    }

    public Users getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Users createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Long getIconId() {
        return iconId;
    }

    public void setIconId(Long iconId) {
        this.iconId = iconId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", managerUserId=" + managerUserId +
                ", createdBy=" + createdBy +
                ", createdDate=" + createdDate +
                ", lastUpdate=" + lastUpdate +
                ", iconId=" + iconId +
                '}';
    }
}
