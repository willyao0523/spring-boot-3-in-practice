package com.github.willyao0523.springboot3inpractice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

//    @Bean
//    CommandLineRunner initUsers(UserManagementRepository repository) {
//        return args -> {
//            repository.save(new UserAccount("alice", "password", "ROLE_USER"));
//            repository.save(new UserAccount("bob", "password", "ROLE_USER"));
//            repository.save(new UserAccount("admin", "password", "ROLE_ADMIN"));
//        };
//    }
//
//    @Bean
//    UserDetailsService userService(UserRepository repo) {
//        return username -> repo.findByUsername(username).asUser();
//    }
//
//    @Bean
//    SecurityFilterChain configureSecurity(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests() //
//                .requestMatchers("/login").permitAll() //
//                .requestMatchers("/", "/search").authenticated() //
//                .requestMatchers(HttpMethod.GET, "/api/**").authenticated() //
//                .requestMatchers("/admin").hasRole("ADMIN") //
//                .requestMatchers(HttpMethod.POST, "/delete/**", "/new-video").authenticated() //
//                .anyRequest().denyAll() //
//                .and() //
//                .formLogin() //
//                .and() //
//                .httpBasic();
//        return http.build();
//    }

    @Bean
    public OAuth2AuthorizedClientManager clientManager( //
                                                        ClientRegistrationRepository clientRegRepo, //
                                                        OAuth2AuthorizedClientRepository authClientRepo) {

        OAuth2AuthorizedClientProvider clientProvider = //
                OAuth2AuthorizedClientProviderBuilder.builder() //
                        .authorizationCode() //
                        .refreshToken() //
                        .clientCredentials() //
                        .password() //
                        .build();

        DefaultOAuth2AuthorizedClientManager clientManager = //
                new DefaultOAuth2AuthorizedClientManager( //
                        clientRegRepo, //
                        authClientRepo);
        clientManager //
                .setAuthorizedClientProvider(clientProvider);

        return clientManager;
    }
}