package com.bam.bamcoreport.dto.model;

import com.bam.bamcoreport.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class GroupsDto {
    private Long id;
    private String name;
    private String parentPath;
    private String displayName;
    private String description;
    private Users createdBy;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
}
