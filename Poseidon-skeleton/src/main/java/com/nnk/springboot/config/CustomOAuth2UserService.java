package com.nnk.springboot.config;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.service.impl.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * The CustomOAuth2UserService class provides authentication logic related to GitHub (OAuth2).
 */
@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private static final Logger logger = LoggerFactory.getLogger(CustomOAuth2UserService.class);

    private final UserService userService;

    @Autowired
    public CustomOAuth2UserService(@Lazy UserService userService) {
        this.userService = userService;
    }

    /**
     * Loads the user's account from the OAuth2 request}.
     *
     * @param userRequest The user request
     * @return OAuth2User A user object
     * @throws OAuth2AuthenticationException
     */
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        logger.info("==>Loading user {}", userRequest.getClientRegistration().getRegistrationId());
        OAuth2User oAuth2User = super.loadUser(userRequest);

        logger.info("OAuth2 User Attributes: {}", oAuth2User.getAttributes());
        String username = oAuth2User.getAttribute("login");
        if (username == null) {
            throw new OAuth2AuthenticationException("Missing attribute 'login' in attributes");
        }

        User user = userService.findByUsername(username).orElse(null);
        if(user!=null){
            logger.info("User {} already exists", username);
        }else{
            String fullname = username;
            String password = "password";
            user = new User(username, password, fullname, "USER");
            userService.addUser(user);
            logger.info("New user registered with OAuth2 GitHub");
        }
        Map<String, Object> listOfAttributes = new HashMap<>(oAuth2User.getAttributes());
        listOfAttributes.put("username", user.getUsername());
        listOfAttributes.put("fullname", user.getFullname());
        listOfAttributes.put("role", user.getRole());

        return new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")), listOfAttributes, "username");
    }

}