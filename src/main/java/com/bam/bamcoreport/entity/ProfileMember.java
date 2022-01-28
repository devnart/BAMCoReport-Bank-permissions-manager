package com.bam.bamcoreport.entity;


import javax.persistence.*;

@Entity
@Table
public class ProfileMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profileId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private Users userId;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="roleId")
    private Role roleId;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="groupId")
    private Groups groupId;


    public ProfileMember() {
    }

    public ProfileMember(String id, Profile profileId, Users userId, Groups groupId, Role roleId) {
        this.id = id;
        this.profileId = profileId;
        this.userId = userId;
        this.groupId = groupId;
        this.roleId = roleId;
    }

    public ProfileMember(Profile profileId, Users userId, Groups groupId, Role roleId) {
        this.profileId = profileId;
        this.userId = userId;
        this.groupId = groupId;
        this.roleId = roleId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Profile getProfileId() {
        return profileId;
    }

    public void setProfileId(Profile profileId) {
        this.profileId = profileId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Groups getGroupId() {
        return groupId;
    }

    public void setGroupId(Groups groupId) {
        this.groupId = groupId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }
}
