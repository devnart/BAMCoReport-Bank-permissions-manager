package com.bam.bamcoreport.dto.model;

import com.bam.bamcoreport.entity.Groups;
import com.bam.bamcoreport.entity.Role;
import com.bam.bamcoreport.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMembershipDto {

    private long id;
    private Users userId;
    private Role roleId;
    private Groups groupId;
    private Users assignedBy;
    private LocalDateTime assignedDate;

}
