package com.bam.bamcoreport.entity;

import javax.persistence.*;

@Entity
@Table
public class UserContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(targetEntity = Users.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "userid", referencedColumnName = "id")
    private Users userId;
}
