package com.nnk.springboot.ti;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(properties = {"spring.profiles.active=test"})
public class PasswordEncodeTest {

    @MockBean
    private ClientRegistrationRepository clientRegistrationRepository;

    @Test
    public void testPassword() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pw = encoder.encode("123456");
        System.out.println("[ "+ pw + " ]");
    }
}