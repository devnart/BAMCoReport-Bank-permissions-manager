package com.bam.bamcoreport.entity;

import org.apache.catalina.Group;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class UserMembership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private Users userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleId")
    private Role roleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupId")
    private Groups groupId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignedby")
    private Users assignedBy;

    @CreationTimestamp
    @Column(name = "assigneddate")
    private LocalDateTime assignedDate;

    public UserMembership(){

    }

    public UserMembership(Users userId, Role roleId, Groups groupId, Users assignedBy, LocalDateTime assignedDate) {
        this.userId = userId;
        this.roleId = roleId;
        this.groupId = groupId;
        this.assignedBy = assignedBy;
        this.assignedDate = assignedDate;
    }

    public UserMembership(long id, Users userId, Role roleId, Groups groupId, Users assignedBy, LocalDateTime assignedDate) {
        this.id = id;
        this.userId = userId;
        this.roleId = roleId;
        this.groupId = groupId;
        this.assignedBy = assignedBy;
        this.assignedDate = assignedDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public Groups getGroupId() {
        return groupId;
    }

    public void setGroupId(Groups groupId) {
        this.groupId = groupId;
    }

    public Users getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(Users assignedBy) {
        this.assignedBy = assignedBy;
    }

    public LocalDateTime getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(LocalDateTime assignedDate) {
        this.assignedDate = assignedDate;
    }
}
