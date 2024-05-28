package com.nnk.springboot.config;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom implementation of the UserDetailsService for integration with the poseidon application's user account system.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    // Lazy instanciation to avoid circular reference with UserService
    public CustomUserDetailsService(@Lazy UserService userService) {
        this.userService = userService;
    }

    /**
     * Loads the user details required by Spring Security for authentication and authorization, based on the username provided.
     *
     * @param username the email address of the user trying to authenticate.
     * @return a UserDetails object containing necessary information for authentication and authorization.
     * @throws UsernameNotFoundException if no UserAccount is found with the provided email.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No user found with this username: " + username));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                getGrantedAuthorities(user.getRole()));
    }

    /**
     * Helper method to convert the user role into a Spring Security GrantedAuthority.
     * Prepends "ROLE_" to the role name to fit Spring Security conventions.
     *
     * @param role the role name of the user.
     * @return a list of GrantedAuthority based on the provided role.
     */
    private List<GrantedAuthority> getGrantedAuthorities(String role) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        return authorities;
    }
}