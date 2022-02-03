package com.bam.bamcoreport.dto.model;

import com.bam.bamcoreport.entity.Groups;
import com.bam.bamcoreport.entity.Profile;
import com.bam.bamcoreport.entity.Role;
import com.bam.bamcoreport.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProfileMemberDto {
    private Long id;
    private Profile profileId;
    private Users userId;
    private Role roleId;
    private Groups groupId;
}
