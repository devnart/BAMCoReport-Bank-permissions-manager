package com.bam.bamcoreport.dto.model;

import com.bam.bamcoreport.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserContactInfoDto {
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
}
