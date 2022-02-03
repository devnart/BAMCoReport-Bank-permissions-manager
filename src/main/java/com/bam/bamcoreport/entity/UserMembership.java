package com.bam.bamcoreport.entity;

import lombok.*;
import org.apache.catalina.Group;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserMembership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Users userId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Role roleId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Groups groupId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignedby")
    private Users assignedBy;

    @CreationTimestamp
    @Column(name = "assigneddate")
    private LocalDateTime assignedDate;

}
