package com.bam.bamcoreport.dto.model;

import com.bam.bamcoreport.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProfileDto {
    private Long id;
    private boolean isDefault;
    private String name;
    private String description;
    private LocalDate creationDate;
    private Users createdBy;
    private LocalDate lastUpdate;
    private Users lastUpdatedBy;
}
