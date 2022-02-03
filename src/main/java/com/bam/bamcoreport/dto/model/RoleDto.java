package com.bam.bamcoreport.dto.model;

import com.bam.bamcoreport.entity.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleDto {

    @JsonIgnore
    private Long id;
    private String name;
    private String displayName;
    private String description;
    private Users createdBy;
    private LocalDate creationDate;
    private LocalDate lastUpdate;

}
