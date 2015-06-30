package com.mkyong.common.service;

import java.util.Collections;

import javax.annotation.PostConstruct;

import com.mkyong.common.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.*;

public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    protected void initialize() {
        userRepository.save(new com.mkyong.common.entity.User("vetrovs@ua.fm", "123", "ROLE_USER"));
        userRepository.save(new com.mkyong.common.entity.User("ilshyma", "123", "ROLE_USER"));
        userRepository.save(new com.mkyong.common.entity.User("admin", "admin", "ROLE_ADMIN"));

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.mkyong.common.entity.User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }
        return createUser(user);
    }

    public void signin(com.mkyong.common.entity.User user) {
        SecurityContextHolder.getContext().setAuthentication(authenticate(user));
    }

    private Authentication authenticate(com.mkyong.common.entity.User user) {
        return new UsernamePasswordAuthenticationToken(createUser(user), null, Collections.singleton(createAuthority(user)));
    }

    private User createUser(com.mkyong.common.entity.User user) {
        return new User(user.getEmail(), user.getPassword(), Collections.singleton(createAuthority(user)));
    }

    private GrantedAuthority createAuthority(com.mkyong.common.entity.User user) {
        return new SimpleGrantedAuthority(user.getRole());
    }

}
