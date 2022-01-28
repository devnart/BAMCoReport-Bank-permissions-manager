package com.bam.bamcoreport.entity;

import javax.persistence.*;

@Entity
@Table
public class UserContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(targetEntity = Users.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private Users userId;

    private String email;
    private String phone;
    private String mobile;
    private String fax;
    private String building;
    private String room;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String website;
    private boolean personal;

    public UserContactInfo() {
    }

    public UserContactInfo(long id, Users userId, String email, String phone, String mobile, String fax, String building, String room, String address, String city, String state, String zip, String country, String website, boolean personal) {
        this.id = id;
        this.userId = userId;
        this.email = email;
        this.phone = phone;
        this.mobile = mobile;
        this.fax = fax;
        this.building = building;
        this.room = room;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.website = website;
        this.personal = personal;
    }

    public UserContactInfo(Users userId, String email, String phone, String mobile, String fax, String building, String room, String address, String city, String state, String zip, String country, String website, boolean personal) {
        this.userId = userId;
        this.email = email;
        this.phone = phone;
        this.mobile = mobile;
        this.fax = fax;
        this.building = building;
        this.room = room;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.website = website;
        this.personal = personal;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public boolean isPersonal() {
        return personal;
    }

    public void setPersonal(boolean personal) {
        this.personal = personal;
    }
}
