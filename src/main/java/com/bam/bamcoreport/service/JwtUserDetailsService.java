package com.bam.bamcoreport.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import com.bam.bamcoreport.entity.UserMembership;
import com.bam.bamcoreport.entity.Users;
import com.bam.bamcoreport.repository.UserMembershipRepository;
import com.bam.bamcoreport.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMembershipRepository userMembershipRepository;

    @Autowired
    RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Users> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            log.error("User not found");
            throw new UsernameNotFoundException("user not found");
        }else {
            log.info("user found");
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        UserMembership membership = userMembershipRepository.findByUserId(user.get().getId());
        String role = roleService.findById(membership.getRole().getId()).getName();

        authorities.add(new SimpleGrantedAuthority(role));
        return new User(user.get().getUsername(),user.get().getPassword(),authorities);
    }

}